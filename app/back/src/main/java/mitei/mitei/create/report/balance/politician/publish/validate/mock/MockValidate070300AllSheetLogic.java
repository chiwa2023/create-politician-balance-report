package mitei.mitei.create.report.balance.politician.publish.validate.mock;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0703JournalAndOtherDto;
import mitei.mitei.create.report.balance.politician.publish.validate.BalanceReportDoesNotMatchSumException;
import mitei.mitei.create.report.balance.politician.publish.validate.BalanceReportIchirenNoNotOrderException;
import mitei.mitei.create.report.balance.politician.publish.validate.BalanceReportRequiredInputException;
import mitei.mitei.create.report.balance.politician.publish.validate.Validate070300AllSheetLogic;

/**
 * MockValidate070300AllSheetLogic
 */
public class MockValidate070300AllSheetLogic extends Validate070300AllSheetLogic {

    /**
     * 実装まちのため仮メソッド
     */
    @Override
    public int practice(final AllSheet0703JournalAndOtherDto allSheet0703) throws BalanceReportRequiredInputException,
            BalanceReportDoesNotMatchSumException, BalanceReportIchirenNoNotOrderException {


        return 70300; //  SUPPRESS CHECKSTYLE MagicNumber
    }

}
