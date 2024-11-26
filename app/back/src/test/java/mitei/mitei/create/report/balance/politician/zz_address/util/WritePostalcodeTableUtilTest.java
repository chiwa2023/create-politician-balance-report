package mitei.mitei.create.report.balance.politician.zz_address.util;


import static org.junit.jupiter.api.Assertions.fail;

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

/**
 * WritePostalcodeTableUtil単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class WritePostalcodeTableUtilTest {

    /** テスト対象 */
    @Autowired
    private WritePostalcodeTableUtil writePostalcodeTableUtil;
    
    @Test
    @Tag("LoadTest")
    void testPractice()throws Exception {
        
        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "address/utf_ken_all.csv");

        try(CSVReader csvReader = new CSVReader(Files.newBufferedReader(path))){
            List<String[]> listAll = csvReader.readAll();
            
            writePostalcodeTableUtil.practice(listAll);
        }
        
        fail("Not yet implemented");
    }

}
