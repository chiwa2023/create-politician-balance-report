package mitei.mitei.create.report.balance.politician.zz_address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mitei.mitei.create.report.balance.politician.dto.SelectOptionInterface;
import mitei.mitei.create.report.balance.politician.zz_address.service.GetAddressService;

/**
 * 住所取得Controller実装例1
 */
@Controller
public class GetAddressController {

    /** 住所取得Service実装例1 */
    @Autowired
    private GetAddressService getAddressService;

    /**
     * 郵便番号条件で番地リストを返却する
     *
     * @param postalCode 郵便番号
     * @return 番地リスト
     * @throws Exception 仮で全部throw
     */
    @GetMapping("/zz-address/example1")
    public ResponseEntity<List<SelectOptionInterface>> practice(
            final @RequestParam(name = "postalCode") String postalCode) throws Exception { // NOPMD

        return ResponseEntity.ok(getAddressService.practice(postalCode));
    }
}
