package mitei.mitei.create.report.balance.politician.zz_address2_support.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.PostalAddressBlockDto;
import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2BlockEntity;
import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;

/**
 * GetAddressBlockService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class GetAddressBlockServiceTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private GetAddressBlockService getAddressBlockService;

    @Test
    void testPractice() {
        String postalcode = "7201623";
        PostalAddressBlockDto postalAddressBlockDto = getAddressBlockService.practice(postalcode);

        List<ZzAddress2PostalcodeEntity> listPostalcode = postalAddressBlockDto.getListPostalcode();
        List<ZzAddress2BlockEntity> listBlack = postalAddressBlockDto.getListBlock();

        // 郵便番号取得は1件
        assertThat(listPostalcode.size()).isEqualTo(1);
        // 広島県神石郡神石高原町花済を取得
        assertThat(listPostalcode.get(0).getAddressName()).isEqualTo("広島県神石郡神石高原町花済");

        // 広島県神石郡神石高原町花済の晩情報は1525件
        assertThat(listBlack.size()).isEqualTo(1525);

    }
}
