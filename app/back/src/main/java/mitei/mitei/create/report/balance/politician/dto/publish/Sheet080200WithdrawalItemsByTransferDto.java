package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式08その2 支出項目別金額の内訳を表すワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet080200WithdrawalItemsByTransferDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 支出項目 */
    @JacksonXmlProperty(localName = "KOMOKU")
    private String shishutsuKoumoku;

    /** 摘要 */
    @JacksonXmlProperty(localName = "TEKIYOU")
    private String tekiyou;

    /** 団体名称 */
    @JacksonXmlProperty(localName = "DANTAI_NM")
    private String dantaiName;

    /**
     * 支出項目を取得する
     *
     * @return 支出項目
     */
    public String getShishutsuKoumoku() {
        return shishutsuKoumoku;
    }

    /**
     * 支出項目を設定する
     *
     * @param shishutsuKoumoku 支出項目
     */
    public void setShishutsuKoumoku(final String shishutsuKoumoku) {
        this.shishutsuKoumoku = shishutsuKoumoku;
    }

    /**
     * 摘要項目を取得する
     *
     * @return 摘要
     */
    public String getTekiyou() {
        return tekiyou;
    }

    /**
     * 摘要を設定する
     *
     * @param tekiyou 摘要
     */
    public void setTekiyou(final String tekiyou) {
        this.tekiyou = tekiyou;
    }

    /**
     * 団体名称を取得する
     *
     * @return 団体名称
     */
    public String getDantaiName() {
        return dantaiName;
    }

    /**
     * 団体名称を設定する
     *
     * @param dantaiName 団体名称
     */
    public void setDantaiName(final String dantaiName) {
        this.dantaiName = dantaiName;
    }

}
