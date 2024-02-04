package mitei.mitei.create.report.balance.politician.report_item.zengin;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.observation.WriteObservationTableUtil;
import mitei.mitei.create.report.balance.politician.observation.mock.MockWriteObservationTableUtil;

/**
 * 全銀フォーマットcsvが改変などを伴っていないかをチェックする
 */
@Component
public class ValidateFormatZenginLogic {

    /** 通知テーブルへの書き込みUtil */
    @Autowired
    private WriteObservationTableUtil writeObservationTableUtil;
    
    /**
     * csvが全銀フォーマットにノットているか、妥当性を検証する
     *
     * @param listCsv csvデータリスト
     * @return 改変がない場合はfalse
     * @throws NumberFormatException 数字であるべきテキストが数字にが変換できない場合
     */
    public boolean practice(final List<String[]> listCsv)throws NumberFormatException { // NOPMD AvoidUncheckedException
        
        if(Objects.isNull(writeObservationTableUtil)){
            writeObservationTableUtil = new MockWriteObservationTableUtil();
        }
        
        boolean hasTampering = false;

        /*
         * 数字が数字として読み取れない=ファイルとして壊れている可能性のほうが濃厚である、
         * 以外のチェック項目(合計金額が合わない、行数が足りない)は絶対に例外処理をして処理を止めないこと。
         * 後々(オンブズマンあるいはAIのようなシステムから)「csvがちょｔっと・・・と指摘してもらう」ので改変があったことを記録しておしまい(ここでは)。
         */
        
        //チェックサンプル例(行数改竄)
        //最終行の2セル目にこのcsv全体の行数の記載がある
        String[] lastLine = listCsv.get(listCsv.size()-1);
        final int allSizePos = 1;
        int allSize = Integer.parseInt(lastLine[allSizePos]);
        
        if(allSize != listCsv.size()) {
            //オンブズマン(調査側)の通知用テーブルに記録する
            writeObservationTableUtil.practice();
            
            //改竄があった
            hasTampering = true;
        }
        
        //TODO その他のチェック
        
        return hasTampering;
    }
    
}
