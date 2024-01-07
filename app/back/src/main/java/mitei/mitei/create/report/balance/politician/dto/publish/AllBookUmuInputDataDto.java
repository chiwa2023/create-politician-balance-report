package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 情報入力されている化を示すフラグ情報を格納するDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI_UMU_FLG")
public class AllBookUmuInputDataDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /**
     * フラグ情報テキスト
     */
    @JacksonXmlProperty(localName = "SYUUSHI_UMU")
    private String inputBitText;

    /**
     * フラグ情報テキスト取得する
     *
     * @return フラグ情報テキスト
     */
    public String getInputBitText() {
        return inputBitText;
    }

    /**
     * フラグ情報テキスト設定する
     *
     * @param inputBitText フラグ情報テキスト
     */
    public void setInputBitText(final String inputBitText) {
        this.inputBitText = inputBitText;
    }

}
