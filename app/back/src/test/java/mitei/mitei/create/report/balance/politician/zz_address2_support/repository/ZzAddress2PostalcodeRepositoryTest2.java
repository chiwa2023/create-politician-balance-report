package mitei.mitei.create.report.balance.politician.zz_address2_support.repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;

/**
 * ZzAddress2PostalcodeRepository単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ZzAddress2PostalcodeRepositoryTest2 {

    /** 単体テスト */
    @Autowired
    private ZzAddress2PostalcodeRepository zzAddress2PostalcodeRepository;
    
    @Test
    void testFindByAddressNameStartingWith() throws Exception {
        String jichitai = "熊本県熊本市中央区";
        List<ZzAddress2PostalcodeEntity> listEntity = zzAddress2PostalcodeRepository.findByAddressNameStartingWith(jichitai);
        for(ZzAddress2PostalcodeEntity entity : listEntity) {
            System.out.println(entity.getAddressName());
        }
        
        fail("Not yet implemented");
    }

    @Test
    void testFindByPostalcode() throws Exception {
        String postalcode = "7201623";
        List<ZzAddress2PostalcodeEntity> listEntity = zzAddress2PostalcodeRepository.findByPostalcode(postalcode);
        for(ZzAddress2PostalcodeEntity entity : listEntity) {
            System.out.println(entity.getAddressName());
        }
        
        fail("Not yet implemented");
    }
}
