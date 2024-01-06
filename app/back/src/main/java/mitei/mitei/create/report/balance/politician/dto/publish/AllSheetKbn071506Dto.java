package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の6区分のシートリストデータDto
 */
public class AllSheetKbn071506Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の6 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071506OtherBusinessExpensesDto> list = new ArrayList<>();

    /**
     * 様式7の15の6を取得する
     *
     * @return 様式7の15の6
     */
    public List<Sheet071506OtherBusinessExpensesDto> getList() {
        return list;
    }

    /**
     * 様式7の15の6を設定する
     *
     * @param list 様式7の15の6
     */
    public void setList(final List<Sheet071506OtherBusinessExpensesDto> list) {
        this.list = list;
    }

}
