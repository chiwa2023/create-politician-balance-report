package mitei.mitei.create.report.balance.politician.zz_address2_support.entity;

import java.util.List;

/**
 * 郵便番号と紐づく番地リスト
 */
public class PostalAddressBlockDto { // NOPMD DataClass

    /** 郵便番号リスト */
    private List<ZzAddress2PostalcodeEntity> listPostalcode;
    
    /** 番地リスト */
    private List<ZzAddress2BlockEntity> listBlock;

    /**
     * 郵便番号リスト取得する
     *
     * @return 郵便番号リスト
     */
    public List<ZzAddress2PostalcodeEntity> getListPostalcode() {
        return listPostalcode;
    }

    /**
     * 郵便番号リスト設定する
     *
     * @param listPostalcode 郵便番号リスト
     */
    public void setListPostalcode(final List<ZzAddress2PostalcodeEntity> listPostalcode) {
        this.listPostalcode = listPostalcode;
    }

    /**
     * 番地リスト取得する
     *
     * @return 番地リスト
     */
    public List<ZzAddress2BlockEntity> getListBlock() {
        return listBlock;
    }

    /**
     * 番地リスト設定する
     *
     * @param listBlock 番地リスト
     */
    public void setListBlock(final List<ZzAddress2BlockEntity> listBlock) {
        this.listBlock = listBlock;
    }

}
