package mitei.mitei.create.report.balance.politician.publish.validate;

/**
 * Dtoの合算入力値と実際のリストの検算が不一致の場合の例外 
 * TODO より良いExceptionがあれば修正する
 * 
 */
public class BalanceReportDoesNotMatchSumException extends Exception {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ(メッセージ必須)
     *
     * @param message メッセージ
     */
    public BalanceReportDoesNotMatchSumException(final String message) {
        super(message + "のリストの金額合計が集計(pageTotal)と一致しません");
    }

}
