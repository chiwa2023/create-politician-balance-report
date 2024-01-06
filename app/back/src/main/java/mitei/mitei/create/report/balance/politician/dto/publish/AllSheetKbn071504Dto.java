package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の4区分のシートリストデータDto
 */
public class AllSheetKbn071504Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の4 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071504AdvertisingExpensesDto> list = new ArrayList<>();

    /**
     * 様式7の15の4を取得する
     *
     * @return 様式7の15の4
     */
    public List<Sheet071504AdvertisingExpensesDto> getList() {
        return list;
    }

    /**
     * 様式7の15の4を設定する
     *
     * @param list 様式7の15の4
     */
    public void setList(final List<Sheet071504AdvertisingExpensesDto> list) {
        this.list = list;
    }

}
