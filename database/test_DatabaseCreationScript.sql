SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `TotalizatorDB` DEFAULT CHARACTER SET utf8 ;
USE `TotalizatorDB` ;

-- -----------------------------------------------------
-- Table `TotalizatorDB`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;
DROP TABLE IF EXISTS `main_events` ;
DROP TABLE IF EXISTS `events` ;
DROP TABLE IF EXISTS `bets` ;
DROP TABLE IF EXISTS `accounts` ;
DROP TABLE IF EXISTS `userAccounts` ;
DROP TABLE IF EXISTS `transactions` ;


CREATE TABLE IF NOT EXISTS `users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  `Password` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`UserID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `main_events` (
  `MainEventID` INT(11) NOT NULL AUTO_INCREMENT,
  `MainEventAddTime` INT(11) NOT NULL,
  `MainEventStartTime` INT(11) NOT NULL,
  `MainEventEndTime` INT(11) NOT NULL,
  `MainEventInfo` TEXT(1000) NOT NULL,
  PRIMARY KEY (`MainEventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `events` (
  `EventID` INT(11) NOT NULL AUTO_INCREMENT,
  `EventName` CHAR(32) NOT NULL,
  PRIMARY KEY (`EventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `accounts` (
  `AccountID` INT(11) NOT NULL AUTO_INCREMENT,
  `AccountBalance` BIGINT NOT NULL,
  PRIMARY KEY (`AccountID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `userAccounts` (
  `UserAccountID` INT(11) NOT NULL AUTO_INCREMENT,
  `AccountID` INT(11) NOT NULL,
  `UserID` INT(11) NOT NULL,
  PRIMARY KEY (`UserAccountID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `transactions` (
  `TransactionID` INT(11) NOT NULL AUTO_INCREMENT,
  `TransactionTime` TIMESTAMP NOT NULL,
  `TransactionAmmount` BIGINT NOT NULL,
  `AccountID`INT(11),
  PRIMARY KEY (`TransactionID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

-- My table - Bets:

CREATE TABLE IF NOT EXISTS `bets` (
  BetID INT(11) AUTO_INCREMENT,
  UserID INT(11) NOT NULL,
  EventID INT(11) NOT NULL,
  Bet_Sum BIGINT UNSIGNED NOT NULL,
  Winning_Choice BOOLEAN NOT NULL,
  PRIMARY KEY(BetID),
  FOREIGN KEY(UserID) REFERENCES users(UserID),
  FOREIGN KEY(EventID) REFERENCES events(EventID)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;