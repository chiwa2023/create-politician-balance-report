package mitei.mitei.create.report.balance.politician.publish.validate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0701CoverAndOrganizationDetailsDto;
import mitei.mitei.create.report.balance.politician.dto.publish.Sheet070100CoverAndOrganizationDetailsDto;

/**
 * Validate070100AllSheetLogic単体テスト
 */
class Validate070100AllSheetLogicTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void test()throws Exception {
        
        Validate070100AllSheetLogic validate070100AllSheetLogic = new Validate070100AllSheetLogic();
        
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(null),"引数がnull");

        AllSheet0701CoverAndOrganizationDetailsDto allSheetDto = new AllSheet0701CoverAndOrganizationDetailsDto();
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"0701シートがnull");

        Sheet070100CoverAndOrganizationDetailsDto sheetDto = new Sheet070100CoverAndOrganizationDetailsDto();
        allSheetDto.setSheet070100CoverAndOrganizationDetailsDto(sheetDto);
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"報告年がnull");

        sheetDto.setHoukokuNen(2022);
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"団体名称がnull");
        
        sheetDto.setDantaiName("団体名称");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"団体名称かながnull");
        
        sheetDto.setDantaiNameKana("団体名称かな");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"事務所住所がnull");
        
        sheetDto.setJimushoJusho("事務所住所");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"代表者姓がnull");
        
        sheetDto.setDaihyoushaNameLast("代表者姓");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"代表者名がnull");
        
        sheetDto.setDaihyoushaNameFirst("代表者名");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"会計責任者姓がnull");
        
        sheetDto.setKaikeiSekinnshaNameLast("会計責任者姓");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"会計責任者名がnull");
        
        //this.checkNull(sheet070100Dto.getJimuTantousha1NameLast(),"事務担当者姓");
        sheetDto.setKaikeiSekinnshaNameFirst("会計責任者名");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"事務担当者姓がnull");
        
        sheetDto.setJimuTantousha1NameLast("事務担当者姓");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"事務担当者名がnull");
        
        sheetDto.setJimuTantousha1NameFirst("事務担当者名");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"事務担当者電話番号がnull");
        
        sheetDto.setJimuTantousha1Tel("事務担当者電話番号");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"団体区分がnull");
        
        sheetDto.setDantaiKbn("団体区分");
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"活動区域がnull");
        
        sheetDto.setKatsudouKuikiKbn(99);
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"資金団体の有無がnull");
        
        sheetDto.setUmuShikinKanrenDantai(99);
        assertThrows(BalanceReportRequiredInputException.class,() -> validate070100AllSheetLogic.practice(allSheetDto),"国会議員団体かどうかの区分がnull");

        sheetDto.setKokkaiGiinDantaiKbn(99);

        
        //TODO 西暦年数表記で記載されているか
        //TODO 区分の値が指定範囲内かどうか
        //TODO 活動区域の値が指定範囲内かどうか
        //TODO 資金団体の有無の値が指定範囲内かどうか
        //TODO 国会議員の区分の値が指定範囲内かどうか
        

        //最低限度の入力ｇされていれば常に入力あり
        assertThat(validate070100AllSheetLogic.practice(allSheetDto)).isEqualTo(MakeUmuInputTextLogic.ARI_INPUT_DATA_FLUG);
        
        fail("Not yet implemented");
    }

}
