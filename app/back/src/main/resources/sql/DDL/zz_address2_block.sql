CREATE TABLE `zz_address2_block` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `value` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '選択肢の値(コード全結合)',
  `postal_code` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `all_address` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '全住所',
  `text` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '選択肢の表示(番地部分)',
  `choume` int DEFAULT NULL COMMENT '丁目の数字',
  `prc1` int DEFAULT NULL COMMENT 'ブロックの数字1',
  `prc2` int DEFAULT NULL COMMENT 'ブロックの数字2',
  `prc3` int DEFAULT NULL COMMENT 'ブロックの数字3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=195680 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
