package mitei.mitei.create.report.balance.politician.zz_address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mitei.mitei.create.report.balance.politician.zz_address.entity.ZzAddressBlockEntity;

/**
 * zz_address_block接続用Repository
 */
public interface ZzAddressBlockRepository  extends JpaRepository<ZzAddressBlockEntity, Long>{

    public List<ZzAddressBlockEntity> findByPostalCode(String postalCode);
}
