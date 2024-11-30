package mitei.mitei.create.report.balance.politician.trial;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.dto.various_financial_pay.VariousFinanciallPayCapsuleDto;
import mitei.mitei.create.report.balance.politician.repository.VariousFinancialPayRepository;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * TransactionFormatControllerWorksBand単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class TransactionFormatControllerWorksBandTest {

    /** テスト対象 */
    @Autowired
    private TransactionFormatControllerWorksBand transactionFormatControllerWorksBand;
    
    /** 各種PayRepository */
    @Autowired
    private VariousFinancialPayRepository variousFinancialPayRepository;

    @Test
    @Sql("truncate_various_financial_pay.sql")
    void testPractice()throws Exception {

        // 一番最初に登録するテーブルを空にして、空であることを確認
        assertEquals(0, variousFinancialPayRepository.findAll().size(), "DELETEしたので0件");

        VariousFinanciallPayCapsuleDto capsuleDto1 = new VariousFinanciallPayCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto1);
        capsuleDto1.setSearchWords("aaa");

        VariousFinanciallPayCapsuleDto capsuleDto2 = new VariousFinanciallPayCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto2);
        // 破綻原因
        capsuleDto2.setSearchWords(
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        List<VariousFinanciallPayCapsuleDto> list = new ArrayList<>();

        list.add(capsuleDto1);
        list.add(capsuleDto2);

        try {
            assertEquals(true, transactionFormatControllerWorksBand.wakeBuissiness(list),"");
        }catch (Exception exception) { // NOPMD
            exception.printStackTrace(); // NOPMD
        }
        
        // トランザクションが効いて変わらず0件であることを確認
        assertEquals(0, variousFinancialPayRepository.findAll().size(), "DELETEしたので0件");
    }

}
