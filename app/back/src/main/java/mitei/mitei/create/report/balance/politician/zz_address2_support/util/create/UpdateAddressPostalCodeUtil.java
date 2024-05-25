package mitei.mitei.create.report.balance.politician.zz_address2_support.util.create;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2BlockEntity;
import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;
import mitei.mitei.create.report.balance.politician.zz_address2_support.repository.ZzAddress2BlockRepository;
import mitei.mitei.create.report.balance.politician.zz_address2_support.repository.ZzAddress2PostalcodeRepository;

/**
 * 郵便番号修正Utility
 */
@Component
public class UpdateAddressPostalCodeUtil {

    /** 番地テーブルRepository */
    @Autowired
    private ZzAddress2BlockRepository zzAddress2BlockRepository;

    /** 郵便番号テーブルRepository */
    @Autowired
    private ZzAddress2PostalcodeRepository zzAddress2PostalcodeRepository;

    
    /**
     * 番地情報を郵便番号テーブルに追加するためのリスト
     *
     * @return 郵便番号テーブルEntityリスト
     */
    public List<ZzAddress2PostalcodeEntity> practice() {
        List<ZzAddress2PostalcodeEntity> list = new ArrayList<>();
        
        for(ZzAddress2PostalcodeEntity postalEntity : zzAddress2PostalcodeRepository.findAll()) {
            List<ZzAddress2BlockEntity> listBlock = zzAddress2BlockRepository.findByPostalCode(postalEntity.getPostalcode());    
            if(!listBlock.isEmpty()) {
                
                postalEntity.setIsChoume(this.checkChoume(listBlock));
                postalEntity.setIsPrc1(this.checkPrc1(listBlock));
                postalEntity.setIsPrc2(this.checkPrc2(listBlock));
                postalEntity.setIsPrc3(this.checkPrc3(listBlock));
                
                list.add(postalEntity);
            }
        }
        
        return list;
    }

    private boolean checkChoume(final List<ZzAddress2BlockEntity> listBlock) {
        
        for(ZzAddress2BlockEntity entity : listBlock) {
            if(entity.getChoume() != 0) {
                return true;
            }
        }
        
        return false;
    }

    private boolean checkPrc1(final List<ZzAddress2BlockEntity> listBlock) {
        
        for(ZzAddress2BlockEntity entity : listBlock) {
            if(entity.getPrc1() != 0) {
                return true;
            }
        }
        
        return false;
    }

    private boolean checkPrc2(final List<ZzAddress2BlockEntity> listBlock) {
        
        for(ZzAddress2BlockEntity entity : listBlock) {
            if(entity.getPrc2() != 0) {
                return true;
            }
        }
        
        return false;
    }

    private boolean checkPrc3(final List<ZzAddress2BlockEntity> listBlock) {
        
        for(ZzAddress2BlockEntity entity : listBlock) {
            if(entity.getPrc3() != 0) {
                return true;
            }
        }
        
        return false;
    }

}
