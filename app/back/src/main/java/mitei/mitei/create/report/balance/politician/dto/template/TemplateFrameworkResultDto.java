package mitei.mitei.create.report.balance.politician.dto.template;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.AbstractResultDto;

/**
 * 処理実行結果を定型で返却するためのDto
 */
public class TemplateFrameworkResultDto extends AbstractResultDto implements Serializable {

    /** SerialId */
    private static final long serialVersionUID = 1L;

    /** 表示メッセージ */
    private String message = "[実装必要]";

    /**
     * 表示メッセージを取得する
     *
     * @return 表示メッセージ
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 表示メッセージを設定する
     *
     * @param message 表示メッセージ
     */
    @Override
    public void setMessage(final String message) {
        this.message = message;
    }

}
