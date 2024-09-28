package mitei.mitei.create.report.balance.politician.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * ストレージ保存する1回限りのパスを生成する
 */
public final class MakeStorageOncePathUtil {

    /** URLを推測されにくくするためのランダム文字の桁数 */
    private static final int RANDOMM_CHAR_COUNT = 16; // CHECKSTYLE:OFF MagicNumber

    /* インスタンス生成よけ */
    private MakeStorageOncePathUtil() {

    }

    /**
     * ユーザ情報と生成時間を組み合わせて保存ディレクトリのパスを生成する
     *
     * @param loginUserid ログインユーザId
     * @param nowDatetime 保存しようとする時間
     * @return 必要事項を連結したPath
     */
    public static Path practice(final Long loginUserid, final LocalDateTime nowDatetime) {

        // フォーマット変換する都合で時刻はnullを許容しません
        if (Objects.isNull(nowDatetime)) {
            throw new IllegalArgumentException("時刻指定がnullです");
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String datetimeText = nowDatetime.format(dateTimeFormatter);
        // パスを推測されにくくするランダム文字
        String randomText = RandomStringUtils.randomAlphanumeric(RANDOMM_CHAR_COUNT);

        return joint(String.valueOf(loginUserid == null ? "" : loginUserid), datetimeText, randomText);
    }

    /**
     * 必要な情報を連結してPathに変換する(テストを確実に行うためでこのメソッドを使うことはほぼない)
     *
     * @param loginUserIdText ログインユーザの文字列変換
     * @param nowText         現在時間の文字列変換
     * @param randomText      ランダム文字列
     * @return 必要事項を連結したPath
     */
    public static Path joint(final String loginUserIdText, final String nowText, final String randomText) {

        String loginText = loginUserIdText;
        String timeText = nowText;
        String rText = randomText;

        // 空文字
        final String blank = "";

        // nullは空文字対応
        if (Objects.isNull(loginUserIdText)) {
            loginText = blank;
        }
        if (Objects.isNull(nowText)) {
            timeText = blank;
        }
        if (Objects.isNull(randomText)) {
            rText = blank;
        }

        // ランダム文字列と一時文字列の両方空は許容しません(ユーザIdだけ重複する)
        if (blank.equals(timeText) && blank.equals(rText)) {
            throw new IllegalArgumentException("ストレージパスを構成する時刻文字列,ランダム文字列が空文字です(実装ミス？)");
        }

        return Paths.get(loginText, rText, timeText);
    }

}
