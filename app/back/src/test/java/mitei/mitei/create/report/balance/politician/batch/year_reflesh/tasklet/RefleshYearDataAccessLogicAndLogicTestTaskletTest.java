package mitei.mitei.create.report.balance.politician.batch.year_reflesh.tasklet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
 * RefleshYearDataAccessLogicAndLogicTestTasklet単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = BackApplication.class) // 全体起動
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RefleshYearDataAccessLogicAndLogicTestTaskletTest {

    /** テスト対象 */
    @Autowired
    private RefleshYearDataAccessLogicAndLogicTestTasklet refleshYearDataAccessLogicAndLogicTestTasklet;

    /** 複写元報告年 */
    private static final int baseYear = 2022;
    /** 複写先報告年 */
    private static final int copyYear = 2025;

    /** SNSフォルダ(Logic) */
    private static final String pathFunctionSns = "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/y";
    /** Mailフォルダ(Logic) */
    private static final String pathFunctionMail = "main/java/mitei/mitei/create/report/balance/politician/task_alert/mail/y";

    /** SNSフォルダ(LogicTest) */
    private static final String pathFunctionSnsTest = "test/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/y";
    /** Mailフォルダ(LogicTest) */
    private static final String pathFunctionMailTest = "test/java/mitei/mitei/create/report/balance/politician/task_alert/mail/y";
    /** SNSフォルダ(LogicTestSQL) */
    private static final String pathFunctionSnsTestSql = "test/resources/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/y";
    /** Mailフォルダ(LogicTestSQL) */
    private static final String pathFunctionMailTestSql = "test/resources/mitei/mitei/create/report/balance/politician/task_alert/mail/y";

    @Test
    void testExecute() throws Exception { // NOPMD

        StepExecution execution = this.getStepExecution();
        refleshYearDataAccessLogicAndLogicTestTasklet.beforeStep(execution);

        // 最後まで到達すればとりあえずOK(内容は各個別のTestを走らせるので)
        assertThat(refleshYearDataAccessLogicAndLogicTestTasklet.execute(new StepContribution(execution), null))
                .isEqualTo(RepeatStatus.FINISHED);

        final String expandTextLogic = "Logic.java";
        final String expandTextLogicTest = "LogicTest.java";
        final String expandTextSql = ".sql";
        final String fileExistText = "ファイルが存在する";
        final String updateText = "更新時間が1分前より後";

        /* ファイル存在確認 */

        // Logic
        String pathBaseAbsSns = GetCurrentResourcePath.getBackSrcPath(pathFunctionSns);
        String pathBaseAbsSnsTest = GetCurrentResourcePath.getBackSrcPath(pathFunctionSnsTest);

        final String fileNameSnsCall = "CallSnsDirectMessageSendingInfo";

        Path pathBaseSnsCall = Paths.get(pathBaseAbsSns + baseYear, fileNameSnsCall + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseSnsCall), fileExistText);

        Path pathBaseSnsTestCall = Paths.get(pathBaseAbsSnsTest + baseYear,
                fileNameSnsCall + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseSnsTestCall), fileExistText);

        final String fileNameSnsSave = "SaveSnsDirectMessageSendingResult";

        Path pathBaseSnsSave = Paths.get(pathBaseAbsSns + baseYear, fileNameSnsSave + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseSnsSave), fileExistText);

        Path pathBaseSnsTestSave = Paths.get(pathBaseAbsSnsTest + baseYear,
                fileNameSnsSave + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseSnsTestSave), fileExistText);

        String pathBaseAbsSnsTestSql = GetCurrentResourcePath.getBackSrcPath(pathFunctionSnsTestSql);

        final String fileNameSnsSaveSql = "save_alert_sns_message_";
        Path pathBaseSnsTestSaveSql = Paths.get(pathBaseAbsSnsTestSql + baseYear,
                fileNameSnsSaveSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseSnsTestSaveSql), fileExistText);

        final String fileNameSnsCallSql = "send_alert_sns_message_";
        Path pathBaseSnsTestCallSql = Paths.get(pathBaseAbsSnsTestSql + baseYear,
                fileNameSnsCallSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseSnsTestCallSql), fileExistText);

        // TODO InsertLogicが追加される(多分)

        // Logic Test
        String pathBaseAbsMail = GetCurrentResourcePath.getBackSrcPath(pathFunctionMail);
        String pathBaseAbsMailTest = GetCurrentResourcePath.getBackSrcPath(pathFunctionMailTest);

        final String fileNameMailCall = "CallMailSendingInfo";

        Path pathBaseMailCall = Paths.get(pathBaseAbsMail + baseYear, fileNameMailCall + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseMailCall), fileExistText);

        Path pathBaseMailTestCall = Paths.get(pathBaseAbsMailTest + baseYear,
                fileNameMailCall + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseMailTestCall), fileExistText);

        final String fileNameMailSave = "SaveMailSendingResult";

        Path pathBaseMailSave = Paths.get(pathBaseAbsMail + baseYear, fileNameMailSave + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseMailSave), fileExistText);

        Path pathBaseMailTestSave = Paths.get(pathBaseAbsMailTest + baseYear,
                fileNameMailSave + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseMailTestSave), fileExistText);

        String pathBaseAbsMailTestSql = GetCurrentResourcePath.getBackSrcPath(pathFunctionMailTestSql);

        final String fileNameMailCallSql = "send_alert_mail_";
        Path pathBaseMailTestCallSql = Paths.get(pathBaseAbsMailTestSql + baseYear,
                fileNameMailCallSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseMailTestCallSql), fileExistText);

        // TODO InsertLogicが追加される(多分)

        // FileTimeがUTCで返るのでそれに合わせる
        Instant kijunTime = LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC);
        kijunTime = kijunTime.minusSeconds(60); // SUPPRESS CHECKSTYLE MagicNumber

        /* 生成確認 */

        Path pathCopySnsCall = Paths.get(pathBaseAbsSns + copyYear, fileNameSnsCall + copyYear + expandTextLogic);

        assertTrue(Files.exists(pathCopySnsCall), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsCall).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsSave = Paths.get(pathBaseAbsSns + copyYear, fileNameSnsSave + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopySnsSave), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsSave).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsSaveTest = Paths.get(pathBaseAbsSnsTest + copyYear,
                fileNameSnsSave + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopySnsSaveTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsSaveTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsCallTest = Paths.get(pathBaseAbsSnsTest + copyYear,
                fileNameSnsCall + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopySnsCallTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsCallTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsSaveTestSql = Paths.get(pathBaseAbsSnsTestSql + copyYear,
                fileNameSnsSaveSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopySnsSaveTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsSaveTestSql).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsCallTestSql = Paths.get(pathBaseAbsSnsTestSql + copyYear,
                fileNameSnsCallSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopySnsCallTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsCallTestSql).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailCall = Paths.get(pathBaseAbsMail + copyYear, fileNameMailCall + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopyMailCall), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailCall).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailSave = Paths.get(pathBaseAbsMail + copyYear, fileNameMailSave + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopyMailSave), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailSave).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailSaveTest = Paths.get(pathBaseAbsMailTest + copyYear,
                fileNameMailSave + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopyMailSaveTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailSaveTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailCallTest = Paths.get(pathBaseAbsMailTest + copyYear,
                fileNameMailCall + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopyMailCallTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailCallTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailCallTestSql = Paths.get(pathBaseAbsMailTestSql + copyYear,
                fileNameMailCallSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopyMailCallTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailCallTestSql).toInstant().isAfter(kijunTime), updateText);

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
