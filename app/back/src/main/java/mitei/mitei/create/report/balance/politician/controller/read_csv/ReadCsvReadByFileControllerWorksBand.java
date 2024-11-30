package mitei.mitei.create.report.balance.politician.controller.read_csv;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.exceptions.CsvException;

import mitei.mitei.create.report.balance.politician.dto.read_csv.ReadCsvByFileCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.read_csv.SendCsvAndStragedShoshouDto;
import mitei.mitei.create.report.balance.politician.service.read_csv.ReadCsvReadByFileService;
import mitei.mitei.create.report.balance.politician.service.save_shoshou.SaveShoshouStrageService;

/**
 * ビジネスロジックをまとめるWorksBandController(Transaction用)
 */
@Component
public class ReadCsvReadByFileControllerWorksBand {

    /** csv変換Service */
    @Autowired
    private ReadCsvReadByFileService readCsvReadByFileService;

    /** 書証保存Service */
    @Autowired
    private SaveShoshouStrageService saveShoshouStrageService;

    /**
     * 保存処理を行う
     *
     * @param readCsvByFileCapsuleDto CSV読み取りカプセルDto
     * @return 各種Payエンティティリスト
     * @throws CsvException ｃｓｖ読み取り例外
     * @throws IOException ファイル読み取り例外
     */
    @Transactional
    public SendCsvAndStragedShoshouDto wakeBusiness(final ReadCsvByFileCapsuleDto readCsvByFileCapsuleDto)
            throws CsvException, IOException {

        SendCsvAndStragedShoshouDto csvDto = new SendCsvAndStragedShoshouDto();

        csvDto.setListAllCsv(readCsvReadByFileService.practice(readCsvByFileCapsuleDto.getFileContent()));

        csvDto.setSaveStorageResultDto(saveShoshouStrageService.practice(readCsvByFileCapsuleDto.getFileName(),
                readCsvByFileCapsuleDto.getCheckPrivilegeDto().getLoginUserId()));

        return csvDto;
    }
}
