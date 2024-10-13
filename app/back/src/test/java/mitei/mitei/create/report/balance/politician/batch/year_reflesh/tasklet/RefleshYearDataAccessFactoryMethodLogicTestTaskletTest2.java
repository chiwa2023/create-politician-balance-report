package mitei.mitei.create.report.balance.politician.batch.year_reflesh.tasklet;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * RefleshYearDataAccessFactoryMethodLogicTestTasklet単体テスト
 * 実装に追加する用の動作環境
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RefleshYearDataAccessFactoryMethodLogicTestTaskletTest2 {

    /** テスト対象 */
    @Autowired
    private RefleshYearDataAccessFactoryMethodLogicTestTasklet refleshYearDataAccessFactoryMethodLogicTestTasklet;

    @Test
    void testExecute() throws Exception { // NOPMD

        // 処理実行
        StepExecution execution = this.getStepExecution();
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution), null);

    }

    private StepExecution getStepExecution() {

        // TODO 必要なTestLogicとSQLを追加する(元ファイルにコメントと2022年分のテストケース追加が必要)

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString("copyYear", "2025")
                .addString("isReadFileReflesh", String.valueOf(false)) // 解析ファイルを更新設定
                .addString("java01",
                        "test/java/mitei/mitei/create/report/balance/politician/task_alert/mail/SaveMailSendingResultFactoryLogicTest.java")
                .addString("sql01",
                        "test/resources/mitei/mitei/create/report/balance/politician/task_alert/mail/truncate_all_mail_table.sql")
                .addLocalDateTime("now", LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // 起動引数付きのStepExecutionを作成
        return MetaDataInstanceFactory.createStepExecution(jobParameters);
    }

}
