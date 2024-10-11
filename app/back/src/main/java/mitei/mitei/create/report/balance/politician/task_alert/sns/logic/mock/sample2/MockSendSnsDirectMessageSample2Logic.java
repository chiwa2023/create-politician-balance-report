package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.mock.sample2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.sns.mock.SnsDmSettingMockSample2Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.mock.SnsDmSetteingMockSample2Repository;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.SendSnsDirectMessageInterface;
import mitei.mitei.create.report.balance.politician.util.RecordExceptionUtil;

/**
 * SNSダイレクトメッセージ送信Logi(Mock Sample1)
 */
@Component
public class MockSendSnsDirectMessageSample2Logic implements SendSnsDirectMessageInterface {

    /** Logic識別Id */
    public static final int LOGIC_ID = 2;

    /** 例外記録Utility */
    @Autowired
    private RecordExceptionUtil recordExceptionUtil;

    /** このSNS設定情報 */
    @Autowired
    private SnsDmSetteingMockSample2Repository snsDmSetteingMockSample2Repository;

    /**
     * SNSダイレクトメッセージ送信をおこなう
     */
    @Override
    public SendSnsDirectMessageResultDto practice(final SnsDirectMessageDto directMessageDto) {

        // SNSのダイレクトメッセージ送信ができなかったからと言って、全作業の巻き戻しはしないので、
        // 全力でこのLogicから例外を投げないようにする
        SendSnsDirectMessageResultDto resultDto = new SendSnsDirectMessageResultDto();
        resultDto.setSendAlertSnsMessageId(directMessageDto.getSendAlertSnsMessageId());
        resultDto.setSendAlertSnsMessageCode(directMessageDto.getSendAlertSnsMessageCode());
        
        try {
            // ログインユーザ同一識別コードからSNS登録情報を呼び出す
            Optional<SnsDmSettingMockSample2Entity> optionalSetting = snsDmSetteingMockSample2Repository
                    .findByLoginUserCodeAndSaishinKbn(directMessageDto.getCheckPrivilegeDto().getLoginUserCode(),
                            DataHistoryStatusConstants.INSERT.value());

            // 接続するための情報が記録されていなければ失敗として処理中断
            if(optionalSetting.isEmpty()) {
                resultDto.setIsOk(false);
                return resultDto;
            }

            // TODO ダイレクトメッセージを送信する

        } catch (Exception exception) { // NOPMD 最後は積極的に全キャッチ
            // ログを流す
            recordExceptionUtil.practice(exception);

            // 失敗とする
            resultDto.setIsOk(false);
        }

        // TODO テスト用記述。Mockでない場合は削除する
        resultDto.setIsOk(!directMessageDto.getCheckPrivilegeDto().getIsRaiseExcception());

        return resultDto;
    }

}
