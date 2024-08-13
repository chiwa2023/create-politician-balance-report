package mitei.mitei.create.report.balance.politician.publish.validate.mock;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheetKbn071201Dto;
import mitei.mitei.create.report.balance.politician.publish.validate.Validate071201SheetLogic;

/**
 * シート12その１の入力状況を確認する妥当性チェックLogic
 */
public class MockValidate071201SheetLogic extends Validate071201SheetLogic{

    /**
     * 実装まちのため仮メソッド
     */
    @Override
    public int practice(final AllSheetKbn071201Dto kbnSheet071201) {
        return 71201; //  SUPPRESS CHECKSTYLE MagicNumber
    }

}
