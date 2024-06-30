package mitei.mitei.create.report.balance.politician.dto.read_csv;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;

/**
 * 申請作業を行うEntityを伝達するCapsuleDto
 */
public class ReadCsvByEntityCapsuleDto  extends TemplateFrameworkCapsuleDto implements Serializable { // NOPMD DataClass

    /** Serial Id */
    private static final long serialVersionUID = 1L;

    /** CSV読み取り仕様申請Entity */
    private ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity;

    /**
     * CSV読み取り仕様申請Entityを取得する
     *
     * @return CSV読み取り仕様申請Entity
     */
    public ProposeCsvReadTemplateEntity getProposeCsvReadTemplateEntity() {
        return proposeCsvReadTemplateEntity;
    }

    /**
     * CSV読み取り仕様申請Entityを設定する
     *
     * @param proposeCsvReadTemplateEntity CSV読み取り仕様申請Entity
     */
    public void setProposeCsvReadTemplateEntity(final ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity) {
        this.proposeCsvReadTemplateEntity = proposeCsvReadTemplateEntity;
    }
    
}
