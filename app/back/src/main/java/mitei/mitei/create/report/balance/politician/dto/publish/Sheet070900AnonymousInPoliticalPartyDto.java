package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式17その9 政党匿名寄付の収入を表すワークシートDto
 */
public class Sheet070900AnonymousInPoliticalPartyDto extends AbstractWorksheet implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 項目リスト */
    @JacksonXmlProperty(localName = "ROW")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Row070900AnonymousInPoliticalPartyDto> list = new ArrayList<>();

    /**
     * 項目リストを取得する
     *
     * @return 項目リスト
     */
    public List<Row070900AnonymousInPoliticalPartyDto> getList() {
        return list;
    }

    /**
     * 項目リストを設定する
     *
     * @param list 項目リスト
     */
    public void setList(final List<Row070900AnonymousInPoliticalPartyDto> list) {
        this.list = list;
    }

}
