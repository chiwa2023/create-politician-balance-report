package mitei.mitei.create.report.balance.politician.zz_address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mitei.mitei.create.report.balance.politician.zz_address.entity.ZzAddressBlockEntity;

/**
 * zz_address_block接続用Repository
 */
public interface ZzAddressBlockRepository  extends JpaRepository<ZzAddressBlockEntity, Long>{

    /**
     * 郵便番号から番地情報を取得する
     *
     * @param postalCode 郵便番号
     * @return 番地情報リスト
     */
    List<ZzAddressBlockEntity> findByPostalCode(String postalCode);
}
