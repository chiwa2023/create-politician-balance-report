package mitei.mitei.create.report.balance.politician.dto.institution_csv;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.SelectOptionDto;

/**
 * csv読み取り仕様テーブルDto
 */
public class CsvReadTemplateDto extends SelectOptionDto implements Serializable{ // NOPMD DataClass

    private static final long serialVersionUID = 1L;

    /** csv指定配列  */
    private String arrayText;

    /** 金融機関Id  */
    private Long finacialOrgId;

    /** 金融機関区分  */
    private Integer finacialOrgKbn;

    /** 金融機関同一識別コード  */
    private Integer finacialOrgCode;

    /** 金融機関名称  */
    private String finacialOrgName;

    /**
     * @return
     */
    public Long getFinacialOrgId() {
        return finacialOrgId;
    }

    /**
     * @param finacialOrgId
     */
    public void setFinacialOrgId(final Long finacialOrgId) {
        this.finacialOrgId = finacialOrgId;
    }

    /**
     * @return
     */
    public Integer getFinacialOrgKbn() {
        return finacialOrgKbn;
    }

    /**
     * @param finacialOrgKbn
     */
    public void setFinacialOrgKbn(final Integer finacialOrgKbn) {
        this.finacialOrgKbn = finacialOrgKbn;
    }

    /**
     * @return
     */
    public Integer getFinacialOrgCode() {
        return finacialOrgCode;
    }

    /**
     * @param finacialOrgCode
     */
    public void setFinacialOrgCode(final Integer finacialOrgCode) {
        this.finacialOrgCode = finacialOrgCode;
    }

    /**
     * @return
     */
    public String getFinacialOrgName() {
        return finacialOrgName;
    }

    /**
     * @param finacialOrgName
     */
    public void setFinacialOrgName(final String finacialOrgName) {
        this.finacialOrgName = finacialOrgName;
    }

    public String getArrayText() {
        return arrayText;
    }

    public void setArrayText(String arrayText) {
        this.arrayText = arrayText;
    }

}
