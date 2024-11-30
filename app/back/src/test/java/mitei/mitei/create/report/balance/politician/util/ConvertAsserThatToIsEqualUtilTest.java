package mitei.mitei.create.report.balance.politician.util;

import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * ConvertAsserThatToIsEqualUtil単体テスト
 */
class ConvertAsserThatToIsEqualUtilTest {

    @Test
    void test() throws Exception {

        final String root = "/mitei/mitei/create/report/balance/politician/logic/audit_opinion";

        ConvertAsserThatToIsEqualUtil convertAsserThatToIsEqualUtil = new ConvertAsserThatToIsEqualUtil();

        Path pathDirectory = Paths.get(GetCurrentResourcePath.getBackTestFilePath() + root);

        convertAsserThatToIsEqualUtil.practice(pathDirectory);

        // TODO 動作結果のテスト
        // 候補1.ファイル存在
        // 候補2.ファイル内容

        fail("Not yet implemented");
    }

}
