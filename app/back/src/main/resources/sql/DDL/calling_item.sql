CREATE TABLE `calling_item` (
  `calling_item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '項目名称取得Id',
  `calling_item_code` int DEFAULT NULL COMMENT '項目名称取得同一識別コード',
  `calling_item_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目名称取得名称',
  `saishin_kbn` int DEFAULT NULL COMMENT '最新区分',
  `user_organization_id` bigint DEFAULT NULL COMMENT 'ユーザ団体Id',
  `user_organization_code` int DEFAULT NULL COMMENT 'ユーザ団体同一識別コード',
  `user_organization_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ユーザ団体名称',
  `calling_refer_digest` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件摘要',
  `calling_item_various_financial_pay_id` bigint DEFAULT NULL COMMENT '項目呼び出し条件各種PayId',
  `calling_item_various_financial_pay_code` int DEFAULT NULL COMMENT '項目呼び出し条件各種Payコード',
  `calling_item_various_financial_pay_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件各種Pay名称',
  `calling_item_zengin_financial_org_code` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件全銀金融機関コード',
  `calling_item_zengin_financial_org_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件全銀金融機関名称',
  `calling_item_zengin_branch_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件支店コード',
  `calling_item_zengin_branch_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件支店名称',
  `calling_item_account_type` int DEFAULT NULL COMMENT '項目呼び出し条件口座種別区分',
  `calling_item_account_no` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件口座番号',
  `calling_item_account_has` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件口座名義人',
  `calling_item_tel1` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件電話番号・市外局番',
  `calling_item_tel2` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件電話番号・局番',
  `calling_item_tel3` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件電話番号・番号',
  `calling_item_postal1` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件郵便番号・前',
  `calling_item_postal2` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件郵便番号・後',
  `calling_item_address_post` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件住所',
  `calling_item_address_block` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件住所番地',
  `calling_item_address_buiding` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '項目呼び出し条件住所建物',
  `youshiki_kbn` int DEFAULT NULL,
  `youshiki_eda_kbn` int DEFAULT NULL,
  `publish_item_kbn` int DEFAULT NULL COMMENT '報告書記載名称区分',
  `publish_item_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '報告書記載名称',
  `publish_orgnization_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '報告書記載住所',
  `publish_profession_orgnization_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '報告書記載職業または代表者氏名',
  `general_item_id` bigint DEFAULT NULL,
  `general_item_code` int DEFAULT NULL COMMENT '一般項目同一識別コード',
  `continue_buissiness_id` bigint DEFAULT NULL,
  `continue_buissiness_code` int DEFAULT NULL COMMENT '継続事業同一識別コード',
  `relation_kbn` int DEFAULT NULL COMMENT '関連者区分',
  `relation_person_id` bigint DEFAULT NULL,
  `relation_person_code` int DEFAULT NULL COMMENT '関連者個人同一識別コード',
  `relation_corporation_id` bigint DEFAULT NULL,
  `relation_corporation_code` int DEFAULT NULL COMMENT '関連者法人同一識別コード',
  `relation_politics_organization_id` bigint DEFAULT NULL,
  `relation_politics_organization_code` int DEFAULT NULL COMMENT '関連者政治団体同一識別コード',
  `insert_user_id` bigint DEFAULT NULL COMMENT '挿入ユーザId',
  `insert_user_code` int DEFAULT NULL COMMENT '挿入ユーザ同一識別コード',
  `insert_user_name` varchar(300) DEFAULT NULL COMMENT '挿入ユーザ姓名',
  `insert_timestamp` timestamp NULL DEFAULT NULL COMMENT '挿入タイムスタンプ',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新ユーザId',
  `update_user_code` int DEFAULT NULL COMMENT '更新ユーザ同一識別コード',
  `update_user_name` varchar(300) DEFAULT NULL COMMENT '更新ユーザ姓名',
  `update_timestamp` timestamp NULL DEFAULT NULL COMMENT '更新タイムスタンプ',
  PRIMARY KEY (`calling_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
