package mitei.mitei.create.report.balance.politician.publish.validate; // NOPMD

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.publish.AllBookDto;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070100AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070200AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070300AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070400AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070500AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070600AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070701SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070702SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070703SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070801SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070802SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070803SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate070900AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071000AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071101SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071102SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071103SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071201SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071202SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071203SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071300AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071401SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071402SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071403SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071501SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071502SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071503SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071504SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071505SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071506SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071507SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071508SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071509SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071600AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071700AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071801SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071802SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071803SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071804SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071805SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071806SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071807SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071808SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071809SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071810SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071811SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071812SheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate071900AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate072000AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate080000AllSheetLogic;
import mitei.mitei.create.report.balance.politician.publish.validate.mock.MockValidate080200AllSheetLogic;

/**
 * XMLにどのシートにデータが入っているかいないかを表すテキスト。
 * 最低限の入力が行われた場合は「110000000000000000001000000000000010000000000000100」
 * ここから設計書がないので適当に逆リバース(苦笑、と言っても数はあっていると思う) 1：sheet1==表紙<br>
 * 1：sheet2==収入集計<br>
 * 0：sheet3<br>
 * 0：sheet4<br>
 * 0：sheet5<br>
 * 0：sheet6<br>
 * 0：sheet7-1<br>
 * 0：sheet7-2<br>
 * 0：sheet7-3<br>
 * 0：sheet8-1<br>
 * 0：sheet8-2<br>
 * 0：sheet8-3<br>
 * 0：sheet9<br>
 * 0：sheet10<br>
 * 0：sheet11-1<br>
 * 0：sheet11-2<br>
 * 0：sheet11-3<br>
 * 0：sheet12-1<br>
 * 0：sheet12-2<br>
 * 0：sheet12-3<br>
 * 1:sheet13==支出表紙<br>
 * 0：sheet14-1<br>
 * 0：sheet14-2<br>
 * 0：sheet14-3<br>
 * 0：sheet15-1<br>
 * 0：sheet15-2<br>
 * 0：sheet15-3<br>
 * 0：sheet15-4<br>
 * 0：sheet15-5<br>
 * 0：sheet15-6<br>
 * 0：sheet15-7<br>
 * 0：sheet15-8<br>
 * 0：sheet15-9<br>
 * 0：sheet16<br>
 * 1：sheet17==資産表紙<br>
 * 0：sheet18-1<br>
 * 0：sheet18-2<br>
 * 0：sheet18-3<br>
 * 0：sheet18-4<br>
 * 0：sheet18-5<br>
 * 0：sheet18-6<br>
 * 0：sheet18-7<br>
 * 0：sheet18-8<br>
 * 0：sheet18-9<br>
 * 0：sheet18-10<br>
 * 0：sheet18-11<br>
 * 0：sheet18-12<br>
 * 0：sheet19<br>
 * 1：sheet20==宣誓書<br>
 * 0：sheetその08-1<br>
 * 0：sheetその08-2<br>
 */
@Component
public class MakeUmuInputTextLogic {

    /** データ入力なしを表すフラグ */
    public static final int NASHI_INPUT_DATA_FLUG = 0;

    /** データ入力がされていることを表すフラグ */
    public static final int ARI_INPUT_DATA_FLUG = 1;

    /** validateLogic数 */
    private static final int COUNT_LOGIC = 51;

    /** 妥当性Logicシート070100 */
    @Autowired
    private Validate070100AllSheetLogic validate070100AllSheetLogic;

    /** 妥当性Logicシート070200 */
    @Autowired
    private Validate070200AllSheetLogic validate070200AllSheetLogic;

    /** 妥当性Logicシート070300 */
    @Autowired
    private Validate070300AllSheetLogic validate070300AllSheetLogic;

    /** 妥当性Logicシート070400 */
    @Autowired
    private Validate070400AllSheetLogic validate070400AllSheetLogic;

    /** 妥当性Logicシート070500 */
    @Autowired
    private Validate070500AllSheetLogic validate070500AllSheetLogic;

    /** 妥当性Logicシート070600 */
    @Autowired
    private Validate070600AllSheetLogic validate070600AllSheetLogic;

    /** 妥当性Logicシート070701 */
    @Autowired
    private Validate070701SheetLogic validate070701SheetLogic;

    /** 妥当性Logicシート070702 */
    @Autowired
    private Validate070702SheetLogic validate070702SheetLogic;

    /** 妥当性Logicシート070703 */
    @Autowired
    private Validate070703SheetLogic validate070703SheetLogic;

