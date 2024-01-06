package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の3費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_16")
public class AllSheet0716RelatedToGrantsDtoDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の16 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071600ExpendituresRelatedToGrantsDto sheet071600ExpendituresRelatedToGrantsDto;

    /**
     * 様式7の16データを取得する
     *
     * @return 様式7の16データ
     */
    public Sheet071600ExpendituresRelatedToGrantsDto getSheet071600ExpendituresRelatedToGrantsDto() {
        return sheet071600ExpendituresRelatedToGrantsDto;
    }

    /**
     * 様式7の16データを設定する
     *
     * @param sheet071600ExpendituresRelatedToGrantsDto 様式7の16データ
     */
    public void setSheet071600ExpendituresRelatedToGrantsDto(
            final Sheet071600ExpendituresRelatedToGrantsDto sheet071600ExpendituresRelatedToGrantsDto) {
        this.sheet071600ExpendituresRelatedToGrantsDto = sheet071600ExpendituresRelatedToGrantsDto;
    }

}
