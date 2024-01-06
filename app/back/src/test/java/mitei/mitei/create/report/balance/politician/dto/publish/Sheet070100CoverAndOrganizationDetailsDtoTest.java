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
 * Sheet070100CoverAndOrganizationDetailsDto単体テスト
 */
class Sheet070100CoverAndOrganizationDetailsDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD ExcessiveMethodLength

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 一種類のみ
        Sheet070100CoverAndOrganizationDetailsDto sheet0 = new Sheet070100CoverAndOrganizationDetailsDto();
        ///** 報告年 */
        sheet0.setHoukokuNen(2022);
        ///** 開催年月日 */
        sheet0.setDateKaisai("R4/12/1");
        ///** 政治団体名称 */
        sheet0.setDantaiName("サンプル政治団体");
        ///** 政治団体名称かな */
        sheet0.setDantaiNameKana("さんぷるせいじだんたい");
        ///** 事務所の住所 */
        sheet0.setJimushoJusho("東京都千代田区");
        ///** 事務所の住所建物 */
        sheet0.setJimushoJushoTatemono("建物方書");
        ///** 代表者の姓 */
        sheet0.setDaihyoushaNameLast("代表者の姓");
        ///** 代表者の名 */
        sheet0.setDaihyoushaNameFirst("代表者の名");
        ///** 会計責任者の姓 */
        sheet0.setKaikeiSekinnshaNameLast("会計責任者の姓");
        ///** 会計責任者の名 */
        sheet0.setKaikeiSekinnshaNameFirst("会計責任者の名");
        ///** 事務担当者1の姓 */
        sheet0.setJimuTantousha1NameLast("事務担当者1の姓");
        ///** 事務担当者1の名 */
        sheet0.setJimuTantousha1NameFirst("事務担当者1の名");
        ///** 事務担当者1の電話番号 */
        sheet0.setJimuTantousha1Tel("000-0000-0000");
        ///** 事務担当者2の姓 */
        sheet0.setJimuTantousha2NameLast("事務担当者2の姓");
        ///** 事務担当者2の名 */
        sheet0.setJimuTantousha2NameFirst("事務担当者1の名");
        ///** 事務担当者2の電話番号 */
        sheet0.setJimuTantousha2Tel("111-1111-1111");
        ///** 事務担当者3の姓 */
        sheet0.setJimuTantousha3NameLast("事務担当者3の姓");
        ///** 事務担当者3の名 */
        sheet0.setJimuTantousha3NameFirst("事務担当者3の名");
        ///** 事務担当者3の電話番号 */
        sheet0.setJimuTantousha3Tel("222-2222-2222");
        ///** 団体区分 */
        sheet0.setDantaiKbn("05");
        ///**　活動区域区分 */
        sheet0.setKatsudouKuikiKbn(1);
        ///** 資金管理団体の有無 */
        sheet0.setUmuShikinKanrenDantai(1);
        ///** 公職の名称 */
        sheet0.setKoushokuName("国会議員");
        ///** 現職候補者の別 */
        sheet0.setKoushokuGenKouho(1);
        ///** 資金管理団体の設立者の姓 */
        sheet0.setShikinDaihyouName1("資金管理団体設立者の姓");
        ///** 資金管理団体の設立者の名 */
        sheet0.setShikinDaihyouName2("資金管理団体設立者の名");
        ///** 資金管理団体の指定期間(開始) */
        sheet0.setKanriDantaiPeriodStart("R4/1/1");
        ///** 資金管理団体の指定期間(終了) */
        sheet0.setKanriDantaiPeriodEnd("R4/12/1");
        ///** 資金管理団体の複数指定期間 */
        sheet0.setKanriDantaiPeriodRest("R4/1/1-R4/2/1、R4/3/1-R4/4/1");
        ///** 国会議員関連団体区分*/
        sheet0.setKokkaiGiinDantaiKbn(1);
        ///** 国家議員1の姓 */
        sheet0.setKokkaiGiin1NameLast("公職者の姓");
        ///** 国家議員1の名 */
        sheet0.setKokkaiGiin1NameFirst("公職者の名");
        ///** 国家議員1の公職(衆参)*/
        sheet0.setKokkaiGiin1ShuuSan("衆議院");
        ///** 国家議員1現職と候補者の別 */
        sheet0.setKokkaiGiin1GenKouho(1);
        ///** 国会議員関係団体の特例適用期間(開始) */
        sheet0.setGiinDantantaiTokureiPeriodStart("R4/1/1");
        ///** 国会議員関係団体の特例適用期間(終了) */
        sheet0.setGiinDantantaiTokureiPeriodEnd("R4/1/1");
        ///** 国会議員関係団体の複数特例適用期間 */
        sheet0.setGiinDantantaiTokureiPeriodRest("R4/1/1-R4/2/1、R4/3/1-R4/4/1");
        ///** 国家議員2の姓 */
        sheet0.setKokkaiGiin2NameLast("国会議員1の姓");
        ///** 国家議員2の名 */
        sheet0.setKokkaiGiin2NameFirst("国会議員1の名");
        ///** 国家議員2の公職(衆参)*/
        sheet0.setKokkaiGiin2ShuuSan("衆議院");
        ///** 国家議員2現職と候補者の別 */
        sheet0.setKokkaiGiin2GenKouho(1);
        ///** 国家議員3の姓 */
        sheet0.setKokkaiGiin3NameLast("国会議員2の姓");
        ///** 国家議員3の姓 */
        sheet0.setKokkaiGiin3NameFirst("国会議員2の名");
        ///** 国家議員3の公職(衆参)*/
        sheet0.setKokkaiGiin3ShuuSan("衆議院");
        ///** 国家議員3現職と候補者の別 */
        sheet0.setKokkaiGiin3GenKouho(1);
        
        String xml0 = xmlMapper.writeValueAsString(sheet0);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_070100_base.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);
        
    }

}
