package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の7費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_7")
public class AllSheet0707DonateDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の7の1 */
    @JacksonXmlProperty(localName = "KUBUN1")
    private AllSheetKbn070701Dto allSheetKbn070701Dto;

    /** 様式7の7の1 */
    @JacksonXmlProperty(localName = "KUBUN2")
    private AllSheetKbn070702Dto allSheetKbn070702Dto;

    /** 様式7の7の1 */
    @JacksonXmlProperty(localName = "KUBUN3")
    private AllSheetKbn070703Dto allSheetKbn070703Dto;

    /**
     * 様式7の7の1を取得する
     *
     * @return 様式7の7の1
     */
    public AllSheetKbn070701Dto getAllSheetKbn070701Dto() {
        return allSheetKbn070701Dto;
    }

    /**
     * 様式7の7の1を設定する
     *
     * @param allSheetKbn070701Dto 様式7の7の1
     */
    public void setAllSheetKbn070701Dto(final AllSheetKbn070701Dto allSheetKbn070701Dto) {
        this.allSheetKbn070701Dto = allSheetKbn070701Dto;
    }

    /**
     * 様式7の7の2を取得する
     *
     * @return 様式7の7の2
     */
    public AllSheetKbn070702Dto getAllSheetKbn070702Dto() {
        return allSheetKbn070702Dto;
    }

    /**
     * 様式7の7の2を設定する
     *
     * @param allSheetKbn070702Dto 様式7の7の2
     */
    public void setAllSheetKbn070702Dto(final AllSheetKbn070702Dto allSheetKbn070702Dto) {
        this.allSheetKbn070702Dto = allSheetKbn070702Dto;
    }

    /**
     * 様式7の7の3を取得する
     *
     * @return 様式7の7の3
     */
    public AllSheetKbn070703Dto getAllSheetKbn070703Dto() {
        return allSheetKbn070703Dto;
    }

    /**
     * 様式7の7の3を設定する
     *
     * @param allSheetKbn070703Dto 様式7の7の3
     */
    public void setAllSheetKbn070703Dto(final AllSheetKbn070703Dto allSheetKbn070703Dto) {
        this.allSheetKbn070703Dto = allSheetKbn070703Dto;
    }

}
