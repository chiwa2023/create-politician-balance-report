package mitei.mitei.create.report.balance.politician.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 例外処理保存Utility
 */
@Component
public class RecordExceptionUtil {

    /** Logger */
    private static final Logger log = LoggerFactory.getLogger(RecordExceptionUtil.class);

    /**
     * 例外を保存する
     *
     * @param exception あらゆる例外を受け付ける
     */
    public void practice(final Exception exception) {
        exception.printStackTrace(); // NOPMD
        log.error(exception.getMessage());
    }

}
