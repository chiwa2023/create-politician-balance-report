package mitei.mitei.create.report.balance.politician.service.save_shoshou;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.storage.SaveStorageResultDto;
import mitei.mitei.create.report.balance.politician.util.MakeStorageOncePathUtil;

/**
 * 書証をサーバのストレージ領域に保存するServuce
 */
@Service
public class SaveShoshouStrageService {

    /** 保存場所 */
    private static final String STORAGED_PATH = "c:/temp/";

    /**
     * 書証を保存し、その結果を返却する
     *
     * @param fileName ファイル名
     * @param loginUserId 処理ユーザId
     * @return 保存結果
     * @throws IOException ファイルが作成できなかった場合
     */
    public SaveStorageResultDto practice(final String fileName,final Long loginUserId)throws IOException {
        //TODO 書証をストレージ保存は仕様が決定次第修正する
        
        //保存するたびに異なるディレクトリ
        Path pathOnce = MakeStorageOncePathUtil.practice(loginUserId, LocalDateTime.now());
        
        Path pathDir = Paths.get(STORAGED_PATH,pathOnce.toString());
        Path pathFile = Paths.get(pathDir.toString(),fileName);
        
        //保存ファイルのディレクトリで出来ていないか所はすべて作成
        //Files.createDirectories(pathDir);
        //TODO ファイルすべてを保存
        
        //TODO 保存出来たらデータベースに記録を残す
        
        //データベースに記録を残せたら結果を返却
        SaveStorageResultDto storageResultDto = new SaveStorageResultDto();
        //TODO 仕様が決定次第修正する
        String pathtext =pathOnce.toString();
        storageResultDto.setShoshouId(pathtext.replaceAll("\\\\\\\\\\\\", "/"));
        storageResultDto.setShoshouCode(1009L); // CHECKSTYLE:OFF
        
        return storageResultDto;
        
    }
}
