package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式8 領収書を徴しがたかった支出項目一覧表ワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet080000DifficultCollectReceiptDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 項目リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ROW")
    private List<Row080000DifficultCollectReceiptDto> list = new ArrayList<>();

    /**
     * 項目行リストを取得する
     *
     * @return 項目行リスト
     */
    public List<Row080000DifficultCollectReceiptDto> getList() {
        return list;
    }

    /**
     * 項目行リストを設定する
     *
     * @param list 項目行リスト
     */
    public void setList(final List<Row080000DifficultCollectReceiptDto> list) {
        this.list = list;
    }

}
