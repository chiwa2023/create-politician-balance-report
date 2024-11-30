package mitei.mitei.create.report.balance.politician.controller.read_csv;

import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.read_csv.ReadCsvByFileCapsuleDto;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * ReadCsvReadByFileControllerWorksBand単体テスト
 */
class ReadCsvReadByFileControllerWorksBandTest {

    /** テスト対象 */
    @Autowired
    private ReadCsvReadByFileControllerWorksBand readCsvReadByFileControllerWorksBand;

    @Test
    void test() throws Exception {

        ReadCsvByFileCapsuleDto readCsvByFileCapsuleDto = new ReadCsvByFileCapsuleDto();

        CreateCommonCheckDtoTestOnlyUtil.practice(readCsvByFileCapsuleDto);

        readCsvByFileCapsuleDto.setFileName("aaa.csv");

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "service/read_csv/read_csv_test.csv");
        String fileContent = Files.readString(path);

        readCsvByFileCapsuleDto.setFileContent(fileContent);

        try {

            // 現在はDb登録がないため何も起きないが、必ずDb登録するのでトランザクションが必要
            // TODO 修正次第このテストも起動できるようにする

            readCsvReadByFileControllerWorksBand.wakeBusiness(null);

        } catch (Exception exception) { // NOPMD
            exception.printStackTrace(); // NOPMD
        }

        fail("Not yet implemented");
    }

}
