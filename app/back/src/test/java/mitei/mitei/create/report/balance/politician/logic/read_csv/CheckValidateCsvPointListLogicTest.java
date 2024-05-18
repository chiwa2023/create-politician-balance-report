package mitei.mitei.create.report.balance.politician.logic.read_csv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * CheckValidateCsvPointListLogic単体テスト
 */
class CheckValidateCsvPointListLogicTest {

    @Test
    void testPractice() {
        
        CheckValidateCsvPointListLogic checkValidateCsvPointListLogic = new CheckValidateCsvPointListLogic();
        
        //NOTE:下記のようなまともに分割できなかった場合・・・とかテストしたくなるが、データ連結部分はfront側で起きないように制御されているので、
        //データベース経由で直接登録して失敗するケースは想定しない 
        //String data = "1-3-5-7-9";
        //checkValidateCsvPointListLogic.practice(data.split(","));←splitできない,意図と異なる

        //TODO 時間があったら検証条件をbooleanでなくメッセージにする
        
        //意図しない定数が入り込み1(実装ミス?)
        String dirty1 = "0,1,2,1234567,15";
        assertThrows(IllegalArgumentException.class, () -> checkValidateCsvPointListLogic.practice(dirty1.split(",")));

        //意図しない定数が入り込み2(実装ミス?)
        String dirty2 = "0,1,2,abcdef,15";
        assertThrows(NumberFormatException.class, () -> checkValidateCsvPointListLogic.practice(dirty2.split(",")));

        //日付、取引金額(収支、支出)、1回ずつで摘要が揃っているので正常
        String data1 = "0,1,2,15,16";
        assertThat(checkValidateCsvPointListLogic.practice(data1.split(",")).getIsOk()).isTrue();
        
        //日付、取引金額(増減)、摘要が1回ずつで揃っているので正常
        String data2 = "0,3,15,16";
        assertThat(checkValidateCsvPointListLogic.practice(data2.split(",")).getIsOk()).isTrue();

        //日付が存在しないので不正
        String data3 = "0,3,16";
        assertThat(checkValidateCsvPointListLogic.practice(data3.split(",")).getIsOk()).isFalse();

        //日付が多すぎるので不正
        String data4 = "0,15,15,1,2,16";
        assertThat(checkValidateCsvPointListLogic.practice(data4.split(",")).getIsOk()).isFalse();

        //摘要はなくても問題ありません
        String data5 = "0,15,1,2";
        assertThat(checkValidateCsvPointListLogic.practice(data5.split(",")).getIsOk()).isTrue();

        //摘要は2回以上を許容しません
        String data6 = "0,15,1,2,16,16,16";
        assertThat(checkValidateCsvPointListLogic.practice(data6.split(",")).getIsOk()).isFalse();

        //増減を指定したら収入を含んではいけません
        String data7 = "0,15,3,1";
        assertThat(checkValidateCsvPointListLogic.practice(data7.split(",")).getIsOk()).isFalse();

        //増減を指定したら支出を含んではいけません
        String data8 = "0,15,3,2";
        assertThat(checkValidateCsvPointListLogic.practice(data8.split(",")).getIsOk()).isFalse();

        //増減を複数指定できません
        String data9 = "0,3,15,3,16";
        assertThat(checkValidateCsvPointListLogic.practice(data9.split(",")).getIsOk()).isFalse();

        //収入を複数指定できません
        String data10 = "0,2,15,2,16";
        assertThat(checkValidateCsvPointListLogic.practice(data10.split(",")).getIsOk()).isFalse();

        //支出を複数指定できません
        String data11 = "0,1,15,1,16";
        assertThat(checkValidateCsvPointListLogic.practice(data11.split(",")).getIsOk()).isFalse();

        //支出を指定したら収入が1回指定されていることが必要です
        String data12 = "0,1,15,16";
        assertThat(checkValidateCsvPointListLogic.practice(data12.split(",")).getIsOk()).isFalse();

        //収入を指定したら支出が1回指定されていることが必要です
        String data13 = "0,2,15,16";
        assertThat(checkValidateCsvPointListLogic.practice(data13.split(",")).getIsOk()).isFalse();
    }

}
