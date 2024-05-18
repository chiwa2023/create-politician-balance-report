package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;


/**
 * task_plan_2025接続用Entity
 */
@Entity
@Table(name = "task_plan_2025")
public class TaskPlan2025Entity  implements Serializable,TaskPlanInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_Long = 0L;

    /** 初期データ(Boolean) */
    private static final Boolean INIT_Boolean = false;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LocalDate = LocalDate.of(1980,1,1);

    /** 初期データ(Timestamp) */
    private static final Timestamp INIT_Timestamp = Timestamp.valueOf(INIT_LocalDate.atTime(0, 0, 0));

    /** タスク予定Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskPlanId = INIT_Long;

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
    private Long taskPlanCode = INIT_Long;

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

    /** タスク予定名称 */
    private String taskPlanName = INIT_String;

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

    /** 政治団体Id */
    private Long politicalOrganizationId = INIT_Long;

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
    private Integer politicalOrganizationCode = INIT_Integer;

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
    private String politicalOrganizationName = INIT_String;

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

    /** ログインユーザId */
    private Long loginUserId = INIT_Long;

    /**
     * ログインユーザIdを取得する
     *
     * @return ログインユーザId
     */
    @Override
    public Long getLoginUserId() {
        return loginUserId;
    }

    /**
     * ログインユーザIdを設定する
     *
     * @param loginUserId ログインユーザId
     */
    @Override
    public void setLoginUserId(final Long loginUserId) {
        this.loginUserId = loginUserId;
    }

    /** ログインユーザ同一識別コード */
    private Integer loginUserCode = INIT_Integer;

    /**
     * ログインユーザ同一識別コードを取得する
     *
     * @return ログインユーザ同一識別コード
     */
    @Override
    public Integer getLoginUserCode() {
        return loginUserCode;
    }

    /**
     * ログインユーザ同一識別コードを設定する
     *
     * @param loginUserCode ログインユーザ同一識別コード
     */
    @Override
    public void setLoginUserCode(final Integer loginUserCode) {
        this.loginUserCode = loginUserCode;
    }

    /** ログインユーザ名 */
    private String loginUserName = INIT_String;

    /**
     * ログインユーザ名を取得する
     *
     * @return ログインユーザ名
     */
    @Override
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * ログインユーザ名を設定する
     *
     * @param loginUserName ログインユーザ名
     */
    @Override
    public void setLoginUserName(final String loginUserName) {
        this.loginUserName = loginUserName;
    }

    /** 更新時間 */
    private Timestamp updateTime = INIT_Timestamp;

    /**
     * 更新時間を取得する
     *
     * @return 更新時間
     */
    @Override
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新時間を設定する
     *
     * @param updateTime 更新時間
     */
    @Override
    public void setUpdateTime(final Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
