package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import mitei.mitei.create.report.balance.politician.entity.VariousFinancialPayEntity;

/**
 * VariousFinancialPayRepository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VariousFinancialPayRepositoryTest {
  //CHECKSTYLE:OFF MagicNumber

    /** テスト対象 */
    @Autowired
    private VariousFinancialPayRepository variousFinancialPayRepository;
    
    @Test
    void testFindFullText() {
        //全リスト
        List<VariousFinancialPayEntity> listAll = variousFinancialPayRepository.findAll();
        
        //最新区分が1のデータしか抽出しません。
        assertThat(listAll.size()).isNotEqualTo(3);
        
        //指定検索語で検索
        List<VariousFinancialPayEntity> listCondition = variousFinancialPayRepository.findFullText("木の葉");
        //英字3文字未満で抽出したい場合はサーバ側の設定に
        //innodb_ft_min_token_size=1
        //ngram_token_size=1
        //が必要(サービス開始時には適応予定)

        //全件取得と条件付きでは取得数が異なります。
        assertThat(listAll.size()).isNotEqualTo(listCondition.size());

        //想定取得件数は2件です
        assertThat(listCondition.size()).isEqualTo(2);
        
        //検出内容を確認します。
        VariousFinancialPayEntity entity2 = listAll.get(3);
        assertThat(entity2.getVariousFinancialPayId()).isEqualTo(4);
        assertThat(entity2.getVariousFinancialPayCode()).isEqualTo(3);
        assertThat(entity2.getVariousFinancialPayName()).isEqualTo("木の葉のポイントざくざくPay");
        assertThat(entity2.getSaishinKbn()).isEqualTo(1);
        assertThat(entity2.getInsertTimestamp()).isEqualTo(Timestamp.valueOf("2012-12-15 00:00:00"));

        VariousFinancialPayEntity entity1 = listAll.get(0);
        assertThat(entity1.getVariousFinancialPayId()).isEqualTo(1);
        assertThat(entity1.getVariousFinancialPayCode()).isEqualTo(1);
        assertThat(entity1.getVariousFinancialPayName()).isEqualTo("きつねが木の葉で払うPay");
        assertThat(entity1.getSaishinKbn()).isEqualTo(1);
        assertThat(entity1.getInsertTimestamp()).isEqualTo(Timestamp.valueOf("2012-12-12 00:00:00"));
        
        //名称で存在しない検索語で検索した場合は0件
        List<VariousFinancialPayEntity> listZero = variousFinancialPayRepository.findFullText("あかさたな");
        assertThat(listZero.size()).isEqualTo(0);

        //指定検索語なし時は全件検索
        List<VariousFinancialPayEntity> listNoWords = variousFinancialPayRepository.findFullText("");
        assertThat(listAll.size()).isNotEqualTo(listNoWords.size());
    }
}
