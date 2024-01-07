package mitei.mitei.create.report.balance.politician.publish.validate;

import org.springframework.stereotype.Component;

/**
 * XMLにどのシートにデータが入っているかいないかを表すテキスト。
 * 最低限の入力が行われた場合は「110000000000000000001000000000000010000000000000100」
 * ここから設計書がないので適当に逆リバース(苦笑、と言っても数はあっていると思う)
 * 1：sheet1==表紙
 * 1：sheet2==収入集計
 * 0：sheet3
 * 0：sheet4
 * 0：sheet5
 * 0：sheet6
 * 0：sheet7-1
 * 0：sheet7-2
 * 0：sheet7-3
 * 0：sheet8-1
 * 0：sheet8-2
 * 0：sheet8-3
 * 0：sheet9
 * 0：sheet10
 * 0：sheet11-1
 * 0：sheet11-2
 * 0：sheet11-3
 * 0：sheet12-1
 * 0：sheet12-2
 * 0：sheet12-3
 * 1:sheet13==支出表紙
 * 0：sheet14-1
 * 0：sheet14-2
 * 0：sheet14-3
 * 0：sheet15-1
 * 0：sheet15-2
 * 0：sheet15-3
 * 0：sheet15-4
 * 0：sheet15-5
 * 0：sheet15-6
 * 0：sheet15-7
 * 0：sheet15-8
 * 0：sheet15-9
 * 0：sheet16
 * 1：sheet17==資産表紙
 * 0：sheet18-1
 * 0：sheet18-2
 * 0：sheet18-3
 * 0：sheet18-4
 * 0：sheet18-5
 * 0：sheet18-6
 * 0：sheet18-7
 * 0：sheet18-8
 * 0：sheet18-9
 * 0：sheet18-10
 * 0：sheet18-11
 * 0：sheet18-12
 * 0：sheet19
 * 1：sheet20==宣誓書
 * 0：sheetその08-1
 * 0：sheetその08-2
 */
@Component
public class MakeUmuInputTextLogic {

    /** データ入力なしを表すフラグ */
    public static final int NASHI_INPUT_DATA_FLUG = 0; 
    
    /** データ入力がされていることを表すフラグ */
    public static final int ARI_INPUT_DATA_FLUG = 1; 

    
    public String practice(
            final int flg0701
            ) throws IllegalArgumentException{
        
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(this.checkValue(flg0701));
        
        
        
        return stringBuilder.toString();
    }
    
    
    private int checkValue(final int value)throws IllegalArgumentException {
        
        if(NASHI_INPUT_DATA_FLUG != value && ARI_INPUT_DATA_FLUG != value) {
            throw new IllegalArgumentException("入力なし:0入力あり：1以外の値が入力されています");
        }
        
        return value;
    }
    
}
