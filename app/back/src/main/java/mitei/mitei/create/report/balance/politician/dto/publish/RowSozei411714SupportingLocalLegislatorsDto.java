package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 国会議員でない地方議員または首長を支援する団体で寄付控除を受けるときに対象議員の名前を申告するDto
 */
public class RowSozei411714SupportingLocalLegislatorsDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 議員・首長の名前 */
    @JacksonXmlProperty(localName = "NM")
    private String name;

    /** 立候補した選挙名称 */
    @JacksonXmlProperty(localName = "SENKYO")
    private String senkyo;

    /** 立候補した日付 */
    @JacksonXmlProperty(localName = "DT")
    private String date;

    /**
     * 地方議員・首長を取得する
     *
     * @return 地方議員・首長
     */
    public String getName() {
        return name;
    }

    /**
     * 地方議員・首長を設定する
     *
     * @param name 地方議員・首長
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * 立候補した選挙名を取得する
     *
     * @return 立候補した選挙名
     */
    public String getSenkyo() {
        return senkyo;
    }

    /**
     * 立候補した選挙名を設定する
     *
     * @param senkyo 立候補した選挙名
     */
    public void setSenkyo(final String senkyo) {
        this.senkyo = senkyo;
    }

    /**
     * 立候補した日付を取得する
     *
     * @return 立候補した日付
     */
    public String getDate() {
        return date;
    }

    /**
     * 立候補した日付を設定する
     *
     * @param date 立候補した日付
     */
    public void setDate(final String date) {
        this.date = date;
    }

}
