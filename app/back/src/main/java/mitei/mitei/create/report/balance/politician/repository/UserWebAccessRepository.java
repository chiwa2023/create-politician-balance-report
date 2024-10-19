package mitei.mitei.create.report.balance.politician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import mitei.mitei.create.report.balance.politician.entity.PoliticalOrgBelogingUserEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;

/**
 * user_web_access接続用Repository
 */
public interface UserWebAccessRepository extends JpaRepository<UserWebAccessEntity, Integer> {

    // TODO マスタ系のテーブルでは名称検索が要求されることが多いので、事前に自動生成する。不要な場合は削除する
    /**
     * 名称を検索対象として全文検索をする
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    @Query(value = "SELECT * FROM user_web_access WHERE saishin_kbn= 1 AND MATCH(user_web_access_name) AGAINST (?1 IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    List<UserWebAccessEntity> findFullText(String searchWords);

    /**
     * 政治団体同一識別コードから該当ユーザを抽出する
     *
     * @param entityManager    entityManager
     * @param politicalOrgCode 政治団体同一識別コード
     * @return ユーザリスト
     */
    default List<UserWebAccessEntity> findselectByPoliOrgCode(final EntityManager entityManager, final Integer politicalOrgCode) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder(); // NOPMD
        CriteriaQuery<Integer> querySub = builder.createQuery(Integer.class);

        Subquery<Integer> subquery = querySub.subquery(Integer.class);
        Root<PoliticalOrgBelogingUserEntity> rootPoliOrg = subquery.from(PoliticalOrgBelogingUserEntity.class);
        subquery.select(rootPoliOrg.get("userCode"))
                .where(builder.equal(rootPoliOrg.get("politicalOrganizationCode"), politicalOrgCode));

        CriteriaQuery<UserWebAccessEntity> query = builder.createQuery(UserWebAccessEntity.class);
        Root<UserWebAccessEntity> root = query.from(UserWebAccessEntity.class);
        query.select(root)
                .where(builder.and(builder.equal(root.get("saishinKbn"), 1), root.get("userCode").in(subquery)));

        return entityManager.createQuery(query).getResultList();
    }

}
