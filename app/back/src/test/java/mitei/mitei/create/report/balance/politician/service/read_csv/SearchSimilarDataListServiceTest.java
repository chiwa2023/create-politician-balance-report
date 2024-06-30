package mitei.mitei.create.report.balance.politician.service.read_csv;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * SearchSimilarDataListService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class SearchSimilarDataListServiceTest {

    /** テスト対象 */
    @Autowired
    private SearchSimilarDataListService searchSimilarDataListService;

    @Test
    void testPractice() {

        List<List<String>> list = searchSimilarDataListService.practice(null);

        // TODO 仕様未決定のため何がしかリストが取れたらとりあえずOK
        // for(List<String> line : list) {
        // for(String data : line) {
        // System.out.print(data + "-");
        // }
        // System.out.println();
        // }

        assertTrue(list.isEmpty(), "仕様未決定のため何がしかリストが取れたらとりあえずOK");

        fail("Not yet implemented");
    }

}
