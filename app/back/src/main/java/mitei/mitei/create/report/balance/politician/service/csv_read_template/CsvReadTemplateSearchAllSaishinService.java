package mitei.mitei.create.report.balance.politician.service.csv_read_template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * 現在申請中(最新)データをすべて抽出する
 */
@Service
public class CsvReadTemplateSearchAllSaishinService {

    /** csv_read_template用Repository */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;
    
    /**
     * 最新データをすべて抽出する。申請が終了したら履歴とする。
     *
     * @return 現在申請中データ全検索結果
     */
    public List<ProposeCsvReadTemplateEntity> practice(){
        
        return proposeCsvReadTemplateRepository.findBySaishinKbn(SaishinKbnConstants.SAISHIN);
    }
}
