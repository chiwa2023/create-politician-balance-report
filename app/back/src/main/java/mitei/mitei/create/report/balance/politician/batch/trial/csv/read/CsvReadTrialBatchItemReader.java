package mitei.mitei.create.report.balance.politician.batch.trial.csv.read;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.batch.trial.csv.write.TrialBatch;

/**
 * csvからデータベース書込みをするｃｓｖ読み込みItemReader
 */
@Component
public class CsvReadTrialBatchItemReader extends FlatFileItemReader<TrialBatch> {

}
