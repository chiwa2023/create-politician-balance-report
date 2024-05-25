package mitei.mitei.create.report.balance.politician.zz_address2_support.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;



/**
 * zz_address2_block接続用Entity
 */
@Entity
@Table(name = "zz_address2_block")
public class ZzAddress2BlockEntity  implements Serializable{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;

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

    /** 選択肢の値(コード全結合) */
    private String value = INIT_String;

    /**
     * 選択肢の値(コード全結合)を取得する
     *
     * @return 選択肢の値(コード全結合)
     */
    public String getValue() {
        return value;
    }

    /**
     * 選択肢の値(コード全結合)を設定する
     *
     * @param value 選択肢の値(コード全結合)
     */
    public void setValue(final String value) {
        this.value = value;
    }

    /** 全住所 */
    private String allAddress = INIT_String;

    /**
     * 全住所を取得する
     *
     * @return 全住所
     */
    public String getAllAddress() {
        return allAddress;
    }

    /**
     * 全住所を設定する
     *
     * @param allAddress 全住所
     */
    public void setAllAddress(final String allAddress) {
        this.allAddress = allAddress;
    }

    /** 選択肢の表示(番地部分) */
    private String text = INIT_String;

    /**
     * 選択肢の表示(番地部分)を取得する
     *
     * @return 選択肢の表示(番地部分)
     */
    public String getText() {
        return text;
    }

    /**
     * 選択肢の表示(番地部分)を設定する
     *
     * @param text 選択肢の表示(番地部分)
     */
    public void setText(final String text) {
        this.text = text;
    }

    /** 丁目の数字 */
    private Integer choume = INIT_Integer;

    /**
     * 丁目の数字を取得する
     *
     * @return 丁目の数字
     */
    public Integer getChoume() {
        return choume;
    }

    /**
     * 丁目の数字を設定する
     *
     * @param choume 丁目の数字
     */
    public void setChoume(final Integer choume) {
        this.choume = choume;
    }

    /** ブロックの数字1 */
    private Integer prc1 = INIT_Integer;

    /**
     * ブロックの数字1を取得する
     *
     * @return ブロックの数字1
     */
    public Integer getPrc1() {
        return prc1;
    }

    /**
     * ブロックの数字1を設定する
     *
     * @param prc1 ブロックの数字1
     */
    public void setPrc1(final Integer prc1) {
        this.prc1 = prc1;
    }

    /** ブロックの数字2 */
    private Integer prc2 = INIT_Integer;

    /**
     * ブロックの数字2を取得する
     *
     * @return ブロックの数字2
     */
    public Integer getPrc2() {
        return prc2;
    }

    /**
     * ブロックの数字2を設定する
     *
     * @param prc2 ブロックの数字2
     */
    public void setPrc2(final Integer prc2) {
        this.prc2 = prc2;
    }

    /** ブロックの数字3 */
    private Integer prc3 = INIT_Integer;

    /**
     * ブロックの数字3を取得する
     *
     * @return ブロックの数字3
     */
    public Integer getPrc3() {
        return prc3;
    }

    /**
     * ブロックの数字3を設定する
     *
     * @param prc3 ブロックの数字3
     */
    public void setPrc3(final Integer prc3) {
        this.prc3 = prc3;
    }
    
    /** 郵便番号 */
    private String postalCode = INIT_String;

    /**
     * 郵便番号を取得する
     *
     * @return 郵便番号
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 郵便番号を設定する
     *
     * @param postalCode 郵便番号
     */
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    
}
