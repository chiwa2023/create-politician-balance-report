package mitei.mitei.create.report.balance.politician.service.read_csv;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.CsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.CsvReadTemplateRepository;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * 申請中CSV読み取りデータを承認で登録する
 */
@Service
public class RegistProposeReadCsvAcceptService {

    /** CSV読み取り仕様申請テーブル */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    /** CSV読み取り仕様テーブル */
    @Autowired
    private CsvReadTemplateRepository csvReadTemplateRepository;

    /**
     * 承認登録を行う
     *
     * @param proposeCsvReadTemplateEntity 承認されたEntity
     * @return データベース登録結果
     */
    public long practice(final ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity) {

        /* 本番テーブルに情報をコピー */
        CsvReadTemplateEntity csvReadTemplateEntity = new CsvReadTemplateEntity();

        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

        final long initId = 0L;
        // 編集元Idが0の時は新規登録とする
        if (initId == proposeCsvReadTemplateEntity.getEditId()) {
            // 新規登録時は同一識別コードを取り直す
            Optional<CsvReadTemplateEntity> optional = csvReadTemplateRepository
                    .findFirstByOrderByCsvReadTemplateCodeDesc();
            if (optional.isEmpty()) {
                csvReadTemplateEntity.setCsvReadTemplateCode(1);
            } else {
                csvReadTemplateEntity.setCsvReadTemplateCode(optional.get().getCsvReadTemplateCode() + 1);
            }

        } else {
            // 変更時は旧データを呼び出して履歴にする作業が必要
            Optional<CsvReadTemplateEntity> optionalEdit = csvReadTemplateRepository
                    .findById(proposeCsvReadTemplateEntity.getEditId());
            if (Objects.isNull(optionalEdit)) { // NOPMD
                // TODO idを使ってロード使用しても呼び出せないのは異常事態なので、対応を決定して修正する
            } else {
                // 履歴に変更
                CsvReadTemplateEntity csvEntityEdit = optionalEdit.get();
                csvEntityEdit.setSaishinKbn(SaishinKbnConstants.HISOTRY);
                csvEntityEdit.setUpdateTime(timestampNow);
                csvReadTemplateRepository.saveAndFlush(csvEntityEdit);

                // 編集時には同一識別コードを引き継ぐ
                csvReadTemplateEntity.setCsvReadTemplateCode(csvEntityEdit.getCsvReadTemplateCode());
            }
        }

        csvReadTemplateEntity.setCsvReadTemplateId(initId);
        csvReadTemplateEntity.setSaishinKbn(SaishinKbnConstants.SAISHIN);
        BeanUtils.copyProperties(proposeCsvReadTemplateEntity, csvReadTemplateEntity);
        csvReadTemplateEntity.setCsvReadTemplateName(proposeCsvReadTemplateEntity.getProposeCsvReadTemplateName());

        // 変更でも新規でも行追加
        csvReadTemplateEntity.setUpdateTime(timestampNow);
        csvReadTemplateRepository.saveAndFlush(csvReadTemplateEntity);

        /* 申請データは両方履歴にして申請中一覧に出ないようにする */
        // 古いデータを履歴に
        proposeCsvReadTemplateEntity.setSaishinKbn(SaishinKbnConstants.HISOTRY);
        proposeCsvReadTemplateEntity.setUpdateTime(timestampNow);
        proposeCsvReadTemplateRepository.saveAndFlush(proposeCsvReadTemplateEntity);

        // 申請完了したデータも履歴で登録
        ProposeCsvReadTemplateEntity entityNew = new ProposeCsvReadTemplateEntity();
        BeanUtils.copyProperties(proposeCsvReadTemplateEntity, entityNew);
        entityNew.setProposeCsvReadTemplateId(0L);
        entityNew.setSaishinKbn(SaishinKbnConstants.HISOTRY);
        entityNew.setJudgeReason("正常登録");
        entityNew.setInProsessing(false);
        entityNew.setIsAccepted(true);

        entityNew.setUpdateTime(timestampNow);
        ProposeCsvReadTemplateEntity entityResult = proposeCsvReadTemplateRepository.saveAndFlush(entityNew);

        long newId = 0L;
        if (!Objects.isNull(entityResult)) {
            newId = entityResult.getProposeCsvReadTemplateId();
            // TODO 通知データを作成する
        }

        return newId;
    }

}
