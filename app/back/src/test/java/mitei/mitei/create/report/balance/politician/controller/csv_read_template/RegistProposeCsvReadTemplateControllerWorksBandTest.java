package mitei.mitei.create.report.balance.politician.controller.csv_read_template;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.dto.financial.FinancialOrgConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * RegistProposeCsvReadTemplateControllerWorksBand単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistProposeCsvReadTemplateControllerWorksBandTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private RegistProposeCsvReadTemplateControllerWorksBand registProposeCsvReadTemplateControllerWorksBand;

    /** csv読み取りテンプレート登録提案Reposiory */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    @Test
    @Tag("TableTruncate")
    @Sql("propose_csv_read_template.sql")
    void test() {

        try {

            assertEquals(1, proposeCsvReadTemplateRepository.count(), "1件投入");

            RegistProposeCsvReadRemplateCapsuleDto capsuleDto = new RegistProposeCsvReadRemplateCapsuleDto();
            CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto);

            ProposeCsvReadTemplateEntity entity = new ProposeCsvReadTemplateEntity();

            entity.setProposeCsvReadTemplateName("石のお金Pay共通");
            String arrayText = "0,15,2,1";
            entity.setArrayNumber(arrayText.split(",").length);
            entity.setArrayText(arrayText);
            entity.setFinancialOrgKbn(FinancialOrgConstants.VARIOUS);
            entity.setFinancialOrgId(1L);
            entity.setFinancialOrgCode(2);
            entity.setFinancialOrgName(
                    "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
            entity.setHasHeader(false);
            entity.setEditId(320L);

            capsuleDto.setProposeCsvReadTemplateEntity(entity);

            registProposeCsvReadTemplateControllerWorksBand.wakeBusiness(capsuleDto);

        } catch (Exception exception) { // NOPMD
            exception.printStackTrace(); // NOPMD
        }

        assertEquals(1, proposeCsvReadTemplateRepository.count(), "ロールバックして1件のまま");

    }

}
