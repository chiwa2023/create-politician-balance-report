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
 * Sheet071503MagazinePublicationExpensesDto単体テスト
 */
class Sheet071503MagazinePublicationExpensesDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // リスト0
        Sheet071503MagazinePublicationExpensesDto sheet0 = new Sheet071503MagazinePublicationExpensesDto();
        sheet0.setPageTotal(30000L);
        sheet0.setSonotaTotal("");
        sheet0.setHimoku("費目");
        
        String xml0 = xmlMapper.writeValueAsString(sheet0);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_071503_none.txt");
        String answer0 = Files.readString(pathAnswer0);
        assertThat(xml0).isEqualTo(answer0);

        // リスト存在
        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_071503_list.txt");
        String answer1 = Files.readString(pathAnswer1);

        Sheet071503MagazinePublicationExpensesDto sheet1 = new Sheet071503MagazinePublicationExpensesDto();
        sheet1.setPageTotal(30000L);
        sheet1.setSonotaTotal("");
        sheet1.setHimoku("費目");

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

        sheet1.getList().add(row0);

        String xml1 = xmlMapper.writeValueAsString(sheet1);

        assertThat(xml1).isEqualTo(answer1);
        
    }

}
