package mitei.mitei.create.report.balance.politician.dto.balancesheet;

/**
 * csvから収支報告書を作成するときに列に役割を与えるときの定数
 * 調査側　定数設計書 X.10 csv読み取り列指定セレクトボックスの項を参照の事
 */
public class CsvTradingRowConstants { // NOPMD DataClass

    /** 指定なし */
    public static final int NO_POINT = 0;

    /** 取引金額支出 */
    public static final int OUTCOME_AMOUNT = 1;
    
    /** 取引金額収入 */
    public static final int INCOME_AMOUNT = 2;

    /** 取引金額増減兼用 */
    public static final int AMOUNT_IN_OUT = 3;
    
    /**  発生日 */
    public static final int ACCURAL_DATE = 15;
    
    /** 摘要 */
    public static final int DIGEST = 16;
    
    /** 取引相手名称 */
    public static final int TRADING_PERSON = 17;
    
}
