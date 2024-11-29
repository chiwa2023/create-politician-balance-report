package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;

/**
 * ProposeCsvReadTemplateRepository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql("classpath:sql/csv_read_template_test.sql")
class ProposeCsvReadTemplateRepositoryTest {
    
    /** テスト対象 */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;
    
    @Test
    @Tag("TableTruncate")
    @Transactional
    void testFindByArrayNumberOrderByCsvReadTemplateNameAsc() {
        //全リスト
        List<ProposeCsvReadTemplateEntity> listAll = proposeCsvReadTemplateRepository.findAll();
        //カラム数が7件のデータを抽出
        List<ProposeCsvReadTemplateEntity> listCondition = proposeCsvReadTemplateRepository.findByArrayNumberOrderByProposeCsvReadTemplateNameAsc(7); // CHECKSTYLE:OFF

        //全件取得と条件付きでは取得数が異なります。
        assertThat(listAll.size()).isNotEqualTo(listCondition.size());

        //想定取得件数は2件です
        assertThat(listCondition.size()).isEqualTo(2);

        //それぞれの仕様の名称を確認します。
        assertThat(listCondition.get(1).getProposeCsvReadTemplateName()).isEqualTo("首都圏信用金庫");
        assertThat(listCondition.get(0).getProposeCsvReadTemplateName()).isEqualTo("きつねが木の葉で払うPay");
        
    }

    @Test
    @Transactional
    void testfindFullText() {

        //全リスト
        List<ProposeCsvReadTemplateEntity> listAll = proposeCsvReadTemplateRepository.findAll();
        //最新区分が1のデータしか抽出しません。
        assertThat(listAll.size()).isNotEqualTo(3);
        
        //指定検索語で検索
        List<ProposeCsvReadTemplateEntity> listCondition = proposeCsvReadTemplateRepository.findFullText("木の葉");
        //List<VariousFinancialPayEntity> listCondition = csvReadTemplateRepository.findFullText("Pay");

        //全件取得と条件付きでは取得数が異なります。
        assertThat(listAll.size()).isNotEqualTo(listCondition.size());

        //想定取得件数は2件です
        assertThat(listCondition.size()).isEqualTo(2);
        
        //検出内容を確認します。
        ProposeCsvReadTemplateEntity entity2 = listCondition.get(0);
        assertThat(entity2.getProposeCsvReadTemplateId()).isEqualTo(4);
        assertThat(entity2.getProposeCsvReadTemplateCode()).isEqualTo(4);
        assertThat(entity2.getProposeCsvReadTemplateName()).isEqualTo("木の葉のポイントざくざくPay");
        assertThat(entity2.getSaishinKbn()).isEqualTo(1);
        assertThat(entity2.getFinancialOrgKbn()).isEqualTo(1);
        assertThat(entity2.getFinancialOrgId()).isEqualTo(2);
        assertThat(entity2.getFinancialOrgCode()).isEqualTo(2);
        assertThat(entity2.getFinancialOrgName()).isEqualTo("木の葉のポイントざくざくPay");
        assertThat(entity2.getArrayNumber()).isEqualTo(3);
        assertThat(entity2.getArrayText()).isEqualTo("15,1,2");
        assertThat(entity2.getInsertTimestamp()).isEqualTo(Timestamp.valueOf("2012-12-15 00:00:00"));

        ProposeCsvReadTemplateEntity entity1 = listCondition.get(1);
        assertThat(entity1.getProposeCsvReadTemplateId()).isEqualTo(2);
        assertThat(entity1.getProposeCsvReadTemplateCode()).isEqualTo(2);
        assertThat(entity1.getProposeCsvReadTemplateName()).isEqualTo("きつねが木の葉で払うPay");
        assertThat(entity1.getSaishinKbn()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgKbn()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgId()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgCode()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgName()).isEqualTo("きつねが木の葉で払うPay");
        assertThat(entity1.getArrayNumber()).isEqualTo(7);
        assertThat(entity1.getArrayText()).isEqualTo("15,1,2,16,0,0,0");
        assertThat(entity1.getInsertTimestamp()).isEqualTo(Timestamp.valueOf("2012-12-13 00:00:00"));
        
        //名称で存在しない検索語で検索した場合は0件
        List<ProposeCsvReadTemplateEntity> listZero = proposeCsvReadTemplateRepository.findFullText("あかさたな");
        assertThat(listZero.size()).isEqualTo(0);

        //指定検索語なし時は全件検索
        List<ProposeCsvReadTemplateEntity> listNoWords = proposeCsvReadTemplateRepository.findFullText("");
        assertThat(listAll.size()).isNotEqualTo(listNoWords.size());
    }

    @Test
    @Sql("classpath:sql/DML/propose_csv_read_template_delete.sql")
    void testFindFirstByOrderByProposeCsvReadTemplateCodeDescNoData()throws Exception {

        Optional<ProposeCsvReadTemplateEntity> optional = proposeCsvReadTemplateRepository
                .findFirstByOrderByProposeCsvReadTemplateCodeDesc();
        assertThat(optional.isEmpty()).isTrue();
    }

    @Test
    // @Sql("classpath:sql/DML/propose_csv_read_template_test.sql")
    void testFindFirstByOrderByBalancesheetIncomeCodeExist()throws Exception {

        Optional<ProposeCsvReadTemplateEntity> optional = proposeCsvReadTemplateRepository
                .findFirstByOrderByProposeCsvReadTemplateCodeDesc();
        assertThat(optional.get().getProposeCsvReadTemplateCode()).isEqualTo(4L);
    }

}
