package mitei.mitei.create.report.balance.politician.dto.calling_item;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.entity.CallingItemEntity;

/**
 * Itemこうもく呼び出しDto
 */
public class CallingItemDto extends CallingItemEntity implements Serializable{

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 書証読み取り行 */
    private Integer readLine;

    /**
     * 書証読み取り行を取得する
     *
     * @return 書証読み取り行
     */
    public Integer getReadLine() {
        return readLine;
    }

    /**
     * 書証読み取り行を設定する
     * 
     *
     * @param readLine 書証読み取り行
     */
    public void setReadLine(final Integer readLine) {
        this.readLine = readLine;
    }

    
}
