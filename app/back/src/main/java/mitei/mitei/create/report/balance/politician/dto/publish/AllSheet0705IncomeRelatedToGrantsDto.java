package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の5費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_05")
public class AllSheet0705IncomeRelatedToGrantsDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の5 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070500IncomeRelatedToGrantsDto sheet070500IncomeRelatedToGrantsDto;

    /**
     * 様式7の5シートを取得する
     *
     * @return 様式7の5シート
     */
    public Sheet070500IncomeRelatedToGrantsDto getSheet070500IncomeRelatedToGrantsDto() {
        return sheet070500IncomeRelatedToGrantsDto;
    }

    /**
     * 様式7の5シートを取得する
     *
     * @param sheet070500IncomeRelatedToGrantsDto 様式7の5シート
     */
    public void setSheet070500IncomeRelatedToGrantsDto(
            final Sheet070500IncomeRelatedToGrantsDto sheet070500IncomeRelatedToGrantsDto) {
        this.sheet070500IncomeRelatedToGrantsDto = sheet070500IncomeRelatedToGrantsDto;
    }

}
