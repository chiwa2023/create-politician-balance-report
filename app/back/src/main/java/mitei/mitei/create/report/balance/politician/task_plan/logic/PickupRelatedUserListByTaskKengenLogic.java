package mitei.mitei.create.report.balance.politician.task_plan.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.user.KengenKbnWorksConstants;
import mitei.mitei.create.report.balance.politician.dto.user.YakushokuKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;

/**
 * タスクに登録された権限リストから関連するユーザを抽出する
 * 機能はただのフィルタだが、定数が絡んでいるのと、運用すると種類が増えてそうなので、Logicに切り出した
 */
@Component
public class PickupRelatedUserListByTaskKengenLogic {

    /** ユーザ連結区切り記号 */
    private static final String SPLITER = "-";

    /** 代表者専用 */
    private static final List<Integer> listDelegate = new ArrayList<>();

    /** 会計責任者専用 */
    private static final List<Integer> listManager = new ArrayList<>();

    /** 事務担当者専用 */
    private static final List<Integer> listOfficer = new ArrayList<>();

    /** 一般作業員専用 */
    private static final List<Integer> listWorker = new ArrayList<>();

    /** 会計責任者以下 */
    private static final List<Integer> listManagerUnder = new ArrayList<>();

    /** 事務担当者以下 */
    private static final List<Integer> listOfficerUnder = new ArrayList<>();

    /** 会計責任者以上 */
    private static final List<Integer> listManagerOver = new ArrayList<>();

    /** 代表者値 */
    private static final int DELEGATE_STATE = YakushokuKbnConstants.DELEGATE.value();

    /** 会計責任者値 */
    private static final int ACCOUNT_MANAGER_STATE = YakushokuKbnConstants.ACCOUNT_MANAGER.value();

    /** 事務担当者値 */
    private static final int OFFICER_STATE = YakushokuKbnConstants.OFFICER.value();

    /** 一般作業員値 */
    private static final int WORKER_STATE = YakushokuKbnConstants.WORKER.value();

    /** 代表者値 */
    private static final int DELEGATE_ONLY = KengenKbnWorksConstants.DELEGATE_ONLY;

    /** 会計責任者値 */
    private static final int ACCOUNT_MANAGER_ONLY = KengenKbnWorksConstants.ACCOUNT_MANAGER_ONLY;

    /** 事務担当者値 */
    private static final int OFFICER_ONLY = KengenKbnWorksConstants.OFFICER_ONLY;

    /** 一般作業員値 */
    private static final int WORKER_ONLY = KengenKbnWorksConstants.WORKER_ONLY;

    /** 会計責任者以下 */
    private static final int MANAGER_UNDER = KengenKbnWorksConstants.MANAGER_UNDER;

    /** 事務担当者以下 */
    private static final int OFFICER_UNDER = KengenKbnWorksConstants.OFFICER_UNDER;

    /** 会計責任者以上 */
    private static final int MANAGER_OVER = KengenKbnWorksConstants.MANAGER_OVER;

    /**
     * コンストラクタ
     */
    public PickupRelatedUserListByTaskKengenLogic() {

        // 代表者専用
        listDelegate.add(DELEGATE_STATE);

        // 会計責任者専用
        listManager.add(ACCOUNT_MANAGER_STATE);

        // 事務担当者専用
        listOfficer.add(OFFICER_STATE);

        // 一般作業員専用
        listWorker.add(WORKER_STATE);

        // 会計責任者以下
        listManagerUnder.add(ACCOUNT_MANAGER_STATE);
        listManagerUnder.add(OFFICER_STATE);
        listManagerUnder.add(WORKER_STATE);

        // 事務担当者以下
        listOfficerUnder.add(OFFICER_STATE);
        listOfficerUnder.add(WORKER_STATE);

        // 会計責任者以上
        listManagerOver.add(ACCOUNT_MANAGER_STATE);
        listManagerOver.add(DELEGATE_STATE);

    }

    /**
     * タスクに紐づく権限区分でフィルタして、Entityリストを返却する
     *
     * @param kengenKbn 権限区分
     * @param listUser  ユーザリスト
     * @return 区分でフィルタ後のリスト
     * @throws IllegalArgumentException 引数nullは許容しないので例外
     */
    public List<UserWebAccessEntity> practice(final Integer kengenKbn, final List<UserWebAccessEntity> listUser)
            throws IllegalArgumentException { // NOPMD

        // 実装ミスを検出
        if (Objects.isNull(kengenKbn)) {
            throw new IllegalArgumentException("kengenKbnがnullです");
        }
        if (Objects.isNull(listUser)) {
            throw new IllegalArgumentException("listUserがnullです");
        }

        List<UserWebAccessEntity> list = new ArrayList<>();

        for (UserWebAccessEntity entity : listUser) {
            switch (kengenKbn) {

                // 代表者専用
                case DELEGATE_ONLY:
                    if (listDelegate.contains(entity.getKengenKbn())) {
                        list.add(entity);
                    }

                    break;
                case ACCOUNT_MANAGER_ONLY:
                    if (listManager.contains(entity.getKengenKbn())) {
                        list.add(entity);
                    }

                    break;

                case OFFICER_ONLY:
                    if (listOfficer.contains(entity.getKengenKbn())) {
                        list.add(entity);
                    }

                    break;

                case WORKER_ONLY:
                    if (listWorker.contains(entity.getKengenKbn())) {
                        list.add(entity);
                    }

                    break;

                case MANAGER_UNDER:
                    if (listManagerUnder.contains(entity.getKengenKbn())) {
                        list.add(entity);
                    }

                    break;

                case OFFICER_UNDER:
                    if (listOfficerUnder.contains(entity.getKengenKbn())) {
                        list.add(entity);
                    }

                    break;

                case MANAGER_OVER:
                    if (listManagerOver.contains(entity.getKengenKbn())) {
                        list.add(entity);
                    }

                    break;

                default:
                    throw new IllegalArgumentException("Unexpected value: " + kengenKbn);
            }

        }

        return list;

    }

    /**
     * タスクに紐づく権限区分でフィルタして、該当者のハイフン連結文字列を返却する
     *
     * @param kengenKbn 権限区分
     * @param listUser  ユーザリスト
     * @return ユーザ同一識別コードを連結した文字列
     * @throws IllegalArgumentException 引数nullは許容しないので例外
     */
    public String practiceString(final Integer kengenKbn, final List<UserWebAccessEntity> listUser)
            throws IllegalArgumentException { // NOPMD

        List<UserWebAccessEntity> list = this.practice(kengenKbn, listUser);

        StringBuilder builder = new StringBuilder();

        for (UserWebAccessEntity entity : list) {
            builder.append(entity.getUserCode()).append(SPLITER);
        }

        // 該当が1件でもあって連結すると最後は区切り文字で終わるので除去
        String text = builder.toString();
        final int noJointTextLength = 1;
        if (noJointTextLength < text.length()) { 
            text = text.substring(0, text.length() - 1);
        }

        return text;
    }

}
