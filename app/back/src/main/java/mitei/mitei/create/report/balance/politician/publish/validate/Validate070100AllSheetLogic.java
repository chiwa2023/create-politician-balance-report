package mitei.mitei.create.report.balance.politician.publish.validate;

import java.util.Objects;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0701CoverAndOrganizationDetailsDto;
import mitei.mitei.create.report.balance.politician.dto.publish.Sheet070100CoverAndOrganizationDetailsDto;

/**
 * シートその１の入力状況を確認する妥当性チェックLogic
 */
@Component
public class Validate070100AllSheetLogic {
    
    /**
     * 入力確認チェックを行う
     *
     * @param allSheet0701 様式7その1全データ
     * @return 常に入力あり(値：1)
     * @throws BalanceReportRequiredInputException 入力必須項目が入力されていない場合
     */
    public int practice(final AllSheet0701CoverAndOrganizationDetailsDto allSheet0701)throws BalanceReportRequiredInputException {
        
        //必ず入力必須
        this.checkNull(allSheet0701,"引数自体");

        //子のシートも
        Sheet070100CoverAndOrganizationDetailsDto sheet070100Dto = allSheet0701.getSheet070100CoverAndOrganizationDetailsDto();
        this.checkNull(sheet070100Dto,"0701シート");
        
        this.checkNull(sheet070100Dto.getHoukokuNen(),"報告年");
        //TODO 西暦年数表記で記載されているか
        this.checkNull(sheet070100Dto.getDantaiName(),"団体名称");
        this.checkNull(sheet070100Dto.getDantaiNameKana(),"団体名称かな");
        this.checkNull(sheet070100Dto.getJimushoJusho(),"事務所住所");
        this.checkNull(sheet070100Dto.getDaihyoushaNameLast(),"代表者姓");
        this.checkNull(sheet070100Dto.getDaihyoushaNameFirst(),"代表者名");
        this.checkNull(sheet070100Dto.getKaikeiSekinnshaNameLast(),"会計責任者姓");
        this.checkNull(sheet070100Dto.getKaikeiSekinnshaNameFirst(),"会計責任者名");
        this.checkNull(sheet070100Dto.getJimuTantousha1NameLast(),"事務担当者姓");
        this.checkNull(sheet070100Dto.getJimuTantousha1NameLast(),"事務担当者名");
        this.checkNull(sheet070100Dto.getJimuTantousha1Tel(),"事務担当者電話番号");
        this.checkNull(sheet070100Dto.getDantaiKbn(),"団体区分");
        //TODO 区分の値が指定範囲内かどうか
        this.checkNull(sheet070100Dto.getKatsudouKuikiKbn(),"活動区域");
        //TODO 活動区域の値が指定範囲内かどうか
        this.checkNull(sheet070100Dto.getUmuShikinKanrenDantai(),"資金団体の有無");
        //TODO 資金団体の有無の値が指定範囲内かどうか
        this.checkNull(sheet070100Dto.getKokkaiGiinDantaiKbn(),"国会議員団体かどうかの区分");
        //TODO 国会議員の区分の値が指定範囲内かどうか
        
        //常になにがしかの入力を要求される。必要項目が存在しない場合は、例外対処するので固定値でOK
        return MakeUmuInputTextLogic.ARI_INPUT_DATA_FLUG;
    }
    
    private boolean checkNull(final Object value,final String message)throws BalanceReportRequiredInputException {
        
        if(Objects.isNull(value)) {
            throw new BalanceReportRequiredInputException(message);
        }
        
        return true;
    }
}
