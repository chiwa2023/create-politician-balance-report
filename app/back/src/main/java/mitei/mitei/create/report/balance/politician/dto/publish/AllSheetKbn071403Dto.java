package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の14の3区分データDto
 */
public class AllSheetKbn071403Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の14の3 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071403OfficeExpensesDto sheet071403OfficeExpensesDto;

    /**
     * 14の3シートデータを取得する
     *
     * @return 14の3シートデータ
     */
    public Sheet071403OfficeExpensesDto getSheet071403OfficeExpensesDto() {
        return sheet071403OfficeExpensesDto;
    }

    /**
     * 14の3シートデータを設定する
     *
     * @param sheet071403OfficeExpensesDto 14の3シートデータ
     */
    public void setSheet071403OfficeExpensesDto(final Sheet071403OfficeExpensesDto sheet071403OfficeExpensesDto) {
        this.sheet071403OfficeExpensesDto = sheet071403OfficeExpensesDto;
    }

}
