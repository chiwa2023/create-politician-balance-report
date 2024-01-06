package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071805Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の5 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071805SavingsAmmongAssetsDto sheet071805SavingsAmmongAssetsDto;

    /**
     * 様式7の18の5を取得する
     *
     * @return 様式7の18の5
     */
    public Sheet071805SavingsAmmongAssetsDto getSheet071805SavingsAmmongAssetsDto() {
        return sheet071805SavingsAmmongAssetsDto;
    }

    /**
     * 様式7の18の5を設定する
     *
     * @param sheet071805SavingsAmmongAssetsDto 様式7の18の5
     */
    public void setSheet071805SavingsAmmongAssetsDto(
            final Sheet071805SavingsAmmongAssetsDto sheet071805SavingsAmmongAssetsDto) {
        this.sheet071805SavingsAmmongAssetsDto = sheet071805SavingsAmmongAssetsDto;
    }

}
