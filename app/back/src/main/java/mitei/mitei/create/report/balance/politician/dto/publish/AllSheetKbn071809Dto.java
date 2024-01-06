package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の18の１資産のうち土地データDto
 */
public class AllSheetKbn071809Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の18の9 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071809LoanAmongAssetsDto sheet071809LoanAmongAssetsDto;

    /**
     * 様式7の18の9を取得する
     *
     * @return 様式7の18の9
     */
    public Sheet071809LoanAmongAssetsDto getSheet071809LoanAmongAssetsDto() {
        return sheet071809LoanAmongAssetsDto;
    }

    /**
     * 様式7の18の9を設定する
     *
     * @param sheet071809LoanAmongAssetsDto 様式7の18の9
     */
    public void setSheet071809LoanAmongAssetsDto(final Sheet071809LoanAmongAssetsDto sheet071809LoanAmongAssetsDto) {
        this.sheet071809LoanAmongAssetsDto = sheet071809LoanAmongAssetsDto;
    }

}
