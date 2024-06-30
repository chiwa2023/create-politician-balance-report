package mitei.mitei.create.report.balance.politician.service.balancesheet;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancesheetInOutDataCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancsheetInOutItemResultDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;
import mitei.mitei.create.report.balance.politician.service.read_csv.ReadCsvReadByFileService;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * RegistBalancesheetInOutService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistBalancesheetInOutServiceTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private RegistBalancesheetInOutService registBalancesheetInOutService;

    /** リスト生成 */
    @Autowired
    private CreateBalancesheetInOutByCsvService createBalancesheetInOutByCsvService;

    @Test
    @Transactional
    void testPractice()throws Exception {
        
        CreateBalancesheetInOutDataCapsuleDto createBalancesheetInOutDataCapsuleDto = new CreateBalancesheetInOutDataCapsuleDto();

        //共通チェックセット完了
        CreateCommonCheckDtoTestOnlyUtil.practice(createBalancesheetInOutDataCapsuleDto);

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "service/read_csv/read_csv_test.csv");
        String fileContent = Files.readString(path);

        ReadCsvReadByFileService ReadCsvReadByFileService = new ReadCsvReadByFileService();
        List<List<CsvCellDto>> listCsv = ReadCsvReadByFileService.practice(fileContent);

        listCsv.remove(0);
        
        SaveStorageResultDto saveStorageResultDto = new SaveStorageResultDto();
        String shoshouId = "/96325/zrgzrgaskda/20221212123456888";
        saveStorageResultDto.setShoshouId(shoshouId);
        saveStorageResultDto.setShoshouCode(3377L);
        saveStorageResultDto.setShoshouKbn(3);
        
        createBalancesheetInOutDataCapsuleDto.setSaveStorageResultDto(saveStorageResultDto);
        createBalancesheetInOutDataCapsuleDto.setListCsvData(listCsv);
        createBalancesheetInOutDataCapsuleDto.setListPointer("15,1,2,16,0,0,0".split(","));

        CreateBalancsheetInOutItemResultDto resultDto = createBalancesheetInOutByCsvService.practice(
                listCsv, 
                saveStorageResultDto,
                createBalancesheetInOutDataCapsuleDto.getCheckPrivilegeDto(),
                createBalancesheetInOutDataCapsuleDto.getListPointer());
        
        RegistBalancesheetInOutCapsuleDto capsuleDto = new RegistBalancesheetInOutCapsuleDto();
        
        capsuleDto.setListOutcome(resultDto.getListOutcome());
        capsuleDto.setListIncome(resultDto.getListIncome());
        capsuleDto.setCheckPrivilegeDto(createBalancesheetInOutDataCapsuleDto.getCheckPrivilegeDto());
        capsuleDto.setCheckSecurityDto(createBalancesheetInOutDataCapsuleDto.getCheckSecurityDto());
        capsuleDto.setCheckTransactionDto(createBalancesheetInOutDataCapsuleDto.getCheckTransactionDto());
        
        //6件登録されます
        assertThat(registBalancesheetInOutService.practice(capsuleDto)).isEqualTo(6);
    }

}