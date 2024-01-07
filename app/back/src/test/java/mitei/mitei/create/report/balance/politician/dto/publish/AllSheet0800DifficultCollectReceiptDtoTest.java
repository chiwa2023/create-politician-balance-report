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
 * AllSheet0800DifficultCollectReceiptDto単体テスト
 */
class AllSheet0800DifficultCollectReceiptDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0800DifficultCollectReceiptDto allSheet0800DifficultCollectReceiptDto = new AllSheet0800DifficultCollectReceiptDto();

        Sheet080000DifficultCollectReceiptDto sheet1 = new Sheet080000DifficultCollectReceiptDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row080000DifficultCollectReceiptDto row1 = new Row080000DifficultCollectReceiptDto();
        /// ** 連番 */
        row1.setIchirenNo(1);
        /// ** 項目 */
        row1.setKoumoku("支出項目");
        /// ** 摘要 */
        row1.setTekiyou("摘要");
        /// ** 金額 */
        row1.setKingaku(30000L);
        /// ** 発生日 */
        row1.setDate("R4/12/1");
        /// ** 事情 */
        row1.setJijyou("徴し難たかった事情");

        sheet1.getList().add(row1);

        allSheet0800DifficultCollectReceiptDto.setSheet080000DifficultCollectReceiptDto(sheet1);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet0800DifficultCollectReceiptDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0800.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);

    }

}
