package mitei.mitei.create.report.balance.politician.zz_address2_support.util.create;

import java.util.ArrayList;
import java.util.List;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;

/**
 * 郵便番号のリストから基本部分を書き出しする(後で修正する必要がある)
 */
public class ZzAddressInsertPostalTableUtil {

    /**
     * 書き出しする部分
     *
     * @param listCsv csv内容
     * @return 郵便番号テーブルEntityリスト
     */
    public List<ZzAddress2PostalcodeEntity> practice(final List<String[]> listCsv) {
        
        final int maxSize = 10;

        final int posKey = 3;
        final int posPostal = 2;
        final int posAddress1 = 6;
        final int posAddress2 = 7;
        final int posAddress3 = 8;
        
        String postal;
        String address;
        ZzAddress2PostalcodeEntity entityPostal;
        List<ZzAddress2PostalcodeEntity> listEntity = new ArrayList<>();
        for (String[] row : listCsv) {

            if (row.length > maxSize) {
                // たまたま地番マスタを拾ったのが広島県と熊本県だったので(^^;;両県限定
                if ("ヒロシマケン".equals(row[posKey]) | "クマモトケン".equals(row[posKey])) { // NOPMD
                    postal = row[posPostal];
                    
                    address = row[posAddress1] + row[posAddress2] + this.formatAddress3(row[posAddress3]);
                    
                    entityPostal = new ZzAddress2PostalcodeEntity(); // NOPMD
                    
                    entityPostal.setId(0);
                    
                    entityPostal.setIsChoume(true);
                    entityPostal.setIsPrc1(true);
                    entityPostal.setIsPrc2(true);
                    entityPostal.setIsPrc3(true);

                    entityPostal.setPostalcode(postal);
                    entityPostal.setAddressName(address);
                    entityPostal.setNamePlus(this.getAfter(row[posAddress3]));
                    
                    listEntity.add(entityPostal);
                }
            }

        }
        
        return listEntity;
    }

    private String formatAddress3(final String data) { //  SUPPRESS CHECKSTYLE
        
        //以下に掲載がない場合は空文字
        if(data.startsWith("以下に掲載がない場合")) {
            return "";
        }

        //（による注釈がある場合は内容を見て修正するので一旦は空文字
        if(data.indexOf("（")!= -1) {
            return "";
        }

        return data;
    }

    private String getAfter(final String data) {  // SUPPRESS CHECKSTYLE

        //（による注釈がある場合は内容を見て修正するので内容を残す
        if(data.indexOf("（")!= -1) {
            String answer = data.replaceAll("（", "");
            answer = answer.replaceAll("）", "");
            return answer;
        }

        //その他は修正不要のため空文字
        return "";
    }
}
