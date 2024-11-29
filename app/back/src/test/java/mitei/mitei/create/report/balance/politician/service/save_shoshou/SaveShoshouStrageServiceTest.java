package mitei.mitei.create.report.balance.politician.service.save_shoshou;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;

/**
 * SaveShoshouStrageService単体テスト
 */
class SaveShoshouStrageServiceTest {
//CHECKSTYLE:OFF
    
    @Test
    @Tag("TableTruncate")
    void test() throws Exception {
        //TODO データベース保存をするようになり、bootが必要になったらテスト方式も変更する

        SaveShoshouStrageService saveShoshouStrageService = new SaveShoshouStrageService();
        final Long userId = 13579L;
        SaveStorageResultDto resultDto = saveShoshouStrageService.practice("aaa.csv", userId);

        assertThat(resultDto.getShoshouCode()).isEqualTo(1009L);// ダミー固定値
        assertThat(resultDto.getShoshouId().startsWith(String.valueOf(userId))).isTrue();

        fail("Not yet implemented");
    }

}
