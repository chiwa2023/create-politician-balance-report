package mitei.mitei.create.report.balance.politician.task_plan.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.user.KengenKbnWorksConstants;
import mitei.mitei.create.report.balance.politician.dto.user.YakushokuKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;

/**
 * PickupRelatedUserListByTaskKengenLogic単体テスト
 */
class PickupRelatedUserListByTaskKengenLogicTest {
    // CHECKSTYLE:OFF

    @Test
    void testPractice() { // NOPMD

        PickupRelatedUserListByTaskKengenLogic pickupRelatedUserListByTaskKengenLogic = new PickupRelatedUserListByTaskKengenLogic();

        // 引数nullは許容しない(実装ミス)
        assertThrows(IllegalArgumentException.class,
                () -> pickupRelatedUserListByTaskKengenLogic.practice(null, new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> pickupRelatedUserListByTaskKengenLogic.practice(100, null));

        List<UserWebAccessEntity> list = new ArrayList<>();

        // 空リストのときは空リストが返却
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(80, list))
                .isEqualTo(new ArrayList<>());

        // 代表者の場合
        List<UserWebAccessEntity> list01 = new ArrayList<>();
        UserWebAccessEntity entity01 = new UserWebAccessEntity();
        entity01.setKengenKbn(YakushokuKbnConstants.DELEGATE.value());
        entity01.setUserCode(111);
        list01.add(entity01);

        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.DELEGATE_ONLY, list01).size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.ACCOUNT_MANAGER_ONLY, list01).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.OFFICER_ONLY, list01)
                .size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.WORKER_ONLY, list01)
                .size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.MANAGER_UNDER, list01).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.OFFICER_UNDER, list01).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.MANAGER_OVER, list01)
                .size()).isEqualTo(1);

        // 会計責任者の場合
        List<UserWebAccessEntity> list02 = new ArrayList<>();
        UserWebAccessEntity entity02 = new UserWebAccessEntity();
        entity02.setKengenKbn(YakushokuKbnConstants.ACCOUNT_MANAGER.value());
        entity02.setUserCode(222);
        list02.add(entity02);

        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.DELEGATE_ONLY, list02).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.ACCOUNT_MANAGER_ONLY, list02).size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.OFFICER_ONLY, list02)
                .size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.WORKER_ONLY, list02)
                .size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.MANAGER_UNDER, list02).size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.OFFICER_UNDER, list02).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.MANAGER_OVER, list02)
                .size()).isEqualTo(1);

        // 事務担当者の場合
        List<UserWebAccessEntity> list03 = new ArrayList<>();
        UserWebAccessEntity entity03 = new UserWebAccessEntity();
        entity03.setKengenKbn(YakushokuKbnConstants.OFFICER.value());
        entity03.setUserCode(333);
        list03.add(entity03);

        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.DELEGATE_ONLY, list03).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.ACCOUNT_MANAGER_ONLY, list03).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.OFFICER_ONLY, list03)
                .size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.WORKER_ONLY, list03)
                .size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.MANAGER_UNDER, list03).size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.OFFICER_UNDER, list03).size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.MANAGER_OVER, list03)
                .size()).isEqualTo(0);

        // 一般作業員の場合
        List<UserWebAccessEntity> list04 = new ArrayList<>();
        UserWebAccessEntity entity04 = new UserWebAccessEntity();
        entity04.setKengenKbn(YakushokuKbnConstants.WORKER.value());
        entity04.setUserCode(444);
        list04.add(entity04);

        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.DELEGATE_ONLY, list04).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.ACCOUNT_MANAGER_ONLY, list04).size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.OFFICER_ONLY, list04)
                .size()).isEqualTo(0);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.WORKER_ONLY, list04)
                .size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.MANAGER_UNDER, list04).size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.OFFICER_UNDER, list04).size()).isEqualTo(1);
        assertThat(pickupRelatedUserListByTaskKengenLogic.practice(KengenKbnWorksConstants.MANAGER_OVER, list04)
                .size()).isEqualTo(0);

        List<UserWebAccessEntity> list10 = new ArrayList<>();
        list10.add(entity01);
        list10.add(entity02);
        list10.add(entity03);
        list10.add(entity04);

        // 複合条件では複合リストが戻る
        List<UserWebAccessEntity> listAns11 = pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.MANAGER_UNDER, list10);
        Map<Integer, UserWebAccessEntity> map11 = this.convertMap(listAns11);
        assertFalse(map11.containsKey(entity01.getUserCode()), "代表者は含まれない");
        assertTrue(map11.containsKey(entity02.getUserCode()), "会計責任者は含まれる");
        assertTrue(map11.containsKey(entity03.getUserCode()), "事務担当者は含まれる");
        assertTrue(map11.containsKey(entity04.getUserCode()), "作業者は含まれる");
        assertThat(map11.size()).isEqualTo(3);

        List<UserWebAccessEntity> listAns12 = pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.OFFICER_UNDER, list10);
        Map<Integer, UserWebAccessEntity> map12 = this.convertMap(listAns12);
        assertFalse(map12.containsKey(entity01.getUserCode()), "代表者は含まれない");
        assertFalse(map12.containsKey(entity02.getUserCode()), "会計責任者は含まれない");
        assertTrue(map12.containsKey(entity03.getUserCode()), "事務担当者は含まれる");
        assertTrue(map12.containsKey(entity04.getUserCode()), "作業者は含まれる");
        assertThat(map12.size()).isEqualTo(2);

        List<UserWebAccessEntity> listAns13 = pickupRelatedUserListByTaskKengenLogic
                .practice(KengenKbnWorksConstants.MANAGER_OVER, list10);
        Map<Integer, UserWebAccessEntity> map13 = this.convertMap(listAns13);
        assertTrue(map13.containsKey(entity01.getUserCode()), "代表者は含まれる");
        assertTrue(map13.containsKey(entity02.getUserCode()), "会計責任者は含まれる");
        assertFalse(map13.containsKey(entity03.getUserCode()), "事務担当者は含まれない");
        assertFalse(map13.containsKey(entity04.getUserCode()), "作業者は含まれない");
        assertThat(map13.size()).isEqualTo(2);

    }

    @Test
    void testPracticeString() throws Exception {

        PickupRelatedUserListByTaskKengenLogic pickupRelatedUserListByTaskKengenLogic = new PickupRelatedUserListByTaskKengenLogic();

        // 引数nullは許容しない(実装ミス)
        assertThrows(IllegalArgumentException.class, () -> pickupRelatedUserListByTaskKengenLogic.practiceString(null,
                new ArrayList<>()));
        assertThrows(IllegalArgumentException.class,
                () -> pickupRelatedUserListByTaskKengenLogic.practiceString(100, null));

        List<UserWebAccessEntity> list = new ArrayList<>();

        // 空リストのときは空文字が返却
        assertThat(pickupRelatedUserListByTaskKengenLogic.practiceString(80, list)).isEqualTo("");

        // 該当ユーザがハイフン連結される

        // 一般作業員1件の場合
        List<UserWebAccessEntity> list04 = new ArrayList<>();
        UserWebAccessEntity entity04 = new UserWebAccessEntity();
        entity04.setKengenKbn(YakushokuKbnConstants.WORKER.value());
        entity04.setUserCode(444);
        list04.add(entity04);

        assertThat(pickupRelatedUserListByTaskKengenLogic.practiceString(KengenKbnWorksConstants.WORKER_ONLY,
                list04)).isEqualTo("444");

        List<UserWebAccessEntity> list10 = new ArrayList<>();
        UserWebAccessEntity entity01 = new UserWebAccessEntity();
        entity01.setKengenKbn(YakushokuKbnConstants.DELEGATE.value());
        entity01.setUserCode(111);
        list10.add(entity01);
        UserWebAccessEntity entity02 = new UserWebAccessEntity();
        entity02.setKengenKbn(YakushokuKbnConstants.ACCOUNT_MANAGER.value());
        entity02.setUserCode(222);
        list10.add(entity02);
        UserWebAccessEntity entity03 = new UserWebAccessEntity();
        entity03.setKengenKbn(YakushokuKbnConstants.OFFICER.value());
        entity03.setUserCode(333);
        list10.add(entity03);
        list10.add(entity04);

        // 複合条件では連結された文字列が戻る
        assertThat(pickupRelatedUserListByTaskKengenLogic.practiceString(KengenKbnWorksConstants.MANAGER_UNDER,
                list10)).isEqualTo("222-333-444");

    }

    private Map<Integer, UserWebAccessEntity> convertMap(final List<UserWebAccessEntity> list) {
        Map<Integer, UserWebAccessEntity> map = new HashMap<>();

        for (UserWebAccessEntity entity : list) {
            map.put(entity.getUserCode(), entity);
        }

        return map;
    }
}
