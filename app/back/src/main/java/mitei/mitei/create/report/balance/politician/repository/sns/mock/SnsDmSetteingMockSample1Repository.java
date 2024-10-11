package mitei.mitei.create.report.balance.politician.repository.sns.mock;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mitei.mitei.create.report.balance.politician.entity.sns.mock.SnsDmSettingMockSample1Entity;


/**
 * MockのSNS(Sample1)Repository
 */
public interface SnsDmSetteingMockSample1Repository  extends JpaRepository<SnsDmSettingMockSample1Entity, Long>{

    /**
     * ログインユーザ同一識別コードと最新区分からSNS接続情報を呼び出しする
     *
     * @param loginUserCode ログインユーザ同一識別コード
     * @param saishinKbn 最新区分
     * @return SNS接続情報
     */
    Optional<SnsDmSettingMockSample1Entity> findByLoginUserCodeAndSaishinKbn(Integer loginUserCode,Integer saishinKbn);

}
