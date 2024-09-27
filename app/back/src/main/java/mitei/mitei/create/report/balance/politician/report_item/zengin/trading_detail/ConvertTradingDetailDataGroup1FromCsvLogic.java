package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailGroup1Ordinaly;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto;
import mitei.mitei.create.report.balance.politician.util.ConvertWarekiToSeirekiUtil;

/**
 * 全銀フォーマット入出金明細のデータレコードgourp1= 普通預金などに変換する
 */
@Component
public class ConvertTradingDetailDataGroup1FromCsvLogic {

    /** 半角スペース */
    private static final String HALF_SPACE = " ";

    /**
     * データレコードに変換する
     *
     * @param cell csvの各セル
     * @return データレコード
     */
    public TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto practice(final String[] cell) { // NOPMD

        TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto dto = new TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto();

        // データ区分の格納位置
        dto.setDataKbn(Integer.parseInt(cell[PosTransactionDetailGroup1Ordinaly.DATA_KBN]));

        // 照会番号の格納位置
        dto.setReferNo(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.REFER_NO]));

        // 勘定日の格納位置
        dto.setAccountingDate(
                ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailGroup1Ordinaly.ACCOUNTING_DATE]));

        // 預入・払出日の格納位置
        dto.setDepositWithdrawalDate(
                ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailGroup1Ordinaly.DEPOSIT_WITH_DRAWAL_DATE]));

        // 入払区分の格納位置
        dto.setDeWdKbn(Integer.parseInt(cell[PosTransactionDetailGroup1Ordinaly.DE_WD_KBN]));

        // 取引区分の格納位置
        dto.setTradingKbn(this.parseInt(cell[PosTransactionDetailGroup1Ordinaly.TRADING_KBN]));

        // 取引金額の格納位置
        dto.setTransactionAmount(Long.parseLong(cell[PosTransactionDetailGroup1Ordinaly.TRANSACTION_AMOUNT]));

        // うち他店券金額の格納位置
        dto.setOtherStoreTicketAmount(
                Long.parseLong(cell[PosTransactionDetailGroup1Ordinaly.OTHER_STORE_TICKET_AMOUNT]));

        // 交換呈示日の格納位置
        dto.setExchangePresentationDate(
                this.parseDate(cell[PosTransactionDetailGroup1Ordinaly.EXCHANGE_PRESENTATION_DATE]));

        // 不渡返還日の格納位置
        dto.setDishonoredReturnDate(this.parseDate(cell[PosTransactionDetailGroup1Ordinaly.DISHORNORED_RETURN_DATE]));

        // 手形・小切手区分の格納位置
        dto.setBillCheckKbn(this.parseInt(cell[PosTransactionDetailGroup1Ordinaly.BILL_CHEK_KBN]));

        // 手形・小切手番号の格納位置
        dto.setBillCheckNo(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.BILL_CHECK_NO]));

        // 僚店番号の格納位置
        dto.setBranchNo(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.BRANCH_NO]));

        // 振込依頼人コードの格納位置
        dto.setTransferRequesterCode(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.TRANSFER_REQUESTER_CODE]));

        // 依頼人名または契約者番号の格納位置
        dto.setTradingDetail(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.TRADING_DETAIL]));

        // 仕向銀行名の格納位置
        dto.setSendingBankName(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.SENDING_BANK_NAME]));

        // 仕向店名の格納位置
        dto.setSendingBankBranchName(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.SENDING_BANK_BRANCH_NAME]));

        // 摘要内容の格納位置
        dto.setAbstractContent(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.ABSTRACT_CONTET]));

        // EDI情報の格納位置
        dto.setEdiInfo(this.parseText(cell[PosTransactionDetailGroup1Ordinaly.EDI_INFO]));

        // ダミーの格納位置
        dto.setDummyEnd(cell[PosTransactionDetailGroup1Ordinaly.DUMMY_END].trim());

        return dto;
    }

    private Integer parseInt(final String data) {
        // 半角スペースは入力省略
        if (HALF_SPACE.equals(data)) {
            return null;
        }

        return Integer.parseInt(data);
    }

    private String parseText(final String data) {
        // 半角スペースは入力省略
        if (HALF_SPACE.equals(data)) {
            return null;
        }

        return data.trim();
    }

    private LocalDate parseDate(final String data) {
        // 半角スペースは入力省略
        if (HALF_SPACE.equals(data)) {
            return null;
        }

        return ConvertWarekiToSeirekiUtil.practice(data);
    }

}
