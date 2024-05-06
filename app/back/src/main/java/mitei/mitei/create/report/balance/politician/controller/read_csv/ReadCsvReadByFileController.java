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
import mitei.mitei.create.report.balance.politician.dto.read_csv.ReadCsvByFileCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.SendCsvAndStragedShoshouDto;
import mitei.mitei.create.report.balance.politician.service.read_csv.ReadCsvReadByFileService;
import mitei.mitei.create.report.balance.politician.service.save_shoshou.SaveShoshouStrageService;

/**
 * ファイルから読み込みしたテキストからCSV形式に変換するContoller
 */
@Controller
@RequestMapping("/read-csv-by-file")
public class ReadCsvReadByFileController extends AbstractTemplateCheckController {

    /** セキュリティチェック不可定数 */
    private static final int SECURITY_CHECK_FALSE = AbstractTemplateCheckController.SECURITY_CHECK_FALSE;
    /** 権限チェック不可定数 */
    private static final int PRIVIKEGE_CHECK_FALSE = AbstractTemplateCheckController.PRIVIKEGE_CHECK_FALSE;
    /** 排他制御チェック不可定数 */
    private static final int TRANSACION_CHECK_FALSE = AbstractTemplateCheckController.TRANSACION_CHECK_FALSE;
    /** ビジネス処理続行定数 */
    private static final int CHECK_TRUE = AbstractTemplateCheckController.CHECK_TRUE;

    /** csv変換Service */
    @Autowired
    private ReadCsvReadByFileService readCsvReadByFileService;

    /** 書証保存Service */
    @Autowired
    private SaveShoshouStrageService saveShoshouStrageService;

    /**
     * fileからcsv形式に変更し、成功したら書証としてストレージ保存する
     *
     * @param readCsvByFileCapsuleDto CSV読み取りカプセルDto
     * @return 各種Payエンティティリスト
     * @throws SecurityException       セキュリティ例外
     * @throws AuthenticationException 権限例外
     * @throws PessimisticLockingFailureException   トランザクション例外
     */
    @Transactional // CHECKSTYLE:OFF
    @PostMapping("/practice")
    public ResponseEntity<SendCsvAndStragedShoshouDto> practice(
            final @RequestBody ReadCsvByFileCapsuleDto readCsvByFileCapsuleDto)
            throws SecurityException, AuthenticationException, PessimisticLockingFailureException { // NOPMD

        // NOTE:共通処理を行ったのちビジネス処理を行うフレームワークのため、ビジネス処理以外は丸コピすること
        try {
            switch (super.allCheck(readCsvByFileCapsuleDto.getCheckSecurityDto(),
                    readCsvByFileCapsuleDto.getCheckPrivilegeDto(), readCsvByFileCapsuleDto.getCheckTransactionDto())) {
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
             */
            SendCsvAndStragedShoshouDto csvDto = new SendCsvAndStragedShoshouDto();

            csvDto.setListAllCsv(readCsvReadByFileService.practice(readCsvByFileCapsuleDto.getFileContent()));

            csvDto.setSaveStorageResultDto(
                    saveShoshouStrageService.practice(
                            readCsvByFileCapsuleDto.getFileName(),
                            readCsvByFileCapsuleDto.getCheckPrivilegeDto().getLoginUserId())
                    );
            
            return ResponseEntity.ok(csvDto);

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
            
            //TODO 例外をデータベースに記録するようになったら削除する
            super.showError(exception);
            
            // その他のビジネスロジック処理例外はInternalServerError
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
