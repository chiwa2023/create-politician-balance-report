package mitei.mitei.create.report.balance.politician.batch.trial.csv.write;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * バッチテスト用Entity
 */
@Entity
@Table(name = "trial_batch")
public class TrialBatch implements Serializable{ // NOPMD

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** id */
    @Id
    @Column(name = "id")
    private long id; // NOPMD

    
    /** 内容 */
    @Column(name = "content")
    private String content;
    
    /** 更新時間 */
    @Column(name = "update_time")
    private Timestamp updateTime;
    
    /**
     * idを取得する
     *
     * @return id
     */
    public long getId() {
        return id;
    }
    /**
     * idを設定する
     *
     * @param id id
     */
    public void setId(final long id) { // NOPMD
        this.id = id;
    }
    /**
     * 内容を取得する
     *
     * @return 内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 内容を設定する
     *
     * @param content 内容
     */
    public void setContent(final String content) {
        this.content = content;
    }
    /**
     * 更新時間を取得する
     *
     * @return 更新時間
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }
    /**
     * 更新時間を設定する
     *
     * @param updateTime 更新時間
     */
    public void setUpdateTime(final Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    
}
