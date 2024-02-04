package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
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
 * CsvWriteTrialBatchItemReader単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = { BackApplication.class, // 全体起動
        CsvWriteBatchConfiguration.class // この機能統合Config(util使用)
})
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvWriteTrialBatchItemReaderTest {

    /** 生成フォルダをログから抽出するItemReader(テスト対象) */
    @Autowired
    private CsvWriteTrialBatchItemReader csvWriteTrialBatchItemReader;

    @Test
    void test()throws Exception {
        
        csvWriteTrialBatchItemReader.open(new ExecutionContext());
        
        TrialBatch trialBatch;
        while(null != (trialBatch = csvWriteTrialBatchItemReader.read())) {
            System.out.println(trialBatch.getId()+"----"+trialBatch.getId()+"------"+trialBatch.getUpdateTime());
        }
        
        fail("Not yet implemented");
    }

}
