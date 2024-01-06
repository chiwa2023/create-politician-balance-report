package mitei.mitei.create.report.balance.politician.dto.publish;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7その15のテンプレートDto
 */
public class Template0708SheetDto extends AbstractWorksheet {  // NOPMD DataClass

    /** その他の合計 */
    @JacksonXmlProperty(localName = "SONOTA_GK")
    private String sonotaTotal;

    /** 項目リスト */
    @JacksonXmlProperty(localName = "ROW")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Row070812MediationDto> list = new ArrayList<>();

    /**
     * その他の合計を取得する
     *
     * @return その他の合計
     */
    public String getSonotaTotal() {
        return sonotaTotal;
    }

    /**
     * その他の合計を設定する
     *
     * @param sonotaTotal その他の合計
     */
    public void setSonotaTotal(final String sonotaTotal) {
        this.sonotaTotal = sonotaTotal;
    }

    /**
     * 項目リストを取得する
     *
     * @return 項目リスト
     */
    public List<Row070812MediationDto> getList() {
        return list;
    }

    /**
     * 項目リストを設定する
     *
     * @param list 項目リスト
     */
    public void setList(final List<Row070812MediationDto> list) {
        this.list = list;
    }

}
