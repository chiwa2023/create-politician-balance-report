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
 * AllSheet0717SummaryTableOfAssetsDto単体テスト
 */
class AllSheet0717SummaryTableOfAssetsDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0717SummaryTableOfAssetsDto allSheet0717SummaryTableOfAssetsDto = new AllSheet0717SummaryTableOfAssetsDto();

        // 一種類のみ
        Sheet071700SummaryTableOfAssetsDto sheet0 = new Sheet071700SummaryTableOfAssetsDto();
        /// ** 土地報告フラグ */
        sheet0.setFlgTochi(1);
        /// ** 備考土地 */
        sheet0.setBikouTochi("備考");
        /// ** 建物報告フラグ */
        sheet0.setFlgTatemono(1);
        /// ** 備考建物 */
        sheet0.setBikouTatemono("備考");
        /// ** 借地件報告フラグ */
        sheet0.setFlgShakuchiken(1);
        /// ** 備考借地権 */
        sheet0.setBikouShakuchiken("備考");
        /// ** 動産報告フラグ */
        sheet0.setFlgDohsan(1);
        /// ** 動産借入 */
        sheet0.setBikouDohsan("備考");
        /// ** 預金報告フラグ */
        sheet0.setFlgYokin(1);
        /// ** 備考預金 */
        sheet0.setBikouYokin("備考");
        /// ** 信託報告フラグ */
        sheet0.setFlgShintaku(1);
        /// ** 備考信託 */
        sheet0.setBikouShintaku("備考");
        /// ** 証券報告フラグ */
        sheet0.setFlgShouken(1);
        /// ** 備考証券 */
        sheet0.setBikouShouken("備考");
        /// ** 出資報告フラグ */
        sheet0.setFlgShusshi(1);
        /// ** 備考出資 */
        sheet0.setBikouShusshi("備考");
        /// ** 貸付報告フラグ */
        sheet0.setFlgKashitsuke(1);
        /// ** 備考貸付 */
        sheet0.setBikouKashitsuke("備考");
        /// ** 敷金報告フラグ */
        sheet0.setFlgShikikin(1);
        /// ** 備考敷金 */
        sheet0.setBikouShikikin("備考");
        /// ** 施設利用報告フラグ */
        sheet0.setFlgShisetsuRiyou(1);
        /// ** 備考施設利用 */
        sheet0.setBikouShisetsuRiyou("備考");
        /// ** 借入報告フラグ */
        sheet0.setFlgKairiire(1);
        /// ** 備考借入 */
        sheet0.setBikouKariire("備考");

        allSheet0717SummaryTableOfAssetsDto.setSheet071700SummaryTableOfAssetsDto(sheet0);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet0717SummaryTableOfAssetsDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0717.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
