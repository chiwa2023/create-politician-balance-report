package mitei.mitei.create.report.balance.politician.dto.publish;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7その15のテンプレートDto
 */
public class Template0715SheetDto extends AbstractWorksheet { // NOPMD DataClass

    /** その他の合計 */
    @JacksonXmlProperty(localName = "SONOTA_GK")
    private String sonotaTotal;

    /** シートの費目 */
    @JacksonXmlProperty(localName = "HIMOKU")
    private String himoku;

    /** 項目リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ROW")
    private List<Row071415OrdinaryExpensesDto> list = new ArrayList<>();

    /**
     * その他合計取得する
     *
     * @return その他合計
     */
    public String getSonotaTotal() {
        return sonotaTotal;
    }

    /**
     * その他合計を設定する
     *
     * @param sonotaTotal その他合計
     */
    public void setSonotaTotal(final String sonotaTotal) {
        this.sonotaTotal = sonotaTotal;
    }

    /**
     * 項目リストを取得する
     *
     * @return 項目リスト
     */
    public List<Row071415OrdinaryExpensesDto> getList() {
        return list;
    }

    /**
     * 項目リストを設定する
     *
     * @param list 項目リスト
     */
    public void setList(final List<Row071415OrdinaryExpensesDto> list) {
        this.list = list;
    }

    /**
     * 費目を取得する
     *
     * @return 費目
     */
    public String getHimoku() {
        return himoku;
    }

    /**
     * 費目を設定する
     *
     * @param himoku 費目
     */
    public void setHimoku(final String himoku) {
        this.himoku = himoku;
    }

}
