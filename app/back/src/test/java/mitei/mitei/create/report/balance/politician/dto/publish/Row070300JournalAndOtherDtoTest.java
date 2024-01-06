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
 * RowJournalAndOthrt0703Dto単体テスト
 */
class Row070300JournalAndOtherDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml()throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); 

        Path pathAnswer = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "dto/publish/row_070300.txt");
        String answer = Files.readString(pathAnswer);
        
        //すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070300JournalAndOtherDto row0 = new Row070300JournalAndOtherDto();
        row0.setIchirenNo(1);
        row0.setJigyoNoShurui("機関誌発行");
        row0.setKingaku(30000L);
        row0.setBiko("備考");
        
        //XML生成
        String xml = xmlMapper.writeValueAsString(row0);
        
        //Dto名がXMLルートに入っているがワークシートで利用するときに<ROW>で上書き
        assertThat(xml).isEqualTo(answer);
    }

}
