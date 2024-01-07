package mitei.mitei.create.report.balance.politician.dto.publish; // NOPMD

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 全「Book」XMLを表現するDto 互換性のためには…Excelじゃないけど「Book」root必要(笑)
 */
@JacksonXmlRootElement(localName = "BOOK")
public class AllBookDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** ブックヘッダ */
    @JacksonXmlProperty(localName = "HEAD")
    private AllBookHeaderDto allBookHeaderDto;

    /** 入力有無フラグ */
    @JacksonXmlProperty(localName = "SYUUSHI_UMU_FLG")
    private AllBookUmuInputDataDto allBookUmuInputDataDto;

    /** シート1 */
    @JacksonXmlProperty(localName = "SYUUSHI07_01")
    private AllSheet0701CoverAndOrganizationDetailsDto allSheet0701CoverAndOrganizationDetailsDto;

    /** シート2 */
    @JacksonXmlProperty(localName = "SYUUSHI07_02")
    private AllSheet0702SummaryTableIncomeDto allSheet0702SummaryTableIncomeDto;

    /** シート3 */
    @JacksonXmlProperty(localName = "SYUUSHI07_03")
    private AllSheet0703JournalAndOtherDto allSheet0703JournalAndOtherDto;

    /** シート4 */
    @JacksonXmlProperty(localName = "SYUUSHI07_04")
    private AllSheet0704BorrowedMoneyDto allSheet0704BorrowedMoneyDto;

    /** シート5 */
    @JacksonXmlProperty(localName = "SYUUSHI07_05")
    private AllSheet0705IncomeRelatedToGrantsDto allSheet0705IncomeRelatedToGrantsDto;

    /** シート6 */
    @JacksonXmlProperty(localName = "SYUUSHI07_06")
    private AllSheet0706OtherIncomeDto allSheet0706OtherIncomeDto;

    /** シート7 */
    @JacksonXmlProperty(localName = "SYUUSHI07_07")
    private AllSheet0707DonateDto allSheet0707DonateDto;

    /** シート8 */
    @JacksonXmlProperty(localName = "SYUUSHI07_08")
    private AllSheet0708MediationDto allSheet0708MediationDto;

    /** シート9 */
    @JacksonXmlProperty(localName = "SYUUSHI07_09")
    private AllSheet0709AnonymousInPoliticalPartyDto allSheet0709AnonymousInPoliticalPartyDto;

    /** シート10 */
    @JacksonXmlProperty(localName = "SYUUSHI07_10")
    private AllSheet0710SpecificPartyDto allSheet0710SpecificPartyDto;

    /** シート11 */
    @JacksonXmlProperty(localName = "SYUUSHI07_11")
    private AllSheet0711ConsiderationPartyDto allSheet0711ConsiderationPartyDto;

    /** シート12 */
    @JacksonXmlProperty(localName = "SYUUSHI07_12")
    private AllSheet0712PartyMediationDto allSheet0712PartyMediationDto;

    /** シート13 */
    @JacksonXmlProperty(localName = "SYUUSHI07_13")
    private AllSheet0713ListOfExpenditureItemsDto allSheet0713ListOfExpenditureItemsDto;

    /** シート14 */
    @JacksonXmlProperty(localName = "SYUUSHI07_14")
    private AllSheet0714ConstsDto allSheet0714ConstsDto;

    /** シート15 */
    @JacksonXmlProperty(localName = "SYUUSHI07_15")
    private AllSheet0715ExpenseDto allSheet0715ExpenseDto;

    /** シート16 */
    @JacksonXmlProperty(localName = "SYUUSHI07_16")
    private AllSheet0716RelatedToGrantsDtoDto allSheet0716RelatedToGrantsDtoDto;

    /** シート17 */
    @JacksonXmlProperty(localName = "SYUUSHI07_17")
    private AllSheet0717SummaryTableOfAssetsDto allSheet0717SummaryTableOfAssetsDto;

    /** シート18 */
    @JacksonXmlProperty(localName = "SYUUSHI07_18")
    private AllSheet0718AssetsDto allSheet0718AssetsDto;

    /** シート19 */
    @JacksonXmlProperty(localName = "SYUUSHI07_19")
    private AllSheet0719RealEstateDto allSheet0719RealEstateDto;

    /** シート20 */
    @JacksonXmlProperty(localName = "SYUUSHI07_20")
    private AllSheet0720OathDto allSheet0720OathDto;

    /** シート8 */
    @JacksonXmlProperty(localName = "SYUUSHI08")
    private AllSheet0800DifficultCollectReceiptDto allSheet0800DifficultCollectReceiptDto;

    /** シート8の2 */
    @JacksonXmlProperty(localName = "SYUUSHI08_02")
    private AllSheet0802WithdrawalItemsByTransferDto allSheet0802WithdrawalItemsByTransferDto;

    /** 租税特別措置 */
    @JacksonXmlProperty(localName = "SYUUSHI_KIFUKOUJYO")
    private AllSheet411710DonationClassifyDto allSheet411710DonationClassifyDto;

    /**
     * Bookヘッダを取得する
     *
     * @return Bookヘッダ
     */
    public AllBookHeaderDto getAllBookHeaderDto() {
        return allBookHeaderDto;
    }

    /**
     * Bookヘッダ設定する
     *
     * @param allBookHeaderDto Bookヘッダ
     */
    public void setAllBookHeaderDto(final AllBookHeaderDto allBookHeaderDto) {
        this.allBookHeaderDto = allBookHeaderDto;
    }

    /**
     * 入力有無フラグテキストを取得する
     *
     * @return 入力有無フラグテキスト
     */
    public AllBookUmuInputDataDto getAllBookUmuInputDataDto() {
        return allBookUmuInputDataDto;
    }

    /**
     * 入力有無フラグテキスト設定する
     *
     * @param allBookUmuInputDataDto 入力有無フラグテキスト
     */
    public void setAllBookUmuInputDataDto(final AllBookUmuInputDataDto allBookUmuInputDataDto) {
        this.allBookUmuInputDataDto = allBookUmuInputDataDto;
    }

    /**
     * シート1全体を取得する
     *
     * @return シート1全体
     */
    public AllSheet0701CoverAndOrganizationDetailsDto getAllSheet0701CoverAndOrganizationDetailsDto() {
        return allSheet0701CoverAndOrganizationDetailsDto;
    }

    /**
     * シート1全体を設定する
     *
     * @param allSheet0701CoverAndOrganizationDetailsDto シート1全体
     */
    public void setAllSheet0701CoverAndOrganizationDetailsDto(
            final AllSheet0701CoverAndOrganizationDetailsDto allSheet0701CoverAndOrganizationDetailsDto) {
        this.allSheet0701CoverAndOrganizationDetailsDto = allSheet0701CoverAndOrganizationDetailsDto;
    }

    /**
     * シート2全体を取得する
     *
     * @return シート1全体
     */
    public AllSheet0702SummaryTableIncomeDto getAllSheet0702SummaryTableIncomeDto() {
        return allSheet0702SummaryTableIncomeDto;
    }

    /**
     * シート2全体を設定する
     *
     * @param allSheet0702SummaryTableIncomeDto シート2全体
     */
    public void setAllSheet0702SummaryTableIncomeDto(
            final AllSheet0702SummaryTableIncomeDto allSheet0702SummaryTableIncomeDto) {
        this.allSheet0702SummaryTableIncomeDto = allSheet0702SummaryTableIncomeDto;
    }

    /**
     * シート3全体を取得する
     *
     * @return シート3全体
     */
    public AllSheet0703JournalAndOtherDto getAllSheet0703JournalAndOtherDto() {
        return allSheet0703JournalAndOtherDto;
    }

    /**
     * シート3全体を設定する
     *
     * @param allSheet0703JournalAndOtherDto シート3全体
     */
    public void setAllSheet0703JournalAndOtherDto(final AllSheet0703JournalAndOtherDto allSheet0703JournalAndOtherDto) {
        this.allSheet0703JournalAndOtherDto = allSheet0703JournalAndOtherDto;
    }

    /**
     * シート4全体を取得する
     *
     * @return シート4
     */
    public AllSheet0704BorrowedMoneyDto getAllSheet0704BorrowedMoneyDto() {
        return allSheet0704BorrowedMoneyDto;
    }

    /**
     * シート4全体を設定する
     *
     * @param allSheet0704BorrowedMoneyDto シート4全体
     */
    public void setAllSheet0704BorrowedMoneyDto(final AllSheet0704BorrowedMoneyDto allSheet0704BorrowedMoneyDto) {
        this.allSheet0704BorrowedMoneyDto = allSheet0704BorrowedMoneyDto;
    }

    /**
     * シート5全体を取得する
     *
     * @return シート5全体
     */
    public AllSheet0705IncomeRelatedToGrantsDto getAllSheet0705IncomeRelatedToGrantsDto() {
        return allSheet0705IncomeRelatedToGrantsDto;
    }

    /**
     * シート5全体を設定する
     *
     * @param allSheet0705IncomeRelatedToGrantsDto シート5全体
     */
    public void setAllSheet0705IncomeRelatedToGrantsDto(
            final AllSheet0705IncomeRelatedToGrantsDto allSheet0705IncomeRelatedToGrantsDto) {
        this.allSheet0705IncomeRelatedToGrantsDto = allSheet0705IncomeRelatedToGrantsDto;
    }

    /**
     * シート6全体を取得する
     *
     * @return シート6全体
     */
    public AllSheet0706OtherIncomeDto getAllSheet0706OtherIncomeDto() {
        return allSheet0706OtherIncomeDto;
    }

    /**
     * シート6全体を設定する
     *
     * @param allSheet0706OtherIncomeDto シート6全体
     */
    public void setAllSheet0706OtherIncomeDto(final AllSheet0706OtherIncomeDto allSheet0706OtherIncomeDto) {
        this.allSheet0706OtherIncomeDto = allSheet0706OtherIncomeDto;
    }

    /**
     * シート7全体を取得する
     *
     * @return シート7全体
     */
    public AllSheet0707DonateDto getAllSheet0707DonateDto() {
        return allSheet0707DonateDto;
    }

    /**
     * シート7全体を設定する
     *
     * @param allSheet0707DonateDto シート7全体
     */
    public void setAllSheet0707DonateDto(final AllSheet0707DonateDto allSheet0707DonateDto) {
        this.allSheet0707DonateDto = allSheet0707DonateDto;
    }

    /**
     * シート8全体を取得する
     *
     * @return シート8全体
     */
    public AllSheet0708MediationDto getAllSheet0708MediationDto() {
        return allSheet0708MediationDto;
    }

    /**
     * シート8全体を設定する
     *
     * @param allSheet0708MediationDto シート8全体
     */
    public void setAllSheet0708MediationDto(final AllSheet0708MediationDto allSheet0708MediationDto) {
        this.allSheet0708MediationDto = allSheet0708MediationDto;
    }

    /**
     * シート9全体を取得する
     *
     * @return シート9全体
     */
    public AllSheet0709AnonymousInPoliticalPartyDto getAllSheet0709AnonymousInPoliticalPartyDto() {
        return allSheet0709AnonymousInPoliticalPartyDto;
    }

    /**
     * シート9全体を設定する
     *
     * @param allSheet0709AnonymousInPoliticalPartyDto シート9全体
     */
    public void setAllSheet0709AnonymousInPoliticalPartyDto(
            final AllSheet0709AnonymousInPoliticalPartyDto allSheet0709AnonymousInPoliticalPartyDto) {
        this.allSheet0709AnonymousInPoliticalPartyDto = allSheet0709AnonymousInPoliticalPartyDto;
    }

    /**
     * シート10全体を取得する
     *
     * @return シート10全体
     */
    public AllSheet0710SpecificPartyDto getAllSheet0710SpecificPartyDto() {
        return allSheet0710SpecificPartyDto;
    }

    /**
     * シート10全体を設定する
     *
     * @param allSheet0710SpecificPartyDto シート10全体
     */
    public void setAllSheet0710SpecificPartyDto(final AllSheet0710SpecificPartyDto allSheet0710SpecificPartyDto) {
        this.allSheet0710SpecificPartyDto = allSheet0710SpecificPartyDto;
    }

    /**
     * シート11全体を取得する
     *
     * @return シート11全体
     */
    public AllSheet0711ConsiderationPartyDto getAllSheet0711ConsiderationPartyDto() {
        return allSheet0711ConsiderationPartyDto;
    }

    /**
     * シート11全体を設定する
     *
     * @param allSheet0711ConsiderationPartyDto シート11全体
     */
    public void setAllSheet0711ConsiderationPartyDto(
            final AllSheet0711ConsiderationPartyDto allSheet0711ConsiderationPartyDto) {
        this.allSheet0711ConsiderationPartyDto = allSheet0711ConsiderationPartyDto;
    }

    /**
     * シート12全体を取得する
     *
     * @return シート12全体
     */
    public AllSheet0712PartyMediationDto getAllSheet0712PartyMediationDto() {
        return allSheet0712PartyMediationDto;
    }

    /**
     * シート12全体を設定する
     *
     * @param allSheet0712PartyMediationDto シート12全体
     */
    public void setAllSheet0712PartyMediationDto(final AllSheet0712PartyMediationDto allSheet0712PartyMediationDto) {
        this.allSheet0712PartyMediationDto = allSheet0712PartyMediationDto;
    }

    /**
     * シート13全体を取得する
     *
     * @return シート13全体
     */
    public AllSheet0713ListOfExpenditureItemsDto getAllSheet0713ListOfExpenditureItemsDto() {
        return allSheet0713ListOfExpenditureItemsDto;
    }

    /**
     * シート13全体を設定する
     *
     * @param allSheet0713ListOfExpenditureItemsDto シート13全体
     */
    public void setAllSheet0713ListOfExpenditureItemsDto(
            final AllSheet0713ListOfExpenditureItemsDto allSheet0713ListOfExpenditureItemsDto) {
        this.allSheet0713ListOfExpenditureItemsDto = allSheet0713ListOfExpenditureItemsDto;
    }

    /**
     * シート14全体を取得する
     *
     * @return シート14全体
     */
    public AllSheet0714ConstsDto getAllSheet0714ConstsDto() {
        return allSheet0714ConstsDto;
    }

    /**
     * シート14全体を設定する
     *
     * @param allSheet0714ConstsDto シート14全体
     */
    public void setAllSheet0714ConstsDto(final AllSheet0714ConstsDto allSheet0714ConstsDto) {
        this.allSheet0714ConstsDto = allSheet0714ConstsDto;
    }

    /**
     * シート15全体を取得する
     *
     * @return シート15全体
     */
    public AllSheet0715ExpenseDto getAllSheet0715ExpenseDto() {
        return allSheet0715ExpenseDto;
    }

    /**
     * シート15全体を設定する
     *
     * @param allSheet0715ExpenseDto シート15全体
     */
    public void setAllSheet0715ExpenseDto(final AllSheet0715ExpenseDto allSheet0715ExpenseDto) {
        this.allSheet0715ExpenseDto = allSheet0715ExpenseDto;
    }

    /**
     * シート16全体を取得する
     *
     * @return シート16全体
     */
    public AllSheet0716RelatedToGrantsDtoDto getAllSheet0716RelatedToGrantsDtoDto() {
        return allSheet0716RelatedToGrantsDtoDto;
    }

    /**
     * シート16全体を設定する
     *
     * @param allSheet0716RelatedToGrantsDtoDto シート16全体
     */
    public void setAllSheet0716RelatedToGrantsDtoDto(
            final AllSheet0716RelatedToGrantsDtoDto allSheet0716RelatedToGrantsDtoDto) {
        this.allSheet0716RelatedToGrantsDtoDto = allSheet0716RelatedToGrantsDtoDto;
    }

    /**
     * シート17全体を取得する
     *
     * @return シート17全体
     */
    public AllSheet0717SummaryTableOfAssetsDto getAllSheet0717SummaryTableOfAssetsDto() {
        return allSheet0717SummaryTableOfAssetsDto;
    }

    /**
     * シート17全体を設定する
     *
     * @param allSheet0717SummaryTableOfAssetsDto シート17全体
     */
    public void setAllSheet0717SummaryTableOfAssetsDto(
            final AllSheet0717SummaryTableOfAssetsDto allSheet0717SummaryTableOfAssetsDto) {
        this.allSheet0717SummaryTableOfAssetsDto = allSheet0717SummaryTableOfAssetsDto;
    }

    /**
     * シート18全体を取得する
     *
     * @return シート18全体
     */
    public AllSheet0718AssetsDto getAllSheet0718AssetsDto() {
        return allSheet0718AssetsDto;
    }

    /**
     * シート18全体を設定する
     *
     * @param allSheet0718AssetsDto シート18全体
     */
    public void setAllSheet0718AssetsDto(final AllSheet0718AssetsDto allSheet0718AssetsDto) {
        this.allSheet0718AssetsDto = allSheet0718AssetsDto;
    }

    /**
     * シート19全体を取得する
     *
     * @return シート19全体
     */
    public AllSheet0719RealEstateDto getAllSheet0719RealEstateDto() {
        return allSheet0719RealEstateDto;
    }

    /**
     * シート19全体を設定する
     *
     * @param allSheet0719RealEstateDto シート19全体
     */
    public void setAllSheet0719RealEstateDto(final AllSheet0719RealEstateDto allSheet0719RealEstateDto) {
        this.allSheet0719RealEstateDto = allSheet0719RealEstateDto;
    }

    /**
     * シート20全体を取得する
     *
     * @return シート20全体
     */
    public AllSheet0720OathDto getAllSheet0720OathDto() {
        return allSheet0720OathDto;
    }

    /**
     * シート20全体を設定する
     *
     * @param allSheet0720OathDto シート20全体
     */
    public void setAllSheet0720OathDto(final AllSheet0720OathDto allSheet0720OathDto) {
        this.allSheet0720OathDto = allSheet0720OathDto;
    }

    /**
     * シート様式8全体を取得する
     *
     * @return シート様式8全体
     */
    public AllSheet0800DifficultCollectReceiptDto getAllSheet0800DifficultCollectReceiptDto() {
        return allSheet0800DifficultCollectReceiptDto;
    }

    /**
     * シート様式8全体を設定する
     *
     * @param allSheet0800DifficultCollectReceiptDto シート様式8全体
     */
    public void setAllSheet0800DifficultCollectReceiptDto(
            final AllSheet0800DifficultCollectReceiptDto allSheet0800DifficultCollectReceiptDto) {
        this.allSheet0800DifficultCollectReceiptDto = allSheet0800DifficultCollectReceiptDto;
    }

    /**
     * シート様式8その2を取得する
     *
     * @return シート様式8その2
     */
    public AllSheet0802WithdrawalItemsByTransferDto getAllSheet0802WithdrawalItemsByTransferDto() {
        return allSheet0802WithdrawalItemsByTransferDto;
    }

    /**
     * シート様式8その2を設定する
     *
     * @param allSheet0802WithdrawalItemsByTransferDto シート様式8その2
     */
    public void setAllSheet0802WithdrawalItemsByTransferDto(
            final AllSheet0802WithdrawalItemsByTransferDto allSheet0802WithdrawalItemsByTransferDto) {
        this.allSheet0802WithdrawalItemsByTransferDto = allSheet0802WithdrawalItemsByTransferDto;
    }

    /**
     * 寄付控除団体情報シートを取得する
     *
     * @return 寄付控除団体情報シート
     */
    public AllSheet411710DonationClassifyDto getAllSheet411710DonationClassifyDto() {
        return allSheet411710DonationClassifyDto;
    }

    /**
     * 寄付控除団体情報シートを設定する
     *
     * @param allSheet411710DonationClassifyDto 寄付控除団体情報シート
     */
    public void setAllSheet411710DonationClassifyDto(
            final AllSheet411710DonationClassifyDto allSheet411710DonationClassifyDto) {
        this.allSheet411710DonationClassifyDto = allSheet411710DonationClassifyDto;
    }

}
