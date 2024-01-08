package mitei.mitei.create.report.balance.politician.publish.validate;

/**
 * XML発行時に入力が必要な項目が未入力の場合の例外
 * TODO より良いExceptionがあれば修正する
 */
public class BalanceReportRequiredInputException extends Exception {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ(メッセージ必須)
     *
     * @param message メッセージ
     */
    public BalanceReportRequiredInputException(final String message) {
        super(message + "が未入力です");
    }
}
