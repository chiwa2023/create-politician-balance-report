/**
 * Date日付をInput localdate形式に変換する
 *
 * @export
 * @param {Date} date 日付
 * @return {*}  {string} inputで扱える形式「yyyy-MM-dd hh:mm」に変換する
 */
export default function convertTimestampText(date: Date): string {
    let dayText = date.getFullYear() + "-" + plusZero(date.getMonth()) + "-" + plusZero(date.getDate());
    let timeText = date.getHours() + ":" + date.getMinutes();
    return dayText + " " + timeText;
}

/**
 * 前ゼロ処理が必要なので行う
 *
 * @param {number} data 月または日
 * @return {*}  {string} 一桁の時は前に「0」を付加する
 */
function plusZero(data: number): string {
    if (data < 10) {
        return "0" + data;
    }
    else {
        return String(data);
    }
}