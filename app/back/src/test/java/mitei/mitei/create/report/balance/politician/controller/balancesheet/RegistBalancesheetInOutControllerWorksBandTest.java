package mitei.mitei.create.report.balance.politician.controller.balancesheet;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancesheetInOutDataCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancsheetInOutItemResultDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.ReportKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;
import mitei.mitei.create.report.balance.politician.repository.BalancesheetIncome2025Repository;
import mitei.mitei.create.report.balance.politician.repository.BalancesheetOutcome2025Repository;
import mitei.mitei.create.report.balance.politician.service.balancesheet.CreateBalancesheetInOutByCsvService;
import mitei.mitei.create.report.balance.politician.service.read_csv.ReadCsvReadByFileService;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * RegistBalancesheetInOutControllerWorksBand単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistBalancesheetInOutControllerWorksBandTest {

    /** テスト対象 */
    @Autowired
    private RegistBalancesheetInOutControllerWorksBand registBalancesheetInOutControllerWorksBand;

    /** テストデータ作成用 */
    @Autowired
    private CreateBalancesheetInOutByCsvService createBalancesheetInOutByCsvService;

    /** 収支報告書収入項目Repository */
    @Autowired
    private BalancesheetIncome2025Repository balancesheetIncome2025Repository;

    /** 収支報告書支出項目Repository */
    @Autowired
    private BalancesheetOutcome2025Repository balancesheetOutcome2025Repository;

    @Test
    @Tag("TableTruncate")
    @Sql("truncate_balancesheet.sql")
    void test() throws Exception {
        // CHECKSTYLE:OFF

        assertEquals(0, balancesheetIncome2025Repository.count(), "truncateしたで0件");
        assertEquals(0, balancesheetOutcome2025Repository.count(), "truncateしたで0件");

        CreateBalancesheetInOutDataCapsuleDto createBalancesheetInOutDataCapsuleDto = new CreateBalancesheetInOutDataCapsuleDto();

        // 共通チェックセット完了
        CreateCommonCheckDtoTestOnlyUtil.practice(createBalancesheetInOutDataCapsuleDto);

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "service/read_csv/read_csv_test.csv");
        String fileContent = Files.readString(path);

        ReadCsvReadByFileService ReadCsvReadByFileService = new ReadCsvReadByFileService();
        List<List<CsvCellDto>> listCsv = ReadCsvReadByFileService.practice(fileContent);

        // サンプルデータは1行目がヘッダなので削除する
        listCsv.remove(0);

        SaveStorageResultDto saveStorageResultDto = new SaveStorageResultDto();
        String shoshouId = "/96325/zrgzrgaskda/20221212123456888";
        saveStorageResultDto.setShoshouId(shoshouId);
        saveStorageResultDto.setShoshouCode(3377L);
        saveStorageResultDto.setShoshouKbn(3);

        createBalancesheetInOutDataCapsuleDto.setSaveStorageResultDto(saveStorageResultDto);
        createBalancesheetInOutDataCapsuleDto.setListCsvData(listCsv);
        createBalancesheetInOutDataCapsuleDto.setListPointer("15,1,2,16,0,0,0".split(","));

        CreateBalancsheetInOutItemResultDto resultDto = createBalancesheetInOutByCsvService.practice(listCsv,
                saveStorageResultDto, createBalancesheetInOutDataCapsuleDto.getCheckPrivilegeDto(),
                createBalancesheetInOutDataCapsuleDto.getListPointer());

        RegistBalancesheetInOutCapsuleDto capsuleDto = new RegistBalancesheetInOutCapsuleDto();

        capsuleDto.setListOutcome(resultDto.getListOutcome());
        capsuleDto.setListIncome(resultDto.getListIncome());
        capsuleDto.setCheckPrivilegeDto(createBalancesheetInOutDataCapsuleDto.getCheckPrivilegeDto());
        capsuleDto.setCheckSecurityDto(createBalancesheetInOutDataCapsuleDto.getCheckSecurityDto());
        capsuleDto.setCheckTransactionDto(createBalancesheetInOutDataCapsuleDto.getCheckTransactionDto());
        // 破綻要因
        capsuleDto.getCheckPrivilegeDto().setLoginUserName(
                "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        // 支出、収入とも各先頭1行は前例と異なる処理
        capsuleDto.getListOutcome().get(0).setIsDifferPrecedent(true);
        capsuleDto.getListIncome().get(0).setIsDifferPrecedent(true);

        // 支出、収入とも各先頭2行目はタスク計上
        capsuleDto.getListOutcome().get(1).setReportKbn(ReportKbnConstants.PLAN_TASK);
        capsuleDto.getListIncome().get(1).setReportKbn(ReportKbnConstants.PLAN_TASK);

        try {
            registBalancesheetInOutControllerWorksBand.wakeBusiness(capsuleDto);
        } catch (Exception exception) { // NOPMD
            exception.printStackTrace(); // NOPMD
        }

        assertEquals(0, balancesheetIncome2025Repository.count(), "ロールバックしたので0件");
        assertEquals(0, balancesheetOutcome2025Repository.count(), "ロールバックしたので0件");

    }

}
