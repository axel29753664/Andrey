CREATE TABLE `users` (
  `UserID`         BIGINT(20)     NOT NULL AUTO_INCREMENT,
  `FirstName`      VARCHAR(45)    NOT NULL,
  `LastName`       VARCHAR(45)    NOT NULL,
  `Login`          VARCHAR(45)    NOT NULL,
  `Password`       VARCHAR(20)    NOT NULL,
  `Admin`          TINYINT(1)     NOT NULL DEFAULT '0',
  `AccountBalance` DECIMAL(19, 4) NOT NULL DEFAULT '0.0000',
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Login_UNIQUE` (`Login`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `events` (
  `EventID`          BIGINT(20)                                NOT NULL AUTO_INCREMENT,
  `EventName`        VARCHAR(45)                               NOT NULL,
  `EventDescription` VARCHAR(255)                              NOT NULL,
  `WinningCondition` VARCHAR(255)                              NOT NULL,
  `LoseCondition`    VARCHAR(255)                              NOT NULL,
  `DrawCondition`    VARCHAR(255)                                       DEFAULT NULL,
  `EventStatus`      ENUM ('ACTIVE', 'NOT_ACTIVE', 'FINISHED') NOT NULL,
  `Winner`           ENUM ('FIRST', 'SECOND', 'DRAW'),
  `TotalBank`        DECIMAL(19, 4)                            NOT NULL DEFAULT '0',
  PRIMARY KEY (`EventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `bets` (
  `BetID`             BIGINT(20) AUTO_INCREMENT,
  `UserID`            BIGINT(20) NOT NULL,
  `EventID`           BIGINT(20) NOT NULL,
  `Bet_Sum`           DECIMAL    NOT NULL,
  `Winning_Condition` BOOLEAN    NOT NULL,
  PRIMARY KEY (`BetID`),
  FOREIGN KEY (`UserID`) REFERENCES users (`UserID`),
  FOREIGN KEY (`EventID`) REFERENCES events (`EventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


