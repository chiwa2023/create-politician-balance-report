package mitei.mitei.create.report.balance.politician.publish.validate;

import java.util.Objects;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0703JournalAndOtherDto;
import mitei.mitei.create.report.balance.politician.dto.publish.Row070300JournalAndOtherDto;
import mitei.mitei.create.report.balance.politician.dto.publish.Sheet070300JournalAndOtherDto;

/**
 * 様式7その３シートの妥当性を検証するLogic
 */
public class Validate070300AllSheetLogic {

    /**
     * 入力・合計検算を行う
     *
     * @param allSheet0703 様式７その3全情報
     * @return 入力がされている場合は1,入力がない場合は0
     * @throws BalanceReportRequiredInputException     必須項目が未入力
     * @throws BalanceReportIchirenNoNotOrderException 行番号が順番通りでない
     * @throws BalanceReportDoesNotMatchSumException   リスト合計がページ計と一致しない
     */
    public int practice(final AllSheet0703JournalAndOtherDto allSheet0703) throws BalanceReportRequiredInputException,
            BalanceReportDoesNotMatchSumException, BalanceReportIchirenNoNotOrderException {

        // 必ず入力必須
        this.checkNull(allSheet0703, "引数自体");

        final String messException = "0703シート";

        // 子のシートも
        Sheet070300JournalAndOtherDto sheet070300Dto = allSheet0703.getSheet070300JournalAndOtherDto();
        this.checkNull(sheet070300Dto, messException);

        long sum = 0L;

        int sizeList = sheet070300Dto.getList().size();
        Row070300JournalAndOtherDto row;
        for (int index = 0; index < sizeList; index++) {
            row = sheet070300Dto.getList().get(index);
            sum = sum + row.getKingaku();
            if ((index + 1) != row.getIchirenNo()) {
                // 連番不正
                throw new BalanceReportIchirenNoNotOrderException("シート03行番号" + index + "番目");
            }

            this.checkNull(row.getJigyoNoShurui(), "シート03事業の種類" + index + "番目");
        }

        int answer = 0;
        if (0 == sizeList) {
            // リストサイズ0入力なし
            if (0 == sheet070300Dto.getPageTotal()) {
                // 入力なし正常
                answer = MakeUmuInputTextLogic.NASHI_INPUT_DATA_FLUG;
            } else {
                // 加算誤り入力
                throw new BalanceReportDoesNotMatchSumException(messException);
            }
        } else {
            // リストサイズ0より大きい＝入力あり
            if (sum == sheet070300Dto.getPageTotal()) {
                // 入力あり正常
                answer = MakeUmuInputTextLogic.ARI_INPUT_DATA_FLUG;
            } else {
                // 加算誤り入力
                throw new BalanceReportDoesNotMatchSumException(messException);
            }
        }

        return answer;
    }

    private boolean checkNull(final Object value, final String message) throws BalanceReportRequiredInputException {

        if (Objects.isNull(value)) {
            throw new BalanceReportRequiredInputException(message);
        }

        return true;
    }

}
