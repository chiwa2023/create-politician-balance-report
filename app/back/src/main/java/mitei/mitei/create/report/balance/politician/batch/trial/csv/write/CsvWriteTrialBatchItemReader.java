package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * データベースからCsv書込みをするデータベース読み込みItemReader
 */
public class CsvWriteTrialBatchItemReader extends JpaCursorItemReader<TrialBatch> {

    /** リポジトリ */
    @Autowired
    private TrialBatchRepository batchRepository;

    /** 結果リスト */
    private List<TrialBatch> list;

    /** カウンタ */
    private int counter;

    /**
     * オープン動作をする(必要データを取得)
     */
    @Override
    protected void doOpen() {
        list = batchRepository.findAll();
    }

    /**
     * 読み取り動作をする(要求されたデータ1件を返却)
     */
    @Override
    protected TrialBatch doRead() {
        TrialBatch trialBatch;
        if (counter < list.size()) {
            trialBatch = list.get(counter);
        } else {
            trialBatch = null; // NOPMD
        }

        counter++;
        return trialBatch;
    }

    /**
     * クローズ動作をする(リストを初期化する)
     */
    @Override
    protected void doClose() {
        list = new ArrayList<>();
        counter = 0;
    }

}
