package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 全「Book」XMLを表現するDto 
 * 互換性のためには…Excelじゃないけど「Book」root必要(笑)
 */
@JacksonXmlRootElement(localName = "BOOK")
public class AllBookDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** ブックヘッダ */
    @JacksonXmlProperty(localName = "HEAD")
    private AllBookHeaderDto allBookHeaderDto;

    /** 入力有無フラグ */
    @JacksonXmlProperty(localName = "SYUUSHI_UMU_FLG")
    private AllBookUmuInputDataDto allBookUmuInputDataDto;

    /** シート1 */
    @JacksonXmlProperty(localName = "SYUUSHI07_01")
    private AllSheet0701CoverAndOrganizationDetailsDto allSheet0701CoverAndOrganizationDetailsDto;

    // TODO 2-19シート

    
    
    
    
    
    
    
    
    
    
    
    /**
     * Bookヘッダを取得する
     *
     * @return Bookヘッダ
     */
    public AllBookHeaderDto getAllBookHeaderDto() {
        return allBookHeaderDto;
    }

    /**
     * Bookヘッダ設定する
     *
     * @param allBookHeaderDto Bookヘッダ
     */
    public void setAllBookHeaderDto(final AllBookHeaderDto allBookHeaderDto) {
        this.allBookHeaderDto = allBookHeaderDto;
    }

    /**
     * 入力有無フラグテキストを取得する
     *
     * @return 入力有無フラグテキスト
     */
    public AllBookUmuInputDataDto getAllBookUmuInputDataDto() {
        return allBookUmuInputDataDto;
    }

    /**
     * 入力有無フラグテキスト設定する
     *
     * @param allBookUmuInputDataDto 入力有無フラグテキスト
     */
    public void setAllBookUmuInputDataDto(final AllBookUmuInputDataDto allBookUmuInputDataDto) {
        this.allBookUmuInputDataDto = allBookUmuInputDataDto;
    }

    /**
     * シート1を取得する
     *
     * @return シート1
     */
    public AllSheet0701CoverAndOrganizationDetailsDto getAllSheet0701CoverAndOrganizationDetailsDto() {
        return allSheet0701CoverAndOrganizationDetailsDto;
    }

    /**
     * シート1を設定する
     *
     * @param allSheet0701CoverAndOrganizationDetailsDto シート1
     */
    public void setAllSheet0701CoverAndOrganizationDetailsDto(
            final AllSheet0701CoverAndOrganizationDetailsDto allSheet0701CoverAndOrganizationDetailsDto) {
        this.allSheet0701CoverAndOrganizationDetailsDto = allSheet0701CoverAndOrganizationDetailsDto;
    }

}
