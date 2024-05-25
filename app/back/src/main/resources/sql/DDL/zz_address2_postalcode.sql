CREATE TABLE `zz_address2_postalcode` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `postalcode` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '郵便番号',
  `address_name` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '住所',
  `is_choume` bit(1) DEFAULT NULL,
  `is_prc1` bit(1) DEFAULT NULL,
  `is_prc2` bit(1) DEFAULT NULL,
  `is_prc3` bit(1) DEFAULT NULL,
  `name_plus` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '注釈部分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7479 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
