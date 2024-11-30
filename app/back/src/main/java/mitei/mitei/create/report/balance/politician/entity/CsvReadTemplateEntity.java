package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


/**
 * csv_read_template接続用Entity
 */
@Entity
@Table(name = "csv_read_template")
public class CsvReadTemplateEntity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_STRING = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_INTEGER = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_LONG = 0L;

    /** 初期データ(Boolean) */
    private static final Boolean INIT_Boolean = false;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LOCALDATE = LocalDate.of(1948,7,29);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_TIMESTAMP  = INIT_LOCALDATE.atTime(0, 0, 0);

    /** CSV読取り仕様Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long csvReadTemplateId = INIT_LONG;

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

    /** CSV読取り仕様同一識別コード */
    private Integer csvReadTemplateCode = INIT_INTEGER;

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

    /** CSV読取り仕様名称 */
    private String csvReadTemplateName = INIT_STRING;

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

    /** 最新区分 */
    private Integer saishinKbn = INIT_INTEGER;

    /**
     * 最新区分を取得する
     *
     * @return 最新区分
     */
    @Override
    public Integer getSaishinKbn() {
        return saishinKbn;
    }

    /**
     * 最新区分を設定する
     *
     * @param saishinKbn 最新区分
     */
    @Override
    public void setSaishinKbn(final Integer saishinKbn) {
        this.saishinKbn = saishinKbn;
    }

    /** 金融機関区分 */
    private Integer financialOrgKbn = INIT_INTEGER;

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

    /** 金融機関Id */
    private Long financialOrgId = INIT_LONG;

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

    /** 金融機関同一識別コード */
    private Integer financialOrgCode = INIT_INTEGER;

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

    /** 金融機関名称 */
    private String financialOrgName = INIT_STRING;

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

    /** データヘッダ有無 */
    private Boolean hasHeader = INIT_Boolean;

    /**
     * データヘッダ有無を取得する
     *
     * @return データヘッダ有無
     */
    public Boolean getHasHeader() {
        return hasHeader;
    }

    /**
     * データヘッダ有無を設定する
     *
     * @param hasHeader データヘッダ有無
     */
    public void setHasHeader(final Boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    /** 配列桁数 */
    private Integer arrayNumber = INIT_INTEGER;

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

    /** 指定配列内容 */
    private String arrayText = INIT_STRING;

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

    /** テーブル全文検索カラム */
    private String tableAllSearchText = INIT_STRING;

    /**
     * テーブル全文検索カラムを取得する
     *
     * @return テーブル全文検索カラム
     */
    public String getTableAllSearchText() {
        return tableAllSearchText;
    }

    /**
     * テーブル全文検索カラムを設定する
     *
     * @param tableAllSearchText テーブル全文検索カラム
     */
    public void setTableAllSearchText(final String tableAllSearchText) {
        this.tableAllSearchText = tableAllSearchText;
    }

    /** 挿入ユーザId */
    private Long insertUserId = INIT_LONG;

    /**
     * 挿入ユーザIdを取得する
     *
     * @return 挿入ユーザId
     */
    @Override
    public Long getInsertUserId() {
        return insertUserId;
    }

    /**
     * 挿入ユーザIdを設定する
     *
     * @param insertUserId 挿入ユーザId
     */
    @Override
    public void setInsertUserId(final Long insertUserId) {
        this.insertUserId = insertUserId;
    }

    /** 挿入ユーザ同一識別コード */
    private Integer insertUserCode = INIT_INTEGER;

    /**
     * 挿入ユーザ同一識別コードを取得する
     *
     * @return 挿入ユーザ同一識別コード
     */
    @Override
    public Integer getInsertUserCode() {
        return insertUserCode;
    }

    /**
     * 挿入ユーザ同一識別コードを設定する
     *
     * @param insertUserCode 挿入ユーザ同一識別コード
     */
    @Override
    public void setInsertUserCode(final Integer insertUserCode) {
        this.insertUserCode = insertUserCode;
    }

    /** 挿入ユーザ姓名 */
    private String insertUserName = INIT_STRING;

    /**
     * 挿入ユーザ姓名を取得する
     *
     * @return 挿入ユーザ姓名
     */
    @Override
    public String getInsertUserName() {
        return insertUserName;
    }

    /**
     * 挿入ユーザ姓名を設定する
     *
     * @param insertUserName 挿入ユーザ姓名
     */
    @Override
    public void setInsertUserName(final String insertUserName) {
        this.insertUserName = insertUserName;
    }

    /** 挿入タイムスタンプ */
    private LocalDateTime insertTimestamp = INIT_TIMESTAMP ;

    /**
     * 挿入タイムスタンプを取得する
     *
     * @return 挿入タイムスタンプ
     */
    @Override
    public LocalDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * 挿入タイムスタンプを設定する
     *
     * @param insertTimestamp 挿入タイムスタンプ
     */
    @Override
    public void setInsertTimestamp(final LocalDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    /** 更新ユーザId */
    private Long updateUserId = INIT_LONG;

    /**
     * 更新ユーザIdを取得する
     *
     * @return 更新ユーザId
     */
    @Override
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 更新ユーザIdを設定する
     *
     * @param updateUserId 更新ユーザId
     */
    @Override
    public void setUpdateUserId(final Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /** 更新ユーザ同一識別コード */
    private Integer updateUserCode = INIT_INTEGER;

    /**
     * 更新ユーザ同一識別コードを取得する
     *
     * @return 更新ユーザ同一識別コード
     */
    @Override
    public Integer getUpdateUserCode() {
        return updateUserCode;
    }

    /**
     * 更新ユーザ同一識別コードを設定する
     *
     * @param updateUserCode 更新ユーザ同一識別コード
     */
    @Override
    public void setUpdateUserCode(final Integer updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    /** 更新ユーザ姓名 */
    private String updateUserName = INIT_STRING;

    /**
     * 更新ユーザ姓名を取得する
     *
     * @return 更新ユーザ姓名
     */
    @Override
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 更新ユーザ姓名を設定する
     *
     * @param updateUserName 更新ユーザ姓名
     */
    @Override
    public void setUpdateUserName(final String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /** 更新タイムスタンプ */
    private LocalDateTime updateTimestamp = INIT_TIMESTAMP ;

    /**
     * 更新タイムスタンプを取得する
     *
     * @return 更新タイムスタンプ
     */
    @Override
    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 更新タイムスタンプを設定する
     *
     * @param updateTimestamp 更新タイムスタンプ
     */
    @Override
    public void setUpdateTimestamp(final LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

}
