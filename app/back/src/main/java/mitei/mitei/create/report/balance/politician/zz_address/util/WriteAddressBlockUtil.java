package mitei.mitei.create.report.balance.politician.zz_address.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.zz_address.entity.ZzAddressBlockEntity;
import mitei.mitei.create.report.balance.politician.zz_address.entity.ZzAddressPostalEntity;
import mitei.mitei.create.report.balance.politician.zz_address.repository.ZzAddressBlockRepository;
import mitei.mitei.create.report.balance.politician.zz_address.repository.ZzAddressPostalRepository;

/**
 * 番地テーブル作成Util(最終的には調査側に移す)
 */
@Component
public class WriteAddressBlockUtil {

    /** 郵便番号テーブル */
    @Autowired
    private ZzAddressPostalRepository zzAddressPostalRepository;

    /** 番地テーブル */
    @Autowired
    private ZzAddressBlockRepository zzAddressBlockRepository;

    /** 空白文字 */
    private static final String blankChar = "";

    /**
     * 番地リストを登録する
     *
     * @param listAll 郵便番号リスト(全)
     */
    public void practice(final List<String[]> listAll) {

        String lgCode;
        String machiazaId;
        String prcId;

        // 1行目はヘッダなので除く
        listAll.remove(0);

        final int posLgCode = 0;
        final int posMachiazaId = 1;
        final int posPrcId = 2;

        String allAddress;
        String city;
        String oazaCho;
        // String chome; TODO 使用例が判明した時点で修正
        String koaza;
        // String machiazaDist; TODO 使用例が判明した時点で修正
        String prcNum1;
        String prcNum2;
        String prcNum3;

        final int posCity = 3;
        final int posOazaCho = 5;
        // final int posChome = 6; TODO 使用例が判明した時点で修正
        final int posKoaza = 7;
        // final int posMachiazaDist = 8; TODO 使用例が判明した時点で修正
        final int posPrcNum1 = 9;
        final int posPrcNum2 = 10;
        final int posPrcNum3 = 11;

        // 地番では省略されている地方自治体を呼び出し
        //lgCode = listAll.get(0)[posLgCode];

        String jichitai = "広島県神石郡";

        List<ZzAddressPostalEntity> listPoastal = zzAddressPostalRepository.findAll();
        List<ZzAddressBlockEntity> listBlock = new ArrayList<>();

        String postalCode;
        String postalAddress;
        String postalAddressSet;
        ZzAddressBlockEntity blockEntity;

        // TODO 実際には高速化のために郵便番号ごとにテーブル分割する
        for (String[] row : listAll) {
            postalCode = "";
            postalAddressSet = "";

            // コード体系取得
            lgCode = row[posLgCode];
            machiazaId = row[posMachiazaId];
            prcId = row[posPrcId];

            // データ取得
            city = row[posCity];
            oazaCho = this.convertOhaza(row[posOazaCho]);
            // chome = row[posChome];
            koaza = this.convertKoaza(row[posKoaza]);
            // machiazaDist = row[posMachiazaDist];
            prcNum1 = this.convertPlace1(row[posPrcNum1]);
            prcNum2 = this.convertPlace2(row[posPrcNum2]);
            prcNum3 = this.convertPlace3(row[posPrcNum3]);

            allAddress = jichitai + city + oazaCho + koaza + prcNum1 + prcNum2 + prcNum3;

            for (ZzAddressPostalEntity entityPostal : listPoastal) {
                postalAddress = entityPostal.getAddressName();
                if (allAddress.startsWith(postalAddress)) {
                    if (postalAddressSet.length() < postalAddress.length()) { // NOPMD
                        postalAddressSet = postalAddress;
                        postalCode = entityPostal.getPostalcode();
                    }
                }
            }

            blockEntity = new ZzAddressBlockEntity(); // NOPMD
            blockEntity.setId(0L);
            blockEntity.setLgCode(lgCode);
            blockEntity.setMachiazaId(machiazaId);
            blockEntity.setValue(prcId);
            blockEntity.setPostalCode(postalCode);
            blockEntity.setNameAll(allAddress);
            blockEntity.setText(allAddress.replaceAll(postalAddressSet, ""));
            listBlock.add(blockEntity);
        }

        zzAddressBlockRepository.saveAll(listBlock);

        // for(ZzAddressBlockEntity entity : listBlock) {
        // System.out.println(entity.getNameAll()+"::"+entity.getNameAfter());
        // }
    }


    private String convertOhaza(final String data) {
        if (blankChar.equals(data)) {
            return data;
        } else {
            return data;
        }
    }

    private String convertKoaza(final String data) {
        if (blankChar.equals(data)) {
            return data;
        } else {
            return data;
        }
    }

    private String convertPlace1(final String data) {
        if (blankChar.equals(data)) {
            return data;
        } else {
            return data + "番地";
        }
    }

    private String convertPlace2(final String data) {
        if (blankChar.equals(data)) {
            return data;
        } else {
            return "の" + data;
        }
    }

    private String convertPlace3(final String data) {
        if (blankChar.equals(data)) {
            return data;
        } else {
            return "の" + data;
        }
    }

}
