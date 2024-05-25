package mitei.mitei.create.report.balance.politician.zz_address2_support.repository;

import static org.junit.jupiter.api.Assertions.fail;

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

import com.opencsv.CSVReader;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;
import mitei.mitei.create.report.balance.politician.zz_address2_support.util.create.UpdateAddressPostalCodeUtil;
import mitei.mitei.create.report.balance.politician.zz_address2_support.util.create.ZzAddressInsertPostalTableUtil;

/**
 * ZzAddress2PostalcodeRepository単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ZzAddress2PostalcodeRepositoryTest {

    /** テスト対象 */
    @Autowired
    private ZzAddress2PostalcodeRepository zzAddress2PostalcodeRepository;
    
    /** 更新データ作成Utility */ 
    @Autowired
    private UpdateAddressPostalCodeUtil updateAddressPostalCodeUtil;

    @Test
    void testSaveAll() throws Exception {

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "address/utf_ken_all.csv");

        try(CSVReader csvReader = new CSVReader(Files.newBufferedReader(path))){
            
            List<String[]> listAll = csvReader.readAll();

            ZzAddressInsertPostalTableUtil zzAddressInsertPostalTableUtil = new ZzAddressInsertPostalTableUtil();

            List<ZzAddress2PostalcodeEntity> listEntity = zzAddressInsertPostalTableUtil.practice(listAll);
            //新規登録
            zzAddress2PostalcodeRepository.saveAll(listEntity);
        }
        
        fail("Not yet implemented");
    }

    @Test
    void test() {
        //更新
        zzAddress2PostalcodeRepository.saveAll(updateAddressPostalCodeUtil.practice());
        
        fail("Not yet implemented");
    }


}
