package mitei.mitei.create.report.balance.politician.service.csv_read_template;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.dto.institution_csv.CsvReadTemplateDto;

/**
 * CsvReadTemplateService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvReadTemplateServiceTest {

    /** テスト対象 */
    @Autowired
    private CsvReadTemplateService csvReadTemplateService;
    
    @Test
    void test()throws Exception {
        //読み取り列数7のデータを取得
        List<CsvReadTemplateDto> listCondition = csvReadTemplateService.selectTemplateByNumber(7); // CHECKSTYLE:OFF
        
        CsvReadTemplateDto dto0 =listCondition.get(0);
        assertThat(dto0.getCsvReadTemplateName()).isEqualTo("きつねが木の葉で払うPay");
        assertThat(dto0.getValue()).isEqualTo(String.valueOf(dto0.getCsvReadTemplateId()));
        assertThat(dto0.getText()).isEqualTo("きつねが木の葉で払うPay");
        
        CsvReadTemplateDto dto1 =listCondition.get(1);
        assertThat(dto1.getCsvReadTemplateName()).isEqualTo("首都圏信用金庫");
        assertThat(dto1.getValue()).isEqualTo(String.valueOf(dto1.getCsvReadTemplateId()));
        assertThat(dto1.getText()).isEqualTo("首都圏信用金庫");

        CsvReadTemplateDto dto2 =listCondition.get(2);
        assertThat(dto2.getText()).isEqualTo("選択解除");
        assertThat(dto2.getValue()).isEqualTo("0");
        assertThat(dto2.getArrayNumber()).isEqualTo(0);
        assertThat(dto2.getArrayText()).isEqualTo("0,0,0,0,0,0,0");

    }

}
