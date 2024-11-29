package mitei.mitei.create.report.balance.politician.service.csv_read_template;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;

/**
 * CsvReadTemplateSearchAllSaishinService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvReadTemplateSearchAllSaishinServiceTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private CsvReadTemplateSearchAllSaishinService csvReadTemplateSearchAllSaishinService;
    
    @Test
    @Tag("TableTruncate")
    void testPractice() {
        
        List<ProposeCsvReadTemplateEntity> list = csvReadTemplateSearchAllSaishinService.practice();
        
        assertThat(list.size()).isEqualTo(11);
    }

}
