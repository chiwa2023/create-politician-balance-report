package mitei.mitei.create.report.balance.politician.report_item.zengin;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.report_item.TradingCoreItemBankingDto;

/**
 * ReadZenginFormatCsvLogic単体テスト
 */
class ReadZenginFormatCsvLogicTest {
    // CHECKSTYLE:OFF

    @Test
    void test()throws Exception {
        
        ReadZenginFormatCsvLogic readZenginFormatCsvLogic = new ReadZenginFormatCsvLogic();
        
        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "report_item/zegin_csv_format.csv");
        
        MultipartFile file = new MockMultipartFile("zegin_csv_format", new FileInputStream(path.toFile())); //NOPMD
        
        try(
                Reader reader1 = new InputStreamReader(file.getInputStream());
                ){
            
            List<TradingCoreItemBankingDto> list = readZenginFormatCsvLogic.practice(reader1);
            
            TradingCoreItemBankingDto dto = list.get(0);
            // 取引金額 
            assertThat(dto.getTransactionAmount()).isEqualTo(98765L);
            // 入出金区分 
            assertThat(dto.getDeWdKbn()).isEqualTo(1);
            // 処理日 
            assertThat(dto.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));
            // 処理明細(自由記述) 
            assertThat(dto.getTradingDetail()).isEqualTo("取引詳細");
            // 金融機関番号(全銀統一コード) 
            //assertThat(dto.getFinancialInstitutionNo()).isEqualTo(0);
            // 金融機関名称
            assertThat(dto.getFinancialInstitutionName()).isEqualTo("××銀行");
            // 僚店番号(支店番号)
            assertThat(dto.getBranchNo()).isEqualTo("456");
            // 支店名 
            assertThat(dto.getBranchName()).isEqualTo("○○支店");
            // 口座区分 
            assertThat(dto.getAccountKbn()).isEqualTo(1);
            // 口座区分 
            assertThat(dto.getAccountKbnName()).isEqualTo("普通預金");
            // 口座番号 
            assertThat(dto.getAccountNo()).isEqualTo("2468013579");
            // 口座名義 
            assertThat(dto.getAccountHolderName()).isEqualTo("振込信金ユーザ太郎");
        }
    }

}
