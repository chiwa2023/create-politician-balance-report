package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071803Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の3 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071803SurfaceRightsAmongAssetsDto sheet071803SurfaceRightsAmongAssetsDto;

    /**
     * 様式7の18の3を取得する
     *
     * @return 様式7の18の3
     */
    public Sheet071803SurfaceRightsAmongAssetsDto getSheet071803SurfaceRightsAmongAssetsDto() {
        return sheet071803SurfaceRightsAmongAssetsDto;
    }

    /**
     * 様式7の18の3を設定する
     *
     * @param sheet071803SurfaceRightsAmongAssetsDto 様式7の18の3
     */
    public void setSheet071803SurfaceRightsAmongAssetsDto(
            final Sheet071803SurfaceRightsAmongAssetsDto sheet071803SurfaceRightsAmongAssetsDto) {
        this.sheet071803SurfaceRightsAmongAssetsDto = sheet071803SurfaceRightsAmongAssetsDto;
    }

}
