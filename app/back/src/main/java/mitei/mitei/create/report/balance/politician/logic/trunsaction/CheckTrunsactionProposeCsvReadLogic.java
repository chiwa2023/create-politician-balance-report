package mitei.mitei.create.report.balance.politician.logic.trunsaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * 他のユーザさんが同じデータをすでに変更申請している場合は申請を断念してもらう
 */
@Component
public class CheckTrunsactionProposeCsvReadLogic {

    /** csv読み取りテンプレート登録提案Reposiory */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    /**
     * 確認作業を行う
     *
     * @param editId 編集対象Id
     * @return 排他対象該否(リストが空の時は排他対象ではない)
     */
    public boolean practice(final Long editId) {

        return !proposeCsvReadTemplateRepository.findBySaishinKbnAndEditId(SaishinKbnConstants.SAISHIN, editId)
                .isEmpty();
    }
}
