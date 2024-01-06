package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の6その他の収入の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_06")
public class AllSheet0706OtherIncomeDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の6 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070600OtherIncomeDto sheet070600OtherIncomeDto;

    /**
     * 様式7の6シートを取得する
     *
     * @return 様式7の6シート
     */
    public Sheet070600OtherIncomeDto getSheet070600OtherIncomeDto() {
        return sheet070600OtherIncomeDto;
    }

    /**
     * 様式7の6シートを取得する
     *
     * @param sheet070600OtherIncomeDto 様式7の6シート
     */
    public void setSheet070600OtherIncomeDto(final Sheet070600OtherIncomeDto sheet070600OtherIncomeDto) {
        this.sheet070600OtherIncomeDto = sheet070600OtherIncomeDto;
    }


    
    
    
}
