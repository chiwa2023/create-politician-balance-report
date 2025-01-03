package mitei.mitei.create.report.balance.politician.controller.zengin_master;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.apache.tomcat.websocket.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mitei.mitei.create.report.balance.politician.controller.AbstractTemplateCheckController;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckSecurityDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.TemplateFrameworkCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.ZenginOrgChangeBranchEntity;

/**
 * 全銀変更テーブルデータを受信する
 */
@Controller
@RequestMapping("/zengin-change")
public class RecieveZenginChageDataController extends AbstractTemplateCheckController {

    /** セキュリティチェック不可定数 */
    private static final int SECURITY_CHECK_FALSE = AbstractTemplateCheckController.SECURITY_CHECK_FALSE;
    /** 権限チェック不可定数 */
    private static final int PRIVIKEGE_CHECK_FALSE = AbstractTemplateCheckController.PRIVIKEGE_CHECK_FALSE;
    /** 排他制御チェック不可定数 */
    private static final int TRANSACION_CHECK_FALSE = AbstractTemplateCheckController.TRANSACION_CHECK_FALSE;
    /** ビジネス処理続行定数 */
    private static final int CHECK_TRUE = AbstractTemplateCheckController.CHECK_TRUE;

    /** ビジネス処理続行定数 */
    private Logger log = LoggerFactory.getLogger(RecieveZenginChageDataController.class);

    /**
     * 処理を行う
     *
     * @param listChange 変更テーブルデータ
     * @return 登録結果
     * @throws SecurityException                  セキュリティ例外
     * @throws AuthenticationException            権限例外
     * @throws PessimisticLockingFailureException トランザクション例外
     */
    @Transactional
    @PostMapping("/recieve")
    public ResponseEntity<TemplateFrameworkResultDto> practice(
            final @RequestBody List<ZenginOrgChangeBranchEntity> listChange)
            throws SecurityException, AuthenticationException, PessimisticLockingFailureException { // NOPMD

        // NOTE:共通処理を行ったのちビジネス処理を行うフレームワークのため、ビジネス処理以外は丸コピすること
        // TODO 作成側と調査側でユーザIDを共通化していないため、そのままチェックに使えない
        // チェックしないことはありえないので、何らかの形でチェックを行う

        TemplateFrameworkCapsuleDto capsuleDto = new TemplateFrameworkCapsuleDto();
        capsuleDto.setCheckSecurityDto(new CheckSecurityDto());
        capsuleDto.setCheckPrivilegeDto(new CheckPrivilegeDto());
        capsuleDto.setCheckTransactionDto(new CheckTransactionDto());

        try {
            switch (super.allCheck(capsuleDto.getCheckSecurityDto(), capsuleDto.getCheckPrivilegeDto(),
                    capsuleDto.getCheckTransactionDto())) {
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
             * 
             */

            log.info("success!!");

            for (ZenginOrgChangeBranchEntity entity : listChange) {
                log.info("-------------------");
                log.info("id" + entity.getZenginOrgChangeBranchId());
                log.info("銀行コード" + entity.getOrgCode());
                log.info("支店コード" + entity.getBranchCode());
                log.info("名称" + entity.getZenginOrgTempoMasterName());
            }

            // TODO 判定内容を記載する
            TemplateFrameworkResultDto resulttDto = new TemplateFrameworkResultDto();
            resulttDto.setIsOk(true);
            resulttDto.setSuccessCount(listChange.size());
            resulttDto.setFailureCount(00);

            return ResponseEntity.ok(resulttDto);
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
            // TODO エラーをDBに登録するようになった時点でStackTrace出力を削除する
            super.showError(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
