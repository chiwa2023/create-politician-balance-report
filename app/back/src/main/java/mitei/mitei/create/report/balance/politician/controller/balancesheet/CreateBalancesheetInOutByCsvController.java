package mitei.mitei.create.report.balance.politician.controller.balancesheet;

import java.time.format.DateTimeParseException;

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
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancesheetInOutDataCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancsheetInOutItemResultDto;
import mitei.mitei.create.report.balance.politician.service.balancesheet.CreateBalancesheetInOutByCsvService;

/**
 * csvデータから政治資金収支報告書の支出項目リストと収入項目リストを生成する
 */
@Controller
@RequestMapping("/create-balancesheet-in-out")
public class CreateBalancesheetInOutByCsvController extends AbstractTemplateCheckController {

    /** セキュリティチェック不可定数 */
    private static final int SECURITY_CHECK_FALSE = AbstractTemplateCheckController.SECURITY_CHECK_FALSE;
    /** 権限チェック不可定数 */
    private static final int PRIVIKEGE_CHECK_FALSE = AbstractTemplateCheckController.PRIVIKEGE_CHECK_FALSE;
    /** 排他制御チェック不可定数 */
    private static final int TRANSACION_CHECK_FALSE = AbstractTemplateCheckController.TRANSACION_CHECK_FALSE;
    /** ビジネス処理続行定数 */
    private static final int CHECK_TRUE = AbstractTemplateCheckController.CHECK_TRUE;

    /** 収支報告リスト作成Service */
    @Autowired
    private CreateBalancesheetInOutByCsvService createBalancesheetInOutByCsvService;

    /**
     * 各種Payテーブルの検索を行う
     *
     * @param createBalancesheetInOutDataCapsuleDto 収支報告書収入・支出リスト生成統合Dto
     * @return 各種Payエンティティリスト
     * @throws SecurityException       セキュリティ例外
     * @throws AuthenticationException 権限例外
     * @throws PessimisticLockingFailureException   トランザクション例外
     */
    @Transactional // CHECKSTYLE:OFF
    @PostMapping("/by-csv")
    public ResponseEntity<CreateBalancsheetInOutItemResultDto> selectTemplateByNumber(
            final @RequestBody CreateBalancesheetInOutDataCapsuleDto createBalancesheetInOutDataCapsuleDto)
            throws SecurityException, AuthenticationException, PessimisticLockingFailureException { // NOPMD

        // NOTE:共通処理を行ったのちビジネス処理を行うフレームワークのため、ビジネス処理以外は丸コピすること
        try {
            switch (super.allCheck(createBalancesheetInOutDataCapsuleDto.getCheckSecurityDto(),
                    createBalancesheetInOutDataCapsuleDto.getCheckPrivilegeDto(),
                    createBalancesheetInOutDataCapsuleDto.getCheckTransactionDto())) {
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
                return this.createIllegalExceptionResult("共通チェック処理で発生しえない値が挿入されています");
            }
            
            /*
             * ここに固有のビジネス処理を記載する
             */
            
            CreateBalancsheetInOutItemResultDto resultDto = createBalancesheetInOutByCsvService.practice(
                            createBalancesheetInOutDataCapsuleDto.getListCsvData(),
                            createBalancesheetInOutDataCapsuleDto.getSaveStorageResultDto(),   
                            createBalancesheetInOutDataCapsuleDto.getCheckPrivilegeDto(),
                            createBalancesheetInOutDataCapsuleDto.getListPointer()
                            );
            
            if(resultDto.getIsOk()) {
                return ResponseEntity.ok().body(resultDto);
            }else {
                //ユーザさん操作起因の例外はno_contentで返す
                return new ResponseEntity<>(resultDto,HttpStatus.NO_CONTENT);
            }
            
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
            
        } catch(NumberFormatException ne) {
            //数値変換不可
            CreateBalancsheetInOutItemResultDto resultDto = new CreateBalancsheetInOutItemResultDto();
            resultDto.setIsOk(false);
            resultDto.setMessage("金額指定の中に数字変換できない値があります");
            return new ResponseEntity<>(resultDto,HttpStatus.NO_CONTENT);
            
        } catch(DateTimeParseException de) {
            //日付変換不可
            CreateBalancsheetInOutItemResultDto resultDto = new CreateBalancsheetInOutItemResultDto();
            resultDto.setIsOk(false);
            resultDto.setMessage("日付指定の中に日付変換できない値があります");
            return new ResponseEntity<>(resultDto,HttpStatus.NO_CONTENT);
            
        } catch(IllegalArgumentException ie) {
            return this.createIllegalExceptionResult(ie.getMessage());
            
        } catch (Exception exception) { // NOPMD
            super.showError(exception); //TODO log処理が確定した段階で修正する
            // その他のビジネスロジック処理例外はInternalServerError
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private ResponseEntity<CreateBalancsheetInOutItemResultDto> createIllegalExceptionResult(final String message){
        //csvの紐づけまたは行設定が不正
        CreateBalancsheetInOutItemResultDto resultDto = new CreateBalancsheetInOutItemResultDto();
        resultDto.setIsOk(false);
        resultDto.setMessage(message);
        return new ResponseEntity<>(resultDto,HttpStatus.NO_CONTENT);
    }
}
