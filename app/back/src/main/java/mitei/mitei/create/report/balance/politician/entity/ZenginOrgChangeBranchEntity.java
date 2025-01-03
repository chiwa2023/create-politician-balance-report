package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;



/**
 * zengin_org_change_branch接続用Entity
 */
@Entity
@Table(name = "zengin_org_change_branch")
public class ZenginOrgChangeBranchEntity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_Long = 0L;

    /** 初期データ(Boolean) */
    private static final Boolean INIT_Boolean = false;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LocalDate = LocalDate.of(1948,7,29);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_Timestamp = INIT_LocalDate.atTime(0, 0, 0);

    /** 金融機関異動Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zengin_org_change_branch_id")
    private Integer zenginOrgChangeBranchId = INIT_Integer;

    /**
     * 金融機関異動Idを取得する
     *
     * @return 金融機関異動Id
     */
    public Integer getZenginOrgChangeBranchId() {
        return zenginOrgChangeBranchId;
    }

    /**
     * 金融機関異動Idを設定する
     *
     * @param zenginOrgChangeBranchId 金融機関異動Id
     */
    public void setZenginOrgChangeBranchId(final Integer zenginOrgChangeBranchId) {
        this.zenginOrgChangeBranchId = zenginOrgChangeBranchId;
    }

    /** 金融機関異動同一識別コード */
    @Column(name = "zengin_org_change_branch_code")
    private Integer zenginOrgChangeBranchCode = INIT_Integer;

    /**
     * 金融機関異動同一識別コードを取得する
     *
     * @return 金融機関異動同一識別コード
     */
    public Integer getZenginOrgChangeBranchCode() {
        return zenginOrgChangeBranchCode;
    }

    /**
     * 金融機関異動同一識別コードを設定する
     *
     * @param zenginOrgChangeBranchCode 金融機関異動同一識別コード
     */
    public void setZenginOrgChangeBranchCode(final Integer zenginOrgChangeBranchCode) {
        this.zenginOrgChangeBranchCode = zenginOrgChangeBranchCode;
    }

    /** 最新区分 */
    @Column(name = "saishin_kbn")
    private Integer saishinKbn = INIT_Integer;

    /**
     * 最新区分を取得する
     *
     * @return 最新区分
     */
    @Override
    public Integer getSaishinKbn() {
        return saishinKbn;
    }

    /**
     * 最新区分を設定する
     *
     * @param saishinKbn 最新区分
     */
    @Override
    public void setSaishinKbn(final Integer saishinKbn) {
        this.saishinKbn = saishinKbn;
    }

    /** 処理終了フラグ */
    @Column(name = "is_finished")
    private Boolean isFinished = INIT_Boolean;

    /**
     * 処理終了フラグを取得する
     *
     * @return 処理終了フラグ
     */
    public Boolean getIsFinished() {
        return isFinished;
    }

    /**
     * 処理終了フラグを設定する
     *
     * @param isFinished 処理終了フラグ
     */
    public void setIsFinished(final Boolean isFinished) {
        this.isFinished = isFinished;
    }

    /** 異動区分 */
    @Column(name = "change_kbn")
    private Integer changeKbn = INIT_Integer;

    /**
     * 異動区分を取得する
     *
     * @return 異動区分
     */
    public Integer getChangeKbn() {
        return changeKbn;
    }

    /**
     * 異動区分を設定する
     *
     * @param changeKbn 異動区分
     */
    public void setChangeKbn(final Integer changeKbn) {
        this.changeKbn = changeKbn;
    }

    /** 異動区分表示 */
    @Column(name = "change_kbn_text")
    private String changeKbnText = INIT_String;

    /**
     * 異動区分表示を取得する
     *
     * @return 異動区分表示
     */
    public String getChangeKbnText() {
        return changeKbnText;
    }

    /**
     * 異動区分表示を設定する
     *
     * @param changeKbnText 異動区分表示
     */
    public void setChangeKbnText(final String changeKbnText) {
        this.changeKbnText = changeKbnText;
    }

    /** 編集金融機関マスタId */
    @Column(name = "zengin_org_tempo_master_id")
    private Integer zenginOrgTempoMasterId = INIT_Integer;

    /**
     * 編集金融機関マスタIdを取得する
     *
     * @return 編集金融機関マスタId
     */
    public Integer getZenginOrgTempoMasterId() {
        return zenginOrgTempoMasterId;
    }

    /**
     * 編集金融機関マスタIdを設定する
     *
     * @param zenginOrgTempoMasterId 編集金融機関マスタId
     */
    public void setZenginOrgTempoMasterId(final Integer zenginOrgTempoMasterId) {
        this.zenginOrgTempoMasterId = zenginOrgTempoMasterId;
    }

    /** 編集全銀協金融機関マスタ同一識別コード */
    @Column(name = "zengin_org_tempo_master_code")
    private Integer zenginOrgTempoMasterCode = INIT_Integer;

    /**
     * 編集全銀協金融機関マスタ同一識別コードを取得する
     *
     * @return 編集全銀協金融機関マスタ同一識別コード
     */
    public Integer getZenginOrgTempoMasterCode() {
        return zenginOrgTempoMasterCode;
    }

    /**
     * 編集全銀協金融機関マスタ同一識別コードを設定する
     *
     * @param zenginOrgTempoMasterCode 編集全銀協金融機関マスタ同一識別コード
     */
    public void setZenginOrgTempoMasterCode(final Integer zenginOrgTempoMasterCode) {
        this.zenginOrgTempoMasterCode = zenginOrgTempoMasterCode;
    }

    /** 編集全銀協金融機関名称 */
    @Column(name = "zengin_org_tempo_master_name")
    private String zenginOrgTempoMasterName = INIT_String;

    /**
     * 編集全銀協金融機関名称を取得する
     *
     * @return 編集全銀協金融機関名称
     */
    public String getZenginOrgTempoMasterName() {
        return zenginOrgTempoMasterName;
    }

    /**
     * 編集全銀協金融機関名称を設定する
     *
     * @param zenginOrgTempoMasterName 編集全銀協金融機関名称
     */
    public void setZenginOrgTempoMasterName(final String zenginOrgTempoMasterName) {
        this.zenginOrgTempoMasterName = zenginOrgTempoMasterName;
    }

    /** 移転先金融機関id */
    @Column(name = "zengin_org_move_id")
    private Integer zenginOrgMoveId = INIT_Integer;

    /**
     * 移転先金融機関idを取得する
     *
     * @return 移転先金融機関id
     */
    public Integer getZenginOrgMoveId() {
        return zenginOrgMoveId;
    }

    /**
     * 移転先金融機関idを設定する
     *
     * @param zenginOrgMoveId 移転先金融機関id
     */
    public void setZenginOrgMoveId(final Integer zenginOrgMoveId) {
        this.zenginOrgMoveId = zenginOrgMoveId;
    }

    /** 移転先金融機関同一識別コード */
    @Column(name = "zengin_org_move_code")
    private Integer zenginOrgMoveCode = INIT_Integer;

    /**
     * 移転先金融機関同一識別コードを取得する
     *
     * @return 移転先金融機関同一識別コード
     */
    public Integer getZenginOrgMoveCode() {
        return zenginOrgMoveCode;
    }

    /**
     * 移転先金融機関同一識別コードを設定する
     *
     * @param zenginOrgMoveCode 移転先金融機関同一識別コード
     */
    public void setZenginOrgMoveCode(final Integer zenginOrgMoveCode) {
        this.zenginOrgMoveCode = zenginOrgMoveCode;
    }

    /** 移転先金融機関名称 */
    @Column(name = "zengin_org_move_name")
    private String zenginOrgMoveName = INIT_String;

    /**
     * 移転先金融機関名称を取得する
     *
     * @return 移転先金融機関名称
     */
    public String getZenginOrgMoveName() {
        return zenginOrgMoveName;
    }

    /**
     * 移転先金融機関名称を設定する
     *
     * @param zenginOrgMoveName 移転先金融機関名称
     */
    public void setZenginOrgMoveName(final String zenginOrgMoveName) {
        this.zenginOrgMoveName = zenginOrgMoveName;
    }

    /** 全銀協金融機関コード */
    @Column(name = "org_code")
    private String orgCode = INIT_String;

    /**
     * 全銀協金融機関コードを取得する
     *
     * @return 全銀協金融機関コード
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 全銀協金融機関コードを設定する
     *
     * @param orgCode 全銀協金融機関コード
     */
    public void setOrgCode(final String orgCode) {
        this.orgCode = orgCode;
    }

    /** 全銀協金融機関支店コード */
    @Column(name = "branch_code")
    private String branchCode = INIT_String;

    /**
     * 全銀協金融機関支店コードを取得する
     *
     * @return 全銀協金融機関支店コード
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * 全銀協金融機関支店コードを設定する
     *
     * @param branchCode 全銀協金融機関支店コード
     */
    public void setBranchCode(final String branchCode) {
        this.branchCode = branchCode;
    }

    /** 金融機関かな */
    @Column(name = "org_name_kana")
    private String orgNameKana = INIT_String;

    /**
     * 金融機関かなを取得する
     *
     * @return 金融機関かな
     */
    public String getOrgNameKana() {
        return orgNameKana;
    }

    /**
     * 金融機関かなを設定する
     *
     * @param orgNameKana 金融機関かな
     */
    public void setOrgNameKana(final String orgNameKana) {
        this.orgNameKana = orgNameKana;
    }

    /** 金融機関名称 */
    @Column(name = "org_name")
    private String orgName = INIT_String;

    /**
     * 金融機関名称を取得する
     *
     * @return 金融機関名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 金融機関名称を設定する
     *
     * @param orgName 金融機関名称
     */
    public void setOrgName(final String orgName) {
        this.orgName = orgName;
    }

    /** 支店名かな */
    @Column(name = "branch_name_kana")
    private String branchNameKana = INIT_String;

    /**
     * 支店名かなを取得する
     *
     * @return 支店名かな
     */
    public String getBranchNameKana() {
        return branchNameKana;
    }

    /**
     * 支店名かなを設定する
     *
     * @param branchNameKana 支店名かな
     */
    public void setBranchNameKana(final String branchNameKana) {
        this.branchNameKana = branchNameKana;
    }

    /** 支店名 */
    @Column(name = "branch_name")
    private String branchName = INIT_String;

    /**
     * 支店名を取得する
     *
     * @return 支店名
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 支店名を設定する
     *
     * @param branchName 支店名
     */
    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }

    /** 支店郵便番号 */
    @Column(name = "postal_code")
    private String postalCode = INIT_String;

    /**
     * 支店郵便番号を取得する
     *
     * @return 支店郵便番号
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 支店郵便番号を設定する
     *
     * @param postalCode 支店郵便番号
     */
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    /** 支店住所 */
    @Column(name = "branch_address")
    private String branchAddress = INIT_String;

    /**
     * 支店住所を取得する
     *
     * @return 支店住所
     */
    public String getBranchAddress() {
        return branchAddress;
    }

    /**
     * 支店住所を設定する
     *
     * @param branchAddress 支店住所
     */
    public void setBranchAddress(final String branchAddress) {
        this.branchAddress = branchAddress;
    }

    /** 支店電話番号 */
    @Column(name = "phon_number")
    private String phonNumber = INIT_String;

    /**
     * 支店電話番号を取得する
     *
     * @return 支店電話番号
     */
    public String getPhonNumber() {
        return phonNumber;
    }

    /**
     * 支店電話番号を設定する
     *
     * @param phonNumber 支店電話番号
     */
    public void setPhonNumber(final String phonNumber) {
        this.phonNumber = phonNumber;
    }

    /** 手形交換所番号 */
    @Column(name = "bill_exchange_number")
    private String billExchangeNumber = INIT_String;

    /**
     * 手形交換所番号を取得する
     *
     * @return 手形交換所番号
     */
    public String getBillExchangeNumber() {
        return billExchangeNumber;
    }

    /**
     * 手形交換所番号を設定する
     *
     * @param billExchangeNumber 手形交換所番号
     */
    public void setBillExchangeNumber(final String billExchangeNumber) {
        this.billExchangeNumber = billExchangeNumber;
    }

    /** 並び順 */
    @Column(name = "order_code")
    private String orderCode = INIT_String;

    /**
     * 並び順を取得する
     *
     * @return 並び順
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 並び順を設定する
     *
     * @param orderCode 並び順
     */
    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    /** 内国為替制度加盟該否 */
    @Column(name = "flg_naikoku_kawase")
    private String flgNaikokuKawase = INIT_String;

    /**
     * 内国為替制度加盟該否を取得する
     *
     * @return 内国為替制度加盟該否
     */
    public String getFlgNaikokuKawase() {
        return flgNaikokuKawase;
    }

    /**
     * 内国為替制度加盟該否を設定する
     *
     * @param flgNaikokuKawase 内国為替制度加盟該否
     */
    public void setFlgNaikokuKawase(final String flgNaikokuKawase) {
        this.flgNaikokuKawase = flgNaikokuKawase;
    }

    /** 挿入ユーザId */
    @Column(name = "insert_user_id")
    private Long insertUserId = INIT_Long;

    /**
     * 挿入ユーザIdを取得する
     *
     * @return 挿入ユーザId
     */
    @Override
    public Long getInsertUserId() {
        return insertUserId;
    }

    /**
     * 挿入ユーザIdを設定する
     *
     * @param insertUserId 挿入ユーザId
     */
    @Override
    public void setInsertUserId(final Long insertUserId) {
        this.insertUserId = insertUserId;
    }

    /** 挿入ユーザ同一識別コード */
    @Column(name = "insert_user_code")
    private Integer insertUserCode = INIT_Integer;

    /**
     * 挿入ユーザ同一識別コードを取得する
     *
     * @return 挿入ユーザ同一識別コード
     */
    @Override
    public Integer getInsertUserCode() {
        return insertUserCode;
    }

    /**
     * 挿入ユーザ同一識別コードを設定する
     *
     * @param insertUserCode 挿入ユーザ同一識別コード
     */
    @Override
    public void setInsertUserCode(final Integer insertUserCode) {
        this.insertUserCode = insertUserCode;
    }

    /** 挿入ユーザ姓名 */
    @Column(name = "insert_user_name")
    private String insertUserName = INIT_String;

    /**
     * 挿入ユーザ姓名を取得する
     *
     * @return 挿入ユーザ姓名
     */
    @Override
    public String getInsertUserName() {
        return insertUserName;
    }

    /**
     * 挿入ユーザ姓名を設定する
     *
     * @param insertUserName 挿入ユーザ姓名
     */
    @Override
    public void setInsertUserName(final String insertUserName) {
        this.insertUserName = insertUserName;
    }

    /** 挿入タイムスタンプ */
    @Column(name = "insert_timestamp")
    private LocalDateTime insertTimestamp = INIT_Timestamp;

    /**
     * 挿入タイムスタンプを取得する
     *
     * @return 挿入タイムスタンプ
     */
    @Override
    public LocalDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * 挿入タイムスタンプを設定する
     *
     * @param insertTimestamp 挿入タイムスタンプ
     */
    @Override
    public void setInsertTimestamp(final LocalDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    /** 更新ユーザId */
    @Column(name = "update_user_id")
    private Long updateUserId = INIT_Long;

    /**
     * 更新ユーザIdを取得する
     *
     * @return 更新ユーザId
     */
    @Override
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 更新ユーザIdを設定する
     *
     * @param updateUserId 更新ユーザId
     */
    @Override
    public void setUpdateUserId(final Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /** 更新ユーザ同一識別コード */
    @Column(name = "update_user_code")
    private Integer updateUserCode = INIT_Integer;

    /**
     * 更新ユーザ同一識別コードを取得する
     *
     * @return 更新ユーザ同一識別コード
     */
    @Override
    public Integer getUpdateUserCode() {
        return updateUserCode;
    }

    /**
     * 更新ユーザ同一識別コードを設定する
     *
     * @param updateUserCode 更新ユーザ同一識別コード
     */
    @Override
    public void setUpdateUserCode(final Integer updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    /** 更新ユーザ姓名 */
    @Column(name = "update_user_name")
    private String updateUserName = INIT_String;

    /**
     * 更新ユーザ姓名を取得する
     *
     * @return 更新ユーザ姓名
     */
    @Override
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 更新ユーザ姓名を設定する
     *
     * @param updateUserName 更新ユーザ姓名
     */
    @Override
    public void setUpdateUserName(final String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /** 更新タイムスタンプ */
    @Column(name = "update_timestamp")
    private LocalDateTime updateTimestamp = INIT_Timestamp;

    /**
     * 更新タイムスタンプを取得する
     *
     * @return 更新タイムスタンプ
     */
    @Override
    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 更新タイムスタンプを設定する
     *
     * @param updateTimestamp 更新タイムスタンプ
     */
    @Override
    public void setUpdateTimestamp(final LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

}
