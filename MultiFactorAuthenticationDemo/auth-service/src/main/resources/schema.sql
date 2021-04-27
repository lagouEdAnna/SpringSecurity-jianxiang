    
CREATE TABLE IF NOT EXISTS `spring_security_demo`.`user` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NULL,
    `password` TEXT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `spring_security_demo`.`auth_code` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `code` VARCHAR(45) NULL,
    PRIMARY KEY (`id`));
