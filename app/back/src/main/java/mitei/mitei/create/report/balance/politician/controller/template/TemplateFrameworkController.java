package mitei.mitei.create.report.balance.politician.controller.template;

import java.util.List;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDtoDto;
import mitei.mitei.create.report.balance.politician.entity.VariousFinancialPayEntity;

/**
 * 各種Pay操作Controller
 */
@Controller
@RequestMapping("/template-framework")
public class TemplateFrameworkController extends AbstractTemplateCheckController {

    /** セキュリティチェック不可定数 */
    private static final int SECURITY_CHECK_FALSE = AbstractTemplateCheckController.SECURITY_CHECK_FALSE;
    /** 権限チェック不可定数 */
    private static final int PRIVIKEGE_CHECK_FALSE = AbstractTemplateCheckController.PRIVIKEGE_CHECK_FALSE;
    /** 排他制御チェック不可定数 */
    private static final int TRANSACION_CHECK_FALSE = AbstractTemplateCheckController.TRANSACION_CHECK_FALSE;
    /** ビジネス処理続行定数 */
    private static final int CHECK_TRUE = AbstractTemplateCheckController.CHECK_TRUE;

    /**
     * 各種Payテーブルの検索を行う
     *
     * @param templateFrameworkCapsuleDtoDto 各種Pay統合Dto
     * @return 各種Payエンティティリスト
     * @throws SecurityException       セキュリティ例外
     * @throws AuthenticationException 権限例外
     * @throws DuplicateKeyException   トランザクション例外
     */
    @Transactional // CHECKSTYLE:OFF
    @PostMapping("/do-test")
    public ResponseEntity<List<VariousFinancialPayEntity>> doTest(
            final @RequestBody TemplateFrameworkCapsuleDtoDto templateFrameworkCapsuleDtoDto)
            throws SecurityException, AuthenticationException, DuplicateKeyException { // NOPMD

        // NOTE:共通処理を行ったのちビジネス処理を行うフレームワークのため、ビジネス処理以外は丸コピすること
        try {
            switch (super.allCheck(templateFrameworkCapsuleDtoDto.getCheckSecurityDto(),
                    templateFrameworkCapsuleDtoDto.getCheckPrivilegeDto(),
                    templateFrameworkCapsuleDtoDto.getCheckTransactionDto())) {
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
                throw new IllegalArgumentException("共通チェック処理で発生しえない値が挿入されています");
            }

            /*
             * ここに固有のビジネス処理を記載する
             * 
             */
            // TODO ビジネス処理
            // ビジネス処理作業結果 = politicianViewService.practice();

            return ResponseEntity.ok(null);// TODO 正常に処理できた場合はここに結果を挿入する

            /* ここまで */

        } catch (AuthenticationException authenticationException) {
            // 権限不足
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (SecurityException securityException) {
            // セキュリティ事故
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build(); // NOPMD
        } catch (DuplicateKeyException duplicateKeyException) {
            // 排他の対象
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception exception) { // NOPMD
            // その他のビジネスロジック処理例外はInternalServerError
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
