package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailHeader;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailHeaderRecordDto;
import mitei.mitei.create.report.balance.politician.util.ConvertWarekiToSeirekiUtil;

/**
 * 全銀フォーマット入出金明細のヘッダレコードに変換する
 */
@Component
public class ConvertTradingDetailHeaderFromCsvLogic {

    /**
     * ヘッダレコードに変換する
     *
     * @param cell csvの各セル
     * @return ヘッダレコード
     */
    public TradingZenginFormatTransactionDetailHeaderRecordDto practice(final String[] cell) {

        TradingZenginFormatTransactionDetailHeaderRecordDto dto = new TradingZenginFormatTransactionDetailHeaderRecordDto();

        // データ区分の格納位置 
        dto.setDataKbn(Integer.parseInt(cell[PosTransactionDetailHeader.DATA_KBN]));

        // 種別コードの格納位置 
        dto.setBusinessType(cell[PosTransactionDetailHeader.BUISSINESS_TYPE].trim());

        // コード区分の格納位置 
        dto.setCodeKbn(Integer.parseInt(cell[PosTransactionDetailHeader.CODE_KBN]));

        // 作成日の格納位置 
        dto.setDateMaking(ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailHeader.DATE_MAKING]));

        // 勘定日(自)の格納位置 
        dto.setDateFromRef(ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailHeader.DATE_FROM_REF]));

        // 勘定日(至)の格納位置 
        dto.setDateToRef(ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailHeader.DATE_TO_REF]));

        // 銀行コードの格納位置 
        dto.setBankNo(cell[PosTransactionDetailHeader.BANK_NO].trim());

        // 銀行名の格納位置 
        dto.setBankName(cell[PosTransactionDetailHeader.BANK_NAME].trim());

        // 支店コードの格納位置 
        dto.setBranchNo(cell[PosTransactionDetailHeader.BRANCH_NO].trim());

        // 支店名の格納位置 
        dto.setBranchName(cell[PosTransactionDetailHeader.BRANCH_NAME].trim());

        // ダミーの格納位置 
        dto.setDummy(cell[PosTransactionDetailHeader.DUMMY].trim());

        // 預金種目の格納位置 
        dto.setDepositType(Integer.parseInt(cell[PosTransactionDetailHeader.DEPOSIT_TYPE]));

        // 口座番号の格納位置 
        dto.setAccountNo(cell[PosTransactionDetailHeader.ACCOUNT_NO].trim());

        // 口座名の格納位置 
        dto.setAccountName(cell[PosTransactionDetailHeader.ACCOUNT_NAME].trim());

        // 貸越区分の格納位置 
        dto.setOverdraftKbn(Integer.parseInt(cell[PosTransactionDetailHeader.OVERDRAFT_KBN]));

        // 通帳・証書区分の格納位置 
        dto.setPassbookKbn(this.parseLong(cell[PosTransactionDetailHeader.PASSBOOK_KBN]));

        // 取引前残高の格納位置 
        dto.setPreTransactionBalance(this.parseLong(cell[PosTransactionDetailHeader.PRE_TRANSACTION_BALANCE]));

        // ダミーの格納位置 
        dto.setDummyEnd(cell[PosTransactionDetailHeader.DUMMY_END].trim());

        return dto;
    }

    private Long parseLong(final String data) {
        //半角スペースは入力省略
        if(" ".equals(data)) {
            return null; // データ未設定
        }
        return Long.parseLong(data);
    }

}
