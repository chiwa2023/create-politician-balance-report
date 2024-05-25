package mitei.mitei.create.report.balance.politician.zz_address.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * zz_address_postal接続用Entity
 */
@Entity
@Table(name = "zz_address_postal")
public class ZzAddressPostalEntity  implements Serializable{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";

    /** id */
    @Id
    private String postalcode = INIT_String;

    /**
     * idを取得する
     *
     * @return id
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * idを設定する
     *
     * @param postalcode id
     */
    public void setPostalcode(final String postalcode) {
        this.postalcode = postalcode;
    }

    /** 住所名称 */
    private String addressName = INIT_String;

    /**
     * 住所名称を取得する
     *
     * @return 住所名称
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * 住所名称を設定する
     *
     * @param addressName 住所名称
     */
    public void setAddressName(final String addressName) {
        this.addressName = addressName;
    }

}
