package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式7の14費用の全体データDto
 */
@JacksonXmlRootElement(localName = "SYUUSHI07_19")
public class AllSheet0719RealEstateDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 様式7の19共通リスト */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet071900RealEstateDto> listSheet0719 = new ArrayList<>();

    /**
     * 様式7の19共通リストを取得する
     *
     * @return 様式7の19共通リスト
     */
    public List<Sheet071900RealEstateDto> getListSheet0719() {
        return listSheet0719;
    }

    /**
     * 様式7の19共通リストを設定する
     *
     * @param listSheet0719 様式7の19共通リスト
     */
    public void setListSheet0719(final List<Sheet071900RealEstateDto> listSheet0719) {
        this.listSheet0719 = listSheet0719;
    }

}
