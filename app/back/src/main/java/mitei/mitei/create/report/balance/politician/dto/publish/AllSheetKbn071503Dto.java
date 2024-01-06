package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の15の3区分のシートリストデータDto
 */
public class AllSheetKbn071503Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の15の3 */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071503MagazinePublicationExpensesDto> list = new ArrayList<>();

    /**
     * 様式7の15の3を取得する
     *
     * @return 様式7の15の3
     */
    public List<Sheet071503MagazinePublicationExpensesDto> getList() {
        return list;
    }

    /**
     * 様式7の15の3を設定する
     *
     * @param list 様式7の15の3
     */
    public void setList(final List<Sheet071503MagazinePublicationExpensesDto> list) {
        this.list = list;
    }

}
