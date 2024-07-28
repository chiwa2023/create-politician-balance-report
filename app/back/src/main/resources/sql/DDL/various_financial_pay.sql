CREATE TABLE `various_financial_pay` (
  `various_financial_pay_id` bigint NOT NULL AUTO_INCREMENT COMMENT '各種PayId',
  `various_financial_pay_code` int DEFAULT NULL COMMENT '各種Pay同一識別コード',
  `various_financial_pay_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '各種Pay名称',
  `saishin_kbn` int DEFAULT NULL COMMENT '最新区分',
  `table_all_search_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT 'テーブル全文検索カラム',
  `insert_user_id` bigint DEFAULT NULL COMMENT '挿入ユーザId',
  `insert_user_code` int DEFAULT NULL COMMENT '挿入ユーザ同一識別コード',
  `insert_user_name` varchar(300) DEFAULT NULL COMMENT '挿入ユーザ姓名',
  `insert_timestamp` timestamp NULL DEFAULT NULL COMMENT '挿入タイムスタンプ',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新ユーザId',
  `update_user_code` int DEFAULT NULL COMMENT '更新ユーザ同一識別コード',
  `update_user_name` varchar(300) DEFAULT NULL COMMENT '更新ユーザ姓名',
  `update_timestamp` timestamp NULL DEFAULT NULL COMMENT '更新タイムスタンプ',
  PRIMARY KEY (`various_financial_pay_id`),
  FULLTEXT KEY `table_all_search_text` (`table_all_search_text`) /*!50100 WITH PARSER `ngram` */ 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
