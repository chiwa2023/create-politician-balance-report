import CheckSendBalancesheetInterface from "../../../../dto/checkSendBalancesheetDto";
import CheckSendBalancesheetDto from "../../../../dto/checkSendBalancesheetDto";
import convertTimestampText from "../../../util/convertTimestampText";

export default function mockGetCheckSendBalancesheetDto():CheckSendBalancesheetInterface{

    const dto:CheckSendBalancesheetInterface = new CheckSendBalancesheetDto();
    dto.submissionYear = 2021;
    dto.publishTimestamp = new Date(2022,3,4,12,23,34);
    dto.publishTimestampText = convertTimestampText(dto.publishTimestamp);
    dto.publishXmlPath = "test_data/syuushi_least.xml";

    return dto;
}