package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の7個人寄付の全体データDto
 */
public class AllSheetKbn070703Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の7の3 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070703DonatePoliticOrgDto sheet070703DonatePoliticOrgDto;

    /**
     * 様式7の7の3を取得する
     *
     * @return 様式7の7の3
     */
    public Sheet070703DonatePoliticOrgDto getSheet070703DonatePoliticOrgDto() {
        return sheet070703DonatePoliticOrgDto;
    }

    /**
     * 様式7の7の3を設定する
     *
     * @param sheet070703DonatePoliticOrgDto 様式7の7の3
     */
    public void setSheet070703DonatePoliticOrgDto(final Sheet070703DonatePoliticOrgDto sheet070703DonatePoliticOrgDto) {
        this.sheet070703DonatePoliticOrgDto = sheet070703DonatePoliticOrgDto;
    }

}
