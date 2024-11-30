package mitei.mitei.create.report.balance.politician.trial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.dto.various_financial_pay.VariousFinanciallPayCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.VariousFinancialPayEntity;
import mitei.mitei.create.report.balance.politician.repository.VariousFinancialPayRepository;
import mitei.mitei.create.report.balance.politician.util.SetTableDataHistoryUtil;

/**
 * ビジネスロジック全体をトランザクションするWorksBandController
 */
@Service
public class TransactionFormatControllerWorksBand {

    /** 各種PayRepository */
    @Autowired
    private VariousFinancialPayRepository variousFinancialPayRepository;

    /**
     * ビジネスロジックを起動する
     *
     * @param listCapsuleDto 登録するDto
     * @return 動作したらtrue
     */
    @Transactional
    public boolean wakeBuissiness(final List<VariousFinanciallPayCapsuleDto> listCapsuleDto) {

        for(VariousFinanciallPayCapsuleDto capsuleDto : listCapsuleDto) {
            VariousFinancialPayEntity entity = new VariousFinancialPayEntity(); // NOPMD
            SetTableDataHistoryUtil.practice(capsuleDto.getCheckPrivilegeDto(), entity, DataHistoryStatusConstants.INSERT);
            entity.setVariousFinancialPayId(0L); // auto_incremrn明記
            entity.setTableAllSearchText(capsuleDto.getSearchWords());
            variousFinancialPayRepository.saveAndFlush(entity);
        }
        
        return true;
    }

    /**
     * ビジネスロジックを起動する
     *
     * @param listCapsuleDto 登録するDto
     * @return 動作したらtrue
     */
    public boolean wakeBuissinessNoTrunsaction(final List<VariousFinanciallPayCapsuleDto> listCapsuleDto) {

        for(VariousFinanciallPayCapsuleDto capsuleDto : listCapsuleDto) {
            VariousFinancialPayEntity entity = new VariousFinancialPayEntity(); // NOPMD
            SetTableDataHistoryUtil.practice(capsuleDto.getCheckPrivilegeDto(), entity, DataHistoryStatusConstants.INSERT);
            entity.setVariousFinancialPayId(0L); // auto_incremrn明記
            entity.setTableAllSearchText(capsuleDto.getSearchWords());
            variousFinancialPayRepository.saveAndFlush(entity);
        }
        
        return true;
    }

}
