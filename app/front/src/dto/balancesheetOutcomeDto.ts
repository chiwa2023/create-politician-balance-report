import SelectOptionInterface from "./selectOptionDto";

/**
 *収支報告書支出データInterface
 *
 * @export
 * @interface BalancesheetOutcomeInterface
 */
export default interface BalancesheetOutcomeInterface {
    /** 書証Id */
    shoushoId: string;

    /** 書証識別コード */
    shoushoHistroyCode: number;

    /** 書証区分 */
    shoushoKbn: number;

    /** 参照した摘要 */
    referDigest: string;

    /** 入力済項目編集区分 */
    isEditAutoInput: boolean;

    /** 収支報告区分 */
    reportKbn: number;

    /** 様式仕訳区分 */
    yoshikiKbn: string;

    /** 様式仕訳枝項目区分 */
    yoshikiEdaKbn: string;

    /** 様式仕訳枝項目区分個別用選択リスト */
    yoshikiEdaKbnOptions: SelectOptionInterface[];

    /** 取引金額 */
    amount: number;

    /** 発生日 */
    accrualDate: string;

    /** 支出大項目 */
    categorizeGroup: string;

    /** 支出項目 */
    itemName: string;

    /** 氏名・団体名称 */
    shimeiOrgnizationName: string;

    /** 団体住所 */
    orgnizationAddress: string;

    /** 備考 */
    biko: string;

    /** 交付金に係る支出 */
    isExpendituresRelatedGrants: boolean;

    /** 領収書を徴しがたかったもの */
    notCollectReciptKbn: number;

    /** 意見付記 */
    note: string;

    /** 前例と異なる処理フラグ */
    isDifferPrecedent: boolean;

    /** 保全証票リスト */
    storagedDocumentIdList: string[];
}

/**
 *収支報告書支出データDto
 *
 * @export
 * @class BalancesheetIncomeDto
 * @implements {BalancesheetOutcomeInterface}
 */
export default class BalancesheetIncomeDto implements BalancesheetOutcomeInterface {

    /** 書証Id */
    shoushoId: string;

    /** 書証識別コード */
    shoushoHistroyCode: number;

    /** 書証区分 */
    shoushoKbn: number;

    /** 参照した摘要 */
    referDigest: string;

    /** 入力済項目編集区分 */
    isEditAutoInput: boolean;

    /** 収支報告区分 */
    reportKbn: number;

    /** 様式仕訳区分 */
    yoshikiKbn: string;

    /** 様式仕訳枝項目区分 */
    yoshikiEdaKbn: string;

    /** 様式仕訳枝項目区分個別用選択リスト */
    yoshikiEdaKbnOptions: SelectOptionInterface[];

    /** 取引金額 */
    amount: number;

    /** 発生日 */
    accrualDate: string;

    /** 支出大項目 */
    categorizeGroup: string;

    /** 支出項目 */
    itemName: string;

    /** 氏名・団体名称 */
    shimeiOrgnizationName: string;

    /** 団体住所 */
    orgnizationAddress: string;

    /** 備考 */
    biko: string;

    /** 交付金に係る支出 */
    isExpendituresRelatedGrants: boolean;

    /** 領収書を徴しがたかったもの */
    notCollectReciptKbn: number;

    /** 意見付記 */
    note: string;

    /** 前例と異なる処理フラグ */
    isDifferPrecedent: boolean;

    /** 保全証票リスト */
    storagedDocumentIdList: string[];



    /** 様式区分使用フラグ */
    isUseYoshikiKbn: boolean;
    /** 様式区分小項目使用フラグ */
    isUseYoshikiEdaKbn: boolean;
    /** 項目名称使用フラグ */
    isUseItemName: boolean;
    /** 組織名称使用フラグ */
    isUseOrgName: boolean;
    /** 団体住所使用フラグ */
    isUseAddress: boolean;
    /** カテゴリ分類使用フラグ */
    isUseCategorizedGroup: boolean;
    /** 備考使用フラグ */
    isUseBiko: boolean;
    /** 交付金に係る使用フラグ */
    isUseRelatedGrants: boolean;
    /** 領収書を徴しがたかったもの使用フラグ */
    isUseCollectRecipt: boolean;

    /**
     * Creates an instance of BalancesheetIncomeDto.
     * @memberof BalancesheetIncomeDto
     */
    constructor() {
        this.shoushoId = "";
        this.shoushoHistroyCode = 0;
        this.shoushoKbn = 0;
        this.referDigest = "ﾌﾘｺﾐ ｼｴﾝｼｬﾊﾅｺ";
        this.isEditAutoInput = false;
        this.reportKbn = 11;
        this.yoshikiKbn = "3";
        this.yoshikiEdaKbn = "1";
        this.yoshikiEdaKbnOptions = [];
        this.amount = 6000;
        this.accrualDate = "2022-01-01";
        this.categorizeGroup = "パーティA";
        this.shimeiOrgnizationName = "政治団体　一郎";
        this.itemName = "政治団体　四郎";
        this.orgnizationAddress = "東京都千代田区霞が関";
        this.biko = "備考";
        this.isExpendituresRelatedGrants = false;
        this.note = "意見付記";
        this.isDifferPrecedent = false;
        this.notCollectReciptKbn = 3;
        this.storagedDocumentIdList = [];
        this.isUseYoshikiKbn = true;
        this.isUseYoshikiEdaKbn = true;
        this.isUseOrgName = true;
        this.isUseItemName = true;
        this.isUseAddress = true;
        this.isUseCategorizedGroup = true;
        this.isUseBiko = true;
        this.isUseCollectRecipt = true;
        this.isUseRelatedGrants = true;
    }
}