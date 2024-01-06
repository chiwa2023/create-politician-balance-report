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
 * AllSheet0719RealEstateDto単体テスト
 */
class AllSheet0719RealEstateDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0719RealEstateDto allSheet0719RealEstateDto = new AllSheet0719RealEstateDto();

        // その1
        Sheet071900RealEstateDto sheet1 = new Sheet071900RealEstateDto();
        sheet1.setKbnRealEstitate(1);

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071900CurrentStatusOfRealEstateUseDto row1 = new Row071900CurrentStatusOfRealEstateUseDto();
        /// ** 連番 */
        row1.setIchirenNo(1);
        /// ** 摘要 */
        row1.setTekiyou("摘要");
        /// ** 用途 */
        row1.setYouto("用途");
        /// ** 使用者と代表者との関係 */
        row1.setKankeiShiyousha("使用者との関係");
        /// ** 使用の用途 */
        row1.setShiyouYouto("使用の用途");
        /// ** 使用面積 */
        row1.setShiyouMenseki("123.45");
        /// ** 使用価格 */
        row1.setShiyouKakaku(4444L);

        sheet1.getList().add(row1);

        // その3
        Sheet071900RealEstateDto sheet2 = new Sheet071900RealEstateDto();
        sheet2.setKbnRealEstitate(2);

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071900CurrentStatusOfRealEstateUseDto row2 = new Row071900CurrentStatusOfRealEstateUseDto();
        /// ** 連番 */
        row2.setIchirenNo(1);
        /// ** 摘要 */
        row2.setTekiyou("摘要");
        /// ** 用途 */
        row2.setYouto("用途");
        /// ** 使用者と代表者との関係 */
        row2.setKankeiShiyousha("使用者との関係");
        /// ** 使用の用途 */
        row2.setShiyouYouto("使用の用途");
        /// ** 使用面積 */
        row2.setShiyouMenseki("123.45");
        /// ** 使用価格 */
        row2.setShiyouKakaku(4444L);

        sheet2.getList().add(row2);

        // その3
        Sheet071900RealEstateDto sheet3 = new Sheet071900RealEstateDto();
        sheet3.setKbnRealEstitate(3);

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071900CurrentStatusOfRealEstateUseDto row3 = new Row071900CurrentStatusOfRealEstateUseDto();
        /// ** 連番 */
        row3.setIchirenNo(1);
        /// ** 摘要 */
        row3.setTekiyou("摘要");
        /// ** 用途 */
        row3.setYouto("用途");
        /// ** 使用者と代表者との関係 */
        row3.setKankeiShiyousha("使用者との関係");
        /// ** 使用の用途 */
        row3.setShiyouYouto("使用の用途");
        /// ** 使用面積 */
        row3.setShiyouMenseki("123.45");
        /// ** 使用価格 */
        row3.setShiyouKakaku(4444L);

        sheet3.getList().add(row3);

        allSheet0719RealEstateDto.getListSheet0719().add(sheet1);
        allSheet0719RealEstateDto.getListSheet0719().add(sheet2);
        allSheet0719RealEstateDto.getListSheet0719().add(sheet3);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml1 = xmlMapper.writeValueAsString(allSheet0719RealEstateDto);

        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0719.txt");
        String answer1 = Files.readString(pathAnswer1);

        assertThat(xml1).isEqualTo(answer1);
    }

}
