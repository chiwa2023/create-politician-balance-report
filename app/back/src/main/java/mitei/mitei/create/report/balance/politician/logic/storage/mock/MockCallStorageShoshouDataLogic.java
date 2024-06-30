package mitei.mitei.create.report.balance.politician.logic.storage.mock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import mitei.mitei.create.report.balance.politician.constants.GetThisResourcePath;
import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;

/**
 * ストレージ保存されているファイルを呼び出すロジックのMock
 */
public class MockCallStorageShoshouDataLogic {

    /**
     * 特定CSVを呼び出す
     *
     * @return 文字列リスト
     * @throws IOException ファイル読み取り例外
     */
    public String practice(final SaveStorageResultDto saveStorageResultDto)throws IOException {
        //TODO しばらくはサンプルcsvを返すが仕様決定次第修正する
        //csvを返すのでList<String>だが、ファイル形式を混在させるかそれぞれにメソッドを設定するか考慮中
 
        Path path = Paths.get(GetThisResourcePath.getBackTestResourcePath(),"/service/read_csv/read_csv_test.csv");
        
        return Files.readString(path);
    }
    
}
