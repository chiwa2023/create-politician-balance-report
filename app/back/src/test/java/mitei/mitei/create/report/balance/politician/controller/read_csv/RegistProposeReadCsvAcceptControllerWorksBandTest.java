package mitei.mitei.create.report.balance.politician.controller.read_csv;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

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

import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * RegistProposeReadCsvAcceptControllerWorksBand単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistProposeReadCsvAcceptControllerWorksBandTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private RegistProposeReadCsvAcceptControllerWorksBand registProposeReadCsvAcceptControllerWorksBand;
    
    /** CSV読み取り使用申請テーブル */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    @Test
    @Tag("TableTruncate")
    @Sql("propose_csv_read_template.sql")
    void test()throws Exception {
        
        assertEquals(1, proposeCsvReadTemplateRepository.findAll().size(), "truncateしてデータ挿入しているので1件");
        
        RegistProposeCsvReadRemplateCapsuleDto registProposeCsvReadRemplateCapsuleDto = new RegistProposeCsvReadRemplateCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(registProposeCsvReadRemplateCapsuleDto);

        Optional<ProposeCsvReadTemplateEntity> optional = proposeCsvReadTemplateRepository.findById(15L);
        ProposeCsvReadTemplateEntity csvReadTemplateEntity = optional.get();
        // 破綻要因
        csvReadTemplateEntity.setProposeCsvReadTemplateName(
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        registProposeCsvReadRemplateCapsuleDto.setProposeCsvReadTemplateEntity(optional.get());
        try {
            
            registProposeReadCsvAcceptControllerWorksBand.wakeBusiness(registProposeCsvReadRemplateCapsuleDto);
            
        }catch (Exception exception) { // NOPMD
            exception.printStackTrace(); // NOPMD
        }
        
        assertEquals(1, proposeCsvReadTemplateRepository.findAll().size(), "ロールバックしているので1件");

    }

}
