INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance) VALUES ('axel', 'foley', 'axel', 'axel', 32.5);
INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance)
VALUES ('Anna', 'Vanna', 'Anna', 'Vanna', 0.25);
INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance)
VALUES ('login', ' PASSWORD ', 'login', ' PASSWORD ', 12.1);
INSERT INTO users (FirstName, LastName, Login, Password, AccountBalance, Admin)
VALUES ('administrator', 'adm', 'admin', 'admin', 55.45, TRUE);


INSERT INTO events (EventName, EventDescription, WinningCondition, LoseCondition, DrawCondition, EventStatus, Winner, TotalBank)
VALUES ('Arsenal - MU', 'Arsenal play vs MU', 'Arsenal', 'MU', 'draw', 'FINISHED', 'FIRST', 235.43);
INSERT INTO events (EventName, EventDescription, WinningCondition, LoseCondition, DrawCondition, EventStatus, TotalBank)
VALUES ('CSKA - MU', 'CSKA play vs MU', 'CSKA', 'MU', 'draw', 'NOT_ACTIVE', 35.12);
INSERT INTO events (EventName, EventDescription, WinningCondition, LoseCondition, DrawCondition, EventStatus,  TotalBank)
VALUES ('Spartak - Liverpool', 'Spartak play vs Liverpool', 'Spartak', 'Liverpool', 'draw', 'ACTIVE',  123.43);
INSERT INTO events (EventName, EventDescription, WinningCondition, LoseCondition, DrawCondition, EventStatus, Winner, TotalBank)
VALUES ('Arsenal - CSKA', 'Arsenal play vs CSKA', 'Arsenal', 'CSKA', 'draw', 'FINISHED', 'SECOND', 135.43);


INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 1, 10, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (2, 1, 20, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 1, 30, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 2, 40, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 3, 50, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (2, 3, 60, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 4, 70, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 4, 80, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (4, 1, 90, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (4, 3, 100, 0);


