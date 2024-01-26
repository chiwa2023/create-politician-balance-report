package mitei.mitei.create.report.balance.politician.trial;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

/**
 * multipartファイルアップロードテスト
 */
@RestController
public class UploadController {

    /**
     * アップロードテスト
     *
     * @param multipartFile 送信されてきたファイル
     * @return 空文字
     * @throws IOException ファイル読み取り不可
     * @throws CsvException csv読み取り例外
     */
    @PostMapping("/upload")
    public ResponseEntity<Object> upload(final @RequestParam("uploaded-file") MultipartFile multipartFile) throws IOException, CsvException {

        try(
                Reader reader = new InputStreamReader(multipartFile.getInputStream());

                CSVReader csvReader = new CSVReader(reader);
                
                ){
            List<String[]> list = csvReader.readAll();

            for (String[] line : list) {
                System.out.println("--------------"); // NOPMD
                for (String cell : line) {
                    System.out.print(cell + ","); // NOPMD
                }
                System.out.println(); // NOPMD
            }
            
        }

        return ResponseEntity.ok().build();
    }
}
