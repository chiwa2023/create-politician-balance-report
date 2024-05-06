package mitei.mitei.create.report.balance.politician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mitei.mitei.create.report.balance.politician.entity.ZenginFinancialOrgEntity;

/**
 * zengin_financial_org接続用Repository
 */
public interface ZenginFinancialOrgRepository extends JpaRepository<ZenginFinancialOrgEntity, Integer> {

    /**
     * 名称を検索対象として全文検索をする
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    @Query(value = "SELECT * FROM zengin_financial_org WHERE saishin_kbn= 1 AND MATCH(table_all_search_text) AGAINST (?1 IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    List<ZenginFinancialOrgEntity> findFullText(String searchWords);
}