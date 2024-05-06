package mitei.mitei.create.report.balance.politician.util;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckSecurityDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;

/**
 * テスト時のみ共通チェックDtoを落ちないように設定するDto
 */
public final class CreateCommonCheckDtoTestOnlyUtil {

    /* インスタンス作成禁止コンストラクタ*/
    private CreateCommonCheckDtoTestOnlyUtil() {
    }
    
    /**
     * Mockテスト用に共通チェックが必ず通るチェックDtoをセットする
     *
     * @param capsuleDto 共通チェックを必要とするカプセルDo
     */
    public static void practice(final TemplateFrameworkCapsuleDto capsuleDto) {
        
        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);
        checkPrivilegeDto.setLoginUserId(1007L); // CHECKSTYLE:OFF
        checkPrivilegeDto.setLoginUserCode(995); // CHECKSTYLE:OFF
        checkPrivilegeDto.setPoliticalOrganizationId(2345L); // CHECKSTYLE:OFF
        checkPrivilegeDto.setPoliticalOrganizationCode(2333); // CHECKSTYLE:OFF
        checkPrivilegeDto.setPoliticalOrganizationName("サンプル政治団体");

        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(false);
        checkTransactionDto.setIsSelectOnly(false);

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);
    }
    
}