package mitei.mitei.create.report.balance.politician.zz_address2_support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2BlockEntity;

/**
 * zz_address2_block接続用Repository
 */
public interface ZzAddress2BlockRepository  extends JpaRepository<ZzAddress2BlockEntity, Integer>{

    /**
     * 該当の郵便番号を持つ番地を取得する
     *
     * @param postalCode 検索条件郵便番号
     * @return 番地リスト
     */
    public List<ZzAddress2BlockEntity> findByPostalCode(String postalCode); // NOPMD UnnecessaryModifier

}
