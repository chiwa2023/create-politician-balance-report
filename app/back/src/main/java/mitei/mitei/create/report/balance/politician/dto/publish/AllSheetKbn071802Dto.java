package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071802Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の2 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071802BuildingsAmongAssetsDto sheet071802BuildingsAmongAssetsDto;

    /**
     * 様式7の18の2を取得する
     *
     * @return 様式7の18の2
     */
    public Sheet071802BuildingsAmongAssetsDto getSheet071802BuildingsAmongAssetsDto() {
        return sheet071802BuildingsAmongAssetsDto;
    }

    /**
     * 様式7の18の2を設定する
     *
     * @param sheet071802BuildingsAmongAssetsDto 様式7の18の2
     */
    public void setSheet071802BuildingsAmongAssetsDto(
            final Sheet071802BuildingsAmongAssetsDto sheet071802BuildingsAmongAssetsDto) {
        this.sheet071802BuildingsAmongAssetsDto = sheet071802BuildingsAmongAssetsDto;
    }

}
