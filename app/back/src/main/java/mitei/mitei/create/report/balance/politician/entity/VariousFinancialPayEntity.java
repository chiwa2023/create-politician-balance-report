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
 * various_financial_pay接続用Entity
 */
@Entity
@Table(name = "various_financial_pay")
public class VariousFinancialPayEntity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_STRING = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_INTEGER = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_LONG = 0L;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LOCALDATE = LocalDate.of(1948,7,29);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_TIMESTAMP  = INIT_LOCALDATE.atTime(0, 0, 0);

    /** 各種PayId */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variousFinancialPayId = INIT_LONG;

    /**
     * 各種PayIdを取得する
     *
     * @return 各種PayId
     */
    public Long getVariousFinancialPayId() {
        return variousFinancialPayId;
    }

    /**
     * 各種PayIdを設定する
     *
     * @param variousFinancialPayId 各種PayId
     */
    public void setVariousFinancialPayId(final Long variousFinancialPayId) {
        this.variousFinancialPayId = variousFinancialPayId;
    }

    /** 各種Pay同一識別コード */
    private Integer variousFinancialPayCode = INIT_INTEGER;

    /**
     * 各種Pay同一識別コードを取得する
     *
     * @return 各種Pay同一識別コード
     */
    public Integer getVariousFinancialPayCode() {
        return variousFinancialPayCode;
    }

    /**
     * 各種Pay同一識別コードを設定する
     *
     * @param variousFinancialPayCode 各種Pay同一識別コード
     */
    public void setVariousFinancialPayCode(final Integer variousFinancialPayCode) {
        this.variousFinancialPayCode = variousFinancialPayCode;
    }

    /** 各種Pay名称 */
    private String variousFinancialPayName = INIT_STRING;

    /**
     * 各種Pay名称を取得する
     *
     * @return 各種Pay名称
     */
    public String getVariousFinancialPayName() {
        return variousFinancialPayName;
    }

    /**
     * 各種Pay名称を設定する
     *
     * @param variousFinancialPayName 各種Pay名称
     */
    public void setVariousFinancialPayName(final String variousFinancialPayName) {
        this.variousFinancialPayName = variousFinancialPayName;
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
