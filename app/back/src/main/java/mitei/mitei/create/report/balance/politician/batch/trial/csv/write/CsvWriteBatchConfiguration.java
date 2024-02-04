package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

/**
 * データベースを読み取りcsvに書き込むバッチ動作テストのConfig
 */
@Configuration
public class CsvWriteBatchConfiguration {

    /** チャンクサイズ */
    private static final int CHUNK_SIZE = 3;

    /** このバッチの名称 */
    private static final String BATCH_NAME = "CsvWrite";

    /** Job名称 */
    public static final String JOB_NAME = "job" + BATCH_NAME;

    /** Step名称 */
    public static final String STEP_NAME = "step" + BATCH_NAME;

    /** エンティティマネージャ */
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * リーダを取得する
     *
     * @return リーダ
     */
    @Bean
    protected CsvWriteTrialBatchItemReader csvWriteTrialBatchItemReader() {
        CsvWriteTrialBatchItemReader csvWriteTrialBatchItemReader = new CsvWriteTrialBatchItemReader();
        csvWriteTrialBatchItemReader.setEntityManagerFactory(entityManagerFactory);
        JpaNativeQueryProvider<TrialBatch> queryProvider = new JpaNativeQueryProvider<>();
        csvWriteTrialBatchItemReader.setQueryProvider(queryProvider);

        return csvWriteTrialBatchItemReader;
    }

    /**
     * ライタを取得する
     *
     * @return ライタ
     */
    @Bean
    protected CsvWriteTrialBatchItemWriter csvWriteTrialBatchItemWriter() {
        Path path = Paths.get("c:/temp8/aaa.csv");
        CsvWriteTrialBatchItemWriter csvWriteTrialBatchItemWriter = new CsvWriteTrialBatchItemWriter();
        csvWriteTrialBatchItemWriter.setResource(new FileSystemResource(path.toFile()));
        csvWriteTrialBatchItemWriter.setLineAggregator(new TrialBatchAggregator());
        
        return csvWriteTrialBatchItemWriter;
    }

    /**
     * ジョブを取得する
     *
     * @param jobRepository ジョブリポジトリ
     * @param stepCsvWrite ステップ
     * @return ジョブ
     */
    @Bean(JOB_NAME)
    protected Job jobCsvWrite(final JobRepository jobRepository, final Step stepCsvWrite) {

        return new JobBuilder(JOB_NAME, jobRepository).incrementer(new RunIdIncrementer()).flow(stepCsvWrite).end()
                .build();
    }

    /**
     * ステップを取得する
     *
     * @param jobRepository ジョブリポジトリ
     * @param transactionManager トランザクションマネージャ
     * @param csvWriteTrialBatchItemReader itemReader
     * @param csvWriteTrialBatchItemWriter itemWriter
     * @return ステップ
     */
    @Bean(STEP_NAME)
    protected Step stepCsvWrite(
            final JobRepository jobRepository, 
            final PlatformTransactionManager transactionManager,
            final CsvWriteTrialBatchItemReader csvWriteTrialBatchItemReader,
            final CsvWriteTrialBatchItemWriter csvWriteTrialBatchItemWriter) {

        return new StepBuilder(STEP_NAME, jobRepository).<TrialBatch, TrialBatch>chunk(CHUNK_SIZE, transactionManager)
                .reader(csvWriteTrialBatchItemReader).writer(csvWriteTrialBatchItemWriter).build();
    }

}
