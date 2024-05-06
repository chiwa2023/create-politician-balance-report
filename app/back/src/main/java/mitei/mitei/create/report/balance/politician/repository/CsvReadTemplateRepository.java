package mitei.mitei.create.report.balance.politician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mitei.mitei.create.report.balance.politician.entity.CsvReadTemplateEntity;

/**
 * csv読み取り仕様を格納するテーブルcsv_read_Templateのrepository
 */
@Repository
public interface CsvReadTemplateRepository  extends JpaRepository<CsvReadTemplateEntity, Long>{

    /**
     * 項目件数を条件として該当するcsv読み取り仕様を取得する
     *
     * @param arrayNumber 項目件数
     * @return 該当リスト
     */
    List<CsvReadTemplateEntity> findByArrayNumberOrderByCsvReadTemplateNameAsc(Integer arrayNumber);

    /**
     * 名称を検索対象として全文検索をする
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    @Query(value = "SELECT * FROM csv_read_template WHERE saishin_kbn= 1 AND MATCH(table_all_search_text) AGAINST (?1 IN NATURAL LANGUAGE MODE WITH QUERY EXPANSION)", nativeQuery = true)
    List<CsvReadTemplateEntity> findFullText(String searchWords);

}