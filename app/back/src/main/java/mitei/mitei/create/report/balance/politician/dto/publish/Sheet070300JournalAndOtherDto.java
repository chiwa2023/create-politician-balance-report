package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式17その3 機関誌とその他の事業の収入を表すワークシートDto
 */
public class Sheet070300JournalAndOtherDto extends AbstractWorksheet implements Serializable{

    /** serialId */
    private static final long serialVersionUID = 1L;
   
    /** 項目リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ROW")
    private List<Row070300JournalAndOtherDto> list=  new ArrayList<>();

    /**
     * 項目行リストを取得する
     *
     * @return 項目行リスト
     */
    public List<Row070300JournalAndOtherDto> getList() {
        return list;
    }

    /**
     * 項目行リストを設定する
     *
     * @param list 項目行リスト
     */
    public void setList(final List<Row070300JournalAndOtherDto> list) {
        this.list = list;
    }

    
}
