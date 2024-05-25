package mitei.mitei.create.report.balance.politician.zz_address2_support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;

/**
 * zz_address2_postalcode接続用Repository
 */
public interface ZzAddress2PostalcodeRepository  extends JpaRepository<ZzAddress2PostalcodeEntity, Integer>{

    /**
     * 検索キーで始まる住所を持つ郵便番号リスト
     *
     * @param key 検索キー
     * @return 該当の郵便番号Entityリスト
     */
    public List<ZzAddress2PostalcodeEntity> findByAddressNameStartingWith(String key); //NOPMD UnnecessaryModifier
    
    
    /**
     * 検索条件で指定された郵便番号リスト
     * TODO 実際には1件しか戻らない予定だが、()で注釈されている部分がリスト化する可能性があるためリストで返却する。
     * 仕様が決定次第修正する
     *
     * @param postalcode 郵便番号
     * @return 郵便番号Entityリスト
     */
    public List<ZzAddress2PostalcodeEntity> findByPostalcode(String postalcode); //NOPMD UnnecessaryModifier
    
}
