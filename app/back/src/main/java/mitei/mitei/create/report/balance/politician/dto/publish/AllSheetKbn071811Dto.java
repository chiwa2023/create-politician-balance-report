package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071811Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の11 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071811FacilityUsageRightsAmongAssetsDto sheet071811FacilityUsageRightsAmongAssetsDto;

    /**
     * 様式7の18の11を取得する
     *
     * @return 様式7の18の11
     */
    public Sheet071811FacilityUsageRightsAmongAssetsDto getSheet071811FacilityUsageRightsAmongAssetsDto() {
        return sheet071811FacilityUsageRightsAmongAssetsDto;
    }

    /**
     * 様式7の18の11を設定する
     *
     * @param sheet071811FacilityUsageRightsAmongAssetsDto 様式7の18の11
     */
    public void setSheet071811FacilityUsageRightsAmongAssetsDto(
            final Sheet071811FacilityUsageRightsAmongAssetsDto sheet071811FacilityUsageRightsAmongAssetsDto) {
        this.sheet071811FacilityUsageRightsAmongAssetsDto = sheet071811FacilityUsageRightsAmongAssetsDto;
    }

}
