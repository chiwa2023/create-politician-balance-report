package mitei.mitei.create.report.balance.politician.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * MakeStorageOncePathUtil単体テスト
 */
class MakeStorageOncePathUtilTest {
    // CHECKSTYLE:OFF
    
    @Test
    @Tag("TableTruncate")
    void testPractice()throws Exception {

        //値を入れた場合予定した位置に値が入る
        LocalDateTime dateTimeNow1 = LocalDateTime.now(); 
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String timeText = dateTimeNow1.format(dateTimeFormatter);
        Long userId1 = 13579L;
        Path ans1 = MakeStorageOncePathUtil.practice(userId1,dateTimeNow1);
        assertThat(ans1.getParent().getParent().toString()).isEqualTo(String.valueOf(userId1));//生成Path内に指定したuserIdが含まれます
        assertThat(ans1.getName(ans1.getNameCount()-1).toString()).isEqualTo(timeText);//生成Path内に指定した時刻が含まれます

        //時刻のnullは許容しません
        assertThrows(IllegalArgumentException.class,() ->  MakeStorageOncePathUtil.practice(444L,null));

        //最悪userIdがnullでもOkとします
        assertDoesNotThrow(() -> MakeStorageOncePathUtil.practice(null,dateTimeNow1));
    }

    @Test
    void testJoint()throws Exception {

        // 一応ログインユーザId,ランダム文字列,日時を結合することになっているがぶっちゃけなんでもいい
        // テストを簡単にするためのメソッドで直接利用は想定していない

        // 文字列が入っていればきちんと連結される
        String loginText1 = "dsgf7gd9f";
        String randomText1 = "iy3ujujhk";
        String dateText1 = "iyferifdytdjhk";
        Path ans1 = MakeStorageOncePathUtil.joint(loginText1, dateText1, randomText1);
        assertThat(ans1.toString()).isEqualTo(loginText1 + File.separator + randomText1 + File.separator + dateText1);

        // これも本来想定しないが、ユーザIdのみが指定された場合重複するので拒否
        String loginText2 = "ewtores3it7";
        String  randomText2 = "";
        String dateText2 = "";
        assertThrows(IllegalArgumentException.class,
                () -> MakeStorageOncePathUtil.joint(loginText2, dateText2, randomText2));

        //ランダム文字列と時刻文字列のみはよほどの事がない限り重複なし(どっかの段階で発見できる・・・と思う)
        String loginText3 = "";
        String  randomText3 = "sertsrhxgh";
        String dateText3 = "";
        Path ans3 = MakeStorageOncePathUtil.joint(loginText3, dateText3, randomText3);
        assertThat(ans3.toString()).isEqualTo(randomText3);

        //空文字比較が入っているのでnullは落ちる→nullは空文字変換→ランダム文字列と時刻文字列が入力されていない→case2におなじ
        String loginText4 = null;
        String  randomText4 = null;
        String dateText4 = null;
        assertThrows(IllegalArgumentException.class,
                () -> MakeStorageOncePathUtil.joint(loginText4, dateText4, randomText4));
    }

}
