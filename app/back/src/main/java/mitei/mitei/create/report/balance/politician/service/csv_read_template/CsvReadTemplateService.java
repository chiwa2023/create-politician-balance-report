package mitei.mitei.create.report.balance.politician.service.csv_read_template;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.institution_csv.CsvReadTemplateDto;
import mitei.mitei.create.report.balance.politician.entity.CsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.CsvReadTemplateRepository;

/**
 * csv読み取り仕様テーブルService
 */
@Service
public class CsvReadTemplateService {

    /** csv_read_template用Repository */
    @Autowired
    private CsvReadTemplateRepository csvReadTemplateRepository;
    
    /**
     * 読み出ししたcsvの列数と一致するcsv読み取りテンプレートを取得する
     *
     * @param arrayNumber 読み出ししたcsvの列数
     * @return csv読み取りテンプレート
     */
    public List<CsvReadTemplateDto> selectTemplateByNumber(final int arrayNumber){
        
        List<CsvReadTemplateEntity> listEntities = csvReadTemplateRepository.findByArrayNumberOrderByCsvReadTemplateNameAsc(arrayNumber);
        
        List<CsvReadTemplateDto> list = new ArrayList<>();
        
        CsvReadTemplateDto dto;
        for(CsvReadTemplateEntity entity : listEntities) {
            dto = new CsvReadTemplateDto(); // NOPMD
            BeanUtils.copyProperties(entity, dto);
            dto.setValue(String.valueOf(entity.getCsvReadTemplateId()));
            dto.setText(entity.getCsvReadTemplateName());
            list.add(dto);
        }
        
        CsvReadTemplateDto dtoNotSelect = new CsvReadTemplateDto();
        dtoNotSelect.setValue("0");
        dtoNotSelect.setText("選択解除");
        dtoNotSelect.setArrayNumber(0);
        
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ;i<arrayNumber ; i++) {
            stringBuilder.append("0,");
        }
        
        dtoNotSelect.setArrayText(stringBuilder.substring(0, stringBuilder.length()-1));
        
        list.add(dtoNotSelect);
        
        return list;
    }
    
}
