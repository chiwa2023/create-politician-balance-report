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
 * Sheet070600OtherIncomeDto単体テスト
 */
class Sheet070600OtherIncomeDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // リスト0
        Sheet070600OtherIncomeDto sheet0 = new Sheet070600OtherIncomeDto();
        sheet0.setMimanTotal("");//空文字を設定しないとタグを挟んでくれない←Logicで対応
        
        String xml0 = xmlMapper.writeValueAsString(sheet0);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_070600_none.txt");
        String answer0 = Files.readString(pathAnswer0);
        assertThat(xml0).isEqualTo(answer0);
        
        // リスト存在
        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_070600_list.txt");
        String answer1 = Files.readString(pathAnswer1);

        Sheet070600OtherIncomeDto sheet1 = new Sheet070600OtherIncomeDto();
        sheet1.setMimanTotal("");//空文字を設定しないとタグを挟んでくれない←Logicで対応

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070600OtherIncomeDto row0 = new Row070600OtherIncomeDto();
        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 摘要 */
        row0.setTekiyou("摘要");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 備考 */
        row0.setBiko("備考");

        sheet1.getList().add(row0);

        String xml1 = xmlMapper.writeValueAsString(sheet1);

        assertThat(xml1).isEqualTo(answer1);
        
    }

}
