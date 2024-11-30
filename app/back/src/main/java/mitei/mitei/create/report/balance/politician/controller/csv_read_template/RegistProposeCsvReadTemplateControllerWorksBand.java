package mitei.mitei.create.report.balance.politician.controller.csv_read_template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.service.csv_read_template.RegistProposeCsvReadTemplateService;

/**
 * ビジネスロジックをまとめるWorksBandController(Transaction用)
 */
@Component
public class RegistProposeCsvReadTemplateControllerWorksBand {

    /** propose_csv_read_templateテーブルService */
    @Autowired
    private RegistProposeCsvReadTemplateService registProposeCsvReadTemplateService;

    /**
     * 処理を行う
     *
     * @param registProposeCsvReadRemplateCapsuleDto csv読み取り仕様登録Dto
     * @return 処理結果
     */
    @Transactional
    public TemplateFrameworkResultDto wakeBusiness(
            final RegistProposeCsvReadRemplateCapsuleDto registProposeCsvReadRemplateCapsuleDto) {

        return registProposeCsvReadTemplateService.practice(
                registProposeCsvReadRemplateCapsuleDto.getProposeCsvReadTemplateEntity(),
                registProposeCsvReadRemplateCapsuleDto.getCheckPrivilegeDto());
    }
}
