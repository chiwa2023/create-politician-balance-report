package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.NonNull;

/**
 * 様式17その3 機関誌とその他の事業の収入の列項目Dto
 */
public class Row070300JournalAndOtherDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 連番 */
    @JacksonXmlProperty(localName = "ICHIREN_NO")
    private Integer ichirenNo;

    /** 事業の種類 */
    @JacksonXmlProperty(localName = "GIGYOU_SYURUI")
    private String jigyoNoShurui;

    /** 金額 */
    @JacksonXmlProperty(localName = "KINGAKU")
    private Long kingaku;

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
     * 事業の種類を取得する
     *
     * @return 事業の種類
     */
    public String getJigyoNoShurui() {
        return jigyoNoShurui;
    }

    /**
     * 事業の種類を設定する
     *
     * @param jigyoNoShurui 事業の種類
     */
    public void setJigyoNoShurui(@NonNull final String jigyoNoShurui) {
        this.jigyoNoShurui = jigyoNoShurui;
    }

}
