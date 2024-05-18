package mitei.mitei.create.report.balance.politician.logic.balancesheet;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.CsvTradingRowConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;

/**
 * csvから収支報告書収入Entityに変換する
 */
@Component
public class CreateBalancesheetIncomeByCsvLogic {

    /** 指定なし */
    public static final int NO_POINT = CsvTradingRowConstants.NO_POINT;

    /** 取引金額支出 */
    public static final int OUTCOME_AMOUNT = CsvTradingRowConstants.OUTCOME_AMOUNT;

    /** 取引金額収入 */
    public static final int INCOME_AMOUNT = CsvTradingRowConstants.INCOME_AMOUNT;

    /** 取引金額増減兼用 */
    public static final int AMOUNT_IN_OUT = CsvTradingRowConstants.AMOUNT_IN_OUT;

    /** 発生日 */
    public static final int ACCURAL_DATE = CsvTradingRowConstants.ACCURAL_DATE;

    /** 摘要 */
    public static final int DIGEST = CsvTradingRowConstants.DIGEST;

    /** 取引相手名称 */
    public static final int TRADING_PERSON = CsvTradingRowConstants.TRADING_PERSON;

    /**
     * 変換処理を行う
     *
     * @param line        変換するcsvデータ
     * @param listPointer 列指定
     * @return 収支報告書収入Entity
     * @throws NumberFormatException  数値変換できなかった場合は処理を止める
     * @throws DateTimeParseException 日付変換できなかった場合は処理を止める
     */
    public BalancesheetIncome2025Entity practice(final List<CsvCellDto> line, final String[] listPointer) // NOPMD
            throws IllegalArgumentException,NumberFormatException, DateTimeParseException { // NOPMD
        final String csvText = "csv";
        final String pointerText = "csvの列指定";

        this.checkNull(line, csvText);
        this.checkNull(listPointer, pointerText);

        if (line.isEmpty()) {
            throw new IllegalArgumentException(csvText + "が空リストです");
        }
        if (listPointer.length == 0) {
            throw new IllegalArgumentException(pointerText + "空リストです");
        }

        BalancesheetIncome2025Entity incomeEntity = new BalancesheetIncome2025Entity();

        int max = listPointer.length;
        for (int index = 0; index < max; index++) {
            int action = Integer.parseInt(listPointer[index]);
            switch (action) {
                // 指定なし
                case NO_POINT:
                    // 何もしない
                    break;

                // 取引金額収入
                case INCOME_AMOUNT:
                    incomeEntity.setAmount(Long.parseLong(line.get(index).getData()));
                    break;

                // 取引金額支出は収入項目では不要
                // case OUTCOME_AMOUNT:
                // entity.setAmount(Integer.parseInt(line.get(index).getData()));
                // break;

                // 取引金額増減兼用
                case AMOUNT_IN_OUT:
                    long amount = Long.parseLong(line.get(index).getData());

                    if (amount >= 0) {
                        incomeEntity.setAmount(Long.parseLong(line.get(index).getData()));
                    }

                    break;

                // 発生日
                case ACCURAL_DATE:
                    // TODO 日付文字列を適切にフォーマットする
                    incomeEntity.setAccrualDate(LocalDate.parse(this.convertDateText(line.get(index).getData())));
                    break;

                // 摘要
                case DIGEST:
                    incomeEntity.setReferDigest(line.get(index).getData());
                    break;

                // 取引相手名称
                case TRADING_PERSON:
                    // TODO 仕様が決定次第修正する
                    break;

                // 設定されない指定内容
                default:
                    break;
            }
        }

        return incomeEntity;
    }

    private void checkNull(final Object object, final String mess) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(mess + "がnullです");
        }
    }

    private String convertDateText(final String text) {

        return text.replaceAll("/", "-");
    }
}
