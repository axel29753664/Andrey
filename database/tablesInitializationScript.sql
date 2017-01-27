INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance) VALUES ('axel', 'foley', 'axel', 'axel', 32.5);
INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance)
VALUES ('Anna', 'Vanna', 'Anna', 'Vanna', 0.25);
INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance)
VALUES ('login', ' PASSWORD ', 'login', 'PASSWORD', 12.1);
INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance)
VALUES ('administrator', 'adm', 'admin', 'admin', 55.45);

INSERT INTO roles VALUES (1, 'ROLE_USER');

INSERT INTO roles VALUES (2, 'ROLE_ADMIN');


INSERT INTO user_roles VALUES (1, 1);
INSERT INTO user_roles VALUES (2, 1);
INSERT INTO user_roles VALUES (3, 1);
INSERT INTO user_roles VALUES (3, 2);
INSERT INTO user_roles VALUES (4, 2);

INSERT INTO events (EventName, EventDescription, WinningConditionDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('Arsenal - MU', 'Arsenal play vs MU', 'Arsenal wins', 'WIN', 'NOT_SET', 1.5, 235.4);
INSERT INTO events (EventName, EventDescription, WinningConditionDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('CSKA - MU', 'CSKA play vs MU', 'CSKA wins', 'LOSE', 'NOT_SET', 0.5, 35.4);
INSERT INTO events (EventName, EventDescription, WinningConditionDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('Spartak - Liverpool', 'Spartak play vs Liverpool', 'Spartak wins', 'NOT_SET', 'NOT_SET', 1.2, 135.4);
INSERT INTO events (EventName, EventDescription, WinningConditionDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('Arsenal - CSKA', 'Arsenal play vs CSKA', 'Arsenal wins', 'WIN', 'NOT_SET', 0.5, 35.4);


INSERT INTO bets (UserID, EventID, BetSum, UncoveredSum, BetCondition) VALUES (1, 1, 10, 10, 'LOSE');
INSERT INTO bets (UserID, EventID, BetSum, UncoveredSum, BetCondition) VALUES (2, 2, 20, 10, 'WIN');
INSERT INTO bets (UserID, EventID, BetSum, UncoveredSum, BetCondition) VALUES (3, 3, 30, 10, 'WIN');
INSERT INTO bets (UserID, EventID, BetSum, UncoveredSum, BetCondition) VALUES (4, 4, 40, 20, 'LOSE');