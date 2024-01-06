package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071808Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の8 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071808InvestmentAmongAssetsDto sheet071808InvestmentAmongAssetsDto;

    /**
     * 様式7の18の8を取得する
     *
     * @return 様式7の18の8
     */
    public Sheet071808InvestmentAmongAssetsDto getSheet071808InvestmentAmongAssetsDto() {
        return sheet071808InvestmentAmongAssetsDto;
    }

    /**
     * 様式7の18の8を設定する
     *
     * @param sheet071808InvestmentAmongAssetsDto 様式7の18の8
     */
    public void setSheet071808InvestmentAmongAssetsDto(
            final Sheet071808InvestmentAmongAssetsDto sheet071808InvestmentAmongAssetsDto) {
        this.sheet071808InvestmentAmongAssetsDto = sheet071808InvestmentAmongAssetsDto;
    }

}
