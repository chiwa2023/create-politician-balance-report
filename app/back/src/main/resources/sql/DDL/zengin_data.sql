CREATE TABLE `zengin_financial_org` (
  `zengin_financial_org_id` bigint NOT NULL AUTO_INCREMENT COMMENT '全銀金融機関Id',
  `zengin_financial_org_code` int DEFAULT NULL COMMENT '全銀金融機関同一識別コード',
  `zengin_financial_org_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '全銀金融機関名称',
  `saishin_kbn` int DEFAULT NULL COMMENT '最新区分',
  `table_all_search_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT 'テーブル全文検索カラム',
  `login_user_id` bigint DEFAULT NULL,
  `login_user_code` int DEFAULT NULL,
  `login_user_name` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ログインユーザ名',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新時間',
  PRIMARY KEY (`zengin_financial_org_id`),
  FULLTEXT KEY `table_all_search_text` (`table_all_search_text`) /*!50100 WITH PARSER `ngram` */ 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
