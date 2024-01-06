package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.NonNull;

/**
 * 様式17その3 機関誌とその他の事業の収入の列項目Dto
 */
public class Row070500IncomeRelatedToGrantsDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 連番 */
    @JacksonXmlProperty(localName = "ICHIREN_NO")
    private Integer ichirenNo;

    /** 本部支部の名称 */
    @JacksonXmlProperty(localName = "HONSIBU_NM")
    private String honbuShibuName;

    /** 金額 */
    @JacksonXmlProperty(localName = "KINGAKU")
    private Long kingaku;

    /** 発生日 */
    @JacksonXmlProperty(localName = "DT")
    private String date;

    /** 事務所の住所 */
    @JacksonXmlProperty(localName = "JIMU_ADR")
    private String jimushoJuusho;

    /** 備考 */
    @JacksonXmlProperty(localName = "BIKOU")
    private String biko;

    /**
     * 連番を取得する
     *
     * @return 連番
     */
    public Integer getIchirenNo() {
        return ichirenNo;
    }

    /**
     * 連番を設定する
     *
     * @param ichirenNo 連番
     */
    public void setIchirenNo(@NonNull final Integer ichirenNo) {
        this.ichirenNo = ichirenNo;
    }

    /**
     * 金額を取得する
     *
     * @return 金額
     */
    public Long getKingaku() {
        return kingaku;
    }

    /**
     * 金額を設定する
     *
     * @param kingaku 金額
     */
    public void setKingaku(@NonNull final Long kingaku) {
        this.kingaku = kingaku;
    }

    /**
     * 備考を取得する
     *
     * @return 備考
     */
    public String getBiko() {
        return biko;
    }

    /**
     * 備考を設定する
     *
     * @param biko 備考
     */
    public void setBiko(final String biko) {
        this.biko = biko;
    }

    /**
     * 本部支部名称を取得する
     *
     * @return 本部支部名称
     */
    public String getHonbuShibuName() {
        return honbuShibuName;
    }

    /**
     * 本部支部名称を設定する
     *
     * @param honbuShibuName 本部支部名称
     */
    public void setHonbuShibuName(final String honbuShibuName) {
        this.honbuShibuName = honbuShibuName;
    }

    /**
     * 発生日を取得する
     *
     * @return 発生日
     */
    public String getDate() {
        return date;
    }

    /**
     * 発生日を設定する
     *
     * @param date 発生日
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * 事務所住所を取得する
     *
     * @return 事務所住所
     */
    public String getJimushoJuusho() {
        return jimushoJuusho;
    }

    /**
     * 事務所住所を設定する
     *
     * @param jimushoJuusho 事務所住所
     */
    public void setJimushoJuusho(final String jimushoJuusho) {
        this.jimushoJuusho = jimushoJuusho;
    }

}
