package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の14の2の区分の全体データDto
 */
public class AllSheetKbn071402Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の14の2 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet071402EquipmentCostsDto sheet071402EquipmentCostsDto;

    /**
     * 14の2シートデータを取得する
     *
     * @return 14の2シートデータ
     */
    public Sheet071402EquipmentCostsDto getSheet071402EquipmentCostsDto() {
        return sheet071402EquipmentCostsDto;
    }

    /**
     * 14の2シートデータを設定する
     *
     * @param sheet071402EquipmentCostsDto 14の2シートデータ
     */
    public void setSheet071402EquipmentCostsDto(final Sheet071402EquipmentCostsDto sheet071402EquipmentCostsDto) {
        this.sheet071402EquipmentCostsDto = sheet071402EquipmentCostsDto;
    }

}
