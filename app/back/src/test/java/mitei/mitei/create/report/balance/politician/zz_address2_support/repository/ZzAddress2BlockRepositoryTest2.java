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

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2BlockEntity;

/**
 * ZzAddress2BlockRepository単体
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ZzAddress2BlockRepositoryTest2 {

    /** テスト対象 */
    @Autowired
    private ZzAddress2BlockRepository zzAddress2BlockRepository;
    
    @Test
    void testFindByPostalCode() {
        String code = "7201623";
        List<ZzAddress2BlockEntity> list = zzAddress2BlockRepository.findByPostalCode(code);
        
        for(ZzAddress2BlockEntity entiy : list) {
            System.out.println(entiy.getAllAddress());
        }
        
        fail("Not yet implemented");
    }

}
