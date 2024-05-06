package mitei.mitei.create.report.balance.politician.service.balancesheet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancsheetInOutItemResultDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CsvTradingRowConstants;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.ReportKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.CallingItemEntity;
import mitei.mitei.create.report.balance.politician.observation.mock.MockWriteObservationTableUtil;
import mitei.mitei.create.report.balance.politician.repository.CallingItemRepository;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * CSVデータから収支報告書収入・支出項目リストを作成する
 */
@Service
public class CreateBalancesheetInOutByCsvService {

    /** 指定なし */
    public static final int NO_POINT = CsvTradingRowConstants.NO_POINT;

    /** 取引金額収入 */
    public static final int INCOME_AMOUNT = CsvTradingRowConstants.INCOME_AMOUNT;

    /** 取引金額支出 */
    public static final int OUTCOME_AMOUNT = CsvTradingRowConstants.OUTCOME_AMOUNT;

    /** 取引金額増減兼用 */
    public static final int AMOUNT_IN_OUT = CsvTradingRowConstants.AMOUNT_IN_OUT;

    /** 発生日 */
    public static final int ACCURAL_DATE = CsvTradingRowConstants.ACCURAL_DATE;

    /** 摘要 */
    public static final int DIGEST = CsvTradingRowConstants.DIGEST;

    /** 取引相手名称 */
    public static final int TRADING_PERSON = CsvTradingRowConstants.TRADING_PERSON;

    /** 取引相手名称 */
    private static final String BLANK_CHAR = "";

    /** 項目名称呼び出しRepository */
    @Autowired
    private CallingItemRepository callingItemRepository;

    /** Logger */
    private static final Logger log = LoggerFactory.getLogger(MockWriteObservationTableUtil.class);

    /**
     * 政治資金収支報告書支出項目リストと収入項目リストをcsvから生成する
     *
     * @param listCsvData csvリスト
     * @param saveStorageResultDto 書証保存Dto
     * @param checkPrivilegeDto 権限Dto
     * @param listPoiner csv項目読み取り指定
     * @return 両リスト格納Dto
     */
    public CreateBalancsheetInOutItemResultDto practice(final List<List<CsvCellDto>> listCsvData,
            final SaveStorageResultDto saveStorageResultDto, final CheckPrivilegeDto checkPrivilegeDto,
            final String[] listPoiner)throws Exception { // NOPMD

        List<BalancesheetIncome2025Entity> listIncome = new ArrayList<>();
        List<BalancesheetOutcome2025Entity> listOutcome = new ArrayList<>();
        List<CallingItemEntity> listCallingItem = new ArrayList<>();
        Boolean isIncome;
        
        int maxSize = listCsvData.size();
        List<CsvCellDto> line;
        for (int index = 0; index < maxSize; index++) {
            line = listCsvData.get(index);
            isIncome = this.isIncomeItem(line, listPoiner);

            if (Objects.nonNull(isIncome)) {
                if (isIncome) {
                    // 収入項目を設定する
                    listIncome.add(this.createIncomeEntity(saveStorageResultDto, checkPrivilegeDto, line, listPoiner,
                            index + 1,listCallingItem));
                } else {
                    // 支出項目を設定する
                    listOutcome.add(this.createOutcomeEntity(saveStorageResultDto, checkPrivilegeDto, line, listPoiner,
                            index + 1,listCallingItem));
                }

            } else {
                // TODO なんの設定もない場合はエラーとする
            }
        }

        // 作成したリストを格納
        CreateBalancsheetInOutItemResultDto createBalancsheetInOutItemResultDto = new CreateBalancsheetInOutItemResultDto();
        createBalancsheetInOutItemResultDto.setListIncome(listIncome);
        createBalancsheetInOutItemResultDto.setListOutcome(listOutcome);
        createBalancsheetInOutItemResultDto.setListCallingItem(listCallingItem);

        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        log.info(objectMapper.writeValueAsString(listCallingItem));
        
        return createBalancsheetInOutItemResultDto;
    }

