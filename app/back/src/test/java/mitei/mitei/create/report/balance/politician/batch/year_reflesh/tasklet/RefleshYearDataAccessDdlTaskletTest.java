package mitei.mitei.create.report.balance.politician.batch.year_reflesh.tasklet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.BackApplication;
import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * RefleshYearDataAccessDdlTasklet単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = BackApplication.class) // 全体起動
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RefleshYearDataAccessDdlTaskletTest {

    /** テスト対象 */
    @Autowired
    private RefleshYearDataAccessDdlTasklet refleshYearDataAccessDdlTasklet;

    /** 複写元報告年 */
    private static final int baseYear = 2024;
    /** 複写先報告年 */
    private static final int copyYear = 2025;

    /** 複写先取得用相対ディレクトリ */
    private static final String copyPath = "main/resources/SQL/DDL";

    @Test
    @Tag("SourceReflesh")
    void testExecute() throws Exception {

        StepExecution execution = this.getStepExecution();
        refleshYearDataAccessDdlTasklet.beforeStep(execution);

        // 最後まで到達すればとりあえずOK(内容は各個別のTestを走らせるので)
        assertThat(refleshYearDataAccessDdlTasklet.execute(new StepContribution(execution), null))
                .isEqualTo(RepeatStatus.FINISHED);

        /* ファイルの存在だけ確認 */
        String pathAbs = GetCurrentResourcePath.getBackSrcPath(copyPath);

        final String expandText = ".sql";
        final String fileExistText = "ファイルが存在する";
        final String updateText = "更新時間が1分前より後";

        final String sqlSns = "send_alert_sns_message_";
        final String sqlMail = "send_alert_mail_";
        final String sqlTask = "task_plan_";

        Path pathBaseSns = Paths.get(pathAbs, sqlSns + baseYear + expandText);
        assertTrue(Files.exists(pathBaseSns), fileExistText);

        Path pathBaseMail = Paths.get(pathAbs, sqlMail + baseYear + expandText);
        assertTrue(Files.exists(pathBaseMail), fileExistText);

        Path pathBaseTask = Paths.get(pathAbs, sqlTask + baseYear + expandText);
        assertTrue(Files.exists(pathBaseTask), fileExistText);

        // FileTimeがUTCで返るのでそれに合わせる
        Instant kijunTime = LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC);
        kijunTime = kijunTime.minusSeconds(60); // SUPPRESS CHECKSTYLE MagicNumber

        Path pathCopySns = Paths.get(pathAbs, sqlSns + copyYear + expandText);
        assertTrue(Files.exists(pathCopySns), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySns).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMail = Paths.get(pathAbs, sqlMail + copyYear + expandText);
        assertTrue(Files.exists(pathCopyMail), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMail).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyTask = Paths.get(pathAbs, sqlTask + copyYear + expandText);
        assertTrue(Files.exists(pathCopyTask), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTask).toInstant().isAfter(kijunTime), updateText);
    }

    private StepExecution getStepExecution() {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString("baseYear", String.valueOf(baseYear))
                .addString("copyYear", String.valueOf(copyYear)).addLocalDateTime("now", LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // 起動引数付きのStepExecutionを作成
        return MetaDataInstanceFactory.createStepExecution(jobParameters);
    }

}
