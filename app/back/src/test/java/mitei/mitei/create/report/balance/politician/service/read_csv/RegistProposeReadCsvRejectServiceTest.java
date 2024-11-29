package mitei.mitei.create.report.balance.politician.service.read_csv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * RegistProposeReadCsvRejectService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
@Transactional
class RegistProposeReadCsvRejectServiceTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private RegistProposeReadCsvRejectService registProposeReadCsvRejectService;

    /** CSV読み取り使用申請テーブル */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    @Test
    @Tag("TableTruncate")
    void testPractice() throws Exception {

        long editId = 14L;

        ProposeCsvReadTemplateEntity entityEdit = proposeCsvReadTemplateRepository.getReferenceById(editId);
        final String reason = "類似データが存在";
        entityEdit.setJudgeReason(reason);

        long newId = registProposeReadCsvRejectService.practice(entityEdit);

        // 正常登録
        assertTrue(newId != 0L,"初期Idでない=登録済です");

        ProposeCsvReadTemplateEntity entityNew = proposeCsvReadTemplateRepository.getReferenceById(newId);

        // 最新データ
        assertThat(entityNew.getSaishinKbn()).isEqualTo(DataHistoryStatusConstants.INSERT.value());

        // 設定した理由
        assertThat(entityNew.getJudgeReason()).isEqualTo(reason);

        // 申請過程継続
        assertTrue(entityNew.getInProsessing(),"申請過程継続");

        // 申請却下
        assertFalse(entityNew.getIsAccepted(),"申請却下");

        // 編集対象を再度呼び出し
        ProposeCsvReadTemplateEntity entityUpdate = proposeCsvReadTemplateRepository.getReferenceById(editId);
        // 間違いなく最新区分は履歴
        assertThat(entityUpdate.getSaishinKbn()).isEqualTo(DataHistoryStatusConstants.UPDATE.value());
    }

}
