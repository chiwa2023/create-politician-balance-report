package mitei.mitei.create.report.balance.politician.entity_interface;

import java.sql.Timestamp;

/**
 * タスク予定共通Interface
 */
public interface TaskPlanInterface {

    /**
     * タスク予定Idを取得する
     *
     * @return タスク予定Id
     */
    Long getTaskPlanId();

    /**
     * タスク予定Idを設定する
     *
     * @param taskPlanId タスク予定I*/
    void setTaskPlanId(Long taskPlanId);

    /**
     * タスク予定同一識別コードを取得する
     *
     * @return タスク予定同一識別コード
     */
    Long getTaskPlanCode();

    /**
     * タスク予定同一識別コードを設定する
     *
     * @param taskPlanCode タスク予定同一識別コード
     */
    void setTaskPlanCode(Long taskPlanCode);

    /**
     * タスク予定名称を取得する
     *
     * @return タスク予定名称
     */
    String getTaskPlanName();

    /**
     * タスク予定名称を設定する
     *
     * @param taskPlanName タスク予定名称
     */
    void setTaskPlanName(String taskPlanName);

    /**
     * 最新区分を取得する
     *
     * @return 最新区分
     */
    Integer getSaishinKbn();

    /**
     * 最新区分を設定する
     *
     * @param saishinKbn 最新区分
     */
    void setSaishinKbn(Integer saishinKbn);

    /**
     * 政治団体Idを取得する
     *
     * @return 政治団体Id
     */
    Long getPoliticalOrganizationId();

    /**
     * 政治団体Idを設定する
     *
     * @param politicalOrganizationId 政治団体Id
     */
    void setPoliticalOrganizationId(Long politicalOrganizationId);

    /**
     * 政治団体同一識別コードを取得する
     *
     * @return 政治団体同一識別コード
     */
    Integer getPoliticalOrganizationCode();

    /**
     * 政治団体同一識別コードを設定する
     *
     * @param politicalOrganizationCode 政治団体同一識別コード
     */
    void setPoliticalOrganizationCode(Integer politicalOrganizationCode);

    /**
     * 政治団体名称を取得する
     *
     * @return 政治団体名称
     */
    String getPoliticalOrganizationName();

    /**
     * 政治団体名称を設定する
     *
     * @param politicalOrganizationName 政治団体名称
     */
    void setPoliticalOrganizationName(String politicalOrganizationName);

    /**
     * 作業終了フラグを取得する
     *
     * @return 作業終了フラグ
     */
    Boolean getIsFinished();

    /**
     * 作業終了フラグを設定する
     *
     * @param isFinished 作業終了フラグ
     */
    void setIsFinished(Boolean isFinished);

    /**
     * 通知フラグを取得する
     *
     * @return 通知フラグ
     */
    Boolean getIsNoticsAlert();

    /**
     * 通知フラグを設定する
     *
     * @param isNoticsAlert 通知フラグ
     */
    void setIsNoticsAlert(Boolean isNoticsAlert);

    /**
     * 代表者用タスクフラグを取得する
     *
     * @return 代表者用タスクフラグ
     * 
     */
    Boolean getIsDelegateFor();

    /**
     * 代表者用タスクフラグを設定する
     *
     * @param isDelegateFor 代表者用タスクフラグ
     */
    void setIsDelegateFor(Boolean isDelegateFor);

    /**
     * 会計責任者用タスクフラグを取得する
     *
     * @return 会計責任者用タスクフラグ
     */
    Boolean getIsAccountOfficerFor();

    /**
     * 会計責任者用タスクフラグを設定する
     *
     * @param isAccountOfficerFor 会計責任者用タスクフラグ
     */
    void setIsAccountOfficerFor(Boolean isAccountOfficerFor);

    /**
     * 事務担当者用タスクフラグを取得する
     *
     * @return 事務担当者用タスクフラグ
     */
    Boolean getIsAccountStaffFor();

    /**
     * 事務担当者用タスクフラグを設定する
     *
     * @param isAccountStaffFor 事務担当者用タスクフラグ
     */
    void setIsAccountStaffFor(Boolean isAccountStaffFor);

    /**
     * ログインユーザIdを取得する
     *
     * @return ログインユーザId
     */
    Long getLoginUserId();

    /**
     * ログインユーザIdを設定する
     *
     * @param loginUserId ログインユーザId
     */
    void setLoginUserId(Long loginUserId);

    /**
     * ログインユーザ同一識別コードを取得する
     *
     * @return ログインユーザ同一識別コード
     */
    Integer getLoginUserCode();

    /**
     * ログインユーザ同一識別コードを設定する
     *
     * @param loginUserCode ログインユーザ同一識別コード
     */
    void setLoginUserCode(Integer loginUserCode);

    /**
     * ログインユーザ名を取得する
     *
     * @return ログインユーザ名
     */
    String getLoginUserName();

    /**
     * ログインユーザ名を設定する
     *
     * @param loginUserName ログインユーザ名
     */
    void setLoginUserName(String loginUserName);

    /**
     * 更新時間を取得する
     *
     * @return 更新時間
     */
    Timestamp getUpdateTime();

    /**
     * 更新時間を設定する
     *
     * @param updateTime 更新時間
     */
    void setUpdateTime(Timestamp updateTime);

}
