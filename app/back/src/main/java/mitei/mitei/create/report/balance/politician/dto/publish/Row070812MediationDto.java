package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.NonNull;

/**
 * 様式17その3 機関誌とその他の事業の収入の列項目Dto
 */
public class Row070812MediationDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 連番 */
    @JacksonXmlProperty(localName = "ICHIREN_NO")
    private Integer ichirenNo;

    /** 名前 */
    @JacksonXmlProperty(localName = "NM")
    private String name;

    /** 金額 */
    @JacksonXmlProperty(localName = "KINGAKU")
    private Long kingaku;

    /** 発生日 */
    @JacksonXmlProperty(localName = "DT")
    private String date;

    /** 斡旋の期間 */
    @JacksonXmlProperty(localName = "KIKAN")
    private String periodMediate;

    /** 住所 */
    @JacksonXmlProperty(localName = "ADR")
    private String juusho;

    /** 職業 */
    @JacksonXmlProperty(localName = "SYOKUGYO")
    private String shokugyou;

    /** 備考 */
    @JacksonXmlProperty(localName = "BIKOU")
    private String biko;

    /** 通し番号 */
    @JacksonXmlProperty(localName = "SEQ_NO")
    private Integer tohshibangou;

    /** 行区分 */
    @JacksonXmlProperty(localName = "ROWKBN")
    private Short gyoukubun;

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
     * 名称を取得する
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称を取得する
     *
     * @param name 名称
     */
    public void setName(final String name) {
        this.name = name;
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
     * あっせんの期間を取得する
     *
     * @return あっせんの期間
     */
    public String getPeriodMediate() {
        return periodMediate;
    }

    /**
     * あっせんの期間を設定する
     *
     * @param periodMediate あっせんの期間
     */
    public void setPeriodMediate(final String periodMediate) {
        this.periodMediate = periodMediate;
    }

    /**
     * 住所を取得する
     *
     * @return 住所
     */
    public String getJuusho() {
        return juusho;
    }

    /**
     * 住所を設定する
     *
     * @param juusho 住所
     */
    public void setJuusho(final String juusho) {
        this.juusho = juusho;
    }

    /**
     * 職業を取得する
     *
     * @return 職業
     */
    public String getShokugyou() {
        return shokugyou;
    }

    /**
     * 職業を設定する
     *
     * @param shokugyou 職業
     */
    public void setShokugyou(final String shokugyou) {
        this.shokugyou = shokugyou;
    }

    /**
     * 通し番号を取得する
     *
     * @return 通し番号
     */
    public Integer getTohshibangou() {
        return tohshibangou;
    }

    /**
     * 通し番号を設定する
     *
     * @param tohshibangou 通し番号
     */
    public void setTohshibangou(final Integer tohshibangou) {
        this.tohshibangou = tohshibangou;
    }

    /**
     * 行区分を取得する
     *
     * @return 行区分
     */
    public Short getGyoukubun() {
        return gyoukubun;
    }

    /**
     * 行区分を設定する
     *
     * @param gyoukubun 行区分
     */
    public void setGyoukubun(final Short gyoukubun) {
        this.gyoukubun = gyoukubun;
    }

}
