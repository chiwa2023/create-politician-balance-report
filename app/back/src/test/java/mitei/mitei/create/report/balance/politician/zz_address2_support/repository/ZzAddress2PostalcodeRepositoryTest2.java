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
    @Tag("LoadTest")
    void testFindByAddressNameStartingWith() throws Exception {
        String jichitai = "熊本県熊本市中央区";
        List<ZzAddress2PostalcodeEntity> listEntity = zzAddress2PostalcodeRepository
                .findByAddressNameStartingWith(jichitai);
        for (ZzAddress2PostalcodeEntity entity : listEntity) {
            assertTrue(entity.getAddressName().startsWith(jichitai), "取得リストの住所はすべて検索キーワードで始まる");
        }
    }

    @Test
    @Tag("LoadTest")
    void testFindByPostalcode() throws Exception {
        String postalcode = "7201623";
        List<ZzAddress2PostalcodeEntity> listEntity = zzAddress2PostalcodeRepository.findByPostalcode(postalcode);
        for (ZzAddress2PostalcodeEntity entity : listEntity) {
            assertTrue(entity.getAddressName().startsWith("広島県神石郡神石高原町花済"), "取得リスト住所はすべて該当郵便番号の住所で始まる");
        }
    }
}
