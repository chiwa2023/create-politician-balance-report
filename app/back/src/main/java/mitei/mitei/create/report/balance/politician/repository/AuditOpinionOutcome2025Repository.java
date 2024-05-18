package mitei.mitei.create.report.balance.politician.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mitei.mitei.create.report.balance.politician.entity.AuditOpinionOutcome2025Entity;

/**
 * audit_opinion_outcome_2025接続用Repository
 */
public interface AuditOpinionOutcome2025Repository  extends JpaRepository<AuditOpinionOutcome2025Entity, Long>{


    //TODO マスタ系のテーブルでは名称検索が要求されることが多いので、事前に自動生成する。不要な場合は削除する
    ///**
    // * 名称を検索対象として全文検索をする
    // *
    // * @param searchWords 検索語
    // * @return 検索結果
    // */
    //@Query(value = "SELECT * FROM audit_opinion_outcome_2025 WHERE saishin_kbn= 1 AND MATCH(audit_opinion_outcome_2025_name) AGAINST (?1 IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    //public List<AuditOpinionOutcome2025Entity> findFullText(String searchWords);
}

