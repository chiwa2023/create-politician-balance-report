package mitei.mitei.create.report.balance.politician.controller.various_financial_pay;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckSecurityDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;
import mitei.mitei.create.report.balance.politician.dto.various_financial_pay.VariousFinanciallPayCapsuleDto;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * VariousFinancialPayController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class VariousFinancialPayControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("TableTruncate")
    void test() throws Exception {

        VariousFinanciallPayCapsuleDto capsuleDto = this.createCapsuleDto();
        /* ビジネス処理特有の値を設定 */
        capsuleDto.setSearchWords("木の葉"); // CHECKSTYLE:OFF

        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        String responseContent = mockMvc // NOPMD LawOfDemeter
                .perform(
                        post("/various-financial-pay/search-table").content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                                .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        String ans = "[{\"updateTime\":\"2012-12-14T15:00:00.000+00:00\",\"variousFinancialPayId\":4,\"saishinKbn\":1,\"variousFinancialPayName\":\"木の葉のポイントざくざくPay\",\"variousFinancialPayCode\":3},{\"updateTime\":\"2012-12-11T15:00:00.000+00:00\",\"variousFinancialPayId\":1,\"saishinKbn\":1,\"variousFinancialPayName\":\"きつねが木の葉で払うPay\",\"variousFinancialPayCode\":1}]";

        assertThat(responseContent).isEqualTo(ans);
    }

    /**
     * 共通処理が正常となるフレームワークDtoを取得する
     *
     * @return フレームワークDto
     */
    private VariousFinanciallPayCapsuleDto createCapsuleDto() {

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);

        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(false);
        checkTransactionDto.setIsSelectOnly(false);

        VariousFinanciallPayCapsuleDto capsuleDto = new VariousFinanciallPayCapsuleDto();

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);

        return capsuleDto;
    }
}