    /** 妥当性Logicシート070802 */
    @Autowired
    private Validate070801SheetLogic validate070801SheetLogic;

    /** 妥当性Logicシート070802 */
    @Autowired
    private Validate070802SheetLogic validate070802SheetLogic;

    /** 妥当性Logicシート070803 */
    @Autowired
    private Validate070803SheetLogic validate070803SheetLogic;

    /** 妥当性Logicシート070900 */
    @Autowired
    private Validate070900AllSheetLogic validate070900AllSheetLogic;

    /** 妥当性Logicシート071000 */
    @Autowired
    private Validate071000AllSheetLogic validate071000AllSheetLogic;

    /** 妥当性Logicシート071001 */
    @Autowired
    private Validate071101SheetLogic validate071101SheetLogic;

    /** 妥当性Logicシート071102 */
    @Autowired
    private Validate071102SheetLogic validate071102SheetLogic;

    /** 妥当性Logicシート071103 */
    @Autowired
    private Validate071103SheetLogic validate071103SheetLogic;

    /** 妥当性Logicシート071201 */
    @Autowired
    private Validate071201SheetLogic validate071201SheetLogic;

    /** 妥当性Logicシート071202 */
    @Autowired
    private Validate071202SheetLogic validate071202SheetLogic;

    /** 妥当性Logicシート071203 */
    @Autowired
    private Validate071203SheetLogic validate071203SheetLogic;

    /** 妥当性Logicシート071300 */
    @Autowired
    private Validate071300AllSheetLogic validate071300AllSheetLogic;

    /** 妥当性Logicシート071401 */
    @Autowired
    private Validate071401SheetLogic validate071401SheetLogic;

    /** 妥当性Logicシート071402 */
    @Autowired
    private Validate071402SheetLogic validate071402SheetLogic;

    /** 妥当性Logicシート071403 */
    @Autowired
    private Validate071403SheetLogic validate071403SheetLogic;

    /** 妥当性Logicシート071501 */
    @Autowired
    private Validate071501SheetLogic validate071501SheetLogic;

    /** 妥当性Logicシート071502 */
    @Autowired
    private Validate071502SheetLogic validate071502SheetLogic;

    /** 妥当性Logicシート071503 */
    @Autowired
    private Validate071503SheetLogic validate071503SheetLogic;

    /** 妥当性Logicシート071504 */
    @Autowired
    private Validate071504SheetLogic validate071504SheetLogic;

    /** 妥当性Logicシート071505 */
    @Autowired
    private Validate071505SheetLogic validate071505SheetLogic;

    /** 妥当性Logicシート071506 */
    @Autowired
    private Validate071506SheetLogic validate071506SheetLogic;

    /** 妥当性Logicシート071507 */
    @Autowired
    private Validate071507SheetLogic validate071507SheetLogic;

    /** 妥当性Logicシート071508 */
    @Autowired
    private Validate071508SheetLogic validate071508SheetLogic;

    /** 妥当性Logicシート071509 */
    @Autowired
    private Validate071509SheetLogic validate071509SheetLogic;

    /** 妥当性Logicシート071600 */
    @Autowired
    private Validate071600AllSheetLogic validate071600AllSheetLogic;

    /** 妥当性Logicシート071700 */
    @Autowired
    private Validate071700AllSheetLogic validate071700AllSheetLogic;

    /** 妥当性Logicシート071801 */
    @Autowired
    private Validate071801SheetLogic validate071801SheetLogic;

    /** 妥当性Logicシート071802 */
    @Autowired
    private Validate071802SheetLogic validate071802SheetLogic;

    /** 妥当性Logicシート071803 */
    @Autowired
    private Validate071803SheetLogic validate071803SheetLogic;

    /** 妥当性Logicシート071804 */
    @Autowired
    private Validate071804SheetLogic validate071804SheetLogic;

    /** 妥当性Logicシート071805 */
    @Autowired
    private Validate071805SheetLogic validate071805SheetLogic;

    /** 妥当性Logicシート071806 */
    @Autowired
    private Validate071806SheetLogic validate071806SheetLogic;

    /** 妥当性Logicシート071807 */
    @Autowired
    private Validate071807SheetLogic validate071807SheetLogic;

    /** 妥当性Logicシート071808 */
    @Autowired
    private Validate071808SheetLogic validate071808SheetLogic;

    /** 妥当性Logicシート071809 */
    @Autowired
    private Validate071809SheetLogic validate071809SheetLogic;

