package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の7区分のシートリストデータDto
 */
public class AllSheetKbn071507Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の7 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071507ResearchExpensesDto> list = new ArrayList<>();

    /**
     * 様式7の15の7を取得する
     *
     * @return 様式7の15の7
     */
    public List<Sheet071507ResearchExpensesDto> getList() {
        return list;
    }

    /**
     * 様式7の15の7を設定する
     *
     * @param list 様式7の15の7
     */
    public void setList(final List<Sheet071507ResearchExpensesDto> list) {
        this.list = list;
    }

}
