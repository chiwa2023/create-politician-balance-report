package mitei.mitei.create.report.balance.politician.logic.read_csv;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.CsvTradingRowConstants;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;

/**
 * 列指定項目の妥当性を確認する
 */
@Component
public class CheckValidateCsvPointListLogic {

    /** 指定なし */
    private static final int NO_POINT = CsvTradingRowConstants.NO_POINT;

    /** 取引金額支出 */
    private static final int OUTCOME_AMOUNT = CsvTradingRowConstants.OUTCOME_AMOUNT;

    /** 取引金額収入 */
    private static final int INCOME_AMOUNT = CsvTradingRowConstants.INCOME_AMOUNT;

    /** 取引金額増減兼用 */
    private static final int AMOUNT_IN_OUT = CsvTradingRowConstants.AMOUNT_IN_OUT;

    /** 発生日 */
    private static final int ACCURAL_DATE = CsvTradingRowConstants.ACCURAL_DATE;

    /** 摘要 */
    private static final int DIGEST = CsvTradingRowConstants.DIGEST;

    // TODO 仕様決定次第修正する
    /// ** 取引相手名称 */
    // private static final int TRADING_PERSON =
    /// CsvTradingRowConstants.TRADING_PERSON;

    /**　1(回指定)を表す定数 */
    private final static int leastTime = 1;

    /** 正常時に指定する空メッセージ */
    private final static String blank = "";

    /**
     * 妥当性チェック
     *
     * @param listPoint 検査するcsv列項目結びつけ指定
     * @return 検査結果
     */
    public TemplateFrameworkResultDto practice(final String[] listPoint) { // NOPMD

        int counterDate = 0;
        int counterIncome = 0;
        int counterOutcome = 0;
        int counterInOut = 0;
        int counterDigest = 0;

        int point;
        for (String data : listPoint) {
            point = Integer.parseInt(data);
            switch (point) {
                // 指定なし
                case NO_POINT:
                    break;

                // 日付
                case ACCURAL_DATE:
                    counterDate++;
                    break;

                // 収入
                case INCOME_AMOUNT:
                    counterIncome++;
                    break;

                // 支出
                case OUTCOME_AMOUNT:
                    counterOutcome++;
                    break;

                // 金額増減
                case AMOUNT_IN_OUT:
                    counterInOut++;
                    break;

                // 摘要
                case DIGEST:
                    counterDigest++;
                    break;
                    
                // 定数以外の値が紛れていたら即アウト(front側で制御しているので実装ミス、あるいはデータベース直接押し込み)
                default:
                    throw new IllegalArgumentException("CsvTradingRowConstants以外の定数が指定されています");
            }
        }

        // 日付の指定は1回だけ
        if (leastTime != counterDate) {
            return this.createFailuerState("日付は1回だけ指定してください");
        }

        // 摘要の指定は0,1回だけで指定なしを許容します
        if (leastTime< counterDigest) {
            return this.createFailuerState("摘要はは2回以上指定しないでください");
        }

        //増減条件検証
        String checkInOut = this.checkInOut(counterInOut,counterIncome,counterOutcome);
        if(!blank.equals(checkInOut)) {
            return this.createFailuerState(checkInOut);
        }
        
        //収入と支出条件を検証
        String checkAmount = this.checkAmount(counterIncome,counterOutcome);
        if(!blank.equals(checkAmount)) {
            return this.createFailuerState(checkAmount);
        }

        //すべてのチェックをパスしたら正常
        TemplateFrameworkResultDto resultDto = new TemplateFrameworkResultDto();
        resultDto.setIsOk(true);

        return resultDto;
    }

    private String checkInOut(final int counterInOut,final int counterIncome,final int counterOutcome) {

        //増減条件
        if (leastTime == counterInOut) {
            if (counterIncome != 0 || counterOutcome != 0) {
                // 増減兼用を含んだら収入・支出ともリストに含んではいけません
                return "増減兼用を指定したら支出・収入を指定しないでください";
            }
        } else {
            //1または0でなく重複を許容しません
            if(0 != counterInOut) {
                return "2回以上増減兼用を指定しないでください";
            }
        }

        return blank;
    }

    private String checkAmount(final int counterIncome,final int counterOutcome) {

        // 収入の指定は0,1回だけで指定なしを許容します
        if (leastTime< counterIncome) {
            return "2回以上収入を指定しないでください";
        }


        // 支出の指定は0,1回だけで指定なしを許容します
        if (leastTime< counterOutcome) {
            return "2回以上支出を指定しないでください";
        }

        // 支出が1回指定されたら収入も1回指定
        if (leastTime == counterOutcome) {
            if(leastTime != counterIncome) { // NOPMD
                return "支出を指定したら収入を1回指定してください";
            }
        }

        // 収入が1回指定されたら支出も1回指定
        if (leastTime == counterIncome) {
            if(leastTime != counterOutcome) { // NOPMD
                return "収入を指定したら支出を1回指定してください";
            }
        }

        return blank;
    }

    private TemplateFrameworkResultDto createFailuerState(final String message) {
        //不正時のResultDtoを生成します
        TemplateFrameworkResultDto dto = new TemplateFrameworkResultDto();
        dto.setIsOk(false);
        dto.setMessage(message);
        return dto;
    }



}
