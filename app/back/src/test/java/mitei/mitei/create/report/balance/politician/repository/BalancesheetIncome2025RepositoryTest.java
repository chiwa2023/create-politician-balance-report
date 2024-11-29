package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;

/**
 * BalancesheetIncome2025Repository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BalancesheetIncome2025RepositoryTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private BalancesheetIncome2025Repository balancesheetIncome2025Repository;

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql("classpath:sql/DML/balancesheet_income_2025_delete.sql")
    void testFindFirstByOrderByBalancesheetIncomeCodeNoData() {

        Optional<BalancesheetIncome2025Entity> optional = balancesheetIncome2025Repository
                .findFirstByOrderByBalancesheetIncomeCodeDesc();
        assertThat(optional.isEmpty()).isTrue();
    }

    @Test
    @Transactional
    // @Sql("classpath:sql/DML/balancesheet_income_2025_test.sql")
    void testFindFirstByOrderByBalancesheetIncomeCodeExist() {

        Optional<BalancesheetIncome2025Entity> optional = balancesheetIncome2025Repository
                .findFirstByOrderByBalancesheetIncomeCodeDesc();
        assertThat(optional.get().getBalancesheetIncomeCode()).isEqualTo(131L);
    }

}
