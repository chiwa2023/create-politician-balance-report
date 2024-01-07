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
 * Sheet411710DonationClassifyDto単体テスト
 */
class Sheet411710DonationClassifyDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception {

        Sheet411710DonationClassifyDto sheet1 = new Sheet411710DonationClassifyDto();
        sheet1.setKubun(1);

        RowSozei411713SupportingMembersParliamentDto row1 = new RowSozei411713SupportingMembersParliamentDto();
        row1.setGiinName("国会議員姓名");

        RowSozei411714SupportingLocalLegislatorsDto row2 = new RowSozei411714SupportingLocalLegislatorsDto();
        row2.setName("選挙立候補者");
        row2.setSenkyo("市議会議員選挙");
        row2.setDate("R4/12/1");

        sheet1.setRowSozei411713SupportingMembersParliamentDto(row1);
        sheet1.setRowSozei411714SupportingLocalLegislatorsDto(row2);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // リスト存在
        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/sheet_411710_list.txt");
        String answer1 = Files.readString(pathAnswer1);

        String xml1 = xmlMapper.writeValueAsString(sheet1);

        assertThat(xml1).isEqualTo(answer1);

    }

}
