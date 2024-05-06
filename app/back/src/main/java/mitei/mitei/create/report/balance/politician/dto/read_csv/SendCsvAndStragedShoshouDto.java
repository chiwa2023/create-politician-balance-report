package mitei.mitei.create.report.balance.politician.dto.read_csv;

import java.io.Serializable;
import java.util.List;

import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;

/**
 * csv変換処理を行た結果を伝送するDto
 */
public class SendCsvAndStragedShoshouDto implements Serializable { // NOPMD DataClass

    /** Serial Id */
    private static final long serialVersionUID = 1L;

    /** csvデータ */
    private List<List<CsvCellDto>> listAllCsv;

    /** csv保存処理結果 */
    private SaveStorageResultDto saveStorageResultDto;


    /**
     * csvデータを取得する
     *
     * @return csvデータ
     */
    public List<List<CsvCellDto>> getListAllCsv() {
        return listAllCsv;
    }

    /**
     * csvデータを設定する
     *
     * @param listAllCsv csvデータ
     */
    public void setListAllCsv(final List<List<CsvCellDto>> listAllCsv) {
        this.listAllCsv = listAllCsv;
    }

    /**
     * csv保存処理結果を取得する
     *
     * @return csv保存処理結果
     */
    public SaveStorageResultDto getSaveStorageResultDto() {
        return saveStorageResultDto;
    }

    /**
     * csv保存処理結果を設定する
     *
     * @param saveStorageResultDto csv保存処理結果
     */
    public void setSaveStorageResultDto(final SaveStorageResultDto saveStorageResultDto) {
        this.saveStorageResultDto = saveStorageResultDto;
    }

    
}
