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
 * Row070400BorrowedMoneyDto単体テスト
 */
class Row070400BorrowedMoneyDtoTest {

    @Test
    void testConvretXml()throws Exception {
        // CHECKSTYLE:OFF MagicNumber

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); 

        Path pathAnswer = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "dto/publish/row_070400.txt");
        String answer = Files.readString(pathAnswer);
        
        //すべてにデータが入っている場合。データ欠損などは作成Logicでの対応が必要
        Row070400BorrowedMoneyDto row0 = new Row070400BorrowedMoneyDto();
   
        ///** 連番 */
        row0.setIchirenNo(1);
        ///** 借り先 */
        row0.setKarisaki("借入先");
        ///** 金額 */
        row0.setKingaku(30000L);
        ///** 備考 */
        row0.setBiko("備考");
        
        //XML生成
        String xml = xmlMapper.writeValueAsString(row0);
        
        //Dto名がXMLルートに入っているがワークシートで利用するときに<ROW>で上書き
        assertThat(xml).isEqualTo(answer);
    }

}
