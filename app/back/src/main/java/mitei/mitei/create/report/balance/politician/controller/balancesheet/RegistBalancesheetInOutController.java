package mitei.mitei.create.report.balance.politician.controller.balancesheet;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.controller.AbstractTemplateCheckController;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;
import mitei.mitei.create.report.balance.politician.logic.task.CreateTaskByReportKbnTaskLogic;
import mitei.mitei.create.report.balance.politician.service.audit_opinion.RegistAuditOpinionService;
import mitei.mitei.create.report.balance.politician.service.balancesheet.RegistBalancesheetInOutService;
import mitei.mitei.create.report.balance.politician.service.task_plan.RegistTaskPlanAllPortalService;

/**
 * 政治資金収支報告書収入リスト・支出リスト登録Controller
 */
@Controller
@RequestMapping("/create-balancesheet-in-out")
public class RegistBalancesheetInOutController extends AbstractTemplateCheckController {

    /** セキュリティチェック不可定数 */
    private static final int SECURITY_CHECK_FALSE = AbstractTemplateCheckController.SECURITY_CHECK_FALSE;
    /** 権限チェック不可定数 */
    private static final int PRIVIKEGE_CHECK_FALSE = AbstractTemplateCheckController.PRIVIKEGE_CHECK_FALSE;
    /** 排他制御チェック不可定数 */
    private static final int TRANSACION_CHECK_FALSE = AbstractTemplateCheckController.TRANSACION_CHECK_FALSE;
    /** ビジネス処理続行定数 */
    private static final int CHECK_TRUE = AbstractTemplateCheckController.CHECK_TRUE;

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
     * 各種Payテーブルの検索を行う
     *
     * @param registBalancesheetInOutCapsuleDto 収支報告書収入・支出登録用リストDto
     * @return 各種Payエンティティリスト
     * @throws SecurityException                  セキュリティ例外
     * @throws AuthenticationException            権限例外
     * @throws PessimisticLockingFailureException トランザクション例外
     */
    @Transactional
    @PostMapping("/regist")
    public ResponseEntity<TemplateFrameworkResultDto> selectTemplateByNumber(
            final @RequestBody RegistBalancesheetInOutCapsuleDto registBalancesheetInOutCapsuleDto)
            throws SecurityException, AuthenticationException, PessimisticLockingFailureException { // NOPMD

        // NOTE:共通処理を行ったのちビジネス処理を行うフレームワークのため、ビジネス処理以外は丸コピすること
        try {
            switch (super.allCheck(registBalancesheetInOutCapsuleDto.getCheckSecurityDto(),
                    registBalancesheetInOutCapsuleDto.getCheckPrivilegeDto(),
                    registBalancesheetInOutCapsuleDto.getCheckTransactionDto())) {
                // セキュリティチェック不可
                case SECURITY_CHECK_FALSE:
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
                // 権限チェック不可
                case PRIVIKEGE_CHECK_FALSE:
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                // 排他制御チェック不可
                case TRANSACION_CHECK_FALSE:
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();

                // ビジネス処理続行
                case CHECK_TRUE:
                    break;

                // 想定外の値(実装ミス?)
                default:
                    throw new IllegalArgumentException(OTHER_EXCEPTION_MESSAGE);
            }

            /*
             * ここに固有のビジネス処理を記載する
             */

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
                return new ResponseEntity<>(resultDto, HttpStatus.NO_CONTENT);
            }

            // リストと同じだけの登録結果が返っていた時 TODO タスク処理は新しくしたので書き直し
            List<TaskPlanInterface> listTask = new ArrayList<>();

            // 収支区分がタスク計上である場合はタスクに入れる
            //listTask.addAll(createTaskByReportKbnTaskLogic.practice(registBalancesheetInOutCapsuleDto));

            // 自動登録した段階で、前例と異なる処理と判断され、仕訳調整対象と判断されたら、タスク計上する
            //listTask.addAll(registAuditOpinionService.practice(registBalancesheetInOutCapsuleDto));

            resultDto = registTaskPlanAllPortalService.practice(listTask);

            if (resultDto.getIsOk()) {
                resultDto.setIsOk(true);
                resultDto.setSuccessCount(result);
            } else {
                resultDto.setIsOk(false);
                resultDto.setMessage("タスクが登録できませんでした");
                return new ResponseEntity<>(resultDto, HttpStatus.NO_CONTENT);
            }

            return ResponseEntity.ok(resultDto);
            /* ここまで */

        } catch (AuthenticationException authenticationException) { // NOPMD
            // 権限不足
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (SecurityException securityException) {
            // セキュリティ事故
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        } catch (PessimisticLockingFailureException pessimisticLockingFailureException) {
            // 排他の対象
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception exception) { // NOPMD
            super.showError(exception); // TODO log処理が確定した段階で修正する
            // その他のビジネスロジック処理例外はInternalServerError
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
