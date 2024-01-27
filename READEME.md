# 政治資金収支報告書・作成側ソフトウェア

## 1.目的

政治資金収支報告書の作成

## 2.概念図

![概念図作成側](./docs/images/概念図作成側.drawio.png)

## 3.範囲

1. 政治資金収支報告書
a. 作成
b. XML形式提出

2. データ連携予定
a. 政党交付金使途報告書
b. 各店舗レシート読取り関連
c. 各金融機関(pay系含む)CSV経由データ取り込み
d. 各金融機関(pay系含む)API経由データ取り込み
e. 全銀フォーマットCSV入出金明細

## 4.開発環境

### 1. front側

1. Vue+Vite
a. vue/cli  5.0.8
b. vitejs/plugin-vue:4.5.2

### 2. back側

1. spring boot
2. spring batch

### 3. Database

1. MySQL

## 4.起動

### 1. front

viteを起動`npm run dev`

### 2. back

mvnから起動`mvn spring-boot:run`
