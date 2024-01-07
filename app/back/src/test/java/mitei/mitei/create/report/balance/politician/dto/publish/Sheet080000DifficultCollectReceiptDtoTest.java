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
 * Sheet080000DifficultCollectReceiptDto単体テスト
 */
class Sheet080000DifficultCollectReceiptDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // リスト0
        Sheet080000DifficultCollectReceiptDto sheet0 = new Sheet080000DifficultCollectReceiptDto();
        String xml0 = xmlMapper.writeValueAsString(sheet0);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_080000_none.txt");
        String answer0 = Files.readString(pathAnswer0);
        assertThat(xml0).isEqualTo(answer0);

        Sheet080000DifficultCollectReceiptDto sheet1 = new Sheet080000DifficultCollectReceiptDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row080000DifficultCollectReceiptDto row0 = new Row080000DifficultCollectReceiptDto();
        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 項目 */
        row0.setKoumoku("支出項目");
        /// ** 摘要 */
        row0.setTekiyou("摘要");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 発生日 */
        row0.setDate("R4/12/1");
        /// ** 事情 */
        row0.setJijyou("徴し難たかった事情");

        sheet1.getList().add(row0);

        // リスト存在
        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_080000_list.txt");
        String answer1 = Files.readString(pathAnswer1);

        String xml1 = xmlMapper.writeValueAsString(sheet1);

        assertThat(xml1).isEqualTo(answer1);
    }

}
