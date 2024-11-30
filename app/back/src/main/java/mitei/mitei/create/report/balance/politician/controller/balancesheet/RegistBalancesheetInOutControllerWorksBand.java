package mitei.mitei.create.report.balance.politician.controller.balancesheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;
import mitei.mitei.create.report.balance.politician.logic.task.CreateTaskByReportKbnTaskLogic;
import mitei.mitei.create.report.balance.politician.service.audit_opinion.RegistAuditOpinionService;
import mitei.mitei.create.report.balance.politician.service.balancesheet.RegistBalancesheetInOutService;
import mitei.mitei.create.report.balance.politician.service.task_plan.RegistTaskPlanAllPortalService;

/**
 * ビジネスロジックをまとめるWorksBandController(Transaction用)
 */
@Component
public class RegistBalancesheetInOutControllerWorksBand {

    /** 収支報告リスト登録Service */
    @Autowired
    private RegistBalancesheetInOutService registBalancesheetInOutService;

    /** 収支報告分タスク計上タスク作成Logic */
    @Autowired
    private CreateTaskByReportKbnTaskLogic createTaskByReportKbnTaskLogic;

    /** 収支報告意見付記リスト登録Service */
    @Autowired
    private RegistAuditOpinionService registAuditOpinionService;

    /** タスク登録Service */
    @Autowired
    private RegistTaskPlanAllPortalService registTaskPlanAllPortalService;

    /**
     * 処理を行う
     *
     * @param registBalancesheetInOutCapsuleDto 政治資金収支報告書支出登録Dto
     * @return 処理結果
     */
    @Transactional
    public TemplateFrameworkResultDto wakeBusiness(
            final RegistBalancesheetInOutCapsuleDto registBalancesheetInOutCapsuleDto) {

        int result = registBalancesheetInOutService.practice(registBalancesheetInOutCapsuleDto);

        TemplateFrameworkResultDto resultDto;

        // 収支報告書項目が登録できていない
        if (result != (registBalancesheetInOutCapsuleDto.getListIncome().size()
                + registBalancesheetInOutCapsuleDto.getListOutcome().size())) {

            // TODO すべての行が登録balancesheetに登録できていません。
            resultDto = new TemplateFrameworkResultDto();
            resultDto.setIsOk(false);
            resultDto.setSuccessCount(result);
            resultDto.setMessage("収支報告書を登録できませんでした");
            return resultDto;
        }

        // リストと同じだけの登録結果が返っていた時 TODO タスク処理は新しくしたので書き直し
        List<TaskPlanInterface> listTask = new ArrayList<>();

        // 収支区分がタスク計上である場合はタスクに入れる
        // listTask.addAll(createTaskByReportKbnTaskLogic.practice(registBalancesheetInOutCapsuleDto));

        // 自動登録した段階で、前例と異なる処理と判断され、仕訳調整対象と判断されたら、タスク計上する
        // listTask.addAll(registAuditOpinionService.practice(registBalancesheetInOutCapsuleDto));

        resultDto = registTaskPlanAllPortalService.practice(listTask);

        if (resultDto.getIsOk()) {
            resultDto.setIsOk(true);
            resultDto.setSuccessCount(result);
        } else {
            resultDto.setIsOk(false);
            resultDto.setMessage("タスクが登録できませんでした");
        }

        return resultDto;
    }
}
