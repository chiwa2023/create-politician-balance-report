package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の10費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_10")
public class AllSheet0710SpecificPartyDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の10 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071000SpecificPartyDto sheet071000SpecificPartyDto;

    /**
     * 様式7の10データを取得する
     *
     * @return 様式7の10データ
     */
    public Sheet071000SpecificPartyDto getSheet071000SpecificPartyDto() {
        return sheet071000SpecificPartyDto;
    }

    /**
     * 様式7の10データを設定する
     *
     * @param sheet071000SpecificPartyDto 様式7の10データ
     */
    public void setSheet071000SpecificPartyDto(final Sheet071000SpecificPartyDto sheet071000SpecificPartyDto) {
        this.sheet071000SpecificPartyDto = sheet071000SpecificPartyDto;
    }

}
