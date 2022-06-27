CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `loginStateType` smallint(6) NOT NULL DEFAULT 0,
  `createDate` timestamp NULL DEFAULT current_timestamp(),
  `lastLoginDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `banType` smallint(6) DEFAULT NULL,
  `banReason` varchar(255) DEFAULT NULL,
  `tempBanTime` timestamp NULL DEFAULT NULL,
  `nxCash` int(11) NOT NULL DEFAULT 0,
  `donationPoints` int(11) NOT NULL DEFAULT 0,
  `votePoints` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
