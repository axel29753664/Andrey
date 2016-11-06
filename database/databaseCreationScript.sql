SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8 ;
USE `java2` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `transactions` ;

-- creating Accounts table

DROP TABLE IF EXISTS `accounts` ;

CREATE TABLE IF NOT EXISTS `accounts` (
  `AccountID` INT(11) NOT NULL AUTO_INCREMENT,
  `AccountBalance` BIGINT NOT NULL,
  PRIMARY KEY (`AccountID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

-- creating Transactions table

CREATE TABLE IF NOT EXISTS `transactions` (
  `TransactionID` INT(11) NOT NULL AUTO_INCREMENT,
  `TransactionTime` CHAR(32) NOT NULL,
  `TransactionAmmount` BIGINT NOT NULL,
  `AccountID`INT(11),
  PRIMARY KEY (`TransactionID`)

)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;