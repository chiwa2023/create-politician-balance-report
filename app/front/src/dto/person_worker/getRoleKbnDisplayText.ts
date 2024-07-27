export default function getRoleKbnDisplayText(roleKbn: number, isDetail: boolean): string {

    //作業者または責任者二択の場合
    const MANEGER_TEXT: string = "責任者";
    const WORKER_TEXT: string = "作業者";
    if (!isDetail) {
        if (roleKbn < 20) {
            return MANEGER_TEXT;
        } else {
            return WORKER_TEXT;
        }
    }

    //役割詳細
    const DELEGATE_TEXT: string = "代表者";
    const ACCOUNT_MANGAER_TEXT: string = "会計責任者";
    const ACCOUNT_MANGAER_SUPORT_TEXT: string = "会計責任者職務代行者";

    switch (roleKbn) {
        //代表者
        case 1:
            return DELEGATE_TEXT;

        //会計責任者
        case 11:
            return ACCOUNT_MANGAER_TEXT;

        //会計責任者職務代行者
        case 12:
            return ACCOUNT_MANGAER_SUPORT_TEXT;

        //TODO 作業者部分実装

        default:
            return "";
    }

    return "";

}