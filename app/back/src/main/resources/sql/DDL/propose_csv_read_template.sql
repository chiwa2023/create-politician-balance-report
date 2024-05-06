CREATE TABLE `propose_csv_read_template` (
  `propose_csv_read_template_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'CSV読取り仕様Id',
  `propose_csv_read_template_code` int DEFAULT NULL COMMENT 'CSV読取り仕様同一識別コード',
  `propose_csv_read_template_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'CSV読取り仕様名称',
  `saishin_kbn` int DEFAULT NULL COMMENT '最新区分',
  `financial_org_kbn` int DEFAULT NULL COMMENT '金融機関区分',
  `financial_org_id` bigint DEFAULT NULL COMMENT '金融機関Id',
  `financial_org_code` int DEFAULT NULL COMMENT '金融機関同一識別コード',
  `financial_org_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '金融機関名称',
  `has_header` tinyint DEFAULT NULL,
  `array_number` int DEFAULT NULL COMMENT '配列桁数',
  `array_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '指定配列内容',
  `table_all_search_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT 'テーブル全文検索カラム',
  `login_user_id` bigint DEFAULT NULL COMMENT 'ログインユーザId',
  `login_user_code` int DEFAULT NULL COMMENT 'ログインユーザ同一識別コード',
  `login_user_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ログインユーザ名',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新時間',
  PRIMARY KEY (`propose_csv_read_template_id`),
  FULLTEXT KEY `table_all_search_text` (`table_all_search_text`) /*!50100 WITH PARSER `ngram` */ 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
