package mitei.mitei.create.report.balance.politician.dto.balancesheet;

import java.io.Serializable;
import java.util.List;

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;

/**
 * 収支報告書に登録するリストDto
 */
public class RegistBalancesheetInOutCapsuleDto extends TemplateFrameworkCapsuleDto implements Serializable { // NOPMD DataClass

    /** SerializableId */
    private static final long serialVersionUID = 1L;

    /** 収入項目リスト */
    private List<BalancesheetIncome2025Entity> listIncome;

    /** 支出項目リスト */
    private List<BalancesheetOutcome2025Entity> listOutcome;

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

}
