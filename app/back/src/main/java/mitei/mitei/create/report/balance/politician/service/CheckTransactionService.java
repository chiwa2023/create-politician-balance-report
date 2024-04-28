package mitei.mitei.create.report.balance.politician.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;

/**
 * 排他制御がされているかをチェックするService
 * TODO 仕様が決定次第修正する
 */
@Service
public class CheckTransactionService {

    /**
     * 排他制御の対象かどうかをチェックする
     *
     * @param checkTransactionDto 排他制御確認情報
     * @return チェック結果
     * @throws DuplicateKeyException (排他制御管理テーブルなどにデータが入っていて)データが重複している
     */
    public boolean practice(final CheckTransactionDto checkTransactionDto)throws DuplicateKeyException { // NOPMD

        //TODO 仕様が決定次第修正する
        //Mockで外部から強制例外発生と判定結果falseを送信るようにする
        if(checkTransactionDto.getIsRaiseExcception()) {
            throw new DuplicateKeyException("Mock強制例外");
        }
        
        return checkTransactionDto.getIsResult();
    }


}
