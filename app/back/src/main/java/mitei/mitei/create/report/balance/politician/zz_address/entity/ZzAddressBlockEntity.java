package mitei.mitei.create.report.balance.politician.zz_address.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import mitei.mitei.create.report.balance.politician.dto.SelectOptionInterface;

/**
 * zz_address_block接続用Entity
 */
@Entity
@Table(name = "zz_address_block")
public class ZzAddressBlockEntity implements Serializable,SelectOptionInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";
    
    /** 初期データ(Long) */
    private static final Long INIT_Long = 0L;

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = INIT_Long; // NOPMD

    /** lgCode */
    private String lgCode = INIT_String;

    /**
     * getLgを取得する
     *
     * @return getLg 
     */
    public String getLgCode() {
        return lgCode;
    }

    /**
     * lgCodeを設定する
     *
     * @param lgCode lgCode
     */
    public void setLgCode(final String lgCode) {
        this.lgCode = lgCode;
    }

    /** machiazaId */
    private String machiazaId = INIT_String;

    /**
     * machiazaIdを取得する
     *
     * @return machiazaId
     */
    public String getMachiazaId() {
        return machiazaId;
    }

    /**
     * machiazaIdを設定する
     *
     * @param machiazaId machiazaId
     */
    public void setMachiazaId(final String machiazaId) {
        this.machiazaId = machiazaId;
    }

    /** value */
    private String value = INIT_String;


    /** postalCode */
    private String postalCode = INIT_String;
    
    /** nameAll */
    private String nameAll = INIT_String;

    /**
     * nameAllを取得する
     *
     * @return nameAll
     */
    public String getNameAll() {
        return nameAll;
    }

    /**
     * nameAllを設定する
     *
     * @param nameAll nameAll
     */
    public void setNameAll(final String nameAll) {
        this.nameAll = nameAll;
    }

    /** text */
    private String text = INIT_String;


    /**
     * idを取得する
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * idを設定する
     *
     * @param id id
     */
    public void setId(final Long id) { // NOPMD
        this.id = id;
    }

    /**
     * 郵便番号を取得する
     *
     * @return 郵便番号
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *  郵便番号を設定する
     *
     * @param postalCode 郵便番号
     */
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     *
     */
    @Override
    public void setValue(final String value) {
        this.value = value;
    }

    /**
     *
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     *
     */
    @Override
    public void setText(final String text) {
        this.text = text;
    }

}
