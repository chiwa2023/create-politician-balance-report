package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の13費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_13")
public class AllSheet0713ListOfExpenditureItemsDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の13 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071300ListOfExpenditureItemsDto sheet071300ListOfExpenditureItemsDto;

    /**
     * 様式7の13データを取得する
     *
     * @return 様式7の13データを設定
     */
    public Sheet071300ListOfExpenditureItemsDto getSheet071300ListOfExpenditureItemsDto() {
        return sheet071300ListOfExpenditureItemsDto;
    }

    /**
     * 様式7の13データを設定する
     *
     * @param sheet071300ListOfExpenditureItemsDto 様式7の13データを設定
     */
    public void setSheet071300ListOfExpenditureItemsDto(
            final Sheet071300ListOfExpenditureItemsDto sheet071300ListOfExpenditureItemsDto) {
        this.sheet071300ListOfExpenditureItemsDto = sheet071300ListOfExpenditureItemsDto;
    }

}
