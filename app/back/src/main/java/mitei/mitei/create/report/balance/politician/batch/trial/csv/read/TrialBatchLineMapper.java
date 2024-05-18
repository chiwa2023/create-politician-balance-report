package mitei.mitei.create.report.balance.politician.batch.trial.csv.read;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.batch.item.file.LineMapper;

import mitei.mitei.create.report.balance.politician.batch.trial.csv.write.TrialBatch;

/**
 * csvの読み取りをするLineMapper
 */
public class TrialBatchLineMapper implements LineMapper<TrialBatch> {

    /**
     * 行データをTrialBatchに変換する
     */
    @Override
    public TrialBatch mapLine(final String line, final int lineNumber) throws Exception {
        
        TrialBatch trialBatch = new TrialBatch();
        
        String[] cell = line.split(",");
        
        trialBatch.setId(0);
        trialBatch.setContent(this.removeQuote(cell[0]));
        trialBatch.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        
        return trialBatch;
    }

    
    private String removeQuote(final String data) {
        int posStart = 0;
        int posEnd = data.length();
        
        if(data.startsWith("\"")) {
            posStart++;
        }
        
        if(data.endsWith("\"")) {
            posEnd--;
        }

        return data.substring(posStart,posEnd);
    }
}
