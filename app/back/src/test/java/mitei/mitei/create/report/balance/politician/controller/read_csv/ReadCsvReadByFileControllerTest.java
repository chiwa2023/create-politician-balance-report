package mitei.mitei.create.report.balance.politician.controller.read_csv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.ReadCsvByFileCapsuleDto;
import mitei.mitei.create.report.balance.politician.service.read_csv.ReadCsvReadByFileService;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * ReadCsvReadByFileController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ReadCsvReadByFileControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("TableTruncate")
    void test()throws Exception {
        
        ReadCsvByFileCapsuleDto readCsvByFileCapsuleDto = new ReadCsvByFileCapsuleDto();
        
        CreateCommonCheckDtoTestOnlyUtil.practice(readCsvByFileCapsuleDto);
        
        readCsvByFileCapsuleDto.setFileName("aaa.csv");
        
        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "service/read_csv/read_csv_test.csv");
        String fileContent = Files.readString(path);

        readCsvByFileCapsuleDto.setFileContent(fileContent);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        String responseContent = mockMvc // NOPMD LawOfDemeter
                .perform(post("/read-csv-by-file/practice")
                        .content(objectMapper.writeValueAsString(readCsvByFileCapsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        //作業内容として含んでいるはずの変換データ
        ReadCsvReadByFileService ReadCsvReadByFileService = new ReadCsvReadByFileService();
        List<List<CsvCellDto>> list = ReadCsvReadByFileService.practice(fileContent);
        String listText = objectMapper.writeValueAsString(list);

        //変換されたcsvデータが送信内容に含まれています
        assertThat(responseContent.indexOf(listText) != -1).isTrue();
    }

}
