package mitei.mitei.create.report.balance.politician.dto.balancesheet;

import mitei.mitei.create.report.balance.politician.dto.AbstractResultDto;

/**
 * 
 */
public class ReadXmlBalancesheetResultDto extends AbstractResultDto{

    /** 表示メッセージ */
    private String message = "";

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
    
    /** 政治資金収支報告書用政治団体情報 */
}
