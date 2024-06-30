package mitei.mitei.create.report.balance.politician.service.read_csv;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * 申請中CSV読み取り仕様を却下で登録する
 */
@Service
public class RegistProposeReadCsvRejectService {

    /** CSV読み取り使用申請テーブル */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    /**
     * 却下登録作業
     *
     * @param proposeCsvReadTemplateEntity 却下されたEntity
     * @return データベース登録結果
     */
    public long practice(final ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity) {

        /* 却下判断が出たデータを最新にする(申請中を継続) */
        ProposeCsvReadTemplateEntity oldEntity = proposeCsvReadTemplateRepository
                .getReferenceById(proposeCsvReadTemplateEntity.getProposeCsvReadTemplateId());
        // 古いデータを履歴に変更
        oldEntity.setSaishinKbn(SaishinKbnConstants.HISOTRY);

        proposeCsvReadTemplateRepository.saveAndFlush(oldEntity);

        // 新たなEntityを準備
        ProposeCsvReadTemplateEntity newEntity = new ProposeCsvReadTemplateEntity();
        BeanUtils.copyProperties(proposeCsvReadTemplateEntity, newEntity);
        // 申請完了したデータも履歴で登録
        newEntity.setProposeCsvReadTemplateId(0L);// 行追加
        newEntity.setSaishinKbn(SaishinKbnConstants.SAISHIN);// 最新データのはずだがダメ押し
        // 申請過程継続
        newEntity.setInProsessing(true);
        // 申請不可
        newEntity.setIsAccepted(false);

        ProposeCsvReadTemplateEntity resultEntity = proposeCsvReadTemplateRepository.saveAndFlush(newEntity);

        // 新しいIdが振られていたら登録完了
        long newId = 0L;
        if (newId != resultEntity.getProposeCsvReadTemplateId()) {
            newId = resultEntity.getProposeCsvReadTemplateId();
            /* ユーザ通知 */
            // TODO ユーザ通知
        }

        return newId;
    }

}
