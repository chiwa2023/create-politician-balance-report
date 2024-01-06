package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の14費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_8")
public class AllSheet0708MediationDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の8の1 */
    @JacksonXmlProperty(localName = "KUBUN1")
    private AllSheetKbn070801Dto allSheetKbn070801Dto;

    /** 様式7の8の1 */
    @JacksonXmlProperty(localName = "KUBUN2")
    private AllSheetKbn070802Dto allSheetKbn070802Dto;

    /** 様式7の8の1 */
    @JacksonXmlProperty(localName = "KUBUN3")
    private AllSheetKbn070803Dto allSheetKbn070803Dto;

    /**
     * 様式7の8の1を取得する
     *
     * @return 様式7の8の1
     */
    public AllSheetKbn070801Dto getAllSheetKbn070801Dto() {
        return allSheetKbn070801Dto;
    }

    /**
     * 様式7の8の1を設定する
     *
     * @param allSheetKbn070801Dto 様式7の8の1
     */
    public void setAllSheetKbn070801Dto(final AllSheetKbn070801Dto allSheetKbn070801Dto) {
        this.allSheetKbn070801Dto = allSheetKbn070801Dto;
    }

    /**
     * 様式7の8の2を取得する
     *
     * @return 様式7の8の2
     */
    public AllSheetKbn070802Dto getAllSheetKbn070802Dto() {
        return allSheetKbn070802Dto;
    }

    /**
     * 様式7の8の2を設定する
     *
     * @param allSheetKbn070802Dto 様式7の8の2
     */
    public void setAllSheetKbn070802Dto(final AllSheetKbn070802Dto allSheetKbn070802Dto) {
        this.allSheetKbn070802Dto = allSheetKbn070802Dto;
    }

    /**
     * 様式7の8の3を取得する
     *
     * @return 様式7の8の3
     */
    public AllSheetKbn070803Dto getAllSheetKbn070803Dto() {
        return allSheetKbn070803Dto;
    }

    /**
     * 様式7の8の3を設定する
     *
     * @param allSheetKbn070803Dto 様式7の8の3
     */
    public void setAllSheetKbn070803Dto(final AllSheetKbn070803Dto allSheetKbn070803Dto) {
        this.allSheetKbn070803Dto = allSheetKbn070803Dto;
    }

}
