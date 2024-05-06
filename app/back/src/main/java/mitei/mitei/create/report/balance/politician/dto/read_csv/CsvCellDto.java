package mitei.mitei.create.report.balance.politician.dto.read_csv;

import java.io.Serializable;

/**
 * csvセルを表すデータ
 */
public class CsvCellDto implements Serializable {

    /** SerialId　*/
    private static final long serialVersionUID = 1L;

    /** セルデータ */
    private String data;

    /**
     * セルデータを取得する
     *
     * @return セルデータ
     */
    public String getData() {
        return data;
    }

    /**
     * セルデータを設定する
     *
     * @param data セルデータ
     */
    public void setData(final String data) {
        this.data = data;
    }

}
