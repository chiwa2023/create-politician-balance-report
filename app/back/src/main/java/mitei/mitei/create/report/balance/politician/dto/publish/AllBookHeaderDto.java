package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * XMLヘッダ情報を格納するDto
 */
@JacksonXmlRootElement(localName = "HEAD")
public class AllBookHeaderDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** バージョン番号 */
    @JacksonXmlProperty(localName = "VERSION")
    private String version = "20191220";

    /** アプリ名称 */
    @JacksonXmlProperty(localName = "APP")
    private String appName = "収支報告書作成ソフト〔収支報告書作成ソフト〕";

    /** ファイルフォーマット名称 */
    @JacksonXmlProperty(localName = "FILE_FORMAT_NO")
    private String fileFormatNo;

    /** 告示フラグ */
    @JacksonXmlProperty(localName = "KOKUJI_APP_FLG")
    private String flgKokuji;

    /** 帳簿アプリバージョン */
    @JacksonXmlProperty(localName = "CHOUBO_APP_VER")
    private String chouboAppVer = "20150701";

    /**
     * バージョン番号を取得する
     *
     * @return バージョン番号
     */
    public String getVersion() {
        return version;
    }

    /**
     * バージョン番号を設定する
     *
     * @param version バージョン番号
     */
    public void setVersion(final String version) {
        this.version = version;
    }

    /**
     * アプリ名称を取得する
     *
     * @return アプリ名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * アプリ名称を設定する
     *
     * @param appName アプリ名称
     */
    public void setAppName(final String appName) {
        this.appName = appName;
    }

    /**
     * ファイルフォーマット番号を取得する
     *
     * @return ファイルフォーマット番号
     */
    public String getFileFormatNo() {
        return fileFormatNo;
    }

    /**
     * ファイルフォーマット番号を設定する
     *
     * @param fileFormatNo ファイルフォーマット番号
     */
    public void setFileFormatNo(final String fileFormatNo) {
        this.fileFormatNo = fileFormatNo;
    }

    /**
     * 告示フラグを取得する
     *
     * @return 告示フラグ
     */
    public String getFlgKokuji() {
        return flgKokuji;
    }

    /**
     * 告示フラグを設定する
     *
     * @param flgKokuji 告示フラグ
     */
    public void setFlgKokuji(final String flgKokuji) {
        this.flgKokuji = flgKokuji;
    }

    /**
     * 帳簿アプリバージョンを取得する
     *
     * @return 帳簿アプリバージョン
     */
    public String getChouboAppVer() {
        return chouboAppVer;
    }

    /**
     * 帳簿アプリバージョンを設定する
     *
     * @param chouboAppVer 帳簿アプリバージョン
     */
    public void setChouboAppVer(final String chouboAppVer) {
        this.chouboAppVer = chouboAppVer;
    }

}
