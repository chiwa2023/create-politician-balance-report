export default interface BalancesheetIncomeInterface {
    isDifferPrecedent: boolean;

}


export default class BalancesheetIncomeDto implements BalancesheetIncomeInterface {

    //| 書証Id                 | 物理名           | String                      | 書証を一意に識別するId                                                               |
    shoushoId: string;

    //| 書証識別コード         | 物理名           | Long                        | 編集履歴を把握するための識別コード                                                   |
    shoushoHistroyCode: number;

    //| 書証区分               | 物理名           | Integer                     | 例示「1:口座振り込み」「2:領収書(レシート)」                                         |
    shoushoKbn: number;

    //参照した摘要
    referDigest: string;

    //| 入力済項目編集区分     | 物理名           | Boolean                     | 例示「false:自動入力部分を編集していない」「true:自動入力部分を編集している」        |
    isEditAutoInput: boolean;

    //| 収支報告区分           | 物理名           | Integer                     | 収支報告選択入力を受け付けること                                                     |
    reportKbn: number;

    //| 様式仕訳区分           | 物理名           | Integer                     | 収支仕訳(大項目)選択を受け付けること                                                 |
    yoshikiKbn: string;

    //| 様式仕訳枝項目区分     | 物理名           | Integer                     | 収支仕訳(枝別れ項目)選択を受け付けること                                             |
    yoshikiEdaKbn: string;

    //| 取引金額               | 物理名           | Long                        | 取引金額を表示すること                                                               |
    amount: number;

    //| 発生日                 | 物理名           | LocalDate                   | 発生日を表示すること                                                                 |
    accrualDate: string;

    //| 集めた期間開始日       | 物理名           | LocalDate                   | 選択された項目が期間入力を必要とする場合に表示<br>期間の開始日を表示すること         |
    mediationStartDate: string;

    //| 集めた期間終了日       | 物理名           | LocalDate                   | 選択された項目が期間入力を必要とする場合に表示<br>期間の終了日を表示すること         |
    mediationEndDate: string;

    partyDate: string;

    //| 氏名・団体名称         | 物理名           | String                      | 選択された項目が氏名・名称入力を必要とする場合に表示<br>名称を表示すること           |
    shimeiOrgnizationName: string;

    //| 氏名名称               | 物理名           | String                      | 選択された項目が団体の名称とその氏名入力を必要とする場合に表示<br>氏名を表示すること |
    itemName: string;

    //| 団体住所               | 物理名           | String                      | 選択された項目が団体の住所入力を必要とする場合に表示<br>団体の住所を表示すること     |
    orgnizationAddress: string;

    //| 備考                   | 物理名           | String                      | 備考を表示すること                                                                   |
    biko: string;

    //| 税額控除有無           | 物理名           | Boolean                     | 税額控除の有無入力を受け付けること                                                   |
    isCreditTax: boolean;

    //寄付が遺贈の有無
    isBequest:boolean;

    //寄付法人が上場または外資50%超え会社からかどうか
    isPrimeListedOrForeign;

    //政治資金パーティ名称
    partyName: string;


    //| 意見付記               | 物理名           | String                      | 最新の意見付記の入力を受け付けること                                                 |
    note: string;

    //| 前例と異なる処理フラグ | 物理名           | Boolean                     | この処理が前例と異なっていることの入力を受け付けること                               |
    isDifferPrecedent: boolean;

    //| 保全証票リスト         | listSaveShohyoId | ArrayLst<保全証票Id:String> | この証票に関連した証票をストレージに保存した時に発行された、一意に証票を識別するId   |

    isUseYoshikiKbn: boolean;
    isUseYoshikiEdaKbn: boolean;
    isUseMediation: boolean;
    isUseItemName: boolean;
    isUseOrgName: boolean;
    isUseAddress: boolean;
    isUsePartyDate: boolean;
    isUseBiko: boolean;
    isUseCreditTax: boolean;
    isUsePartyName: boolean;
    isUseBequest:boolean;
    isUsePrimeListedOrForeign:boolean;

    attentionItemName: string;
    attentionOrgName: string;
    attentionAddress: string;
    attentionMediation: string;
    attentionPartyDate: string;
    attentionCreditTax: string;
    attentionPartyName: string;

    constructor() {
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
        //| 保全証票リスト         | listSaveShohyoId | ArrayLst<保全証票Id:String> | この証票に関連した証票をストレージに保存した時に発行された、一意に証票を識別するId   |
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