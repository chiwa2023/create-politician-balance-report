package mitei.mitei.create.report.balance.politician.dto.read_csv;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;

/**
 * アップロードされたcsv内容格納Dto
 */
public class RegistProposeCsvReadRemplateCapsuleDto extends TemplateFrameworkCapsuleDto implements Serializable { // NOPMD DataClass

    /** Serial Id */
    private static final long serialVersionUID = 1L;

    /** 申請用csv結びつけ項目Entity */
    private ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity;

    /**
     * 申請用csv結びつけ項目を取得する
     *
     * @return 申請用csv結びつけ項目
     */
    public ProposeCsvReadTemplateEntity getProposeCsvReadTemplateEntity() {
        return proposeCsvReadTemplateEntity;
    }

    /**
     * 申請用csv結びつけ項目を設定する
     *
     * @param proposeCsvReadTemplateEntity 申請用csv結びつけ項目
     */
    public void setProposeCsvReadTemplateEntity(final ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity) {
        this.proposeCsvReadTemplateEntity = proposeCsvReadTemplateEntity;
    }

}
