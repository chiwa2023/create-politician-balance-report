package mitei.mitei.create.report.balance.politician.dto.balancesheet;

import java.io.Serializable;
import java.util.List;

import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;

/**
 * 政治資金収支報告書支出・収入項目リスト作成用情報リスト
 */
public class CreateBalancesheetInOutDataCapsuleDto extends TemplateFrameworkCapsuleDto implements Serializable { // NOPMD DataClass

    /** Serial Id */
    private static final long serialVersionUID = 1L;

    /** ストレージ保存した書証 */
    private SaveStorageResultDto saveStorageResultDto;

    /** csvリスト */
    private List<List<CsvCellDto>> listCsvData;

    /** csv読み取り組み合わせ配列 */
    private String[] listPointer;

    /**
     * ストレージ保存した書証を取得する
     *
     * @return ストレージ保存した書証
     */
    public SaveStorageResultDto getSaveStorageResultDto() {
        return saveStorageResultDto;
    }

    /**
     * ストレージ保存した書証を設定する
     *
     * @param saveStorageResultDto ストレージ保存した書証
     */
    public void setSaveStorageResultDto(final SaveStorageResultDto saveStorageResultDto) {
        this.saveStorageResultDto = saveStorageResultDto;
    }

    /**
     * csvリストを取得する
     *
     * @return csvリスト
     */
    public List<List<CsvCellDto>> getListCsvData() {
        return listCsvData;
    }

    /**
     * csvリストを設定する
     *
     * @param listCsvData csvリスト
     */
    public void setListCsvData(final List<List<CsvCellDto>> listCsvData) {
        this.listCsvData = listCsvData;
    }

    /**
     * csv読み取り組み合わせ配列を取得する
     *
     * @return csv読み取り組み合わせ配列
     */
    public String[] getListPointer() {
        return listPointer; // NOPMD
    }

    /**
     * csv読み取り組み合わせ配列を設定する
     *
     * @param listPointer csv読み取り組み合わせ配列
     */
    public void setListPointer(final String[] listPointer) { // NOPMD
        this.listPointer = listPointer; // NOPMD
    }
    
}
