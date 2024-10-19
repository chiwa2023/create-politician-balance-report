package mitei.mitei.create.report.balance.politician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mitei.mitei.create.report.balance.politician.entity.PoliticalOrgBelogingUserEntity;

/**
 * political_org_beloging_user接続用Repository
 */
public interface PoliticalOrgBelogingUserRepository extends JpaRepository<PoliticalOrgBelogingUserEntity, Long> {

    // TODO マスタ系のテーブルでは名称検索が要求されることが多いので、事前に自動生成する。不要な場合は削除する
    /**
     * 名称を検索対象として全文検索をする
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    @Query(value = "SELECT * FROM political_org_beloging_user WHERE saishin_kbn= 1 AND MATCH(political_org_beloging_user_name) AGAINST (?1 IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    List<PoliticalOrgBelogingUserEntity> findFullText(String searchWords);

    /**
     * ユーザ同一識別コードから所属政治団体リストを取得する
     *
     * @param saishinKbn 最新区分
     * @param userCode   ユーザ同一識別コード
     * @return 検索結果
     */
    List<PoliticalOrgBelogingUserEntity> findBySaishinKbnAndUserCode(Integer saishinKbn, Integer userCode);

    
    /**
     * 政治団体同一識別コードからリストを取得する
     *
     * @param saishinKbn 最新区分
     * @param politicalOrgCode 政治団体同一識別コード
     * @return 検索結果
     */
    List<PoliticalOrgBelogingUserEntity> findBySaishinKbnAndPoliticalOrganizationCode(Integer saishinKbn, Integer politicalOrgCode);

}
