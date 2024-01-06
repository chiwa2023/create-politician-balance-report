package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.NonNull;

/**
 * 様式17その3 機関誌とその他の事業の収入の列項目Dto
 */
public class Row071415OrdinaryExpensesDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 連番 */
    @JacksonXmlProperty(localName = "ICHIREN_NO")
    private Integer ichirenNo;

    /** 支出の目的 */
    @JacksonXmlProperty(localName = "MOKUTEKI")
    private String mokuteki;

    /** 金額 */
    @JacksonXmlProperty(localName = "KINGAKU")
    private Long kingaku;

    /** 発生日 */
    @JacksonXmlProperty(localName = "DT")
    private String date;

    /** 支出の相手先名称 */
    @JacksonXmlProperty(localName = "NM")
    private String name;

    /** 支出の相手先住所 */
    @JacksonXmlProperty(localName = "ADR")
    private String jusho;

    /** 備考 */
    @JacksonXmlProperty(localName = "BIKOU")
    private String biko;

    /** 領収書を徴しがたかったフラグ */
    @JacksonXmlProperty(localName = "RYOUSYU")
    private Integer flgRyoushuusho;

    /** 交付金に係る支出フラグ */
    @JacksonXmlProperty(localName = "KOUFUKIN")
    private Integer flgKouufukin;

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
     * 目的を取得する
     *
     * @return 目的
     */
    public String getMokuteki() {
        return mokuteki;
    }

    /**
     * 目的を設定する
     *
     * @param mokuteki 目的
     */
    public void setMokuteki(final String mokuteki) {
        this.mokuteki = mokuteki;
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
     * 支出先名称を取得する
     *
     * @return 支出先名称
     */
    public String getName() {
        return name;
    }

    /**
     * 支出先名称を設定する
     *
     * @param name 支出先名称
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * 支出先住所を取得する
     *
     * @return 支出先住所
     */
    public String getJusho() {
        return jusho;
    }

    /**
     * 支出先住所を設定する
     *
     * @param jusho 支出先住所
     */
    public void setJusho(final String jusho) {
        this.jusho = jusho;
    }

    /**
     * 領収書を徴し難かったものフラグを取得する
     *
     * @return 領収書を徴し難かったものフラグ
     */
    public Integer getFlgRyoushuusho() {
        return flgRyoushuusho;
    }

    /**
     * 領収書を徴し難かったものフラグを設定する
     *
     * @param flgRyoushuusho 領収書を徴し難かったものフラグ
     */
    public void setFlgRyoushuusho(final Integer flgRyoushuusho) {
        this.flgRyoushuusho = flgRyoushuusho;
    }

    /**
     * 交付金フラグを取得する
     *
     * @return 交付金フラグ
     */
    public Integer getFlgKouufukin() {
        return flgKouufukin;
    }

    /**
     * 交付金フラグを設定する
     *
     * @param flgKouufukin 交付金フラグ
     */
    public void setFlgKouufukin(final Integer flgKouufukin) {
        this.flgKouufukin = flgKouufukin;
    }

}
