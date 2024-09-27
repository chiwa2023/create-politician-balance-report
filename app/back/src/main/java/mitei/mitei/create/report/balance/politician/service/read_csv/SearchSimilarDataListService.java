package mitei.mitei.create.report.balance.politician.service.read_csv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.CsvTradingRowConstants;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.CsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.CsvReadTemplateRepository;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * 編集中の申請データの類似データを一覧する
 */
@Service
public class SearchSimilarDataListService {

    /** CSV読み取り仕様申請テーブル */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    /** CSV読み取り仕様テーブル */
    @Autowired
    private CsvReadTemplateRepository csvReadTemplateRepository;

    /**
     * 類似リストを取得する
     *
     * @param templateEntity 編集対象Entity
     * @return 申請中と運用中の類似データ
     */
    public List<List<String>> practice(final ProposeCsvReadTemplateEntity templateEntity) {
        List<List<String>> listAll = new ArrayList<>();

        // TODO 類似度の高いリストの条件は検討後決定する
        List<ProposeCsvReadTemplateEntity> listPropose = proposeCsvReadTemplateRepository.findAll();
        List<ProposeCsvReadTemplateEntity> listProposeFilter = listPropose.stream().filter(entity -> {
            return DataHistoryStatusConstants.INSERT.value() == entity.getSaishinKbn();
        }).toList();

        for (ProposeCsvReadTemplateEntity entity : listProposeFilter) {
            List<String> line = new ArrayList<>();// NOPMD
            line.add(String.valueOf(entity.getProposeCsvReadTemplateCode()));
            line.add(entity.getProposeCsvReadTemplateName());
            
            String[] setting = entity.getArrayText().split(",");
            //値で格納しているのを定数(表示テキストに変換)
            for(String settingValue : setting) {
                line.add(CsvTradingRowConstants.convertValueToText(settingValue));
            }

            listAll.add(line);
        }

        // TODO 類似度の高いリストの条件は検討後決定する
        List<CsvReadTemplateEntity> listCsv = csvReadTemplateRepository.findAll();
        List<CsvReadTemplateEntity> listCsvFilter = listCsv.stream().filter(entity -> {
            return DataHistoryStatusConstants.INSERT.value() == entity.getSaishinKbn();
        }).toList();

        for (CsvReadTemplateEntity entity : listCsvFilter) {
            List<String> line = new ArrayList<>(); // NOPMD

            line.add(String.valueOf(entity.getCsvReadTemplateCode()));
            line.add(entity.getCsvReadTemplateName());
            
            String[] setting = entity.getArrayText().split(",");
            //値で格納しているのを定数(表示テキストに変換)
            for(String settingValue : setting) {
                line.add(CsvTradingRowConstants.convertValueToText(settingValue));
            }
 
            listAll.add(line);
        }

        return listAll;
    }
}
