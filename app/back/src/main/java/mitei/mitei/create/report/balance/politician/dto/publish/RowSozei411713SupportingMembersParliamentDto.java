package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 国会議員を支援する団体で寄付控除を受けるときに国会議員の名前を申告するDto
 */
public class RowSozei411713SupportingMembersParliamentDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 国会議員名 */
    @JacksonXmlProperty(localName = "GIIN_NM")
    private String giinName;

    /**
     * 国会議員名を取得する
     *
     * @return 国会議員名
     */
    public String getGiinName() {
        return giinName;
    }

    /**
     * 国会議員名を設定する
     *
     * @param giinName 国会議員名
     */
    public void setGiinName(final String giinName) {
        this.giinName = giinName;
    }

}
