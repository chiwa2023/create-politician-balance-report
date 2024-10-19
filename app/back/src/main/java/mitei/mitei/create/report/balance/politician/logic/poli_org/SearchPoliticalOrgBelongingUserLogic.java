package mitei.mitei.create.report.balance.politician.logic.poli_org;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.PoliticalOrganizationSelectOptionDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.PoliticalOrgBelogingUserEntity;
import mitei.mitei.create.report.balance.politician.repository.PoliticalOrgBelogingUserRepository;

/**
 * ユーザ所属政治団体検索Logic
 */
@Component
public class SearchPoliticalOrgBelongingUserLogic {

    /** 政治団体所属ユーザデータRepository */
    @Autowired
    private PoliticalOrgBelogingUserRepository politicalOrgBelogingUserRepository;

    /**
     * ユーザが所属する政治団体をユーザ同一識別コードで検索
     *
     * @param userCode ユーザ同一識別コード
     * @return 政治団体Selectbox選択肢リスト
     */
    public List<PoliticalOrganizationSelectOptionDto> practice(final Integer userCode) {

        List<PoliticalOrgBelogingUserEntity> listEntity = politicalOrgBelogingUserRepository
                .findBySaishinKbnAndUserCode(DataHistoryStatusConstants.INSERT.value(), userCode);
        
        List<PoliticalOrganizationSelectOptionDto> listDto = new ArrayList<>();
        List<Integer> listDistinct = new ArrayList<>();
        Integer code;
        for(PoliticalOrgBelogingUserEntity entity : listEntity ) {
            
            // 政治団体が重複しているデータはリスト追加しない(運営の原理ではおきないはず)
            code = entity.getPoliticalOrganizationCode();
            if(!listDistinct.contains(code)) {
                listDto.add(this.createDto(entity));
                listDistinct.add(code);
            }
            
        }

        return listDto;
    }

    private PoliticalOrganizationSelectOptionDto createDto(final PoliticalOrgBelogingUserEntity entity) {
        PoliticalOrganizationSelectOptionDto dto = new PoliticalOrganizationSelectOptionDto();
        
        BeanUtils.copyProperties(entity, dto);
        
        String code = String.valueOf(dto.getPoliticalOrganizationCode());
        dto.setValue(code);
        dto.setText(dto.getPoliticalOrganizationName() + "(" + code + ")");

        return dto;
    }
    
    
}
