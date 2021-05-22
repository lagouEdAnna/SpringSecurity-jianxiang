DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment`
(
  id              BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  create_time      TIMESTAMP NOT NULL,
  doctor_id   BIGINT(20) NOT NULL,
  card_id   BIGINT(20) NOT NULL,
  remark varchar(255) DEFAULT NULL
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
