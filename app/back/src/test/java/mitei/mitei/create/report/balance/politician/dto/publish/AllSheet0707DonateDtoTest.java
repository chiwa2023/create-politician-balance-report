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
 * AllSheet0707DonateDto単体テスト
 */
class AllSheet0707DonateDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0707DonateDto allSheet0707DonateDto = new AllSheet0707DonateDto();

        // その1
        AllSheetKbn070701Dto allSheetKbn070701Dto = new AllSheetKbn070701Dto();

        Sheet070701DonatePersonDto sheet1 = new Sheet070701DonatePersonDto();
        sheet1.setPageTotal(30000L);
        sheet1.setSonotaTotal("2000");

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070711DonateDto row1 = new Row070711DonateDto();

        /// ** 連番 */
        row1.setIchirenNo(1);
        /// ** 寄付者の名前 */
        row1.setKifusha("寄付者名称");
        /// ** 金額 */
        row1.setKingaku(30000L);
        /// ** 発生日 */
        row1.setDate("R4/2/2");
        /// ** 住所 */
        row1.setJusho("住所");
        /// ** 職業 */
        row1.setShokugyou("職業");
        /// ** 備考 */
        row1.setBiko("備考");
        /// ** 通し番号 */
        row1.setTohshibangou(1);
        /// ** 税額控除フラグ */
        row1.setFlgZeigakuKohjo(Short.valueOf("0"));
        /// ** 行区分 */
        row1.setGyoukubun(Short.valueOf("8"));

        sheet1.getList().add(row1);

        allSheetKbn070701Dto.setSheet070701DonatePersonDto(sheet1);

        // その2
        AllSheetKbn070702Dto allSheetKbn070702Dto = new AllSheetKbn070702Dto();

        Sheet070702DonateGroupDto sheet2 = new Sheet070702DonateGroupDto();
        sheet2.setPageTotal(30000L);
        sheet2.setSonotaTotal("2000");

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070711DonateDto row2 = new Row070711DonateDto();

        /// ** 連番 */
        row2.setIchirenNo(1);
        /// ** 寄付者の名前 */
        row2.setKifusha("寄付者名称");
        /// ** 金額 */
        row2.setKingaku(30000L);
        /// ** 発生日 */
        row2.setDate("R4/2/2");
        /// ** 住所 */
        row2.setJusho("住所");
        /// ** 職業 */
        row2.setShokugyou("職業");
        /// ** 備考 */
        row2.setBiko("備考");
        /// ** 通し番号 */
        row2.setTohshibangou(1);
        /// ** 税額控除フラグ */
        row2.setFlgZeigakuKohjo(Short.valueOf("0"));
        /// ** 行区分 */
        row2.setGyoukubun(Short.valueOf("8"));

        sheet2.getList().add(row2);

        allSheetKbn070702Dto.setSheet070702DonateGroupDto(sheet2);

        // その3
        AllSheetKbn070703Dto allSheetKbn070703Dto = new AllSheetKbn070703Dto();

        Sheet070703DonatePoliticOrgDto sheet3 = new Sheet070703DonatePoliticOrgDto();
        sheet3.setPageTotal(30000L);
        sheet3.setSonotaTotal("2000");

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070711DonateDto row3 = new Row070711DonateDto();

        /// ** 連番 */
        row3.setIchirenNo(1);
        /// ** 寄付者の名前 */
        row3.setKifusha("寄付者名称");
        /// ** 金額 */
        row3.setKingaku(30000L);
        /// ** 発生日 */
        row3.setDate("R4/2/2");
        /// ** 住所 */
        row3.setJusho("住所");
        /// ** 職業 */
        row3.setShokugyou("職業");
        /// ** 備考 */
        row3.setBiko("備考");
        /// ** 通し番号 */
        row3.setTohshibangou(1);
        /// ** 税額控除フラグ */
        row3.setFlgZeigakuKohjo(Short.valueOf("0"));
        /// ** 行区分 */
        row3.setGyoukubun(Short.valueOf("8"));

        sheet3.getList().add(row3);

        allSheetKbn070703Dto.setSheet070703DonatePoliticOrgDto(sheet3);

        allSheet0707DonateDto.setAllSheetKbn070701Dto(allSheetKbn070701Dto);
        allSheet0707DonateDto.setAllSheetKbn070702Dto(allSheetKbn070702Dto);
        allSheet0707DonateDto.setAllSheetKbn070703Dto(allSheetKbn070703Dto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet0707DonateDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0707.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
