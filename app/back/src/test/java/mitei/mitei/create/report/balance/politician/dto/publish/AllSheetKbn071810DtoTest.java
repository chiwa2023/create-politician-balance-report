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
 * AllSheetKbn071810Dto
 */
class AllSheetKbn071810DtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheetKbn071810Dto allSheetKbn071810Dto = new AllSheetKbn071810Dto();

        Sheet071810DepositAmongAssetsDto sheet1 = new Sheet071810DepositAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row0 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 摘要 */
        row0.setTekiyou("摘要");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 発生日 */
        row0.setDate("R4/12/1");
        /// ** 備考 */
        row0.setBiko("備考");

        sheet1.getList().add(row0);

        allSheetKbn071810Dto.setSheet071810DepositAmongAssetsDto(sheet1);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheetKbn071810Dto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/kbn_071810_list.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);

    }

}
