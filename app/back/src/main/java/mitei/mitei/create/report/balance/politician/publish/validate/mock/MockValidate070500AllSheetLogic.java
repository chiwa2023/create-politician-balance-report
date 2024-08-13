package mitei.mitei.create.report.balance.politician.publish.validate.mock;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0705IncomeRelatedToGrantsDto;
import mitei.mitei.create.report.balance.politician.publish.validate.Validate070500AllSheetLogic;

/**
 * シート5の入力状況を確認する妥当性チェックLogic
 */
public class MockValidate070500AllSheetLogic extends Validate070500AllSheetLogic{

    /**
     * 実装まちのため仮メソッド
     */
    @Override
    public int practice(final AllSheet0705IncomeRelatedToGrantsDto allSheet0705) {
        return 70500; //  SUPPRESS CHECKSTYLE MagicNumber
    }

}
