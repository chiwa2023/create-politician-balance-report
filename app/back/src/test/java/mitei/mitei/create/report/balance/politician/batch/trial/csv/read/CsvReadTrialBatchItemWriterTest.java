package mitei.mitei.create.report.balance.politician.batch.trial.csv.read;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jakarta.persistence.EntityManagerFactory;
import mitei.mitei.create.report.balance.politician.BackApplication;
import mitei.mitei.create.report.balance.politician.batch.trial.csv.write.CsvWriteBatchConfiguration;
import mitei.mitei.create.report.balance.politician.batch.trial.csv.write.TrialBatch;

/**
 * CsvReadTrialBatchItemWriter単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = { BackApplication.class, // 全体起動
        CsvWriteBatchConfiguration.class // この機能統合Config(util使用)
})
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvReadTrialBatchItemWriterTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */ 
    @Autowired
    private CsvReadTrialBatchItemWriter csvReadTrialBatchItemWriter;

    /** エンティティマネージャ */
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void test() {
        csvReadTrialBatchItemWriter.setEntityManagerFactory(entityManagerFactory);
        
        List<TrialBatch> list = new ArrayList<>();
        TrialBatch trialBatch = new TrialBatch();
        trialBatch.setId(0L);
        trialBatch.setContent("q");
        trialBatch.setUpdateTime(Timestamp.valueOf(LocalDateTime.of(2022, 12, 12, 12, 34, 56)));
        list.add(trialBatch);
        
        Chunk<TrialBatch> chunk = new Chunk<>(list);
        csvReadTrialBatchItemWriter.write(chunk);

   }

}
