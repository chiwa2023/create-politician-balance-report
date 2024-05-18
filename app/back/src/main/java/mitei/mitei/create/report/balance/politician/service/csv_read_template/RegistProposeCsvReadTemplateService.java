package mitei.mitei.create.report.balance.politician.service.csv_read_template;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.logic.read_csv.CheckValidateCsvPointListLogic;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;

/**
 * csv読み取りテンプレート登録提案テーブルにデータ挿入する
 */
@Service
public class RegistProposeCsvReadTemplateService {

    /** csv読み取りテンプレート登録提案Reposiory */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    /** 列指定妥当性検証Logic */
    @Autowired
    private CheckValidateCsvPointListLogic checkValidateCsvPointListLogic;

    /**
     * csv読み取りテンプレート登録提案を行う
     *
     * @param proposeCsvReadTemplateEntity 登録内容Entity
     * @return 登録結果
     */
    public TemplateFrameworkResultDto practice(final ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity,
            final CheckPrivilegeDto checkPrivilegeDto) {

        //指定リストの妥当性のチェック
        TemplateFrameworkResultDto resultDto = checkValidateCsvPointListLogic
                .practice(proposeCsvReadTemplateEntity.getArrayText().split(","));
        if (!resultDto.getIsOk()) {
            return resultDto;
        }

        // 全文検索対象は名称
        proposeCsvReadTemplateEntity
                .setTableAllSearchText(proposeCsvReadTemplateEntity.getProposeCsvReadTemplateName());

        // auto increment
        proposeCsvReadTemplateEntity.setProposeCsvReadTemplateId(0L);

        // 最大同一識別コード
        Optional<ProposeCsvReadTemplateEntity> optional = proposeCsvReadTemplateRepository
                .findFirstByOrderByProposeCsvReadTemplateCodeDesc();
        if (!optional.isEmpty()) {
            proposeCsvReadTemplateEntity
                    .setProposeCsvReadTemplateCode(optional.get().getProposeCsvReadTemplateCode() + 1);
        }

        // 新規登録は最新
        proposeCsvReadTemplateEntity.setSaishinKbn(SaishinKbnConstants.SAISHIN);

        // ログインユーザ設定と更新時間
        BeanUtils.copyProperties(checkPrivilegeDto, proposeCsvReadTemplateEntity);
        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());
        proposeCsvReadTemplateEntity.setUpdateTime(timestampNow);

        ProposeCsvReadTemplateEntity result = proposeCsvReadTemplateRepository.save(proposeCsvReadTemplateEntity);

        // auto incrementで新たに値が採番された
        if (0 != result.getProposeCsvReadTemplateId()) {
            resultDto.setIsOk(true);
        }

        return resultDto;
    }
}
