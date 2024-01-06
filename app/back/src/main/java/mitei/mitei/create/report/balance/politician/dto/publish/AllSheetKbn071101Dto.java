package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の11の1特定パーティ(個人)区分のシートリストデータDto
 */
public class AllSheetKbn071101Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の11の1リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "SHEET")
    private List<Sheet071101ConsiderationPartyPerspnalDto> list = new ArrayList<>();

    /**
     * 様式7の11の1リストを取得する
     *
     * @return 様式7の11の1リスト
     */
    public List<Sheet071101ConsiderationPartyPerspnalDto> getList() {
        return list;
    }

    /**
     * 様式7の11の1リストを設定する
     *
     * @param list 様式7の11の1リスト
     */
    public void setList(final List<Sheet071101ConsiderationPartyPerspnalDto> list) {
        this.list = list;
    }

}
