package mitei.mitei.create.report.balance.politician.dto.report_item;

/**
 * 全銀フォーマットcsv格納位置定数
 */
public final class ZenginFormatRecordPosConstants { // NOPMD

    private ZenginFormatRecordPosConstants() {
        
    }

    /**
     * 入出金明細のヘッダレのcsvレコードの格納位置
     */
    public class PosTransactionDetailHeader{ // NOPMD
        /** データ区分の格納位置 */
        public static final int  DATA_KBN = 0;
        
        /** 種別コードの格納位置 */
        public static final int  BUISSINESS_TYPE = 1;
        
        /** コード区分の格納位置 */
        public static final int  CODE_KBN = 2;
        
        /** 作成日の格納位置 */
        public static final int DATE_MAKING = 3;
        
        /** 勘定日(自)の格納位置 */
        public static final int DATE_FROM_REF = 4;
        
        /** 勘定日(至)の格納位置 */
        public static final int DATE_TO_REF = 5;
        
        /** 銀行コードの格納位置 */
        public static final int BANK_NO = 6;
        
        /** 銀行名の格納位置 */
        public static final int BANK_NAME = 7;
        
        /** 支店コードの格納位置 */
        public static final int BRANCH_NO = 8;
        
        /** 支店名の格納位置 */
        public static final int BRANCH_NAME = 9;
        
        /** ダミーの格納位置 */
        public static final int DUMMY = 10;
        
        /** 預金種目の格納位置 */
        public static final int DEPOSIT_TYPE = 11;
       
        /** 口座番号の格納位置 */
        public static final int ACCOUNT_NO = 12;
        
        /** 口座名の格納位置 */
        public static final int ACCOUNT_NAME = 13;
        
        /** 貸越区分の格納位置 */
        public static final int OVERDRAFT_KBN = 14;
        
        /** 通帳・証書区分の格納位置 */
        public static final int PASSBOOK_KBN = 15;
        
        /** 取引前残高の格納位置 */
        public static final int PRE_TRANSACTION_BALANCE = 16;
        
        /** ダミーの格納位置 */
        public static final int DUMMY_END = 17;
        
    }

    /**
     * 入出金明細のgroup1(普通預金)csvレコードの格納位置
     */
    public class PosTransactionDetailGroup1Ordinaly{ // NOPMD
        /** データ区分の格納位置 */
        public static final int DATA_KBN = 0;
        
        /** 照会番号の格納位置 */
        public static final int  REFER_NO = 1;
        
        /** 勘定日の格納位置 */
        public static final int  ACCOUNTING_DATE = 2;
        
        /** 預入・払出日の格納位置 */
        public static final int  DEPOSIT_WITH_DRAWAL_DATE = 3;
        
        /** 入払区分の格納位置 */
        public static final int  DE_WD_KBN = 4;
        
        /** 取引区分の格納位置 */
        public static final int TRADING_KBN = 5;
        
        /** 取引金額の格納位置 */
        public static final int  TRANSACTION_AMOUNT = 6;
        
        /** うち他店券金額の格納位置 */
        public static final int  OTHER_STORE_TICKET_AMOUNT = 7;
        
        /** 交換呈示日の格納位置 */
        public static final int  EXCHANGE_PRESENTATION_DATE = 8;
        
        /** 不渡返還日の格納位置 */
        public static final int  DISHORNORED_RETURN_DATE = 9;
        
        /** 手形・小切手区分の格納位置 */
        public static final int  BILL_CHEK_KBN = 10;

        /** 手形・小切手番号の格納位置 */
        public static final int BILL_CHECK_NO = 11;

        /** 僚店番号の格納位置 */
        public static final int  BRANCH_NO = 12;
        
        /** 振込依頼人コードの格納位置 */
        public static final int TRANSFER_REQUESTER_CODE = 13;
        
        /** 依頼人名または契約者番号の格納位置 */
        public static final int TRADING_DETAIL = 14;
           
        /** 仕向銀行名の格納位置 */
        public static final int SENDING_BANK_NAME = 15;
        
        /** 仕向店名の格納位置 */
        public static final int SENDING_BANK_BRANCH_NAME = 16;
        
        /** 摘要内容の格納位置 */
        public static final int ABSTRACT_CONTET = 17;
        
        /** EDI情報の格納位置 */
        public static final int EDI_INFO = 18;

        /** ダミーの格納位置 */
        public static final int DUMMY_END = 19;

    }

    /**
     * 入出金明細のgroup2(通知預金など)csvレコードの格納位置
     */
    public class PosTransactionDetailGroup2Notice{ // NOPMD
        /** データ区分の格納位置 */
        public static final int DATA_KBN = 0;
        
