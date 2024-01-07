package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 寄付控除を受ける団体の区分と補足情報のデータDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI_KIFUKOUJYO")
public class AllSheet411710DonationClassifyDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 寄付控除団体情報 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet411710DonationClassifyDto sheet411710DonationClassifyDto;

    /**
     * 寄付控除団体情報を取得する
     *
     * @return 寄付控除団体情報
     */
    public Sheet411710DonationClassifyDto getSheet411710DonationClassifyDto() {
        return sheet411710DonationClassifyDto;
    }

    /**
     * 寄付控除団体情報を設定する
     *
     * @param sheet411710DonationClassifyDto 寄付控除団体情報
     */
    public void setSheet411710DonationClassifyDto(final Sheet411710DonationClassifyDto sheet411710DonationClassifyDto) {
        this.sheet411710DonationClassifyDto = sheet411710DonationClassifyDto;
    }

}
