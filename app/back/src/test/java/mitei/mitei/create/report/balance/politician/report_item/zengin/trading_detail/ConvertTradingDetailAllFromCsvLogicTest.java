package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.TradingZenginFormatTransactionDetailDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailEndRecordDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailGroup1OrdinalyDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailGroup2NoticeDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailHeaderRecordDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailTrailerRecordDto;

/**
 * ConvertTradingDetailAllFromCsvLogic単体テスト
 */
class ConvertTradingDetailAllFromCsvLogicTest {
    // CHECKSTYLE:OFF

    @Test
    void testPractice() throws Exception { // NOPMD
        ConvertTradingDetailAllFromCsvLogic convertTradingDetailAllFromCsvLogic = new ConvertTradingDetailAllFromCsvLogic();

        Path path = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(), "report_item/zegin_csv_format.csv");

        MultipartFile file = new MockMultipartFile("zegin_csv_format", new FileInputStream(path.toFile())); // NOPMD

        try (Reader reader = new InputStreamReader(file.getInputStream());) {

            TradingZenginFormatTransactionDetailDto detailDto = convertTradingDetailAllFromCsvLogic.practice(reader);

            List<TradingZenginFormatTransactionDetailGroup1OrdinalyDto> listGroup1 = detailDto.getListGroup1();

            // 1組データが入っている
            assertThat(listGroup1.size()).isEqualTo(1);

            /* ヘッダレコード */
            TradingZenginFormatTransactionDetailHeaderRecordDto headerDto1 = listGroup1.get(0) // NOPMD
                    .getTradingZenginFormatTransactionDetailHeaderRecordDto();
            assertThat(headerDto1.getDataKbn()).isEqualTo(1);
            assertThat(headerDto1.getBusinessType()).isEqualTo("03");
            assertThat(headerDto1.getCodeKbn()).isEqualTo(0);
            assertThat(headerDto1.getDateMaking()).isEqualTo(LocalDate.of(2022, 10, 1));
            assertThat(headerDto1.getDateFromRef()).isEqualTo(LocalDate.of(2022, 9, 1));
            assertThat(headerDto1.getDateToRef()).isEqualTo(LocalDate.of(2023, 1, 31));
            assertThat(headerDto1.getBankNo()).isEqualTo("0123");
            assertThat(headerDto1.getBankName()).isEqualTo("ｷﾞﾝｺｳﾒｲ");
            assertThat(headerDto1.getBranchNo()).isEqualTo("098");
            assertThat(headerDto1.getBranchName()).isEqualTo("ｼﾃﾝﾒｲ");
            assertThat(headerDto1.getDummy()).isEqualTo("ﾀﾞﾐｰ");
            assertThat(headerDto1.getDepositType()).isEqualTo(1);
            assertThat(headerDto1.getAccountNo()).isEqualTo("00002345");
            assertThat(headerDto1.getAccountName()).isEqualTo("ｺｳｻﾞﾒｲｼｮｳ");
            assertThat(headerDto1.getOverdraftKbn()).isEqualTo(1);
            assertThat(headerDto1.getPassbookKbn()).isEqualTo(1);
            assertThat(headerDto1.getPreTransactionBalance()).isEqualTo(24680L);
            assertThat(headerDto1.getDummyEnd()).isEqualTo("ｻｲｼｭｳ");

            /* トレーラレコード */
            TradingZenginFormatTransactionDetailTrailerRecordDto trailerDto1 = listGroup1.get(0) // NOPMD
                    .getTradingZenginFormatTransactionDetailTrailerRecordDto();
            assertThat(trailerDto1.getDataKbn()).isEqualTo(8);
            assertThat(trailerDto1.getCountIncome()).isEqualTo(1);
            assertThat(trailerDto1.getSumIncome()).isEqualTo(35791L);
            assertThat(trailerDto1.getCountOutcome()).isEqualTo(1);
            assertThat(trailerDto1.getSumOutcome()).isEqualTo(123);
            assertThat(trailerDto1.getOverdraftKbn()).isEqualTo(1);
            assertThat(trailerDto1.getBalanceAfterTransaction()).isEqualTo(97531L);
            assertThat(trailerDto1.getCountData()).isEqualTo(2);
            assertThat(trailerDto1.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ"); // NOPMD

            List<TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto> listData1 = listGroup1.get(0) // NOPMD
                    .getListData();

            // データレコードは2件
            assertThat(listData1.size()).isEqualTo(2);

            TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto dto11 = listData1.get(0);
            assertThat(dto11.getDataKbn()).isEqualTo(2);
            assertThat(dto11.getReferNo()).isEqualTo("12345");
            assertThat(dto11.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));
            assertThat(dto11.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 1));
            assertThat(dto11.getDeWdKbn()).isEqualTo(1);
            assertThat(dto11.getTradingKbn()).isEqualTo(11);
            assertThat(dto11.getTransactionAmount()).isEqualTo(98765L);
            assertThat(dto11.getOtherStoreTicketAmount()).isEqualTo(3333L);
            assertThat(dto11.getExchangePresentationDate()).isEqualTo(LocalDate.of(2021, 9, 13));
            assertThat(dto11.getDishonoredReturnDate()).isEqualTo(LocalDate.of(2021, 10, 24));
            assertThat(dto11.getBillCheckKbn()).isEqualTo(2);
            assertThat(dto11.getBillCheckNo()).isEqualTo("00468");
            assertThat(dto11.getBranchNo()).isEqualTo("456");
            assertThat(dto11.getTransferRequesterCode()).isEqualTo("2468013579");
            assertThat(dto11.getTradingDetail()).isEqualTo("振込信金ユーザ太郎");
            assertThat(dto11.getSendingBankName()).isEqualTo("××銀行");
            assertThat(dto11.getSendingBankBranchName()).isEqualTo("○○支店");
            assertThat(dto11.getAbstractContent()).isEqualTo("取引詳細");
            assertThat(dto11.getEdiInfo()).isEqualTo("edi");
            assertThat(dto11.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

            TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto dto12 = listData1.get(1);
            assertThat(dto12.getDataKbn()).isEqualTo(2);
            assertThat(dto12.getReferNo()).isEqualTo("12345");
            assertThat(dto12.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));
            assertThat(dto12.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 1));
            assertThat(dto12.getDeWdKbn()).isEqualTo(2);
            assertThat(dto12.getTradingKbn()).isEqualTo(14);
            assertThat(dto12.getTransactionAmount()).isEqualTo(87654L);
            assertThat(dto12.getOtherStoreTicketAmount()).isEqualTo(3333L);
            assertThat(dto12.getExchangePresentationDate()).isEqualTo(LocalDate.of(2021, 9, 13));
            assertThat(dto12.getDishonoredReturnDate()).isEqualTo(LocalDate.of(2021, 9, 13));
            assertThat(dto12.getBillCheckKbn()).isEqualTo(1);
            assertThat(dto12.getBillCheckNo()).isEqualTo("00468");
            assertThat(dto12.getBranchNo()).isEqualTo("654");
            assertThat(dto12.getTransferRequesterCode()).isEqualTo("1357924680");
            assertThat(dto12.getTradingDetail()).isEqualTo("振替水道料金");
            assertThat(dto12.getSendingBankName()).isEqualTo("××銀行");
            assertThat(dto12.getSendingBankBranchName()).isEqualTo("○○支店");
            assertThat(dto12.getAbstractContent()).isEqualTo("取引詳細");
            assertThat(dto12.getEdiInfo()).isEqualTo("edi");
            assertThat(dto12.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

            List<TradingZenginFormatTransactionDetailGroup2NoticeDto> listGroup2 = detailDto.getListGroup2();

            // 1組データが入っている
            assertThat(listGroup2.size()).isEqualTo(1);

            /* ヘッダレコード */
            TradingZenginFormatTransactionDetailHeaderRecordDto headerDto2 = listGroup2.get(0) // NOPMD
                    .getTradingZenginFormatTransactionDetailHeaderRecordDto();
            assertThat(headerDto2.getDataKbn()).isEqualTo(1);
            assertThat(headerDto2.getBusinessType()).isEqualTo("03");
            assertThat(headerDto2.getCodeKbn()).isEqualTo(0);
            assertThat(headerDto2.getDateMaking()).isEqualTo(LocalDate.of(2022, 10, 1));
            assertThat(headerDto2.getDateFromRef()).isEqualTo(LocalDate.of(2022, 9, 1));
            assertThat(headerDto2.getDateToRef()).isEqualTo(LocalDate.of(2023, 1, 31));
            assertThat(headerDto2.getBankNo()).isEqualTo("0123");
            assertThat(headerDto2.getBankName()).isEqualTo("ｷﾞﾝｺｳﾒｲ");
            assertThat(headerDto2.getBranchNo()).isEqualTo("098");
            assertThat(headerDto2.getBranchName()).isEqualTo("ｼﾃﾝﾒｲ");
            assertThat(headerDto2.getDummy()).isEqualTo("ﾀﾞﾐｰ");
            assertThat(headerDto2.getDepositType()).isEqualTo(5);
            assertThat(headerDto2.getAccountNo()).isEqualTo("00002345");
            assertThat(headerDto2.getAccountName()).isEqualTo("ｺｳｻﾞﾒｲｼｮｳ");
            assertThat(headerDto2.getOverdraftKbn()).isEqualTo(1);
            assertThat(headerDto2.getPassbookKbn()).isEqualTo(1);
            assertThat(headerDto2.getPreTransactionBalance()).isEqualTo(24680L);
            assertThat(headerDto2.getDummyEnd()).isEqualTo("ｻｲｼｭｳ");

            /* トレーラレコード */
            TradingZenginFormatTransactionDetailTrailerRecordDto trailerDto2 = listGroup2.get(0) // NOPMD
                    .getTradingZenginFormatTransactionDetailTrailerRecordDto();
            assertThat(trailerDto2.getDataKbn()).isEqualTo(8);
            assertThat(trailerDto2.getCountIncome()).isEqualTo(1);
            assertThat(trailerDto2.getSumIncome()).isEqualTo(35791L);
            assertThat(trailerDto2.getCountOutcome()).isEqualTo(1);
            assertThat(trailerDto2.getSumOutcome()).isEqualTo(123);
            assertThat(trailerDto2.getOverdraftKbn()).isEqualTo(1);
            assertThat(trailerDto2.getBalanceAfterTransaction()).isEqualTo(97531L);
            assertThat(trailerDto2.getCountData()).isEqualTo(2);
            assertThat(trailerDto2.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

            List<TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto> listData2 = listGroup2.get(0)
                    .getListData();

            // データレコードは2件
            assertThat(listData2.size()).isEqualTo(2);

            TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto dto21 = listData2.get(0);
            assertThat(dto21.getDataKbn()).isEqualTo(2);
            assertThat(dto21.getIdentificationNo()).isEqualTo("00123");
            assertThat(dto21.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));
            assertThat(dto21.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 10));
            assertThat(dto21.getDeWdKbn()).isEqualTo(1);
            assertThat(dto21.getTradingKbn()).isEqualTo(10);
            assertThat(dto21.getTransactionAmount()).isEqualTo(98765L);
            assertThat(dto21.getOtherStoreTicketAmount()).isEqualTo(333);
            assertThat(dto21.getExchangePresentationDate()).isEqualTo(LocalDate.of(2022, 2, 5));
            assertThat(dto21.getDishonoredReturnDate()).isEqualTo(LocalDate.of(2022, 2, 9));
            assertThat(dto21.getBillCheckKbn()).isEqualTo(1);
            assertThat(dto21.getBillCheckNo()).isEqualTo("000246");
            assertThat(dto21.getBranchNo()).isEqualTo("456");
            assertThat(dto21.getOrginalDate()).isEqualTo(LocalDate.of(2022, 3, 1));
            assertThat(dto21.getInterestRate()).isEqualTo(0.22F);
            assertThat(dto21.getMaturityDate()).isEqualTo(LocalDate.of(2028, 1, 1));
            assertThat(dto21.getPeriod1()).isEqualTo("0110022");
            assertThat(dto21.getPeriodInterest()).isEqualTo(135L);
            assertThat(dto21.getIntermediateInterestRate()).isEqualTo(1.12F);
            assertThat(dto21.getInterimPaymentKbn()).isEqualTo(2);
            assertThat(dto21.getPostPeriod()).isEqualTo(12);
            assertThat(dto21.getPostPeriodInterestRate()).isEqualTo(0.33F);
            assertThat(dto21.getPostPeriodInterest()).isEqualTo(129L);
            assertThat(dto21.getTotalInterest()).isEqualTo(35798L);
            assertThat(dto21.getTaxKbn()).isEqualTo(2);
            assertThat(dto21.getTaxRate()).isEqualTo(0.23F);
            assertThat(dto21.getTaxAmount()).isEqualTo(9753L);
            assertThat(dto21.getAfterTaxInterest()).isEqualTo(6654L);
            assertThat(dto21.getAbstractContent()).isEqualTo("ﾃｷﾖｳ");
            assertThat(dto21.getPeriod2()).isEqualTo("1212");
            assertThat(dto21.getPeriodicInterestKbn()).isEqualTo(1);
            assertThat(dto21.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

            TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto dto22 = listData2.get(1);
            assertThat(dto22.getDataKbn()).isEqualTo(2);
            assertThat(dto22.getIdentificationNo()).isEqualTo("00123");
            assertThat(dto22.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));
            assertThat(dto22.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 10));
            assertThat(dto22.getDeWdKbn()).isEqualTo(2);
            assertThat(dto22.getTradingKbn()).isEqualTo(10);
            assertThat(dto22.getTransactionAmount()).isEqualTo(98765L);
            assertThat(dto22.getOtherStoreTicketAmount()).isEqualTo(333);
            assertThat(dto22.getExchangePresentationDate()).isEqualTo(LocalDate.of(2022, 2, 5));
            assertThat(dto22.getDishonoredReturnDate()).isEqualTo(LocalDate.of(2022, 2, 9));
            assertThat(dto22.getBillCheckKbn()).isEqualTo(1);
            assertThat(dto22.getBillCheckNo()).isEqualTo("000246");
            assertThat(dto22.getBranchNo()).isEqualTo("456");
            assertThat(dto22.getOrginalDate()).isEqualTo(LocalDate.of(2022, 3, 1));
            assertThat(dto22.getInterestRate()).isEqualTo(0.22F);
            assertThat(dto22.getMaturityDate()).isEqualTo(LocalDate.of(2028, 1, 1));
            assertThat(dto22.getPeriod1()).isEqualTo("0110022");
            assertThat(dto22.getPeriodInterest()).isEqualTo(135L);
            assertThat(dto22.getIntermediateInterestRate()).isEqualTo(1.12F);
            assertThat(dto22.getInterimPaymentKbn()).isEqualTo(2);
            assertThat(dto22.getPostPeriod()).isEqualTo(12);
            assertThat(dto22.getPostPeriodInterestRate()).isEqualTo(0.33F);
            assertThat(dto22.getPostPeriodInterest()).isEqualTo(129L);
            assertThat(dto21.getTotalInterest()).isEqualTo(35798L);
            assertThat(dto22.getTaxKbn()).isEqualTo(2);
            assertThat(dto22.getTaxRate()).isEqualTo(0.23F);
            assertThat(dto22.getTaxAmount()).isEqualTo(9753L);
            assertThat(dto22.getAfterTaxInterest()).isEqualTo(6654L);
            assertThat(dto22.getAbstractContent()).isEqualTo("ﾃｷﾖｳ");
            assertThat(dto22.getPeriod2()).isEqualTo("1212");
            assertThat(dto22.getPeriodicInterestKbn()).isEqualTo(1);
            assertThat(dto22.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

            // エンドレコード
            TradingZenginFormatTransactionDetailEndRecordDto endDto = detailDto // NOPMD
                    .getTradingZenginFormatTransactionDetailEndRecordDto();
            assertThat(endDto.getDataKbn()).isEqualTo(9);
            assertThat(endDto.getCountRecord()).isEqualTo(11);
            assertThat(endDto.getCountAccount()).isEqualTo(2);
            assertThat(endDto.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

        }

        Path pathNot = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "report_item/zegin_csv_format_not_detail.csv");

        MultipartFile fileNot = new MockMultipartFile("zegin_csv_format_not_detail",
                new FileInputStream(pathNot.toFile())); // NOPMD

        try (Reader readerNot = new InputStreamReader(fileNot.getInputStream());) {
            assertThrows(IllegalArgumentException.class, () -> convertTradingDetailAllFromCsvLogic.practice(readerNot));
        }

        Path pathAllDeposit = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "report_item/zegin_csv_format_deposit.csv");

        MultipartFile fileAllDeposit = new MockMultipartFile("zegin_csv_format_not_detail",
                new FileInputStream(pathAllDeposit.toFile())); // NOPMD

        try (Reader readerAllDeposit = new InputStreamReader(fileAllDeposit.getInputStream());) {
            // 分岐すべてをテストで流す
            TradingZenginFormatTransactionDetailDto allDepositDto = convertTradingDetailAllFromCsvLogic
                    .practice(readerAllDeposit);
            assertThat(allDepositDto.getListGroup1().size()).isEqualTo(3);
            assertThat(allDepositDto.getListGroup2().size()).isEqualTo(1);

        }

    }

}
