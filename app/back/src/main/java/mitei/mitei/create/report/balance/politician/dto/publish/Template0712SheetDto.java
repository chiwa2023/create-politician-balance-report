package mitei.mitei.create.report.balance.politician.dto.publish;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7その15のテンプレートDto
 */
public class Template0712SheetDto extends AbstractWorksheet { // NOPMD DataClass

    /** パーティ名称 */
    @JacksonXmlProperty(localName = "PATYI_NM")
    private String partyName;

    /** 通し番号 */
    @JacksonXmlProperty(localName = "SORT_NO")
    private Integer sortNo;

    /** 項目リスト */
    @JacksonXmlProperty(localName = "ROW")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Row070812MediationDto> list = new ArrayList<>();

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

    /**
     * パーティ名称を取得する
     *
     * @return パーティ名称
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * パーティ名称を設定する
     *
     * @param partyName パーティ名称
     */
    public void setPartyName(final String partyName) {
        this.partyName = partyName;
    }

    /**
     * 並び順を取得する
     *
     * @return 並び順
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 並び順を設定する
     *
     * @param sortNo 並び順
     */
    public void setSortNo(final Integer sortNo) {
        this.sortNo = sortNo;
    }

}
