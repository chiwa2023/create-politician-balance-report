package mitei.mitei.create.report.balance.politician.service.balancesheet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.CreateBalancsheetInOutItemResultDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.ReportKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.service.read_csv.ReadCsvReadByFileService;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * CreateBalancesheetInOutByCsvService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CreateBalancesheetInOutByCsvServiceTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private CreateBalancesheetInOutByCsvService createBalancesheetInOutByCsvService;

    @Test
    void test() throws Exception {

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "service/read_csv/read_csv_test.csv");
        String fileContent = Files.readString(path);

        ReadCsvReadByFileService ReadCsvReadByFileService = new ReadCsvReadByFileService();
        List<List<CsvCellDto>> listCsv = ReadCsvReadByFileService.practice(fileContent);
        String shoshouId = "/96325/zrgzrgaskda/20221212123456888";

        SaveStorageResultDto saveStorageResultDto = new SaveStorageResultDto();
        saveStorageResultDto.setShoshouId(shoshouId);
        saveStorageResultDto.setShoshouCode(3377L);
        saveStorageResultDto.setShoshouKbn(3);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setLoginUserId(1007L);
        checkPrivilegeDto.setLoginUserCode(1007);
        checkPrivilegeDto.setPoliticalOrganizationId(2345L);
        checkPrivilegeDto.setPoliticalOrganizationCode(2333);
        checkPrivilegeDto.setPoliticalOrganizationName("サンプル政治団体");

        //ヘッダ行を除去
        listCsv.remove(0);
        
        String[] listPointer = "15,1,2,16,0,0,0".split(",");

        CreateBalancsheetInOutItemResultDto resultDto = createBalancesheetInOutByCsvService.practice(listCsv,
                saveStorageResultDto, checkPrivilegeDto, listPointer);

        List<BalancesheetIncome2025Entity> listIncome = resultDto.getListIncome();

        BalancesheetIncome2025Entity incomeEntity1 = listIncome.get(0);

        /* 収入 */
        // 政治資金収支報告書収入項目Id'::テーブル登録直前に設定、初期値-1,
        assertThat(incomeEntity1).isEqualTo(incomeEntity1);

        // '政治資金収支報告書収入項目同一識別コード'::テーブル登録直前に設定、初期値-1,
        assertThat(incomeEntity1.getBalancesheetIncomeCode()).isEqualTo(-1L);

        // '最新区分'::最新データ,
        assertThat(incomeEntity1.getSaishinKbn()).isEqualTo(SaishinKbnConstants.SAISHIN);

        // '政治資金団体Id'::値設定,
        assertThat(incomeEntity1.getPoliticalOrganizationId())
                .isEqualTo(checkPrivilegeDto.getPoliticalOrganizationId());

        // '政治資金団体同一識別コード'::値設定,
        assertThat(incomeEntity1.getPoliticalOrganizationCode())
                .isEqualTo(checkPrivilegeDto.getPoliticalOrganizationCode());

        // '政治資金団体名称'::値設定,
        assertThat(incomeEntity1.getPoliticalOrganizationName())
                .isEqualTo(checkPrivilegeDto.getPoliticalOrganizationName());

        // '書証Id'::登録済の値設定,
        assertThat(incomeEntity1.getShoshouId()).isEqualTo(saveStorageResultDto.getShoshouId());

        // '書証識別コード'::値設定,
        assertThat(incomeEntity1.getShoshouHistoryCode()).isEqualTo(saveStorageResultDto.getShoshouCode());

        // '書証区分'::値設定：：仕様未定,
        assertThat(incomeEntity1.getShoshouKbn()).isEqualTo(saveStorageResultDto.getShoshouKbn());

        // '書証読み取り行':::2行目,
        assertThat(incomeEntity1.getReadingLine()).isEqualTo(2);

        // '参照した摘要'::お引き出し(csvの値),
        assertThat(incomeEntity1.getReferDigest()).isEqualTo("政治家花子からの寄付");

        // `amount`::123456(csvの値),
        assertThat(incomeEntity1.getAmount()).isEqualTo(123456L);

        // '発生日'::2022/12/29(csvの値),
        assertThat(incomeEntity1.getAccrualDate()).isEqualTo(LocalDate.of(2022, 12, 29));

        // 自動読み取り値編集::false(していません),
        assertThat(incomeEntity1.getIsEditAutoInput()).isEqualTo(false);

        // '収支報告区分'::初期値は報告(1),
        assertThat(incomeEntity1.getReportKbn()).isEqualTo(ReportKbnConstants.PUBLISH_REPORT);

         // '様式仕訳区分',
         assertThat(incomeEntity1.getYoushikiKbn()).isEqualTo(7);

         // '様式仕訳枝項目区分',
          assertThat(incomeEntity1.getYoushikiEdaKbn()).isEqualTo(1);

        // '項目名称'::DB登録値,
        assertThat(incomeEntity1.getItemName()).isEqualTo("320");

        // '項目名称Id区分',calling_itemに追加予定
        // TODO assertThat(incomeEntity1.getItemIdKbn()).isEqualTo(incomeEntity1);

        // '一般項目名称Id'::DB登録値,
        assertThat(incomeEntity1.getGeneralItemId()).isEqualTo(323L);

        // '一般名称同一識別コード'::DB登録値,
        assertThat(incomeEntity1.getGeneralItemCode()).isEqualTo(324);

        // `継続事業Id'::DB登録値,
        assertThat(incomeEntity1.getContinueBuissinessId()).isEqualTo(325L);

        // '継続事業同一識別コード'::DB登録値,
        assertThat(incomeEntity1.getContinueBuissinessCode()).isEqualTo(326);

        // '関連者区分'::DB登録値,
        assertThat(incomeEntity1.getRelationKbn()).isEqualTo(327);

        // '関連者個人Id'::DB登録値,
        assertThat(incomeEntity1.getRelationPersonId()).isEqualTo(328L);

        // '関連者個人同一識別コード'::DB登録値,
        assertThat(incomeEntity1.getRelationPersonCode()).isEqualTo(329);

        // '関連者法人Id'::DB登録値,
        assertThat(incomeEntity1.getRelationCorporationId()).isEqualTo(330L);

        // '関連者法人同一識別コード'::DB登録値,
        assertThat(incomeEntity1.getRelationCorporationCode()).isEqualTo(331);

        // '関連者政治団体Id'::DB登録値,
        assertThat(incomeEntity1.getRelationPoliticsOrganizationId()).isEqualTo(332L);

        // '関連者政治団体同一識別コード'::DB登録値,
        assertThat(incomeEntity1.getRelationPoliticsOrganizationCode()).isEqualTo(333);

        // '個人・団体住所'::DB登録値,
        assertThat(incomeEntity1.getOrgnizationAddress()).isEqualTo("321");

        // '団体代表者・職業'::DB登録値,
        assertThat(incomeEntity1.getProfessionOrgnizationName()).isEqualTo("322");

        // '集めた期間開始日'あっせん関連は自動入力の範囲外とします=初期値,
        assertThat(incomeEntity1.getMediationStartDate()).isEqualTo(LocalDate.of(1980, 1, 1));

        // '集めた期間終了日'あっせん関連は自動入力の範囲外とします=初期値,
        assertThat(incomeEntity1.getMediationEndDate()).isEqualTo(LocalDate.of(1980, 1, 1));

        // 'パーティ開催日':::TODO 継続事業でパーティを選択されていたらパーティ開催日,
        assertThat(incomeEntity1.getPartyDate()).isEqualTo(LocalDate.of(1980, 1, 1));

        // '備考'::遺贈などのフラグの反映場所、という意味合いが強いので最初は空文字
        assertThat(incomeEntity1.getBiko()).isEqualTo("");

        // '税額控除有無'特殊条件につき初期値はfalse,
        assertThat(incomeEntity1.getIsCreditTax()).isEqualTo(false);

        // '寄付が遺贈有無フラグ'特殊条件に付き初期値はfalse,
        assertThat(incomeEntity1.getIsBequest()).isEqualTo(false);

        // '寄付法人が上場または外資50%超え会社有無フラグ'::基本的にはfalse,TODO 関連者法人で属性として追加したらそれを複写,
        assertThat(incomeEntity1.getIsPrimeListedOrForeign()).isEqualTo(false);

        // '政治資金パーティ名称':::TODO 継続事業でパーティを選択されていたら継続事業名,
        // assertThat(incomeEntity1.getPartyName()).isEqualTo(incomeEntity1);

        // '意見付記'ユーザさんがデータの条件を鑑みて付記しない限りは空文字,
        assertThat(incomeEntity1.getNote()).isEqualTo("");

        // '前例と異なる処理フラグ'::ユーザさんが意図的に編集可能にしない限りfalse,
        assertThat(incomeEntity1.getIsDifferPrecedent()).isEqualTo(false);

        // '保全証票リスト'意見付記の強化機能のため、意見付記がない限りは空配列,
        // assertThat(incomeEntity1.getStoragedDocumentIdList().length()).isEqualTo(0);

        // 'ログインユーザId',
        assertThat(incomeEntity1.getLoginUserId()).isEqualTo(checkPrivilegeDto.getLoginUserId());

        // 'ログインユーザ同一識別コード',
        assertThat(incomeEntity1.getLoginUserCode()).isEqualTo(checkPrivilegeDto.getLoginUserCode());

        // '更新時間'::登録直前にセット,
        // assertThat(incomeEntity1.getUpdtateTime()).isEqualTo();

        
        
        
        
        /* 支出項目 */
        List<BalancesheetOutcome2025Entity> listOutcome = resultDto.getListOutcome();

        BalancesheetOutcome2025Entity outcomeEntity1 = listOutcome.get(1);

        // '政治資金収支報告書主出項目Id',テーブルに登録持に設定::初期値
        assertThat(outcomeEntity1.getBalancesheetOutcomeId()).isEqualTo(-1L);

        // '政治資金収支報告書支出項目同一識別コード',テーブルに登録持に設定::初期値
        assertThat(outcomeEntity1.getBalancesheetOutcomeCode()).isEqualTo(-1);

        // '最新区分',最新データです
        assertThat(outcomeEntity1.getSaishinKbn()).isEqualTo(SaishinKbnConstants.SAISHIN);

        // '政治資金団体Id'::設定値,
        assertThat(outcomeEntity1.getPoliticalOrganizationId()).isEqualTo(checkPrivilegeDto.getPoliticalOrganizationId());

        // '政治資金団体同一識別コード'::設定値,
        assertThat(outcomeEntity1.getPoliticalOrganizationCode()).isEqualTo(checkPrivilegeDto.getPoliticalOrganizationCode());

        // '政治資金団体名称'::設定値,
        assertThat(outcomeEntity1.getPoliticalOrganizationName()).isEqualTo(checkPrivilegeDto.getPoliticalOrganizationName());

        // '書証Id'::設定値,
        assertThat(outcomeEntity1.getShoshouId()).isEqualTo(saveStorageResultDto.getShoshouId());

        // '書証識別コード'::設定値,
        assertThat(outcomeEntity1.getShoshouHistoryCode()).isEqualTo(saveStorageResultDto.getShoshouCode());

        // '書証区分::設定値',
        assertThat(outcomeEntity1.getShoshouKbn()).isEqualTo(saveStorageResultDto.getShoshouKbn());

        // '書証読み取り行'このデータでは支出項目の2項目目はcsvの3行目,
        assertThat(outcomeEntity1.getReadingLine()).isEqualTo(3);

        // '参照した摘要'::csv取得値,
        assertThat(outcomeEntity1.getReferDigest()).isEqualTo("ﾌﾘｶｴ ｼｭﾄｹﾝﾃﾞﾝｷ");

        // 取引金額::csv取得値,
        assertThat(outcomeEntity1.getAmount()).isEqualTo(12345L);

        // '発生日'::csv取得値,
        assertThat(outcomeEntity1.getAccrualDate()).isEqualTo(LocalDate.of(2022, 12, 27));

        // `自動データの編集`ユーザさんが編集すると操作してはじめてtrueになる
        assertThat(outcomeEntity1.getIsEditAutoInput()).isEqualTo(false);

        // '収支報告区分'収支報告する,
        assertThat(outcomeEntity1.getReportKbn()).isEqualTo(ReportKbnConstants.PUBLISH_REPORT);

        // '様式仕訳区分'::Db設定値,
        assertThat(outcomeEntity1.getYoushikiKbn()).isEqualTo(15);

        // '様式仕訳枝項目区分'::Db設定値,
        assertThat(outcomeEntity1.getYoushikiEdaKbn()).isEqualTo(2);

        // '支出大項目',TODO calling_itemに追加予定
        //assertThat(outcomeEntity1.getCategorizeGroup()).isEqualTo(outcomeEntity1);

        // '項目名称'::Db設定値,
        assertThat(outcomeEntity1.getItemName()).isEqualTo("420");

        // '項目名称Id区分',  TODO calling_itemに追加予定 
        //assertThat(outcomeEntity1.getItemIdKbn()).isEqualTo(-1);

        // '一般項目名称Id'::Db設定値,
        assertThat(outcomeEntity1.getGeneralItemId()).isEqualTo(423L);

        // '一般名称同一識別コード'::Db設定値,
        assertThat(outcomeEntity1.getGeneralItemCode()).isEqualTo(424);

        // '継続事業Id'::Db設定値,
        assertThat(outcomeEntity1.getContinueBuissinessId()).isEqualTo(425L);

        // '継続事業同一識別コード'::Db設定値,
        assertThat(outcomeEntity1.getContinueBuissinessCode()).isEqualTo(426);

        // '関連者区分'::Db設定値,
        assertThat(outcomeEntity1.getRelationKbn()).isEqualTo(427);

        // '関連者個人Id'::Db設定値,
        assertThat(outcomeEntity1.getRelationPersonId()).isEqualTo(428L);

        // '関連者個人同一識別コード'::Db設定値,
        assertThat(outcomeEntity1.getRelationPersonCode()).isEqualTo(429);

        // '関連者法人Id'::Db設定値,
        assertThat(outcomeEntity1.getRelationCorporationId()).isEqualTo(430L);

        // '関連者法人同一識別コード'::Db設定値,
        assertThat(outcomeEntity1.getRelationCorporationCode()).isEqualTo(431);

        // '関連者政治団体Id',::Db設定値
        assertThat(outcomeEntity1.getRelationPoliticsOrganizationId()).isEqualTo(432L);

        // '関連者政治団体同一識別コード',::Db設定値
        assertThat(outcomeEntity1.getRelationPoliticsOrganizationCode()).isEqualTo(433);

        // '個人・団体住所'::Db設定値,
        assertThat(outcomeEntity1.getOrgnizationAddress()).isEqualTo("421");

        // '団体代表者・職業'::Db設定値,
        assertThat(outcomeEntity1.getProfessionOrgnizationName()).isEqualTo("422");

        // '備考',フラグ関係記載に使っている傾向がありますので基本は空文字
        assertThat(outcomeEntity1.getBiko()).isEqualTo("");

        // '交付金に係る支出'特殊条件のため初期値false,
        assertThat(outcomeEntity1.getIsExpendituresRelatedGrants()).isEqualTo(false);

        // '領収書を徴しがたかったもの'特殊条件のため基本的にfalse,
        assertThat(outcomeEntity1.getNotCollectReciptKbn()).isEqualTo(false);

        // '意見付記'データをユーザさんが確認して必要に応じ追加します→空文字,
        assertThat(outcomeEntity1.getNote()).isEqualTo("");

        // '前例と異なる処理フラグ'::ユーザさんが操作した時にtrueになります,
        assertThat(outcomeEntity1.getIsDifferPrecedent()).isEqualTo(false);

        // '保全証票リスト'意見付記の強化機能のため、意見付記が空ならこの項目も基本的に空です,
        //assertThat(outcomeEntity1.getStoragedDocumentIdList()).isEqualTo(outcomeEntity1);

        // 'ログインユーザId'::設定値,
        assertThat(outcomeEntity1.getLoginUserId()).isEqualTo(checkPrivilegeDto.getLoginUserId());

        // 'ログインユーザ同一識別コード'::設定値,
        assertThat(outcomeEntity1.getLoginUserCode()).isEqualTo(checkPrivilegeDto.getLoginUserCode());

        // '更新時間'テーブル直前に投入,
        //assertThat(outcomeEntity1.getUpdateTime()).isEqualTo(outcomeEntity1);
        
        fail("Not yet implemented");
    }

}
