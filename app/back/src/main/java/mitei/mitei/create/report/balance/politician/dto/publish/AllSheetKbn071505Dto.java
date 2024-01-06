package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の5区分のシートリストデータDto
 */
public class AllSheetKbn071505Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の5 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071505PartyHostingFeeDto> list = new ArrayList<>();

    /**
     * 様式7の15の5を取得する
     *
     * @return 様式7の15の5
     */
    public List<Sheet071505PartyHostingFeeDto> getList() {
        return list;
    }

    /**
     * 様式7の15の5を設定する
     *
     * @param list 様式7の15の5
     */
    public void setList(final List<Sheet071505PartyHostingFeeDto> list) {
        this.list = list;
    }

}
