package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;


/**
 * task_plan_2024接続用Entity
 */
@Entity
@Table(name = "task_plan_2024")
public class TaskPlan2024Entity  implements Serializable,TaskPlanInterface{ // NOPMD DataClass

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
    private static final LocalDate INIT_LOCALDATE = LocalDate.of(1980,1,1);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_TIMESTAMP  = INIT_LOCALDATE.atTime(0, 0, 0);

    /** タスク予定Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskPlanId = INIT_LONG;

    /**
     * タスク予定Idを取得する
     *
     * @return タスク予定Id
     */
    @Override
    public Long getTaskPlanId() {
        return taskPlanId;
    }

    /**
     * タスク予定Idを設定する
     *
     * @param taskPlanId タスク予定Id
     */
    @Override
    public void setTaskPlanId(final Long taskPlanId) {
        this.taskPlanId = taskPlanId;
    }

    /** タスク予定同一識別コード */
    private Long taskPlanCode = INIT_LONG;

    /**
     * タスク予定同一識別コードを取得する
     *
     * @return タスク予定同一識別コード
     */
    @Override
    public Long getTaskPlanCode() {
        return taskPlanCode;
    }

    /**
     * タスク予定同一識別コードを設定する
     *
     * @param taskPlanCode タスク予定同一識別コード
     */
    @Override
    public void setTaskPlanCode(final Long taskPlanCode) {
        this.taskPlanCode = taskPlanCode;
    }

    /** タスク予定名称  */
    private String taskPlanName = INIT_STRING;

    /**
     * タスク予定名称を取得する
     *
     * @return タスク予定名称
     */
    @Override
    public String getTaskPlanName() {
        return taskPlanName;
    }

    /**
     * タスク予定名称を設定する
     *
     * @param taskPlanName タスク予定名称
     */
    @Override
    public void setTaskPlanName(final String taskPlanName) {
        this.taskPlanName = taskPlanName;
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

    /** 政治団体Id */
    private Long politicalOrganizationId = INIT_LONG;

    /**
     * 政治団体Idを取得する
     *
     * @return 政治団体Id
     */
    @Override
    public Long getPoliticalOrganizationId() {
        return politicalOrganizationId;
    }

    /**
     * 政治団体Idを設定する
     *
     * @param politicalOrganizationId 政治団体Id
     */
    @Override
    public void setPoliticalOrganizationId(final Long politicalOrganizationId) {
        this.politicalOrganizationId = politicalOrganizationId;
    }

    /** 政治団体同一識別コード */
    private Integer politicalOrganizationCode = INIT_INTEGER;

    /**
     * 政治団体同一識別コードを取得する
     *
     * @return 政治団体同一識別コード
     */
    @Override
    public Integer getPoliticalOrganizationCode() {
        return politicalOrganizationCode;
    }

    /**
     * 政治団体同一識別コードを設定する
     *
     * @param politicalOrganizationCode 政治団体同一識別コード
     */
    @Override
    public void setPoliticalOrganizationCode(final Integer politicalOrganizationCode) {
        this.politicalOrganizationCode = politicalOrganizationCode;
    }

    /** 政治団体名称 */
    private String politicalOrganizationName = INIT_STRING;

    /**
     * 政治団体名称を取得する
     *
     * @return 政治団体名称
     */
    @Override
    public String getPoliticalOrganizationName() {
        return politicalOrganizationName;
    }

    /**
     * 政治団体名称を設定する
     *
     * @param politicalOrganizationName 政治団体名称 
     */
    @Override
    public void setPoliticalOrganizationName(final String politicalOrganizationName) {
        this.politicalOrganizationName = politicalOrganizationName;
    }

    /** 作業終了フラグ */
    private Boolean isFinished = INIT_Boolean;

    /**
     * 作業終了フラグを取得する
     *
     * @return 作業終了フラグ
     */
    @Override
    public Boolean getIsFinished() {
        return isFinished;
    }

    /**
     * 作業終了フラグを設定する
     *
     * @param isFinished 作業終了フラグ
     */
    @Override
    public void setIsFinished(final Boolean isFinished) {
        this.isFinished = isFinished;
    }

    /** 通知フラグ */
    private Boolean isNoticsAlert = INIT_Boolean;

    /**
     * 通知フラグを取得する
     *
     * @return 通知フラグ
     */
    @Override
    public Boolean getIsNoticsAlert() {
        return isNoticsAlert;
    }

    /**
     * 通知フラグを設定する
     *
     * @param isNoticsAlert 通知フラグ
     */
    @Override
    public void setIsNoticsAlert(final Boolean isNoticsAlert) {
        this.isNoticsAlert = isNoticsAlert;
    }

    /** 代表者用タスクフラグ */
    private Boolean isDelegateFor = INIT_Boolean;

    /**
     * 代表者用タスクフラグを取得する
     *
     * @return 代表者用タスクフラグ
     */
    @Override
    public Boolean getIsDelegateFor() {
        return isDelegateFor;
    }

    /**
     * 代表者用タスクフラグを設定する
     *
     * @param isDelegateFor 代表者用タスクフラグ
     */
    @Override
    public void setIsDelegateFor(final Boolean isDelegateFor) {
        this.isDelegateFor = isDelegateFor;
    }

    /** 会計責任者用タスクフラグ */
    private Boolean isAccountOfficerFor = INIT_Boolean;

    /**
     * 会計責任者用タスクフラグを取得する
     *
     * @return 会計責任者用タスクフラグ
     */
    @Override
    public Boolean getIsAccountOfficerFor() {
        return isAccountOfficerFor;
    }

    /**
     * 会計責任者用タスクフラグを設定する
     *
     * @param isAccountOfficerFor 会計責任者用タスクフラグ
     */
    @Override
    public void setIsAccountOfficerFor(final Boolean isAccountOfficerFor) {
        this.isAccountOfficerFor = isAccountOfficerFor;
    }

    /** 事務担当者用タスクフラグ */
    private Boolean isAccountStaffFor = INIT_Boolean;

    /**
     * 事務担当者用タスクフラグを取得する
     *
     * @return 事務担当者用タスクフラグ
     */
    @Override
    public Boolean getIsAccountStaffFor() {
        return isAccountStaffFor;
    }

    /**
     * 事務担当者用タスクフラグを設定する
     *
     * @param isAccountStaffFor 事務担当者用タスクフラグ
     */
    @Override
    public void setIsAccountStaffFor(final Boolean isAccountStaffFor) {
        this.isAccountStaffFor = isAccountStaffFor;
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
