package mitei.mitei.create.report.balance.politician.trial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.SelectOptionDto;

/**
 * テストデータ生成
 */
@Component
public class MakeTrialTestDataLogic {

    /**
     * テストデータ生成
     *
     * @return リスト
     */
    public List<SelectOptionDto> practice() {

        SelectOptionDto dto1 = new SelectOptionDto();
        dto1.setValue("1");
        dto1.setText("one");

        SelectOptionDto dto2 = new SelectOptionDto();
        dto2.setValue("2");
        dto2.setText("two");

        List<SelectOptionDto> list = new ArrayList<>();
        list.add(dto1);
        list.add(dto2);

        return list;
    }
}
