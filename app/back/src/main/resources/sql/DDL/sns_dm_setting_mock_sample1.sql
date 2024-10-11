CREATE TABLE `sns_dm_setting_mock_sample1` (
  `mock_sample1_id` bigint NOT NULL AUTO_INCREMENT COMMENT '項目名称取得Id',
  `mock_sample1_code` int DEFAULT NULL COMMENT '項目名称取得同一識別コード',
  `saishin_kbn` int DEFAULT NULL COMMENT '最新区分',
  `login_user_id` bigint DEFAULT NULL COMMENT 'ログインユーザId',
  `login_user_code` int DEFAULT NULL COMMENT 'ログインユーザ同一識別コード',
  `login_user_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ログインユーザ名称',
  `account_id` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'アカウントId',
  `passcode` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '接続パスコード',
  `insert_user_id` bigint DEFAULT NULL COMMENT '挿入ユーザId',
  `insert_user_code` int DEFAULT NULL COMMENT '挿入ユーザ同一識別コード',
  `insert_user_name` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '挿入ユーザ姓名',
  `insert_timestamp` datetime DEFAULT NULL COMMENT '挿入タイムスタンプ',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新ユーザId',
  `update_user_code` int DEFAULT NULL COMMENT '更新ユーザ同一識別コード',
  `update_user_name` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新ユーザ姓名',
  `update_timestamp` datetime DEFAULT NULL COMMENT '更新タイムスタンプ',
  PRIMARY KEY (`mock_sample1_id`)
) ENGINE=InnoDB AUTO_INCREMENT=840 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
