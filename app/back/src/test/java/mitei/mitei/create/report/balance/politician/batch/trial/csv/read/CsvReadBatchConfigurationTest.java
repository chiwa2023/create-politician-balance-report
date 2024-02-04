package mitei.mitei.create.report.balance.politician.batch.trial.csv.read;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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
 * CsvReadBatchConfiguration単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = { BackApplication.class, // 全体起動
        CsvReadBatchConfiguration.class // この機能統合Config(util使用)
})
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvReadBatchConfigurationTest {

    /** テスト対象 */
    @Autowired
    private CsvReadBatchConfiguration csvReadBatchConfiguration;

    @Test
    void testCsvReadTrialBatchItemReader() {
        assertEquals(CsvReadTrialBatchItemReader.class.getName(),
                csvReadBatchConfiguration.csvReadTrialBatchItemReader().getClass().getName(), "指定したItemReader");
    }

    @Test
    void testCsvReadTrialBatchItemWriter() {
        assertEquals(CsvReadTrialBatchItemWriter.class.getName(),
                csvReadBatchConfiguration.csvReadTrialBatchItemWriter().getClass().getName(), "指定したItemWriter");
    }

    @Test
    void testJobCsvWrite() {
        Job job = csvReadBatchConfiguration.jobCsvWrite(null, null);
        assertEquals(CsvReadBatchConfiguration.JOB_NAME, job.getName(), "指定したJob名");
    }

    @Test
    void testStepCsvRead() {
        Step step = csvReadBatchConfiguration.stepCsvRead(null, null, null, null);
        assertEquals(CsvReadBatchConfiguration.STEP_NAME, step.getName(), "指定したStep名");
    }

}
