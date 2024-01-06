package mitei.mitei.create.report.balance.politician.dto.publish; // NOPMD

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
 * AllSheet0718AssetsDto単体テスト
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
class AllSheet0718AssetsDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0718AssetsDto allSheet0718AssetsDto = new AllSheet0718AssetsDto();

        /**
         * その1
         */
        AllSheetKbn071801Dto allSheetKbn071801Dto = new AllSheetKbn071801Dto();

        Sheet071801LandAmongAssetsDto sheet1 = new Sheet071801LandAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row1 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row1.setIchirenNo(1);
        /// ** 摘要 */
        row1.setTekiyou("摘要");
        /// ** 金額 */
        row1.setKingaku(30000L);
        /// ** 発生日 */
        row1.setDate("R4/12/1");
        /// ** 備考 */
        row1.setBiko("備考");

        sheet1.getList().add(row1);

        allSheetKbn071801Dto.setSheet071801LandAmongAssetsDto(sheet1);

        /**
         * その2
         */
        AllSheetKbn071802Dto allSheetKbn071802Dto = new AllSheetKbn071802Dto();

        Sheet071802BuildingsAmongAssetsDto sheet2 = new Sheet071802BuildingsAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row2 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row2.setIchirenNo(1);
        /// ** 摘要 */
        row2.setTekiyou("摘要");
        /// ** 金額 */
        row2.setKingaku(30000L);
        /// ** 発生日 */
        row2.setDate("R4/12/1");
        /// ** 備考 */
        row2.setBiko("備考");

        sheet2.getList().add(row2);

        allSheetKbn071802Dto.setSheet071802BuildingsAmongAssetsDto(sheet2);

        /**
         * その3
         */
        AllSheetKbn071803Dto allSheetKbn071803Dto = new AllSheetKbn071803Dto();

        Sheet071803SurfaceRightsAmongAssetsDto sheet3 = new Sheet071803SurfaceRightsAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row3 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row3.setIchirenNo(1);
        /// ** 摘要 */
        row3.setTekiyou("摘要");
        /// ** 金額 */
        row3.setKingaku(30000L);
        /// ** 発生日 */
        row3.setDate("R4/12/1");
        /// ** 備考 */
        row3.setBiko("備考");

        sheet3.getList().add(row3);

        allSheetKbn071803Dto.setSheet071803SurfaceRightsAmongAssetsDto(sheet3);

        /**
         * その4
         */
        AllSheetKbn071804Dto allSheetKbn071804Dto = new AllSheetKbn071804Dto();

        Sheet071804MovablesAmongAssetsDto sheet4 = new Sheet071804MovablesAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row4 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row4.setIchirenNo(1);
        /// ** 摘要 */
        row4.setTekiyou("摘要");
        /// ** 金額 */
        row4.setKingaku(30000L);
        /// ** 発生日 */
        row4.setDate("R4/12/1");
        /// ** 備考 */
        row4.setBiko("備考");

        sheet4.getList().add(row4);

        allSheetKbn071804Dto.setSheet071804MovablesAmongAssetsDto(sheet4);

        /**
         * その5
         */
        AllSheetKbn071805Dto allSheetKbn071805Dto = new AllSheetKbn071805Dto();

        Sheet071805SavingsAmmongAssetsDto sheet5 = new Sheet071805SavingsAmmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row5 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row5.setIchirenNo(1);
        /// ** 摘要 */
        row5.setTekiyou("摘要");
        /// ** 金額 */
        row5.setKingaku(30000L);
        /// ** 発生日 */
        row5.setDate("R4/12/1");
        /// ** 備考 */
        row5.setBiko("備考");

        sheet5.getList().add(row5);

        allSheetKbn071805Dto.setSheet071805SavingsAmmongAssetsDto(sheet5);

        /**
         * その6
         */
        AllSheetKbn071806Dto allSheetKbn071806Dto = new AllSheetKbn071806Dto();

        Sheet071806TrustAmongAssetsDto sheet6 = new Sheet071806TrustAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row6 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row6.setIchirenNo(1);
        /// ** 摘要 */
        row6.setTekiyou("摘要");
        /// ** 金額 */
        row6.setKingaku(30000L);
        /// ** 発生日 */
        row6.setDate("R4/12/1");
        /// ** 備考 */
        row6.setBiko("備考");

        sheet6.getList().add(row6);

        allSheetKbn071806Dto.setSheet071806TrustAmongAssetsDto(sheet6);

        /**
         * その7
         */
        AllSheetKbn071807Dto allSheetKbn071807Dto = new AllSheetKbn071807Dto();

        Sheet071807SecuritiesAmongAssetsDto sheet7 = new Sheet071807SecuritiesAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row7 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row7.setIchirenNo(1);
        /// ** 摘要 */
        row7.setTekiyou("摘要");
        /// ** 金額 */
        row7.setKingaku(30000L);
        /// ** 発生日 */
        row7.setDate("R4/12/1");
        /// ** 備考 */
        row7.setBiko("備考");

        sheet7.getList().add(row7);

        allSheetKbn071807Dto.setSheet071807SecuritiesAmongAssetsDto(sheet7);

        /**
         * その8
         */
        AllSheetKbn071808Dto allSheetKbn071808Dto = new AllSheetKbn071808Dto();

        Sheet071808InvestmentAmongAssetsDto sheet8 = new Sheet071808InvestmentAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row8 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row8.setIchirenNo(1);
        /// ** 摘要 */
        row8.setTekiyou("摘要");
        /// ** 金額 */
        row8.setKingaku(30000L);
        /// ** 発生日 */
        row8.setDate("R4/12/1");
        /// ** 備考 */
        row8.setBiko("備考");

        sheet8.getList().add(row8);

        allSheetKbn071808Dto.setSheet071808InvestmentAmongAssetsDto(sheet8);

        /**
         * その9
         */
        AllSheetKbn071809Dto allSheetKbn071809Dto = new AllSheetKbn071809Dto();

        Sheet071809LoanAmongAssetsDto sheet9 = new Sheet071809LoanAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row9 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row9.setIchirenNo(1);
        /// ** 摘要 */
        row9.setTekiyou("摘要");
        /// ** 金額 */
        row9.setKingaku(30000L);
        /// ** 発生日 */
        row9.setDate("R4/12/1");
        /// ** 備考 */
        row9.setBiko("備考");

        sheet9.getList().add(row9);

        allSheetKbn071809Dto.setSheet071809LoanAmongAssetsDto(sheet9);

        /**
         * その10
         */
        AllSheetKbn071810Dto allSheetKbn071810Dto = new AllSheetKbn071810Dto();

        Sheet071810DepositAmongAssetsDto sheet10 = new Sheet071810DepositAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row10 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row10.setIchirenNo(1);
        /// ** 摘要 */
        row10.setTekiyou("摘要");
        /// ** 金額 */
        row10.setKingaku(30000L);
        /// ** 発生日 */
        row10.setDate("R4/12/1");
        /// ** 備考 */
        row10.setBiko("備考");

        sheet10.getList().add(row10);

        allSheetKbn071810Dto.setSheet071810DepositAmongAssetsDto(sheet10);

        /**
         * その11
         */
        AllSheetKbn071811Dto allSheetKbn071811Dto = new AllSheetKbn071811Dto();

        Sheet071811FacilityUsageRightsAmongAssetsDto sheet11 = new Sheet071811FacilityUsageRightsAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row11 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row11.setIchirenNo(1);
        /// ** 摘要 */
        row11.setTekiyou("摘要");
        /// ** 金額 */
        row11.setKingaku(30000L);
        /// ** 発生日 */
        row11.setDate("R4/12/1");
        /// ** 備考 */
        row11.setBiko("備考");

        sheet11.getList().add(row11);

        allSheetKbn071811Dto.setSheet071811FacilityUsageRightsAmongAssetsDto(sheet11);

        /**
         * その12
         */
        AllSheetKbn071812Dto allSheetKbn071812Dto = new AllSheetKbn071812Dto();

        Sheet071812BorrowingsAmongAssetsDto sheet12 = new Sheet071812BorrowingsAmongAssetsDto();

        // すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row071800ClassificationOfAssetsByItemDto row12 = new Row071800ClassificationOfAssetsByItemDto();
        /// ** 連番 */
        row12.setIchirenNo(1);
        /// ** 摘要 */
        row12.setTekiyou("摘要");
        /// ** 金額 */
        row12.setKingaku(30000L);
        /// ** 発生日 */
        row12.setDate("R4/12/1");
        /// ** 備考 */
        row12.setBiko("備考");

        sheet12.getList().add(row12);

        allSheetKbn071812Dto.setSheet071812BorrowingsAmongAssetsDto(sheet12);

        allSheet0718AssetsDto.setAllSheetKbn071801Dto(allSheetKbn071801Dto);
        allSheet0718AssetsDto.setAllSheetKbn071802Dto(allSheetKbn071802Dto);
        allSheet0718AssetsDto.setAllSheetKbn071803Dto(allSheetKbn071803Dto);
        allSheet0718AssetsDto.setAllSheetKbn071804Dto(allSheetKbn071804Dto);
        allSheet0718AssetsDto.setAllSheetKbn071805Dto(allSheetKbn071805Dto);
        allSheet0718AssetsDto.setAllSheetKbn071806Dto(allSheetKbn071806Dto);
        allSheet0718AssetsDto.setAllSheetKbn071807Dto(allSheetKbn071807Dto);
        allSheet0718AssetsDto.setAllSheetKbn071808Dto(allSheetKbn071808Dto);
        allSheet0718AssetsDto.setAllSheetKbn071809Dto(allSheetKbn071809Dto);
        allSheet0718AssetsDto.setAllSheetKbn071810Dto(allSheetKbn071810Dto);
        allSheet0718AssetsDto.setAllSheetKbn071811Dto(allSheetKbn071811Dto);
        allSheet0718AssetsDto.setAllSheetKbn071812Dto(allSheetKbn071812Dto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml1 = xmlMapper.writeValueAsString(allSheet0718AssetsDto);

        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0718.txt");
        String answer1 = Files.readString(pathAnswer1);

        assertThat(xml1).isEqualTo(answer1);

    }

}
