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
 * AllSheet0706OtherIncomeDto単体テスト
 */
class AllSheet0706OtherIncomeDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0706OtherIncomeDto allSheet0706OtherIncomeDto = new AllSheet0706OtherIncomeDto();

        Sheet070600OtherIncomeDto sheet1 = new Sheet070600OtherIncomeDto();
        sheet1.setMimanTotal("");// 空文字を設定しないとタグを挟んでくれない←Logicで対応

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

        allSheet0706OtherIncomeDto.setSheet070600OtherIncomeDto(sheet1);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet0706OtherIncomeDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0706.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
