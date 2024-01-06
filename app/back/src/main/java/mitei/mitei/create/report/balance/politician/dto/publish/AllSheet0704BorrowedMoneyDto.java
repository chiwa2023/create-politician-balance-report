package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の4費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_04")
public class AllSheet0704BorrowedMoneyDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の4 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070400BorrowedMoneyDto sheet070400BorrowedMoneyDto;

    /**
     * 様式7の4のシートを取得する
     *
     * @return 様式7の4のシート
     */
    public Sheet070400BorrowedMoneyDto getSheet070400BorrowedMoneyDto() {
        return sheet070400BorrowedMoneyDto;
    }

    /**
     * 様式7の4のシートを設定する
     *
     * @param sheet070400BorrowedMoneyDto 様式7の4のシート
     */
    public void setSheet070400BorrowedMoneyDto(final Sheet070400BorrowedMoneyDto sheet070400BorrowedMoneyDto) {
        this.sheet070400BorrowedMoneyDto = sheet070400BorrowedMoneyDto;
    }

}
