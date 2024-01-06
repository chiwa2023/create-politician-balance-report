package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の14費用の全体データDto
 */
public class AllSheetKbn071401Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の14の1 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071401UtilityCostsDto sheet071401UtilityCostsDto;

    /**
     * 14の1シートデータを取得する
     *
     * @return 14の1シートデータ
     */
    public Sheet071401UtilityCostsDto getSheet071401UtilityCostsDto() {
        return sheet071401UtilityCostsDto;
    }

    /**
     * 14の1シートデータを設定する
     *
     * @param sheet071401UtilityCostsDto 14の1シートデータ
     */
    public void setSheet071401UtilityCostsDto(final Sheet071401UtilityCostsDto sheet071401UtilityCostsDto) {
        this.sheet071401UtilityCostsDto = sheet071401UtilityCostsDto;
    }

}
