package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の8区分のシートリストデータDto
 */
public class AllSheetKbn071508Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の8 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071508DonationsGrantsDto> list = new ArrayList<>();

    /**
     * 様式7の15の8を取得する
     *
     * @return 様式7の15の8
     */
    public List<Sheet071508DonationsGrantsDto> getList() {
        return list;
    }

    /**
     * 様式7の15の8を設定する
     *
     * @param list 様式7の15の8
     */
    public void setList(final List<Sheet071508DonationsGrantsDto> list) {
        this.list = list;
    }

}
