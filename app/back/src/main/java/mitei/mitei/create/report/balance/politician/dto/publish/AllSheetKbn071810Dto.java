package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071810Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の10 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071810DepositAmongAssetsDto sheet071810DepositAmongAssetsDto;

    /**
     * 様式7の18の10を取得する
     *
     * @return 様式7の18の10
     */
    public Sheet071810DepositAmongAssetsDto getSheet071810DepositAmongAssetsDto() {
        return sheet071810DepositAmongAssetsDto;
    }

    /**
     * 様式7の18の10を設定する
     *
     * @param sheet071810DepositAmongAssetsDto 様式7の18の10
     */
    public void setSheet071810DepositAmongAssetsDto(
            final Sheet071810DepositAmongAssetsDto sheet071810DepositAmongAssetsDto) {
        this.sheet071810DepositAmongAssetsDto = sheet071810DepositAmongAssetsDto;
    }

}
