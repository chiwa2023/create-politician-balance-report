package mitei.mitei.create.report.balance.politician.dto.institution_csv;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;

/**
 * csv読み取り仕様テーブルDto
 */
public class CsvReadTemplateCapsuleDto extends TemplateFrameworkCapsuleDto implements Serializable{ // NOPMD DataClass

    /** Serial Id  */
    private static final long serialVersionUID = 1L;

    /** 読み取りcsv桁数  */
    private Integer arrayNumber;

    /**
     * 読み取りcsv桁数を取得する
     *
     * @return 読み取りcsv桁数
     */
    public Integer getArrayNumber() {
        return arrayNumber;
    }

    /**
     * 読み取りcsv桁数を設定する
     *
     * @param arrayNumber 読み取りcsv桁数
     */
    public void setArrayNumber(final Integer arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

}
