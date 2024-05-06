package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.entity.CsvReadTemplateEntity;

/**
 * CsvReadTemplateRepository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql("classpath:sql/csv_read_template_test.sql")
class CsvReadTemplateRepositoryTest {
    
    /** テスト対象 */
    @Autowired
    private CsvReadTemplateRepository csvReadTemplateRepository;
    
    @Test
    @Transactional
    void testFindByArrayNumberOrderByCsvReadTemplateNameAsc() {
        //全リスト
        List<CsvReadTemplateEntity> listAll = csvReadTemplateRepository.findAll();
        //カラム数が7件のデータを抽出
        List<CsvReadTemplateEntity> listCondition = csvReadTemplateRepository.findByArrayNumberOrderByCsvReadTemplateNameAsc(7); // CHECKSTYLE:OFF

        //全件取得と条件付きでは取得数が異なります。
        assertThat(listAll.size()).isNotEqualTo(listCondition.size());

        //想定取得件数は2件です
        assertThat(listCondition.size()).isEqualTo(2);

        //それぞれの仕様の名称を確認します。
        assertThat(listCondition.get(0).getCsvReadTemplateName()).isEqualTo("木の葉のポイントざくざくPay");
        assertThat(listCondition.get(1).getCsvReadTemplateName()).isEqualTo("きつねが木の葉で払うPay");
        
    }

    @Test
    @Transactional
    void testfindFullText() {

        //全リスト
        List<CsvReadTemplateEntity> listAll = csvReadTemplateRepository.findAll();
        //最新区分が1のデータしか抽出しません。
        assertThat(listAll.size()).isNotEqualTo(3);
        
        //指定検索語で検索
        List<CsvReadTemplateEntity> listCondition = csvReadTemplateRepository.findFullText("木の葉");
        //List<VariousFinancialPayEntity> listCondition = csvReadTemplateRepository.findFullText("Pay");

        //全件取得と条件付きでは取得数が異なります。
        assertThat(listAll.size()).isNotEqualTo(listCondition.size());

        //想定取得件数は2件です
        assertThat(listCondition.size()).isEqualTo(2);
        
        //検出内容を確認します。
        CsvReadTemplateEntity entity2 = listCondition.get(0);
        assertThat(entity2.getCsvReadTemplateId()).isEqualTo(4);
        assertThat(entity2.getCsvReadTemplateCode()).isEqualTo(4);
        assertThat(entity2.getCsvReadTemplateName()).isEqualTo("木の葉のポイントざくざくPay");
        assertThat(entity2.getSaishinKbn()).isEqualTo(1);
        assertThat(entity2.getFinancialOrgKbn()).isEqualTo(1);
        assertThat(entity2.getFinancialOrgId()).isEqualTo(2);
        assertThat(entity2.getFinancialOrgCode()).isEqualTo(2);
        assertThat(entity2.getFinancialOrgName()).isEqualTo("木の葉のポイントざくざくPay");
        assertThat(entity2.getArrayNumber()).isEqualTo(3);
        assertThat(entity2.getArrayText()).isEqualTo("15,1,2");
        assertThat(entity2.getUpdateTime()).isEqualTo(Timestamp.valueOf("2012-12-15 00:00:00"));

        CsvReadTemplateEntity entity1 = listCondition.get(1);
        assertThat(entity1.getCsvReadTemplateId()).isEqualTo(2);
        assertThat(entity1.getCsvReadTemplateCode()).isEqualTo(2);
        assertThat(entity1.getCsvReadTemplateName()).isEqualTo("きつねが木の葉で払うPay");
        assertThat(entity1.getSaishinKbn()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgKbn()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgId()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgCode()).isEqualTo(1);
        assertThat(entity1.getFinancialOrgName()).isEqualTo("きつねが木の葉で払うPay");
        assertThat(entity1.getArrayNumber()).isEqualTo(7);
        assertThat(entity1.getArrayText()).isEqualTo("15,1,2,16,0,0,0");
        assertThat(entity1.getUpdateTime()).isEqualTo(Timestamp.valueOf("2012-12-13 00:00:00"));
        
        //名称で存在しない検索語で検索した場合は0件
        List<CsvReadTemplateEntity> listZero = csvReadTemplateRepository.findFullText("あかさたな");
        assertThat(listZero.size()).isEqualTo(0);

        //指定検索語なし時は全件検索
        List<CsvReadTemplateEntity> listNoWords = csvReadTemplateRepository.findFullText("");
        assertThat(listAll.size()).isNotEqualTo(listNoWords.size());
    }

}
