package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の14費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_12")
public class AllSheet0712PartyMediationDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の12の1 */
    @JacksonXmlProperty(localName = "KUBUN1")
    private AllSheetKbn071201Dto allSheetKbn071201Dto;

    /** 様式7の12の2 */
    @JacksonXmlProperty(localName = "KUBUN2")
    private AllSheetKbn071202Dto allSheetKbn071202Dto;

    /** 様式7の12の3 */
    @JacksonXmlProperty(localName = "KUBUN3")
    private AllSheetKbn071203Dto allSheetKbn071203Dto;

    /**
     * 様式7の12の1を取得する
     *
     * @return 様式7の12の1
     */
    public AllSheetKbn071201Dto getAllSheetKbn071201Dto() {
        return allSheetKbn071201Dto;
    }

    /**
     * 様式7の12の1を設定する
     *
     * @param allSheetKbn071201Dto 様式7の12の1
     */
    public void setAllSheetKbn071201Dto(final AllSheetKbn071201Dto allSheetKbn071201Dto) {
        this.allSheetKbn071201Dto = allSheetKbn071201Dto;
    }

    /**
     * 様式7の12の2を取得する
     *
     * @return 様式7の12の2
     */
    public AllSheetKbn071202Dto getAllSheetKbn071202Dto() {
        return allSheetKbn071202Dto;
    }

    /**
     * 様式7の12の2を設定する
     *
     * @param allSheetKbn071202Dto 様式7の12の2
     */
    public void setAllSheetKbn071202Dto(final AllSheetKbn071202Dto allSheetKbn071202Dto) {
        this.allSheetKbn071202Dto = allSheetKbn071202Dto;
    }

    /**
     * 様式7の12の3を取得する
     *
     * @return 様式7の12の3
     */
    public AllSheetKbn071203Dto getAllSheetKbn071203Dto() {
        return allSheetKbn071203Dto;
    }

    /**
     * 様式7の12の3を設定する
     *
     * @param allSheetKbn071203Dto 様式7の12の3
     */
    public void setAllSheetKbn071203Dto(final AllSheetKbn071203Dto allSheetKbn071203Dto) {
        this.allSheetKbn071203Dto = allSheetKbn071203Dto;
    }

}
