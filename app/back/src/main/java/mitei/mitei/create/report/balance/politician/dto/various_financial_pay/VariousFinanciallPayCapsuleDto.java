package mitei.mitei.create.report.balance.politician.dto.various_financial_pay;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.AbstractCapsuleDto;

/**
 * 各種Payのfront側とBack側の通信用のDto
 */
public class VariousFinanciallPayCapsuleDto extends AbstractCapsuleDto // NOPMD DataClass
        implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 検索語 */
    private String searchWords;

    /**
     * 検索語を取得する
     *
     * @return 検索語
     */
    public String getSearchWords() {
        return searchWords;
    }

    /**
     * 検索語を設定する
     *
     * @param searchWords 検索語
     */
    public void setSearchWords(final String searchWords) {
        this.searchWords = searchWords;
    }

}
