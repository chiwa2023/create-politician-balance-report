package mitei.mitei.create.report.balance.politician.batch.trial.csv.read;


import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.BackApplication;
import mitei.mitei.create.report.balance.politician.batch.trial.csv.write.TrialBatch;
import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * CsvReadTrialBatchItemReader単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = { BackApplication.class, // 全体起動
        CsvReadBatchConfiguration.class // この機能統合Config(util使用)
})
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvReadTrialBatchItemReaderTest {

    /** テスト対象 */
    @Autowired
    private CsvReadTrialBatchItemReader csvReadTrialBatchItemReader;
    
    @Test
    void test()throws Exception {
        csvReadTrialBatchItemReader.setLineMapper(new TrialBatchLineMapper());
        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "batch/trial_batch_data.csv");
        csvReadTrialBatchItemReader.setResource(new FileSystemResource(path.toFile()));
        
        csvReadTrialBatchItemReader.open(new ExecutionContext());
        
        TrialBatch trialBatch;
        while(null != (trialBatch = csvReadTrialBatchItemReader.read())) {
            System.out.println(trialBatch.getId()+"----"+trialBatch.getContent()+"------"+trialBatch.getUpdateTime());
        }
        fail("Not yet implemented");
    }

}
