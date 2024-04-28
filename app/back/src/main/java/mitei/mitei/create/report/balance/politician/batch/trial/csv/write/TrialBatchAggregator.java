package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * csv書き出し方法実装ファイル
 */
public class TrialBatchAggregator implements LineAggregator<TrialBatch> {

    /**
     * Dtoをcsvデータ文字列に変換する
     */
    @Override
    public String aggregate(final TrialBatch item) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"").append(item.getId()).append("\""); // NOPMD
        stringBuilder.append(","); // NOPMD
        stringBuilder.append("\"").append(item.getContent()).append("\""); // NOPMD
        stringBuilder.append(","); // NOPMD
        stringBuilder.append("\"").append(item.getUpdateTime()).append("\""); // NOPMD
        return stringBuilder.toString();
    }
}
