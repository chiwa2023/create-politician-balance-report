package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import mitei.mitei.create.report.balance.politician.entity.CallingItemEntity;

/**
 * CallingItemRepository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CallingItemRepositoryTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private CallingItemRepository callingItemRepository;

    @Test
    @Tag("TableTruncate")
    //@Sql("classpath:sql/DML/calling_item_test.sql")
    void testFindByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest() {
        
        //テストデータに最新区分が0データは存在しません
        List<CallingItemEntity> list1 = 
                callingItemRepository.findByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest(2333,0,"ﾈｯﾄﾂｳﾊﾝA");
        assertThat(list1.size()).isEqualTo(0);        

        //ユーザ団体同一識別コードが一致するデータは存在しません
        List<CallingItemEntity> list2 = 
                callingItemRepository.findByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest(3999,1,"ﾈｯﾄﾂｳﾊﾝA");
        assertThat(list2.size()).isEqualTo(0);        
        
        //摘要が一致しない場合も空リストが返ります
        List<CallingItemEntity> list3 = 
                callingItemRepository.findByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest(2333,1,"借金");
        assertThat(list3.size()).isEqualTo(0);        
        
        //1件取得できます
        List<CallingItemEntity> list4 = 
                callingItemRepository.findByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest(2333,1,"ﾌﾘｶｴ ｼｭﾄｹﾝﾃﾞﾝｷ");
        assertThat(list4.size()).isEqualTo(1);        

        //取得できた行が想定通りかいくつかカラムで試してみる
        CallingItemEntity callingItemEntity = list4.get(0);
        assertThat(callingItemEntity.getCallingItemZenginBranchName()).isEqualTo("407");
        assertThat(callingItemEntity.getRelationCorporationId()).isEqualTo(430);
        assertThat(callingItemEntity.getCallingItemAddressBuiding()).isEqualTo("418");
        assertThat(callingItemEntity.getPublishItemName()).isEqualTo("420");
        assertThat(callingItemEntity.getPublishOrgnizationAddress()).isEqualTo("421");
        assertThat(callingItemEntity.getPublishProfessionOrgnizationName()).isEqualTo("422");
        assertThat(callingItemEntity.getGeneralItemId()).isEqualTo(423L);
        assertThat(callingItemEntity.getRelationPoliticsOrganizationCode()).isEqualTo(433);
        assertThat(callingItemEntity.getYoushikiKbn()).isEqualTo(15);
        assertThat(callingItemEntity.getYoushikiEdaKbn()).isEqualTo(2);
    }

}
