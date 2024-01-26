package mitei.mitei.create.report.balance.politician.dto.report_item;

/**
 * 全銀フォーマット定数
 */
public final class ZenginFormatConstants {
    
    private ZenginFormatConstants() {
        
    }
    
    /**
     * 口座種目名称を取得する
     *
     * @param type 口座種目(数字1桁)
     * @return 口座種目名称
     */
    public static String getDepositTypeLabel(final int type) { // CHECKSTYLE:OFF

        switch (type) {
            // 1:普通預金
            case DepositType.ORDINALY:
                return "普通預金";
            // 2:当座預金
            case DepositType.CURRENT:
                return "当座預金";
            // 3：納税準備預金
            case DepositType.TAX_RESERVE:
                return "納税準備預金";
            // 4:貯蓄預金
            case DepositType.SAVING:
                return "貯蓄預金";
            // 5：通知預金
            case DepositType.NOTICE:
                return "通知預金";
            // 6：定期預金
            case DepositType.FIXED:
                return "定期預金";
            // 7：積立定期預金
            case DepositType.ACCUMULATED_FIXED:
                return "積立定期預金";
            // 8：定期積金
            case DepositType.REGULAR:
                return "定期積金";
            // 9：その他
            case DepositType.OtHER:
                return "その他";
            default:
                throw new IllegalArgumentException("口座種目指定でない値が入力されました");
        }
    }


    /**
     * データ区分
     */
    public final class DataKbn { // NOPMD DataClass
        /** ヘッダ */
        public static final int HEADER = 1;
        /** データ */
        public static final int DATA = 2;
        /** トレーラ */
        public static final int TRAILER = 8;
        /** エンド */
        public static final int END = 9;
    }

    /**
     * 業務種別
     */
    public final class BusinessType { // NOPMD DataClass

        /** 01：振込入金通知 */
        public static final String PAYMENT_NOTIFICATION = "01";

        /** 03：入出金取引明細 */
        public static final String DEPOSIT_WITHDRAL_DETAIL = "03";

        /** 04：残高通知 */
        public static final String BALANCE_NOTIFICATION = "04";

        /** 11：給与振込（民間） */
        public static final String SALARY_PRIVATE = "11";

        /** 12：賞与振込(民間) */
        public static final String BONUS_PRIVATE = "12";

        /** 21:総合振込 */
        public static final String GENERAL = "21";

        /** 41：株式配当金振込 */
        public static final String STOCK_DIVIDEND = "41";

        /** 43：年金信託契約に係る年金・一時金給付金振込 */
        public static final String PENSION = "43";

        /** 44：公的年金保険の年金・一時金給付金振込 */
        public static final String PENSION_PUBLIC = "44";

        /** 45：医療保険の給付金振込 */
        public static final String MEDICAL_INSURERANCE = "45";

        /** 71：給与振込(地方公務員) */
        public static final String SALARY_LOCAL_GOV = "71";

        /** 72：賞与振込(地方公務員) */
        public static final String BONUS_LOCAL_GOV = "72";

        /** 91：預金口座振替 */
        public static final String TRANSFER_OUTCOME = "91";

        /** 93：預金口座振替変更通知 */
        public static final String CHANGE_ACCOUNT = "93";

        /** 98：振込口座照会依頼 */
        public static final String INQUIRY_REQUEST = "98";

        /** 99：振込口座照会結果 */
        public static final String INQUIRY_RESULT = "99";

        // 住宅ローン関係(財形ローン):11
        // 住宅ローン関係(その他):12
        // 財形貯蓄関係(依頼明細):00
        // 財形貯蓄関係(処理結果明細:積立内容):01
        // 財形貯蓄関係(処理結果明細:利子補給):02
        // 財形貯蓄関係(処理結果明細:その他) :09
        // 借入金計算書:31
        // 借入金残高明細:32
        // 借入金残高合:33
        // 外国為替取引明細(会計性):25
        // 外国為替取引明細(非会計性):26
        // 外国為替関連情報:27
        // 外国送金依頼:35
        // 荷為替輸入信用状発行依頼:28
        // 外貨預金入出金取引明細:09
    }

    /**
     * コード区分
     */
    public final class CodeKbn {

        /** 0:JIS */
        public static final int JIS = 0;

        /** 1:EBCDIC */
        public static final int EBCDIC = 1;

    }

    /**
     * 口座種別
     */
    public final class DepositType { // NOPMD DataClass

        /** 1:普通預金 */
        public static final int ORDINALY = 1;

