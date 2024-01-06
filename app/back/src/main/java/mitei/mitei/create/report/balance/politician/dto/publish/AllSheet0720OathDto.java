package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の20 宣誓書の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_20")
public class AllSheet0720OathDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の20 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet072000OathDto sheet072000OathDto;

    /**
     * 様式7の20のデータを取得する
     *
     * @return 様式7の20のデータ
     */
    public Sheet072000OathDto getSheet072000OathDto() {
        return sheet072000OathDto;
    }

    /**
     * 様式7の20のデータを設定する
     *
     * @param sheet072000OathDto 様式7の20のデータ
     */
    public void setSheet072000OathDto(final Sheet072000OathDto sheet072000OathDto) {
        this.sheet072000OathDto = sheet072000OathDto;
    }

}
