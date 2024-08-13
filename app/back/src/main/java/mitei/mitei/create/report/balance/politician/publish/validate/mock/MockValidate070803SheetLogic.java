package mitei.mitei.create.report.balance.politician.publish.validate.mock;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheetKbn070803Dto;
import mitei.mitei.create.report.balance.politician.publish.validate.Validate070803SheetLogic;

/**
 * シート8その3の入力状況を確認する妥当性チェックLogic
 */
public class MockValidate070803SheetLogic extends Validate070803SheetLogic{

    /**
     * 実装まちのため仮メソッド
     */
    @Override
    public int practice(final AllSheetKbn070803Dto kbnSheet070803) {
        return 70803; //  SUPPRESS CHECKSTYLE MagicNumber
    }

}
