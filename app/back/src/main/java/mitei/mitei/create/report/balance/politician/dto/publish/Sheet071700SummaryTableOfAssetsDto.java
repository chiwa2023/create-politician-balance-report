package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式17その17 資産等の状況総括表を表すワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet071700SummaryTableOfAssetsDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 土地報告フラグ */
    @JacksonXmlProperty(localName = "TOCHI_UMU")
    private Integer flgTochi = 0;

    /** 備考土地 */
    @JacksonXmlProperty(localName = "TOCHI_BIKOU")
    private String bikouTochi;

    /** 建物報告フラグ */
    @JacksonXmlProperty(localName = "TATEMONO_UMU")
    private Integer flgTatemono = 0;

    /** 備考建物 */
    @JacksonXmlProperty(localName = "TATEMONO_BIKOU")
    private String bikouTatemono;

    /** 借地件報告フラグ */
    @JacksonXmlProperty(localName = "SYAKUCHI_UMU")
    private Integer flgShakuchiken = 0;

    /** 備考借地権 */
    @JacksonXmlProperty(localName = "SYAKUCHI_BIKOU")
    private String bikouShakuchiken;

    /** 動産報告フラグ */
    @JacksonXmlProperty(localName = "DOUSAN_UMU")
    private Integer flgDohsan = 0;

    /** 動産借入 */
    @JacksonXmlProperty(localName = "DOUSAN_BIKOU")
    private String bikouDohsan;

    /** 預金報告フラグ */
    @JacksonXmlProperty(localName = "YOKIN_UMU")
    private Integer flgYokin = 0;

    /** 備考預金 */
    @JacksonXmlProperty(localName = "YOKIN_BIKOU")
    private String bikouYokin;

    /** 信託報告フラグ */
    @JacksonXmlProperty(localName = "SINTAKU_UMU")
    private Integer flgShintaku = 0;

    /** 備考信託 */
    @JacksonXmlProperty(localName = "SINTAKU_BIKOU")
    private String bikouShintaku;

    /** 証券報告フラグ */
    @JacksonXmlProperty(localName = "SYOUKEN_UMU")
    private Integer flgShouken = 0;

    /** 備考証券 */
    @JacksonXmlProperty(localName = "SYOUKEN_BIKOU")
    private String bikouShouken;

    /** 出資報告フラグ */
    @JacksonXmlProperty(localName = "SYUSSI_UMU")
    private Integer flgShusshi = 0;

    /** 備考出資 */
    @JacksonXmlProperty(localName = "SYUSSI_BIKOU")
    private String bikouShusshi;

    /** 貸付報告フラグ */
    @JacksonXmlProperty(localName = "KASITUKE_UMU")
    private Integer flgKashitsuke = 0;

    /** 備考貸付 */
    @JacksonXmlProperty(localName = "KASITUKE_BIKOU")
    private String bikouKashitsuke;

    /** 敷金報告フラグ */
    @JacksonXmlProperty(localName = "SIKIKIN_UMU")
    private Integer flgShikikin = 0;

    /** 備考敷金 */
    @JacksonXmlProperty(localName = "SIKIKIN_BIKOU")
    private String bikouShikikin;

    /** 施設利用報告フラグ */
    @JacksonXmlProperty(localName = "SISETURIYOU_UMU")
    private Integer flgShisetsuRiyou = 0;

    /** 備考施設利用 */
    @JacksonXmlProperty(localName = "SISETURIYOU_BIKOU")
    private String bikouShisetsuRiyou;

    /** 借入報告フラグ */
    @JacksonXmlProperty(localName = "KARIIRE_UMU")
    private Integer flgKairiire = 0;

    /** 備考借入 */
    @JacksonXmlProperty(localName = "KARIIRE_BIKOU")
    private String bikouKariire;

    /**
     * 土地報告を取得する
     *
     * @return 土地報告
     */
    public Integer getFlgTochi() {
        return flgTochi;
    }

    /**
     * 土地報告を設定する
     *
     * @param flgTochi 土地報告
     */
    public void setFlgTochi(final Integer flgTochi) {
        this.flgTochi = flgTochi;
    }

    /**
     * 土地備考を取得する
     *
     * @return 土地備考
     */
    public String getBikouTochi() {
        return bikouTochi;
    }

    /**
     * 土地備考を設定する
     *
     * @param bikouTochi 土地備考
     */
    public void setBikouTochi(final String bikouTochi) {
        this.bikouTochi = bikouTochi;
    }

    /**
     * 建物報告を取得する
     *
     * @return 建物報告
     */
    public Integer getFlgTatemono() {
        return flgTatemono;
    }

    /**
     * 建物報告を設定する
     *
     * @param flgTatemono 建物報告
     */
    public void setFlgTatemono(final Integer flgTatemono) {
        this.flgTatemono = flgTatemono;
    }

    /**
     * 建物備考を取得する
     *
     * @return 建物備考
     */
    public String getBikouTatemono() {
        return bikouTatemono;
    }

    /**
     * 建物備考を設定する
     *
     * @param bikouTatemono 建物備考
     */
    public void setBikouTatemono(final String bikouTatemono) {
        this.bikouTatemono = bikouTatemono;
    }

    /**
     * 借地権報告を取得する
     *
     * @return 借地権報告
     */
    public Integer getFlgShakuchiken() {
        return flgShakuchiken;
    }

    /**
     * 借地権報告を設定する
     *
     * @param flgShakuchiken 借地権報告
     */
    public void setFlgShakuchiken(final Integer flgShakuchiken) {
        this.flgShakuchiken = flgShakuchiken;
    }

    /**
     * 借地権備考を取得する
     *
     * @return 借地権備考
     */
    public String getBikouShakuchiken() {
        return bikouShakuchiken;
    }

    /**
     * 借地権備考を設定する
     *
     * @param bikouShakuchiken 借地権備考
     */
    public void setBikouShakuchiken(final String bikouShakuchiken) {
        this.bikouShakuchiken = bikouShakuchiken;
    }

    /**
     * 動産報告を取得する
     *
     * @return 動産報告
     */
    public Integer getFlgDohsan() {
        return flgDohsan;
    }

    /**
     * 動産報告を設定する
     *
     * @param flgDohsan 動産報告
     */
    public void setFlgDohsan(final Integer flgDohsan) {
        this.flgDohsan = flgDohsan;
    }

    /**
     * 動産備考を取得する
     *
     * @return 動産備考
     */
    public String getBikouDohsan() {
        return bikouDohsan;
    }

    /**
     * 動産備考を設定する
     *
     * @param bikouDohsan 動産備考
     */
    public void setBikouDohsan(final String bikouDohsan) {
        this.bikouDohsan = bikouDohsan;
    }

    /**
     * 預金報告を取得する
     *
     * @return 預金報告
     */
    public Integer getFlgYokin() {
        return flgYokin;
    }

    /**
     * 預金報告を設定する
     *
     * @param flgYokin 預金報告
     */
    public void setFlgYokin(final Integer flgYokin) {
        this.flgYokin = flgYokin;
    }

    /**
     * 預金備考を取得する
     *
     * @return 預金備考
     */
    public String getBikouYokin() {
        return bikouYokin;
    }

    /**
     * 預金備考を設定する
     *
     * @param bikouYokin 預金備考
     */
    public void setBikouYokin(final String bikouYokin) {
        this.bikouYokin = bikouYokin;
    }

    /**
     * 信託報告を取得する
     *
     * @return 信託報告
     */
    public Integer getFlgShintaku() {
        return flgShintaku;
    }

    /**
     * 信託報告を設定する
     *
     * @param flgShintaku 信託報告
     */
    public void setFlgShintaku(final Integer flgShintaku) {
        this.flgShintaku = flgShintaku;
    }

    /**
     * 信託備考を取得する
     *
     * @return 信託備考
     */
    public String getBikouShintaku() {
        return bikouShintaku;
    }

    /**
     * 信託備考を設定する
     *
     * @param bikouShintaku 信託備考
     */
    public void setBikouShintaku(final String bikouShintaku) {
        this.bikouShintaku = bikouShintaku;
    }

    /**
     * 証券報告を取得する
     *
     * @return 証券報告
     */
    public Integer getFlgShouken() {
        return flgShouken;
    }

    /**
     * 証券報告を設定する
     *
     * @param flgShouken 証券報告
     */
    public void setFlgShouken(final Integer flgShouken) {
        this.flgShouken = flgShouken;
    }

    /**
     * 証券備考を取得する
     *
     * @return 証券備考
     */
    public String getBikouShouken() {
        return bikouShouken;
    }

    /**
     * 証券備考を設定する
     *
     * @param bikouShouken 証券備考
     */
    public void setBikouShouken(final String bikouShouken) {
        this.bikouShouken = bikouShouken;
    }

    /**
     * 出資報告を取得する
     *
     * @return 出資報告
     */
    public Integer getFlgShusshi() {
        return flgShusshi;
    }

    /**
     * 出資報告を設定する
     *
     * @param flgShusshi 出資報告
     */
    public void setFlgShusshi(final Integer flgShusshi) {
        this.flgShusshi = flgShusshi;
    }

    /**
     * 出資備考を取得する
     *
     * @return 出資備考
     */
    public String getBikouShusshi() {
        return bikouShusshi;
    }

    /**
     * 出資備考を設定する
     *
     * @param bikouShusshi 出資備考
     */
    public void setBikouShusshi(final String bikouShusshi) {
        this.bikouShusshi = bikouShusshi;
    }

    /**
     * 貸付報告を取得する
     *
     * @return 貸付報告
     */
    public Integer getFlgKashitsuke() {
        return flgKashitsuke;
    }

    /**
     * 貸付報告を設定する
     *
     * @param flgKashitsuke 貸付報告
     */
    public void setFlgKashitsuke(final Integer flgKashitsuke) {
        this.flgKashitsuke = flgKashitsuke;
    }

    /**
     * 貸付備考を取得する
     *
     * @return 貸付備考
     */
    public String getBikouKashitsuke() {
        return bikouKashitsuke;
    }

    /**
     * 貸付備考を設定する
     *
     * @param bikouKashitsuke 貸付備考
     */
    public void setBikouKashitsuke(final String bikouKashitsuke) {
        this.bikouKashitsuke = bikouKashitsuke;
    }

    /**
     * 敷金報告を取得する
     *
     * @return 敷金報告
     */
    public Integer getFlgShikikin() {
        return flgShikikin;
    }

    /**
     * 敷金報告を設定する
     *
     * @param flgShikikin 敷金報告
     */
    public void setFlgShikikin(final Integer flgShikikin) {
        this.flgShikikin = flgShikikin;
    }

    /**
     * 敷金備考を取得する
     *
     * @return 敷金備考
     */
    public String getBikouShikikin() {
        return bikouShikikin;
    }

    /**
     * 敷金備考を設定する
     *
     * @param bikouShikikin 敷金備考
     */
    public void setBikouShikikin(final String bikouShikikin) {
        this.bikouShikikin = bikouShikikin;
    }

    /**
     * 施設利用報告を取得する
     *
     * @return 施設利用報告
     */
    public Integer getFlgShisetsuRiyou() {
        return flgShisetsuRiyou;
    }

    /**
     * 施設利用報告を設定する
     *
     * @param flgShisetsuRiyou 施設利用報告
     */
    public void setFlgShisetsuRiyou(final Integer flgShisetsuRiyou) {
        this.flgShisetsuRiyou = flgShisetsuRiyou;
    }

    /**
     * 施設利用備考を取得する
     *
     * @return 施設利用備考
     */
    public String getBikouShisetsuRiyou() {
        return bikouShisetsuRiyou;
    }

    /**
     * 施設利用備考を設定する
     *
     * @param bikouShisetsuRiyou 施設利用備考
     */
    public void setBikouShisetsuRiyou(final String bikouShisetsuRiyou) {
        this.bikouShisetsuRiyou = bikouShisetsuRiyou;
    }

    /**
     * 借入報告を取得する
     *
     * @return 借入報告
     */
    public Integer getFlgKairiire() {
        return flgKairiire;
    }

    /**
     * 借入報告を設定する
     *
     * @param flgKairiire 借入報告
     */
    public void setFlgKairiire(final Integer flgKairiire) {
        this.flgKairiire = flgKairiire;
    }

    /**
     * 借入備考を取得する
     *
     * @return 借入備考
     */
    public String getBikouKariire() {
        return bikouKariire;
    }

    /**
     * 借入備考を設定する
     *
     * @param bikouKariire 借入備考
     */
    public void setBikouKariire(final String bikouKariire) {
        this.bikouKariire = bikouKariire;
    }

}
