package mitei.mitei.create.report.balance.politician.dto.publish;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * AllSheet0705IncomeRelatedToGrantsDto単体テスト
 */
class AllSheet0705IncomeRelatedToGrantsDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD
        
        AllSheet0705IncomeRelatedToGrantsDto allSheet0705IncomeRelatedToGrantsDto = new AllSheet0705IncomeRelatedToGrantsDto();        
        
        Sheet070500IncomeRelatedToGrantsDto sheet1 = new Sheet070500IncomeRelatedToGrantsDto();
        sheet1.setPageTotal(30000L);

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070500IncomeRelatedToGrantsDto row0 = new Row070500IncomeRelatedToGrantsDto();

        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 本部支部の名称 */
        row0.setHonbuShibuName("本部支部名称");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 発生日 */
        row0.setDate("R4/2/2");
        /// ** 事務所の住所 */
        row0.setJimushoJuusho("事務所住所");
        /// ** 備考 */
        row0.setBiko("備考");

        sheet1.getList().add(row0);
        
        allSheet0705IncomeRelatedToGrantsDto.setSheet070500IncomeRelatedToGrantsDto(sheet1);
        
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        String xml0 = xmlMapper.writeValueAsString(allSheet0705IncomeRelatedToGrantsDto);
        
        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0705.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
