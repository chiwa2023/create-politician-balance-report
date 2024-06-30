package mitei.mitei.create.report.balance.politician.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;

/**
 * csv読み取り仕様を格納するテーブルcsv_read_Templateのrepository
 */
@Repository
public interface ProposeCsvReadTemplateRepository  extends JpaRepository<ProposeCsvReadTemplateEntity, Long>{

    /**
     * テーブル同一識別コードがテーブルで最大である行を取得する
     *
     * @return 最大値のOptional
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<ProposeCsvReadTemplateEntity> findFirstByOrderByProposeCsvReadTemplateCodeDesc();
    
    /**
     * 項目件数を条件として該当するcsv読み取り仕様を取得する
     *
     * @param arrayNumber 項目件数
     * @return 該当リスト
     */
    List<ProposeCsvReadTemplateEntity> findByArrayNumberOrderByProposeCsvReadTemplateNameAsc(Integer arrayNumber);

    /**
     * 名称を検索対象として全文検索をする
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    @Query(value = "SELECT * FROM propose_csv_read_template WHERE saishin_kbn= 1 AND MATCH(table_all_search_text) AGAINST (?1 IN NATURAL LANGUAGE MODE WITH QUERY EXPANSION)", nativeQuery = true)
    List<ProposeCsvReadTemplateEntity> findFullText(String searchWords);
    
    /**
     * 検索キーである最新区分に該当するデータを抽出する(基本的には最新データをすべて)
     *
     * @param saishinKbn 最新区分
     * @return 検索結果
     */
    List<ProposeCsvReadTemplateEntity> findBySaishinKbn(Integer saishinKbn);
    
}
