package mitei.mitei.create.report.balance.politician.observation;

import org.springframework.stereotype.Component;

/**
 * 改竄を疑われる事象があったら調査側に通知するために専用テーブルobservationに記録する
 */
@Component
public class WriteObservationTableUtil {

    /**
     * observationに書込みする
     *
     * @return 記録行数
     */
    public int practice() {
        int affectedRow = 0 ; // NOPMD
        //TODO Daoを使用して書込み
        

        return affectedRow;
    }
}
