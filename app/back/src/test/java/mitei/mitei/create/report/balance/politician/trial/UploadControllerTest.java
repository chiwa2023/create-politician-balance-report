package mitei.mitei.create.report.balance.politician.trial;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * UploadController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class UploadControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("TableTruncate")
    void testUpload() throws Exception {

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "report_item/zegin_csv_format.csv");

        MockMultipartFile sampleFile = new MockMultipartFile("uploaded-file", new FileInputStream(path.toFile())); // NOPMD

        MockMultipartHttpServletRequestBuilder multipartRequest = MockMvcRequestBuilders.multipart("/upload");

        // とりあえずサーバステータスがOK(200)
        assertThat(mockMvc.perform(multipartRequest.file(sampleFile)).andExpect(status().isOk()).andReturn() // NOPMD
                .getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

}
