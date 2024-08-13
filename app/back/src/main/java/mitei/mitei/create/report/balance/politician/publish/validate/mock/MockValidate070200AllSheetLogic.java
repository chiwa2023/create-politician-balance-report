package mitei.mitei.create.report.balance.politician.publish.validate.mock;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0702SummaryTableIncomeDto;
import mitei.mitei.create.report.balance.politician.publish.validate.Validate070200AllSheetLogic;

/**
 * シート2の入力状況を確認する妥当性チェックLogic
 */
public class MockValidate070200AllSheetLogic extends Validate070200AllSheetLogic{

    /**
     * 実装まちのため仮メソッド
     */
    @Override
    public int practice(final AllSheet0702SummaryTableIncomeDto allSheet0702) {
        return 70200; //  SUPPRESS CHECKSTYLE MagicNumber
    }

}
