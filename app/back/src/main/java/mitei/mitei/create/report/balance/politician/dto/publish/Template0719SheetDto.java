package mitei.mitei.create.report.balance.politician.dto.publish;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7その15のテンプレートDto
 */
public class Template0719SheetDto { // NOPMD DataClass

    /** 区分 */
    @JacksonXmlProperty(localName = "KUBUN")
    private Integer kbnRealEstitate;

    /** 項目リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ROW")
    private List<Row071900CurrentStatusOfRealEstateUseDto> list = new ArrayList<>();

    /**
     * 項目リストを取得する
     *
     * @return 項目リスト
     */
    public List<Row071900CurrentStatusOfRealEstateUseDto> getList() {
        return list;
    }

    /**
     * 項目リストを設定する
     *
     * @param list 項目リスト
     */
    public void setList(final List<Row071900CurrentStatusOfRealEstateUseDto> list) {
        this.list = list;
    }

    /**
     * 不動産区分を取得する
     *
     * @return 不動産区分
     */
    public Integer getKbnRealEstitate() {
        return kbnRealEstitate;
    }

    /**
     * 不動産区分を設定する
     *
     * @param kbnRealEstitate 不動産区分
     */
    public void setKbnRealEstitate(final Integer kbnRealEstitate) {
        this.kbnRealEstitate = kbnRealEstitate;
    }

}
