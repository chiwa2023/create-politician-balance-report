package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071801Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の1 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071801LandAmongAssetsDto sheet071801LandAmongAssetsDto;

    /**
     * 様式7の18の1を取得する
     *
     * @return 様式7の18の1
     */
    public Sheet071801LandAmongAssetsDto getSheet071801LandAmongAssetsDto() {
        return sheet071801LandAmongAssetsDto;
    }

    /**
     * 様式7の18の1を設定する
     *
     * @param sheet071801LandAmongAssetsDto 様式7の18の1
     */
    public void setSheet071801LandAmongAssetsDto(final Sheet071801LandAmongAssetsDto sheet071801LandAmongAssetsDto) {
        this.sheet071801LandAmongAssetsDto = sheet071801LandAmongAssetsDto;
    }

}
