package mitei.mitei.create.report.balance.politician.logic.political_organizaion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.entity.PoliticalOrganizationEntity;

/**
 * GetRoleInPolitialOrganizationLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class GetRoleInPolitialOrganizationLogicTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private GetRoleInPolitialOrganizationLogic getRoleInPolitialOrganizationLogic;
    
    @Test
    void test()throws Exception {
        
        Integer userCode = 12345;
        PoliticalOrganizationEntity organizationEntity = new PoliticalOrganizationEntity();
        
        //政治団体Entityがnullを許容しません
        assertThrows(IllegalArgumentException.class, () -> getRoleInPolitialOrganizationLogic.practice(null, userCode));
        
        //ユーザchordがnullを許容しません
        assertThrows(IllegalArgumentException.class, () -> getRoleInPolitialOrganizationLogic.practice(organizationEntity, null));
        
        //両方揃っていれば例外ではありません
        assertDoesNotThrow( () -> getRoleInPolitialOrganizationLogic.practice(organizationEntity, userCode));

        //代表者
        PoliticalOrganizationEntity entity1 = new PoliticalOrganizationEntity();
        entity1.setDelegateCode(userCode);
        assertThat(getRoleInPolitialOrganizationLogic.practice(entity1, userCode)).isEqualTo(GetRoleInPolitialOrganizationLogic.DELEGATE_TEXT);

        //会計責任者
        PoliticalOrganizationEntity entity2 = new PoliticalOrganizationEntity();
        entity2.setAccountOfficerCode(userCode);
        assertThat(getRoleInPolitialOrganizationLogic.practice(entity2, userCode)).isEqualTo(GetRoleInPolitialOrganizationLogic.ACCOUNT_OFFICER_TEXT);

        //事務担当者1
        PoliticalOrganizationEntity entity3 = new PoliticalOrganizationEntity();
        entity3.setAccountStaff1Code(userCode);
        assertThat(getRoleInPolitialOrganizationLogic.practice(entity3, userCode)).isEqualTo(GetRoleInPolitialOrganizationLogic.ACCOUNT_STAFF1_TEXT);
        
        //事務担当者2
        PoliticalOrganizationEntity entity4 = new PoliticalOrganizationEntity();
        entity4.setAccountStaff2Code(userCode);
        assertThat(getRoleInPolitialOrganizationLogic.practice(entity4, userCode)).isEqualTo(GetRoleInPolitialOrganizationLogic.ACCOUNT_STAFF2_TEXT);

        //事務担当者3
        PoliticalOrganizationEntity entity5 = new PoliticalOrganizationEntity();
        entity5.setAccountStaff3Code(userCode);
        assertThat(getRoleInPolitialOrganizationLogic.practice(entity5, userCode)).isEqualTo(GetRoleInPolitialOrganizationLogic.ACCOUNT_STAFF3_TEXT);

        //いずれでもない
        PoliticalOrganizationEntity entity6 = new PoliticalOrganizationEntity();
        entity1.setDelegateCode(1);
        entity6.setAccountOfficerCode(2);
        entity6.setAccountStaff1Code(3);
        entity6.setAccountStaff2Code(4);
        entity6.setAccountStaff3Code(5);
        assertThat(getRoleInPolitialOrganizationLogic.practice(entity6, userCode)).isEqualTo("");

    }

}
