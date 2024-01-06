package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の8斡旋による寄付(個人)の全体データDto
 */
public class AllSheetKbn070801Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の08の1 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070801MediationPersonDto sheet070801MediationPersonDto;

    /**
     * 様式7の08の1を取得する
     *
     * @return 様式7の08の1
     */
    public Sheet070801MediationPersonDto getSheet070801MediationPersonDto() {
        return sheet070801MediationPersonDto;
    }

    /**
     * 様式7の08の1を設定する
     *
     * @param sheet070801MediationPersonDto 様式7の08の1
     */
    public void setSheet070801MediationPersonDto(final Sheet070801MediationPersonDto sheet070801MediationPersonDto) {
        this.sheet070801MediationPersonDto = sheet070801MediationPersonDto;
    }

}
