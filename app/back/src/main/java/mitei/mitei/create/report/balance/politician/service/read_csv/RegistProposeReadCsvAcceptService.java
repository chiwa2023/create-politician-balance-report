package mitei.mitei.create.report.balance.politician.service.read_csv;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.CsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.logic.common.SetTableDataHistoryLogic;
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

    /** テーブル履歴設定Logic */
    @Autowired
    private SetTableDataHistoryLogic setTableDataHistoryLogic;

    /**
     * 承認登録を行う
     *
     * @param registProposeCsvReadRemplateCapsuleDto 承認されたEntityを含むDto
     * @return データベース登録結果
     */
    public long practice(final RegistProposeCsvReadRemplateCapsuleDto registProposeCsvReadRemplateCapsuleDto) {

        
        ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity = registProposeCsvReadRemplateCapsuleDto.getProposeCsvReadTemplateEntity();
        
        CheckPrivilegeDto checkPrivilegeDto = registProposeCsvReadRemplateCapsuleDto.getCheckPrivilegeDto();
        
        /* 本番テーブルに情報をコピー */
        CsvReadTemplateEntity csvReadTemplateEntity = new CsvReadTemplateEntity();

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
                csvEntityEdit.setSaishinKbn(DataHistoryStatusConstants.UPDATE.value());
                setTableDataHistoryLogic.practice(checkPrivilegeDto, csvReadTemplateEntity, DataHistoryStatusConstants.UPDATE);
                csvReadTemplateRepository.saveAndFlush(csvEntityEdit);

                // 編集時には同一識別コードを引き継ぐ
                csvReadTemplateEntity.setCsvReadTemplateCode(csvEntityEdit.getCsvReadTemplateCode());
            }
        }

        csvReadTemplateEntity.setCsvReadTemplateId(initId);
        csvReadTemplateEntity.setSaishinKbn(DataHistoryStatusConstants.INSERT.value());
        BeanUtils.copyProperties(proposeCsvReadTemplateEntity, csvReadTemplateEntity);
        csvReadTemplateEntity.setCsvReadTemplateName(proposeCsvReadTemplateEntity.getProposeCsvReadTemplateName());

        // 変更でも新規でも行追加
        setTableDataHistoryLogic.practice(checkPrivilegeDto, proposeCsvReadTemplateEntity, DataHistoryStatusConstants.INSERT);        
        csvReadTemplateRepository.saveAndFlush(csvReadTemplateEntity);

        /* 申請データは両方履歴にして申請中一覧に出ないようにする */
        // 古いデータを履歴に
        proposeCsvReadTemplateEntity.setSaishinKbn(DataHistoryStatusConstants.UPDATE.value());
        setTableDataHistoryLogic.practice(checkPrivilegeDto, proposeCsvReadTemplateEntity, DataHistoryStatusConstants.UPDATE);        
        proposeCsvReadTemplateRepository.saveAndFlush(proposeCsvReadTemplateEntity);

        // 申請完了したデータも履歴で登録
        ProposeCsvReadTemplateEntity entityNew = new ProposeCsvReadTemplateEntity();
        entityNew.setProposeCsvReadTemplateId(0L);
        entityNew.setSaishinKbn(DataHistoryStatusConstants.UPDATE.value());
        entityNew.setJudgeReason("正常登録");
        entityNew.setInProsessing(false);
        entityNew.setIsAccepted(true);
        setTableDataHistoryLogic.practice(checkPrivilegeDto, entityNew, DataHistoryStatusConstants.UPDATE);        

        ProposeCsvReadTemplateEntity entityResult = proposeCsvReadTemplateRepository.saveAndFlush(entityNew);

        long newId = 0L;
        if (!Objects.isNull(entityResult)) {
            newId = entityResult.getProposeCsvReadTemplateId();
            // TODO 通知データを作成する
        }

        return newId;
    }

}
