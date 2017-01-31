CREATE TABLE `users` (
  `UserID`         BIGINT(20)     NOT NULL AUTO_INCREMENT,
  `FirstName`      VARCHAR(45)    NOT NULL,
  `LastName`       VARCHAR(45)    NOT NULL,
  `Login`          VARCHAR(45)    NOT NULL,
  `Password`       VARCHAR(20)    NOT NULL,
  `AccountBalance` DECIMAL(19, 4) NOT NULL DEFAULT '0.0000',
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Login_UNIQUE` (`Login`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE `roles` (
  `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE `user_roles` (
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  UNIQUE KEY `user_id` (`user_id`, `role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`UserID`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
)
  ENGINE = InnoDB;


CREATE TABLE `events` (
  `EventID`                     BIGINT(20)                      NOT NULL                 AUTO_INCREMENT,
  `EventName`                   VARCHAR(45)                     NOT NULL,
  `EventDescription`            VARCHAR(255)                                             DEFAULT NULL,
  `WinningConditionDescription` VARCHAR(255)                    NOT NULL,
  `BetSide`                     ENUM ('WIN', 'LOSE', 'NOT_SET') NOT NULL                 DEFAULT 'LOSE',
  `Winner`                      ENUM ('WIN', 'LOSE', 'NOT_SET') NOT NULL                 DEFAULT 'NOT_SET',
  `Coefficient`                 DOUBLE                          NOT NULL                 DEFAULT '1',
  `TotalBank`                   DECIMAL(19, 4)                  NOT NULL                 DEFAULT '0.0000',
  PRIMARY KEY (`EventID`),
  UNIQUE KEY `EventName_UNIQUE` (`EventName`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE `bets` (
  `BetID`        BIGINT(20)           NOT NULL AUTO_INCREMENT,
  `UserID`       BIGINT(20)           NOT NULL,
  `Event_ID`     BIGINT(20)           NOT NULL,
  `BetSum`       DECIMAL(19, 2)       NOT NULL DEFAULT '0.00',
  `UncoveredSum` DECIMAL(19, 5)       NOT NULL DEFAULT '0.00000',
  `BetCondition` ENUM ('WIN', 'LOSE') NOT NULL,
  PRIMARY KEY (`BetID`),
  KEY `UserID` (`UserID`),
  KEY `bets_ibfk_2` (`Event_ID`),
  CONSTRAINT `bets_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`),
  CONSTRAINT `bets_ibfk_2` FOREIGN KEY (`Event_ID`) REFERENCES `events` (`EventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE `bank` (
  `Balance` DECIMAL(19, 2) NOT NULL DEFAULT '0'
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


