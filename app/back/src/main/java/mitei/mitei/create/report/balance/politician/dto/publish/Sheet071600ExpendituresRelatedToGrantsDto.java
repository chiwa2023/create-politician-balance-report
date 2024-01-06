package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式17その16 交付金に係る支出を表すワークシートDto
 */
public class Sheet071600ExpendituresRelatedToGrantsDto extends AbstractWorksheet implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 項目リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ROW")
    private List<Row071600ExpendituresRelatedToGrantsProvidedDto> list=  new ArrayList<>();

    /**
     * 項目リストを取得する
     *
     * @return 項目リスト
     */
    public List<Row071600ExpendituresRelatedToGrantsProvidedDto> getList() {
        return list;
    }

    /**
     * 項目リストを設定する
     *
     * @param list 項目リスト
     */
    public void setList(final List<Row071600ExpendituresRelatedToGrantsProvidedDto> list) {
        this.list = list;
    }

    
}
