package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 様式7の12の1特定パーティのうち斡旋による(個人)のシートリストデータDto
 */
public class AllSheetKbn071203Dto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の12の3リスト */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071203ConsiderationMediationPartyPoliticOrgDto> list = new ArrayList<>();

    /**
     * 様式7の12の3リストを取得する
     *
     * @return 様式7の12の3リスト
     */
    public List<Sheet071203ConsiderationMediationPartyPoliticOrgDto> getList() {
        return list;
    }

    /**
     * 様式7の12の3リストを設定する
     *
     * @param list 様式7の12の3リスト
     */
    public void setList(final List<Sheet071203ConsiderationMediationPartyPoliticOrgDto> list) {
        this.list = list;
    }


}
