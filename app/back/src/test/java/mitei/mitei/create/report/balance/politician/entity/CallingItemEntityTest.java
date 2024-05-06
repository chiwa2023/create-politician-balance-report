package mitei.mitei.create.report.balance.politician.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CallingItemEntity単体テスト
 * 
 */
public class CallingItemEntityTest {
    // CHECKSTYLE:OFF

    /** テスト対象Entity */
    private CallingItemEntity callingItemEntity;

    @BeforeEach
    void setUp() throws Exception {
        callingItemEntity = new CallingItemEntity();
    }

    /** ログインユーザ同一識別コード */
    @Test
    public void testSetLoginIuserCode() throws Exception {
        Integer dataOk = 46037343;
        assertDoesNotThrow(() -> callingItemEntity.setLoginUserCode(dataOk));
    }

    /** ログインユーザ同一識別コード */
    @Test
    public void testGetLoginIuserCode() throws Exception {
        Integer dataOk = 24217097;
        callingItemEntity.setLoginUserCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getLoginUserCode());
    }

    /** 項目呼び出し条件摘要 */
    @Test
    public void testSetCallingReferDigest() throws Exception {
        String dataOk = "Lpkvv4Z9MTbmX4YpfTkKNKAR8SIm9kTJVVyDXrz0xVdd8JDiMRzRLqFPBpeEnvrJu0mxe0LK24u3MEoRyHTcpXfTNJoI6R8oPohHrHZFq6FwOleZ9eWzwmznWjORo7mbaw8gIzP4MPeSRZwmPEPc9m";
        assertDoesNotThrow(() -> callingItemEntity.setCallingReferDigest(dataOk));
    }

    /** 項目呼び出し条件摘要 */
    @Test
    public void testGetCallingReferDigest() throws Exception {
        String dataOk = "JXvivxiqtNUwMOdsAsJWG9CscydFjfpuYi4CYhBECkllP3jkVhwyMo3MbuEyX0MapkhGpSZI0UTa5x5qI72TpklpzPYbL0HcFHSHusKWtsASpNd6QFhUnKGw3kKCopQQaipOqFUCzorb5RZzBqe8gQ";
        callingItemEntity.setCallingReferDigest(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingReferDigest());
    }

    /** 関連者法人同一識別コード */
    @Test
    public void testSetRelationCorporationCode() throws Exception {
        Integer dataOk = 71953155;
        assertDoesNotThrow(() -> callingItemEntity.setRelationCorporationCode(dataOk));
    }

    /** 関連者法人同一識別コード */
    @Test
    public void testGetRelationCorporationCode() throws Exception {
        Integer dataOk = 18860160;
        callingItemEntity.setRelationCorporationCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getRelationCorporationCode());
    }

    /** 項目呼び出し条件口座番号 */
    @Test
    public void testSetCallingItemAccountNo() throws Exception {
        String dataOk = "dgcZrxwFbNmKiTV";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemAccountNo(dataOk));
    }

    /** 項目呼び出し条件口座番号 */
    @Test
    public void testGetCallingItemAccountNo() throws Exception {
        String dataOk = "ng9FLd4oD7RKsnO";
        callingItemEntity.setCallingItemAccountNo(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemAccountNo());
    }

    /** 項目呼び出し条件住所建物 */
    @Test
    public void testSetCallingItemAddressBuiding() throws Exception {
        String dataOk = "qE2mE6ezAn9cFfkKGY1ivl2GAzHLgHJOMToR6n0FIIvpR6tJSro0f8FgSYLpJOg8K5d37WGbYYSLyBmvP6Ym7u8u2xfOr0oNVYek8D9pkBPYpx6FojRUw8CHQQAKLFNJ9tWw3KAfjqTYouz2ttHHs8";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemAddressBuiding(dataOk));
    }

    /** 項目呼び出し条件住所建物 */
    @Test
    public void testGetCallingItemAddressBuiding() throws Exception {
        String dataOk = "JQLqqrD8Uuro6FUKgl3dE6KFyzpUELkbXj9Am5ss5XyidqlLni6ZVkACIJUHwtgYKjjb4RJPUr4nT99KioDXVzibaqYEWNRj6M7p0xIf2h40fX9Zzrn1Occ7Wa69zlBBD9nZ5bTl0r0T7IsWj6ztYX";
        callingItemEntity.setCallingItemAddressBuiding(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemAddressBuiding());
    }

    /** 項目呼び出し条件住所 */
    @Test
    public void testSetCallingItemAddressPost() throws Exception {
        String dataOk = "SzKF1lctDinfucTFkEd9CVeBhH2KFsvUmPVaOpdzsBqI58bXE7ihc2jHuvhYWMf6oymh5FIPiMnsDCRhtL74i37MN4oj7VItPt4keNNYiEvqg1eumm9I1sHCNQtcCzL4p75M1tQFzqInI1mgqFxnlO";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemAddressPost(dataOk));
    }

    /** 項目呼び出し条件住所 */
    @Test
    public void testGetCallingItemAddressPost() throws Exception {
        String dataOk = "moySmupnCN3QrA29bOSHwzuEy64wSicYjWYUKfe9c4gGeLoz5uNdaBs23QiuFYmQ3PeoCBQKvUxfyw9jQRFgKV8IwAniBVNeqEtiydOFQh6NE3lBPv91vvXatPRhENuhA1kDURZW4WxX0JvV1IQmC3";
        callingItemEntity.setCallingItemAddressPost(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemAddressPost());
    }

    /** 関連者区分 */
    @Test
    public void testSetRelationkbn() throws Exception {
        Integer dataOk = 91944757;
        assertDoesNotThrow(() -> callingItemEntity.setRelationKbn(dataOk));
    }

    /** 関連者区分 */
    @Test
    public void testGetRelationkbn() throws Exception {
        Integer dataOk = 79866789;
        callingItemEntity.setRelationKbn(dataOk);
        assertEquals(dataOk, callingItemEntity.getRelationKbn());
    }

    /** 継続事業Id */
    @Test
    public void testSetContinueBuissinessId() throws Exception {
        Long dataOk = 32647214L;
        assertDoesNotThrow(() -> callingItemEntity.setContinueBuissinessId(dataOk));
    }

    /** 継続事業Id */
    @Test
    public void testGetContinueBuissinessId() throws Exception {
        Long dataOk = 12546244L;
        callingItemEntity.setContinueBuissinessId(dataOk);
        assertEquals(dataOk, callingItemEntity.getContinueBuissinessId());
    }

    /** 項目呼び出し条件全銀金融機関名称 */
    @Test
    public void testSetCallingItemZenginFinancialOrgName() throws Exception {
        String dataOk = "dd6Rb3ug1JjoEz90dzBnJ0V17ZDQKifPiyfAjlJ2fdpX2ScaQJ";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemZenginFinancialOrgName(dataOk));
    }

    /** 項目呼び出し条件全銀金融機関名称 */
    @Test
    public void testGetCallingItemZenginFinancialOrgName() throws Exception {
        String dataOk = "ZZHA076qn9oeua1IhOMV3Eltn6jlK6kYhSJi9vcD2n7irOSTN2";
        callingItemEntity.setCallingItemZenginFinancialOrgName(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemZenginFinancialOrgName());
    }

    /** 項目呼び出し条件各種Pay名称 */
    @Test
    public void testSetCallingItemVariousFinancialPayName() throws Exception {
        String dataOk = "4sFDYRgBnmjACsUH8Z8BXWdLGwTlFtkLrBjU21df2jiyZAPel78QrBphWnIN3VI9zMv6R7lsF6MsYvNhB7OKCdLYSTVi6gtp6pcWb3qBNuSLZrui8Tx8PW01zPeXYRcVUOzdWCt97sv1bQzq18VA9O";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemVariousFinancialPayName(dataOk));
    }

    /** 項目呼び出し条件各種Pay名称 */
    @Test
    public void testGetCallingItemVariousFinancialPayName() throws Exception {
        String dataOk = "HjwLRdSMLpzSD5ohO2flqFAWlNgnHKaODAHulOlm7bG87GYoRcfFVmZEUSvn2KILGohEzI40p4s8tOwYGPEPnI1zTN8usF3QIxBtaZ40lZpTimjfHx7c8iUZCYV2JI2G9KLFGa4u2KR0UyrW3RdlVv";
        callingItemEntity.setCallingItemVariousFinancialPayName(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemVariousFinancialPayName());
    }

    /** ユーザ団体名称 */
    @Test
    public void testSetUserOrganizationName() throws Exception {
        String dataOk = "DDRrcGEOveonkyKyF2Wry99LHqg9VeWCT6qAAwrmZOWbQDvFucB6fiKcsPEaPOJFitQ60H3lstl3rldL4sYVk9E6UrVKjD1lenXRZFOWrDpn5UhO3YoHpGJwm6zgAlKVKIEbg5ZXLmWXzz8UnvFGt1";
        assertDoesNotThrow(() -> callingItemEntity.setUserOrganizationName(dataOk));
    }

    /** ユーザ団体名称 */
    @Test
    public void testGetUserOrganizationName() throws Exception {
        String dataOk = "vyqLzdtYb8t05pAVukBcy3tl7Mt8APiUU0X2PmHD6VJykfGc1JQIulTLlPeyew8zAYhWXbLQGTdCbQ87tX94yqgtRJunXooTh8ga7mEiCPzWPozzvWwv0MTEtgNiWR1iw6cIuoP1aYPpxvg1LvesUR";
        callingItemEntity.setUserOrganizationName(dataOk);
        assertEquals(dataOk, callingItemEntity.getUserOrganizationName());
    }

    /** 関連者個人Id */
    @Test
    public void testSetRelationPersonId() throws Exception {
        Long dataOk = 47674867L;
        assertDoesNotThrow(() -> callingItemEntity.setRelationPersonId(dataOk));
    }

    /** 関連者個人Id */
    @Test
    public void testGetRelationPersonId() throws Exception {
        Long dataOk = 7541988L;
        callingItemEntity.setRelationPersonId(dataOk);
        assertEquals(dataOk, callingItemEntity.getRelationPersonId());
    }

    /** 更新時間 */
    @Test
    public void testSetUpdateTime() throws Exception {
        Timestamp dataOk = Timestamp.valueOf(LocalDateTime.of(2039, 11, 10, 7, 31, 8));
        assertDoesNotThrow(() -> callingItemEntity.setUpdateTime(dataOk));
    }

    /** 更新時間 */
    @Test
    public void testGetUpdateTime() throws Exception {
        Timestamp dataOk = Timestamp.valueOf(LocalDateTime.of(2019, 7, 20, 7, 31, 8));
        callingItemEntity.setUpdateTime(dataOk);
        assertEquals(dataOk, callingItemEntity.getUpdateTime());
    }

    /** 関連者個人同一識別コード */
    @Test
    public void testSetRelationPersonCode() throws Exception {
        Integer dataOk = 16853115;
        assertDoesNotThrow(() -> callingItemEntity.setRelationPersonCode(dataOk));
    }

    /** 関連者個人同一識別コード */
    @Test
    public void testGetRelationPersonCode() throws Exception {
        Integer dataOk = 42997966;
        callingItemEntity.setRelationPersonCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getRelationPersonCode());
    }

    /** 項目呼び出し条件支店コード */
    @Test
    public void testSetCallingItemZenginBranchCode() throws Exception {
        String dataOk = "jkmPcJ";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemZenginBranchCode(dataOk));
    }

    /** 項目呼び出し条件支店コード */
    @Test
    public void testGetCallingItemZenginBranchCode() throws Exception {
        String dataOk = "BUZl1s";
        callingItemEntity.setCallingItemZenginBranchCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemZenginBranchCode());
    }

    /** 継続事業同一識別コード */
    @Test
    public void testSetContinueBuissinessCode() throws Exception {
        Integer dataOk = 57389552;
        assertDoesNotThrow(() -> callingItemEntity.setContinueBuissinessCode(dataOk));
    }

    /** 継続事業同一識別コード */
    @Test
    public void testGetContinueBuissinessCode() throws Exception {
        Integer dataOk = 35885782;
        callingItemEntity.setContinueBuissinessCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getContinueBuissinessCode());
    }

    /** ユーザ団体Id */
    @Test
    public void testSetUserOrganizationId() throws Exception {
        Long dataOk = 325392875L;
        assertDoesNotThrow(() -> callingItemEntity.setUserOrganizationId(dataOk));
    }

    /** ユーザ団体Id */
    @Test
    public void testGetUserOrganizationId() throws Exception {
        Long dataOk = 23749325L;
        callingItemEntity.setUserOrganizationId(dataOk);
        assertEquals(dataOk, callingItemEntity.getUserOrganizationId());
    }

    /** 項目名称取得同一識別コード */
    @Test
    public void testSetCallingItemCode() throws Exception {
        Integer dataOk = 92543256;
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemCode(dataOk));
    }

    /** 項目名称取得同一識別コード */
    @Test
    public void testGetCallingItemCode() throws Exception {
        Integer dataOk = 96468314;
        callingItemEntity.setCallingItemCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemCode());
    }

    /** 一般項目Id */
    @Test
    public void testSetGeneralItemId() throws Exception {
        Long dataOk = 61512148L;
        assertDoesNotThrow(() -> callingItemEntity.setGeneralItemId(dataOk));
    }

    /** 一般項目Id */
    @Test
    public void testGetGeneralItemId() throws Exception {
        Long dataOk = 10211168L;
        callingItemEntity.setGeneralItemId(dataOk);
        assertEquals(dataOk, callingItemEntity.getGeneralItemId());
    }

    /** 報告書記載名称 */
    @Test
    public void testSetPublishItemName() throws Exception {
        String dataOk = "JNaAAMfl2yBsRcUY7x6rCIv5TZa8iHHUqYMp7zKGtBhOeJo9ZsZ6P380Wo9GzDiPkUYRiP7HULNSFHJXxOHRmdZ1m7sKad5VKDRyeyHEuqepV3Y6D0dPcuYOYaGchoRrDWhsCgpxrED6o2oXul3EWf";
        assertDoesNotThrow(() -> callingItemEntity.setPublishItemName(dataOk));
    }

    /** 報告書記載名称 */
    @Test
    public void testGetPublishItemName() throws Exception {
        String dataOk = "kVv2tFEFIPWFHfuJJAVZ4y8Sd2SqSITjOVBijGmXElAGyyGK8JVfuVkTOSbVCSeoaQd6k924C2ZJdUHh16EFe6zdfroiCvwRRkvFx3mC9g9qap0B5LfVMIowcwY5p9eE6NOwHDY1xnMOMxmHn4g7zQ";
        callingItemEntity.setPublishItemName(dataOk);
        assertEquals(dataOk, callingItemEntity.getPublishItemName());
    }

    /** ログインユーザId */
    @Test
    public void testSetLoginUserId() throws Exception {
        Long dataOk = 359843798436L;
        assertDoesNotThrow(() -> callingItemEntity.setLoginUserId(dataOk));
    }

    /** ログインユーザId */
    @Test
    public void testGetLoginUserId() throws Exception {
        Long dataOk = 49057590457L;
        callingItemEntity.setLoginUserId(dataOk);
        assertEquals(dataOk, callingItemEntity.getLoginUserId());
    }

    /** 項目呼び出し条件郵便番号・後 */
    @Test
    public void testSetCallingItemPostal2() throws Exception {
        String dataOk = "pYdY4QUq";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemPostal2(dataOk));
    }

    /** 項目呼び出し条件郵便番号・後 */
    @Test
    public void testGetCallingItemPostal2() throws Exception {
        String dataOk = "vAG00l31";
        callingItemEntity.setCallingItemPostal2(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemPostal2());
    }

    /** 項目呼び出し条件郵便番号・前 */
    @Test
    public void testSetCallingItemPostal1() throws Exception {
        String dataOk = "RDkxLm";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemPostal1(dataOk));
    }

    /** 項目呼び出し条件郵便番号・前 */
    @Test
    public void testGetCallingItemPostal1() throws Exception {
        String dataOk = "yxn4pS";
        callingItemEntity.setCallingItemPostal1(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemPostal1());
    }

    /** 項目呼び出し条件全銀金融機関コード */
    @Test
    public void testSetCallingItemZenginFinancialOrgCode() throws Exception {
        String dataOk = "NrlrdxyU";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemZenginFinancialOrgCode(dataOk));
    }

    /** 項目呼び出し条件全銀金融機関コード */
    @Test
    public void testGetCallingItemZenginFinancialOrgCode() throws Exception {
        String dataOk = "tOqf5UO4";
        callingItemEntity.setCallingItemZenginFinancialOrgCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemZenginFinancialOrgCode());
    }

    /** 項目呼び出し条件電話番号・番号 */
    @Test
    public void testSetCallingItemTel3() throws Exception {
        String dataOk = "W0JCH2gj";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemTel3(dataOk));
    }

    /** 項目呼び出し条件電話番号・番号 */
    @Test
    public void testGetCallingItemTel3() throws Exception {
        String dataOk = "z16FF2Jp";
        callingItemEntity.setCallingItemTel3(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemTel3());
    }

    /** 項目呼び出し条件電話番号・局番 */
    @Test
    public void testSetCallingItemTel2() throws Exception {
        String dataOk = "f3w5skb";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemTel2(dataOk));
    }

    /** 項目呼び出し条件電話番号・局番 */
    @Test
    public void testGetCallingItemTel2() throws Exception {
        String dataOk = "7xVaHpN";
        callingItemEntity.setCallingItemTel2(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemTel2());
    }

    /** 一般項目同一識別コード */
    @Test
    public void testSetGeneralItemCode() throws Exception {
        Integer dataOk = 64851171;
        assertDoesNotThrow(() -> callingItemEntity.setGeneralItemCode(dataOk));
    }

    /** 一般項目同一識別コード */
    @Test
    public void testGetGeneralItemCode() throws Exception {
        Integer dataOk = 56253410;
        callingItemEntity.setGeneralItemCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getGeneralItemCode());
    }

    /** 項目呼び出し条件電話番号・市外局番 */
    @Test
    public void testSetCallingItemTel1() throws Exception {
        String dataOk = "a6SN0Bib3e";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemTel1(dataOk));
    }

    /** 項目呼び出し条件電話番号・市外局番 */
    @Test
    public void testGetCallingItemTel1() throws Exception {
        String dataOk = "tp26wkucT6";
        callingItemEntity.setCallingItemTel1(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemTel1());
    }

    /** 報告書記載住所 */
    @Test
    public void testSetPublishOrgnizationAddress() throws Exception {
        String dataOk = "g5cWM45fzCBWqdOb0RUdCrjCwhkeKXcXv6rpiFOWxjHAXZE5pW98K0DS7juScShyKIheFxG69hOgBsDQ8YXLKYZBfrxwkziFoxqwXn5UI533Z0BV0C2nyOWxuxYDxZgnNs2jrJcz611ddodcUnucnu";
        assertDoesNotThrow(() -> callingItemEntity.setPublishOrgnizationAddress(dataOk));
    }

    /** 報告書記載住所 */
    @Test
    public void testGetPublishOrgnizationAddress() throws Exception {
        String dataOk = "acOadHvcZGXgMopsjDBGsUmELbDKaKqHXm1ZtsqDX9NtHbAEWb78w7gomV8aXmDH2g1mxtOq5p2PNxSaEnHlBDWDsYrJ9yY6HUCq52wE9bcj63ETNGR0pMHe9EoQJTWNQjHtXdkm8mdEKQ9N5IHLO7";
        callingItemEntity.setPublishOrgnizationAddress(dataOk);
        assertEquals(dataOk, callingItemEntity.getPublishOrgnizationAddress());
    }

    /** ユーザ団体同一識別コード */
    @Test
    public void testSetUserOrganizationCode() throws Exception {
        Integer dataOk = 65205601;
        assertDoesNotThrow(() -> callingItemEntity.setUserOrganizationCode(dataOk));
    }

    /** ユーザ団体同一識別コード */
    @Test
    public void testGetUserOrganizationCode() throws Exception {
        Integer dataOk = 38954116;
        callingItemEntity.setUserOrganizationCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getUserOrganizationCode());
    }

    /** 項目呼び出し条件各種PayId */
    @Test
    public void testSetCallingItemVariousFinancialPayId() throws Exception {
        Long dataOk = 435340968457L;
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemVariousFinancialPayId(dataOk));
    }

    /** 項目呼び出し条件各種PayId */
    @Test
    public void testGetCallingItemVariousFinancialPayId() throws Exception {
        Long dataOk = 4097654L;
        callingItemEntity.setCallingItemVariousFinancialPayId(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemVariousFinancialPayId());
    }

    /** 項目名称取得名称 */
    @Test
    public void testSetCallingItemName() throws Exception {
        String dataOk = "ZCE0SlRrbZExF3UT3C3QPPOHhY4P7ugrR7EIM5ZjjqRjndMro6OaDMXCgpGNexHFtJnvkuJOGhbSiX0eGxS3g5Ha4vW2j3zSwTnS4hdnDmh4kJqvIy4qvavDaUVdHj2vPtBIMNwDaVW72kqzJvjAl3";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemName(dataOk));
    }

    /** 項目名称取得名称 */
    @Test
    public void testGetCallingItemName() throws Exception {
        String dataOk = "Pl6uJ3ux76osxbY8yxPF4RU4gHFgYLhqKjimu8ENZXpMR6hU1sGQQW5Abex9rqDaP2RQ2lpBczNTmY9qKW46FAxeybITFm5X85mKJstKtCWttUBtjEuNew7YOnFnF2BKwosRKAUp2TSVkDYENMDY0U";
        callingItemEntity.setCallingItemName(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemName());
    }

    /** 項目呼び出し条件口座名義人 */
    @Test
    public void testSetCallingItemAccountHas() throws Exception {
        String dataOk = "038pG4xcrnUX11oWMpvQ2RgrqAhY6Q8xvY3yay0sLbPcR0Jk17dHhox78Ean";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemAccountHas(dataOk));
    }

    /** 項目呼び出し条件口座名義人 */
    @Test
    public void testGetCallingItemAccountHas() throws Exception {
        String dataOk = "PbqcVzBnTssK3S5BbEPxmwPlnEz8uNPDJo3UcDNMmVbbCVhY5FV6haKjMSzd";
        callingItemEntity.setCallingItemAccountHas(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemAccountHas());
    }

    /** 項目呼び出し条件各種Payコード */
    @Test
    public void testSetCallingItemVariousFinancialPayCode() throws Exception {
        Integer dataOk = 86054558;
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemVariousFinancialPayCode(dataOk));
    }

    /** 項目呼び出し条件各種Payコード */
    @Test
    public void testGetCallingItemVariousFinancialPayCode() throws Exception {
        Integer dataOk = 7780850;
        callingItemEntity.setCallingItemVariousFinancialPayCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemVariousFinancialPayCode());
    }

    /** 報告書記載名称区分 */
    @Test
    public void testSetPublishItemKbn() throws Exception {
        Integer dataOk = 76563845;
        assertDoesNotThrow(() -> callingItemEntity.setPublishItemKbn(dataOk));
    }

    /** 報告書記載名称区分 */
    @Test
    public void testGetPublishItemKbn() throws Exception {
        Integer dataOk = 50326792;
        callingItemEntity.setPublishItemKbn(dataOk);
        assertEquals(dataOk, callingItemEntity.getPublishItemKbn());
    }

    /** 最新区分 */
    @Test
    public void testSetSaishinKbn() throws Exception {
        Integer dataOk = 36803142;
        assertDoesNotThrow(() -> callingItemEntity.setSaishinKbn(dataOk));
    }

    /** 最新区分 */
    @Test
    public void testGetSaishinKbn() throws Exception {
        Integer dataOk = 40596548;
        callingItemEntity.setSaishinKbn(dataOk);
        assertEquals(dataOk, callingItemEntity.getSaishinKbn());
    }

    /** 関連者政治団体Id */
    @Test
    public void testSetRelationPoliticsOrganizationId() throws Exception {
        Long dataOk = 24908209L;
        assertDoesNotThrow(() -> callingItemEntity.setRelationPoliticsOrganizationId(dataOk));
    }

    /** 関連者政治団体Id */
    @Test
    public void testGetRelationPoliticsOrganizationId() throws Exception {
        Long dataOk = 26758313L;
        callingItemEntity.setRelationPoliticsOrganizationId(dataOk);
        assertEquals(dataOk, callingItemEntity.getRelationPoliticsOrganizationId());
    }

    /** 項目呼び出し条件支店名称 */
    @Test
    public void testSetCallingItemZenginBranchName() throws Exception {
        String dataOk = "9gFWAgRpeBH1YmEYRTj0ScSjeQFkpsCUDhXLsd8sL4KIZdb3GB";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemZenginBranchName(dataOk));
    }

    /** 項目呼び出し条件支店名称 */
    @Test
    public void testGetCallingItemZenginBranchName() throws Exception {
        String dataOk = "P4lXen2UtNqZwQOuOjl6a05C52vAAYO8tVm7WotvqC0ZVirTJh";
        callingItemEntity.setCallingItemZenginBranchName(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemZenginBranchName());
    }

    /** 項目呼び出し条件口座種別区分 */
    @Test
    public void testSetCallingItemAccountType() throws Exception {
        Integer dataOk = 44263564;
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemAccountType(dataOk));
    }

    /** 項目呼び出し条件口座種別区分 */
    @Test
    public void testGetCallingItemAccountType() throws Exception {
        Integer dataOk = 68458770;
        callingItemEntity.setCallingItemAccountType(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemAccountType());
    }

    /** 関連者政治団体同一識別コード */
    @Test
    public void testSetRelationPoliticsOrganizationCode() throws Exception {
        Integer dataOk = 73533691;
        assertDoesNotThrow(() -> callingItemEntity.setRelationPoliticsOrganizationCode(dataOk));
    }

    /** 関連者政治団体同一識別コード */
    @Test
    public void testGetRelationPoliticsOrganizationCode() throws Exception {
        Integer dataOk = 75544333;
        callingItemEntity.setRelationPoliticsOrganizationCode(dataOk);
        assertEquals(dataOk, callingItemEntity.getRelationPoliticsOrganizationCode());
    }

    /** 項目呼び出し条件住所番地 */
    @Test
    public void testSetCallingItemAddressBlock() throws Exception {
        String dataOk = "LLAljvZDlH0gLA946BZCKdBTbdlgO0LHrCl2NO28TcPHw2cUDaUwzjYIsrRaUhtKQcysLKPpfQLFoufykF8xjJOuXMx3pWbae5ZGM44GuD3Yza8Zc0Cy8pGIWDP3smf65iGLYyzoCNUkFosl0ypobo";
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemAddressBlock(dataOk));
    }

    /** 項目呼び出し条件住所番地 */
    @Test
    public void testGetCallingItemAddressBlock() throws Exception {
        String dataOk = "AVhXUDJRcE7DuBobnEAE2BzwxPc7ksQNm6yZB6qS90XScMDY7BZ7ci2wIB3SUI8ht5DHngNTQtViKMwWMlkohmaDKrTwbkYQs6f1Z4IfzxxDvZpYWzeWhVXrmLe3dkeKmEpLqyvDdjJOiuySmKk2yD";
        callingItemEntity.setCallingItemAddressBlock(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemAddressBlock());
    }

    /** 関連者法人Id */
    @Test
    public void testSetRelationCorporationId() throws Exception {
        Long dataOk = 86193128L;
        assertDoesNotThrow(() -> callingItemEntity.setRelationCorporationId(dataOk));
    }

    /** 関連者法人Id */
    @Test
    public void testGetRelationCorporationId() throws Exception {
        Long dataOk = 2837643L;
        callingItemEntity.setRelationCorporationId(dataOk);
        assertEquals(dataOk, callingItemEntity.getRelationCorporationId());
    }

    /** 報告書記載職業または代表者氏名 */
    @Test
    public void testSetPublishProfessionOrgnizationName() throws Exception {
        String dataOk = "dLPkDj5gq28iFK8fjBaqbxrNvM3eXYz5EqnCPix6zXNyr6aO9gyAYTaE4cQXb9EyGHMPehw6q9bw2HVMarrFLHgWM8AQolr1S0dmq4enIrYFMvsd5XTWVe6zjpZCsZOydF0s0mzrWvKFFQjW2Eo6py";
        assertDoesNotThrow(() -> callingItemEntity.setPublishProfessionOrgnizationName(dataOk));
    }

    /** 報告書記載職業または代表者氏名 */
    @Test
    public void testGetPublishProfessionOrgnizationName() throws Exception {
        String dataOk = "tw4LYJeezsWCRpMrfrAer2D8rIeuxu3VskiTamlLR6tSpxOy5w6dQPbJ5JVzUgGLXk6OUSJZxWOzGyZQoSBIwfqMqccDySEqpmwkrD6I0bPuajpynq7EO1lRUU7cIMk5N6e128Rt9A3e9kzxWsPMVi";
        callingItemEntity.setPublishProfessionOrgnizationName(dataOk);
        assertEquals(dataOk, callingItemEntity.getPublishProfessionOrgnizationName());
    }

    /** 項目名称取得Id */
    @Test
    public void testSetCallingItemId() throws Exception {
        Long dataOk = 43847234L;
        assertDoesNotThrow(() -> callingItemEntity.setCallingItemId(dataOk));
    }

    /** 項目名称取得Id */
    @Test
    public void testGetCallingItemId() throws Exception {
        Long dataOk = 3460973489573L;
        callingItemEntity.setCallingItemId(dataOk);
        assertEquals(dataOk, callingItemEntity.getCallingItemId());
    }

}
