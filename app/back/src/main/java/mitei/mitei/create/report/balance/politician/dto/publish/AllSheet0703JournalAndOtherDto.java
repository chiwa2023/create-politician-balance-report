package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の3機関誌発光の収入の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_03")
public class AllSheet0703JournalAndOtherDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の3 */
    @JacksonXmlProperty(localName = "SHEET")
    private Sheet070300JournalAndOtherDto sheet070300JournalAndOtherDto;

    /**
     * 様式7の3のシートを取得する
     *
     * @return 様式7の3のシート
     */
    public Sheet070300JournalAndOtherDto getSheet070300JournalAndOtherDto() {
        return sheet070300JournalAndOtherDto;
    }

    /**
     * 様式7の3のシートを取得する
     *
     * @param sheet070300JournalAndOtherDto 様式7の3のシート
     */
    public void setSheet070300JournalAndOtherDto(final Sheet070300JournalAndOtherDto sheet070300JournalAndOtherDto) {
        this.sheet070300JournalAndOtherDto = sheet070300JournalAndOtherDto;
    }

}
