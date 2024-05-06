package mitei.mitei.create.report.balance.politician.service.read_csv;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;

/**
 * ファイルから読み込みしたテキストからCSV形式に変換するContoller
 */
@Service
public class ReadCsvReadByFileService {

    /**
     * 文字列からCSV形式のデータに変換する
     *
     * @param fileContent csvファイル全体を一つの文字列に変換した
     * @return CSＶセルの二次元配列
     * @throws IOException  ファイル読み取り失敗(今回は関係ない)
     * @throws CsvException 変換の例外
     */
    public List<List<CsvCellDto>> practice(final String fileContent) throws IOException, CsvException {

        List<List<CsvCellDto>> listAll = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new StringReader(fileContent));

        ) {

            List<String[]> listSrc = csvReader.readAll();
            int max = 0;
            // 最大cell数を算出する(ヘッダなしで1行目が最大列でない場合を想定)
            for (String[] c : listSrc) {
                if (max < c.length) {
                    max = c.length;
                }
            }

            List<CsvCellDto> listLine;
            CsvCellDto csvCellDto;
            for (String[] line : listSrc) {
                listLine = new ArrayList<>(); // NOPMD
                int lineMax = line.length;
                // データ挿入
                for (int i = 0; i < lineMax; i++) {
                    csvCellDto = new CsvCellDto(); // NOPMD
                    csvCellDto.setData(line[i]);
                    listLine.add(csvCellDto);
                }
                // 列が足りない場合の補填
                for (int j = lineMax; j < max; j++) {
                    csvCellDto = new CsvCellDto(); // NOPMD
                    csvCellDto.setData("");// 初期値
                    listLine.add(csvCellDto);
                }
                // 全体リストに行リストを追加
                listAll.add(listLine);
            }
        }

        return listAll;
    }
}
