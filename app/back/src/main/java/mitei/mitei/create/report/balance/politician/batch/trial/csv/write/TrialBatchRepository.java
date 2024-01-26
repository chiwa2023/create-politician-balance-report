package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * バッチテスト用テーブルtrial_batchのリポジトリ
 */
@Repository
public interface TrialBatchRepository extends JpaRepository<TrialBatch, Long> {

    
}
