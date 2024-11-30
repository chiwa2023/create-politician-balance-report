package mitei.mitei.create.report.balance.politician.trial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import mitei.mitei.create.report.balance.politician.dto.various_financial_pay.VariousFinanciallPayCapsuleDto;
import mitei.mitei.create.report.balance.politician.repository.VariousFinancialPayRepository;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * TransactionFormatController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class TransactionFormatControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    /** 各種PayRepository */
    @Autowired
    private VariousFinancialPayRepository variousFinancialPayRepository;

    @Test
    @Sql("truncate_various_financial_pay.sql")
    void testPractice() throws Exception {

        assertEquals(0, variousFinancialPayRepository.findAll().size(), "DELETEしたので0件");

        VariousFinanciallPayCapsuleDto capsuleDto1 = new VariousFinanciallPayCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto1);
        capsuleDto1.setSearchWords("aaa");

        VariousFinanciallPayCapsuleDto capsuleDto2 = new VariousFinanciallPayCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto2);
        capsuleDto2.setSearchWords(
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        List<VariousFinanciallPayCapsuleDto> list = new ArrayList<>();

        list.add(capsuleDto1);
        list.add(capsuleDto2);

        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        try {
            mockMvc.perform(post("/transaction-test/execute1").content(objectMapper.writeValueAsString(list))
                    .contentType(MediaType.APPLICATION_JSON_VALUE));
        } catch (Exception exception) { // NOPMD
            exception.printStackTrace(); // NOPMD
        }

        assertEquals(0, variousFinancialPayRepository.findAll().size(), "トランザクションしたので0件");

    }

    @Test
    @Sql("truncate_various_financial_pay.sql")
    void testPractice2() throws Exception {

        assertEquals(0, variousFinancialPayRepository.findAll().size(), "DELETEしたので0件");

        VariousFinanciallPayCapsuleDto capsuleDto1 = new VariousFinanciallPayCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto1);
        capsuleDto1.setSearchWords("aaa");

        VariousFinanciallPayCapsuleDto capsuleDto2 = new VariousFinanciallPayCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto2);
        capsuleDto2.setSearchWords(
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        List<VariousFinanciallPayCapsuleDto> list = new ArrayList<>();

        list.add(capsuleDto1);
        list.add(capsuleDto2);

        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        try {
            mockMvc.perform(post("/transaction-test/execute2").content(objectMapper.writeValueAsString(list))
                    .contentType(MediaType.APPLICATION_JSON_VALUE));
        } catch (Exception exception) { // NOPMD
            exception.printStackTrace(); // NOPMD
        }

        assertEquals(1, variousFinancialPayRepository.findAll().size(), "トランザクションがないのでロールバックされず1件");

    }

}
