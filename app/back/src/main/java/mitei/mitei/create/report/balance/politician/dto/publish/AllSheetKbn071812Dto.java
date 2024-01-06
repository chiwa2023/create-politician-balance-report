package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071812Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の12 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071812BorrowingsAmongAssetsDto sheet071812BorrowingsAmongAssetsDto;

    /**
     * 様式7の18の12を取得する
     *
     * @return 様式7の18の12
     */
    public Sheet071812BorrowingsAmongAssetsDto getSheet071812BorrowingsAmongAssetsDto() {
        return sheet071812BorrowingsAmongAssetsDto;
    }

    /**
     * 様式7の18の12を設定する
     *
     * @param sheet071812BorrowingsAmongAssetsDto 様式7の18の12
     */
    public void setSheet071812BorrowingsAmongAssetsDto(
            final Sheet071812BorrowingsAmongAssetsDto sheet071812BorrowingsAmongAssetsDto) {
        this.sheet071812BorrowingsAmongAssetsDto = sheet071812BorrowingsAmongAssetsDto;
    }

}
