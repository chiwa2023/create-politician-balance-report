package mitei.mitei.create.report.balance.politician.observation.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mitei.mitei.create.report.balance.politician.observation.WriteObservationTableUtil;

/**
 * WriteObservationTableUtilのMock
 */
public class MockWriteObservationTableUtil extends WriteObservationTableUtil {

    /** Logger */
    private static final Logger log = LoggerFactory.getLogger(MockWriteObservationTableUtil.class);
    
    /**
     * 仮メソッド
     */
    @Override
    public int practice() {
        
        log.info("tampering...");

        return 0;
    }

}
