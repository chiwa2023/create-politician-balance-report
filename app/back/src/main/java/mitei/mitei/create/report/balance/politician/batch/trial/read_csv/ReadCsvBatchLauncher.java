package mitei.mitei.create.report.balance.politician.batch.trial.read_csv;

import java.net.URISyntaxException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.zz_address.util.GetTestResourceUtil;


//TODO 普段は毎回定期間隔で実行されると煩わしいので@EnableSchedulingと@Componentを無効化する
/**
 * バッチをタイムスケージュールで自動起動するランチャ
 */
@EnableScheduling
@Component
public class ReadCsvBatchLauncher {

    /** 起動をつかさどるランチャー */
    @Autowired
    private JobLauncher jobLauncher;

    /** 起動をするJob */
    @Qualifier(ReadCsvBatchConfiguration.JOB_NAME)
    @Autowired
    private Job readCsvJob;

    /** JobParameter */
    private JobParameters jobParameters = new JobParameters();

    /**
     * 時間間隔と必要な起動引数を設定し、所定時刻で起動する
     *
     * @throws JobExecutionException ジョブ設定に誤りがある場合の例外
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void launchJob() throws JobExecutionException,URISyntaxException {

        String writePath = "c:/temp/report.csv";
        String readPath = GetTestResourceUtil.practice("batch/trial/person.csv").toString();
        
        jobParameters = new JobParametersBuilder(readCsvJob.getJobParametersIncrementer().getNext(this.jobParameters)) // NOPMD
                .addString("readFileName", readPath).addString("writeFileName", writePath)
                .toJobParameters();
        
        jobLauncher.run(readCsvJob, jobParameters);
    }

}
