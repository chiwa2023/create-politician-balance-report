package mitei.mitei.create.report.balance.politician.dto;

/**
 * セレクトボタンオプション項目Interface
 */
public interface SelectOptionInterface {

    /**
     * オプション項目の値を取得する
     *
     * @return オプション項目の値
     */
    String getValue();

    /**
     * オプション項目の値を設定する
     *
     * @param value オプション項目の値
     */
    void setValue(String value);
    
    /**
     * オプション項目のテキストを取得する
     *
     * @return オプション項目のテキスト
     */
    String getText();

    /**
     * オプション項目のテキストを設定する
     *
     * @param text オプション項目のテキスト
     */
    void setText(String text);
}
