package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式17その3 機関誌とその他の事業の収入の列項目Dto
 */
public class Row080000DifficultCollectReceiptDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 連番 */
    @JacksonXmlProperty(localName = "ICHIREN_NO")
    private Integer ichirenNo;

    /** 項目 */
    @JacksonXmlProperty(localName = "KOMOKU")
    private String koumoku;

    /** 摘要 */
    @JacksonXmlProperty(localName = "TEKIYOU")
    private String tekiyou;

    /** 金額 */
    @JacksonXmlProperty(localName = "KINGAKU")
    private Long kingaku = 0L;

    /** 発生日 */
    @JacksonXmlProperty(localName = "DT")
    private String date;

    /** 事情 */
    @JacksonXmlProperty(localName = "JIJYOU")
    private String jijyou;

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
    public void setIchirenNo(final Integer ichirenNo) {
        this.ichirenNo = ichirenNo;
    }

    /**
     * 支出項目を取得する
     *
     * @return 支出項目
     */
    public String getKoumoku() {
        return koumoku;
    }

    /**
     * 支出項目を設定する
     *
     * @param koumoku 支出項目
     */
    public void setKoumoku(final String koumoku) {
        this.koumoku = koumoku;
    }

    /**
     * 摘要を取得する
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
    public void setKingaku(final Long kingaku) {
        this.kingaku = kingaku;
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
     * 領収書を徴し難しかった事情を取得する
     *
     * @return 領収書を徴し難しかった事情
     */
    public String getJijyou() {
        return jijyou;
    }

    /**
     * 領収書を徴し難しかった事情を設定する
     *
     * @param jijyou 領収書を徴し難しかった事情
     */
    public void setJijyou(final String jijyou) {
        this.jijyou = jijyou;
    }

}
