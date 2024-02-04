package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatConstants.DataKbn;
import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatConstants.DepositType;
import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailHeader;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.TradingZenginFormatTransactionDetailDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailGroup1OrdinalyDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailGroup2NoticeDto;

/**
 * 全銀フォーマット入出金明細データをフルで読み込むロジック
 */
@Component
public class ConvertTradingDetailAllFromCsvLogic {

    /** グループ1読み取りロジック */
    @Autowired
    private ConvertTradingDetailDataGroup1FromCsvLogic convertTradingDetailDataGroup1FromCsvLogic;
    
    /** グループ2読み取りロジック */
    @Autowired
    private ConvertTradingDetailDataGroup2FromCsvLogic convertTradingDetailDataGroup2FromCsvLogic;
    
    /** エンド読み取りロジック */
    @Autowired
    private ConvertTradingDetailEndFromCsvLogic convertTradingDetailEndFromCsvLogic;
    
    /** ヘッダ読み取りロジック */
    @Autowired
    private ConvertTradingDetailHeaderFromCsvLogic convertTradingDetailHeaderFromCsvLogic;
    
    /** トレーラ読み取りロジック */
    @Autowired
    private ConvertTradingDetailTrailerFromCsvLogic convertTradingDetailTrailerFromCsvLogic;
    
    /**
     * 全銀フォーマット入出金明細データを全解析する
     *
     * @param reader csvデータのreader
     * @return 入出金明細データDto
     * @throws CsvException csvの例外
     * @throws IOException ファイル読み取り不可の例外
     */
    public TradingZenginFormatTransactionDetailDto practice(final Reader reader)throws CsvException, IOException {
        
        /* NOTE:このcsvでは列数が記載する口座によって変わる仕様となる 
         * XMLでいうところの名前空間の指定もなく、列数が違うだけで自動でバインドするDtoを選択する
         * 何かのツールによる自動バインディングができることは期待薄と判断して、
         * 1セルづつ割り当てる力技による実装を行った
         */

        if(Objects.isNull(convertTradingDetailEndFromCsvLogic)) {
            convertTradingDetailDataGroup1FromCsvLogic = new ConvertTradingDetailDataGroup1FromCsvLogic();
            convertTradingDetailDataGroup2FromCsvLogic = new ConvertTradingDetailDataGroup2FromCsvLogic();
            convertTradingDetailEndFromCsvLogic = new ConvertTradingDetailEndFromCsvLogic();
            convertTradingDetailHeaderFromCsvLogic = new ConvertTradingDetailHeaderFromCsvLogic();
            convertTradingDetailTrailerFromCsvLogic = new ConvertTradingDetailTrailerFromCsvLogic();
        }
        
        CSVReader csvReader = new CSVReader(reader);

        List<String[]> listItem = csvReader.readAll();

        TradingZenginFormatTransactionDetailDto allDto = new TradingZenginFormatTransactionDetailDto();
        
        int depositType = 0;
        for(String[] cell : listItem) {
            
            switch(Integer.parseInt(cell[0])) {
                case DataKbn.HEADER:
                    // ヘッダレコードでは口座種目(普通、積金など)が変わり、データパターンが2ケースあるので切り替え
                    depositType = Integer.parseInt(cell[PosTransactionDetailHeader.DEPOSIT_TYPE]);
                    
                    if(depositType == DepositType.ORDINALY | depositType == DepositType.CURRENT | depositType == DepositType.SAVING) {
                        allDto.getListGroup1().add(new TradingZenginFormatTransactionDetailGroup1OrdinalyDto());
                        //最終のデータにヘッダを追加
                        allDto.getListGroup1().get(allDto.getListGroup1().size()-1).setTradingZenginFormatTransactionDetailHeaderRecordDto(convertTradingDetailHeaderFromCsvLogic.practice(cell));
                    } else {
                        allDto.getListGroup2().add(new TradingZenginFormatTransactionDetailGroup2NoticeDto());
                        //最終のデータにヘッダを追加
                        allDto.getListGroup2().get(allDto.getListGroup2().size()-1).setTradingZenginFormatTransactionDetailHeaderRecordDto(convertTradingDetailHeaderFromCsvLogic.practice(cell));
                    }
                    break;
            
                case DataKbn.DATA:
                    if(depositType == DepositType.ORDINALY | depositType == DepositType.CURRENT | depositType == DepositType.SAVING) {
                        //最終のデータにデータレコードを追加
                        allDto.getListGroup1().get(allDto.getListGroup1().size()-1).getListData().add(convertTradingDetailDataGroup1FromCsvLogic.practice(cell));
                    } else {
                        //最終のデータにデータレコードを追加
                        allDto.getListGroup2().get(allDto.getListGroup2().size()-1).getListData().add(convertTradingDetailDataGroup2FromCsvLogic.practice(cell));
                    }
                    break;
            
                case DataKbn.TRAILER:
                    if(depositType == DepositType.ORDINALY | depositType == DepositType.CURRENT | depositType == DepositType.SAVING) {
                        //最終のデータにトレーラを追加
                        allDto.getListGroup1().get(allDto.getListGroup1().size()-1).setTradingZenginFormatTransactionDetailTrailerRecordDto(convertTradingDetailTrailerFromCsvLogic.practice(cell));
                    } else {
                        //最終のデータにトレーラを追加
                        allDto.getListGroup2().get(allDto.getListGroup2().size()-1).setTradingZenginFormatTransactionDetailTrailerRecordDto(convertTradingDetailTrailerFromCsvLogic.practice(cell));
                    }
                    break;

                case DataKbn.END:
                    //エンドレコードは明細全体で1件だけです
                    allDto.setTradingZenginFormatTransactionDetailEndRecordDto(convertTradingDetailEndFromCsvLogic.practice(cell));
                    break;

                default:
                    throw new IllegalArgumentException("データ区分が1,2,8,9以外です");
            }
            
        }
        
        csvReader.close();
        return allDto;
    }
}
