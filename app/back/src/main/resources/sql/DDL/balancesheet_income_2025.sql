CREATE TABLE `balancesheet_income_2025` (
  `balancesheet_income_id` bigint NOT NULL AUTO_INCREMENT COMMENT '政治資金収支報告書収入項目Id',
  `balancesheet_income_code` bigint DEFAULT NULL COMMENT '政治資金収支報告書収入項目同一識別コード',
  `saishin_kbn` int DEFAULT NULL COMMENT '最新区分',
  `political_organization_id` bigint DEFAULT NULL COMMENT '政治資金団体Id',
  `political_organization_code` int DEFAULT NULL COMMENT '政治資金団体同一識別コード',
  `political_organization_name` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '政治資金団体名称',
  `shoshou_id` text COLLATE utf8mb4_bin COMMENT '書証Id',
  `shoshou_history_code` bigint DEFAULT NULL COMMENT '書証識別コード',
  `shoshou_kbn` int DEFAULT NULL COMMENT '書証区分',
  `reading_line` int DEFAULT NULL COMMENT '書証読み取り行',
  `refer_digest` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参照した摘要',
  `amount` bigint DEFAULT NULL COMMENT '取引金額',
  `accrual_date` date DEFAULT NULL COMMENT '発生日',
  `is_edit_auto_input` tinyint(1) DEFAULT NULL COMMENT '自動入力編集の有無',
  `report_kbn` int DEFAULT NULL COMMENT '収支報告区分',
  `youshiki_kbn` int DEFAULT NULL COMMENT '様式仕訳区分',
  `youshiki_eda_kbn` int DEFAULT NULL COMMENT '様式仕訳枝項目区分',
  `item_name` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目名称',
  `item_id_kbn` int DEFAULT NULL COMMENT '項目名称Id区分',
  `general_item_id` bigint DEFAULT NULL COMMENT '一般項目名称Id',
  `general_item_code` int DEFAULT NULL COMMENT '一般名称同一識別コード',
  `continue_buissiness_id` bigint DEFAULT NULL COMMENT '継続事業Id',
  `continue_buissiness_code` int DEFAULT NULL COMMENT '継続事業同一識別コード',
  `relation_kbn` int DEFAULT NULL COMMENT '関連者区分',
  `relation_person_id` bigint DEFAULT NULL COMMENT '関連者個人Id',
  `relation_person_code` int DEFAULT NULL COMMENT '関連者個人同一識別コード',
  `relation_corporation_id` bigint DEFAULT NULL COMMENT '関連者法人Id',
  `relation_corporation_code` int DEFAULT NULL COMMENT '関連者法人同一識別コード',
  `relation_politics_organization_id` bigint DEFAULT NULL COMMENT '関連者政治団体Id',
  `relation_politics_organization_code` int DEFAULT NULL COMMENT '関連者政治団体同一識別コード',
  `orgnization_address` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '個人・団体住所',
  `profession_orgnization_name` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '団体代表者・職業',
  `mediation_start_date` date DEFAULT NULL COMMENT 'あっせん期間開始日',
  `mediation_end_date` date DEFAULT NULL COMMENT 'あっせん期間終了日',
  `party_date` date DEFAULT NULL COMMENT 'パーティ日付',
  `biko` text COLLATE utf8mb4_bin COMMENT '備考',
  `is_credit_tax` tinyint(1) DEFAULT NULL COMMENT '税額控除有無',
  `is_bequest` tinyint(1) DEFAULT NULL COMMENT '寄付が遺贈有無フラグ',
  `is_prime_listed_or_foreign` tinyint(1) DEFAULT NULL COMMENT '寄付法人が上場または外資50%超え会社有無フラグ',
  `party_name` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '政治資金パーティ名称',
  `note` text COLLATE utf8mb4_bin COMMENT '意見付記',
  `is_differ_precedent` tinyint(1) DEFAULT NULL COMMENT '前例と異なる処理フラグ',
  `storaged_document_id_list` text COLLATE utf8mb4_bin COMMENT '保全証票リスト',
  `insert_user_id` bigint DEFAULT NULL COMMENT '挿入ユーザId',
  `insert_user_code` int DEFAULT NULL COMMENT '挿入ユーザ同一識別コード',
  `insert_user_name` varchar(300) DEFAULT NULL COMMENT '挿入ユーザ姓名',
  `insert_timestamp` datetime NULL DEFAULT NULL COMMENT '挿入タイムスタンプ',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新ユーザId',
  `update_user_code` int DEFAULT NULL COMMENT '更新ユーザ同一識別コード',
  `update_user_name` varchar(300) DEFAULT NULL COMMENT '更新ユーザ姓名',
  `update_timestamp` datetime NULL DEFAULT NULL COMMENT '更新タイムスタンプ',
  PRIMARY KEY (`balancesheet_income_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
