package mitei.mitei.create.report.balance.politician.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * AuditOpinionIncome2025Repository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql("classpath:sql/audit_opinion_income_2025_test.sql")
class AuditOpinionIncome2025RepositoryTest {

    /** テスト対象 */
    @Autowired
    private AuditOpinionIncome2025Repository auditOpinionIncome2025Repository;

}
