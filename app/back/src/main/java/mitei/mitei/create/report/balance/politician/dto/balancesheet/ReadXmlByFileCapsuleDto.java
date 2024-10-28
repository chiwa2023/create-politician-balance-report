package mitei.mitei.create.report.balance.politician.dto.balancesheet;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;

/**
 * アップロードされたcsv内容格納Dto
 */
public class ReadXmlByFileCapsuleDto extends TemplateFrameworkCapsuleDto implements Serializable { // NOPMD DataClass

    /** Serial Id */
    private static final long serialVersionUID = 1L;

    /** ファイル名 */
    private String fileName;

    /** csvファイル内容 */
    private String fileContent;

    /**
     * ファイル名を取得する
     *
     * @return ファイル名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * ファイル名を設定する
     *
     * @param fileName ファイル名
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * csvファイル内容ファイル名を取得する
     *
     * @return csvファイル内容
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * csvファイル内容を設定する
     *
     * @param fileContent csvファイル内容
     */
    public void setFileContent(final String fileContent) {
        this.fileContent = fileContent;
    }

}
