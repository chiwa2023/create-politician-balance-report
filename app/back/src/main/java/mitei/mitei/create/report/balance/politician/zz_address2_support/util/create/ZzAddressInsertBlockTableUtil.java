package mitei.mitei.create.report.balance.politician.zz_address2_support.util.create;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2BlockEntity;
import mitei.mitei.create.report.balance.politician.zz_address2_support.entity.ZzAddress2PostalcodeEntity;
import mitei.mitei.create.report.balance.politician.zz_address2_support.repository.ZzAddress2PostalcodeRepository;

/**
 * 番地データ作成Utility
 */
@Component
public class ZzAddressInsertBlockTableUtil {

    /** 郵便番号テーブル */
    @Autowired
    private ZzAddress2PostalcodeRepository zzAddress2PostalcodeRepository;

    /** 空文字 */
    private static final String blankChar = "";

    /**
     * 番地データを挿入する
     *
     * @param listCsv  csvデータ
     * @param jichitai 地番データに出現しない自治体名(県・その次の広域自治体が主)
     * @return 番地データリスト
     */
    public List<ZzAddress2BlockEntity> practice(final List<String[]> listCsv, final String jichitai) { // NOPMD

        String lgCode;
        String machiazaId;
        String prcId;

        final int posLgCode = 0;
        final int posMachiazaId = 1;
        final int posPrcId = 2;

        String allAddress;
        String city;
        String ward;
        String oazaCho;
        String chome;
        String koaza;
        // String machiazaDist; TODO 使用例が判明した時点で修正
        String prcNum1;
        String prcNum2;
        String prcNum3;

        final int posCity = 3;
        final int posWard = 4;
        final int posOazaCho = 5;
        final int posChome = 6;
        final int posKoaza = 7;
        // final int posMachiazaDist = 8; TODO 使用例が判明した時点で修正
        final int posPrcNum1 = 9;
        final int posPrcNum2 = 10;
        final int posPrcNum3 = 11;

        // 地番では省略されている地方自治体を呼び出し
        // lgCode = listCsv.get(0)[posLgCode];

        List<ZzAddress2PostalcodeEntity> listPoastal = zzAddress2PostalcodeRepository
                .findByAddressNameStartingWith(jichitai);
        List<ZzAddress2BlockEntity> listBlock = new ArrayList<>();

        String postalCode;
        String postalAddress;
        String postalAddressSet;
        ZzAddress2BlockEntity blockEntity;

        // TODO 実際には高速化のために郵便番号ごとにテーブル分割する
        for (String[] row : listCsv) {
            postalCode = blankChar;
            postalAddressSet = blankChar;

            // コード体系取得
            lgCode = row[posLgCode];
            machiazaId = row[posMachiazaId];
            prcId = row[posPrcId];

            // データ取得
            city = row[posCity];
            ward = row[posWard];
            oazaCho = row[posOazaCho];
            chome = this.convertChoume(row[posChome]);
            koaza = this.convertKoaza(row[posKoaza]);
            // machiazaDist = row[posMachiazaDist];
            prcNum1 = this.convertPlace1(row[posPrcNum1]);
            prcNum2 = this.convertPlace2(row[posPrcNum2]);
            prcNum3 = this.convertPlace3(row[posPrcNum3]);

            allAddress = jichitai + city + ward + oazaCho + chome + koaza + prcNum1 + prcNum2 + prcNum3;

            for (ZzAddress2PostalcodeEntity entityPostal : listPoastal) {
                postalAddress = entityPostal.getAddressName();
                if (allAddress.startsWith(postalAddress)) {
                    if (postalAddressSet.length() < postalAddress.length()) { // NOPMD
                        postalAddressSet = postalAddress;
                        postalCode = entityPostal.getPostalcode();
                    }
                }
            }

            blockEntity = new ZzAddress2BlockEntity(); // NOPMD
            blockEntity.setId(0);
            blockEntity.setValue(lgCode + "-" + machiazaId + "-" + prcId);
            blockEntity.setText(allAddress.replaceAll(postalAddressSet, ""));
            blockEntity.setAllAddress(allAddress);
            blockEntity.setPostalCode(postalCode);
            blockEntity.setChoume(this.convertChoumeNumber(chome));
            blockEntity.setPrc1(this.convertNumber(row[posPrcNum1]));
            blockEntity.setPrc2(this.convertNumber(row[posPrcNum2]));
            blockEntity.setPrc3(this.convertNumber(row[posPrcNum3]));

            listBlock.add(blockEntity);
        }

        return listBlock;
    }

    private String convertChoume(final String data) {

        if (blankChar.equals(data)) {
            return blankChar;
        }
        String numText = data.replaceAll("丁目", blankChar);
        int num = 9999999; // SUPPRESS CHECKSTYLE MagicNumber

        final int INT1 = 1;
        final int INT2 = 2;
        final int INT3 = 3;
        final int INT4 = 4;
        final int INT5 = 5;
        final int INT6 = 6;
        final int INT7 = 7;
        final int INT8 = 8;
        final int INT9 = 9;
        final int INT10 = 10;

        switch (numText) {
            case "一":
                num = INT1;
                break;
            case "二":
                num = INT2;
                break;
            case "三":
                num = INT3;
                break;
            case "四":
                num = INT4;
                break;
            case "五":
                num = INT5;
                break;
            case "六":
                num = INT6;
                break;
            case "七":
                num = INT7;
                break;
            case "八":
                num = INT8;
                break;
            case "九":
                num = INT9;
                break;
            case "十":
                num = INT10;
                break;
            default:
                // 何もしない
                break;
        }

        return num + "丁目";
    }

    private int convertChoumeNumber(final String data) {
        if (blankChar.equals(data)) {
            return 0;
        }

        String ans = data.replaceAll("丁目", "");

        return Integer.parseInt(ans);
    }

    private int convertNumber(final String data) {
        if (blankChar.equals(data)) {
            return 0;
        }
        return Integer.parseInt(data.replaceAll(data, data));
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
