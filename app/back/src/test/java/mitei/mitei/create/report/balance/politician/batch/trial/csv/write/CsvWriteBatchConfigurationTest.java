package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

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
 * CsvWriteBatchConfiguration単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = { BackApplication.class, // 全体起動
        CsvWriteBatchConfiguration.class // この機能統合Config(util使用)
})
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvWriteBatchConfigurationTest {

    
    /** テスト対象 */
    @Autowired
   private CsvWriteBatchConfiguration csvWriteBatchConfiguration;
    
    @Test
    void testCsvWriteTrialBatchItemReader() {
        assertEquals(CsvWriteTrialBatchItemReader.class.getName(),
                csvWriteBatchConfiguration.csvWriteTrialBatchItemReader().getClass().getName(), "指定したItemReader");
    }

    @Test
    void testCsvWriteTrialBatchItemWriter() {
        assertEquals(CsvWriteTrialBatchItemWriter.class.getName(),
                csvWriteBatchConfiguration.csvWriteTrialBatchItemWriter().getClass().getName(), "指定したItemWriter");
    }

    @Test
    void testJobCsvWrite() {
        Job job = csvWriteBatchConfiguration.jobCsvWrite(null, null);
        assertEquals(CsvWriteBatchConfiguration.JOB_NAME, job.getName(), "指定したJob名");
    }

    @Test
    void testStepCsvWrite() {
        Step step = csvWriteBatchConfiguration.stepCsvWrite(null, null, null, null);
        assertEquals(CsvWriteBatchConfiguration.STEP_NAME, step.getName(), "指定したStep名");
    }

}
