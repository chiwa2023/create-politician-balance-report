package mitei.mitei.create.report.balance.politician.service.read_csv;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;

/**
 * ReadCsvReadByFileService単体テスト
 */
class ReadCsvReadByFileServiceTest {
// CHECKSTYLE:OFF
    
    @Test
    @Tag("TableTruncate")
    void test() throws Exception {

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "service/read_csv/read_csv_test.csv");
        String fileContent = Files.readString(path);

        ReadCsvReadByFileService ReadCsvReadByFileService = new ReadCsvReadByFileService();
        List<List<CsvCellDto>> list = ReadCsvReadByFileService.practice(fileContent);

        // 7行取得
        assertThat(list.size()).isEqualTo(7);

        // ヘッダ行は最大の7列
        List<CsvCellDto> listLine = list.get(0);
        assertThat(listLine.size()).isEqualTo(7);
        assertThat(listLine.get(0).getData()).isEqualTo("年月日");
        assertThat(listLine.get(1).getData()).isEqualTo("お引出し");
        assertThat(listLine.get(2).getData()).isEqualTo("お預入れ");
        assertThat(listLine.get(3).getData()).isEqualTo("お取り扱い内容");
        assertThat(listLine.get(4).getData()).isEqualTo("残高");
        assertThat(listLine.get(5).getData()).isEqualTo("メモ");
        assertThat(listLine.get(6).getData()).isEqualTo("ラベル");

        // 3行は5列だが7列に補正されている
        listLine = list.get(3);
        assertThat(listLine.size()).isEqualTo(7);
        assertThat(listLine.get(0).getData()).isEqualTo("2022/12/27");
        assertThat(listLine.get(1).getData()).isEqualTo("12345");
        assertThat(listLine.get(2).getData()).isEqualTo("");
        assertThat(listLine.get(3).getData()).isEqualTo("ﾌﾘｶｴ ｼｭﾄｹﾝﾃﾞﾝｷ");
        assertThat(listLine.get(4).getData()).isEqualTo("997");
        assertThat(listLine.get(5).getData()).isEqualTo("");
        assertThat(listLine.get(6).getData()).isEqualTo("");
    }

}
