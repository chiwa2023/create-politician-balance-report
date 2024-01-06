package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の2収入一覧表データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_02")
public class AllSheet0702SummaryTableIncomeDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の2の1 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070200SummaryTableIncomeExpenditureDto sheet070200SummaryTableIncomeExpenditureDto;

    /**
     * 様式7の2収入一覧表データを取得する
     *
     * @return 様式7の2収入一覧表データ
     */
    public Sheet070200SummaryTableIncomeExpenditureDto getSheet070200SummaryTableIncomeExpenditureDto() {
        return sheet070200SummaryTableIncomeExpenditureDto;
    }

    /**
     * 様式7の2収入一覧表データを設定する
     *
     * @param sheet070200SummaryTableIncomeExpenditureDto 様式7の2収入一覧表データ
     */
    public void setSheet070200SummaryTableIncomeExpenditureDto(
            final Sheet070200SummaryTableIncomeExpenditureDto sheet070200SummaryTableIncomeExpenditureDto) {
        this.sheet070200SummaryTableIncomeExpenditureDto = sheet070200SummaryTableIncomeExpenditureDto;
    }

}
