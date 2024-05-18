package mitei.mitei.create.report.balance.politician.controller.balancesheet;


import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancesheetInOutDataCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;
import mitei.mitei.create.report.balance.politician.service.read_csv.ReadCsvReadByFileService;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * CreateBalancesheetInOutByCsvController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CreateBalancesheetInOutByCsvControllerTest {
    //CHECKSTYLE:OFF
    
    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test()throws Exception {
        
        CreateBalancesheetInOutDataCapsuleDto createBalancesheetInOutDataCapsuleDto = new CreateBalancesheetInOutDataCapsuleDto();
        
        //共通チェックセット完了
        CreateCommonCheckDtoTestOnlyUtil.practice(createBalancesheetInOutDataCapsuleDto);

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "service/read_csv/read_csv_test.csv");
        String fileContent = Files.readString(path);

        ReadCsvReadByFileService ReadCsvReadByFileService = new ReadCsvReadByFileService();
        List<List<CsvCellDto>> listCsv = ReadCsvReadByFileService.practice(fileContent);

        //サンプルデータは1行目がヘッダなので削除する
        listCsv.remove(0);
        
        SaveStorageResultDto saveStorageResultDto = new SaveStorageResultDto();
        String shoshouId = "/96325/zrgzrgaskda/20221212123456888";
        saveStorageResultDto.setShoshouId(shoshouId);
        saveStorageResultDto.setShoshouCode(3377L);
        saveStorageResultDto.setShoshouKbn(3);
        
        createBalancesheetInOutDataCapsuleDto.setSaveStorageResultDto(saveStorageResultDto);
        createBalancesheetInOutDataCapsuleDto.setListCsvData(listCsv);
        createBalancesheetInOutDataCapsuleDto.setListPointer("15,1,2,16,0,0,0".split(","));
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        String responseContent = mockMvc // NOPMD LawOfDemeter
                .perform(post("/create-balancesheet-in-out/by-csv")
                        .content(objectMapper.writeValueAsString(createBalancesheetInOutDataCapsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        System.out.println(responseContent);
        
        fail("Not yet implemented");
    }

}
