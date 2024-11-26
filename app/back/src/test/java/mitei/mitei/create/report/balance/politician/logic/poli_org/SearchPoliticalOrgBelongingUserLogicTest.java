package mitei.mitei.create.report.balance.politician.logic.poli_org;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.PoliticalOrganizationSelectOptionDto;

/**
 * SearchPoliticalOrgBelongingUserLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class SearchPoliticalOrgBelongingUserLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private SearchPoliticalOrgBelongingUserLogic searchPoliticalOrgBelongingUserLogic;

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql("political_org_beloging_user.sql")
    void testPractice() {

        // ユーザ同一識別コードが890のユーザが所属
       Integer userCode =890;
        List<PoliticalOrganizationSelectOptionDto> list = searchPoliticalOrgBelongingUserLogic.practice(userCode);

        // テストデータから3件取得
        assertThat(list.size()).isEqualTo(4);

        PoliticalOrganizationSelectOptionDto dto0 = this.getData(list, 3570);
        assertThat(dto0.getPoliticalOrganizationId()).isEqualTo(3579L);
        assertThat(dto0.getPoliticalOrganizationCode()).isEqualTo(3570);
        assertThat(dto0.getPoliticalOrganizationName()).isEqualTo("ちゃらんぽらん政治団体1");
        assertThat(dto0.getValue()).isEqualTo("3570");
        assertThat(dto0.getText()).isEqualTo("ちゃらんぽらん政治団体1(3570)");

        PoliticalOrganizationSelectOptionDto dto1 = this.getData(list, 5220);
        assertThat(dto1.getPoliticalOrganizationId()).isEqualTo(5224L);
        assertThat(dto1.getPoliticalOrganizationCode()).isEqualTo(5220);
        assertThat(dto1.getPoliticalOrganizationName()).isEqualTo("変わっている政治団体1");
        assertThat(dto1.getValue()).isEqualTo("5220");
        assertThat(dto1.getText()).isEqualTo("変わっている政治団体1(5220)");

    }

    private PoliticalOrganizationSelectOptionDto getData(final List<PoliticalOrganizationSelectOptionDto> list,
            final Integer code) {

        for (PoliticalOrganizationSelectOptionDto dto : list) {

            if (code.equals(dto.getPoliticalOrganizationCode())) {
                return dto;
            }

        }

        return null;
    }
}
