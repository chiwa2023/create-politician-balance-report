package mitei.mitei.create.report.balance.politician.entity.sns.mock;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import mitei.mitei.create.report.balance.politician.entity.AllTabeDataHistoryInterface;



/**
 * sns_dm_setting_mock_sample2接続用Entity
 */
@Entity
@Table(name = "sns_dm_setting_mock_sample2")
public class SnsDmSettingMockSample2Entity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_Long = 0L;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LocalDate = LocalDate.of(1948,7,29);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_LocalDateTime = INIT_LocalDate.atTime(0, 0, 0);

    /** 項目名称取得Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mock_sample2_id")
    private Long mockSample2Id = INIT_Long;

    /**
     * 項目名称取得Idを取得する
     *
     * @return 項目名称取得Id
     */
    public Long getMockSample2Id() {
        return mockSample2Id;
    }

    /**
     * 項目名称取得Idを設定する
     *
     * @param mockSample2Id 項目名称取得Id
     */
    public void setMockSample2Id(final Long mockSample2Id) {
        this.mockSample2Id = mockSample2Id;
    }

    /** 項目名称取得同一識別コード */
    @Column(name = "mock_sample2_code")
    private Integer mockSample2Code = INIT_Integer;

    /**
     * 項目名称取得同一識別コードを取得する
     *
     * @return 項目名称取得同一識別コード
     */
    public Integer getMockSample2Code() {
        return mockSample2Code;
    }

    /**
     * 項目名称取得同一識別コードを設定する
     *
     * @param mockSample2Code 項目名称取得同一識別コード
     */
    public void setMockSample2Code(final Integer mockSample2Code) {
        this.mockSample2Code = mockSample2Code;
    }

    /** 最新区分 */
    @Column(name = "saishin_kbn")
    private Integer saishinKbn = INIT_Integer;

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

    /** ログインユーザId */
    @Column(name = "login_user_id")
    private Long loginUserId = INIT_Long;

    /**
     * ログインユーザIdを取得する
     *
     * @return ログインユーザId
     */
    public Long getLoginUserId() {
        return loginUserId;
    }

    /**
     * ログインユーザIdを設定する
     *
     * @param loginUserId ログインユーザId
     */
    public void setLoginUserId(final Long loginUserId) {
        this.loginUserId = loginUserId;
    }

    /** ログインユーザ同一識別コード */
    @Column(name = "login_user_code")
    private Integer loginUserCode = INIT_Integer;

    /**
     * ログインユーザ同一識別コードを取得する
     *
     * @return ログインユーザ同一識別コード
     */
    public Integer getLoginUserCode() {
        return loginUserCode;
    }

    /**
     * ログインユーザ同一識別コードを設定する
     *
     * @param loginUserCode ログインユーザ同一識別コード
     */
    public void setLoginUserCode(final Integer loginUserCode) {
        this.loginUserCode = loginUserCode;
    }

    /** ログインユーザ名称 */
    @Column(name = "login_user_name")
    private String loginUserName = INIT_String;

    /**
     * ログインユーザ名称を取得する
     *
     * @return ログインユーザ名称
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * ログインユーザ名称を設定する
     *
     * @param loginUserName ログインユーザ名称
     */
    public void setLoginUserName(final String loginUserName) {
        this.loginUserName = loginUserName;
    }

    /** アカウントId */
    @Column(name = "account_id")
    private String accountId = INIT_String;

    /**
     * アカウントIdを取得する
     *
     * @return アカウントId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * アカウントIdを設定する
     *
     * @param accountId アカウントId
     */
    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    /** アクセスキー1 */
    @Column(name = "access_key1")
    private String accessKey1 = INIT_String;

    /**
     * アクセスキー1を取得する
     *
     * @return アクセスキー1
     */
    public String getAccessKey1() {
        return accessKey1;
    }

    /**
     * アクセスキー1を設定する
     *
     * @param accessKey1 アクセスキー1
     */
    public void setAccessKey1(final String accessKey1) {
        this.accessKey1 = accessKey1;
    }

    /** アクセスキー2 */
    @Column(name = "access_key2")
    private String accessKey2 = INIT_String;

    /**
     * アクセスキー2を取得する
     *
     * @return アクセスキー2
     */
    public String getAccessKey2() {
        return accessKey2;
    }

    /**
     * アクセスキー2を設定する
     *
     * @param accessKey2 アクセスキー2
     */
    public void setAccessKey2(final String accessKey2) {
        this.accessKey2 = accessKey2;
    }

    /** 挿入ユーザId */
    @Column(name = "insert_user_id")
    private Long insertUserId = INIT_Long;

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
    @Column(name = "insert_user_code")
    private Integer insertUserCode = INIT_Integer;

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
    @Column(name = "insert_user_name")
    private String insertUserName = INIT_String;

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
    @Column(name = "insert_timestamp")
    private LocalDateTime insertTimestamp = INIT_LocalDateTime;

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
    @Column(name = "update_user_id")
    private Long updateUserId = INIT_Long;

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
    @Column(name = "update_user_code")
    private Integer updateUserCode = INIT_Integer;

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
    @Column(name = "update_user_name")
    private String updateUserName = INIT_String;

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
    @Column(name = "update_timestamp")
    private LocalDateTime updateTimestamp = INIT_LocalDateTime;

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
