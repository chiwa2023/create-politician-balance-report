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
 * AllSheetKbn070802Dto
 */
class AllSheetKbn070802DtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheetKbn070802Dto allSheetKbn070802Dto = new AllSheetKbn070802Dto();

        Sheet070802MediationGroupDto sheet1 = new Sheet070802MediationGroupDto();
        sheet1.setPageTotal(30000L);
        sheet1.setSonotaTotal("2000");

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070812MediationDto row0 = new Row070812MediationDto();

        /// ** 連番 */
        row0.setIchirenNo(1);
        /// ** 名前 */
        row0.setName("名称");
        /// ** 金額 */
        row0.setKingaku(30000L);
        /// ** 発生日 */
        row0.setDate("R4/2/2");
        /// ** 斡旋の期間 */
        row0.setPeriodMediate("1/1-1/31");
        /// ** 住所 */
        row0.setJuusho("住所");
        /// ** 職業 */
        row0.setShokugyou("職業");
        /// ** 備考 */
        row0.setBiko("備考");
        /// ** 通し番号 */
        row0.setTohshibangou(1);
        /// ** 行区分 */
        row0.setGyoukubun(Short.valueOf("7"));

        sheet1.getList().add(row0);

        allSheetKbn070802Dto.setSheet070802MediationGroupDto(sheet1);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheetKbn070802Dto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/kbn_070802_list.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);

    }

}
