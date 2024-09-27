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
 * Sheet071300ListOfExpenditureItemsDto単体テスト
 */
class Sheet071300ListOfExpenditureItemsDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD ExcessiveMethodLength

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 一種類のみ
        Sheet071300ListOfExpenditureItemsDto sheet0 = new Sheet071300ListOfExpenditureItemsDto();
        /// ** 人件費項目の合計 */
        sheet0.setGoukeiJinkenhi("3000");
        /// ** 人件費の供与した交付金に係る支出 */
        sheet0.setKohfuJinkenhi("400");
        /// ** 人件費の備考 */
        sheet0.setBikouJinkenhi("備考");
        /// ** 光熱費項目の合計 */
        sheet0.setGoukeiKohnetsuhi("3000");
        /// ** 光熱費の供与した交付金に係る支出 */
        sheet0.setKohfuKohnetsuhi("400");
        /// ** 光熱費の備考 */
        sheet0.setBikouKohnetsuhi("備考");
        /// ** 備品項目の合計 */
        sheet0.setGoukeiBihinhi("3000");
        /// ** 備品の供与した交付金に係る支出 */
        sheet0.setKohfuBihinhi("400");
        /// ** 備品の備考 */
        sheet0.setBikouBihinhi("備考");
        /// ** 事務所項目の合計 */
        sheet0.setGoukeiJimushohi("3000");
        /// ** 事務所の供与した交付金に係る支出 */
        sheet0.setKohfuJimushohi("400");
        /// ** 事務所の備考 */
        sheet0.setBikouJimushohi("備考");
        /// ** 経費項目の合計 */
        sheet0.setGoukeiKeihiShoukei(3000L);
        /// ** 経費の供与した交付金に係る支出 */
        sheet0.setKohfuKeihiShoukei(400L);
        /// ** 経費の備考 */
        sheet0.setBikouKeihiShoukei("備考");
        /// ** 組織活動費項目の合計 */
        sheet0.setGoukeiSoshikiKatsudouhi(3000L);
        /// ** 組織活動費の供与した交付金に係る支出 */
        sheet0.setKohfuSoshikiKatsudouhi("400");
        /// ** 組織活動費の備考 */
        sheet0.setBikouSoshikiKatsudouhi("備考");
        /// ** 選挙活動費項目の合計 */
        sheet0.setGoukeiSenkyoKatsudou(3000L);
        /// ** 選挙活動費の供与した交付金に係る支出 */
        sheet0.setKohfuSenkyoKatsudou("400");
        /// ** 選挙活動費の備考 */
        sheet0.setBikouSenkyoKatsudou("備考");
        /// ** その他項目の合計 */
        sheet0.setGoukeiSonota(3000L);
        /// ** その他の供与した交付金に係る支出 */
        sheet0.setKohfuSonota(400L);
        /// ** その他の備考 */
        sheet0.setBikouSonota("備考");
        /// ** 機関誌発行項目の合計 */
        sheet0.setGoukeiHakkou(3000L);
        /// ** 機関誌発行の供与した交付金に係る支出 */
        sheet0.setKohfuHakkou("400");
        /// ** 機関誌発行の備考 */
        sheet0.setBikouHakkou("備考");
        /// ** 宣伝費項目の合計 */
        sheet0.setGoukeiSenden(3000L);
        /// ** 宣伝費の供与した交付金に係る支出 */
        sheet0.setKohfuSenden("400");
        /// ** 宣伝費の備考 */
        sheet0.setBikouSenden("備考");
        /// ** 政治資金パーティ開催項目の合計 */
        sheet0.setGoukeiKaisaiPty(3000L);
        /// ** 政治資金パーティ開催の供与した交付金に係る支出 */
        sheet0.setKohfuKaisaiPty("400");
        /// ** 政治資金パーティ開催の備考 */
        sheet0.setBikouKaisaiPty("備考");
        /// ** その他事業費項目の合計 */
        sheet0.setGoukeiSonotaJigyou(3000L);
        /// ** その他事業費の供与した交付金に係る支出 */
        sheet0.setKohfuSonotaJigyou("400");
        /// ** その他事業費の備考 */
        sheet0.setBikouSonotaJigyou("備考");
        /// ** 調査研究費項目の合計 */
        sheet0.setGoukeiChousaKenkyu(3000L);
        /// ** 調査研究費の供与した交付金に係る支出 */
        sheet0.setKohfuChousaKenkyu("400");
        /// ** 調査研究費の備考 */
        sheet0.setBikouChousaKenkyu("備考");
        /// ** 寄付金項目の合計 */
        sheet0.setGoukeiKifukin(3000L);
        /// ** 寄付金の供与した交付金に係る支出 */
        sheet0.setKohfuKifukin("400");
        /// ** 寄付金の備考 */
        sheet0.setBikouKifukin("備考");
        /// ** その他の経費項目の合計 */
        sheet0.setGoukeiSonotaKeihi(3000L);
        /// ** その他の経費の供与した交付金に係る支出 */
        sheet0.setKohfuSonotaKeihi("400");
        /// ** その他の経費の備考 */
        sheet0.setBikouSonotaKeihi("備考");
        /// ** 活動費小計の合計 */
        sheet0.setGoukeiKatsudouhi(3000L);
        /// ** 活動費小計の供与した交付金に係る支出 */
        sheet0.setKohfuKatsudouhi(400L);
        /// ** 活動費小計の備考 */
        sheet0.setBikouKatsudouhi("備考");
        /// ** 現計合計 */
        sheet0.setGoukeiZenGohkei(90000L);

        String xml0 = xmlMapper.writeValueAsString(sheet0);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_071300_base.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);

    }

}
