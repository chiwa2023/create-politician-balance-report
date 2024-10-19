package mitei.mitei.create.report.balance.politician.batch.year_reflesh.tasklet;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
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

/**
 * RefleshYearDataAccessFactoryMethodLogicTasklet実装時処理追加用
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = BackApplication.class) // 全体起動
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RefleshYearDataAccessFactoryMethodLogicTaskletTest2 {

    /** テスト対象 */
    @Autowired
    private RefleshYearDataAccessFactoryMethodLogicTasklet refleshYearDataAccessFactoryMethodLogicTasklet;

    @Test
    void testExecute() throws Exception { // NOPMD JUnitTestsShouldIncludeAssert

        // 処理実行
        StepExecution execution = this.getStepExecution();
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution);
        refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution), null);

    }

    private StepExecution getStepExecution() {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString("copyYear", "2022")
                .addString("isReadFileReflesh", String.valueOf(true)) // 解析ファイルを更新設定
                .addString("file01",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic.java")
                .addString("file02",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/SaveSnsDirectMessageSendingResultFactoryLogic.java")
                .addString("file03",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/mail/CallMailSendingInfoFactoryLogic.java")
                .addString("file04",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/mail/SaveMailSendingResultFactoryLogic.java")
                .addLocalDateTime("now", LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // 起動引数付きのStepExecutionを作成
        return MetaDataInstanceFactory.createStepExecution(jobParameters);
    }

}
