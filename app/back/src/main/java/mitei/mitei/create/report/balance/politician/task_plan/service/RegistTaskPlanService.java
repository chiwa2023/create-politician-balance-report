package mitei.mitei.create.report.balance.politician.task_plan.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.task_plan.RegistTaskPlanResultDto;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.repository.UserWebAccessRepository;
import mitei.mitei.create.report.balance.politician.task_alert.mail.InsertMailInfoFactoryLogic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.InsertSnsDirectMessageSendingInfoFactoryLogic;
import mitei.mitei.create.report.balance.politician.task_plan.logic.InsertTaskPlanFactoryLogic;

/**
 * タスクの新規登録を行う
 */
@Service
public class RegistTaskPlanService {

    /** EntityManager(CriteriaAPI 組み立て用) */
    @Autowired
    private EntityManager entityManager;

    /** メール送信Logic */
    @Autowired
    private InsertMailInfoFactoryLogic insertMailInfoFactoryLogic;

    /** SNSダイレクトメッセージ送信Logic */
    @Autowired
    private InsertSnsDirectMessageSendingInfoFactoryLogic insertSnsDirectMessageSendingInfoFactoryLogic;

    /** タスク計画挿入Logic */
    @Autowired
    private InsertTaskPlanFactoryLogic insertTaskPlanFactoryLogic;

    /** ユーザ所属政治団体リストRepository */
    @Autowired
    private UserWebAccessRepository userWebAccessRepository;

    /** Logger */
    private static final Logger log = LoggerFactory.getLogger(RegistTaskPlanService.class);

    /**
     * タスク計画、タスク通知予定情報を登録する
     *
     * @param privilegeDto 権限確認Dto
     * @param listTask     タスクリスト
     */
    public RegistTaskPlanResultDto practice(final CheckPrivilegeDto privilegeDto,final LocalDateTime datetimeShori,final List<TaskInfoEntity> listTask) {

        if (Objects.isNull(privilegeDto)) {
            throw new IllegalArgumentException("引数CheckPrivilegeDtoがnullです");
        }

        if (Objects.isNull(listTask)) {
            throw new IllegalArgumentException("引数List<TaskInfoEntity>oがnullです");
        }

        // 操作ユーザが操作対象としている政治団体のユーザ情報を取得してループ
        List<UserWebAccessEntity> listUserInPoliOrg = userWebAccessRepository.findselectByPoliOrgCode(entityManager,
                privilegeDto.getPoliticalOrganizationCode());

        // 政治団体同一識別コードはユーザ同一識別コードから取得しているので、ないとおかしい TODO 基本的に例外として処理全体を止める方向で
        UserWebAccessEntity userEntity = listUserInPoliOrg.stream()
                .filter(entity -> entity.getUserCode().equals(privilegeDto.getLoginUserCode())).toList().get(0);

        // 何らかのcsvファイルを開けて仕分け一括処理があって、
        // タスクを持ち越した場合は、タスクが複数になることがあり得るのでタスクは複数(リストで入ってくる)
        // かつ政治団体の個別設定とテンプレート両方を取得してくる

        // タスクを作成
        int sizeTask = insertTaskPlanFactoryLogic.practice(datetimeShori.getYear(), privilegeDto, listTask, listUserInPoliOrg);

        // メール通知予定を作成する
        int sizeMail = insertMailInfoFactoryLogic.practice(privilegeDto, datetimeShori, userEntity, listUserInPoliOrg, listTask);

        // SNS通知予定を作成する
        int sizeSns = insertSnsDirectMessageSendingInfoFactoryLogic.practice(privilegeDto, listUserInPoliOrg, datetimeShori,
                listTask);

        RegistTaskPlanResultDto resultDto = new RegistTaskPlanResultDto();

        // タスクの数とタスク計画に登録した数が一致していれば成功
        if (sizeTask == listTask.size()) {
            resultDto.setIsOk(true);
            resultDto.setSuccessCount(sizeTask);
            resultDto.setFailureCount(0);
        } else {
            resultDto.setIsOk(false);
            resultDto.setSuccessCount(listTask.size() - sizeTask);
            resultDto.setFailureCount(sizeTask);
        }

        // 最悪の最悪はタスク登録がされていればログインすれば気づくはず
        // 代表者に「その話は聞いていない」と言わせないことが主目的であるので通知が届くことにこだわりたい
        // TODO 循環処理となるタスク計画・通知計画処理以外の方法を考える
        // 主業務登録がちゃんとできているにも関わず落とすかは検討中
        int alertSize = listTask.size() * listUserInPoliOrg.size();
        if (sizeMail != alertSize) {
            log.warn("メール通知計画が必要数登録されていません");
        }
        if (sizeSns != alertSize) {
            log.warn("SNSダイレクトメッセージ通知計画が必要数登録されていません");
        }

        return resultDto;
    }

}
