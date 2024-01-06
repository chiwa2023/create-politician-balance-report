package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式17その6 その他の収入を表すワークシートDto
 */
public class Sheet070600OtherIncomeDto extends AbstractWorksheet implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 基準額未満の合計 */
    @JacksonXmlProperty(localName = "MIMAN_GK")
    private String mimanTotal;

    /** 項目リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ROW")
    private List<Row070600OtherIncomeDto> list=  new ArrayList<>();

    /**
     * 未満金額の合計を取得する
     *
     * @return 未満金額
     */
    public String getMimanTotal() {
        return mimanTotal;
    }

    /**
     * 未満金額の合計を設定する
     *
     * @param mimanTotal 未満金額
     */
    public void setMimanTotal(final String mimanTotal) {
        this.mimanTotal = mimanTotal;
    }

    /**
     * 項目リストを取得する
     *
     * @return 項目リスト
     */
    public List<Row070600OtherIncomeDto> getList() {
        return list;
    }

    /**
     * 項目リストを設定する
     *
     * @param list 項目リスト
     */
    public void setList(final List<Row070600OtherIncomeDto> list) {
        this.list = list;
    }


}
