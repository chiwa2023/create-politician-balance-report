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
 * RefleshYearDataAccessRepositoryAndEntityTasklet単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = BackApplication.class) // 全体起動
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RefleshYearDataAccessRepositoryAndEntityTaskletTest {

    /** テスト対象 */
    @Autowired
    private RefleshYearDataAccessRepositoryAndEntityTasklet refleshYearDataAccessRepositoryAndEntityTasklet;

    /** 複写元報告年 */
    private static final int baseYear = 2024;
    /** 複写先報告年 */
    private static final int copyYear = 2025;

    /** 通知SNSフォルダ(Repository) */
    private static final String pathFunctionSnsRepository = "main/java/mitei/mitei/create/report/balance/politician/repository/sns/";
    /** 通知メールフォルダ(Repository) */
    private static final String pathFunctionMailRepository = "main/java/mitei/mitei/create/report/balance/politician/repository/mail/";
    /** タスク計画フォルダ(Repository) */
    private static final String pathFunctionTaskRepository = "main/java/mitei/mitei/create/report/balance/politician/repository/task_plan/";

    /** 通知SNSフォルダ(Entity) */
    private static final String pathFunctionSnsEntity = "main/java/mitei/mitei/create/report/balance/politician/entity/sns/";
    /** 通知メールフォルダ(Entity) */
    private static final String pathFunctionMailEntity = "main/java/mitei/mitei/create/report/balance/politician/entity/mail/";
    /** タスク計画フォルダ(Entity) */
    private static final String pathFunctionTaskEntity = "main/java/mitei/mitei/create/report/balance/politician/entity/task_plan/";

    @Test
    @Tag("SourceReflesh")
    void testExecute() throws Exception {

        StepExecution execution = this.getStepExecution();
        refleshYearDataAccessRepositoryAndEntityTasklet.beforeStep(execution);

        // 最後まで到達すればとりあえずOK(内容は各個別のTestを走らせるので)
        assertThat(refleshYearDataAccessRepositoryAndEntityTasklet.execute(new StepContribution(execution), null))
                .isEqualTo(RepeatStatus.FINISHED);

        /* ファイルの存在だけ確認 */

        final String expandTextRepository = "Repository.java";
        final String fileExistText = "ファイルが存在する";
        final String updateText = "更新時間が1分前より後";

        final String fileNameSns = "SendAlertSnsMessage";
        final String fileNameMail = "SendAlertMail";
        final String fileNameTask = "TaskPlan";

        String pathBaseAbsSnsRepository = GetCurrentResourcePath.getBackSrcPath(pathFunctionSnsRepository);
        Path pathBaseSnsRepository = Paths.get(pathBaseAbsSnsRepository, fileNameSns + baseYear + expandTextRepository);
        assertTrue(Files.exists(pathBaseSnsRepository), fileExistText);

        String pathBaseAbsMailRepository = GetCurrentResourcePath.getBackSrcPath(pathFunctionMailRepository);
        Path pathBaseMailRepository = Paths.get(pathBaseAbsMailRepository,
                fileNameMail + baseYear + expandTextRepository);
        assertTrue(Files.exists(pathBaseMailRepository), fileExistText);

        String pathBaseAbsTaskRepository = GetCurrentResourcePath.getBackSrcPath(pathFunctionTaskRepository);
        Path pathBaseTaskRepository = Paths.get(pathBaseAbsTaskRepository,
                fileNameTask + baseYear + expandTextRepository);
        assertTrue(Files.exists(pathBaseTaskRepository), fileExistText);

        final String expandTextEntity = "Entity.java";

        String pathBaseAbsSnsEntity = GetCurrentResourcePath.getBackSrcPath(pathFunctionSnsEntity);
        Path pathBaseSnsEntity = Paths.get(pathBaseAbsSnsEntity, fileNameSns + baseYear + expandTextEntity);
        assertTrue(Files.exists(pathBaseSnsEntity), fileExistText);

        String pathBaseAbsMailEntity = GetCurrentResourcePath.getBackSrcPath(pathFunctionMailEntity);
        Path pathBaseMailEntity = Paths.get(pathBaseAbsMailEntity, fileNameMail + baseYear + expandTextEntity);
        assertTrue(Files.exists(pathBaseMailEntity), fileExistText);

        String pathBaseAbsTaskEntity = GetCurrentResourcePath.getBackSrcPath(pathFunctionTaskEntity);
        Path pathBaseTaskEntity = Paths.get(pathBaseAbsTaskEntity, fileNameTask + baseYear + expandTextEntity);
        assertTrue(Files.exists(pathBaseTaskEntity), fileExistText);

        // FileTimeがUTCで返るのでそれに合わせる
        Instant kijunTime = LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC);
        kijunTime = kijunTime.minusSeconds(60); // SUPPRESS CHECKSTYLE MagicNumber

        /* 生成確認 */

        String pathCopyAbsSns = GetCurrentResourcePath.getBackSrcPath(pathFunctionSnsRepository);
        Path pathCopySns = Paths.get(pathCopyAbsSns, fileNameSns + copyYear + expandTextRepository);
        assertTrue(Files.exists(pathCopySns), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySns).toInstant().isAfter(kijunTime), updateText);

        String pathCopyAbsMail = GetCurrentResourcePath.getBackSrcPath(pathFunctionMailRepository);
        Path pathCopyMail = Paths.get(pathCopyAbsMail, fileNameMail + copyYear + expandTextRepository);
        assertTrue(Files.exists(pathCopyMail), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMail).toInstant().isAfter(kijunTime), updateText);

        String pathCopyAbsTask = GetCurrentResourcePath.getBackSrcPath(pathFunctionTaskRepository);
        Path pathCopyTask = Paths.get(pathCopyAbsTask, fileNameTask + copyYear + expandTextRepository);
        assertTrue(Files.exists(pathCopyTask), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTask).toInstant().isAfter(kijunTime), updateText);
        
        String pathCopyAbsSnsEntity = GetCurrentResourcePath.getBackSrcPath(pathFunctionSnsEntity);
        Path pathCopySnsEntity = Paths.get(pathCopyAbsSnsEntity, fileNameSns + copyYear + expandTextEntity);
        assertTrue(Files.exists(pathCopySnsEntity), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsEntity).toInstant().isAfter(kijunTime), updateText);

        String pathCopyAbsMailEntity = GetCurrentResourcePath.getBackSrcPath(pathFunctionMailEntity);
        Path pathCopyMailEntity = Paths.get(pathCopyAbsMailEntity, fileNameMail + copyYear + expandTextEntity);
        assertTrue(Files.exists(pathCopyMailEntity), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailEntity).toInstant().isAfter(kijunTime), updateText);

        String pathCopyAbsTaskEntity = GetCurrentResourcePath.getBackSrcPath(pathFunctionTaskEntity);
        Path pathCopyTaskEntity = Paths.get(pathCopyAbsTaskEntity, fileNameTask + copyYear + expandTextEntity);
        assertTrue(Files.exists(pathCopyTaskEntity), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTaskEntity).toInstant().isAfter(kijunTime), updateText);
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
