package mitei.mitei.create.report.balance.politician.service.various_financial_pay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.entity.VariousFinancialPayEntity;
import mitei.mitei.create.report.balance.politician.repository.VariousFinancialPayRepository;

/**
 * 各種PayテーブルService
 */
@Service
public class VariousFinancialPayService {

    /** 各種PayテーブルRepository */
    @Autowired
    private VariousFinancialPayRepository variousFinancialPayRepository;
    
    /**
     * 検索条件から該当テーブルの全文検索を行う
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    public List<VariousFinancialPayEntity> searchTable(final String searchWords){

        return variousFinancialPayRepository.findFullText(searchWords);
    }
}
