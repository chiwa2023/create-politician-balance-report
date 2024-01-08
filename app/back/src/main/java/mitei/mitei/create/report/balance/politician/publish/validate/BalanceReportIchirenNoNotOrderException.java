package mitei.mitei.create.report.balance.politician.publish.validate;

/**
 * Dtoの行連番が順番に並んでいない場合の例外 
 * TODO より良いExceptionがあれば修正する
 * 
 */
public class BalanceReportIchirenNoNotOrderException extends Exception {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ(メッセージ必須)
     *
     * @param message メッセージ
     */
    public BalanceReportIchirenNoNotOrderException(final String message) {
        super(message + "の行連番が順番通りでありません");
    }

}
