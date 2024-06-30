package mitei.mitei.create.report.balance.politician.service.read_csv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.CsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.CsvReadTemplateRepository;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * RegistProposeReadCsvAcceptService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
@Transactional
class RegistProposeReadCsvAcceptServiceTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private RegistProposeReadCsvAcceptService registProposeReadCsvAcceptService;

    /** CSV読み取り使用申請テーブル */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    /** CSV読み取り仕様テーブル */
    @Autowired
    private CsvReadTemplateRepository csvReadTemplateRepository;

    @Test
    void testPractice() throws Exception {
        // 旧リストの把握
        List<CsvReadTemplateEntity> listOld = csvReadTemplateRepository.findAll();
        int count = listOld.size();
        List<Long> listOldId = new ArrayList<>();
        for (CsvReadTemplateEntity entity : listOld) {
            listOldId.add(entity.getCsvReadTemplateId());
        }

        long editId = 15L;
        
        ProposeCsvReadTemplateEntity entityEdit = proposeCsvReadTemplateRepository.getReferenceById(editId);

        long newId = registProposeReadCsvAcceptService.practice(entityEdit);
        
        // 追加された行
        assertTrue(newId != 0L,"初期Id=未登録でない");

        ProposeCsvReadTemplateEntity entityResult = proposeCsvReadTemplateRepository.getReferenceById(newId);

        // 最新区分は履歴
        assertThat(entityResult.getSaishinKbn()).isEqualTo(SaishinKbnConstants.HISOTRY);

        // 正常に登録しました、の意
        assertThat(entityResult.getJudgeReason()).isEqualTo("正常登録");

        // 申請中ではない
        assertFalse(entityResult.getInProsessing(),"申請中でない");

        // 申請許可
        assertTrue(entityResult.getIsAccepted(),"許可");

        // 新リストを確認
        List<CsvReadTemplateEntity> listNew = csvReadTemplateRepository.findAll();

        //1件増えた
        assertThat(listNew.size()).isEqualTo(count + 1);
        
        //追加したデータを確定
        CsvReadTemplateEntity entityTemplateNew = null;
        for(CsvReadTemplateEntity entity : listNew) {
            if(!listOldId.contains(entity.getCsvReadTemplateId())) {
                entityTemplateNew = entity;
            }
        }
        
        //追加データを確定できた時は申請データと同一を確認
        if(!Objects.isNull(entityTemplateNew)) {
            //仕様名称
            assertThat(entityTemplateNew.getCsvReadTemplateName()).isEqualTo(entityResult.getProposeCsvReadTemplateName());
            //最新区分
            assertThat(entityTemplateNew.getSaishinKbn()).isEqualTo(SaishinKbnConstants.SAISHIN);
            //金融機関区分
            assertThat(entityTemplateNew.getFinancialOrgKbn()).isEqualTo(entityResult.getFinancialOrgKbn());
            //金融機関Id
            assertThat(entityTemplateNew.getFinancialOrgId()).isEqualTo(entityResult.getFinancialOrgId());
            //金融機関同一識別コード
            assertThat(entityTemplateNew.getFinancialOrgCode()).isEqualTo(entityResult.getFinancialOrgCode());
            //金融機関名称
            assertThat(entityTemplateNew.getFinancialOrgName()).isEqualTo(entityResult.getFinancialOrgName());
            //ヘッダの有無
            assertThat(entityTemplateNew.getHasHeader()).isEqualTo(entityResult.getHasHeader());
            //配列桁数
            assertThat(entityTemplateNew.getArrayNumber()).isEqualTo(entityResult.getArrayNumber());
            //指定配列内容
            assertThat(entityTemplateNew.getArrayText()).isEqualTo(entityResult.getArrayText());
        }
    }

}
