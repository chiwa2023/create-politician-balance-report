package mitei.mitei.create.report.balance.politician.dto.balancesheet;

/**
 * csvから収支報告書を作成するときに列に役割を与えるときの定数 調査側 定数設計書 X.10 csv読み取り列指定セレクトボックスの項を参照の事
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

    /** 発生日 */
    public static final int ACCURAL_DATE = 15;

    /** 摘要 */
    public static final int DIGEST = 16;

    /** 取引相手名称 */
    public static final int TRADING_PERSON = 17;

    /**
     * 列指定定数を文字列表現に変換する
     *
     * @param value 定数値
     * @return 定数値に紐づく表示
     */
    public static final String convertValueToText(final String value)throws IllegalArgumentException,NumberFormatException { // NOPMD
        
        switch (Integer.parseInt(value)) {
            
            // 指定なし
            case NO_POINT:
                return "指定なし";
                
                // 取引金額支出
            case OUTCOME_AMOUNT:
                return "取引金額支出";
            
                // 取引金額収入
            case INCOME_AMOUNT:
                return "取引金額収入";
            
                // 取引金額増減兼用
            case AMOUNT_IN_OUT:
                return "取引金額増減兼用";
            
                // 発生日
            case ACCURAL_DATE:
                return "発生日";
            
                // 摘要
            case DIGEST:
                return "摘要";
            
                // 取引相手名称
            case TRADING_PERSON:
                return "取引相手名称";
            
            default:
                throw new IllegalArgumentException("定数以外の値が指定されています");
        }
    }

}
