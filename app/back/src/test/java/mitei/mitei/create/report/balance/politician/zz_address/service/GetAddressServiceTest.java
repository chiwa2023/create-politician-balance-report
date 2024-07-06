package mitei.mitei.create.report.balance.politician.zz_address.service;


import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import mitei.mitei.create.report.balance.politician.dto.SelectOptionInterface;

/**
 * GetAddressService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class GetAddressServiceTest {

    /** テスト対象 */
    @Autowired
    private GetAddressService getAddressService;

    @Test
    void testPractice() {

        String postalCode = "7201521";
        List<SelectOptionInterface> list = getAddressService.practice(postalCode);

        for (SelectOptionInterface dto : list) {
            System.out.println(dto.getText());
        }

        fail("Not yet implemented");
    }

}