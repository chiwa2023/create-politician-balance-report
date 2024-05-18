package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.entity.PoliticalOrganizationEntity;

/**
 * PoliticalOrganizationRepository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql("classpath:sql/political_organization_test.sql")
class PoliticalOrganizationRepositoryTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private PoliticalOrganizationRepository politicalOrganizationRepository;
    
    @Test
    @Transactional
    void testFindFullText() {
        //全リスト
        List<PoliticalOrganizationEntity> listAll = politicalOrganizationRepository.findAll();
        //指定検索語で検索
        List<PoliticalOrganizationEntity> listCondition = politicalOrganizationRepository.findFullText("サンプル");

        //全件取得と条件付きでは取得数が異なります。
        assertThat(listAll.size()).isNotEqualTo(listCondition.size());

        //想定取得件数は2件です
        assertThat(listCondition.size()).isEqualTo(2);

        //検出内容を確認します。
        PoliticalOrganizationEntity entity1 = listCondition.get(0);
        assertThat(entity1.getPoliticalOrganizationId()).isEqualTo(1);
        assertThat(entity1.getPoliticalOrganizationCode()).isEqualTo(11);
        assertThat(entity1.getPoliticalOrganizationName()).isEqualTo("食品サンプル連合会");
        assertThat(entity1.getSaishinKbn()).isEqualTo(1);
        
        //検出内容を確認します。
        PoliticalOrganizationEntity entity2 = listCondition.get(1);
        assertThat(entity2.getPoliticalOrganizationId()).isEqualTo(2345);
        assertThat(entity2.getPoliticalOrganizationCode()).isEqualTo(2333);
        assertThat(entity2.getPoliticalOrganizationName()).isEqualTo("サンプル政治団体");
        assertThat(entity2.getSaishinKbn()).isEqualTo(1);
        
        //名称で存在しない検索語で検索した場合は0件
        List<PoliticalOrganizationEntity> listZero = politicalOrganizationRepository.findFullText("あかさたな");
        assertThat(listZero.size()).isEqualTo(0);

        //指定検索語でなし時は全件検索
        List<PoliticalOrganizationEntity> listNoWords = politicalOrganizationRepository.findFullText("");
        assertThat(listAll.size()).isNotEqualTo(listNoWords.size());
    }
}
