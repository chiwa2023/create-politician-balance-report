/**
 * 収支報告書収入情報Interface
 *
 * @export
 * @interface BalancesheetIncomeInterface
 */
export default interface BalancesheetIncomeInterface {
    /** 読み取り時の行 */
    readingLine: number;

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

    /** 取引金額 */
    amount: number;

    /** 発生日 */
    accrualDate: string;

    /** 集めた期間開始日 */
    mediationStartDate: string;

    /** 集めた期間終了日 */
    mediationEndDate: string;

    /** パーティ開催日 */
    partyDate: string;

    /** 氏名・団体名称 */
    shimeiOrgnizationName: string;

    /** 項目名称 */
    itemName: string;

    /** 個人・団体住所 */
    orgnizationAddress: string;

    /** 備考 */
    biko: string;

    /** 税額控除有無 */
    isCreditTax: boolean;

    /** 寄付が遺贈有無フラグ */
    isBequest:boolean;

    /** 寄付法人が上場または外資50%超え会社有無フラグ */
    isPrimeListedOrForeign:boolean;

    /** 政治資金パーティ名称 */
    partyName: string;

    /** 意見付記 */
    note: string;

    /** 前例と異なる処理フラグ */
    isDifferPrecedent: boolean;

    /** 保全証票リスト */
    storagedDocumentIdList: string[];

// eslint-disable-next-line semi
}

/**
 * 収支報告書収入情報Dto
 *
 * @export
 * @class BalancesheetIncomeDto
 * @implements {BalancesheetIncomeInterface}
 */
export default class BalancesheetIncomeDto implements BalancesheetIncomeInterface {

    /** 読み取り時の行 */
    readingLine: number;

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

    /** 取引金額 */
    amount: number;

    /** 発生日 */
    accrualDate: string;

    /** 集めた期間開始日 */
    mediationStartDate: string;

    /** 集めた期間終了日 */
    mediationEndDate: string;

    /** パーティ開催日 */
    partyDate: string;

    /** 氏名・団体名称 */
    shimeiOrgnizationName: string;

    /** 項目名称 */
    itemName: string;

    /** 個人・団体住所 */
    orgnizationAddress: string;

    /** 備考 */
    biko: string;

    /** 税額控除有無 */
    isCreditTax: boolean;

    /** 寄付が遺贈有無フラグ */
    isBequest:boolean;

    /** 寄付法人が上場または外資50%超え会社有無フラグ */
    isPrimeListedOrForeign:boolean;

    /** 政治資金パーティ名称 */
    partyName: string;

    /** 意見付記 */
    note: string;

    /** 前例と異なる処理フラグ */
    isDifferPrecedent: boolean;

    /** 保全証票リスト */
    storagedDocumentIdList: string[];

    /** 様式仕訳区分使用フラグ */
    isUseYoshikiKbn: boolean;
    /** 様式仕訳枝項目区分使用フラグ */
    isUseYoshikiEdaKbn: boolean;
    /** あっせん(期間)使用フラグ */
    isUseMediation: boolean;
    /** 項目名使用フラグ */
    isUseItemName: boolean;
    /** 組織・個人名使用フラグ */
    isUseOrgName: boolean;
    /** 個人・組織住所使用フラグ */
    isUseAddress: boolean;
    /** 政治資金パーティ開催日使用フラグ */
    isUsePartyDate: boolean;
    /** 備考使用フラグ */
    isUseBiko: boolean;
    /** 税額控除使用フラグ */
    isUseCreditTax: boolean;
    /** パーティ名称使用フラグ */
    isUsePartyName: boolean;
    /** 寄付遺贈使用フラグ */
    isUseBequest:boolean;
    /** 上場会社または50%外資会社使用フラグ */
    isUsePrimeListedOrForeign:boolean;

    /** 項目名称入力内容示唆*/
    attentionItemName: string;
    /** 個人・組織名称入力内容示唆 */
    attentionOrgName: string;
    /** 個人・組織住所入力内容示唆 */
    attentionAddress: string;
    /** 期間入力内容示唆 */
    attentionMediation: string;
    /** パーティ日付入力内容示唆 */
    attentionPartyDate: string;
    /** 税額控除内容示唆 */
    attentionCreditTax: string;
    /** パーティ名称名称入力内容示唆 */
    attentionPartyName: string;

    constructor() {
        this.readingLine=0;
        this.shoushoId = "";
        this.shoushoHistroyCode = 0;
        this.shoushoKbn = 0;
        this.referDigest = "ﾌﾘｺﾐ ｼｴﾝｼｬﾊﾅｺ";
        this.isEditAutoInput = false;
        this.reportKbn = 11;
        this.yoshikiKbn = "3";
        this.yoshikiEdaKbn = "1";
        this.amount = 6000;
        this.accrualDate = "2022-01-01";
        this.mediationStartDate = "2022-01-01";
        this.mediationEndDate = "2022-01-01";
        this.shimeiOrgnizationName = "政治団体　一郎";
        this.itemName = "政治団体　四郎";
        this.orgnizationAddress = "東京都千代田区霞が関";
        this.partyDate = "2022-01-01";
        this.biko = "備考";
        this.isCreditTax = false;
        this.partyName = "パーティ名称";
        this.isBequest=false;
        this.isPrimeListedOrForeign=false;
        this.note = "意見付記";
        this.isDifferPrecedent = false;
        this.storagedDocumentIdList=[];
        this.isUseYoshikiKbn = true;
        this.isUseYoshikiEdaKbn = true;
        this.isUseMediation = true;
        this.isUseOrgName = true;
        this.isUseItemName = true;
        this.isUseAddress = true;
        this.isUsePartyDate = true;
        this.isUseBiko = true;
        this.isUseCreditTax = true;
        this.isUsePartyName = true;
        this.isUseBequest=false;
        this.isUsePrimeListedOrForeign=false;
        this.attentionItemName = "";
        this.attentionOrgName = "";
        this.attentionAddress = "";
        this.attentionMediation = "";
        this.attentionPartyDate = "";
        this.attentionCreditTax = "";
        this.attentionPartyName = "";
    }
}