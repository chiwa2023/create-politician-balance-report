# 各種金融機関(個人用銀行独自フォーマット／Pay系含む)CSVファイルから収支項目データ作成【表示画面】設計書

## 状態：手戻り大歓迎!の姿勢で実装中(二次実装完了)

## 1.目的

各種金融機関サイトからダウンロードしたcsvをもとに収支／収入データを作成し登録する

## 2. 構成コンポーネント

1. [csv読取り仕様コンポーネント](../../common/front/input_institution_csv/input_institution_csv.md)
2. 独自フィールド
3. [収支報告書入力コンポーネント](../../common/front/balancesheet_input/balancesheet_input.md)

### 2.1 繰り返し項目

なし

## 3. 画面イメージ

### 3.1 画面イメージ

![csvテンプレート編集](image/csvテンプレート編集.drawio.png)

### 3.2 画面イメージ(項番)

![csvテンプレート編集項番](image/csvテンプレート編集項番.drawio.png)

## 4. フィールド要素一覧

| 番号 |            論理名            |     タイプ     | 活性／表示 |                      内容                       |
| ---- | ---------------------------- | -------------- | ---------- | ----------------------------------------------- |
| 1    | csv読取り仕様コンポーネント  | コンポーネント | 表示       | csv読取り仕様コンポーネントが表示されていること |
| 1    | 収支報告書入力コンポーネント | コンポーネント | 表示       | 収支報告書コンポーネントが表示されていること    |

## 5.アクション一覧

| 番号 |   論理名   | タイプ | 活性／表示 |              内容              |
| ---- | ---------- | ------ | ---------- | ------------------------------ |
| 1    | キャンセル | ボタン | 活性       | 押下時：入力内容を破棄すること |
| 1    | 保存       | ボタン | 活性       | 下記参照                       |

## 5.1 保存処理

- 収入項目をbalancesheet_income_(提出年)に保存すること
- 支出項目をbalancesheet_outcome_(提出年)に保存すること
- 収支区分が`タスク計上`である場合、団体誰か一人向けタスクとしてタスク一覧テーブルにデータを挿入すること
- 収入・支出リストに含まれる項目で備考欄が`空文字でない`場合、または前例と異なる処理フラグが`true`である場合
    1.収入の場合はmeeting_adjust_income_(提出年)、支出の場合はmeeting_adjust_outcome_(提出年)データを登録すること
    2.代表者専用向けタスクを計上し、メールと指定SNSへ通知を行うこと

## 6. 収支報告書登録Interface

RegistBalancesheetInOutCapsuleInterface

 |     論理名     |   物理名    |                  型                  |    説明(例)    |
 | -------------- | ----------- | ------------------------------------ | -------------- |
 | 収入項目リスト | listIncome  | List\<BalancesheetIncomeInterface\>  | 収入項目リスト |
 | 支出項目リスト | listOutcome | List\<BalancesheetOutcomeInterface\> | 支出項目リスト |

各項目の詳細は[収支報告書入力コンポーネント](../../common/front/balancesheet_input/balancesheet_input.md)を参照のこと

## 7. 連携

csv読み取りコンポーネントからcsvデータと読み取り方法が送信された場合、`recieveSelectOptionsArrayInterface(listPointArray: string[], saveStorageResultDto: SaveStorageResultDto)`で受信すること
