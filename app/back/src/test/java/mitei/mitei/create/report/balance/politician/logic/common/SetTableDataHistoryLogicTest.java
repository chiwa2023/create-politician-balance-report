package mitei.mitei.create.report.balance.politician.logic.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;


/**
 * SetTableDataHistoryLogic単体テスト
 */
class SetTableDataHistoryLogicTest {
    // CHECKSTYLE:OFF

    /** Long初期値 */
    private final Long INIT_LONG = 0L; // NOPMD

    /** Integer初期値 */
    private final Integer INIT_INTEGER = 0; // NOPMD

    /** String初期値 */
    private final String INIT_STRING = ""; // NOPMD

    /** Timestamp初期値 */
    private final LocalDateTime INIT_TIMESTAMP = LocalDateTime.of(1980, 1, 1, 0, 0, 0);

    @Test
    @Tag("TableTruncate")
    void testPracticeInsert() {

        AllTabeDataHistoryInterfaceForTestEntity dataEntity = new AllTabeDataHistoryInterfaceForTestEntity();

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        final long LOGIN_ID = 123321L;
        final int LOGIN_CODE = 987;
        final String LOGIN_NAME = "ユーザ";

        checkPrivilegeDto.setLoginUserId(LOGIN_ID);
        checkPrivilegeDto.setLoginUserCode(LOGIN_CODE);
        checkPrivilegeDto.setLoginUserName(LOGIN_NAME);

        // 新規挿入時
        SetTableDataHistoryLogic setTableDataHistoryLogic = new SetTableDataHistoryLogic();
        setTableDataHistoryLogic.practice(checkPrivilegeDto, dataEntity, DataHistoryStatusConstants.INSERT);
        
        // データ挿入ユーザId
        assertThat(dataEntity.getInsertUserId()).isEqualTo(checkPrivilegeDto.getLoginUserId());
        // データ挿入ユーザ同一識別コード
        assertThat(dataEntity.getInsertUserCode()).isEqualTo(checkPrivilegeDto.getLoginUserCode());
        // データ挿入ユーザ名称
        assertThat(dataEntity.getInsertUserName()).isEqualTo(checkPrivilegeDto.getLoginUserName());
        // データ挿入時間
        // 実行時には誤差1秒以内におさまっているでしょう…
        assertTrue(dataEntity.getInsertTimestamp().isAfter(LocalDateTime.now().minusMinutes(1L)),""); // NOPMD
        assertTrue(dataEntity.getInsertTimestamp().isAfter(LocalDateTime.now().minusMinutes(1L)),""); // NOPMD

        // データ挿入ユーザId
        assertThat(dataEntity.getUpdateUserId()).isEqualTo(INIT_LONG);
        // データ挿入ユーザ同一識別コード
        assertThat(dataEntity.getUpdateUserCode()).isEqualTo(INIT_INTEGER);
        // データ挿入ユーザ名称
        assertThat(dataEntity.getUpdateUserName()).isEqualTo(INIT_STRING);
        // データ挿入時間
        assertTrue(INIT_TIMESTAMP.compareTo(dataEntity.getUpdateTimestamp()) == 0); // NOPMD
    }

    @Test
    void testPracticeUpdate() {

        AllTabeDataHistoryInterfaceForTestEntity dataEntity = new AllTabeDataHistoryInterfaceForTestEntity();

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        final long LOGIN_ID = 123321L;
        final int LOGIN_CODE = 987;
        final String LOGIN_NAME = "ユーザ";

        checkPrivilegeDto.setLoginUserId(LOGIN_ID);
        checkPrivilegeDto.setLoginUserCode(LOGIN_CODE);
        checkPrivilegeDto.setLoginUserName(LOGIN_NAME);

        // 更新時
        SetTableDataHistoryLogic setTableDataHistoryLogic = new SetTableDataHistoryLogic();
        setTableDataHistoryLogic.practice(checkPrivilegeDto, dataEntity, DataHistoryStatusConstants.UPDATE);

        // データ挿入ユーザId
        assertThat(dataEntity.getUpdateUserId()).isEqualTo(checkPrivilegeDto.getLoginUserId());
        // データ挿入ユーザ同一識別コード
        assertThat(dataEntity.getUpdateUserCode()).isEqualTo(checkPrivilegeDto.getLoginUserCode());
        // データ挿入ユーザ名称
        assertThat(dataEntity.getUpdateUserName()).isEqualTo(checkPrivilegeDto.getLoginUserName());
        // データ挿入時間
        // 実行時には誤差1秒以内におさまっているでしょう…
        assertTrue(dataEntity.getUpdateTimestamp().isAfter(LocalDateTime.now().minusMinutes(1L)),""); // NOPMD
        assertTrue(dataEntity.getUpdateTimestamp().isAfter(LocalDateTime.now().minusMinutes(1L)),""); // NOPMD

        // データ挿入ユーザId
        assertThat(dataEntity.getInsertUserId()).isEqualTo(INIT_LONG);
        // データ挿入ユーザ同一識別コード
        assertThat(dataEntity.getInsertUserCode()).isEqualTo(INIT_INTEGER);
        // データ挿入ユーザ名称
        assertThat(dataEntity.getInsertUserName()).isEqualTo(INIT_STRING);
        // データ挿入時間
        assertTrue(INIT_TIMESTAMP.compareTo(dataEntity.getInsertTimestamp()) == 0); // NOPMD
    }

}
