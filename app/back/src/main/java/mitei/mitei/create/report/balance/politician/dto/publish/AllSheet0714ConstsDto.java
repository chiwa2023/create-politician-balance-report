package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の14費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_14")
public class AllSheet0714ConstsDto implements Serializable { //NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の14の1 */
    @JacksonXmlProperty(localName = "KUBUN1")
    private AllSheetKbn071401Dto allSheetKbn071401Dto;

    /** 様式7の14の2 */
    @JacksonXmlProperty(localName = "KUBUN2")
    private AllSheetKbn071402Dto allSheetKbn071402Dto;

    /** 様式7の14の3 */
    @JacksonXmlProperty(localName = "KUBUN3")
    private AllSheetKbn071403Dto allSheetKbn071403Dto;

    /**
     * 14の1の区分データを取得する
     *
     * @return 14の1の区分データ
     */
    public AllSheetKbn071401Dto getAllSheetKbn071401Dto() {
        return allSheetKbn071401Dto;
    }

    /**
     * 14の1の区分データを設定する
     *
     * @param allSheetKbn071401Dto 14の1の区分データ
     */
    public void setAllSheetKbn071401Dto(final AllSheetKbn071401Dto allSheetKbn071401Dto) {
        this.allSheetKbn071401Dto = allSheetKbn071401Dto;
    }

    /**
     * 14の2の区分データを取得する
     *
     * @return 14の2の区分データ
     */
    public AllSheetKbn071402Dto getAllSheetKbn071402Dto() {
        return allSheetKbn071402Dto;
    }

    /**
     * 14の2の区分データを設定する
     *
     * @param allSheetKbn071402Dto 14の2の区分データ
     */
    public void setAllSheetKbn071402Dto(final AllSheetKbn071402Dto allSheetKbn071402Dto) {
        this.allSheetKbn071402Dto = allSheetKbn071402Dto;
    }

    /**
     * 14の3の区分データを取得する
     *
     * @return 14の3の区分データ
     */
    public AllSheetKbn071403Dto getAllSheetKbn071403Dto() {
        return allSheetKbn071403Dto;
    }

    /**
     * 14の3の区分データを設定する
     *
     * @param allSheetKbn071403Dto 14の3の区分データ
     */
    public void setAllSheetKbn071403Dto(final AllSheetKbn071403Dto allSheetKbn071403Dto) {
        this.allSheetKbn071403Dto = allSheetKbn071403Dto;
    }

}
