package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import lombok.RequiredArgsConstructor;

/**
 * データベースを読み取りcsvに書き込むバッチ動作テストのランチャ(というよりタイマーがメイン)
 */
@Component
// TODO 本番起動時には下記2アノテーションを有効にする。そのままにするとapplication.propertyで
//batchを有効化しているかどうかに関係なく起動してくる(スケジュール機能ってそういう物らしい)
//@EnableScheduling
//@RequiredArgsConstructor
public class CsvWriteBatchLauncher {

    /** 起動をつかさどるランチャー */
    private final JobLauncher jobLauncher;

    /** 起動をするJob */
    private final Job jobCsvWrite;

    /** 起動引数(このJobでは引数なし) */
    private JobParameters jobParameters;

    /**
     * コンストラクタ
     *
     * @param jobLauncher ランチャ
     * @param jobCsvWrite ジョブ
     */
    public CsvWriteBatchLauncher(final JobLauncher jobLauncher, final Job jobCsvWrite) {
        this.jobLauncher = jobLauncher;
        this.jobCsvWrite = jobCsvWrite;
    }

    
    /**
     * 時間間隔と必要な起動引数を設定し、所定時刻で起動する
     *
     * @throws JobExecutionException ジョブ設定に誤りがある場合の例外
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void launchJob() throws JobExecutionException {
        this.jobParameters = jobCsvWrite// NOPMD LawOfDemeter
                .getJobParametersIncrementer()
                .getNext(this.jobParameters);
        
        this.jobLauncher.run(this.jobCsvWrite, this.jobParameters);
    }
    
    /**
     * ランチャーを取得する
     *
     * @return このバッチのランチャー
     */
    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    /**
     * 所定のジョブを取得する
     *
     * @return このBatchのジョブ
     */
    public Job getJobCsvWrite() {
        return jobCsvWrite;
    }

}
