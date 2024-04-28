package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * CsvReadTemplateEntiy
 */
@Entity
@Table(name = "csv_read_template")
public class CsvReadTemplateEntity implements Serializable { // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 金融機関区分 */
    private Integer financialOrgKbn;

    /**
     * 金融機関区分を取得する
     *
     * @return 金融機関区分
     */
    public Integer getFinancialOrgKbn() {
        return financialOrgKbn;
    }

    /**
     * 金融機関区分を設定する
     *
     * @param financialOrgKbn 金融機関区分
     */
    public void setFinancialOrgKbn(final Integer financialOrgKbn) {
        this.financialOrgKbn = financialOrgKbn;
    }

    /** 金融機関同一識別コード */
    private Integer financialOrgCode;

    /**
     * 金融機関同一識別コードを取得する
     *
     * @return 金融機関同一識別コード
     */
    public Integer getFinancialOrgCode() {
        return financialOrgCode;
    }

    /**
     * 金融機関同一識別コードを設定する
     *
     * @param financialOrgCode 金融機関同一識別コード
     */
    public void setFinancialOrgCode(final Integer financialOrgCode) {
        this.financialOrgCode = financialOrgCode;
    }

    /** CSV読取り仕様同一識別コード */
    private Integer csvReadTemplateCode;

    /**
     * CSV読取り仕様同一識別コードを取得する
     *
     * @return CSV読取り仕様同一識別コード
     */
    public Integer getCsvReadTemplateCode() {
        return csvReadTemplateCode;
    }

    /**
     * CSV読取り仕様同一識別コードを設定する
     *
     * @param csvReadTemplateCode CSV読取り仕様同一識別コード
     */
    public void setCsvReadTemplateCode(final Integer csvReadTemplateCode) {
        this.csvReadTemplateCode = csvReadTemplateCode;
    }

    /** 更新時間 */
    private Timestamp updateTime;

    /**
     * 更新時間を取得する
     *
     * @return 更新時間
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新時間を設定する
     *
     * @param updateTime 更新時間
     */
    public void setUpdateTime(final Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /** 最新区分 */
    private Integer saishinKbn;

    /**
     * 最新区分を取得する
     *
     * @return 最新区分
     */
    public Integer getSaishinKbn() {
        return saishinKbn;
    }

    /**
     * 最新区分を設定する
     *
     * @param saishinKbn 最新区分
     */
    public void setSaishinKbn(final Integer saishinKbn) {
        this.saishinKbn = saishinKbn;
    }

    /** CSV読取り仕様Id */
    @Id
    private Long csvReadTemplateId;

    /**
     * CSV読取り仕様Idを取得する
     *
     * @return CSV読取り仕様Id
     */
    public Long getCsvReadTemplateId() {
        return csvReadTemplateId;
    }

    /**
     * CSV読取り仕様Idを設定する
     *
     * @param csvReadTemplateId CSV読取り仕様Id
     */
    public void setCsvReadTemplateId(final Long csvReadTemplateId) {
        this.csvReadTemplateId = csvReadTemplateId;
    }

    /** CSV読取り仕様名称 */
    private String csvReadTemplateName;

    /**
     * CSV読取り仕様名称を取得する
     *
     * @return CSV読取り仕様名称
     */
    public String getCsvReadTemplateName() {
        return csvReadTemplateName;
    }

    /**
     * CSV読取り仕様名称を設定する
     *
     * @param csvReadTemplateName CSV読取り仕様名称
     */
    public void setCsvReadTemplateName(final String csvReadTemplateName) {
        this.csvReadTemplateName = csvReadTemplateName;
    }

    /** 指定配列内容 */
    private String arrayText;

    /**
     * 指定配列内容を取得する
     *
     * @return 指定配列内容
     */
    public String getArrayText() {
        return arrayText;
    }

    /**
     * 指定配列内容を設定する
     *
     * @param arrayText 指定配列内容
     */
    public void setArrayText(final String arrayText) {
        this.arrayText = arrayText;
    }

    /** 金融機関名称 */
    private String financialOrgName;

    /**
     * 金融機関名称を取得する
     *
     * @return 金融機関名称
     */
    public String getFinancialOrgName() {
        return financialOrgName;
    }

    /**
     * 金融機関名称を設定する
     *
     * @param financialOrgName 金融機関名称
     */
    public void setFinancialOrgName(final String financialOrgName) {
        this.financialOrgName = financialOrgName;
    }

    /** 金融機関Id */
    private Long financialOrgId;

    /**
     * 金融機関Idを取得する
     *
     * @return 金融機関Id
     */
    public Long getFinancialOrgId() {
        return financialOrgId;
    }

    /**
     * 金融機関Idを設定する
     *
     * @param financialOrgId 金融機関Id
     */
    public void setFinancialOrgId(final Long financialOrgId) {
        this.financialOrgId = financialOrgId;
    }

    /** 配列桁数 */
    private Integer arrayNumber;

    /**
     * 配列桁数を取得する
     *
     * @return 配列桁数
     */
    public Integer getArrayNumber() {
        return arrayNumber;
    }

    /**
     * 配列桁数を設定する
     *
     * @param arrayNumber 配列桁数
     */
    public void setArrayNumber(final Integer arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

}
