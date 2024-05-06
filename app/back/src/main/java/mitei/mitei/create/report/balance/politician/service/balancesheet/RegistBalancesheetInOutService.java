package mitei.mitei.create.report.balance.politician.service.balancesheet;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.repository.BalancesheetIncome2025Repository;
import mitei.mitei.create.report.balance.politician.repository.BalancesheetOutcome2025Repository;

/**
 * 収支項目リストと支出項目リストを一括新規登録する
 */
@Service
public class RegistBalancesheetInOutService {

    /** 収支報告書収入項目Repository */
    @Autowired
    private BalancesheetIncome2025Repository balancesheetIncome2025Repository;

    /** 収支報告書支出項目Repository */
    @Autowired
    private BalancesheetOutcome2025Repository balancesheetOutcome2025Repository;

    /**
     * 収支項目リストと支出項目リストを一括新規登録する
     *
     * @param capsuleDto 収支項目リストと支出項目リスト
     * @return 更新行数
     */
    public int practice(final RegistBalancesheetInOutCapsuleDto capsuleDto) {

        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

        return this.registIncome(capsuleDto.getListIncome(), timestampNow)
                + this.registOutcome(capsuleDto.getListOutcome(), timestampNow);
    }

    private int registIncome(final List<BalancesheetIncome2025Entity> listIncome, final Timestamp timestamp) {

        //同一識別コード最大値を取得
        Long code = 0L;
        Optional<BalancesheetIncome2025Entity> optional = balancesheetIncome2025Repository
                .findFirstByOrderByBalancesheetIncomeCodeDesc();
        if (optional.isPresent()) {
            code = optional.get().getBalancesheetIncomeCode();
        }

        // 登録時に必要な情報を更新
        for (BalancesheetIncome2025Entity entity : listIncome) {
            code++;
            entity.setBalancesheetIncomeId(0L);
            entity.setBalancesheetIncomeCode(code);
            entity.setUpdateTime(timestamp);
        }

        return balancesheetIncome2025Repository.saveAll(listIncome).size();
    }

    private int registOutcome(final List<BalancesheetOutcome2025Entity> listOutcome, final Timestamp timestamp) {

        //同一識別コード最大値を取得
        Long code = 0L;
        Optional<BalancesheetOutcome2025Entity> optional = balancesheetOutcome2025Repository
                .findFirstByOrderByBalancesheetOutcomeCodeDesc();
        if (optional.isPresent()) {
            code = optional.get().getBalancesheetOutcomeCode();
        }

        // 登録時に必要な情報を更新
        for (BalancesheetOutcome2025Entity entity : listOutcome) {
            code++;
            entity.setBalancesheetOutcomeId(0L);
            entity.setBalancesheetOutcomeCode(code);
            entity.setUpdateTime(timestamp);
        }

        return balancesheetOutcome2025Repository.saveAll(listOutcome).size();
    }

}
