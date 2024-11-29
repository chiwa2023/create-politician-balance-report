package mitei.mitei.create.report.balance.politician.repository;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

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

    
    @Test
    @Tag("TableTruncate")
    @Transactional
    void testFindFullText() {
        fail("not yet implments");
    }
}
