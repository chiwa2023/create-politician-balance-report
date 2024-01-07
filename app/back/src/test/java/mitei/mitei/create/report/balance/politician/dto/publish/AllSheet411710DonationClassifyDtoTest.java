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
 * AllSheet411710DonationClassifyDto単体テスト
 */
class AllSheet411710DonationClassifyDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet411710DonationClassifyDto allSheet411710DonationClassifyDto = new AllSheet411710DonationClassifyDto();

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

        allSheet411710DonationClassifyDto.setSheet411710DonationClassifyDto(sheet1);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allSheet411710DonationClassifyDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_4117.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);

    }

}
