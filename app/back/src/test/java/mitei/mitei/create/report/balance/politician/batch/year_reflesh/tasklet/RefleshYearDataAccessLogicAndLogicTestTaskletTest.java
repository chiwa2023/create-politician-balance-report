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
    private static final int baseYear = 2024;
    /** 複写先報告年 */
    private static final int copyYear = 2025;

    /** SNSフォルダ(Logic) */
    private static final String pathFunctionSns = "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/y";
    /** Mailフォルダ(Logic) */
    private static final String pathFunctionMail = "main/java/mitei/mitei/create/report/balance/politician/task_alert/mail/y";
    /** Taskフォルダ(Logic) */
    private static final String pathFunctionTask = "main/java/mitei/mitei/create/report/balance/politician/task_plan/logic/y";

    /** SNSフォルダ(LogicTest) */
    private static final String pathFunctionSnsTest = "test/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/y";
    /** Mailフォルダ(LogicTest) */
    private static final String pathFunctionMailTest = "test/java/mitei/mitei/create/report/balance/politician/task_alert/mail/y";
    /** Mailフォルダ(LogicTest) */
    private static final String pathFunctionTaskTest = "test/java/mitei/mitei/create/report/balance/politician/task_plan/logic/y";
    /** SNSフォルダ(LogicTestSQL) */
    private static final String pathFunctionSnsTestSql = "test/resources/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/y";
    /** Mailフォルダ(LogicTestSQL) */
    private static final String pathFunctionMailTestSql = "test/resources/mitei/mitei/create/report/balance/politician/task_alert/mail/y";
    /** Taskフォルダ(LogicTestSQL) */
    private static final String pathFunctionTaskTestSql = "test/resources/mitei/mitei/create/report/balance/politician/task_plan/logic/y";

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
        // SNS
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

        final String fileNameSnsInsert = "SaveSnsDirectMessageSendingResult";

        Path pathBaseSnsInsert = Paths.get(pathBaseAbsSns + baseYear, fileNameSnsInsert + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseSnsInsert), fileExistText);

        Path pathBaseSnsTestInsert = Paths.get(pathBaseAbsSnsTest + baseYear,
                fileNameSnsInsert + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseSnsTestInsert), fileExistText);

        String pathBaseAbsSnsTestSql = GetCurrentResourcePath.getBackSrcPath(pathFunctionSnsTestSql);

        final String fileNameSnsSaveSql = "save_alert_sns_message_";
        Path pathBaseSnsTestSaveSql = Paths.get(pathBaseAbsSnsTestSql + baseYear,
                fileNameSnsSaveSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseSnsTestSaveSql), fileExistText);

        final String fileNameSnsCallSql = "send_alert_sns_message_";
        Path pathBaseSnsTestCallSql = Paths.get(pathBaseAbsSnsTestSql + baseYear,
                fileNameSnsCallSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseSnsTestCallSql), fileExistText);

        final String fileNameSnsInsertSql = "truncate_alert_sns_message_";
        Path pathBaseSnsTestInsertSql = Paths.get(pathBaseAbsSnsTestSql + baseYear,
                fileNameSnsInsertSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseSnsTestInsertSql), fileExistText);

        // Mail
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

        final String fileNameMailInsert = "InsertMailInfo";

        Path pathBaseMailInsert = Paths.get(pathBaseAbsMail + baseYear,
                fileNameMailInsert + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseMailInsert), fileExistText);

        Path pathBaseMailTestInsert = Paths.get(pathBaseAbsMailTest + baseYear,
                fileNameMailInsert + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseMailTestInsert), fileExistText);

        String pathBaseAbsMailTestSql = GetCurrentResourcePath.getBackSrcPath(pathFunctionMailTestSql);

        final String fileNameMailCallSql = "send_alert_mail_";
        Path pathBaseMailTestCallSql = Paths.get(pathBaseAbsMailTestSql + baseYear,
                fileNameMailCallSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseMailTestCallSql), fileExistText);

        final String fileNameMailInsertSql = "truncate_alert_mail_";
        Path pathBaseMailTestInsertSql = Paths.get(pathBaseAbsMailTestSql + baseYear,
                fileNameMailInsertSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseMailTestInsertSql), fileExistText);

        // Task
        String pathBaseAbsTask = GetCurrentResourcePath.getBackSrcPath(pathFunctionTask);
        String pathBaseAbsTaskTest = GetCurrentResourcePath.getBackSrcPath(pathFunctionTaskTest);

        final String fileNameTaskInsert = "InsertTaskPlanY";

        Path pathBaseTaskInsert = Paths.get(pathBaseAbsTask + baseYear,
                fileNameTaskInsert + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseTaskInsert), fileExistText);

        Path pathBaseTaskTestInsert = Paths.get(pathBaseAbsTaskTest + baseYear,
                fileNameTaskInsert + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseTaskTestInsert), fileExistText);

        final String fileNameTaskSearch = "SearchTaskPlanByPoliticalOrgY";

        Path pathBaseTaskSearch = Paths.get(pathBaseAbsTask + baseYear,
                fileNameTaskSearch + baseYear + expandTextLogic);
        assertTrue(Files.exists(pathBaseTaskSearch), fileExistText);

        Path pathBaseTaskTestSearch = Paths.get(pathBaseAbsTaskTest + baseYear,
                fileNameTaskSearch + baseYear + expandTextLogicTest);
        assertTrue(Files.exists(pathBaseTaskTestSearch), fileExistText);

        String pathBaseAbsTaskTestSql = GetCurrentResourcePath.getBackSrcPath(pathFunctionTaskTestSql);

        final String fileNameTaskInsertSql = "truncate_task_plan_";
        Path pathBaseTaskTestInsertSql = Paths.get(pathBaseAbsTaskTestSql + baseYear,
                fileNameTaskInsertSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseTaskTestInsertSql), fileExistText);

        final String fileNameTaskSearchSql = "task_plan_";
        Path pathBaseTaskTestSearchSql = Paths.get(pathBaseAbsTaskTestSql + baseYear,
                fileNameTaskSearchSql + baseYear + expandTextSql);
        assertTrue(Files.exists(pathBaseTaskTestSearchSql), fileExistText);

        // FileTimeがUTCで返るのでそれに合わせる
        Instant kijunTime = LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC);
        kijunTime = kijunTime.minusSeconds(60); // SUPPRESS CHECKSTYLE MagicNumber

        /* 生成確認 */

        /* SNS */
        Path pathCopySnsCall = Paths.get(pathBaseAbsSns + copyYear, fileNameSnsCall + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopySnsCall), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsCall).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsSave = Paths.get(pathBaseAbsSns + copyYear, fileNameSnsSave + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopySnsSave), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsSave).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsInsert = Paths.get(pathBaseAbsSns + copyYear, fileNameSnsInsert + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopySnsInsert), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsInsert).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsSaveTest = Paths.get(pathBaseAbsSnsTest + copyYear,
                fileNameSnsSave + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopySnsSaveTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsSaveTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsCallTest = Paths.get(pathBaseAbsSnsTest + copyYear,
                fileNameSnsCall + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopySnsCallTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsCallTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsInsertTest = Paths.get(pathBaseAbsSnsTest + copyYear,
                fileNameSnsInsert + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopySnsInsertTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsInsertTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsSaveTestSql = Paths.get(pathBaseAbsSnsTestSql + copyYear,
                fileNameSnsSaveSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopySnsSaveTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsSaveTestSql).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsCallTestSql = Paths.get(pathBaseAbsSnsTestSql + copyYear,
                fileNameSnsCallSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopySnsCallTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsCallTestSql).toInstant().isAfter(kijunTime), updateText);

        Path pathCopySnsInsertTestSql = Paths.get(pathBaseAbsSnsTestSql + copyYear,
                fileNameSnsInsertSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopySnsInsertTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopySnsInsertTestSql).toInstant().isAfter(kijunTime), updateText);

        /* Mail */

        Path pathCopyMailCall = Paths.get(pathBaseAbsMail + copyYear, fileNameMailCall + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopyMailCall), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailCall).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailSave = Paths.get(pathBaseAbsMail + copyYear, fileNameMailSave + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopyMailSave), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailSave).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailInsert = Paths.get(pathBaseAbsMail + copyYear,
                fileNameMailInsert + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopyMailInsert), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailInsert).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailSaveTest = Paths.get(pathBaseAbsMailTest + copyYear,
                fileNameMailSave + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopyMailSaveTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailSaveTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailCallTest = Paths.get(pathBaseAbsMailTest + copyYear,
                fileNameMailCall + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopyMailCallTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailCallTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailInsertTest = Paths.get(pathBaseAbsMailTest + copyYear,
                fileNameMailInsert + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopyMailInsertTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailInsertTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailCallTestSql = Paths.get(pathBaseAbsMailTestSql + copyYear,
                fileNameMailCallSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopyMailCallTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailCallTestSql).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyMailInsertTestSql = Paths.get(pathBaseAbsMailTestSql + copyYear,
                fileNameMailInsertSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopyMailInsertTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyMailInsertTestSql).toInstant().isAfter(kijunTime), updateText);

        /* Task */

        Path pathCopyTaskSearch = Paths.get(pathBaseAbsTask + copyYear,
                fileNameTaskSearch + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopyTaskSearch), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTaskSearch).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyTaskInsert = Paths.get(pathBaseAbsTask + copyYear,
                fileNameTaskInsert + copyYear + expandTextLogic);
        assertTrue(Files.exists(pathCopyTaskInsert), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTaskInsert).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyTaskSearchTest = Paths.get(pathBaseAbsTaskTest + copyYear,
                fileNameTaskInsert + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopyTaskSearchTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTaskSearchTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyTaskInsertTest = Paths.get(pathBaseAbsTaskTest + copyYear,
                fileNameTaskInsert + copyYear + expandTextLogicTest);
        assertTrue(Files.exists(pathCopyTaskInsertTest), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTaskInsertTest).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyTaskInsertTestSql = Paths.get(pathBaseAbsTaskTestSql + copyYear,
                fileNameTaskInsertSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopyTaskInsertTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTaskInsertTestSql).toInstant().isAfter(kijunTime), updateText);

        Path pathCopyTaskSearchTestSql = Paths.get(pathBaseAbsTaskTestSql + copyYear,
                fileNameTaskSearchSql + copyYear + expandTextSql);
        assertTrue(Files.exists(pathCopyTaskSearchTestSql), fileExistText);
        assertTrue(Files.getLastModifiedTime(pathCopyTaskSearchTestSql).toInstant().isAfter(kijunTime), updateText);

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
