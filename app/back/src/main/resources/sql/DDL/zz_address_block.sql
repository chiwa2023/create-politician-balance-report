CREATE TABLE `zz_address_block` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `lg_code` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `machiaza_id` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `value` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `name_all` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `text` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116785 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
