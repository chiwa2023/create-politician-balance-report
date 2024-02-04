package mitei.mitei.create.report.balance.politician;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 全体起動
 */
@SpringBootApplication
@EnableBatchProcessing
public class BackApplication { // NOPMD

    /**
     * 全体起動
     *
     * @param args 引数
     */
    public static void main(final String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

}
