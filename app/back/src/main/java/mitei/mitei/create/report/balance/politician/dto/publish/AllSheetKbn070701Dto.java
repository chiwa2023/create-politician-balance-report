package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の7個人寄付の全体データDto
 */
public class AllSheetKbn070701Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の7の1 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070701DonatePersonDto sheet070701DonatePersonDto;

    /**
     * 様式7の7の1データを取得する
     *
     * @return 様式7の7の1データ
     */
    public Sheet070701DonatePersonDto getSheet070701DonatePersonDto() {
        return sheet070701DonatePersonDto;
    }

    /**
     * 様式7の7の1データを設定する
     *
     * @param sheet070701DonatePersonDto 様式7の7の1データ
     */
    public void setSheet070701DonatePersonDto(final Sheet070701DonatePersonDto sheet070701DonatePersonDto) {
        this.sheet070701DonatePersonDto = sheet070701DonatePersonDto;
    }

}
