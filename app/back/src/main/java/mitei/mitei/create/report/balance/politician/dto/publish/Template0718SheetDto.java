package mitei.mitei.create.report.balance.politician.dto.publish;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7その15のテンプレートDto
 */
public class Template0718SheetDto {

    /** 項目リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ROW")
    private List<Row071800ClassificationOfAssetsByItemDto> list = new ArrayList<>();

    /**
     * 項目リストを取得する
     *
     * @return 項目リスト
     */
    public List<Row071800ClassificationOfAssetsByItemDto> getList() {
        return list;
    }

    /**
     * 項目リストを設定する
     *
     * @param list 項目リスト
     */
    public void setList(final List<Row071800ClassificationOfAssetsByItemDto> list) {
        this.list = list;
    }


}
