CREATE TABLE `zz_address_postal` (
  `postalcode` varchar(15) COLLATE utf8mb4_bin NOT NULL,
  `address_name` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`postalcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
