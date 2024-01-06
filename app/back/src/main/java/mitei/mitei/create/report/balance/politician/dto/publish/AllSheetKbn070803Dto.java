package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の8斡旋による寄付(個人)の全体データDto
 */
public class AllSheetKbn070803Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の08の3 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070803MediationPoliticOrgDto sheet070803MediationPoliticOrgDto;

    /**
     * 様式7の08の3を取得する
     *
     * @return 様式7の08の3
     */
    public Sheet070803MediationPoliticOrgDto getSheet070803MediationPoliticOrgDto() {
        return sheet070803MediationPoliticOrgDto;
    }

    /**
     * 様式7の08の3を設定する
     *
     * @param sheet070803MediationPoliticOrgDto 様式7の08の3
     */
    public void setSheet070803MediationPoliticOrgDto(
            final Sheet070803MediationPoliticOrgDto sheet070803MediationPoliticOrgDto) {
        this.sheet070803MediationPoliticOrgDto = sheet070803MediationPoliticOrgDto;
    }

}
