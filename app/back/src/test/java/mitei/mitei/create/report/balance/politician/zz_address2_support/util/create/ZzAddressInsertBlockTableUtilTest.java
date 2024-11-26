package mitei.mitei.create.report.balance.politician.zz_address2_support.util.create;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.opencsv.CSVReader;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2BlockEntity;

/**
 * ZzAddressInsertBlockTableUtil単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ZzAddressInsertBlockTableUtilTest {

    /** テスト対象 */
    @Autowired
    private ZzAddressInsertBlockTableUtil zzAddressInsertBlockTableUtil;

    @Test
    @Tag("LoadTest")
    void testPractice() throws Exception {
        // CHECKSTYLE:OFF

        // Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
        // "address/mt_parcel_city431010.csv");
        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "address/mt_parcel_city345458.csv");

        try (CSVReader csvReader = new CSVReader(Files.newBufferedReader(path));) {
            List<String[]> listAll = csvReader.readAll();

            // 1行目はヘッダなので除く
            listAll.remove(0);

            // String jichitai = "熊本県";
            String jichitai = "広島県神石郡";
            List<ZzAddress2BlockEntity> listEntity = zzAddressInsertBlockTableUtil.practice(listAll, jichitai);

            for (ZzAddress2BlockEntity entity : listEntity) {
                // System.out.println(entity.getAllAddress() + "::" + entity.getText() + "::" +
                // entity.getChoume());
                assertTrue(entity.getAllAddress().startsWith(jichitai), "取得した住所はすべて検索キーワードで始まる");
            }

        }
    }

}
