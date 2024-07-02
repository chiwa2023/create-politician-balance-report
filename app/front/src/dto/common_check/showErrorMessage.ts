import { AxiosError } from "axios";
import TemplateFrameworkResultDto from "../template/templateFrameworkResultDto";

/** 
 * サーバステータスに合わせたメッセージを表示する
 * @param status サーバステータス
 */
export default function showErrorMessage(error: any) {

    //TODO 例外表示方法の使用が決定したら修正する
    //特に現在はわかりやすいようにstatus表示もしている部分

    if (error instanceof AxiosError) {
        if (error.response !== undefined) {

            //権限不足 HttpStatus.FORBIDDEN=403
            const FORBIDDEN = 403;

            //セキュリティ事故 HttpStatus.BAD_GATEWAY=502
            const BAD_GATEWAY = 502;

            //排他の対象HttpStatus.CONFLICT=409
            const CONFLICT = 409;

            //実装上の問題無含めた内部エラー
            const INTERNAL_ERROR = 500;

            const status = error.response.status;

            let isShowMessage: boolean = false

            switch (status) {
                //権限不足
                case FORBIDDEN:
                    isShowMessage = false
                    if (error.response.data !== undefined) {
                        if (error.response.data instanceof TemplateFrameworkResultDto) {
                            //メッセージを入れる選択をしている場合はメッセージを表示する
                            const resultDto: TemplateFrameworkResultDto = error.response.data;
                            alert(resultDto.message);
                            isShowMessage = true;
                        }
                    }
                    //独自メッセージを出していない場合は一般的なメッセージを出す
                    if (!isShowMessage) {
                        alert("利用権限がありません。あなたの団体の事務担当責任者またはシステム運営者にお問い合わせください" + status);
                    }
                    break;
                //排他制御
                case CONFLICT:
                    isShowMessage = false
                    if (error.response.data !== undefined) {
                        if (error.response.data instanceof TemplateFrameworkResultDto) {
                            //メッセージを入れる選択をしている場合はメッセージを表示する
                            const resultDto: TemplateFrameworkResultDto = error.response.data;
                            alert(resultDto.message);
                            isShowMessage = true;
                        }
                    }
                    //独自メッセージを出していない場合は一般的なメッセージを出す
                    if (!isShowMessage) {
                        alert("ほかのユーザさんが同じデータを編集しようとしています。編集完了までお待ちください");
                    }
                    break;
                //セキュリティ事故
                case BAD_GATEWAY:
                    isShowMessage = false
                    if (error.response.data !== undefined) {
                        if (error.response.data instanceof TemplateFrameworkResultDto) {
                            //メッセージを入れる選択をしている場合はメッセージを表示する
                            const resultDto: TemplateFrameworkResultDto = error.response.data;
                            alert(resultDto.message);
                            isShowMessage = true;
                        }
                    }
                    //独自メッセージを出していない場合は一般的なメッセージを出す
                    if (!isShowMessage) {
                        alert("システム運営者にお問い合わせください。セキュリティ上の問題が発生していると思われます");
                    }
                    break;
                //内部エラー
                case INTERNAL_ERROR:
                    isShowMessage = false
                    if (error.response.data !== undefined) {
                        if (error.response.data instanceof TemplateFrameworkResultDto) {
                            //メッセージを入れる選択をしている場合はメッセージを表示する
                            const resultDto: TemplateFrameworkResultDto = error.response.data;
                            alert(resultDto.message);
                            isShowMessage = true;
                        }
                    }
                    //独自メッセージを出していない場合は一般的なメッセージを出す
                    if (!isShowMessage) {
                        alert("予測できない例外が発生しています。システム運営者にお問い合わせください" + status);
                    }
                    break;
                //その他
                default:
                    isShowMessage = false
                    if (error.response.data !== undefined) {
                        if (error.response.data instanceof TemplateFrameworkResultDto) {
                            //メッセージを入れる選択をしている場合はメッセージを表示する
                            const resultDto: TemplateFrameworkResultDto = error.response.data;
                            alert(resultDto.message);
                            isShowMessage = true;
                        }
                    }
                    //独自メッセージを出していない場合は一般的なメッセージを出す
                    if (!isShowMessage) {
                        alert("予測できない例外が発生しています。システム運営者にお問い合わせください" + status);
                    }
                    break;
            }

        } else {
            alert("ネットワークで技術上例外が発生しています。システム運営者にお問い合わせください");
        }
    }

}

