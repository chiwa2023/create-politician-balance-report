package mitei.mitei.create.report.balance.politician.zz_address2_support.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.PostalAddressBlockDto;
import mitei.mitei.create.report.balance.politician.zz_address2_support.repository.ZzAddress2BlockRepository;
import mitei.mitei.create.report.balance.politician.zz_address2_support.repository.ZzAddress2PostalcodeRepository;

/**
 * 番地と郵便番号情報量を取得するService
 */
@Service
public class GetAddressBlockService {

    /** 郵便番号Repository */
    @Autowired
    private ZzAddress2PostalcodeRepository zzAddress2PostalcodeRepository;

    /** 番地情報Repository */
    @Autowired
    private ZzAddress2BlockRepository zzAddress2BlockRepository;

    /**
     * 郵便番号と紐づく番地リストを取得する
     *
     * @param postalcode 郵便番号
     * @return 郵便番号と紐づく番地リストDto
     */
    public PostalAddressBlockDto practice(final String postalcode) {

        PostalAddressBlockDto postalAddressBlockDto = new PostalAddressBlockDto();
        
        postalAddressBlockDto.setListPostalcode(zzAddress2PostalcodeRepository.findByPostalcode(postalcode));
        postalAddressBlockDto.setListBlock(zzAddress2BlockRepository.findByPostalCode(postalcode));
        
        return postalAddressBlockDto;
    }
}
