package mitei.mitei.create.report.balance.politician.task_plan.controller;

import java.time.LocalDateTime;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mitei.mitei.create.report.balance.politician.controller.AbstractTemplateCheckController;
import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanSearchConditonCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_plan.service.GetLoginUserTaskPlanService;

/**
 * 未処理タスク検索Controller
 */
@Controller
public class GetLoginUserTaskPlanController extends AbstractTemplateCheckController {

    /** セキュリティチェック不可定数 */
    private static final int SECURITY_CHECK_FALSE = AbstractTemplateCheckController.SECURITY_CHECK_FALSE;
    /** 権限チェック不可定数 */
    private static final int PRIVIKEGE_CHECK_FALSE = AbstractTemplateCheckController.PRIVIKEGE_CHECK_FALSE;
    /** 排他制御チェック不可定数 */
    private static final int TRANSACION_CHECK_FALSE = AbstractTemplateCheckController.TRANSACION_CHECK_FALSE;
    /** ビジネス処理続行定数 */
    private static final int CHECK_TRUE = AbstractTemplateCheckController.CHECK_TRUE;

    /** 未処理タスクリスト取得Service */
    @Autowired
    private GetLoginUserTaskPlanService getLoginUserTaskPlanService;

    /**
     * 未処理タスク格納Dtoを取得する
     *
     * @param searchConditionCapsuleDto 未処理タスク検索Dto
     * @return 未処理タスク検索結果Dto
     */
    @PostMapping("/get-task-plan")
    public ResponseEntity<TaskPlanResultDto> practice(
            @RequestBody final TaskPlanSearchConditonCapsuleDto searchConditionCapsuleDto) {

        // NOTE:共通処理を行ったのちビジネス処理を行うフレームワークのため、ビジネス処理以外は丸コピすること
        try {
            switch (super.allCheck(searchConditionCapsuleDto.getCheckSecurityDto(),
                    searchConditionCapsuleDto.getCheckPrivilegeDto(),
                    searchConditionCapsuleDto.getCheckTransactionDto())) {
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

            LocalDateTime now = LocalDateTime.now();
            return ResponseEntity
                    .ok(getLoginUserTaskPlanService.practice(now, searchConditionCapsuleDto.getCheckPrivilegeDto()));

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
            // その他のビジネスロジック処理例外はInternalServerError
            super.showError(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
