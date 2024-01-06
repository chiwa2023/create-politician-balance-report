package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の7個人寄付の全体データDto
 */
public class AllSheetKbn070702Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の14の2 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070702DonateGroupDto sheet070702DonateGroupDto;

    /**
     * 様式7の14の2を取得する
     *
     * @return 様式7の14の2
     */
    public Sheet070702DonateGroupDto getSheet070702DonateGroupDto() {
        return sheet070702DonateGroupDto;
    }

    /**
     * 様式7の14の2を設定する
     *
     * @param sheet070702DonateGroupDto 様式7の14の2
     */
    public void setSheet070702DonateGroupDto(final Sheet070702DonateGroupDto sheet070702DonateGroupDto) {
        this.sheet070702DonateGroupDto = sheet070702DonateGroupDto;
    }

}
