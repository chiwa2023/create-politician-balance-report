package mitei.mitei.create.report.balance.politician.service.audit_opinion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.AuditOpinionIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.AuditOpinionOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.PoliticalOrganizationEntity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;
import mitei.mitei.create.report.balance.politician.logic.audit_opinion.ConvertAuditToTaskLogic;
import mitei.mitei.create.report.balance.politician.logic.political_organizaion.GetRoleInPolitialOrganizationLogic;
import mitei.mitei.create.report.balance.politician.repository.AuditOpinionIncome2025Repository;
import mitei.mitei.create.report.balance.politician.repository.AuditOpinionOutcome2025Repository;
import mitei.mitei.create.report.balance.politician.repository.PoliticalOrganizationRepository;

/**
 * 意見付記登録(収入／支出)Service
 */
@Service
public class RegistAuditOpinionService {

    /** 意見付記収入Repository */
    @Autowired
    private AuditOpinionIncome2025Repository auditOpinionIncome2025Repository;

    /** 意見付記支出Repository */
    @Autowired
    private AuditOpinionOutcome2025Repository auditOpinionOutcome2025Repository;

    /** 政治団体Repository */
    @Autowired
    private PoliticalOrganizationRepository politicalOrganizationRepository;

    /** 政治団体内役割取得Logic */
    @Autowired
    private GetRoleInPolitialOrganizationLogic  getRoleInPolitialOrganizationLogic;

    /** 意見付記タスク変換Logic */
    @Autowired
    private ConvertAuditToTaskLogic convertAuditToTaskLogic;

    /** 空文字 */
    private final static String BLANK_CHAR = "";

    /**
     * 意見付記リストにに該当データを追加し、タスク登録をするためのリストを返す
     *
     * @param registBalancesheetInOutCapsuleDto 収支報告書登録済リスト
     * @return タスク登録リスト
     */
    public List<TaskPlanInterface> practice(final RegistBalancesheetInOutCapsuleDto registBalancesheetInOutCapsuleDto) {
        List<BalancesheetIncome2025Entity> listIncome = registBalancesheetInOutCapsuleDto.getListIncome();
        List<BalancesheetOutcome2025Entity> listOutcome = registBalancesheetInOutCapsuleDto.getListOutcome();

        LocalDateTime now = LocalDateTime.now();
        // 支出のうち前例と異なる収入
        List<AuditOpinionIncome2025Entity> listAuditIncome = new ArrayList<>();
        
        if (!listIncome.isEmpty()) {
            //役割取得
            BalancesheetIncome2025Entity incomeEntity = listIncome.get(0);
            PoliticalOrganizationEntity politicalOrganizationEntity = politicalOrganizationRepository
                    .getReferenceById(incomeEntity.getPoliticalOrganizationId());
            String role = getRoleInPolitialOrganizationLogic.practice(politicalOrganizationEntity, incomeEntity.getInsertUserCode());

            for (BalancesheetIncome2025Entity entityIncome : listIncome) {
                // 前例と異なる処理が選択されている時
                if (entityIncome.getIsDifferPrecedent()) {
                    listAuditIncome.add(this.createAuditByIncome(now, role, entityIncome));
                }
            }

        }
        // リスト丸ごと登録
        List<AuditOpinionIncome2025Entity> listRecordedIncome = auditOpinionIncome2025Repository
                .saveAll(listAuditIncome);

        // 支出のうち前例と異なる処理
        List<AuditOpinionOutcome2025Entity> listAuditOutcome = new ArrayList<>();

        if (!listOutcome.isEmpty()) {
            //役割取得
            BalancesheetOutcome2025Entity outcomeEntity = listOutcome.get(0);

            PoliticalOrganizationEntity politicalOrganizationEntity = politicalOrganizationRepository
                    .getReferenceById(outcomeEntity.getPoliticalOrganizationId());
            String role = getRoleInPolitialOrganizationLogic.practice(politicalOrganizationEntity, outcomeEntity.getInsertUserCode());

            for (BalancesheetOutcome2025Entity entityOutcome : listOutcome) {
                // 前例と異なる処理が選択されている時
                if (entityOutcome.getIsDifferPrecedent()) {
                    listAuditOutcome.add(this.createAuditByOutcome(now, role, entityOutcome));
                }
            }

        }

        // リスト丸ごと登録
        List<AuditOpinionOutcome2025Entity> listRecodedOutcome = auditOpinionOutcome2025Repository
                .saveAll(listAuditOutcome);

        //タスク登録するリストに変換
        List<TaskPlanInterface> listTask = new ArrayList<>();
        listTask.addAll(convertAuditToTaskLogic.practiceIncome(listRecordedIncome));
        listTask.addAll(convertAuditToTaskLogic.practiceOutcome(listRecodedOutcome));
        
        return listTask;
    }


    private AuditOpinionIncome2025Entity createAuditByIncome(final LocalDateTime now,final String role, final BalancesheetIncome2025Entity entityIncome) {
        
        AuditOpinionIncome2025Entity entityAuditIncome = new AuditOpinionIncome2025Entity();

        BeanUtils.copyProperties(entityIncome, entityAuditIncome);
        // 特有の設定

        // auto_incrementできように明示的に0を設定
        entityAuditIncome.setAuditOpinionIncomeId(0L);
        // 作成側のデータです
        entityAuditIncome.setIsCreatedItemByInvest(false);

        // 調査側の値はすべて初期値
        entityAuditIncome.setResearcherAmount(0);
        entityAuditIncome.setAuditAgreeItemValue(BLANK_CHAR);
        entityAuditIncome.setAuditAgreeItemText(BLANK_CHAR);
        entityAuditIncome.setInsertUserRole(role);

        // 更新時間は現在時間
        // TODO SetTableDataHistoryUtilに変更
        entityAuditIncome.setInsertTimestamp(now);

        return entityAuditIncome;
    }

    private AuditOpinionOutcome2025Entity createAuditByOutcome(final LocalDateTime now,final String role, final BalancesheetOutcome2025Entity entityOutcome) {

        AuditOpinionOutcome2025Entity entityAuditOutcome = new AuditOpinionOutcome2025Entity();
        BeanUtils.copyProperties(entityOutcome, entityAuditOutcome);

        // auto_incrementできように明示的に0を設定
        entityAuditOutcome.setAuditOpinionOutcomeId(0L);
        // 作成側のデータです
        entityAuditOutcome.setIsCreatedItemByInvest(false);

        // 調査側の値はすべて初期値
        entityAuditOutcome.setResearcherAmount(0);
        entityAuditOutcome.setAuditAgreeItemValue(BLANK_CHAR);
        entityAuditOutcome.setAuditAgreeItemText(BLANK_CHAR);
        entityAuditOutcome.setInsertUserRole(role);

        // 更新時間は現在時間
        // TODO SetTableDataHistoryUtilに変更
        entityAuditOutcome.setInsertTimestamp(now);

        return entityAuditOutcome;
    }
}
