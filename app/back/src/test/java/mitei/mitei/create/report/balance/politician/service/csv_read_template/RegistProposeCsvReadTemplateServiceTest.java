package mitei.mitei.create.report.balance.politician.service.csv_read_template;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.financial.FinancialOrgConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * RegistProposeCsvReadTemplateService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistProposeCsvReadTemplateServiceTest {

    /** テスト対象 */
    @Autowired
    private RegistProposeCsvReadTemplateService registProposeCsvReadTemplateService;
    
    @Test
    @Transactional
    void testPractice() {

        RegistProposeCsvReadRemplateCapsuleDto capsuleDto = new RegistProposeCsvReadRemplateCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto);

        ProposeCsvReadTemplateEntity entity = new  ProposeCsvReadTemplateEntity();

        entity.setProposeCsvReadTemplateName("石のお金Pay共通");
        String arrayText = "0,15,2,1";
        entity.setArrayNumber(arrayText.split(",").length);
        entity.setArrayText(arrayText);
        entity.setFinancialOrgKbn(FinancialOrgConstants.VARIOUS);
        entity.setFinancialOrgId(1L);
        entity.setFinancialOrgCode(2);
        entity.setFinancialOrgName("石のお金Pay");
        entity.setHasHeader(false);
        
        boolean result = registProposeCsvReadTemplateService.practice(entity, capsuleDto.getCheckPrivilegeDto());
        
        assertThat(result).isTrue();
    }

}
