package mitei.mitei.create.report.balance.politician.zz_address.util;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.zz_address.entity.ZzAddressPostalEntity;
//import mitei.mitei.create.report.balance.politician.repository.ZzAddressPostalRepository;

/**
 * 番地データベース作成用Util(最終的には調査側に移す)
 */
@Component
public class WritePostalcodeTableUtil {

    ///** 郵便番号Repository */
    //@Autowired
    //private ZzAddressPostalRepository zzAddressPostalRepository;


    /**
     * csvから郵便番号と対応住所を登録する
     *
     * @param listAll csv内容
     */
    public void practice(final List<String[]> listAll) {

        final int maxSize = 10;

        final int posKey = 3;
        final int posPostal = 2;
        final int posAddress1 = 6;
        final int posAddress2 = 7;
        final int posAddress3 = 8;

        List<ZzAddressPostalEntity> listAdd = new ArrayList<>();
        List<String> listSql = new ArrayList<>();

        String postal;
        String address;
        ZzAddressPostalEntity entity;
        for (String[] row : listAll) {

            if (row.length > maxSize) {
                // たまたま地番マスタを拾ったのが広島県だったので(^^;;広島県限定
                if ("ヒロシマケン".equals(row[posKey])) { // NOPMD
                    postal = row[posPostal];
                    address = row[posAddress1] + row[posAddress2] + this.formatAddress3(row[posAddress3]);
                    
                    //System.out.println(postal + address);
                    
                    entity = new ZzAddressPostalEntity(); // NOPMD
                    entity.setPostalcode(postal);
                    entity.setAddressName(address);
                    
                    listAdd.add(entity);
                    listSql.add("INSERT INTO `politician_balance_report_create`.`zz_address_postal`(`postalcode`,`address_name`)VALUES('"+postal+"','"+address+"');\n");
                }
            }

        }

        //zzAddressPostalRepository.saveAll(listAdd);

        //for(String sql : listSql) {
        //    System.out.print(sql);
        //}
        
    }

    private String formatAddress3(final String data) {
        // 以下に掲載がない場合の場合は空文字とする
        String answer = data.replaceAll("以下に掲載がない場合", "");

        // ()があったら以下を除去
        int pos = answer.indexOf("（");
        if (pos != -1) {
            answer = answer.substring(0, pos);
        }

        return answer;
    }
}
