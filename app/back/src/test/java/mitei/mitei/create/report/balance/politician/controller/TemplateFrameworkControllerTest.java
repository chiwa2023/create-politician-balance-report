package mitei.mitei.create.report.balance.politician.controller;

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

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckSecurityDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * TemplateFrameworkController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class TemplateFrameworkControllerTest {

    /** 接続URL */
    private static final String PATH_TEXT = "/template-framework/do-test";
    
    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    /** セキュリティ例外 */
    @Test
    @Tag("TableTruncate")
    @Transactional
    void testSecurityException()throws Exception { // NOPMD

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(true);//強制例外発生

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);
        
        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(false);

        TemplateFrameworkCapsuleDto capsuleDto = new TemplateFrameworkCapsuleDto(); 

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        final int BAD_GATEWAY = 502;
        mockMvc // NOPMD LawOfDemeter
                .perform(post(PATH_TEXT)
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().is(BAD_GATEWAY));
    }

    /** セキュリティ処理不可 */
    @Test
    @Transactional
    void testSecurityFalse()throws Exception { // NOPMD

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(false);//チェック結果不可
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);
        
        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(false);

        TemplateFrameworkCapsuleDto capsuleDto = new TemplateFrameworkCapsuleDto(); 

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        final int BAD_GATEWAY = 502;
        mockMvc // NOPMD LawOfDemeter
                .perform(post(PATH_TEXT)
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().is(BAD_GATEWAY));
    }
    
    /** 権限例外 */
    @Test
    @Transactional
    void testPrivilegeException()throws Exception { // NOPMD

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(true);//強制例外発生
        
        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(false);

        TemplateFrameworkCapsuleDto capsuleDto = new TemplateFrameworkCapsuleDto(); 

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        final int FORBIDDEN = 403;
        mockMvc // NOPMD LawOfDemeter
                .perform(post(PATH_TEXT)
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().is(FORBIDDEN));
    }

    /** 権限処理不可 */
    @Test
    @Transactional
    void testPrivilegeFalse()throws Exception { // NOPMD

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(false);//チェック結果不可
        checkPrivilegeDto.setIsRaiseExcception(false);
        
        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(false);

        TemplateFrameworkCapsuleDto capsuleDto = new TemplateFrameworkCapsuleDto(); 

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        final int FORBIDDEN = 403;
        mockMvc // NOPMD LawOfDemeter
                .perform(post(PATH_TEXT)
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().is(FORBIDDEN));
    }

    /** 排他制御例外 */
    @Test
    @Transactional
    void testTransactionException()throws Exception { // NOPMD

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);
        
        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(true);//強制例外発生

        TemplateFrameworkCapsuleDto capsuleDto = new TemplateFrameworkCapsuleDto(); 

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        final int CONFLICT = 409;
        mockMvc // NOPMD LawOfDemeter
                .perform(post(PATH_TEXT)
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().is(CONFLICT));
    }

    /** 排他制御処理不可 */
    @Test
    @Transactional
    void testTransactionFalse()throws Exception { // NOPMD

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);
        
        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(false);//チェック結果不可
        checkTransactionDto.setIsRaiseExcception(false);

        TemplateFrameworkCapsuleDto capsuleDto = new TemplateFrameworkCapsuleDto(); 

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        final int CONFLICT = 409;
        mockMvc // NOPMD LawOfDemeter
                .perform(post(PATH_TEXT)
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().is(CONFLICT));
    }

}