        /** 識別番号の格納位置 */
        public static final int IDENTIFICATION_NO = 1;
        
        /** 勘定日の格納位置 */
        public static final int ACCOUNTING_DATE = 2;
        
        /** 預入・払出日の格納位置 */
        public static final int DEPOSIT_WITHDRAWAL_DATE = 3;
        
        /** 入払区分の格納位置 */
        public static final int DE_WD_KBNn = 4;
        
        /** 取引区分の格納位置 */
        public static final int TRADING_KBN = 5;
        
        /** 取引金額の格納位置 */
        public static final int TRANSACTION_AMOUNT = 6;
        
        /** うち他店券金額の格納位置 */
        public static final int OTHER_STORE_TICKET_AMOUNT = 7;
        
        /** 交換呈示日の格納位置 */
        public static final int EXCHANGE_PRESENTATION_DATE = 8;
        
        /** 不渡返還日の格納位置 */
        public static final int DISHONORED_RETURN_DATE = 9;
        
        /** 手形・小切手区分の格納位置 */
        public static final int BILL_CHECK_KBN = 10;

        /** 手形・小切手番号の格納位置 */
        public static final int BILL_CHECK_NO = 11;

        /** 僚店番号の格納位置 */
        public static final int BRANCH_NO = 12;
        
        /** 当初預入日の格納位置 */
        public static final int ORGINAL_DATE = 13;
        
        /** 利率の格納位置 */
        public static final int INTEREST_RATE = 14;
        
        /** 満期日の格納位置 */
        public static final int MATURITY_DATE = 15;
        
        /** 期間(1)の格納位置 */
        public static final int PERIOD1 = 16;
        
        /** 期間利息の格納位置 */
        public static final int PERIOD_INTEREST = 17;
        
        /** 中間払利率の格納位置 */
        public static final int INTERMEDIATE_INTEREST_RATE = 18;
        
        /** 中間払区分の格納位置 */
        public static final int INTERIM_PAYMENT_KBN = 19;
        
        /** 期後期間の格納位置 */
        public static final int POST_PERIOD = 20;

        /** 期後利率の格納位置 */
        public static final int POST_PERIOD_INTEREST_RATE = 21;

        /** 期後利息の格納位置 */
        public static final int POST_PERIOD_INTEREST = 22;

        /** 合計利息の格納位置 */
        public static final int TOTAL_INTEREST = 23;

        /** 税区分の格納位置 */
        public static final int TAX_KBN = 24;

        /** 税率の格納位置 */
        public static final int TAX_RATE = 25;

        /** 税額の格納位置 */
        public static final int TAX_AMOUNT = 26;

        /** 税引後利息の格納位置 */
        public static final int AFTER_TAX_INTEREST = 27;

        /** 摘要内容の格納位置 */
        public static final int ABSTRACT_CONTENT = 28;

        /** 期間（2）の格納位置 */
        public static final int PERIOD2 = 29;

        /** 期間利息正負表示の格納位置 */
        public static final int PERIODIC_INTEREST_KBN = 30 ;

        /** ダミーの格納位置 */
        public static final int DUMMY_END = 31;

    }

    /**
     * 入出金明細のトレーラcsvレコードの格納位置
     */
    public class PosTransactionDetailTrailer{ // NOPMD
     
        /** データ区分の格納位置 */
        public static final int DATA_KBN = 0;

        /** 入金件数の格納位置 */
        public static final int COUNT_INCOME = 1;

        /** 入金額合計の格納位置 */
        public static final int SUM_INCOME = 2;

        /** 出金件数の格納位置 */
        public static final int COUNT_OUTCOME = 3;

        /** 出金額合計の格納位置 */
        public static final int SUM_OUTCOME = 4;

        /** 貸越区分の格納位置 */
        public static final int OVERDRAFT_KBN = 5;

        /** 取引後残高の格納位置 */
        public static final int BALANCE_AFTER_TRANSACTION = 6;

        /** データ・レコード件数の格納位置 */
        public static final int COUNT_DATA = 7;

        /** ダミーの格納位置 */
        public static final int DUMMY_END = 8;

    }

    /**
     * 入出金明細のエンドcsvレコードの格納位置
     */
    public class PosTransactionDetailEnd{ // NOPMD
        /** データ区分の格納位置 */
        public static final int DATA_KBN = 0;
        
        /** レコード総件数の格納位置 */
        public static final int COUNT_RECORD = 1;
        
        /** 口座数の格納位置 */
        public static final int COUNT_ACCOUNT = 2;
        
        /** ダミーの格納位置 */
        public static final int DUMMY_END = 3;
    }

}
