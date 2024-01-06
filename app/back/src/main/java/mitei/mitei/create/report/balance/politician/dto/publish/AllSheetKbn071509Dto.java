package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の9区分のシートリストデータDto
 */
public class AllSheetKbn071509Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の9 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071509OtherExpensesDto> list = new ArrayList<>();

    /**
     * 様式7の15の9を取得する
     *
     * @return 様式7の15の9
     */
    public List<Sheet071509OtherExpensesDto> getList() {
        return list;
    }

    /**
     * 様式7の15の9を設定する
     *
     * @param list 様式7の15の9
     */
    public void setList(final List<Sheet071509OtherExpensesDto> list) {
        this.list = list;
    }

}
