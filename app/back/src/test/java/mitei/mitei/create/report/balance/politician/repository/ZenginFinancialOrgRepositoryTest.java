package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.entity.ZenginFinancialOrgEntity;

/**
 * ZenginFinancialOrgRepository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql("classpath:sql/zengin_financial_org_test.sql")
class ZenginFinancialOrgRepositoryTest {

    /** テスト対象 */
    @Autowired
    private ZenginFinancialOrgRepository zenginFinancialOrgRepository;
    
    @Test
    @Transactional
    void testFindFullText() {
        //全リスト
        List<ZenginFinancialOrgEntity> listAll = zenginFinancialOrgRepository.findAll();
        
        //全件取得時の想定件数は3件です
        assertThat(listAll.size()).isNotEqualTo(3); // CHECKSTYLE:OFF

        //指定検索語で検索
        List<ZenginFinancialOrgEntity> listCondition = zenginFinancialOrgRepository.findFullText("金庫");

        //全件取得と条件付きでは取得数が異なります。
        assertThat(listAll.size()).isNotEqualTo(listCondition.size());

        //想定取得件数は2件です
        assertThat(listCondition.size()).isEqualTo(2);

        //検出内容を確認します。
        ZenginFinancialOrgEntity entity1 = listCondition.get(0);
        assertThat(entity1.getZenginFinancialOrgId()).isEqualTo(1);
        assertThat(entity1.getZenginFinancialOrgCode()).isEqualTo(1);
        assertThat(entity1.getZenginFinancialOrgName()).isEqualTo("首都圏信用金庫");
        assertThat(entity1.getSaishinKbn()).isEqualTo(1);
        assertThat(entity1.getInsertTimestamp()).isEqualTo(Timestamp.valueOf("2012-12-12 00:00:00"));
        
        //検出内容を確認します。
        ZenginFinancialOrgEntity entity2 = listCondition.get(1);
        assertThat(entity2.getZenginFinancialOrgId()).isEqualTo(4);
        assertThat(entity2.getZenginFinancialOrgCode()).isEqualTo(3);
        assertThat(entity2.getZenginFinancialOrgName()).isEqualTo("東北圏信用金庫");
        assertThat(entity2.getSaishinKbn()).isEqualTo(1);
        assertThat(entity2.getInsertTimestamp()).isEqualTo(Timestamp.valueOf("2012-12-15 00:00:00"));
        
        //名称で存在しない検索語で検索した場合は0件
        List<ZenginFinancialOrgEntity> listZero = zenginFinancialOrgRepository.findFullText("あかさたな");
        assertThat(listZero.size()).isEqualTo(0);

        //指定検索語でなし時は全件検索
        List<ZenginFinancialOrgEntity> listNoWords = zenginFinancialOrgRepository.findFullText("");
        assertThat(listAll.size()).isNotEqualTo(listNoWords.size());

    }
}
