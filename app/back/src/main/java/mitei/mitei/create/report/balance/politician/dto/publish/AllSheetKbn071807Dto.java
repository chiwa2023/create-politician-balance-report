package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071807Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の7 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071807SecuritiesAmongAssetsDto sheet071807SecuritiesAmongAssetsDto;

    /**
     * 様式7の18の7を取得する
     *
     * @return 様式7の18の7
     */
    public Sheet071807SecuritiesAmongAssetsDto getSheet071807SecuritiesAmongAssetsDto() {
        return sheet071807SecuritiesAmongAssetsDto;
    }

    /**
     * 様式7の18の7を設定する
     *
     * @param sheet071807SecuritiesAmongAssetsDto 様式7の18の7
     */
    public void setSheet071807SecuritiesAmongAssetsDto(
            final Sheet071807SecuritiesAmongAssetsDto sheet071807SecuritiesAmongAssetsDto) {
        this.sheet071807SecuritiesAmongAssetsDto = sheet071807SecuritiesAmongAssetsDto;
    }

}
