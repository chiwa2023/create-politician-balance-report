package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の11費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_11")
public class AllSheet0711ConsiderationPartyDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の11の1 */
    @JacksonXmlProperty(localName = "KUBUN1")
    private AllSheetKbn071101Dto allSheetKbn071101Dto;

    /** 様式7の11の2 */
    @JacksonXmlProperty(localName = "KUBUN2")
    private AllSheetKbn071102Dto allSheetKbn071102Dto;

    /** 様式7の11の3 */
    @JacksonXmlProperty(localName = "KUBUN3")
    private AllSheetKbn071103Dto allSheetKbn071103Dto;

    /**
     * 様式7の11の1を取得する
     *
     * @return 様式7の11の1
     */
    public AllSheetKbn071101Dto getAllSheetKbn071101Dto() {
        return allSheetKbn071101Dto;
    }

    /**
     * 様式7の11の1を設定する
     *
     * @param allSheetKbn071101Dto 様式7の11の1
     */
    public void setAllSheetKbn071101Dto(final AllSheetKbn071101Dto allSheetKbn071101Dto) {
        this.allSheetKbn071101Dto = allSheetKbn071101Dto;
    }

    /**
     * 様式7の11の2を取得する
     *
     * @return 様式7の11の2
     */
    public AllSheetKbn071102Dto getAllSheetKbn071102Dto() {
        return allSheetKbn071102Dto;
    }

    /**
     * 様式7の11の2を設定する
     *
     * @param allSheetKbn071102Dto 様式7の11の2
     */
    public void setAllSheetKbn071102Dto(final AllSheetKbn071102Dto allSheetKbn071102Dto) {
        this.allSheetKbn071102Dto = allSheetKbn071102Dto;
    }

    /**
     * 様式7の11の3を取得する
     *
     * @return 様式7の11の3
     */
    public AllSheetKbn071103Dto getAllSheetKbn071103Dto() {
        return allSheetKbn071103Dto;
    }

    /**
     * 様式7の11の3を設定する
     *
     * @param allSheetKbn071103Dto 様式7の11の3
     */
    public void setAllSheetKbn071103Dto(final AllSheetKbn071103Dto allSheetKbn071103Dto) {
        this.allSheetKbn071103Dto = allSheetKbn071103Dto;
    }

}
