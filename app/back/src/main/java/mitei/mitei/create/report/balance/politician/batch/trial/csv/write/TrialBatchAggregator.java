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
        System.out.println("convert data!!!");
        StringBuilder sb = new StringBuilder();
        sb.append("\"" + item.getId() + "\"");
        sb.append(",");
        sb.append("\"" + item.getContent() + "\"");
        sb.append(",");
        sb.append("\"" + item.getUpdateTime() + "\"");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
