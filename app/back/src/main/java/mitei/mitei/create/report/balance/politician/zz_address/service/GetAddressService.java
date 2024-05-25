package mitei.mitei.create.report.balance.politician.zz_address.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.SelectOptionInterface;
import mitei.mitei.create.report.balance.politician.zz_address.entity.ZzAddressBlockEntity;
import mitei.mitei.create.report.balance.politician.zz_address.repository.ZzAddressBlockRepository;

/**
 * 住所取得Service実装例1
 */
@Service
public class GetAddressService {
    
    /** 郵便番号テーブル1 */
    @Autowired
    private ZzAddressBlockRepository zzAddressBlockRepository;
    
    /**
     * 番地リストを返却する
     *
     * @param postalCode 郵便番号
     * @return 番地リスト
     */
    public List<SelectOptionInterface> practice(final String postalCode){
        
        List<SelectOptionInterface> list = new ArrayList<>();
        
        for(ZzAddressBlockEntity blockEntity :zzAddressBlockRepository.findByPostalCode(postalCode)) {
            list.add(blockEntity);
        }
        
        return list;
    }
    
}
