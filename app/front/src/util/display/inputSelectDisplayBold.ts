/**
 * inputのチェックボックス、ラジオボックスのテキストを選択されたら強調する
 * @param isTrue 選択状態
 * @returns 強調するcssの値
 */
export default function inputSelectDisplayBold(isTrue:boolean):string{
    if(isTrue){
        return "input-selected-true-display";
    }else{
        return "";
    }
}