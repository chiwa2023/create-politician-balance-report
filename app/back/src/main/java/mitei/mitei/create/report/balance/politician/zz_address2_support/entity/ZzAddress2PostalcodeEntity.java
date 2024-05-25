package mitei.mitei.create.report.balance.politician.zz_address2_support.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

/**
 * zz_address2_postalcode接続用Entity
 */
@Entity
@Table(name = "zz_address2_postalcode")
public class ZzAddress2PostalcodeEntity  implements Serializable{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;

    /** 初期データ(Boolean) */
    private static final Boolean INIT_Boolean = false;

    /** id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = INIT_Integer; // NOPMD

    /**
     * idを取得する
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * idを設定する
     *
     * @param id id
     */
    public void setId(final Integer id) { // NOPMD
        this.id = id;
    }

    /** 郵便番号 */
    private String postalcode = INIT_String;

    /**
     * 郵便番号を取得する
     *
     * @return 郵便番号
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * 郵便番号を設定する
     *
     * @param postalcode 郵便番号
     */
    public void setPostalcode(final String postalcode) {
        this.postalcode = postalcode;
    }

    /** 住所 */
    private String addressName = INIT_String;

    /**
     * 住所を取得する
     *
     * @return 住所
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * 住所を設定する
     *
     * @param addressName 住所
     */
    public void setAddressName(final String addressName) {
        this.addressName = addressName;
    }

    /** 丁目表記有無 */
    private Boolean isChoume = INIT_Boolean;

    /**
     * 丁目表記有無を取得する
     *
     * @return 丁目表記有無
     */
    public Boolean getIsChoume() {
        return isChoume;
    }

    /**
     * 丁目表記有無を設定する
     *
     * @param isChoume 丁目表記有無
     */
    public void setIsChoume(final Boolean isChoume) {
        this.isChoume = isChoume;
    }

    /** 番地表記有無 */
    private Boolean isPrc1 = INIT_Boolean;

    /**
     * 番地表記有無を取得する
     *
     * @return 番地表記有無
     */
    public Boolean getIsPrc1() {
        return isPrc1;
    }

    /**
     * 番地表記有無を設定する
     *
     * @param isPrc1 番地表記有無
     */
    public void setIsPrc1(final Boolean isPrc1) {
        this.isPrc1 = isPrc1;
    }

    /** 号表記有無 */
    private Boolean isPrc2 = INIT_Boolean;

    /**
     * 号表記有無を取得する
     *
     * @return 号表記有無
     */
    public Boolean getIsPrc2() {
        return isPrc2;
    }

    /**
     * 号表記有無を設定する
     *
     * @param isPrc2 号表記有無
     */
    public void setIsPrc2(final Boolean isPrc2) {
        this.isPrc2 = isPrc2;
    }

    /** 号表記有無2 */
    private Boolean isPrc3 = INIT_Boolean;

    /**
     * 号表記有無2を取得する
     *
     * @return 号表記有無2
     */
    public Boolean getIsPrc3() {
        return isPrc3;
    }

    /**
     * 号表記有無2を設定する
     *
     * @param isPrc3 号表記有無2
     */
    public void setIsPrc3(final Boolean isPrc3) {
        this.isPrc3 = isPrc3;
    }

    /** 注釈部分 */
    private String namePlus = INIT_String;

    /**
     * 注釈部分を取得する
     *
     * @return 注釈部分
     */
    public String getNamePlus() {
        return namePlus;
    }

    /**
     * 注釈部分を設定する
     *
     * @param namePlus 注釈部分
     */
    public void setNamePlus(final String namePlus) {
        this.namePlus = namePlus;
    }

}
