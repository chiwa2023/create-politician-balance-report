package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の17の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_17")
public class AllSheet0717SummaryTableOfAssetsDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の17 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071700SummaryTableOfAssetsDto sheet071700SummaryTableOfAssetsDto;

    /**
     * 様式7の17データを取得する
     *
     * @return 様式7の17データ
     */
    public Sheet071700SummaryTableOfAssetsDto getSheet071700SummaryTableOfAssetsDto() {
        return sheet071700SummaryTableOfAssetsDto;
    }

    /**
     * 様式7の17データを設定する
     *
     * @param sheet071700SummaryTableOfAssetsDto 様式7の17データ
     */
    public void setSheet071700SummaryTableOfAssetsDto(
            final Sheet071700SummaryTableOfAssetsDto sheet071700SummaryTableOfAssetsDto) {
        this.sheet071700SummaryTableOfAssetsDto = sheet071700SummaryTableOfAssetsDto;
    }

}
