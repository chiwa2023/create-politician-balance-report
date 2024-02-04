package mitei.mitei.create.report.balance.politician.batch.trial.csv.read;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * csvを読み込んでデータべース書込みバッチ動作テストのランチャ(というよりタイマーがメイン)
 */
@Component
//TODO 本番起動時には下記2アノテーションを有効にする。そのままにするとapplication.propertyで
//batchを有効化しているかどうかに関係なく起動してくる(スケジュール機能ってそういう物らしい)
//@EnableScheduling
//@RequiredArgsConstructor
public class CsvReadBatchLauncher {


    /** 起動をつかさどるランチャー */
    private final JobLauncher jobLauncher;

    /** 起動をするJob */
    private final Job jobCsvRead;

    /** 起動引数(このJobでは引数なし) */
    private JobParameters jobParameters;

    /**
     * コンストラクタ
     *
     * @param jobLauncher ランチャ
     * @param jobCsvRead ジョブ
     */
    public CsvReadBatchLauncher(final JobLauncher jobLauncher, final Job jobCsvRead) {
        this.jobLauncher = jobLauncher;
        this.jobCsvRead = jobCsvRead;
    }

    /**
     * 時間間隔と必要な起動引数を設定し、所定時刻で起動する
     *
     * @throws JobExecutionException ジョブ設定に誤りがある場合の例外
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void launchJob() throws JobExecutionException {
        this.jobParameters = jobCsvRead// NOPMD LawOfDemeter
                .getJobParametersIncrementer()
                .getNext(this.jobParameters);
        
        this.jobLauncher.run(this.jobCsvRead, this.jobParameters);
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
    public Job getJobCsvRead() {
        return jobCsvRead;
    }

}
