package mitei.mitei.create.report.balance.politician.logic.political_organizaion;

import java.util.Objects;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.entity.PoliticalOrganizationEntity;

/**
 * 政治団体内役割を取得する
 */
@Component
public class GetRoleInPolitialOrganizationLogic {

    /** 団体代表者 */
    public static final int DELEGATE = 1;
    /** 団体代表者表示テキスト */
    public static final String DELEGATE_TEXT = "代表者";

    /** 会計責任者 */
    public static final int ACCOUNT_OFFICER = 11;
    /** 会計責任者表示テキスト */
    public static final String ACCOUNT_OFFICER_TEXT = "会計責任者";

    /** (会計)事務担当者1 */
    public static final int ACCOUNT_STAFF1 = 21;
    /** (会計)事務担当者1表示テキスト */
    public static final String ACCOUNT_STAFF1_TEXT = "事務担当者1";

    /** (会計)事務担当者2 */
    public static final int ACCOUNT_STAFF2 = 22;
    /** (会計)事務担当者2表示テキスト */
    public static final String ACCOUNT_STAFF2_TEXT = "事務担当者2";

    /** (会計)事務担当者3 */
    public static final int ACCOUNT_STAFF3 = 23;
    /** (会計)事務担当者3表示テキスト */
    public static final String ACCOUNT_STAFF3_TEXT = "事務担当者3";

    /**
     * ユーザ情報から政治団体における役割を返却する
     *
     * @param politicalOrganizationEntity 政治団体Entity
     * @param userCode                    ユーザコード
     * @return 団体内役割テキスト
     */
    public String practice(final PoliticalOrganizationEntity politicalOrganizationEntity, // NOPMD CHECKSTYLE:OFF
            final Integer userCode) {

        if (Objects.isNull(userCode)) {
            // 限りなく実装ミスを検出しているのに等しい
            throw new IllegalArgumentException("userCodeがnullです");
        }

        if (Objects.isNull(politicalOrganizationEntity)) {
            // 限りなく実装ミスを検出しているのに等しい
            throw new IllegalArgumentException("politicalOrganizationEntityeがnullです");
        }
        
        // 代表者
        if (!Objects.isNull(politicalOrganizationEntity.getDelegateCode())) {
            if (userCode.equals(politicalOrganizationEntity.getDelegateCode())) { // NOPMD
                return DELEGATE_TEXT;
            }
        }

        // 会計責任者
        if (!Objects.isNull(politicalOrganizationEntity.getAccountOfficerCode())) {
            if (userCode.equals(politicalOrganizationEntity.getAccountOfficerCode())) { // NOPMD
                return ACCOUNT_OFFICER_TEXT;
            }
        }

        // 事務担当者1
        if (!Objects.isNull(politicalOrganizationEntity.getAccountStaff1Code())) {
            if (userCode.equals(politicalOrganizationEntity.getAccountStaff1Code())) { // NOPMD
                return ACCOUNT_STAFF1_TEXT;
            }
        }

        // 事務担当者2
        if (!Objects.isNull(politicalOrganizationEntity.getAccountStaff2Code())) {
            if (userCode.equals(politicalOrganizationEntity.getAccountStaff2Code())) { // NOPMD
                return ACCOUNT_STAFF2_TEXT;
            }
        }

        // 事務担当者3
        if (!Objects.isNull(politicalOrganizationEntity.getAccountStaff3Code())) {
            if (userCode.equals(politicalOrganizationEntity.getAccountStaff3Code())) { // NOPMD
                return ACCOUNT_STAFF3_TEXT;
            }
        }

        // 該当がないときは空文字を返す
        return "";
    }
}
