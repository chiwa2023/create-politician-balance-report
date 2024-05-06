package mitei.mitei.create.report.balance.politician.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import jakarta.persistence.LockModeType;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;

/**
 * balancesheet_outcome_2025接続用Repository
 */
public interface BalancesheetOutcome2025Repository extends JpaRepository<BalancesheetOutcome2025Entity, Integer> {

    /**
     * テーブル同一識別コードがテーブルで最大行を取得する
     *
     * @return 最大値のOptional
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<BalancesheetOutcome2025Entity> findFirstByOrderByBalancesheetOutcomeCodeDesc();

    // TODO マスタ系のテーブルでは名称検索が要求されることが多いので、事前に自動生成する。不要な場合は削除する
    /// **
    // * 名称を検索対象として全文検索をする
    // *
    // * @param searchWords 検索語
    // * @return 検索結果
    // */
    // @Query(value = "SELECT * FROM balancesheet_outcome_2025 WHERE saishin_kbn= 1
    // AND MATCH(balancesheet_outcome_2025_name) AGAINST (?1 IN NATURAL LANGUAGE
    // MODE)", nativeQuery = true)
    // public List<BalancesheetOutcome2025Entity> findFullText(String searchWords);

}
