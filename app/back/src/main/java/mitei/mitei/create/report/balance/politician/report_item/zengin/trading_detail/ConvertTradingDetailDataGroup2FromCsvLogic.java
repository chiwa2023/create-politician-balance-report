package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailGroup2Notice;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto;
import mitei.mitei.create.report.balance.politician.util.ConvertWarekiToSeirekiUtil;

/**
 * 全銀フォーマット入出金明細のデータレコードgourp2=積立貯金など)に変換する
 */
@Component
public class ConvertTradingDetailDataGroup2FromCsvLogic {

    /** 半角スペース */
    private static final String BLANK=" ";
    
    /**
     * データレコードに変換する
     *
     * @param cell csvの各セル
     * @return データレコード
     */
    public TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto practice(final String[] cell) { // NOPMD

        TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto dto = new TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto();

        // データ区分の格納位置
        dto.setDataKbn(Integer.parseInt(cell[PosTransactionDetailGroup2Notice.DATA_KBN]));

        // 識別番号の格納位置
        dto.setIdentificationNo(this.parseText(cell[PosTransactionDetailGroup2Notice.IDENTIFICATION_NO]));

        // 勘定日の格納位置
        dto.setAccountingDate(
                ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailGroup2Notice.ACCOUNTING_DATE]));

        // 預入・払出日の格納位置
        dto.setDepositWithdrawalDate(
                ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailGroup2Notice.DEPOSIT_WITHDRAWAL_DATE]));

        // 入払区分の格納位置
        dto.setDeWdKbn(Integer.parseInt(cell[PosTransactionDetailGroup2Notice.DE_WD_KBNn]));

        // 取引区分の格納位置
        dto.setTradingKbn(this.parseInt(cell[PosTransactionDetailGroup2Notice.TRADING_KBN]));

        // 取引金額の格納位置
        dto.setTransactionAmount(Long.parseLong(cell[PosTransactionDetailGroup2Notice.TRANSACTION_AMOUNT]));

        // うち他店券金額の格納位置
        dto.setOtherStoreTicketAmount(this.parseLong(cell[PosTransactionDetailGroup2Notice.OTHER_STORE_TICKET_AMOUNT]));

        // 交換呈示日の格納位置
        dto.setExchangePresentationDate(this.parseDate(cell[PosTransactionDetailGroup2Notice.EXCHANGE_PRESENTATION_DATE]));

        // 不渡返還日の格納位置
        dto.setDishonoredReturnDate(this.parseDate(cell[PosTransactionDetailGroup2Notice.DISHONORED_RETURN_DATE]));

        // 手形・小切手区分の格納位置
        dto.setBillCheckKbn(this.parseInt(cell[PosTransactionDetailGroup2Notice.BILL_CHECK_KBN]));

        // 手形・小切手番号の格納位置
        dto.setBillCheckNo(this.parseText(cell[PosTransactionDetailGroup2Notice.BILL_CHECK_NO]));

        // 僚店番号の格納位置
        dto.setBranchNo(this.parseText(cell[PosTransactionDetailGroup2Notice.BRANCH_NO]));

        // 当初預入日の格納位置
        dto.setOrginalDate(this.parseDate(cell[PosTransactionDetailGroup2Notice.ORGINAL_DATE]));

        // 利率の格納位置
        dto.setInterestRate(Float.parseFloat(cell[PosTransactionDetailGroup2Notice.INTEREST_RATE]));

        // 満期日の格納位置
        dto.setMaturityDate(this.parseDate(cell[PosTransactionDetailGroup2Notice.MATURITY_DATE]));

        // 期間(1)の格納位置
        dto.setPeriod1(this.parseText(cell[PosTransactionDetailGroup2Notice.PERIOD1]));

        // 期間利息の格納位置
        dto.setPeriodInterest(this.parseLong(cell[PosTransactionDetailGroup2Notice.PERIOD_INTEREST]));

        // 中間払利率の格納位置
        dto.setIntermediateInterestRate(
                this.parseFloat(cell[PosTransactionDetailGroup2Notice.INTERMEDIATE_INTEREST_RATE]));

        // 中間払区分の格納位置
        dto.setInterimPaymentKbn(this.parseInt(cell[PosTransactionDetailGroup2Notice.INTERIM_PAYMENT_KBN]));

        // 期後期間の格納位置
        dto.setPostPeriod(this.parseInt(cell[PosTransactionDetailGroup2Notice.POST_PERIOD]));

        // 期後利率の格納位置
        dto.setPostPeriodInterestRate(
                this.parseFloat(cell[PosTransactionDetailGroup2Notice.POST_PERIOD_INTEREST_RATE]));

        // 期後利息の格納位置
        dto.setPostPeriodInterest(this.parseLong(cell[PosTransactionDetailGroup2Notice.POST_PERIOD_INTEREST]));

        // 合計利息の格納位置
        dto.setTotalInterest(this.parseLong(cell[PosTransactionDetailGroup2Notice.TOTAL_INTEREST]));

        // 税区分の格納位置
        dto.setTaxKbn(this.parseInt(cell[PosTransactionDetailGroup2Notice.TAX_KBN]));

        // 税率の格納位置
        dto.setTaxRate(this.parseFloat(cell[PosTransactionDetailGroup2Notice.TAX_RATE]));

        // 税額の格納位置
        dto.setTaxAmount(this.parseLong(cell[PosTransactionDetailGroup2Notice.TAX_AMOUNT]));

        // 税引後利息の格納位置
        dto.setAfterTaxInterest(this.parseLong(cell[PosTransactionDetailGroup2Notice.AFTER_TAX_INTEREST]));

        // 摘要内容の格納位置
        dto.setAbstractContent(this.parseText(cell[PosTransactionDetailGroup2Notice.ABSTRACT_CONTENT]));

        // 期間（2）の格納位置
        dto.setPeriod2(this.parseText(cell[PosTransactionDetailGroup2Notice.PERIOD2]));

        // 期間利息正負表示の格納位置
        dto.setPeriodicInterestKbn(this.parseInt(cell[PosTransactionDetailGroup2Notice.PERIODIC_INTEREST_KBN]));

        // ダミーの格納位置
        dto.setDummyEnd(cell[PosTransactionDetailGroup2Notice.DUMMY_END].trim());

        return dto;
    }


    private Integer parseInt(final String data) {
        // 半角スペースは入力省略
        if(BLANK.equals(data)) {
            return null;
        }
        
        return Integer.parseInt(data);
    }

    private Long parseLong(final String data) {
        // 半角スペースは入力省略
        if(BLANK.equals(data)) {
            return null;
        }
        
        return Long.parseLong(data);
    }

    private String parseText(final String data) {
        // 半角スペースは入力省略
        if(BLANK.equals(data)) {
            return null;
        }
        
        return data.trim();
    }


    private Float parseFloat(final String data) {
        // 半角スペースは入力省略
        if(BLANK.equals(data)) {
            return null;
        }
        
        return Float.parseFloat(data);
    }

    private LocalDate parseDate(final String data) {
        // 半角スペースは入力省略
        if(BLANK.equals(data)) {
            return null;
        }
        
        return ConvertWarekiToSeirekiUtil.practice(data);
    }

}
