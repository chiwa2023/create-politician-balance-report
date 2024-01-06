package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の1区分のシートリストデータDto
 */
public class AllSheetKbn071501Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の1 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071501OrganizationalActivityExpensesDto> list = new ArrayList<>();

    /**
     * 様式7の15の1シートリストを取得する
     *
     * @return 様式7の15の1シートリスト
     */
    public List<Sheet071501OrganizationalActivityExpensesDto> getList() {
        return list;
    }

    /**
     * 様式7の15の1シートリストを設定する
     *
     * @param list 様式7の15の1シートリスト
     */
    public void setList(final List<Sheet071501OrganizationalActivityExpensesDto> list) {
        this.list = list;
    }

}
