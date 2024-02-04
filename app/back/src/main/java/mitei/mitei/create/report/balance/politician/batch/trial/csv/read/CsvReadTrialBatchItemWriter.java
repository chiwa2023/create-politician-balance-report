package mitei.mitei.create.report.balance.politician.batch.trial.csv.read;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.batch.trial.csv.write.TrialBatch;
import mitei.mitei.create.report.balance.politician.batch.trial.csv.write.TrialBatchRepository;

/**
 * csvからデータべ須書込みをするデータベース書込みItemWriter
 */
@Component
public class CsvReadTrialBatchItemWriter extends JpaItemWriter<TrialBatch> {

    /** リポジトリ */
    @Autowired
    private TrialBatchRepository batchRepository;

    /**
     * データ書き込み動作
     */
    @Override
    public void write(final Chunk<? extends TrialBatch> items) {
        batchRepository.saveAll(items);
    }

}
