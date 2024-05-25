package mitei.mitei.create.report.balance.politician.zz_address2_support.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.PostalAddressBlockDto;
import mitei.mitei.create.report.balance.politician.zz_address2_support.service.GetAddressBlockService;

/**
 * 郵便番号と番地Dto取得Controller
 */
@Controller
public class GetAddressBlockController {

    /** 郵便番号と番地Dto取得Service */
    @Autowired
    private GetAddressBlockService getAddressBlockService;
    
    /**
     * 郵便番号と番地Dtoを含むレスポンス
     *
     * @param postalCode 郵便番号
     * @return 郵便番号と番地Dto
     * @throws Exception 仮で全Throw
     */
    @GetMapping("/zz-address/example2")
    public ResponseEntity<PostalAddressBlockDto> practice(
            final @RequestParam(name = "postalCode") String postalCode) throws Exception{ // NOPMD
        
        return ResponseEntity.ok(getAddressBlockService.practice(postalCode));
    }
}
