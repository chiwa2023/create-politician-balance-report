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
 * Sheet070200SummaryTableIncomeExpenditureDto単体テスト
 */
class Sheet070200SummaryTableIncomeExpenditureDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 一種類のみ
        Sheet070200SummaryTableIncomeExpenditureDto sheet0 = new Sheet070200SummaryTableIncomeExpenditureDto();
        /// ** 収入総額 */
        sheet0.setShunyuGokei(30000L);
        /// ** 前年からの繰越額 */
        sheet0.setZennenKurikoshi(30000L);
        /// ** 本年の収入額 */
        sheet0.setHonnenShunyu(30000L);
        /// ** 支出総額 */
        sheet0.setShishutsuGoukei(30000L);
        /// ** 翌年への繰越額 */
        sheet0.setYokunenKurikoshi(30000L);
        /// ** 個人の党費または会費を納入金額 */
        sheet0.setKojiFutanGoukei(30000L);
        /// ** 党費または会費を納入した員数 */
        sheet0.setKojiFutanSuu(30000L);
        /// ** 個人寄付の合計 */
        sheet0.setKojinKifuGoukei(30000L);
        /// ** 個人寄付備考 */
        sheet0.setKojinKifuBikou("備考");
        /// ** 特定寄付合計 */
        sheet0.setTokuteiKifuGoukei(30000L);
        /// ** うち特定寄付備考 */
        sheet0.setTokuteiKifuBikou("備考");
        /// ** 法人寄付合計 */
        sheet0.setHoujinKifuGoukei(30000L);
        /// ** 法人寄付備考 */
        sheet0.setHoujinKifuBiko("備考");
        /// ** 政治団体寄付合計 */
        sheet0.setSeijiDantaiKifuGoukei(30000L);
        /// ** 政治団体寄付備考 */
        sheet0.setSeijiDantaiKifuBikou("備考");
        /// ** 寄付小計合計 */
        sheet0.setKifuShoukeiGoukei(30000L);
        /// ** 寄付小計合計備考 */
        sheet0.setKifuShoukeiBikou("備考");
        /// ** 寄付のうちあっせんによるもの合計 */
        sheet0.setAssenGoukei(30000L);
        /// ** 寄付のうちあっせんによるもの合計備考 */
        sheet0.setAssenBikou("備考");
        /// ** 政党匿名寄付の合計 */
        sheet0.setTokumeiKifuGoukei(30000L);
        /// ** 政党匿名寄付の合計備考 */
        sheet0.setTokumeiKifuBikou("備考");
        /// ** 寄付総合計 */
        sheet0.setKifuSoGoukei(30000L);
        /// ** 寄付総合計備考 */
        sheet0.setKifuSoGoukeiBikou("備考");

        String xml0 = xmlMapper.writeValueAsString(sheet0);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_070200_base.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
    }

}
