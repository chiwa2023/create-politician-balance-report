package mitei.mitei.create.report.balance.politician.dto.zengin_financial_org;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.SelectOptionInterface;
import mitei.mitei.create.report.balance.politician.entity.ZenginFinancialOrgEntity;

/**
 * 全銀金融機関Dto
 */
public class ZenginFinancialOrgDto extends ZenginFinancialOrgEntity // NOPMD DataClass
        implements Serializable, SelectOptionInterface {

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /**
     * option項目のvalue(値)
     */
    private String value;

    /**
     * option項目の表示テキスト
     */
    private String text;

    /**
     * オプション項目の値を取得する
     *
     * @return オプション項目の値
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * オプション項目の値を設定する
     *
     * @param value オプション項目の値
     */
    @Override
    public void setValue(final String value) {
        this.value = value;
    }

    /**
     * オプション項目のテキストを取得する
     *
     * @return オプション項目のテキスト
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * オプション項目のテキストを設定する
     *
     * @param text オプション項目のテキスト
     */
    @Override
    public void setText(final String text) {
        this.text = text;
    }

}