        /** 2:当座預金 */
        public static final int CURRENT = 2;

        /** 3：納税準備預金 */
        public static final int TAX_RESERVE = 3;

        /** 4:貯蓄預金 */
        public static final int SAVING = 4;

        /** 5：通知預金 */
        public static final int NOTICE = 5;

        /** 6：定期預金 */
        public static final int FIXED = 6;

        /** 7：積立定期預金 */
        public static final int ACCUMULATED_FIXED = 7;

        /** 8：定期積金 */
        public static final int REGULAR = 8;

        /** 9：その他 */
        public static final int OtHER = 9;

    }

    /**
     * 取消区分
     */
    public final class CancellingKbn {

        /** 1:取消 */
        public static final int CANCEL = 1;

    }

    /**
     * 貸越区分
     */
    public final class OverdraftKbn {

        /** 1:プラス */
        public static final int PLUS = 1;

        /** 2:マイナス */
        public static final int MINUS = 2;

    }

    /**
     * 通帳区分
     */
    public final class PassbookKbn {

        /** 1:通帳 */
        public static final int BOOK = 1;

        /** 2:証書 */
        public static final int CERTIFICATE = 2;

    }

    /**
     * 入払区分
     */
    public final class DepositWithdralKbn {

        /** 1：入金 */
        public static final int INCOME = 1;

        /** 2：出金 */
        public static final int OUTCOME = 2;
    }

    /**
     * 取引区分
     */
    public final class TradingKbn { // NOPMD DataClass

        /** 10：現金 */
        public static final String CASH = "10";

        /** 11：振込 */
        public static final String TRANSFER_INCOME = "11";

        /** 12：他店券入金 */
        public static final String OTHER_STORE_TICKET = "12";

        /** 13：交換（取立入金および交換払） */
        public static final String EXCHANGE = "13";

        /** 14：振替 */
        public static final String TRANSFER_OUTCOME = "14";

        /** 15:継続（自動継続を含む） */
        public static final String CONTINUATION = "15";

        /** 18：その他 */
        public static final String OTHER = "15";

        /** 19：訂正 */
        public static final String CORRECT = "19";

    }

    /**
     * 取引区分
     */
    public final class BillKbn {

        /** 1：小切手 */
        public static final int CHECK = 1;

        /** 2：約束手形 */
        public static final int PROMISSORY = 2;

        /** 3：為替手形 */
        public static final int EXCHANGE = 3;

    }

    /**
     * 中間払区分
     */
    public final class InterimKbn {
        /** 1：現払 */
        public static final int PAY = 1;

        /** 2：指定口座への振替 */
        public static final int TRANSFER = 2;

        /** 3：定期預金の作成 */
        public static final int FIX_ACCOUNT = 3;
    }

    /**
     * 税区分
     */
    public final class TaxKbn { // NOPMD DataClass

        /** 1：総合課税 */
        public static final int COMPREHENSIVE = 1;

        /** 2：分離課税 */
        public static final int SEPARATE = 2;

        /** 3：マル優 */
        public static final int PREFENTIAL = 3;

        /** 5：非居住者 */
        public static final int NON_RESIDENT = 5;

        /** 9：その他 */
        public static final int OTHER = 9;

    }

    /**
     * 期間利息正負表示区分
     */
    public final class InterestKbn {

        /** 1:プラス */
        public static final int PLUS = 1;

        /** 2:マイナス */
        public static final int MINUS = 2;

    }

    // 以下総合金融サービスを実装するわけではないので不要

    // 通知区分
    // 1：預金

    // 支払可能残高
    // 1：プラス
    // 2：マイナス

    // 前日残高
    // 1：プラス
    // 2：マイナス

    // 新規コード
    // 1：第 1 回振込分
    // 2：変更分(被仕向銀行・支店、口座番号)
    // 0：その他

    // 振込指定区分
    // 7:テレ振込
    // 8:文書振込

    // 識別表示
    // 「Y」またはスペースとする

    // 照会回答コード
    // 0：確認済（預金種目・口座番号、受取人名とも一致）
    // 1：該当口座なし（該当する預金種目・口座番号なし）
    // 2：受取人名相違（該当する預金種目・口座番号の受取人名が相違）
    // 9：その他（上記以外の場合）

    // 振替結果コード
    // 0：振替済
    // 1：資金不足
    // 2：取引なし
    // 3：預金者の都合による振替停止
    // 4：預金口座振替依頼書なし
    // 8：委託者の都合による振替停止
    // 9：その他



}
