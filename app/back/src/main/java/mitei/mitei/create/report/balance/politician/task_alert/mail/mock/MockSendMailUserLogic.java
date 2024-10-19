package mitei.mitei.create.report.balance.politician.task_alert.mail.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.mail.MailDataDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMailCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMaileResultDto;
import mitei.mitei.create.report.balance.politician.util.RecordExceptionUtil;

/**
 * メール送信Logic(Mock) SNSのDMと併用し、「タスクが発生したのでログインしてね」くらいなので簡易でOKと判断
 * (URLを置いとけばメールリーダでリンクにしてくれるでしょう…)
 */
@Component
public class MockSendMailUserLogic {

    /** spring bootのメールSender */
    @Autowired
    private MailSender mailSender;

    /** 例外記録Utility */
    @Autowired
    private RecordExceptionUtil recordExceptionUtil;

    /**
     * メール送信を行います。 送信完了者と未送信者を分けて処理できるように実装を行います
     *
     * @param mailCapsuleDto メール送信格納Dto
     * @return メール送信結果Dto
     */
    public SendMaileResultDto practice(final SendMailCapsuleDto mailCapsuleDto) {

        // 結果Dtoの準備。仮で送信OK(完了)状態
        SendMaileResultDto resultDto = new SendMaileResultDto();
        resultDto.setIsOk(true);

        // 送信失敗者リスト
        List<MailDataDto> listFailure = new ArrayList<>();

        // 解析するリスト
        List<MailDataDto> listSend = mailCapsuleDto.getListMailData();

        // メール送信失敗は例外で返ってくる
        MailDataDto mailDataDto = new MailDataDto();

        // 複数人送信できるようを配列で一発で渡すこともできるが、○○さんには送れたが
        // ××さんに送れなかったという制御ができないのであえてループで回す
        // メールが送信されなかったことが原因で全作業の巻き戻しはしない(のでtry-catchがloop内にいる)
        int size = listSend.size();
        for (int index = 0; index < size; index++) {
            try {
                // TODO Mockでなくなったら削除する
                if (mailCapsuleDto.getPosFailure().contains(-999)) { // SUPPRESS CHECKSTYLE MagicNumber
                    throw new MailAuthenticationException("認証に失敗しました");
                }

                mailDataDto = listSend.get(index);
                // TODO 環境が替わるたびにて動作テストする。現在smtp4devをテストして動作
                mailSender.send(mailDataDto.getSimpleMailMessage());

                // TODO Mockでなくなったら削除する
                this.mockRaiseException(index, mailCapsuleDto);

            } catch (MailParseException mailParseException) {
                // MailParseException - メッセージの解析中にエラーが発生した場合
                recordExceptionUtil.practice(mailParseException);

                // 失敗とする
                listFailure.add(mailDataDto);
                resultDto.setIsOk(false);

            } catch (MailAuthenticationException mailAuthenticationException) { // NOPMD
                // MailAuthenticationException - 認証に失敗した場合

                // ログを流す
                recordExceptionUtil.practice(mailAuthenticationException);

                // あるユーザまで処理してきて、突然認証できなくなった・・・ということはほぼないと思われるので
                // 大概一人目。全失敗で即中断して処理を抜ける(認証できないののに何回もtryしない)
                resultDto.setIsOk(false);

                // すべての送信予定者を失敗リストに入れる
                for (MailDataDto dataDto : listSend) {
                    listFailure.add(dataDto);
                }
                resultDto.setListFailure(listFailure);
                resultDto.setFailureCount(listFailure.size());
                resultDto.setSuccessCount(0);
                return resultDto;

            } catch (MailSendException mailSendException) { // NOPMD
                // MailSendException - メッセージ送信時に失敗した場合

                // ログを流す
                recordExceptionUtil.practice(mailSendException);

                // 失敗とする
                listFailure.add(mailDataDto);
                resultDto.setIsOk(false);

            } catch (Exception exception) { // NOPMD 業務上の理由で積極的許容

                // ログを流す
                recordExceptionUtil.practice(exception);

                // 失敗とする
                listFailure.add(mailDataDto);
                resultDto.setIsOk(false);
            }

        }

        resultDto.setListFailure(listFailure);
        resultDto.setFailureCount(listFailure.size());
        resultDto.setSuccessCount(listSend.size() - listFailure.size());
        return resultDto;
    }

    /**
     * TODO Mockテスト用コードなので、Mockテスト完了したら消す
     */
    private void mockRaiseException(final int index, final SendMailCapsuleDto mailCapsuleDto)
            throws MailAuthenticationException, MailParseException, MailSendException, Exception { // NOPMD

        if (mailCapsuleDto.getPosFailure().contains(index)) {
            // 失敗リストに追加
            if (1 == index % 3) { // SUPPRESS CHECKSTYLE MagicNumber // NOPMD
                throw new MailParseException("メッセージ作成に失敗しました");
            }
            if (2 == index % 3) { // SUPPRESS CHECKSTYLE MagicNumber // NOPMD
                throw new MailSendException("送信に失敗しました");
            }
            if (0 == index % 3) { // SUPPRESS CHECKSTYLE MagicNumber // NOPMD
                throw new Exception("適当な理由で失敗しました"); // NOPMD
            }
        }

    }
}
