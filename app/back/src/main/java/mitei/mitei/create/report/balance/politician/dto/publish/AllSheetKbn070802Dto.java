package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の8斡旋による寄付(個人)の全体データDto
 */
public class AllSheetKbn070802Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の08の2 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070802MediationGroupDto sheet070802MediationGroupDto;

    /**
     * 様式7の08の2を取得する
     *
     * @return 様式7の08の2
     */
    public Sheet070802MediationGroupDto getSheet070802MediationGroupDto() {
        return sheet070802MediationGroupDto;
    }

    /**
     * 様式7の08の2を設定する
     *
     * @param sheet070802MediationGroupDto 様式7の08の2
     */
    public void setSheet070802MediationGroupDto(final Sheet070802MediationGroupDto sheet070802MediationGroupDto) {
        this.sheet070802MediationGroupDto = sheet070802MediationGroupDto;
    }

}
