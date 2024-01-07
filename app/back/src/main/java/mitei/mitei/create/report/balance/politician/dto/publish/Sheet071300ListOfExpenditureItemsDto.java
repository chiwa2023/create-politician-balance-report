package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式17その13 支出項目別金額の内訳を表すワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet071300ListOfExpenditureItemsDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 人件費項目の合計 */
    @JacksonXmlProperty(localName = "JINKENHI_GK")
    private Long goukeiJinkenhi = 0L;

    /** 人件費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "JINKENHI_KOUFU")
    private String kohfuJinkenhi;

    /** 人件費の備考 */
    @JacksonXmlProperty(localName = "JINKENHI_BIKOU")
    private String bikouJinkenhi;

    /** 光熱費項目の合計 */
    @JacksonXmlProperty(localName = "KOUNETU_GK")
    private Long goukeiKohnetsuhi = 0L;

    /** 光熱費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "KOUNETU_KOUFU")
    private String kohfuKohnetsuhi;

    /** 光熱費の備考 */
    @JacksonXmlProperty(localName = "KOUNETU_BIKOU")
    private String bikouKohnetsuhi;

    /** 備品項目の合計 */
    @JacksonXmlProperty(localName = "BIHIN_GK")
    private Long goukeiBihinhi = 0L;

    /** 備品の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "BIHIN_KOUFU")
    private String kohfuBihinhi;

    /** 備品の備考 */
    @JacksonXmlProperty(localName = "BIHIN_BIKOU")
    private String bikouBihinhi;

    /** 事務所項目の合計 */
    @JacksonXmlProperty(localName = "JIMUSYO_GK")
    private Long goukeiJimushohi = 0L;

    /** 事務所の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "JIMUSYO_KOUFU")
    private String kohfuJimushohi;

    /** 事務所の備考 */
    @JacksonXmlProperty(localName = "JIMUSYO_BIKOU")
    private String bikouJimushohi;

    /** 経費項目の合計 */
    @JacksonXmlProperty(localName = "KEIHI_SKEI_GK")
    private Long goukeiKeihiShoukei = 0L;

    /** 経費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "KEIHI_SKEI_KOUFU")
    private String kohfuKeihiShoukei;

    /** 経費の備考 */
    @JacksonXmlProperty(localName = "KEIHI_SKEI_BIKOU")
    private String bikouKeihiShoukei;

    /** 組織活動費項目の合計 */
    @JacksonXmlProperty(localName = "SOSIKI_GK")
    private Long goukeiSoshikiKatsudouhi = 0L;

    /** 組織活動費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "SOSIKI_KOUFU")
    private String kohfuSoshikiKatsudouhi;

    /** 組織活動費の備考 */
    @JacksonXmlProperty(localName = "SOSIKI_BIKOU")
    private String bikouSoshikiKatsudouhi;

    /** 選挙活動費項目の合計 */
    @JacksonXmlProperty(localName = "SENKYO_GK")
    private Long goukeiSenkyoKatsudou = 0L;

    /** 選挙活動費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "SENKYO_KOUFU")
    private String kohfuSenkyoKatsudou;

    /** 選挙活動費の備考 */
    @JacksonXmlProperty(localName = "SENKYO_BIKOU")
    private String bikouSenkyoKatsudou;

    /** その他項目の合計 */
    @JacksonXmlProperty(localName = "SONOTA_JIGYO_GK")
    private Long goukeiSonota = 0L;

    /** その他の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "SONOTA_JIGYO_KOUFU")
    private String kohfuSonota;

    /** その他の備考 */
    @JacksonXmlProperty(localName = "SONOTA_JIGYO_BIKOU")
    private String bikouSonota;

    /** 機関誌発行項目の合計 */
    @JacksonXmlProperty(localName = "HAKKOU_JIGYO_GK")
    private Long goukeiHakkou = 0L;

    /** 機関誌発行の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "HAKKOU_JIGYO_KOUFU")
    private String kohfuHakkou;

    /** 機関誌発行の備考 */
    @JacksonXmlProperty(localName = "HAKKOU_JIGYO_BIKOU")
    private String bikouHakkou;

    /** 宣伝費項目の合計 */
    @JacksonXmlProperty(localName = "SENDEN_GK")
    private Long goukeiSenden = 0L;

    /** 宣伝費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "SENDEN_KOUFU")
    private String kohfuSenden;

    /** 宣伝費見書の備考 */
    @JacksonXmlProperty(localName = "SENDEN_BIKOU")
    private String bikouSenden;

    /** 政治資金パーティ開催項目の合計 */
    @JacksonXmlProperty(localName = "KAISAI_GK")
    private Long goukeiKaisaiPty = 0L;

    /** 政治資金パーティ開催の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "KAISAI_KOUFU")
    private String kohfuKaisaiPty;

    /** 政治資金パーティ開催の備考 */
    @JacksonXmlProperty(localName = "KAISAI_BIKOU")
    private String bikouKaisaiPty;

    /** その他事業費項目の合計 */
    @JacksonXmlProperty(localName = "SONOTA_GK")
    private Long goukeiSonotaJigyou = 0L;

    /** その他事業費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "SONOTA_KOUFU")
    private String kohfuSonotaJigyou;

    /** その他事業費の備考 */
    @JacksonXmlProperty(localName = "SONOTA_BIKOU")
    private String bikouSonotaJigyou;

    /** 調査研究費項目の合計 */
    @JacksonXmlProperty(localName = "CYOUSA_GK")
    private Long goukeiChousaKenkyu = 0L;

    /** 調査研究費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "CYOUSA_KOUFU")
    private String kohfuChousaKenkyu;

    /** 調査研究費の備考 */
    @JacksonXmlProperty(localName = "CYOUSA_BIKOU")
    private String bikouChousaKenkyu;

    /** 寄付金項目の合計 */
    @JacksonXmlProperty(localName = "KIFU_GK")
    private Long goukeiKifukin = 0L;

    /** 寄付金の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "KIFU_KOUFU")
    private String kohfuKifukin;

    /** 寄付金の備考 */
    @JacksonXmlProperty(localName = "KIFU_BIKOU")
    private String bikouKifukin;

    /** その他の経費項目の合計 */
    @JacksonXmlProperty(localName = "SONOTA_KEIHI_GK")
    private Long goukeiSonotaKeihi = 0L;

    /** その他の経費の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "SONOTA_KEIHI_KOUFU")
    private String kohfuSonotaKeihi;

    /** その他の経費の備考 */
    @JacksonXmlProperty(localName = "SONOTA_KEIHI_BIKOU")
    private String bikouSonotaKeihi;

    /** 活動費小計の合計 */
    @JacksonXmlProperty(localName = "KATUDOU_SKEI_GK")
    private Long goukeiKatsudouhi = 0L;

    /** 活動費小計の供与した交付金に係る支出 */
    @JacksonXmlProperty(localName = "KATUDOU_SKEI_KOUFU")
    private String kohfuKatsudouhi;

    /** 活動費小計の備考 */
    @JacksonXmlProperty(localName = "KATUDOU_SKEI_BIKOU")
    private String bikouKatsudouhi;

    /** 現計合計 */
    @JacksonXmlProperty(localName = "GKEI_GK")
    private Long goukeiZenGohkei = 0L;

    /**
     * 人件費合計を取得する
     *
     * @return 人件費合計
     */
    public Long getGoukeiJinkenhi() {
        return goukeiJinkenhi;
    }

    /**
     * 人件費合計を設定する
     *
     * @param goukeiJinkenhi 人件費合計
     */
    public void setGoukeiJinkenhi(final Long goukeiJinkenhi) {
        this.goukeiJinkenhi = goukeiJinkenhi;
    }

    /**
     * 人件費に係る交付金を取得する
     *
     * @return 人件費に係る交付金
     */
    public String getKohfuJinkenhi() {
        return kohfuJinkenhi;
    }

    /**
     * 人件費に係る交付金を設定する
     *
     * @param kohfuJinkenhi 人件費に係る交付金
     */
    public void setKohfuJinkenhi(final String kohfuJinkenhi) {
        this.kohfuJinkenhi = kohfuJinkenhi;
    }

    /**
     * 人件費備考を取得する
     *
     * @return 人件費備考
     */
    public String getBikouJinkenhi() {
        return bikouJinkenhi;
    }

    /**
     * 人件費備考を設定する
     *
     * @param bikouJinkenhi 人件費備考
     */
    public void setBikouJinkenhi(final String bikouJinkenhi) {
        this.bikouJinkenhi = bikouJinkenhi;
    }

    /**
     * 光熱費合計を取得する
     *
     * @return 光熱費合計
     */
    public Long getGoukeiKohnetsuhi() {
        return goukeiKohnetsuhi;
    }

    /**
     * 光熱費合計を設定する
     *
     * @param goukeiKohnetsuhi 光熱費合計
     */
    public void setGoukeiKohnetsuhi(final Long goukeiKohnetsuhi) {
        this.goukeiKohnetsuhi = goukeiKohnetsuhi;
    }

    /**
     * 光熱費に係る交付金を取得する
     *
     * @return 光熱費に係る交付金
     */
    public String getKohfuKohnetsuhi() {
        return kohfuKohnetsuhi;
    }

    /**
     * 光熱費に係る交付金を設定する
     *
     * @param kohfuKohnetsuhi 光熱費に係る交付金
     */
    public void setKohfuKohnetsuhi(final String kohfuKohnetsuhi) {
        this.kohfuKohnetsuhi = kohfuKohnetsuhi;
    }

    /**
     * 光熱費備考を取得する
     *
     * @return 光熱費備考
     */
    public String getBikouKohnetsuhi() {
        return bikouKohnetsuhi;
    }

    /**
     * 光熱費備考を設定する
     *
     * @param bikouKohnetsuhi 光熱費備考
     */
    public void setBikouKohnetsuhi(final String bikouKohnetsuhi) {
        this.bikouKohnetsuhi = bikouKohnetsuhi;
    }

    /**
     * 備品費合計を取得する
     *
     * @return 備品費合計
     */
    public Long getGoukeiBihinhi() {
        return goukeiBihinhi;
    }

    /**
     * 備品費合計を設定する
     *
     * @param goukeiBihinhi 備品費合計
     */
    public void setGoukeiBihinhi(final Long goukeiBihinhi) {
        this.goukeiBihinhi = goukeiBihinhi;
    }

    /**
     * 備品費に係る交付金を取得する
     *
     * @return 備品費に係る交付金
     */
    public String getKohfuBihinhi() {
        return kohfuBihinhi;
    }

    /**
     * 備品費に係る交付金を設定する
     *
     * @param kohfuBihinhi 備品費に係る交付金
     */
    public void setKohfuBihinhi(final String kohfuBihinhi) {
        this.kohfuBihinhi = kohfuBihinhi;
    }

    /**
     * 備品費備考を取得する
     *
     * @return 備品費備考
     */
    public String getBikouBihinhi() {
        return bikouBihinhi;
    }

    /**
     * 備品費備考を設定する
     *
     * @param bikouBihinhi 備品費備考
     */
    public void setBikouBihinhi(final String bikouBihinhi) {
        this.bikouBihinhi = bikouBihinhi;
    }

    /**
     * 事務所費合計を取得する
     *
     * @return 事務所費合計
     */
    public Long getGoukeiJimushohi() {
        return goukeiJimushohi;
    }

    /**
     * 事務所費合計を設定する
     *
     * @param goukeiJimushohi 事務所費合計
     */
    public void setGoukeiJimushohi(final Long goukeiJimushohi) {
        this.goukeiJimushohi = goukeiJimushohi;
    }

    /**
     * 事務所費に係る交付金を取得する
     *
     * @return 事務所費に係る交付金
     */
    public String getKohfuJimushohi() {
        return kohfuJimushohi;
    }

    /**
     * 事務所費に係る交付金を設定する
     *
     * @param kohfuJimushohi 事務所費に係る交付金
     */
    public void setKohfuJimushohi(final String kohfuJimushohi) {
        this.kohfuJimushohi = kohfuJimushohi;
    }

    /**
     * 事務所費備考を取得する
     *
     * @return 事務所費備考
     */
    public String getBikouJimushohi() {
        return bikouJimushohi;
    }

    /**
     * 事務所費備考を設定する
     *
     * @param bikouJimushohi 事務所費備考
     */
    public void setBikouJimushohi(final String bikouJimushohi) {
        this.bikouJimushohi = bikouJimushohi;
    }

    /**
     * 経費小計合計を取得する
     *
     * @return 経費小計合計
     */
    public Long getGoukeiKeihiShoukei() {
        return goukeiKeihiShoukei;
    }

    /**
     * 経費小計合計を設定する
     *
     * @param goukeiKeihiShoukei 経費小計合計
     */
    public void setGoukeiKeihiShoukei(final Long goukeiKeihiShoukei) {
        this.goukeiKeihiShoukei = goukeiKeihiShoukei;
    }

    /**
     * 経費小計に係る交付金を取得する
     *
     * @return 経費小計に係る交付金
     */
    public String getKohfuKeihiShoukei() {
        return kohfuKeihiShoukei;
    }

    /**
     * 経費小計に係る交付金を設定する
     *
     * @param kohfuKeihiShoukei 経費小計に係る交付金
     */
    public void setKohfuKeihiShoukei(final String kohfuKeihiShoukei) {
        this.kohfuKeihiShoukei = kohfuKeihiShoukei;
    }

    /**
     * 経費小計備考を取得する
     *
     * @return 経費小計備考
     */
    public String getBikouKeihiShoukei() {
        return bikouKeihiShoukei;
    }

    /**
     * 経費小計備考を設定する
     *
     * @param bikouKeihiShoukei 経費小計備考
     */
    public void setBikouKeihiShoukei(final String bikouKeihiShoukei) {
        this.bikouKeihiShoukei = bikouKeihiShoukei;
    }

    /**
     * 組織活動費合計を取得する
     *
     * @return 組織活動費合計
     */
    public Long getGoukeiSoshikiKatsudouhi() {
        return goukeiSoshikiKatsudouhi;
    }

    /**
     * 組織活動費合計を設定する
     *
     * @param goukeiSoshikiKatsudouhi 組織活動費合計
     */
    public void setGoukeiSoshikiKatsudouhi(final Long goukeiSoshikiKatsudouhi) {
        this.goukeiSoshikiKatsudouhi = goukeiSoshikiKatsudouhi;
    }

    /**
     * 組織活動費に係る交付金を取得する
     *
     * @return 組織活動費に係る交付金
     */
    public String getKohfuSoshikiKatsudouhi() {
        return kohfuSoshikiKatsudouhi;
    }

    /**
     * 組織活動費に係る交付金を設定する
     *
     * @param kohfuSoshikiKatsudouhi 組織活動費に係る交付金
     */
    public void setKohfuSoshikiKatsudouhi(final String kohfuSoshikiKatsudouhi) {
        this.kohfuSoshikiKatsudouhi = kohfuSoshikiKatsudouhi;
    }

    /**
     * 組織活動費備考を取得する
     *
     * @return 組織活動費備考
     */
    public String getBikouSoshikiKatsudouhi() {
        return bikouSoshikiKatsudouhi;
    }

    /**
     * 組織活動費備考を設定する
     *
     * @param bikouSoshikiKatsudouhi 組織活動費備考
     */
    public void setBikouSoshikiKatsudouhi(final String bikouSoshikiKatsudouhi) {
        this.bikouSoshikiKatsudouhi = bikouSoshikiKatsudouhi;
    }

    /**
     * 選挙活動費合計を取得する
     *
     * @return 選挙活動費合計
     */
    public Long getGoukeiSenkyoKatsudou() {
        return goukeiSenkyoKatsudou;
    }

    /**
     * 選挙活動費合計を設定する
     *
     * @param goukeiSenkyoKatsudou 選挙活動費合計
     */
    public void setGoukeiSenkyoKatsudou(final Long goukeiSenkyoKatsudou) {
        this.goukeiSenkyoKatsudou = goukeiSenkyoKatsudou;
    }

    /**
     * 選挙活動費に係る交付金を取得する
     *
     * @return 選挙活動費に係る交付金
     */
    public String getKohfuSenkyoKatsudou() {
        return kohfuSenkyoKatsudou;
    }

    /**
     * 選挙活動費に係る交付金を設定する
     *
     * @param kohfuSenkyoKatsudou 選挙活動費に係る交付金
     */
    public void setKohfuSenkyoKatsudou(final String kohfuSenkyoKatsudou) {
        this.kohfuSenkyoKatsudou = kohfuSenkyoKatsudou;
    }

    /**
     * 選挙活動費備考を取得する
     *
     * @return 選挙活動費備考
     */
    public String getBikouSenkyoKatsudou() {
        return bikouSenkyoKatsudou;
    }

    /**
     * 選挙活動費備考を設定する
     *
     * @param bikouSenkyoKatsudou 選挙活動費備考
     */
    public void setBikouSenkyoKatsudou(final String bikouSenkyoKatsudou) {
        this.bikouSenkyoKatsudou = bikouSenkyoKatsudou;
    }

    /**
     * その他の経費費合計を取得する
     *
     * @return その他の経費費合計
     */
    public Long getGoukeiSonota() {
        return goukeiSonota;
    }

    /**
     * その他の経費費合計を設定する
     *
     * @param goukeiSonota その他の経費費合計
     */
    public void setGoukeiSonota(final Long goukeiSonota) {
        this.goukeiSonota = goukeiSonota;
    }

    /**
     * その他の経費に係る交付金を取得する
     *
     * @return その他の経費に係る交付金
     */
    public String getKohfuSonota() {
        return kohfuSonota;
    }

    /**
     * その他の経費に係る交付金を設定する
     *
     * @param kohfuSonota その他の経費に係る交付金
     */
    public void setKohfuSonota(final String kohfuSonota) {
        this.kohfuSonota = kohfuSonota;
    }

    /**
     * その他の経費備考を取得する
     *
     * @return その他の経費備考
     */
    public String getBikouSonota() {
        return bikouSonota;
    }

    /**
     * その他の経費備考を設定する
     *
     * @param bikouSonota その他の経費備考
     */
    public void setBikouSonota(final String bikouSonota) {
        this.bikouSonota = bikouSonota;
    }

    /**
     * 機関誌発行費合計を取得する
     *
     * @return 機関誌発行費合計
     */
    public Long getGoukeiHakkou() {
        return goukeiHakkou;
    }

    /**
     * 機関誌発行費合計を設定する
     *
     * @param goukeiHakkou 機関誌発行費合計
     */
    public void setGoukeiHakkou(final Long goukeiHakkou) {
        this.goukeiHakkou = goukeiHakkou;
    }

    /**
     * 機関誌発行費に係る交付金を取得する
     *
     * @return 機関誌発行費に係る交付金
     */
    public String getKohfuHakkou() {
        return kohfuHakkou;
    }

    /**
     * 機関誌発行費に係る交付金を設定する
     *
     * @param kohfuHakkou 機関誌発行費に係る交付金
     */
    public void setKohfuHakkou(final String kohfuHakkou) {
        this.kohfuHakkou = kohfuHakkou;
    }

    /**
     * 機関誌発行費備考を取得する
     *
     * @return 機関誌発行費備考
     */
    public String getBikouHakkou() {
        return bikouHakkou;
    }

    /**
     * 機関誌発行費備考を設定する
     *
     * @param bikouHakkou 機関誌発行費備考
     */
    public void setBikouHakkou(final String bikouHakkou) {
        this.bikouHakkou = bikouHakkou;
    }

    /**
     * 宣伝費合計を取得する
     *
     * @return 宣伝費合計
     */
    public Long getGoukeiSenden() {
        return goukeiSenden;
    }

    /**
     * 宣伝費合計を設定する
     *
     * @param goukeiSenden 宣伝費合計
     */
    public void setGoukeiSenden(final Long goukeiSenden) {
        this.goukeiSenden = goukeiSenden;
    }

    /**
     * 宣伝費に係る交付金を取得する
     *
     * @return 宣伝費に係る交付金
     */
    public String getKohfuSenden() {
        return kohfuSenden;
    }

    /**
     * 宣伝費に係る交付金を設定する
     *
     * @param kohfuSenden 宣伝費に係る交付金
     */
    public void setKohfuSenden(final String kohfuSenden) {
        this.kohfuSenden = kohfuSenden;
    }

    /**
     * 宣伝費備考を取得する
     *
     * @return 宣伝費備考
     */
    public String getBikouSenden() {
        return bikouSenden;
    }

    /**
     * 宣伝費備考を設定する
     *
     * @param bikouSenden 宣伝費備考
     */
    public void setBikouSenden(final String bikouSenden) {
        this.bikouSenden = bikouSenden;
    }

    /**
     * パーティ開催費合計を取得する
     *
     * @return パーティ開催費合計
     */
    public Long getGoukeiKaisaiPty() {
        return goukeiKaisaiPty;
    }

    /**
     * パーティ開催費合計を設定する
     *
     * @param goukeiKaisaiPty パーティ開催費合計
     */
    public void setGoukeiKaisaiPty(final Long goukeiKaisaiPty) {
        this.goukeiKaisaiPty = goukeiKaisaiPty;
    }

    /**
     * パーティ開催費に係る交付金を取得する
     *
     * @return パーティ開催費に係る交付金
     */
    public String getKohfuKaisaiPty() {
        return kohfuKaisaiPty;
    }

    /**
     * パーティ開催費に係る交付金を設定する
     *
     * @param kohfuKaisaiPty パーティ開催費に係る交付金
     */
    public void setKohfuKaisaiPty(final String kohfuKaisaiPty) {
        this.kohfuKaisaiPty = kohfuKaisaiPty;
    }

    /**
     * パーティ開催費備考を取得する
     *
     * @return パーティ開催費備考
     */
    public String getBikouKaisaiPty() {
        return bikouKaisaiPty;
    }

    /**
     * パーティ開催費備考を設定する
     *
     * @param bikouKaisaiPty パーティ開催費備考
     */
    public void setBikouKaisaiPty(final String bikouKaisaiPty) {
        this.bikouKaisaiPty = bikouKaisaiPty;
    }

    /**
     * その他事業費合計を取得する
     *
     * @return その他事業費合計
     */
    public Long getGoukeiSonotaJigyou() {
        return goukeiSonotaJigyou;
    }

    /**
     * その他事業費合計を設定する
     *
     * @param goukeiSonotaJigyou その他事業費合計
     */
    public void setGoukeiSonotaJigyou(final Long goukeiSonotaJigyou) {
        this.goukeiSonotaJigyou = goukeiSonotaJigyou;
    }

    /**
     * その他事業費に係る交付金を取得する
     *
     * @return その他事業費に係る交付金
     */
    public String getKohfuSonotaJigyou() {
        return kohfuSonotaJigyou;
    }

    /**
     * その他事業費に係る交付金を設定する
     *
     * @param kohfuSonotaJigyou その他事業費に係る交付金
     */
    public void setKohfuSonotaJigyou(final String kohfuSonotaJigyou) {
        this.kohfuSonotaJigyou = kohfuSonotaJigyou;
    }

    /**
     * その他事業費備考を取得する
     *
     * @return その他事業費備考
     */
    public String getBikouSonotaJigyou() {
        return bikouSonotaJigyou;
    }

    /**
     * その他事業費備考を設定する
     *
     * @param bikouSonotaJigyou その他事業費備考
     */
    public void setBikouSonotaJigyou(final String bikouSonotaJigyou) {
        this.bikouSonotaJigyou = bikouSonotaJigyou;
    }

    /**
     * 調査研究費合計を取得する
     *
     * @return 調査研究費合計
     */
    public Long getGoukeiChousaKenkyu() {
        return goukeiChousaKenkyu;
    }

    /**
     * 調査研究費合計を設定する
     *
     * @param goukeiChousaKenkyu 調査研究費合計
     */
    public void setGoukeiChousaKenkyu(final Long goukeiChousaKenkyu) {
        this.goukeiChousaKenkyu = goukeiChousaKenkyu;
    }

    /**
     * 調査研究費に係る交付金を取得する
     *
     * @return 調査研究費に係る交付金
     */
    public String getKohfuChousaKenkyu() {
        return kohfuChousaKenkyu;
    }

    /**
     * 調査研究費に係る交付金を設定する
     *
     * @param kohfuChousaKenkyu 調査研究費に係る交付金
     */
    public void setKohfuChousaKenkyu(final String kohfuChousaKenkyu) {
        this.kohfuChousaKenkyu = kohfuChousaKenkyu;
    }

    /**
     * 調査研究費備考を取得する
     *
     * @return 調査研究費備考
     */
    public String getBikouChousaKenkyu() {
        return bikouChousaKenkyu;
    }

    /**
     * 調査研究費備考を設定する
     *
     * @param bikouChousaKenkyu 調査研究費備考
     */
    public void setBikouChousaKenkyu(final String bikouChousaKenkyu) {
        this.bikouChousaKenkyu = bikouChousaKenkyu;
    }

    /**
     * 寄付金合計を取得する
     *
     * @return 寄付金合計
     */
    public Long getGoukeiKifukin() {
        return goukeiKifukin;
    }

    /**
     * 寄付金合計を設定する
     *
     * @param goukeiKifukin 寄付金合計
     */
    public void setGoukeiKifukin(final Long goukeiKifukin) {
        this.goukeiKifukin = goukeiKifukin;
    }

    /**
     * 寄付金に係る交付金を取得する
     *
     * @return 寄付金に係る交付金
     */
    public String getKohfuKifukin() {
        return kohfuKifukin;
    }

    /**
     * 寄付金に係る交付金を設定する
     *
     * @param kohfuKifukin 寄付金に係る交付金
     */
    public void setKohfuKifukin(final String kohfuKifukin) {
        this.kohfuKifukin = kohfuKifukin;
    }

    /**
     * 寄付金備考を取得する
     *
     * @return 寄付金備考
     */
    public String getBikouKifukin() {
        return bikouKifukin;
    }

    /**
     * 寄付金備考を設定する
     *
     * @param bikouKifukin 寄付金備考
     */
    public void setBikouKifukin(final String bikouKifukin) {
        this.bikouKifukin = bikouKifukin;
    }

    /**
     * その他経費合計を取得する
     *
     * @return その他経費合計
     */
    public Long getGoukeiSonotaKeihi() {
        return goukeiSonotaKeihi;
    }

    /**
     * その他経費合計を設定する
     *
     * @param goukeiSonotaKeihi その他経費合計
     */
    public void setGoukeiSonotaKeihi(final Long goukeiSonotaKeihi) {
        this.goukeiSonotaKeihi = goukeiSonotaKeihi;
    }

    /**
     * その他経費に係る交付金を取得する
     *
     * @return その他経費に係る交付金
     */
    public String getKohfuSonotaKeihi() {
        return kohfuSonotaKeihi;
    }

    /**
     * その他経費に係る交付金を設定する
     *
     * @param kohfuSonotaKeihi その他経費に係る交付金
     */
    public void setKohfuSonotaKeihi(final String kohfuSonotaKeihi) {
        this.kohfuSonotaKeihi = kohfuSonotaKeihi;
    }

    /**
     * その他経費備考を取得する
     *
     * @return その他経費備考
     */
    public String getBikouSonotaKeihi() {
        return bikouSonotaKeihi;
    }

    /**
     * その他経費備考を設定する
     *
     * @param bikouSonotaKeihi その他経費備考
     */
    public void setBikouSonotaKeihi(final String bikouSonotaKeihi) {
        this.bikouSonotaKeihi = bikouSonotaKeihi;
    }

    /**
     * 活動費合計を取得する
     *
     * @return 活動費合計
     */
    public Long getGoukeiKatsudouhi() {
        return goukeiKatsudouhi;
    }

    /**
     * 活動費合計を設定する
     *
     * @param goukeiKatsudouhi 活動費合計
     */
    public void setGoukeiKatsudouhi(final Long goukeiKatsudouhi) {
        this.goukeiKatsudouhi = goukeiKatsudouhi;
    }

    /**
     * 活動費に係る交付金を取得する
     *
     * @return 活動費に係る交付金
     */
    public String getKohfuKatsudouhi() {
        return kohfuKatsudouhi;
    }

    /**
     * 活動費に係る交付金を設定する
     *
     * @param kohfuKatsudouhi 活動費に係る交付金
     */
    public void setKohfuKatsudouhi(final String kohfuKatsudouhi) {
        this.kohfuKatsudouhi = kohfuKatsudouhi;
    }

    /**
     * 活動費備考を取得する
     *
     * @return 活動費備考
     */
    public String getBikouKatsudouhi() {
        return bikouKatsudouhi;
    }

    /**
     * 活動費備考を設定する
     *
     * @param bikouKatsudouhi 活動費備考
     */
    public void setBikouKatsudouhi(final String bikouKatsudouhi) {
        this.bikouKatsudouhi = bikouKatsudouhi;
    }

    /**
     * 現計全合計を取得する
     *
     * @return 現計全合計
     */
    public Long getGoukeiZenGohkei() {
        return goukeiZenGohkei;
    }

    /**
     * 現計全合計を設定する
     *
     * @param goukeiZenGohkei 現計全合計
     */
    public void setGoukeiZenGohkei(final Long goukeiZenGohkei) {
        this.goukeiZenGohkei = goukeiZenGohkei;
    }

}
