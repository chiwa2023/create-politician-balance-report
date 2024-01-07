package mitei.mitei.create.report.balance.politician.publish.validate;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0701CoverAndOrganizationDetailsDto;

/**
 * シートその１の入力状況を確認する妥当性チェックLogic
 */
@Component
public class Validate070100AllSheetLogic {

    
    public int practice(boolean isOverwrite,AllSheet0701CoverAndOrganizationDetailsDto allSheet0701) {
        
        
        
        //常になにがしかの入力を要求される。必要項目が存在しない場合は、例外対処するので固定値でOK
        return MakeUmuInputTextLogic.ARI_INPUT_DATA_FLUG;
    }
    
}
