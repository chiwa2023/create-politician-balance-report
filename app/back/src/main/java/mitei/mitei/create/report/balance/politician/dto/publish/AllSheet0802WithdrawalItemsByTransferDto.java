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
@JacksonXmlRootElement(localName = "SYUUSHI08_02")
public class AllSheet0802WithdrawalItemsByTransferDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 振込明細書に係る支出項目リスト */
    @JacksonXmlProperty(localName = "SHEET")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Sheet080200WithdrawalItemsByTransferDto> listSheet0802 = new ArrayList<>();

    /**
     * 振込明細書に係る支出項目リストを取得する
     *
     * @return 振込明細書に係る支出項目リスト
     */
    public List<Sheet080200WithdrawalItemsByTransferDto> getListSheet0802() {
        return listSheet0802;
    }

    /**
     * 振込明細書に係る支出項目リストを設定する
     *
     * @param listSheet0802 振込明細書に係る支出項目リスト
     */
    public void setListSheet0802(final List<Sheet080200WithdrawalItemsByTransferDto> listSheet0802) {
        this.listSheet0802 = listSheet0802;
    }

}
