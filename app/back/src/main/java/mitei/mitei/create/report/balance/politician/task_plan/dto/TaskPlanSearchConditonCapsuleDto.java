package mitei.mitei.create.report.balance.politician.task_plan.dto;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.AbstractCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckSecurityDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;

/**
 * 未処理タスクリスト検索条件Dto
 */
public class TaskPlanSearchConditonCapsuleDto extends AbstractCapsuleDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** セキュリティチェック情報 */
    private CheckSecurityDto checkSecurityDto;

    /** 権限チェック情報 */
    private CheckPrivilegeDto checkPrivilegeDto;

    /** 排他制御情報 */
    private CheckTransactionDto checkTransactionDto;

    /**
     * セキュリティ情報を取得する
     *
     * @return セキュリティ情報
     */
    @Override
    public CheckSecurityDto getCheckSecurityDto() {
        return checkSecurityDto;
    }

    /**
     * セキュリティ情報を設定する
     *
     * @param checkSecurityDto セキュリティ情報
     */
    @Override
    public void setCheckSecurityDto(final CheckSecurityDto checkSecurityDto) {
        this.checkSecurityDto = checkSecurityDto;
    }

    /**
     * 権限情報を取得する
     *
     * @return 権限情報
     */
    @Override
    public CheckPrivilegeDto getCheckPrivilegeDto() {
        return checkPrivilegeDto;
    }

    /**
     * 権限情報を設定する
     *
     * @param checkPrivilegeDto 権限情報
     */
    @Override
    public void setCheckPrivilegeDto(final CheckPrivilegeDto checkPrivilegeDto) {
        this.checkPrivilegeDto = checkPrivilegeDto;
    }

    /**
     * 排他制御情報を取得する
     *
     * @return 排他制御情報
     */
    @Override
    public CheckTransactionDto getCheckTransactionDto() {
        return checkTransactionDto;
    }

    /**
     * 排他制御情報を設定する
     *
     * @param checkTransactionDto 排他制御情報
     */
    @Override
    public void setCheckTransactionDto(final CheckTransactionDto checkTransactionDto) {
        this.checkTransactionDto = checkTransactionDto;
    }

}
