package mitei.mitei.create.report.balance.politician.trial;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
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
    void testUpload() throws Exception {

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "report_item/zegin_csv_format.csv");
        
        MockMultipartFile sampleFile = new MockMultipartFile("uploaded-file",new FileInputStream(path.toFile())); // NOPMD
        
        MockMultipartHttpServletRequestBuilder multipartRequest =
                MockMvcRequestBuilders.multipart("/upload");

        mockMvc.perform(multipartRequest.file(sampleFile)).andExpect(status().isOk());
     
        fail("not yet imple");
    }

}
