package mitei.mitei.create.report.balance.politician.batch.year_reflesh.tasklet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.batch.year_reflesh.exception.BadFactoryMethodFileStructureException;
import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * RefleshYearDataAccessFactoryMethodLogicTestTasklet単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RefleshYearDataAccessFactoryMethodLogicTestTaskletTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private RefleshYearDataAccessFactoryMethodLogicTestTasklet refleshYearDataAccessFactoryMethodLogicTestTasklet;

    /** JobParameterのkey(複写年) */
    private static final String COPY_YEAR_TEXT = "copyYear";
    /** JobParameterのdata(2025) */
    private static final String YEAR_TEXT = "2025";
    /** JobParameterのkey(解析ファイル更新該否) */
    private static final String REFLESH_TEXT = "isReadFileReflesh";
    /** JobParameterのkey(現在時) */
    private static final String NOW_TEXT = "now";
    /** JobParameterのkey(Java) */
    private static final String JAVA_TEXT = "java01";
    /** JobParameterのkey(SQL) */
    private static final String SQL_TEXT = "sql01";

    @Test
    void testExecute00() throws Exception {

        // 更新先ファイルが解析ファイルであるとの設定の場合

        String javaPath = "test/java/mitei/mitei/create/report/balance/politician/task_alert/mail/SaveMailSendingResultFactoryLogicTest.java";
        String sqlPath = "test/resources/mitei/mitei/create/report/balance/politician/task_alert/mail/truncate_all_mail_table.sql";

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(true)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT, javaPath).addString(SQL_TEXT, sqlPath)
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);

        assertThat(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopyJavaPath(0)).isEqualTo(javaPath); // 解析元と出力先が同じ
        assertThat(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopySqlPath(0)).isEqualTo(sqlPath); // 解析元と出力先が同じ
    }

    @Test
    void testExecute01() throws Exception {

        // 更新先ファイルは別場所に出力する設定の場合。複数あってもJavaとSqlで数が異なってもOK

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString("java101",
                        "test/java/mitei/mitei/create/report/balance/politician/task_alert/mail/SaveMailSendingResultFactoryLogicTest.java")
                .addString("java102",
                        "test/java/mitei/mitei/create/report/balance/politician/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogicTest.java")
                .addString("java103",
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest00.java_")
                .addString("sql101",
                        "test/resources/mitei/mitei/create/report/balance/politician/task_alert/mail/truncate_all_mail_table.sql")
                .addString("sql102", "test/resources/batch/task_alert/mail/abc_def.sql")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);

        // 元ソースの場所の場合は、出力先を別フォルダに移動
        assertThat(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopyJavaPath(0))
                .isEqualTo("test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTestNewDiff.java");
        // 元ソースの場所の場合は、出力先を別フォルダに移動
        assertThat(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopyJavaPath(1)).isEqualTo(
                "test/resources/batch/task_alert/sns/logic/CallSnsDirectMessageSendingInfoFactoryLogicTestNewDiff.java");
        // 解析ファイルががテスト専用フォルダの場合はそのまま
        assertThat(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopyJavaPath(2))
                .isEqualTo("test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest00NewDiff.java_");

        // 元ソースの場所の場合は、出力先を別フォルダに移動
        assertThat(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopySqlPath(0))
                .isEqualTo("test/resources/batch/task_alert/mail/truncate_all_mail_tableNewDiff.sql");
        // 解析ファイルががテスト専用フォルダの場合はそのまま
        assertThat(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopySqlPath(1))
                .isEqualTo("test/resources/batch/task_alert/mail/abc_defNewDiff.sql");
    }

    @Test
    void testExecute02() throws Exception {

        // 双方のファイルの中に複写報告年が含まれている

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT,
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest02.java_")
                .addString(SQL_TEXT, "test/resources/batch/task_alert/mail/abc_def02.sql")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution), null);

        String fileCopySql = refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopySqlPath(0);

        assertFalse(Files.exists(Paths.get(GetCurrentResourcePath.getBackSrcPath(fileCopySql))),
                "もともとファイルが存在しないので、中断したらファイルが作られない=ファイルが不存在で作成未処理");

        String fileCopyJava = refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopyJavaPath(0);

        assertFalse(Files.exists(Paths.get(GetCurrentResourcePath.getBackSrcPath(fileCopyJava))),
                "もともとファイルが存在しないので、中断したらファイルが作られない=ファイルが不存在で作成未処理");
    }

    @Test
    void testExecute03() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT,
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest03.java_")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);

        // importコメントがありません
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution),
                        null));

    }

    @Test
    void testExecute04() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT,
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest04.java_")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);

        // テンプレート開始コメントがありません
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution),
                        null));
    }

    @Test
    void testExecute05() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT,
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest05.java_")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);

        // テンプレート貼り付け位置コメントがありません
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution),
                        null));

    }

    @Test
    void testExecute06() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT,
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest06.java_")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);

        // テンプレートとなるimport文に報告年が含まれていません
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution),
                        null));

    }

    @Test
    void testExecute07() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT,
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest07.java_")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);

        // 追加指定位置コメントが存在しません
        assertThrows(BadFactoryMethodFileStructureException.class,
                () -> refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution),
                        null));
    }

    @Test
    void testExecute50() throws Exception {

        // JobParameterの設定
        JobParameters jobParameters = new JobParametersBuilder().addString(COPY_YEAR_TEXT, YEAR_TEXT)
                .addString(REFLESH_TEXT, String.valueOf(false)) // 解析ファイルを更新設定
                .addString(JAVA_TEXT,
                        "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest50.java_")
                .addString(SQL_TEXT, "test/resources/batch/task_alert/mail/abc_def50.sql")
                .addLocalDateTime(NOW_TEXT, LocalDateTime.now()) // 実作業では必要としないがパラメータ一致よけ
                .toJobParameters();

        // JobParameter取得
        StepExecution execution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.beforeStep(execution);
        refleshYearDataAccessFactoryMethodLogicTestTasklet.execute(new StepContribution(execution), null);

        /* 正常処理できたので結果を比較 */

        // Java側の想定結果ファイルと比較
        String pathJava = GetCurrentResourcePath
                .getBackSrcPath(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopyJavaPath(0));
        String copyJavaBody = Files.readString(Paths.get(pathJava));
        String pathJavaCompare = GetCurrentResourcePath.getBackSrcPath(
                "test/resources/batch/task_alert/mail/SaveMailSendingResultFactoryLogicTest50Compare.java_");
        String copyJavaCompare = Files.readString(Paths.get(pathJavaCompare));
        assertThat(copyJavaBody).isEqualTo(copyJavaCompare);

        // Sql側の想定結果ファイルと比較
        String pathSql = GetCurrentResourcePath
                .getBackSrcPath(refleshYearDataAccessFactoryMethodLogicTestTasklet.getCopySqlPath(0));
        String copySqlBody = Files.readString(Paths.get(pathSql));
        String pathSqlCompare = GetCurrentResourcePath
                .getBackSrcPath("test/resources/batch/task_alert/mail/abc_def50compare.sql");
        String copySqlCompare = Files.readString(Paths.get(pathSqlCompare));
        assertThat(copySqlBody).isEqualTo(copySqlCompare);

    }

}
