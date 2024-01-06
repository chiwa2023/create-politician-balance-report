package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の9費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_09")
public class AllSheet0709AnonymousInPoliticalPartyDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の9 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070900AnonymousInPoliticalPartyDto sheet070900AnonymousInPoliticalPartyDto;

    /**
     * 様式7の9データを取得する
     *
     * @return 様式7の9データ
     */
    public Sheet070900AnonymousInPoliticalPartyDto getSheet070900AnonymousInPoliticalPartyDto() {
        return sheet070900AnonymousInPoliticalPartyDto;
    }

    /**
     * 様式7の9データを設定する
     *
     * @param sheet070900AnonymousInPoliticalPartyDto 様式7の9データ
     */
    public void setSheet070900AnonymousInPoliticalPartyDto(
            final Sheet070900AnonymousInPoliticalPartyDto sheet070900AnonymousInPoliticalPartyDto) {
        this.sheet070900AnonymousInPoliticalPartyDto = sheet070900AnonymousInPoliticalPartyDto;
    }

}
