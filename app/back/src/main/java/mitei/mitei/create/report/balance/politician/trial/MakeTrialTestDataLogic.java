package mitei.mitei.create.report.balance.politician.trial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.SelectOptionDto;

@Component
public class MakeTrialTestDataLogic {

	public List<SelectOptionDto> practice() {
        List<SelectOptionDto> list = new ArrayList<>();
        
        SelectOptionDto dto1 = new SelectOptionDto();
        dto1.setValue("1");
        dto1.setText("one");

        SelectOptionDto dto2 = new SelectOptionDto();
        dto2.setValue("2");
        dto2.setText("two");

        list.add(dto1);
        list.add(dto2);

        return list;
	}
}
