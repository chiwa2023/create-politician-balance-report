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
 * AllSheet0709AnonymousInPoliticalPartyDto単体テスト
 */
class AllSheet0709AnonymousInPoliticalPartyDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD
        AllSheet0709AnonymousInPoliticalPartyDto allSheet0709AnonymousInPoliticalPartyDto = new AllSheet0709AnonymousInPoliticalPartyDto();
        
        
        Sheet070900AnonymousInPoliticalPartyDto sheet1 = new Sheet070900AnonymousInPoliticalPartyDto();
        sheet1.setPageTotal(30000L);

        //すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070900AnonymousInPoliticalPartyDto row0 = new Row070900AnonymousInPoliticalPartyDto();
        
        ///** 連番 */
        row0.setIchirenNo(1);
        ///** 場所 */
        row0.setBasho("開催場所");
        ///** 金額 */
        row0.setKingaku(30000L);
        ///** 発生日 */
        row0.setDate("R4/3/1");
        ///** 備考 */
        row0.setBiko("備考");

        sheet1.getList().add(row0);

        allSheet0709AnonymousInPoliticalPartyDto.setSheet070900AnonymousInPoliticalPartyDto(sheet1);        
        
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        String xml0 = xmlMapper.writeValueAsString(allSheet0709AnonymousInPoliticalPartyDto);
        
        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0709.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);

    }

}
