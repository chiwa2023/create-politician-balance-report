package mitei.mitei.create.report.balance.politician.zz_address2_support.util.create;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.opencsv.CSVReader;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;

/**
 * ZzAddressInsertPostalTableUtil単体テスト
 */
class ZzAddressInsertPostalTableUtilTest {
    // CHECKSTYLE:OFF

    @Test
    void testPractice() throws Exception {
        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "address/utf_ken_all.csv");

        ZzAddressInsertPostalTableUtil zzAddressInsertPostalTableUtil = new ZzAddressInsertPostalTableUtil();
        try (CSVReader csvReader = new CSVReader(Files.newBufferedReader(path));) {
            List<String[]> listAll = csvReader.readAll();
            List<ZzAddress2PostalcodeEntity> listEntity = zzAddressInsertPostalTableUtil.practice(listAll);

            ZzAddress2PostalcodeEntity entity;
            for (int i = 0; i < 500; i++) {
                entity = listEntity.get(i);
                assertTrue(entity.getAddressName().startsWith("広島県"),"");
                //System.out.println(entity.getPostalcode() + "::" + entity.getAddressName() + "::" + entity.getNamePlus());
            }

            int length = listEntity.size();
            for (int i = length - 1; i > length - 500; i--) {
                entity = listEntity.get(i);
                assertTrue(entity.getAddressName().startsWith("熊本県"),"");
                //System.out.println(entity.getPostalcode() + "::" + entity.getAddressName() + "::" + entity.getNamePlus());
            }
        }

    }

}
