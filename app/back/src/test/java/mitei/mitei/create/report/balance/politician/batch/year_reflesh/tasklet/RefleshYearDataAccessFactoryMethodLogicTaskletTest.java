package mitei.mitei.create.report.balance.politician.batch.year_reflesh.tasklet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.BackApplication;
import mitei.mitei.create.report.balance.politician.batch.year_reflesh.exception.BadFactoryMethodFileStructureException;
import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * RefleshYearDataAccessFactoryMethodLogicTasklet単体テスト
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBatchTest
@ContextConfiguration(classes = BackApplication.class) // 全体起動
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RefleshYearDataAccessFactoryMethodLogicTaskletTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private RefleshYearDataAccessFactoryMethodLogicTasklet refleshYearDataAccessFactoryMethodLogicTasklet;

    /** JobParameter呼び出しキー(報告年) */
    private static final String COPY_YEAR = "copyYear";
    /** JobParameter呼び出しキー(解析ファイル更新該否) */
    private static final String IS_REFLESH = "isReadFileReflesh";
    /** JobParameter呼び出しキー(ファイル) */
    private static final String FILE01 = "file01";
    /** JobParameter呼び出しキー(現在時) */
    private static final String NOW = "now";

    @Test
    @Tag("SourceReflesh")
    void testExecute00() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters00 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(true)) // 本ファイルを更新設定
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01,
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic.java")
                .addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution00 = MetaDataInstanceFactory.createStepExecution(jobParameters00);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution00);

        // 元ファイル更新フラグが立っているとき、更新対象ファイルは解析対象ファイルと同じである
        assertThat(refleshYearDataAccessFactoryMethodLogicTasklet.getCopyFilePath(0)).isEqualTo(
                "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic.java");

        // 元ファイル更新フラグオン時では、テストでは実際に更新作業は行わない。
        // 内容の確認は差分に起こしたファイルで行う
        // assertThat(refleshYearDataAccessFactoryMethodLogicTasklet.execute(new
        // StepContribution(execution00), null))
        // .isEqualTo(RepeatStatus.FINISHED);

    }

    @Test
    void testExecute01() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString("file01",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic.java")
                .addString("file02",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/SaveSnsDirectMessageSendingResultFactoryLogic.java")
                .addString("file03",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/mail/CallMailSendingInfoFactoryLogic.java")
                .addString("file04",
                        "main/java/mitei/mitei/create/report/balance/politician/task_alert/mail/SaveMailSendingResultFactoryLogic.java")
                .addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);

        // 更新ファイルが立っていないときは別フォルダに排出する、かつ複数ファイル処理対応
        String pathCopy011 = refleshYearDataAccessFactoryMethodLogicTasklet.getCopyFilePath(0);
        String pathCopy012 = refleshYearDataAccessFactoryMethodLogicTasklet.getCopyFilePath(1);
        String pathCopy013 = refleshYearDataAccessFactoryMethodLogicTasklet.getCopyFilePath(2);
        String pathCopy014 = refleshYearDataAccessFactoryMethodLogicTasklet.getCopyFilePath(3);

        assertThat(pathCopy011).isEqualTo(
                "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogicNewDiff.java");
        assertThat(pathCopy012).isEqualTo(
                "test/resources/batch/task_alert/sns/logic/SaveSnsDirectMessageSendingResultFactoryLogicNewDiff.java");
        assertThat(pathCopy013)
                .isEqualTo("test/resources/batch/task_alert/mail/CallMailSendingInfoFactoryLogicNewDiff.java");
        assertThat(pathCopy014)
                .isEqualTo("test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicNewDiff.java");
    }

    @Test
    void testExecute11() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic11.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime("now", LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);

        // 例外発生(importテンプレートに西暦が含まれていない)
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null));

    }

    @Test
    void testExecute12() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic12.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);

        // 例外発生(importテンプレート指定が存在しない)
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null));

    }

    @Test
    void testExecute13() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic13.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);

        // 例外発生(フィールド開始コメントがない)
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null));

    }

    @Test
    void testExecute14() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic14.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);

        // 例外発生(フィールド追加位置指定がない)
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null));

    }

    @Test
    void testExecute15() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic15.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);

        // 例外発生(switch-case開始コメントがない)
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null));

    }

    @Test
    void testExecute16() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic16.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);

        // 例外発生(switch-caseコピー開始位置コメントがない)
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null));

    }

    @Test
    void testExecute17() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic17.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2024))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);
        refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null);

        // すでに解析ファイル内に存在する報告念を指定するとswitch-caseのところで重複エラーになるので処理を中断する(例外とするほどではない)

        String fileCopy = refleshYearDataAccessFactoryMethodLogicTasklet.getCopyFilePath(0);

        assertFalse(Files.exists(Paths.get(GetCurrentResourcePath.getBackSrcPath(fileCopy))),
                "もともとファイルが存在しないので、中断したらファイルが作られない=ファイルが不存在で作成未処理");
    }

    @Test
    void testExecute50() throws Exception {

        String file = "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic50.java_";

        // JobParameterの設定
        JobParameters jobParameters01 = new JobParametersBuilder().addString(COPY_YEAR, String.valueOf(2025))
                .addString(IS_REFLESH, String.valueOf(false)) // 別ファイルに差分を出す
                // keyが『file』で始まるジョブパラメータは解析対象ファイルとして扱う
                .addString(FILE01, file).addLocalDateTime(NOW, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        StepExecution execution01 = MetaDataInstanceFactory.createStepExecution(jobParameters01);
        refleshYearDataAccessFactoryMethodLogicTasklet.beforeStep(execution01);
        refleshYearDataAccessFactoryMethodLogicTasklet.execute(new StepContribution(execution01), null);

        // 正常処理できるのでファイルを書き出しする
        String fileCopy = refleshYearDataAccessFactoryMethodLogicTasklet.getCopyFilePath(0);
        Path pathCopy = Paths.get(GetCurrentResourcePath.getBackSrcPath(fileCopy));
        assertTrue(Files.exists(pathCopy), "書き出ししたのでファイル存在");

        String bodyWrite = Files.readString(pathCopy);

        // 2022年、2024年が存在するところに、2025年を追加したときの想定内容
        Path pathCompare = Paths.get(GetCurrentResourcePath.getBackSrcPath(
                "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogic50Compare.java_"));
        String bodyCompare = Files.readString(pathCompare);

        // 想定内容と一致
        assertThat(bodyWrite).isEqualTo(bodyCompare);
    }

}
