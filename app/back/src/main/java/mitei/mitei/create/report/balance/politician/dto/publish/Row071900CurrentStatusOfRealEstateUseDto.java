package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.NonNull;

/**
 * 様式17その3 機関誌とその他の事業の収入の列項目Dto
 */
public class Row071900CurrentStatusOfRealEstateUseDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 連番 */
    @JacksonXmlProperty(localName = "ICHIREN_NO")
    private Integer ichirenNo;

    /** 摘要 */
    @JacksonXmlProperty(localName = "TEKIYOU")
    private String tekiyou;

    /** 用途 */
    @JacksonXmlProperty(localName = "YOUTO")
    private String youto;

    /** 使用者と代表者との関係 */
    @JacksonXmlProperty(localName = "SIYOU_KANKEI")
    private String kankeiShiyousha;

    /** 使用の用途 */
    @JacksonXmlProperty(localName = "SIYOU_YOUTO")
    private String shiyouYouto;

    /** 使用面積 */
    @JacksonXmlProperty(localName = "SIYOU_MENSEKI")
    private String shiyouMenseki;

    /** 使用価格 */
    @JacksonXmlProperty(localName = "SIYOU_KAKAKU")
    private Long shiyouKakaku = 0L;

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
     * 用途を取得する
     *
     * @return 用途
     */
    public String getYouto() {
        return youto;
    }

    /**
     * 用途を設定する
     *
     * @param youto 用途
     */
    public void setYouto(final String youto) {
        this.youto = youto;
    }

    /**
     * 使用者との関係を取得する
     *
     * @return 使用者との関係
     */
    public String getKankeiShiyousha() {
        return kankeiShiyousha;
    }

    /**
     * 使用者との関係を設定する
     *
     * @param kankeiShiyousha 使用者との関係
     */
    public void setKankeiShiyousha(final String kankeiShiyousha) {
        this.kankeiShiyousha = kankeiShiyousha;
    }

    /**
     * 使用用途を取得する
     *
     * @return 使用用途
     */
    public String getShiyouYouto() {
        return shiyouYouto;
    }

    /**
     * 使用用途を設定する
     *
     * @param shiyouYouto 使用用途
     */
    public void setShiyouYouto(final String shiyouYouto) {
        this.shiyouYouto = shiyouYouto;
    }

    /**
     * 使用面積を取得する
     *
     * @return 使用面積
     */
    public String getShiyouMenseki() {
        return shiyouMenseki;
    }

    /**
     * 使用面積を設定する
     *
     * @param shiyouMenseki 使用面積
     */
    public void setShiyouMenseki(final String shiyouMenseki) {
        this.shiyouMenseki = shiyouMenseki;
    }

    /**
     * 使用価格を取得する
     *
     * @return 使用価格
     */
    public Long getShiyouKakaku() {
        return shiyouKakaku;
    }

    /**
     * 使用価格を設定する
     *
     * @param shiyouKakaku 使用価格
     */
    public void setShiyouKakaku(final Long shiyouKakaku) {
        this.shiyouKakaku = shiyouKakaku;
    }

}
