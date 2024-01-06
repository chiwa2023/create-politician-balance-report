package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式17その10 特定パーティの対価に係る収入を表すワークシートDto
 */
public class Sheet071000SpecificPartyDto extends AbstractWorksheet implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 項目リスト */
    @JacksonXmlProperty(localName = "ROW")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Row071000SpecificPartyDto> list = new ArrayList<>();

    /**
     * リスト項目を取得する
     *
     * @return リスト項目
     */
    public List<Row071000SpecificPartyDto> getList() {
        return list;
    }

    /**
     * リスト項目を取得する
     *
     * @param list リスト項目
     */
    public void setList(final List<Row071000SpecificPartyDto> list) {
        this.list = list;
    }

}