    /**
     * 収入項目Entityを生成する
     *
     * @param saveStorageResultDto 書証保存Dto
     * @param checkPrivilegeDto 権限Dto
     * @param line csv行
     * @param listPointer csv読み取り列指定配列
     * @param readLine 読み取り行
     * @return 収入項目Entity
     */
    private BalancesheetIncome2025Entity createIncomeEntity(final SaveStorageResultDto saveStorageResultDto,
            final CheckPrivilegeDto checkPrivilegeDto, final List<CsvCellDto> line, final String[] listPointer,
            final int readLine,final List<CallingItemEntity> listCallingItem) { // NOPMD

        //TODO この内容はLogicにリファクタする

        BalancesheetIncome2025Entity entity = new BalancesheetIncome2025Entity();

        // 読み取りデータ書証
        entity.setShoshouId(saveStorageResultDto.getShoshouId());
        entity.setShoshouHistoryCode(saveStorageResultDto.getShoshouCode());
        entity.setShoshouKbn(saveStorageResultDto.getShoshouKbn());

        // 自身の政治団体とログインユーザ
        BeanUtils.copyProperties(checkPrivilegeDto, entity);

        // CSVに掲載されている内容を複写
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
                    entity.setAmount(Long.parseLong(line.get(index).getData()));
                    break;

                // 取引金額支出は収入項目では不要
                // case OUTCOME_AMOUNT:
                // entity.setAmount(Integer.parseInt(line.get(index).getData()));
                // break;

                // 取引金額増減兼用
                case AMOUNT_IN_OUT:
                    entity.setAmount(Long.parseLong(line.get(index).getData()));
                    break;

                // 発生日
                case ACCURAL_DATE:
                    // TODO 日付文字列を適切にフォーマットする
                    entity.setAccrualDate(LocalDate.parse(this.convertDateText(line.get(index).getData())));
                    break;

                // 摘要
                case DIGEST:
                    entity.setReferDigest(line.get(index).getData());
                    break;

                // 取引相手名称
                case TRADING_PERSON:
                    // TODO
                    break;

                // 設定されない指定内容
                default:
                    break;
            }
        }

        // CSVの摘要の内容からより詳細な設定を行う
        List<CallingItemEntity> listCalling = callingItemRepository
                .findByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest(
                        entity.getPoliticalOrganizationCode(),
                        SaishinKbnConstants.SAISHIN, 
                        entity.getReferDigest());

        // なにがしかデータが取れたら取得最初のデータをコピーする
        if (!listCalling.isEmpty()) {
            CallingItemEntity callingItemEntity = listCalling.get(0);
            BeanUtils.copyProperties(callingItemEntity, entity);

            // 項目
            entity.setItemName(callingItemEntity.getPublishItemName());
            // 住所
            entity.setOrgnizationAddress(callingItemEntity.getPublishOrgnizationAddress());
            // 代表者氏名又は個人の職業
            entity.setProfessionOrgnizationName(callingItemEntity.getPublishProfessionOrgnizationName());

            // TODO パーティ開催日は継続事業かつ事業がパーティである場合
            // TODO パーティ名称は継続事業かつ事業がパーティである場合

        }

        // 読み取り行
        entity.setReadingLine(readLine);

        // 書証区分・・・CSVファイル自動?
        entity.setShoshouKbn(saveStorageResultDto.getShoshouKbn());

        // これから登録しようとしているので最新データ
        entity.setSaishinKbn(SaishinKbnConstants.SAISHIN);

        // 入力済項目編集区分はきちんと読み取れていれば編集の必要はないのでfalse
        entity.setIsEditAutoInput(false);

        // 収支報告区分はフロントで決定するので仮に報告とする
        entity.setReportKbn(ReportKbnConstants.PUBLISH_REPORT);

        // あっせん期間はあまりに入力がこまかいので一旦省略

        // 意見付記は初期値空文字
        // 前例と異なる処理フラグは初期値false
        // 保全証票リストは初期値なし
        // 備考は初期値空文字

        listCallingItem.addAll(listCalling);
        return entity;
    }

    /**
     * 支出項目Entityを生成する
     *
     * @param saveStorageResultDto 書証保存Dto
     * @param checkPrivilegeDto 権限Dto
     * @param line csv行
     * @param listPointer csv読み取り結びつけ
     * @param readLine csv読み取り行(番目)
     * @return 支出項目Entity
     */
    private BalancesheetOutcome2025Entity createOutcomeEntity(final SaveStorageResultDto saveStorageResultDto,
            final CheckPrivilegeDto checkPrivilegeDto, final List<CsvCellDto> line, final String[] listPointer,
            final int readLine,final List<CallingItemEntity> listCallingItem) { // NOPMD

        //TODO この内容はLogicにリファクタする

        BalancesheetOutcome2025Entity entity = new BalancesheetOutcome2025Entity();

        // 読み取りデータ書証
        entity.setShoshouId(saveStorageResultDto.getShoshouId());
        entity.setShoshouHistoryCode(saveStorageResultDto.getShoshouCode());

        // 自身の政治団体とログインユーザ
        BeanUtils.copyProperties(checkPrivilegeDto, entity);

        // CSVに掲載されている内容を複写
        int max = listPointer.length;
        for (int index = 0; index < max; index++) {
            int action = Integer.parseInt(listPointer[index]);
            switch (action) {
                // 指定なし
                case NO_POINT:
                    // 何もしない
                    break;

                // 取引金額収入は支出項目では不要
                // case INCOME_AMOUNT:
                // entity.setAmount(Integer.parseInt(line.get(index).getData()));
                // break;

                // 取引金額支出
                case OUTCOME_AMOUNT:
                    entity.setAmount(Long.parseLong(line.get(index).getData()));
                    break;

                // 取引金額増減兼用
                case AMOUNT_IN_OUT:
                    entity.setAmount(Long.parseLong(line.get(index).getData()));
                    break;

                // 発生日
                case ACCURAL_DATE:
                    // TODO 日付文字列を適切にフォーマットする
                    entity.setAccrualDate(LocalDate.parse(this.convertDateText(line.get(index).getData())));
                    break;

                // 摘要
                case DIGEST:
                    entity.setReferDigest(line.get(index).getData());
                    break;

                // 取引相手名称
                case TRADING_PERSON:
                    // TODO
                    break;

                // 設定されない指定内容
                default:
                    break;
            }
        }
        
        // CSVの摘要の内容からより詳細な設定を行う
        List<CallingItemEntity> listCalling = callingItemRepository
                .findByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest(
                        entity.getPoliticalOrganizationCode(),
                        SaishinKbnConstants.SAISHIN, 
                        entity.getReferDigest());

        // なにがしかデータが取れたら取得最初のデータをコピーする
        if (!listCalling.isEmpty()) {
            CallingItemEntity callingItemEntity = listCalling.get(0);
            BeanUtils.copyProperties(callingItemEntity, entity);

            // 項目
            entity.setItemName(callingItemEntity.getPublishItemName());
            // 住所
            entity.setOrgnizationAddress(callingItemEntity.getPublishOrgnizationAddress());
            // 代表者氏名又は個人の職業
            entity.setProfessionOrgnizationName(callingItemEntity.getPublishProfessionOrgnizationName());

        }

        // 読み取り行
        entity.setReadingLine(readLine);

        // 書証区分・・・CSVファイル自動?
        entity.setShoshouKbn(saveStorageResultDto.getShoshouKbn());

        // これから登録しようとしているので最新データ
        entity.setSaishinKbn(SaishinKbnConstants.SAISHIN);

        // 入力済項目編集区分はきちんと読み取れていれば編集の必要はないのでfalse
        entity.setIsEditAutoInput(false);

        // 収支報告区分はフロントで決定するので仮に報告とする
        entity.setReportKbn(ReportKbnConstants.PUBLISH_REPORT);

        
        //TODO 支出大項目は仕様が決定次第修正する
        //TODO 項目名称区分は仕様が決定次第修正する
        
        // 領収書を徴しがたかったものは初期値false
        // 交付金に係る支出は初期値-1
        
        // 意見付記は初期値空文字
        // 前例と異なる処理フラグは初期値false
        // 保全証票リストは初期値なし
        // 備考は初期値空文字

        listCallingItem.addAll(listCalling);

        return entity;
    }

    private Boolean isIncomeItem(final List<CsvCellDto> line, final String[] listPointer) { // NOPMD

        int max = listPointer.length;

        for (int index = 0; index < max; index++) {
            int action = Integer.parseInt(listPointer[index]);
            // 収支項目が設定されている
            if (INCOME_AMOUNT == action) {
                if (!BLANK_CHAR.equals(line.get(index).getData())) { //NOPMD
                    return true;
                }
            }
            // 支出項目が設定されている
            if (OUTCOME_AMOUNT == action) {
                if (!BLANK_CHAR.equals(line.get(index).getData())) { //NOPMD
                    return false;
                }
            }
            if (AMOUNT_IN_OUT == action) {
                int tempAmount = Integer.parseInt(line.get(index).getData());
                // 金額が0より大きいときは収入項目小さい時は支出項目
                return tempAmount > 0;
            }
        }

        return null;
    }

    private String convertDateText(final String text) {

        return text.replaceAll("/", "-");
    }
}
