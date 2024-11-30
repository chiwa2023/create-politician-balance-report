package mitei.mitei.create.report.balance.politician.controller.read_csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.logic.common.SetTableDataHistoryLogic;
import mitei.mitei.create.report.balance.politician.service.read_csv.RegistProposeReadCsvAcceptService;

/**
 * ビジネスロジックをまとめるWorksBandController(Transaction用)
 */
@Component
public class RegistProposeReadCsvAcceptControllerWorksBand {

    /** csv読み取り仕様申請許可Service */
    @Autowired
    private RegistProposeReadCsvAcceptService registProposeReadCsvAcceptService;

    /** テーブル履歴設定Logic */
    @Autowired
    private SetTableDataHistoryLogic setTableDataHistoryLogic;

    /**
     * 処理を行う
     *
     * @param registProposeCsvReadRemplateCapsuleDto csv読み取り仕様登録Dto
     * @return 登録結果
     */
    @Transactional
    public TemplateFrameworkResultDto wakeBusiness(
            final RegistProposeCsvReadRemplateCapsuleDto registProposeCsvReadRemplateCapsuleDto) {

        // ユーザ設定を行う
        CheckPrivilegeDto privilegeDto = registProposeCsvReadRemplateCapsuleDto.getCheckPrivilegeDto();
        ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity = registProposeCsvReadRemplateCapsuleDto
                .getProposeCsvReadTemplateEntity();

        setTableDataHistoryLogic.practice(privilegeDto, proposeCsvReadTemplateEntity,
                DataHistoryStatusConstants.INSERT);

        // 登録
        long newId = registProposeReadCsvAcceptService.practice(registProposeCsvReadRemplateCapsuleDto);

        final long initId = 0L;
        TemplateFrameworkResultDto resultDto = new TemplateFrameworkResultDto();
        if (initId == newId) {
            resultDto.setFailureCount(0);
            resultDto.setMessage("登録できませんでした");
        } else {
            resultDto.setIsOk(true);
            resultDto.setSuccessCount(1);
            resultDto.setMessage("登録できました");
        }

        return resultDto;
    }

}
