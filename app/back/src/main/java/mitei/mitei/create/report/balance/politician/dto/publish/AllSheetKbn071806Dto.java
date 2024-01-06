package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071806Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の6 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071806TrustAmongAssetsDto sheet071806TrustAmongAssetsDto;

    /**
     * 様式7の18の6を取得する
     *
     * @return 様式7の18の6
     */
    public Sheet071806TrustAmongAssetsDto getSheet071806TrustAmongAssetsDto() {
        return sheet071806TrustAmongAssetsDto;
    }

    /**
     * 様式7の18の6を設定する
     *
     * @param sheet071806TrustAmongAssetsDto 様式7の18の6
     */
    public void setSheet071806TrustAmongAssetsDto(final Sheet071806TrustAmongAssetsDto sheet071806TrustAmongAssetsDto) {
        this.sheet071806TrustAmongAssetsDto = sheet071806TrustAmongAssetsDto;
    }

}
