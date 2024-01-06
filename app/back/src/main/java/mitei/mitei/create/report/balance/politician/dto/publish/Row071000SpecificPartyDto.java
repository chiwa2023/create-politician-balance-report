package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.NonNull;

/**
 * 様式17その10 特定パーティの対価に係る収入の列項目Dto
 */
public class Row071000SpecificPartyDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 連番 */
    @JacksonXmlProperty(localName = "ICHIREN_NO")
    private Integer ichirenNo;

    /** パーティ名称 */
    @JacksonXmlProperty(localName = "PATYI_NM")
    private String partyName;

    /** 金額 */
    @JacksonXmlProperty(localName = "KINGAKU")
    private Long kingaku;

    /** 支払い数 */
    @JacksonXmlProperty(localName = "SHIHARAI_SU")
    private Long shiharaisu;

    /** 開催日 */
    @JacksonXmlProperty(localName = "KAISAI_DT")
    private String date;

    /** 開催場所 */
    @JacksonXmlProperty(localName = "KAISAI_BASYO")
    private String kaisaiBasho;

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
     * パーティ名称を取得する
     *
     * @return パーティ名称
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * パーティ名称を設定する
     *
     * @param partyName パーティ名称
     */
    public void setPartyName(final String partyName) {
        this.partyName = partyName;
    }

    /**
     * 支払い数を取得する
     *
     * @return 支払い数
     */
    public Long getShiharaisu() {
        return shiharaisu;
    }

    /**
     * 支払い数を設定する
     *
     * @param shiharaisu 支払い数
     */
    public void setShiharaisu(final Long shiharaisu) {
        this.shiharaisu = shiharaisu;
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
     * 開催場所を取得する
     *
     * @return 開催場所
     */
    public String getKaisaiBasho() {
        return kaisaiBasho;
    }

    /**
     * 開催場所を設定する
     *
     * @param kaisaiBasho 開催場所
     */
    public void setKaisaiBasho(final String kaisaiBasho) {
        this.kaisaiBasho = kaisaiBasho;
    }

}
