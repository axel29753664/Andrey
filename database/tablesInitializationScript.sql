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

INSERT INTO events (EventName, EventDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('Arsenal - MU', 'Arsenal play vs MU', FALSE, 'WIN', 1.5, 235.4);
INSERT INTO events (EventName, EventDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('CSKA - MU', 'CSKA play vs MU', TRUE, 'NOT_SET', 0.5, 35.4);
INSERT INTO events (EventName, EventDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('Spartak - Liverpool', 'Spartak play vs Liverpool', TRUE, 'NOT_SET', 1.2, 135.4);
INSERT INTO events (EventName, EventDescription, BetSide, Winner, Coefficient, TotalBank)
VALUES ('Arsenal - CSKA', 'Arsenal play vs CSKA', FALSE, 'LOSE', 0.5, 35.4);


INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (1, 1, 10, 'WIN');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (2, 1, 20, 'WIN');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (3, 1, 30, 'LOSE');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (1, 2, 40, 'DRAW');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (1, 3, 50, 'WIN');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (2, 3, 60, 'LOSE');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (3, 4, 70, 'DRAW');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (3, 4, 80, 'LOSE');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (4, 1, 90, 'WIN');
INSERT INTO bets (UserID, EventID, BetSum, BetCondition) VALUES (4, 3, 100, 'DRAW');