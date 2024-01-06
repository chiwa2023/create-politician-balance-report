package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の11の1特定パーティ(個人)区分のシートリストデータDto
 */
public class AllSheetKbn071102Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の11の2リスト */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "SHEET")
    private List<Sheet071102ConsiderationPartyGroupDto> list = new ArrayList<>();

    /**
     * 様式7の11の2リストを取得する
     *
     * @return 様式7の11の2リスト
     */
    public List<Sheet071102ConsiderationPartyGroupDto> getList() {
        return list;
    }

    /**
     * 様式7の11の2リストを設定する
     *
     * @param list 様式7の11の2リスト
     */
    public void setList(final List<Sheet071102ConsiderationPartyGroupDto> list) {
        this.list = list;
    }

}
