package mitei.mitei.create.report.balance.politician.publish.validate.mock;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0701CoverAndOrganizationDetailsDto;
import mitei.mitei.create.report.balance.politician.publish.validate.BalanceReportRequiredInputException;
import mitei.mitei.create.report.balance.politician.publish.validate.Validate070100AllSheetLogic;

/**
 * MockValidate070100AllSheetLogic
 */
public class MockValidate070100AllSheetLogic extends Validate070100AllSheetLogic{

    /**
     * 実装まちのため仮メソッド
     */
    @Override
    public int practice(final AllSheet0701CoverAndOrganizationDetailsDto allSheet0701)throws BalanceReportRequiredInputException {

        return 70100;//  SUPPRESS CHECKSTYLE MagicNumber
        
    }
}
