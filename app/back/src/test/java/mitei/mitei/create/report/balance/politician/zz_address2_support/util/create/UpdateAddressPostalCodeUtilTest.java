package mitei.mitei.create.report.balance.politician.zz_address2_support.util.create;


import static org.junit.jupiter.api.Assertions.assertTrue;

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
 * UpdateAddressPostalCodeUtil単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class UpdateAddressPostalCodeUtilTest {

    /** テスト対象 */
    @Autowired
    private UpdateAddressPostalCodeUtil updateAddressPostalCodeUtil;
    
    @Test
    void test() {
        
        // NOTE:データベース更新(と変更後のデータ取得)を行うのでめちゃくちゃ時間がかる。何度も実施するものではない
        
        List<ZzAddress2PostalcodeEntity> list = updateAddressPostalCodeUtil.practice();
        
        //for(ZzAddress2PostalcodeEntity entity  :list) {
        //    if(entity.getIsPrc1()) {
        //        System.out.println(entity.getAddressName());
        //    }
        //}
        
        assertTrue(!list.isEmpty(),"適切なテストが思い浮かばない");
    }

}
