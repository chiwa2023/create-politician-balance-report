package mitei.mitei.create.report.balance.politician.zz_address2_support.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @Tag("LoadTest")
    void testFindByPostalCode() {
        String code = "7201623";
        List<ZzAddress2BlockEntity> list = zzAddress2BlockRepository.findByPostalCode(code);
        
        for(ZzAddress2BlockEntity entiy : list) {
            assertTrue(entiy.getAllAddress().startsWith("広島県神石郡神石高原町花済"),"取得した住所は指定語で始まる");
        }
    }

}
