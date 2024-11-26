package mitei.mitei.create.report.balance.politician.repository;

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

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;

/**
 * UserWebAccessRepository単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class UserWebAccessRepositoryTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private UserWebAccessRepository userWebAccessRepository;
    
    /** EntityManager */
    @Autowired
    private EntityManager entityManager;
    
    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql({"political_org_beloging_user.sql","user_web_access.sql"})
    void test() {
        
        List<UserWebAccessEntity> list = userWebAccessRepository.findselectByPoliOrgCode(entityManager,3570);
        assertThat(list.size()).isEqualTo(1);
        
        UserWebAccessEntity entityAns = list.get(0);
        
        // ユーザCode202を検索しているが、Id 1008は最新区分：最新でないので抽出されない
        assertThat(entityAns.getUserWebAccessId()).isEqualTo(1006L);
    }

}
