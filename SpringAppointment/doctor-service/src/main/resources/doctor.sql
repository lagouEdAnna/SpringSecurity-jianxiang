DROP TABLE IF EXISTS `doctor`;

CREATE TABLE `doctor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `doctor_code` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `doctor` VALUES ('1', 'doctorCode1', 'doctorName1');
INSERT INTO `doctor` VALUES ('2', 'doctorCode2', 'doctorName2');