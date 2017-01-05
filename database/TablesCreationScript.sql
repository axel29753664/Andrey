-- -----------------------------------------------------
-- Table `TotalizatorDB`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `UserID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(32) NOT NULL,
  `LastName` VARCHAR(32) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  `Password` VARCHAR(45) NOT NULL,

PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

