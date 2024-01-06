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
 * AllSheet0708MediationDto単体テスト
 */
class AllSheet0708MediationDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0708MediationDto allSheet0708MediationDto = new AllSheet0708MediationDto();

        // その1
        AllSheetKbn070801Dto allSheetKbn070801Dto = new AllSheetKbn070801Dto();

        Sheet070801MediationPersonDto sheet1 = new Sheet070801MediationPersonDto();
        sheet1.setPageTotal(30000L);
        sheet1.setSonotaTotal("2000");

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070812MediationDto row1 = new Row070812MediationDto();

        /// ** 連番 */
        row1.setIchirenNo(1);
        /// ** 名前 */
        row1.setName("名称");
        /// ** 金額 */
        row1.setKingaku(30000L);
        /// ** 発生日 */
        row1.setDate("R4/2/2");
        /// ** 斡旋の期間 */
        row1.setPeriodMediate("1/1-1/31");
        /// ** 住所 */
        row1.setJuusho("住所");
        /// ** 職業 */
        row1.setShokugyou("職業");
        /// ** 備考 */
        row1.setBiko("備考");
        /// ** 通し番号 */
        row1.setTohshibangou(1);
        /// ** 行区分 */
        row1.setGyoukubun(Short.valueOf("7"));

        sheet1.getList().add(row1);

        allSheetKbn070801Dto.setSheet070801MediationPersonDto(sheet1);

        // その2
        AllSheetKbn070802Dto allSheetKbn070802Dto = new AllSheetKbn070802Dto();

        Sheet070802MediationGroupDto sheet2 = new Sheet070802MediationGroupDto();
        sheet2.setPageTotal(30000L);
        sheet2.setSonotaTotal("2000");

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070812MediationDto row2 = new Row070812MediationDto();

        /// ** 連番 */
        row2.setIchirenNo(1);
        /// ** 名前 */
        row2.setName("名称");
        /// ** 金額 */
        row2.setKingaku(30000L);
        /// ** 発生日 */
        row2.setDate("R4/2/2");
        /// ** 斡旋の期間 */
        row2.setPeriodMediate("1/1-1/31");
        /// ** 住所 */
        row2.setJuusho("住所");
        /// ** 職業 */
        row2.setShokugyou("職業");
        /// ** 備考 */
        row2.setBiko("備考");
        /// ** 通し番号 */
        row2.setTohshibangou(1);
        /// ** 行区分 */
        row2.setGyoukubun(Short.valueOf("7"));

        sheet2.getList().add(row2);

        allSheetKbn070802Dto.setSheet070802MediationGroupDto(sheet2);

        // その3
        AllSheetKbn070803Dto allSheetKbn070803Dto = new AllSheetKbn070803Dto();

        Sheet070803MediationPoliticOrgDto sheet3 = new Sheet070803MediationPoliticOrgDto();
        sheet3.setPageTotal(30000L);
        sheet3.setSonotaTotal("2000");

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070812MediationDto row3 = new Row070812MediationDto();

        /// ** 連番 */
        row3.setIchirenNo(1);
        /// ** 名前 */
        row3.setName("名称");
        /// ** 金額 */
        row3.setKingaku(30000L);
        /// ** 発生日 */
        row3.setDate("R4/2/2");
        /// ** 斡旋の期間 */
        row3.setPeriodMediate("1/1-1/31");
        /// ** 住所 */
        row3.setJuusho("住所");
        /// ** 職業 */
        row3.setShokugyou("職業");
        /// ** 備考 */
        row3.setBiko("備考");
        /// ** 通し番号 */
        row3.setTohshibangou(1);
        /// ** 行区分 */
        row3.setGyoukubun(Short.valueOf("7"));

        sheet3.getList().add(row3);

        allSheetKbn070803Dto.setSheet070803MediationPoliticOrgDto(sheet3);

        allSheet0708MediationDto.setAllSheetKbn070801Dto(allSheetKbn070801Dto);
        allSheet0708MediationDto.setAllSheetKbn070802Dto(allSheetKbn070802Dto);
        allSheet0708MediationDto.setAllSheetKbn070803Dto(allSheetKbn070803Dto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet0708MediationDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0708.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
