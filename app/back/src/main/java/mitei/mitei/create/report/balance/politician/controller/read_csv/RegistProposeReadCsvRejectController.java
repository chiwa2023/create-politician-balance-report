package mitei.mitei.create.report.balance.politician.controller.read_csv;

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
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.service.read_csv.RegistProposeReadCsvRejectService;

/**
 * CSV読み取り仕様申請を却下する
 */
@Controller
@RequestMapping("/propose-csv-read-reject")
public class RegistProposeReadCsvRejectController extends AbstractTemplateCheckController {

    /** セキュリティチェック不可定数 */
    private static final int SECURITY_CHECK_FALSE = AbstractTemplateCheckController.SECURITY_CHECK_FALSE;
    /** 権限チェック不可定数 */
    private static final int PRIVIKEGE_CHECK_FALSE = AbstractTemplateCheckController.PRIVIKEGE_CHECK_FALSE;
    /** 排他制御チェック不可定数 */
    private static final int TRANSACION_CHECK_FALSE = AbstractTemplateCheckController.TRANSACION_CHECK_FALSE;
    /** ビジネス処理続行定数 */
    private static final int CHECK_TRUE = AbstractTemplateCheckController.CHECK_TRUE;

    /** csv読み取り仕様申請却下Service */
    @Autowired
    private RegistProposeReadCsvRejectService registProposeReadCsvRejectService;

    /**
     * 登録作業を行う
     *
     * @param registProposeCsvReadRemplateCapsuleDto 編集中の申請CSV読み取り仕様Entityを含むCapsuleDto
     * @return 登録結果
     * @throws SecurityException                  セキュリティ例外
     * @throws AuthenticationException            権限例外
     * @throws PessimisticLockingFailureException トランザクション例外
     */
    @Transactional
    @PostMapping("/regist")
    public ResponseEntity<TemplateFrameworkResultDto> practice(
            final @RequestBody RegistProposeCsvReadRemplateCapsuleDto registProposeCsvReadRemplateCapsuleDto)
            throws SecurityException, AuthenticationException, PessimisticLockingFailureException { // NOPMD

        // NOTE:共通処理を行ったのちビジネス処理を行うフレームワークのため、ビジネス処理以外は丸コピすること
        try {
            switch (super.allCheck(registProposeCsvReadRemplateCapsuleDto.getCheckSecurityDto(),
                    registProposeCsvReadRemplateCapsuleDto.getCheckPrivilegeDto(),
                    registProposeCsvReadRemplateCapsuleDto.getCheckTransactionDto())) {
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

            //ユーザ設定を行う
            CheckPrivilegeDto privilegeDto = registProposeCsvReadRemplateCapsuleDto.getCheckPrivilegeDto();

            ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity = registProposeCsvReadRemplateCapsuleDto
                    .getProposeCsvReadTemplateEntity();
            proposeCsvReadTemplateEntity.setLoginUserId(privilegeDto.getLoginUserId());
            proposeCsvReadTemplateEntity.setLoginUserCode(privilegeDto.getLoginUserCode());
            proposeCsvReadTemplateEntity.setLoginUserName(privilegeDto.getLoginUserName());

            //登録をお行う
            long newId = registProposeReadCsvRejectService.practice(proposeCsvReadTemplateEntity);

            final long initId = 0L;
            
            TemplateFrameworkResultDto resultDto = new TemplateFrameworkResultDto();
            if (initId == newId) {
                resultDto.setFailureCount(0);
                resultDto.setMessage("登録できませんでした");
            } else {
                resultDto.setIsOk(true);
                resultDto.setSuccessCount(1);
                resultDto.setMessage("登録できました");
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

            // TODO 例外をデータベースに記録するようになったら削除する
            super.showError(exception);

            // その他のビジネスロジック処理例外はInternalServerError
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}