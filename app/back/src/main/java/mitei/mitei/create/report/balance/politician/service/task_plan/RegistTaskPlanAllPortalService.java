package mitei.mitei.create.report.balance.politician.service.task_plan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2024Entity;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;

/**
 * 発生年別にあわせてタスクを登録するService
 */
@Service
public class RegistTaskPlanAllPortalService {

    /** 2024年用Service */
    @Autowired
    private RegistTaskPlan2024Service registTaskPlan2024Service;

    /** 2025年用Service */
    @Autowired
    private RegistTaskPlan2025Service registTaskPlan2025Service;

    /**
     * 発生年に関わらず登録を行う
     *
     * @param list タスク予定リスト
     * @return 登録結果
     */
    public TemplateFrameworkResultDto practice(final List<TaskPlanInterface> list) {

        if(Objects.isNull(list)) {
            throw new IllegalArgumentException("タスク計画リストテーブルがnullです");//限りなく実装ミスを摘出している
        }
        
        TemplateFrameworkResultDto resultDto;
        if(list.isEmpty()) {
            //ユーザさんがタスク計上しなければ0件リストは極めて正常
            resultDto = new TemplateFrameworkResultDto();
            resultDto.setIsOk(true);
            return resultDto;
        }

        int year = LocalDate.now().getYear();

        switch (year) {
        // 2024年
        case 2024: // CHECKSTYLE:OFF MagicNumber
            resultDto = registTaskPlan2024Service.practice(this.convert2024(list));
            resultDto.setMessage("2024");// しばらくどのテーブルに挿入した検証用として代入する TODO 不要になったら削除する
            break;
        // 2025年
        case 2025: // CHECKSTYLE:OFF MagicNumber
            resultDto = registTaskPlan2025Service.practice(this.convert2025(list));
            resultDto.setMessage("2025");// しばらくどのテーブルに挿入した検証用として代入する TODO 不要になったら削除する
            break;
        default:
            throw new IllegalArgumentException("Unexpected value: " + year);
        }
        return resultDto;
    }

    private List<TaskPlan2024Entity> convert2024(final List<TaskPlanInterface> list) {

        List<TaskPlan2024Entity> listChanged = new ArrayList<>();

        TaskPlan2024Entity entity;
        for (TaskPlanInterface impl : list) {
            entity = new TaskPlan2024Entity(); // NOPMD
            // 全プロパティをInterface化＝すべてのプロパティがコピー
            BeanUtils.copyProperties(impl, entity);
            listChanged.add(entity);
        }

        return listChanged;
    }

    private List<TaskPlan2025Entity> convert2025(final List<TaskPlanInterface> list) {

        List<TaskPlan2025Entity> listChanged = new ArrayList<>();

        TaskPlan2025Entity entity;
        for (TaskPlanInterface impl : list) {
            entity = new TaskPlan2025Entity(); // NOPMD
            // 全プロパティをInterface化＝すべてのプロパティがコピー
            BeanUtils.copyProperties(impl, entity);
            listChanged.add(entity);
        }

        return listChanged;
    }

}
