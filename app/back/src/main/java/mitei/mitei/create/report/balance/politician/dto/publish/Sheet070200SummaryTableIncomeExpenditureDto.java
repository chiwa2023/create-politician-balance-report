package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式17その2 収支の総括表を表すワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet070200SummaryTableIncomeExpenditureDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 収入総額 */
    @JacksonXmlProperty(localName = "SYUNYU_SGK")
    private Long shunyuGokei = 0L;

    /** 前年からの繰越額 */
    @JacksonXmlProperty(localName = "ZENNEN_KKS_GK")
    private Long zennenKurikoshi = 0L;

    /** 本年の収入額 */
    @JacksonXmlProperty(localName = "HONNEN_SYUNYU_GK")
    private Long honnenShunyu = 0L;

    /** 支出総額 */
    @JacksonXmlProperty(localName = "SISYUTU_SGK")
    private Long shishutsuGoukei = 0L;

    /** 翌年への繰越額 */
    @JacksonXmlProperty(localName = "YOKUNEN_KKS_GK")
    private Long yokunenKurikoshi = 0L;

    /** 個人の党費または会費を納入金額 */
    @JacksonXmlProperty(localName = "KOJIN_FUTAN_KGK")
    private Long kojiFutanGoukei = 0L;

    /** 党費または会費を納入した員数 */
    @JacksonXmlProperty(localName = "KOJIN_FUTAN_SU")
    private Long kojiFutanSuu = 0L;

    /** 個人寄付の合計 */
    @JacksonXmlProperty(localName = "KOJIN_KIFU_GK")
    private Long kojinKifuGoukei = 0L;

    /** 個人寄付備考 */
    @JacksonXmlProperty(localName = "KOJIN_KIFU_BIKOU")
    private String kojinKifuBikou;

    /** 特定寄付合計 */
    @JacksonXmlProperty(localName = "TOKUTEI_KIFU_GK")
    private Long tokuteiKifuGoukei = 0L;

    /** うち特定寄付備考 */
    @JacksonXmlProperty(localName = "TOKUTEI_KIFU_BIKOU")
    private String tokuteiKifuBikou;

    /** 法人寄付合計 */
    @JacksonXmlProperty(localName = "HOJIN_KIFU_GK")
    private Long houjinKifuGoukei = 0L;

    /** 法人寄付備考 */
    @JacksonXmlProperty(localName = "HOJIN_KIFU_BIKOU")
    private String houjinKifuBiko;

    /** 政治団体寄付合計 */
    @JacksonXmlProperty(localName = "SEIJI_KIFU_GK")
    private Long seijiDantaiKifuGoukei = 0L;

    /** 政治団体寄付備考 */
    @JacksonXmlProperty(localName = "SEIJI_KIFU_BIKOU")
    private String seijiDantaiKifuBikou;

    /** 寄付小計合計 */
    @JacksonXmlProperty(localName = "KIFU_SKEI_GK")
    private Long kifuShoukeiGoukei = 0L;

    /** 寄付小計合計備考 */
    @JacksonXmlProperty(localName = "KIFU_SKEI_BIKOU")
    private String kifuShoukeiBikou;

    /** 寄付のうちあっせんによるもの合計 */
    @JacksonXmlProperty(localName = "ATUSEN_GK")
    private Long assenGoukei = 0L;

    /** 寄付のうちあっせんによるもの合計備考 */
    @JacksonXmlProperty(localName = "ATUSEN_BIKOU")
    private String assenBikou;

    /** 政党匿名寄付の合計 */
    @JacksonXmlProperty(localName = "TOKUMEI_KIFU_GK")
    private Long tokumeiKifuGoukei = 0L;

    /** 政党匿名寄付の合計備考 */
    @JacksonXmlProperty(localName = "TOKUMEI_KIFU_BIKOU")
    private String tokumeiKifuBikou;

    /** 寄付総合計 */
    @JacksonXmlProperty(localName = "KIFU_GKEI_GK")
    private Long kifuSoGoukei = 0L;

    /** 寄付総合計備考 */
    @JacksonXmlProperty(localName = "KIFU_GKEI_BIKOU")
    private String kifuSoGoukeiBikou;

    /**
     * 収入合計を取得する
     *
     * @return 収入合計
     */
    public Long getShunyuGokei() {
        return shunyuGokei;
    }

    /**
     * 収入合計を設定する
     *
     * @param shunyuGokei 収入合計
     */
    public void setShunyuGokei(final Long shunyuGokei) {
        this.shunyuGokei = shunyuGokei;
    }

    /**
     * 前年繰り越し額を取得する
     *
     * @return 前年繰り越し額
     */
    public Long getZennenKurikoshi() {
        return zennenKurikoshi;
    }

    /**
     * 前年繰り越し額を設定する
     *
     * @param zennenKurikoshi 前年繰り越し額
     */
    public void setZennenKurikoshi(final Long zennenKurikoshi) {
        this.zennenKurikoshi = zennenKurikoshi;
    }

    /**
     * 本年収入を取得する
     *
     * @return 本年収入
     */
    public Long getHonnenShunyu() {
        return honnenShunyu;
    }

    /**
     * 本年収入を設定する
     *
     * @param honnenShunyu 本年収入
     */
    public void setHonnenShunyu(final Long honnenShunyu) {
        this.honnenShunyu = honnenShunyu;
    }

    /**
     * 支出合計を取得する
     *
     * @return 支出合計
     */
    public Long getShishutsuGoukei() {
        return shishutsuGoukei;
    }

    /**
     * 支出合計を設定する
     *
     * @param shishutsuGoukei 支出合計
     */
    public void setShishutsuGoukei(final Long shishutsuGoukei) {
        this.shishutsuGoukei = shishutsuGoukei;
    }

    /**
     * 翌年繰り越し額を取得する
     *
     * @return 翌年繰り越し額
     */
    public Long getYokunenKurikoshi() {
        return yokunenKurikoshi;
    }

    /**
     * 翌年繰り越し額を設定する
     *
     * @param yokunenKurikoshi 翌年繰り越し額
     */
    public void setYokunenKurikoshi(final Long yokunenKurikoshi) {
        this.yokunenKurikoshi = yokunenKurikoshi;
    }

    /**
     * 個人負担による党費や会費合計額を取得する
     *
     * @return 個人負担による党費や会費合計額
     */
    public Long getKojiFutanGoukei() {
        return kojiFutanGoukei;
    }

    /**
     * 個人負担による党費や会費合計額を設定する
     *
     * @param kojiFutanGoukei 個人負担による党費や会費合計額
     */
    public void setKojiFutanGoukei(final Long kojiFutanGoukei) {
        this.kojiFutanGoukei = kojiFutanGoukei;
    }

    /**
     * 個人負担員数を取得する
     *
     * @return 個人負担員数
     */
    public Long getKojiFutanSuu() {
        return kojiFutanSuu;
    }

    /**
     * 個人負担員数を設定する
     *
     * @param kojiFutanSuu 個人負担員数
     */
    public void setKojiFutanSuu(final Long kojiFutanSuu) {
        this.kojiFutanSuu = kojiFutanSuu;
    }

    /**
     * 個人寄付額を取得する
     *
     * @return 個人寄付額
     */
    public Long getKojinKifuGoukei() {
        return kojinKifuGoukei;
    }

    /**
     * 個人寄付額を設定する
     *
     * @param kojinKifuGoukei 個人寄付額
     */
    public void setKojinKifuGoukei(final Long kojinKifuGoukei) {
        this.kojinKifuGoukei = kojinKifuGoukei;
    }

    /**
     * 個人寄付額備考を取得する
     *
     * @return 個人寄付額備考
     */
    public String getKojinKifuBikou() {
        return kojinKifuBikou;
    }

    /**
     * 個人寄付額備考を設定する
     *
     * @param kojinKifuBikou 個人寄付額備考
     */
    public void setKojinKifuBikou(final String kojinKifuBikou) {
        this.kojinKifuBikou = kojinKifuBikou;
    }

    /**
     * 特定寄付額を取得する
     *
     * @return 特定寄付額
     */
    public Long getTokuteiKifuGoukei() {
        return tokuteiKifuGoukei;
    }

    /**
     * 特定寄付額を設定する
     *
     * @param tokuteiKifuGoukei 特定寄付額
     */
    public void setTokuteiKifuGoukei(final Long tokuteiKifuGoukei) {
        this.tokuteiKifuGoukei = tokuteiKifuGoukei;
    }

    /**
     * 特定寄付額備考を取得する
     *
     * @return 特定寄付額備考
     */
    public String getTokuteiKifuBikou() {
        return tokuteiKifuBikou;
    }

    /**
     * 特定寄付額備考を設定する
     *
     * @param tokuteiKifuBikou 特定寄付額備考
     */
    public void setTokuteiKifuBikou(final String tokuteiKifuBikou) {
        this.tokuteiKifuBikou = tokuteiKifuBikou;
    }

    /**
     * 法人寄付額を取得する
     *
     * @return 法人寄付額
     */
    public Long getHoujinKifuGoukei() {
        return houjinKifuGoukei;
    }

    /**
     * 法人寄付額を設定する
     *
     * @param houjinKifuGoukei 法人寄付額
     */
    public void setHoujinKifuGoukei(final Long houjinKifuGoukei) {
        this.houjinKifuGoukei = houjinKifuGoukei;
    }

    /**
     * 法人寄付額備考を取得する
     *
     * @return 法人寄付額備考
     */
    public String getHoujinKifuBiko() {
        return houjinKifuBiko;
    }

    /**
     * 法人寄付額備考を設定する
     *
     * @param houjinKifuBiko 法人寄付額備考
     */
    public void setHoujinKifuBiko(final String houjinKifuBiko) {
        this.houjinKifuBiko = houjinKifuBiko;
    }

    /**
     * 政治団体寄付額を取得する
     *
     * @return 政治団体寄付額
     */
    public Long getSeijiDantaiKifuGoukei() {
        return seijiDantaiKifuGoukei;
    }

    /**
     * 政治団体寄付額を設定する
     *
     * @param seijiDantaiKifuGoukei 政治団体寄付額
     */
    public void setSeijiDantaiKifuGoukei(final Long seijiDantaiKifuGoukei) {
        this.seijiDantaiKifuGoukei = seijiDantaiKifuGoukei;
    }

    /**
     * 政治団体寄付額備考を取得する
     *
     * @return 政治団体寄付額備考
     */
    public String getSeijiDantaiKifuBikou() {
        return seijiDantaiKifuBikou;
    }

    /**
     * 政治団体寄付額備考を設定する
     *
     * @param seijiDantaiKifuBikou 政治団体寄付額備考
     */
    public void setSeijiDantaiKifuBikou(final String seijiDantaiKifuBikou) {
        this.seijiDantaiKifuBikou = seijiDantaiKifuBikou;
    }

    /**
     * 寄付小計を取得する
     *
     * @return 寄付小計
     */
    public Long getKifuShoukeiGoukei() {
        return kifuShoukeiGoukei;
    }

    /**
     * 寄付小計を設定する
     *
     * @param kifuShoukeiGoukei 寄付小計
     */
    public void setKifuShoukeiGoukei(final Long kifuShoukeiGoukei) {
        this.kifuShoukeiGoukei = kifuShoukeiGoukei;
    }

    /**
     * 寄付小計備考を取得する
     *
     * @return 寄付小計備考
     */
    public String getKifuShoukeiBikou() {
        return kifuShoukeiBikou;
    }

    /**
     * 寄付小計備考を設定する
     *
     * @param kifuShoukeiBikou 寄付小計備考
     */
    public void setKifuShoukeiBikou(final String kifuShoukeiBikou) {
        this.kifuShoukeiBikou = kifuShoukeiBikou;
    }

    /**
     * 寄付のうちあっせんによるものの額を取得する
     *
     * @return 寄付のうちあっせんによるものの額
     */
    public Long getAssenGoukei() {
        return assenGoukei;
    }

    /**
     * 寄付のうちあっせんによるものの額を設定する
     *
     * @param assenGoukei 寄付のうちあっせんによるものの額
     */
    public void setAssenGoukei(final Long assenGoukei) {
        this.assenGoukei = assenGoukei;
    }

    /**
     * 寄付のうちあっせんによるものの額備考を取得する
     *
     * @return 寄付のうちあっせんによるものの額備考
     */
    public String getAssenBikou() {
        return assenBikou;
    }

    /**
     * 寄付のうちあっせんによるものの額備考を設定する
     *
     * @param assenBikou 寄付のうちあっせんによるものの額備考
     */
    public void setAssenBikou(final String assenBikou) {
        this.assenBikou = assenBikou;
    }

    /**
     * 政党匿名寄付額を取得する
     *
     * @return 政党匿名寄付額
     */
    public Long getTokumeiKifuGoukei() {
        return tokumeiKifuGoukei;
    }

    /**
     * 政党匿名寄付額を設定する
     *
     * @param tokumeiKifuGoukei 政党匿名寄付額
     */
    public void setTokumeiKifuGoukei(final Long tokumeiKifuGoukei) {
        this.tokumeiKifuGoukei = tokumeiKifuGoukei;
    }

    /**
     * 政党匿名寄付額備考を取得する
     *
     * @return 政党匿名寄付額備考
     */
    public String getTokumeiKifuBikou() {
        return tokumeiKifuBikou;
    }

    /**
     * 政党匿名寄付額備考を設定する
     *
     * @param tokumeiKifuBikou 政党匿名寄付額備考
     */
    public void setTokumeiKifuBikou(final String tokumeiKifuBikou) {
        this.tokumeiKifuBikou = tokumeiKifuBikou;
    }

    /**
     * 寄付合計を取得する
     *
     * @return 寄付合計
     */
    public Long getKifuSoGoukei() {
        return kifuSoGoukei;
    }

    /**
     * 寄付合計を設定する
     *
     * @param kifuSoGoukei 寄付合計
     */
    public void setKifuSoGoukei(final Long kifuSoGoukei) {
        this.kifuSoGoukei = kifuSoGoukei;
    }

    /**
     * 寄付合計備考を取得する
     *
     * @return 寄付合計備考
     */
    public String getKifuSoGoukeiBikou() {
        return kifuSoGoukeiBikou;
    }

    /**
     * 寄付合計備考を設定する
     *
     * @param kifuSoGoukeiBikou 寄付合計備考
     */
    public void setKifuSoGoukeiBikou(final String kifuSoGoukeiBikou) {
        this.kifuSoGoukeiBikou = kifuSoGoukeiBikou;
    }

}
