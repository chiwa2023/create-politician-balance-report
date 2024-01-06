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
 * AllSheet0712PartyMediationDto単体テスト
 */
class AllSheet0712PartyMediationDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0712PartyMediationDto allSheet0712PartyMediationDto = new AllSheet0712PartyMediationDto();

        // その1
        AllSheetKbn071201Dto allSheetKbn071201Dto = new AllSheetKbn071201Dto();

        Sheet071201ConsiderationMediationPartyPersonalDto sheet1 = new Sheet071201ConsiderationMediationPartyPersonalDto();
        sheet1.setPageTotal(30000L);
        sheet1.setPartyName("パーティ名称");
        sheet1.setSortNo(9);

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

        allSheetKbn071201Dto.getList().add(sheet1);

        // その2
        AllSheetKbn071202Dto allSheetKbn071202Dto = new AllSheetKbn071202Dto();

        Sheet071202ConsiderationMediationPartyGroupDto sheet2 = new Sheet071202ConsiderationMediationPartyGroupDto();
        sheet2.setPageTotal(30000L);
        sheet2.setPartyName("パーティ名称");
        sheet2.setSortNo(9);

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

        allSheetKbn071202Dto.getList().add(sheet2);

        // その3
        AllSheetKbn071203Dto allSheetKbn071203Dto = new AllSheetKbn071203Dto();

        Sheet071203ConsiderationMediationPartyPoliticOrgDto sheet3 = new Sheet071203ConsiderationMediationPartyPoliticOrgDto();
        sheet3.setPageTotal(30000L);
        sheet3.setPartyName("パーティ名称");
        sheet3.setSortNo(9);

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

        allSheetKbn071203Dto.getList().add(sheet3);

        allSheet0712PartyMediationDto.setAllSheetKbn071201Dto(allSheetKbn071201Dto);
        allSheet0712PartyMediationDto.setAllSheetKbn071202Dto(allSheetKbn071202Dto);
        allSheet0712PartyMediationDto.setAllSheetKbn071203Dto(allSheetKbn071203Dto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml1 = xmlMapper.writeValueAsString(allSheet0712PartyMediationDto);

        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0712.txt");
        String answer1 = Files.readString(pathAnswer1);

        assertThat(xml1).isEqualTo(answer1);

    }

}
