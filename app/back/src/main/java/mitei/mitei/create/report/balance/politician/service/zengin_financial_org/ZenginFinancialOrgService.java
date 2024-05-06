package mitei.mitei.create.report.balance.politician.service.zengin_financial_org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.entity.ZenginFinancialOrgEntity;
import mitei.mitei.create.report.balance.politician.repository.ZenginFinancialOrgRepository;

/**
 * 全銀金融機関テーブルService
 */
@Service
public class ZenginFinancialOrgService {

    /** 全銀金融機関Repository*/
    @Autowired
    private ZenginFinancialOrgRepository zenginFinancialOrgRepository;
    
    /**
     *  検索語全文検索を行う
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    public List<ZenginFinancialOrgEntity> searchTable(final String searchWords){
        
        return zenginFinancialOrgRepository.findFullText(searchWords);
    }
    
}
