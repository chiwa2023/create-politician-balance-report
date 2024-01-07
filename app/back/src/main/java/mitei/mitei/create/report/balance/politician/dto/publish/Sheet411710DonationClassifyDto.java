package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式17その13 支出項目別金額の内訳を表すワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet411710DonationClassifyDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 人件費項目の合計 */
    @JacksonXmlProperty(localName = "KUBUN")
    private Integer kubun = 0;

    /** 区分3における国会議員情報 */
    @JacksonXmlProperty(localName = "ZEI411713")
    private RowSozei411713SupportingMembersParliamentDto rowSozei411713SupportingMembersParliamentDto;

    /** 区分4における地方議員・首長情報 */
    @JacksonXmlProperty(localName = "ZEI411714")
    private RowSozei411714SupportingLocalLegislatorsDto rowSozei411714SupportingLocalLegislatorsDto;

    /**
     * 団体区分を取得する
     *
     * @return 団体区分
     */
    public Integer getKubun() {
        return kubun;
    }

    /**
     * 団体区分を設定する
     *
     * @param kubun 団体区分
     */
    public void setKubun(final Integer kubun) {
        this.kubun = kubun;
    }

    /**
     * 国会議員情報を取得する
     *
     * @return 国会議員情報
     */
    public RowSozei411713SupportingMembersParliamentDto getRowSozei411713SupportingMembersParliamentDto() {
        return rowSozei411713SupportingMembersParliamentDto;
    }

    /**
     * 国会議員情報を設定する
     *
     * @param rowSozei411713SupportingMembersParliamentDto 国会議員情報
     */
    public void setRowSozei411713SupportingMembersParliamentDto(
            final RowSozei411713SupportingMembersParliamentDto rowSozei411713SupportingMembersParliamentDto) {
        this.rowSozei411713SupportingMembersParliamentDto = rowSozei411713SupportingMembersParliamentDto;
    }

    /**
     * 地方議員・首長立候補情報を取得する
     *
     * @return 地方議員・首長立候補情報
     */
    public RowSozei411714SupportingLocalLegislatorsDto getRowSozei411714SupportingLocalLegislatorsDto() {
        return rowSozei411714SupportingLocalLegislatorsDto;
    }

    /**
     * 地方議員・首長立候補情報を設定する
     *
     * @param rowSozei411714SupportingLocalLegislatorsDto 地方議員・首長立候補情報
     */
    public void setRowSozei411714SupportingLocalLegislatorsDto(
            final RowSozei411714SupportingLocalLegislatorsDto rowSozei411714SupportingLocalLegislatorsDto) {
        this.rowSozei411714SupportingLocalLegislatorsDto = rowSozei411714SupportingLocalLegislatorsDto;
    }

}
