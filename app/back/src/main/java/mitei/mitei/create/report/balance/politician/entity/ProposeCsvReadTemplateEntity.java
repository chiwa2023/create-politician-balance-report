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
 * propose_csv_read_template接続用Entity
 */
@Entity
@Table(name = "propose_csv_read_template")
public class ProposeCsvReadTemplateEntity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

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
    private Long proposeCsvReadTemplateId = INIT_LONG;

    /**
     * CSV読取り仕様Idを取得する
     *
     * @return CSV読取り仕様Id
     */
    public Long getProposeCsvReadTemplateId() {
        return proposeCsvReadTemplateId;
    }

    /**
     * CSV読取り仕様Idを設定する
     *
     * @param proposeCsvReadTemplateId CSV読取り仕様Id
     */
    public void setProposeCsvReadTemplateId(final Long proposeCsvReadTemplateId) {
        this.proposeCsvReadTemplateId = proposeCsvReadTemplateId;
    }

    /** CSV読取り仕様同一識別コード */
    private Integer proposeCsvReadTemplateCode = INIT_INTEGER;

    /**
     * CSV読取り仕様同一識別コードを取得する
     *
     * @return CSV読取り仕様同一識別コード
     */
    public Integer getProposeCsvReadTemplateCode() {
        return proposeCsvReadTemplateCode;
    }

    /**
     * CSV読取り仕様同一識別コードを設定する
     *
     * @param proposeCsvReadTemplateCode CSV読取り仕様同一識別コード
     */
    public void setProposeCsvReadTemplateCode(final Integer proposeCsvReadTemplateCode) {
        this.proposeCsvReadTemplateCode = proposeCsvReadTemplateCode;
    }

    /** CSV読取り仕様名称 */
    private String proposeCsvReadTemplateName = INIT_STRING;

    /**
     * CSV読取り仕様名称を取得する
     *
     * @return CSV読取り仕様名称
     */
    public String getProposeCsvReadTemplateName() {
        return proposeCsvReadTemplateName;
    }

    /**
     * CSV読取り仕様名称を設定する
     *
     * @param proposeCsvReadTemplateName CSV読取り仕様名称
     */
    public void setProposeCsvReadTemplateName(final String proposeCsvReadTemplateName) {
        this.proposeCsvReadTemplateName = proposeCsvReadTemplateName;
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

    /** ヘッダ有無 */
    private Boolean hasHeader = INIT_Boolean;

    /**
     * ヘッダ有無を取得する
     *
     * @return ヘッダ有無
     */
    public Boolean getHasHeader() {
        return hasHeader;
    }

    /**
     * ヘッダ有無を設定する
     *
     * @param hasHeader ヘッダ有無
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

    /** 編集中読み取り仕様Id */
    private Long editId = INIT_LONG;

    /**
     * 編集中読み取り仕様Idを取得する
     *
     * @return 編集中読み取り仕様Id
     */
    public Long getEditId() {
        return editId;
    }

    /**
     * 編集中読み取り仕様Idを設定する
     *
     * @param editId 編集中読み取り仕様Id
     */
    public void setEditId(final Long editId) {
        this.editId = editId;
    }

    /** 申請継続中該否 */
    private Boolean inProsessing = INIT_Boolean;

    /**
     * 申請継続中該否を取得する
     *
     * @return 申請継続中該否
     */
    public Boolean getInProsessing() {
        return inProsessing;
    }

    /**
     * 申請継続中該否を設定する
     *
     * @param inProsessing 申請継続中該否
     */
    public void setInProsessing(final Boolean inProsessing) {
        this.inProsessing = inProsessing;
    }

    /** 申請承認該否 */
    private Boolean isAccepted = INIT_Boolean;

    /**
     * 申請承認該否を取得する
     *
     * @return 申請承認該否
     */
    public Boolean getIsAccepted() {
        return isAccepted;
    }

    /**
     * 申請承認該否を設定する
     *
     * @param isAccepted 申請承認該否
     */
    public void setIsAccepted(final Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    /** 判定理由 */
    private String judgeReason = INIT_STRING;

    /**
     * 判定理由を取得する
     *
     * @return 判定理由
     */
    public String getJudgeReason() {
        return judgeReason;
    }

    /**
     * 判定理由を設定する
     *
     * @param judgeReason 判定理由
     */
    public void setJudgeReason(final String judgeReason) {
        this.judgeReason = judgeReason;
    }

    /** 書証Id */
    private String shoshouId = INIT_STRING;

    /**
     * 書証Idを取得する
     *
     * @return 書証Id
     */
    public String getShoshouId() {
        return shoshouId;
    }

    /**
     * 書証Idを設定する
     *
     * @param shoshouId 書証Id
     */
    public void setShoshouId(final String shoshouId) {
        this.shoshouId = shoshouId;
    }


    /** 書証同一識別コード */
    private Long shoshouCode = INIT_LONG;

    /**
     * 書証同一識別コードを取得する
     *
     * @return 書証同一識別コード
     */
    public Long getShoshouCode() {
        return shoshouCode;
    }

    /**
     * 書証同一識別コードを設定する
     *
     * @param shoshouCode 書証同一識別コード
     */
    public void setShoshouCode(final Long shoshouCode) {
        this.shoshouCode = shoshouCode;
    }

    /** 書証区分 */
    private Integer shoshouKbn = INIT_INTEGER;

    /**
     * 書証区分を取得する
     *
     * @return 書証区分
     */
    public Integer getShoshouKbn() {
        return shoshouKbn;
    }

    /**
     * 書証区分を設定する
     *
     * @param shoshouKbn 書証区分
     */
    public void setShoshouKbn(final Integer shoshouKbn) {
        this.shoshouKbn = shoshouKbn;
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
