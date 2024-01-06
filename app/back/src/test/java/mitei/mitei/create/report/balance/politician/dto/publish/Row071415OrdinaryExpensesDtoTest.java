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
 * Row071415OrdinaryExpensesDto単体テスト
 */
class Row071415OrdinaryExpensesDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Path pathAnswer = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "dto/publish/row_071415.txt");
        String answer = Files.readString(pathAnswer);

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071415OrdinaryExpensesDto row0 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 支出の目的 */
        row0.setMokuteki("目的");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 発生日 */
        row0.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row0.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row0.setJusho("東京都千代田区");
        /// ** 備考 */
        row0.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row0.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row0.setFlgKouufukin(1);

        // XML生成
        String xml = xmlMapper.writeValueAsString(row0);

        // Dto名がXMLルートに入っているがワークシートで利用するときに<ROW>で上書き
        assertThat(xml).isEqualTo(answer);
    }

}
