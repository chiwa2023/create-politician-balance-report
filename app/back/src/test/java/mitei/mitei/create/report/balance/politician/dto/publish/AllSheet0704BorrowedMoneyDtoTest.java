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
 * AllSheet0704BorrowedMoneyDto単体テスト
 */
class AllSheet0704BorrowedMoneyDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0704BorrowedMoneyDto allSheet0704BorrowedMoneyDto = new AllSheet0704BorrowedMoneyDto();

        Sheet070400BorrowedMoneyDto sheet1 = new Sheet070400BorrowedMoneyDto();
        sheet1.setPageTotal(30000L);

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070400BorrowedMoneyDto row0 = new Row070400BorrowedMoneyDto();

        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 借り先 */
        row0.setKarisaki("借入先");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 備考 */
        row0.setBiko("備考");

        sheet1.getList().add(row0);

        allSheet0704BorrowedMoneyDto.setSheet070400BorrowedMoneyDto(sheet1);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet0704BorrowedMoneyDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0704.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
