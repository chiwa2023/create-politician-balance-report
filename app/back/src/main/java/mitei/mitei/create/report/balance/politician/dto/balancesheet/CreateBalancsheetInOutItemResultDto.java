package mitei.mitei.create.report.balance.politician.dto.balancesheet;

import java.io.Serializable;
import java.util.List;

import mitei.mitei.create.report.balance.politician.dto.calling_item.CallingItemDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;

/**
 * 生成した政治資金収支報告書収入・支出項目リストDto
 */
public class CreateBalancsheetInOutItemResultDto extends TemplateFrameworkResultDto implements Serializable{ // NOPMD DataClass

    /** SerializableId */
    private static final long serialVersionUID = 1L;

    /** 収入項目リスト */
    private List<BalancesheetIncome2025Entity> listIncome;

    /** 支出項目リスト */
    private List<BalancesheetOutcome2025Entity> listOutcome;

    /** 結びつけ項目検索結果リスト */
    private List<CallingItemDto> listCallingItem;
    
    /**
     * 収入項目リストを取得する
     *
     * @return 収入項目リスト
     */
    public List<BalancesheetIncome2025Entity> getListIncome() {
        return listIncome;
    }

    /**
     * 収入項目リストを設定する
     *
     * @param listIncome 収入項目リスト
     */
    public void setListIncome(final List<BalancesheetIncome2025Entity> listIncome) {
        this.listIncome = listIncome;
    }

    /**
     * 支出項目リストを取得する
     *
     * @return 支出項目リスト
     */
    public List<BalancesheetOutcome2025Entity> getListOutcome() {
        return listOutcome;
    }

    /**
     * 支出項目リストを設定する
     *
     * @param listOutcome 支出項目リスト
     */
    public void setListOutcome(final List<BalancesheetOutcome2025Entity> listOutcome) {
        this.listOutcome = listOutcome;
    }

    /**
     * 結びつけ項目検索結果マップを取得する
     *
     * @return 結びつけ項目検索結果マップ
     */
    public List<CallingItemDto> getListCallingItem() {
        return listCallingItem;
    }

    /**
     * 結びつけ項目検索結果マップを設定する
     *
     * @param listCallingItem 結びつけ項目検索結果マップ
     */
    public void setListCallingItem(final List<CallingItemDto> listCallingItem) {
        this.listCallingItem = listCallingItem;
    }
    
}
