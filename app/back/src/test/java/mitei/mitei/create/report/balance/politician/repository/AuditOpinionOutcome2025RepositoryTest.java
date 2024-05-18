package mitei.mitei.create.report.balance.politician.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


/**
 * AuditOpinionOutcome2025Repository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql("classpath:sql/audit_opinion_outcome_2025_test.sql")
class AuditOpinionOutcome2025RepositoryTest {

    /** テスト対象 */
    @Autowired
    private AuditOpinionOutcome2025Repository auditOpinionOutcome2025Repository;
    
    //@Test
    //@Transactional
    //void testFindFullText() {
    //    //全リスト
    //    List<AuditOpinionOutcome2025Entity> listAll = auditOpinionOutcome2025Repository.findAll();
    //    //指定検索語で検索
    //    List<AuditOpinionOutcome2025Entity> listCondition = auditOpinionOutcome2025Repository.findFullText("");
    //
    //    //全件取得と条件付きでは取得数が異なります。
    //    assertThat(listAll.size()).isNotEqualTo(listCondition.size());
    //
    //    //想定取得件数は2件です
    //    assertThat(listCondition.size()).isEqualTo(2);
    //
    //    //検出内容を確認します。
    //    AuditOpinionOutcome2025Entity entity1 = listCondition.get(0);
    //    assertThat(entity1.getAuditOpinionOutcome2025Id()).isEqualTo(1);
    //    assertThat(entity1.getAuditOpinionOutcome2025Code()).isEqualTo(1);
    //    assertThat(entity1.getAuditOpinionOutcome2025Name()).isEqualTo("");
    //    assertThat(entity1.getSaishinKbn()).isEqualTo(1);
    //    assertThat(entity1.getUpdateTime()).isEqualTo(1);
    //    
    //    //検出内容を確認します。
    //    AuditOpinionOutcome2025Entity entity2 = listCondition.get(1);
    //    assertThat(entity2.getAuditOpinionOutcome2025Id()).isEqualTo(2);
    //    assertThat(entity2.getAuditOpinionOutcome2025Code()).isEqualTo(2);
    //    assertThat(entity2.getAuditOpinionOutcome2025Name()).isEqualTo("");
    //    assertThat(entity2.getSaishinKbn()).isEqualTo(1);
    //    assertThat(entity2.getUpdateTime()).isEqualTo(1);
        
    //    //名称で存在しない検索語で検索した場合は0件
    //    List<AuditOpinionOutcome2025Entity> listZero = auditOpinionOutcome2025Repository.findFullText("あかさたな");
    //    assertThat(listZero.size()).isEqualTo(0);
    //
    //    //指定検索語でなし時は全件検索
    //    List<AuditOpinionOutcome2025Entity> listNoWords = auditOpinionOutcome2025Repository.findFullText("");
    //    assertThat(listAll.size()).isNotEqualTo(listNoWords.size());
    //
    //}
}
