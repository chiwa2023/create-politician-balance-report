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
 * AllSheet0716RelatedToGrantsDtoDto単体テスト
 */
class AllSheet0716RelatedToGrantsDtoDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD
        AllSheet0716RelatedToGrantsDtoDto allSheet0716RelatedToGrantsDtoDto = new AllSheet0716RelatedToGrantsDtoDto();

        Sheet071600ExpendituresRelatedToGrantsDto sheet1 = new Sheet071600ExpendituresRelatedToGrantsDto();
        sheet1.setPageTotal(30000L);

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071600ExpendituresRelatedToGrantsProvidedDto row0 = new Row071600ExpendituresRelatedToGrantsProvidedDto();
        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 支出項目 */
        row0.setShishutsuKoumoku("支出の目的");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 発生日 */
        row0.setDate("R4/12/1");
        /// ** 本部支部への交付金支出の相手先名称 */
        row0.setHonShibuName("本部支部名称");
        /// ** 支出の相手先住所 */
        row0.setJusho("東京都千代田区");
        /// ** 備考 */
        row0.setBiko("備考");

        sheet1.getList().add(row0);

        allSheet0716RelatedToGrantsDtoDto.setSheet071600ExpendituresRelatedToGrantsDto(sheet1);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet0716RelatedToGrantsDtoDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0716.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
