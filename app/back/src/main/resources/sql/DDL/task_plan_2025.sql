CREATE TABLE `task_plan_2025` (
  `task_plan_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'タスク予定Id',
  `task_plan_code` bigint DEFAULT NULL COMMENT 'タスク予定同一識別コード',
  `task_plan_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'タスク予定名称',
  `saishin_kbn` int DEFAULT NULL COMMENT '最新区分',
  `political_organization_id` bigint DEFAULT NULL COMMENT '政治団体Id',
  `political_organization_code` int DEFAULT NULL COMMENT '政治団体同一識別コード',
  `political_organization_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '政治団体名称',
  `is_finished` tinyint(1) DEFAULT NULL COMMENT '作業終了フラグ',
  `is_notics_alert` tinyint(1) DEFAULT NULL COMMENT '通知フラグ',
  `is_delegate_for` tinyint(1) DEFAULT NULL COMMENT '代表者用タスクフラグ',
  `is_account_officer_for` tinyint(1) DEFAULT NULL COMMENT '会計責任者用タスクフラグ',
  `is_account_staff_for` tinyint(1) DEFAULT NULL COMMENT '事務担当者用タスクフラグ',
  `login_user_id` bigint DEFAULT NULL COMMENT 'ログインユーザId',
  `login_user_code` int DEFAULT NULL COMMENT 'ログインユーザ同一識別コード',
  `login_user_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ログインユーザ名',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新時間',
  PRIMARY KEY (`task_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
