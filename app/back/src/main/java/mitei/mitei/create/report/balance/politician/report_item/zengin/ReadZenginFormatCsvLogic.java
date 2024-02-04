package mitei.mitei.create.report.balance.politician.report_item.zengin;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import mitei.mitei.create.report.balance.politician.dto.report_item.TradingCoreItemBankingDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatConstants;
import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatConstants.DataKbn;
import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatConstants.DepositType;
import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailGroup1Ordinaly;
import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailHeader;
import mitei.mitei.create.report.balance.politician.util.ConvertWarekiToSeirekiUtil;

/**
 * 全銀フォーマットcsvの読み込みをして、銀行口座入出金Dtoリストに変換する
 */
@Component
public class ReadZenginFormatCsvLogic {

    /** ファイル改竄などがないかチェックするLogic */
    @Autowired
    private ValidateFormatZenginLogic validateFormatZenginLogic;

    /**
     * 銀行口座入出金Dtoリストに変換する
     *
     * @param reader 全銀フォーマットcsvを読み取りしたreader
     * @return 銀行口座入出金Dtoリスト
     * @throws CsvException          csvに変換できない
     * @throws IOException           ファイルが読み込みできない
     * @throws NumberFormatException 数値に変換できない
     */
    public List<TradingCoreItemBankingDto> practice(final Reader reader)
            throws CsvException, IOException, NumberFormatException { // NOPMD AvoidUncheckedException

        if (Objects.isNull(validateFormatZenginLogic)) {
            validateFormatZenginLogic = new ValidateFormatZenginLogic();
        }

        CSVReader csvReader = new CSVReader(reader);

        List<String[]> listItem = csvReader.readAll();

        /*
         * 議員2期以上(あるいは当選時)である職業政治家であれば専用を銀行口座を持つのが望ましいと思われるが、
         * 1テーマ実現のため1回だけ立候補する(落選したので立候補はそれでおしまいの)場合も考慮しなくてはならない。
         * この条件下で最も必要なのは「すべての入出金データが分別の俎上に載っていること」 現在できるかどうかは不明だが、職業政治家には、厳しい企業会計検査のように、
         * サンプル調査として 「・・・と明細が記録されているけど間違いないか」と銀行に明細履歴改竄の有無(と政治家自身の隠し口座の有無)
         * を問い合わせをすることになる。そうしないと少なくとも振り込み間関係の調査の実効性は上がらない。
         * 生活資金と政治資金がうまく分別出来てないことをチェックするのはその次の段階。 その前段階として TODO
         * 全銀フォーマットファイルに改変がないか仮の確認を行う
         */
        validateFormatZenginLogic.practice(listItem);

        // データレコードを解析
        List<TradingCoreItemBankingDto> listBankingTrade = new ArrayList<>();

        int depositType = 0;
        for (String[] cell : listItem) {
            switch (Integer.parseInt(cell[0])) {
                case DataKbn.HEADER:
                    // ヘッダレコードでは口座種目(普通、積金など)が変わり、データパターンが2ケースあるので切り替え
                    depositType = Integer.parseInt(cell[PosTransactionDetailHeader.DEPOSIT_TYPE]);
                    break;
                case DataKbn.DATA:
                    //普通預金または当座預金または貯蓄預金
                    if(depositType == DepositType.ORDINALY | depositType == DepositType.CURRENT | depositType == DepositType.SAVING) {
                        // 解析してリストに追加
                        listBankingTrade.add(this.createBankingCoreItem(cell, depositType));
                    }
                    
                    break;
                // トレーラーレコードとエンドレコードはこの機能では使用しない
                default:
                    break;
            }

        }

        csvReader.close();

        return listBankingTrade;
    }

    private TradingCoreItemBankingDto createBankingCoreItem(final String[] cell, final int depositType)
            throws JsonMappingException, JsonProcessingException {

        TradingCoreItemBankingDto tradingCoreItemBankingDto = new TradingCoreItemBankingDto();

        // 金額
        tradingCoreItemBankingDto
                .setTransactionAmount(Long.parseLong(cell[PosTransactionDetailGroup1Ordinaly.TRANSACTION_AMOUNT]));
        // 日付
        tradingCoreItemBankingDto.setAccountingDate(ConvertWarekiToSeirekiUtil.practice(cell[PosTransactionDetailGroup1Ordinaly.ACCOUNTING_DATE]));
        // 口座名義人は摘要とコミコミ
        tradingCoreItemBankingDto.setAccountHolderName(cell[PosTransactionDetailGroup1Ordinaly.TRADING_DETAIL].trim());
        // 口座種別
        tradingCoreItemBankingDto.setAccountKbn(depositType);
        // 口座種別
        tradingCoreItemBankingDto.setAccountKbnName(ZenginFormatConstants.getDepositTypeLabel(depositType));
        // 口座番号
        tradingCoreItemBankingDto.setAccountNo(cell[PosTransactionDetailGroup1Ordinaly.TRANSFER_REQUESTER_CODE].trim());
        // 支店名
        tradingCoreItemBankingDto
                .setBranchName(cell[PosTransactionDetailGroup1Ordinaly.SENDING_BANK_BRANCH_NAME].trim());
        // 支店番号
        tradingCoreItemBankingDto.setBranchNo(cell[PosTransactionDetailGroup1Ordinaly.BRANCH_NO].trim());
        // 入出金区分
        tradingCoreItemBankingDto.setDeWdKbn(Integer.parseInt(cell[PosTransactionDetailGroup1Ordinaly.DE_WD_KBN]));
        // 金融機関名
        tradingCoreItemBankingDto
                .setFinancialInstitutionName(cell[PosTransactionDetailGroup1Ordinaly.SENDING_BANK_NAME].trim());
        // 入出金元金融機関番号は金融機関名から取得する必要がある・・・ってなにやってんすか(>_<)
        // tradingCoreItemBankingDto.setFinancialInstitutionNo(null);
        // 摘要
        tradingCoreItemBankingDto.setTradingDetail(cell[PosTransactionDetailGroup1Ordinaly.ABSTRACT_CONTET].trim());

        return tradingCoreItemBankingDto;
    }

}
