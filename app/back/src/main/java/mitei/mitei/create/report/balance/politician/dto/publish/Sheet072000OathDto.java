package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式17その20 宣誓書を表すワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet072000OathDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 領収書の写しの有無 */
    @JacksonXmlProperty(localName = "RYOUSYU_UMU")
    private Integer flgReciptCopy;

    /** 監査意見書の有無 */
    @JacksonXmlProperty(localName = "KANSA_IKEN_UMU")
    private Integer flgKansaIkensho;

    /** 政治資金監査報告書 */
    @JacksonXmlProperty(localName = "KANSA_HOUKOKU_UMU")
    private Integer flgSeijishikinHohkokusho;

    /** 宣誓日 */
    @JacksonXmlProperty(localName = "SENSEI_DT")
    private String dateOath;

    /** 政治団体名称 */
    @JacksonXmlProperty(localName = "DANTAI_NM")
    private String dantaiName;

    /** 会計責任者姓名の姓 */
    @JacksonXmlProperty(localName = "KAI_NM1")
    private String kaikeiSekininshaNameLast;

    /** 会計責任者姓名の名 */
    @JacksonXmlProperty(localName = "KAI_NM2")
    private String kaikeiSekininshaNameFirst;

    /** 代表者姓名の姓 */
    @JacksonXmlProperty(localName = "DAI_NM1")
    private String daihyoushaNameLast;

    /** 代表者姓名の名 */
    @JacksonXmlProperty(localName = "DAI_NM2")
    private String daihyoushaNameFirst = "";

    /**
     * レシート複写フラグを取得する
     *
     * @return レシート複写フラグ
     */
    public Integer getFlgReciptCopy() {
        return flgReciptCopy;
    }

    /**
     * レシート複写フラグを設定する
     *
     * @param flgReciptCopy レシート複写フラグ
     */
    public void setFlgReciptCopy(final Integer flgReciptCopy) {
        this.flgReciptCopy = flgReciptCopy;
    }

    /**
     * 団体監査意見書フラグを取得する
     *
     * @return 団体監査意見書
     */
    public Integer getFlgKansaIkensho() {
        return flgKansaIkensho;
    }

    /**
     * 団体監査意見書フラグを設定する
     *
     * @param flgKansaIkensho 団体監査意見書
     */
    public void setFlgKansaIkensho(final Integer flgKansaIkensho) {
        this.flgKansaIkensho = flgKansaIkensho;
    }

    /**
     * 政治資金報告書フラグを取得する
     *
     * @return 政治資金報告書
     */
    public Integer getFlgSeijishikinHohkokusho() {
        return flgSeijishikinHohkokusho;
    }

    /**
     * 政治資金報告書フラグを設定する
     *
     * @param flgSeijishikinHohkokusho 政治資金報告書
     */
    public void setFlgSeijishikinHohkokusho(final Integer flgSeijishikinHohkokusho) {
        this.flgSeijishikinHohkokusho = flgSeijishikinHohkokusho;
    }

    /**
     * 宣誓日を取得する
     *
     * @return 宣誓日
     */
    public String getDateOath() {
        return dateOath;
    }

    /**
     * 宣誓日を設定する
     *
     * @param dateOath 宣誓日
     */
    public void setDateOath(final String dateOath) {
        this.dateOath = dateOath;
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

    /**
     * 会計責任者名の姓を取得する
     *
     * @return 会計責任者名の姓
     */
    public String getKaikeiSekininshaNameLast() {
        return kaikeiSekininshaNameLast;
    }

    /**
     * 会計責任者名の姓を設定する
     *
     * @param kaikeiSekininshaNameLast 会計責任者名の姓
     */
    public void setKaikeiSekininshaNameLast(final String kaikeiSekininshaNameLast) {
        this.kaikeiSekininshaNameLast = kaikeiSekininshaNameLast;
    }

    /**
     * 会計責任者名の名を取得する
     *
     * @return 会計責任者名の名
     */
    public String getKaikeiSekininshaNameFirst() {
        return kaikeiSekininshaNameFirst;
    }

    /**
     * 会計責任者名の名を設定する
     *
     * @param kaikeiSekininshaNameFirst 会計責任者名の名
     */
    public void setKaikeiSekininshaNameFirst(final String kaikeiSekininshaNameFirst) {
        this.kaikeiSekininshaNameFirst = kaikeiSekininshaNameFirst;
    }

    /**
     * 代表者名の姓を取得する
     *
     * @return 代表者名の姓
     */
    public String getDaihyoushaNameLast() {
        return daihyoushaNameLast;
    }

    /**
     * 代表者名の姓を設定する
     *
     * @param daihyoushaNameLast 代表者名の姓
     */
    public void setDaihyoushaNameLast(final String daihyoushaNameLast) {
        this.daihyoushaNameLast = daihyoushaNameLast;
    }

    /**
     * 代表者名の名を取得する
     *
     * @return 代表者名の名
     */
    public String getDaihyoushaNameFirst() {
        return daihyoushaNameFirst;
    }

    /**
     * 代表者名の名を設定する
     *
     * @param daihyoushaNameFirst 代表者名の名
     */
    public void setDaihyoushaNameFirst(final String daihyoushaNameFirst) {
        this.daihyoushaNameFirst = daihyoushaNameFirst;
    }

}