    /** 妥当性Logicシート071810 */
    @Autowired
    private Validate071810SheetLogic validate071810SheetLogic;

    /** 妥当性Logicシート071811 */
    @Autowired
    private Validate071811SheetLogic validate071811SheetLogic;

    /** 妥当性Logicシート071802 */
    @Autowired
    private Validate071812SheetLogic validate071812SheetLogic;

    /** 妥当性Logicシート071900 */
    @Autowired
    private Validate071900AllSheetLogic validate071900AllSheetLogic;

    /** 妥当性Logicシート072000 */
    @Autowired
    private Validate072000AllSheetLogic validate072000AllSheetLogic;

    /** 妥当性Logicシート080000 */
    @Autowired
    private Validate080000AllSheetLogic validate080000AllSheetLogic;

    /** 妥当性Logicシート082000 */
    @Autowired
    private Validate080200AllSheetLogic validate080200AllSheetLogic;
    
    /**
     * 全体のデータから入力有無フラグテキストを生成する
     *
     * @param allBookDto 全体データ
     * @return 有無(0/1)フラグが連結された文字列
     * @throws BalanceReportIchirenNoNotOrderException 妥当性Logicで投げられる例外を中継
     * @throws BalanceReportIchirenNoNotOrderException 妥当性Logicで投げられる例外を中継
     * @throws BalanceReportRequiredInputException 妥当性Logicで投げられる例外を中継
     * @throws BalanceReportDoesNotMatchSumException 妥当性Logicで投げられる例外を中継
     */
    public String practice(final AllBookDto allBookDto)
            throws BalanceReportIchirenNoNotOrderException, BalanceReportIchirenNoNotOrderException,
            BalanceReportRequiredInputException, BalanceReportDoesNotMatchSumException {

        StringBuilder stringBuilder = this.convertText(this.confimInputUmu(allBookDto));

        return stringBuilder.toString();
    }

    private boolean isNotRunBoot() {

        boolean answer = Objects.isNull(validate070100AllSheetLogic);

        // TODO validate logicの実装が完了した時点でMockから本実装Logicに入れ替えする
        // 1LogicでもNull・・・@autowiredが無効につき手動でインスタンスを生成する
        if (answer) {
            validate070100AllSheetLogic = new MockValidate070100AllSheetLogic();
            validate070200AllSheetLogic = new MockValidate070200AllSheetLogic();
            validate070300AllSheetLogic = new MockValidate070300AllSheetLogic();
            validate070400AllSheetLogic = new MockValidate070400AllSheetLogic();
            validate070500AllSheetLogic = new MockValidate070500AllSheetLogic();
            validate070600AllSheetLogic = new MockValidate070600AllSheetLogic();
            validate070701SheetLogic = new MockValidate070701SheetLogic();
            validate070702SheetLogic = new MockValidate070702SheetLogic();
            validate070703SheetLogic = new MockValidate070703SheetLogic();
            validate070801SheetLogic = new MockValidate070801SheetLogic();
            validate070802SheetLogic = new MockValidate070802SheetLogic();
            validate070803SheetLogic = new MockValidate070803SheetLogic();
            validate070900AllSheetLogic = new MockValidate070900AllSheetLogic();
            validate071000AllSheetLogic = new MockValidate071000AllSheetLogic();
            validate071101SheetLogic = new MockValidate071101SheetLogic();
            validate071102SheetLogic = new MockValidate071102SheetLogic();
            validate071103SheetLogic = new MockValidate071103SheetLogic();
            validate071201SheetLogic = new MockValidate071201SheetLogic();
            validate071202SheetLogic = new MockValidate071202SheetLogic();
            validate071203SheetLogic = new MockValidate071203SheetLogic();
            validate071300AllSheetLogic = new MockValidate071300AllSheetLogic();
            validate071401SheetLogic = new MockValidate071401SheetLogic();
            validate071402SheetLogic = new MockValidate071402SheetLogic();
            validate071403SheetLogic = new MockValidate071403SheetLogic();
            validate071501SheetLogic = new MockValidate071501SheetLogic();
            validate071502SheetLogic = new MockValidate071502SheetLogic();
            validate071503SheetLogic = new MockValidate071503SheetLogic();
            validate071504SheetLogic = new MockValidate071504SheetLogic();
            validate071505SheetLogic = new MockValidate071505SheetLogic();
            validate071506SheetLogic = new MockValidate071506SheetLogic();
            validate071507SheetLogic = new MockValidate071507SheetLogic();
            validate071508SheetLogic = new MockValidate071508SheetLogic();
            validate071509SheetLogic = new MockValidate071509SheetLogic();
            validate071600AllSheetLogic = new MockValidate071600AllSheetLogic();
            validate071700AllSheetLogic = new MockValidate071700AllSheetLogic();
            validate071801SheetLogic = new MockValidate071801SheetLogic();
            validate071802SheetLogic = new MockValidate071802SheetLogic();
            validate071803SheetLogic = new MockValidate071803SheetLogic();
            validate071804SheetLogic = new MockValidate071804SheetLogic();
            validate071805SheetLogic = new MockValidate071805SheetLogic();
            validate071806SheetLogic = new MockValidate071806SheetLogic();
            validate071807SheetLogic = new MockValidate071807SheetLogic();
            validate071808SheetLogic = new MockValidate071808SheetLogic();
            validate071809SheetLogic = new MockValidate071809SheetLogic();
            validate071810SheetLogic = new MockValidate071810SheetLogic();
            validate071811SheetLogic = new MockValidate071811SheetLogic();
            validate071812SheetLogic = new MockValidate071812SheetLogic();
            validate071900AllSheetLogic = new MockValidate071900AllSheetLogic();
            validate072000AllSheetLogic = new MockValidate072000AllSheetLogic();
            validate080000AllSheetLogic = new MockValidate080000AllSheetLogic();
            validate080200AllSheetLogic = new MockValidate080200AllSheetLogic();
        }

        return answer;
    }

