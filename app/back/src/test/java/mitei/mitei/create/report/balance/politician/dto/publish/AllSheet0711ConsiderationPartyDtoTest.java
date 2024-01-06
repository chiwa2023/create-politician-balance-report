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
 * AllSheet0711ConsiderationPartyDto単体テスト
 */
class AllSheet0711ConsiderationPartyDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0711ConsiderationPartyDto allSheet0711ConsiderationPartyDto = new AllSheet0711ConsiderationPartyDto();

        // その1
        AllSheetKbn071101Dto allSheetKbn071101Dto = new AllSheetKbn071101Dto();

        Sheet071101ConsiderationPartyPerspnalDto sheet1 = new Sheet071101ConsiderationPartyPerspnalDto();
        sheet1.setPageTotal(30000L);
        sheet1.setPartyName("パーティ名称");
        sheet1.setSortNo(9);

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

        allSheetKbn071101Dto.getList().add(sheet1);

        // その2
        AllSheetKbn071102Dto allSheetKbn071102Dto = new AllSheetKbn071102Dto();

        Sheet071102ConsiderationPartyGroupDto sheet2 = new Sheet071102ConsiderationPartyGroupDto();
        sheet2.setPageTotal(30000L);
        sheet2.setPartyName("パーティ名称");
        sheet2.setSortNo(9);

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

        allSheetKbn071102Dto.getList().add(sheet2);

        // その3
        AllSheetKbn071103Dto allSheetKbn071103Dto = new AllSheetKbn071103Dto();

        Sheet071103ConsiderationPartyPoliticOrgDto sheet3 = new Sheet071103ConsiderationPartyPoliticOrgDto();
        sheet3.setPageTotal(30000L);
        sheet3.setPartyName("パーティ名称");
        sheet3.setSortNo(9);

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

        allSheetKbn071103Dto.getList().add(sheet3);

        allSheet0711ConsiderationPartyDto.setAllSheetKbn071101Dto(allSheetKbn071101Dto);
        allSheet0711ConsiderationPartyDto.setAllSheetKbn071102Dto(allSheetKbn071102Dto);
        allSheet0711ConsiderationPartyDto.setAllSheetKbn071103Dto(allSheetKbn071103Dto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml1 = xmlMapper.writeValueAsString(allSheet0711ConsiderationPartyDto);

        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0711.txt");
        String answer1 = Files.readString(pathAnswer1);

        assertThat(xml1).isEqualTo(answer1);

    }

}
