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
  `EventID`          BIGINT(20)     NOT NULL            AUTO_INCREMENT,
  `EventName`        VARCHAR(45)    NOT NULL,
  `EventDescription` VARCHAR(255)                       DEFAULT NULL,
  `BetSide`          TINYINT(1)     NOT NULL            DEFAULT '0',
  `Winner`           ENUM ('WIN', 'LOSE', 'NOT_SET')    DEFAULT NULL,
  `Coefficient`      DOUBLE         NOT NULL            DEFAULT '1',
  `TotalBank`        DECIMAL(19, 4) NOT NULL            DEFAULT '0.0000',
  PRIMARY KEY (`EventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `bets` (
  `BetID`               BIGINT(20)                             AUTO_INCREMENT,
  `UserID`              BIGINT(20)                             NOT NULL,
  `EventID`             BIGINT(20)                             NOT NULL,
  `BetSum`              DECIMAL(19, 2)                         NOT NULL,
  `UncoveredBetSum`     DECIMAL(19, 2)                         NOT NULL,
  `BetCondition`        VARCHAR(20)                            NOT NULL,
  PRIMARY KEY (`BetID`),
  FOREIGN KEY (`UserID`) REFERENCES users (`UserID`),
  FOREIGN KEY (`EventID`) REFERENCES events (`EventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