    private int[] confimInputUmu(final AllBookDto allBookDto)
            throws BalanceReportIchirenNoNotOrderException, BalanceReportIchirenNoNotOrderException,
            BalanceReportRequiredInputException, BalanceReportDoesNotMatchSumException {
        this.isNotRunBoot();

        int[] intArrayInputUmu = new int[COUNT_LOGIC];
        int count = 0;

        //指定位置に各妥当性Logicからの値(0/1)をセット
        intArrayInputUmu[count++] = validate070100AllSheetLogic
                .practice(allBookDto.getAllSheet0701CoverAndOrganizationDetailsDto());
        intArrayInputUmu[count++] = validate070200AllSheetLogic.practice(allBookDto.getAllSheet0702SummaryTableIncomeDto());
        intArrayInputUmu[count++] = validate070300AllSheetLogic.practice(allBookDto.getAllSheet0703JournalAndOtherDto());
        intArrayInputUmu[count++] = validate070400AllSheetLogic.practice(allBookDto.getAllSheet0704BorrowedMoneyDto());
        intArrayInputUmu[count++] = validate070500AllSheetLogic.practice(allBookDto.getAllSheet0705IncomeRelatedToGrantsDto());
        intArrayInputUmu[count++] = validate070600AllSheetLogic.practice(allBookDto.getAllSheet0706OtherIncomeDto());
        intArrayInputUmu[count++] = validate070701SheetLogic.practice(allBookDto.getAllSheet0707DonateDto().getAllSheetKbn070701Dto());
        intArrayInputUmu[count++] = validate070702SheetLogic.practice(allBookDto.getAllSheet0707DonateDto().getAllSheetKbn070702Dto());
        intArrayInputUmu[count++] = validate070703SheetLogic.practice(allBookDto.getAllSheet0707DonateDto().getAllSheetKbn070703Dto());
        intArrayInputUmu[count++] = validate070801SheetLogic.practice(allBookDto.getAllSheet0708MediationDto().getAllSheetKbn070801Dto());
        intArrayInputUmu[count++] = validate070802SheetLogic.practice(allBookDto.getAllSheet0708MediationDto().getAllSheetKbn070802Dto());
        intArrayInputUmu[count++] = validate070803SheetLogic.practice(allBookDto.getAllSheet0708MediationDto().getAllSheetKbn070803Dto());
        intArrayInputUmu[count++] = validate070900AllSheetLogic.practice(allBookDto.getAllSheet0709AnonymousInPoliticalPartyDto());
        intArrayInputUmu[count++] = validate071000AllSheetLogic.practice(allBookDto.getAllSheet0710SpecificPartyDto());
        intArrayInputUmu[count++] = validate071101SheetLogic.practice(allBookDto.getAllSheet0711ConsiderationPartyDto().getAllSheetKbn071101Dto());
        intArrayInputUmu[count++] = validate071102SheetLogic.practice(allBookDto.getAllSheet0711ConsiderationPartyDto().getAllSheetKbn071102Dto());
        intArrayInputUmu[count++] = validate071103SheetLogic.practice(allBookDto.getAllSheet0711ConsiderationPartyDto().getAllSheetKbn071103Dto());
        intArrayInputUmu[count++] = validate071201SheetLogic.practice(allBookDto.getAllSheet0712PartyMediationDto().getAllSheetKbn071201Dto());
        intArrayInputUmu[count++] = validate071202SheetLogic.practice(allBookDto.getAllSheet0712PartyMediationDto().getAllSheetKbn071202Dto());
        intArrayInputUmu[count++] = validate071203SheetLogic.practice(allBookDto.getAllSheet0712PartyMediationDto().getAllSheetKbn071203Dto());
        intArrayInputUmu[count++] = validate071300AllSheetLogic.practice(allBookDto.getAllSheet0713ListOfExpenditureItemsDto());
        intArrayInputUmu[count++] = validate071401SheetLogic.practice(allBookDto.getAllSheet0714ConstsDto().getAllSheetKbn071401Dto());
        intArrayInputUmu[count++] = validate071402SheetLogic.practice(allBookDto.getAllSheet0714ConstsDto().getAllSheetKbn071402Dto());
        intArrayInputUmu[count++] = validate071403SheetLogic.practice(allBookDto.getAllSheet0714ConstsDto().getAllSheetKbn071403Dto());
        intArrayInputUmu[count++] = validate071501SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071501Dto());
        intArrayInputUmu[count++] = validate071502SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071502Dto());
        intArrayInputUmu[count++] = validate071503SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071503Dto());
        intArrayInputUmu[count++] = validate071504SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071504Dto());
        intArrayInputUmu[count++] = validate071505SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071505Dto());
        intArrayInputUmu[count++] = validate071506SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071506Dto());
        intArrayInputUmu[count++] = validate071507SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071507Dto());
        intArrayInputUmu[count++] = validate071508SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071508Dto());
        intArrayInputUmu[count++] = validate071509SheetLogic.practice(allBookDto.getAllSheet0715ExpenseDto().getAllSheetKbn071509Dto());
        intArrayInputUmu[count++] = validate071600AllSheetLogic.practice(allBookDto.getAllSheet0716RelatedToGrantsDtoDto());
        intArrayInputUmu[count++] = validate071700AllSheetLogic.practice(allBookDto.getAllSheet0717SummaryTableOfAssetsDto());
        intArrayInputUmu[count++] = validate071801SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071801Dto());
        intArrayInputUmu[count++] = validate071802SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071802Dto());
        intArrayInputUmu[count++] = validate071803SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071803Dto());
        intArrayInputUmu[count++] = validate071804SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071804Dto());
        intArrayInputUmu[count++] = validate071805SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071805Dto());
        intArrayInputUmu[count++] = validate071806SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071806Dto());
        intArrayInputUmu[count++] = validate071807SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071807Dto());
        intArrayInputUmu[count++] = validate071808SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071808Dto());
        intArrayInputUmu[count++] = validate071809SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071809Dto());
        intArrayInputUmu[count++] = validate071810SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071810Dto());
        intArrayInputUmu[count++] = validate071811SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071811Dto());
        intArrayInputUmu[count++] = validate071812SheetLogic.practice(allBookDto.getAllSheet0718AssetsDto().getAllSheetKbn071812Dto());
        intArrayInputUmu[count++] = validate071900AllSheetLogic.practice(allBookDto.getAllSheet0719RealEstateDto());
        intArrayInputUmu[count++] = validate072000AllSheetLogic.practice(allBookDto.getAllSheet0720OathDto());
        intArrayInputUmu[count++] = validate080000AllSheetLogic.practice(allBookDto.getAllSheet0800DifficultCollectReceiptDto());
        intArrayInputUmu[count] = validate080200AllSheetLogic.practice(allBookDto.getAllSheet0802WithdrawalItemsByTransferDto());

        return intArrayInputUmu;
    }

    private StringBuilder convertText(final int[] intArrayInputUmu) { // NOPMD
        StringBuilder stringBuilder = new StringBuilder();

        int max = intArrayInputUmu.length;

        for (int index = 0; index < max; index++) {
            stringBuilder.append(this.checkFlag(intArrayInputUmu[index]));
        }

        return stringBuilder;
    }

    private int checkFlag(final int data)throws IllegalArgumentException { // NOPMD
        if(data == 0 || data == 1) {
            return data;
        }
        throw new IllegalArgumentException("convertTextのデータには0,1のみを入力してください");
    }
}
