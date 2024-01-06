package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071804Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の4 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071804MovablesAmongAssetsDto sheet071804MovablesAmongAssetsDto;

    /**
     * 様式7の18の4を取得する
     *
     * @return 様式7の18の4
     */
    public Sheet071804MovablesAmongAssetsDto getSheet071804MovablesAmongAssetsDto() {
        return sheet071804MovablesAmongAssetsDto;
    }

    /**
     * 様式7の18の4を設定する
     *
     * @param sheet071804MovablesAmongAssetsDto 様式7の18の4
     */
    public void setSheet071804MovablesAmongAssetsDto(
            final Sheet071804MovablesAmongAssetsDto sheet071804MovablesAmongAssetsDto) {
        this.sheet071804MovablesAmongAssetsDto = sheet071804MovablesAmongAssetsDto;
    }

}
