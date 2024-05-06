package mitei.mitei.create.report.balance.politician.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import jakarta.persistence.LockModeType;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;

/**
 * balancesheet_income_2025接続用Repository
 */
public interface BalancesheetIncome2025Repository extends JpaRepository<BalancesheetIncome2025Entity, Long> {

    /**
     * テーブル同一識別コードがテーブルで最大行を取得する
     *
     * @return 最大値のOptional
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<BalancesheetIncome2025Entity> findFirstByOrderByBalancesheetIncomeCodeDesc();

    // TODO マスタ系のテーブルでは名称検索が要求されることが多いので、事前に自動生成する。不要な場合は削除する
    /// **
    // * 名称を検索対象として全文検索をする
    // *
    // * @param searchWords 検索語
    // * @return 検索結果
    // */
    // @Query(value = "SELECT * FROM balancesheet_income_2025 WHERE saishin_kbn= 1
    // AND MATCH(balancesheet_income_2025_name) AGAINST (?1 IN NATURAL LANGUAGE
    // MODE)", nativeQuery = true)
    // public List<BalancesheetIncome2025Entity> findFullText(String searchWords);

}
