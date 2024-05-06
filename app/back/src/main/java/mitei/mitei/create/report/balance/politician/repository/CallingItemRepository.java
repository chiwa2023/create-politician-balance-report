package mitei.mitei.create.report.balance.politician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mitei.mitei.create.report.balance.politician.entity.CallingItemEntity;

/**
 * calling_item接続用Repository
 */
public interface CallingItemRepository extends JpaRepository<CallingItemEntity, Long> {

    /**
     * 自身の政治団体が設定した摘要から設定項目を取得する
     *
     * @param UserOrganizationCode ユーザ政治団体同一識別コード
     * @param SaishinKbn 最新区分
     * @param CallingReferDigest 検索用摘要
     * @return 検索結果
     */
    List<CallingItemEntity> findByUserOrganizationCodeAndSaishinKbnAndCallingReferDigest(Integer UserOrganizationCode,Integer SaishinKbn,String CallingReferDigest);
    
    // TODO マスタ系のテーブルでは名称検索が要求されることが多いので、事前に自動生成する。不要な場合は削除する
    /// **
    // * 名称を検索対象として全文検索をする
    // *
    // * @param searchWords 検索語
    // * @return 検索結果
    // */
    // @Query(value = "SELECT * FROM calling_item WHERE saishin_kbn= 1 AND
    // MATCH(calling_item_name) AGAINST (?1 IN NATURAL LANGUAGE MODE)", nativeQuery
    // = true)
    // public List<CallingItemEntity> findFullText(String searchWords);

}
