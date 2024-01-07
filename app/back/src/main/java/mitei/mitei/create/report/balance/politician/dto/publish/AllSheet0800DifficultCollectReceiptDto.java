package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の3機関誌発光の収入の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI08")
public class AllSheet0800DifficultCollectReceiptDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式8 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet080000DifficultCollectReceiptDto sheet080000DifficultCollectReceiptDto;

    /**
     * 様式8を取得する
     *
     * @return 様式8
     */
    public Sheet080000DifficultCollectReceiptDto getSheet080000DifficultCollectReceiptDto() {
        return sheet080000DifficultCollectReceiptDto;
    }

    /**
     * 様式8を設定する
     *
     * @param sheet080000DifficultCollectReceiptDto 様式8
     */
    public void setSheet080000DifficultCollectReceiptDto(
            final Sheet080000DifficultCollectReceiptDto sheet080000DifficultCollectReceiptDto) {
        this.sheet080000DifficultCollectReceiptDto = sheet080000DifficultCollectReceiptDto;
    }

}
