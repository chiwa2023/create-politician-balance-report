package mitei.mitei.create.report.balance.politician.publish.validate.mock;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheetKbn070702Dto;
import mitei.mitei.create.report.balance.politician.publish.validate.Validate070702SheetLogic;

/**
 * シート7その2の入力状況を確認する妥当性チェックLogic
 */
public class MockValidate070702SheetLogic extends Validate070702SheetLogic{

    /**
     * 実装まちのため仮メソッド
     */
    @Override
    public int practice(final AllSheetKbn070702Dto kbnSheet070702) {
        return 70702; //  SUPPRESS CHECKSTYLE MagicNumber
    }

}
