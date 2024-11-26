package mitei.mitei.create.report.balance.politician.zz_address2_support.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

/**
 * GetAddressBlockController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class GetAddressBlockControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("LoadTest")
    void testPractice() throws Exception {
        // String responsContent =
        // this.mockMvc.perform(get("/zz-address/example2?postalCode=7201521")) // NOPMD
        // .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        // System.out.println(responsContent);

        assertThat(this.mockMvc.perform(get("/zz-address/example2?postalCode=7201521")).andReturn().getResponse() // NOPMD
                .getStatus()).isEqualTo(HttpStatus.OK.value());
    }

}
