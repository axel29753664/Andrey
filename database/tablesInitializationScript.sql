INSERT INTO totalizatordb.users (FirstName, LastName, Login, Password) VALUES ('Denis', 'A', 'DenisA', 'da');
INSERT INTO totalizatordb.users (FirstName, LastName, Login, Password) VALUES ('Andrey', 'B', 'AndreyB', 'ab');
INSERT INTO totalizatordb.users (FirstName, LastName, Login, Password) VALUES ('Anna', 'C', 'AnnaC', 'ac');
INSERT INTO totalizatordb.users (FirstName, LastName, Login, Password) VALUES ('Alexander', 'D', 'AlexanderD', 'ad');
INSERT INTO totalizatordb.users (FirstName, LastName, Login, Password) VALUES ('Olga', 'E', 'OlgaE', 'oe');

INSERT INTO totalizatordb.main_events (MainEventName, MainEventAddTime, MainEventStartTime, MainEventEndTime, MainEventInfo)
            VALUES ('Arsenal - MU', 10, 20, 30, 'Text about Arsenal - MU');
INSERT INTO totalizatordb.main_events (MainEventName, MainEventAddTime, MainEventStartTime, MainEventEndTime, MainEventInfo)
            VALUES ('Milan - Roma', 20, 30, 40, 'Text about Milan - Roma');
INSERT INTO totalizatordb.main_events (MainEventName, MainEventAddTime, MainEventStartTime, MainEventEndTime, MainEventInfo)
            VALUES ('Real Madrid - Barcelona', 20, 30, 40, 'Text about Real Madrid - Barcelona');

INSERT INTO totalizatordb.events (EventName) VALUES ('Arsenal - MU: 3 - 1');
INSERT INTO totalizatordb.events (EventName) VALUES ('Arsenal - MU: 2 - 3');
INSERT INTO totalizatordb.events (EventName) VALUES ('Arsenal - MU: 4 - 4');
INSERT INTO totalizatordb.events (EventName) VALUES ('Milan - Roma: 0 - 1');
INSERT INTO totalizatordb.events (EventName) VALUES ('Milan - Roma: 1 - 2');
INSERT INTO totalizatordb.events (EventName) VALUES ('Real Madrid - Barcelona: 2 - 2');

INSERT INTO totalizatordb.accounts (AccountBalance) VALUES (10);
INSERT INTO totalizatordb.accounts (AccountBalance) VALUES (50);
INSERT INTO totalizatordb.accounts (AccountBalance) VALUES (100);
INSERT INTO totalizatordb.accounts (AccountBalance) VALUES (200);
INSERT INTO totalizatordb.accounts (AccountBalance) VALUES (0);

INSERT INTO totalizatordb.userAccounts (AccountID, UserID) VALUES (1, 1);
INSERT INTO totalizatordb.userAccounts (AccountID, UserID) VALUES (2, 2);
INSERT INTO totalizatordb.userAccounts (AccountID, UserID) VALUES (3, 3);
INSERT INTO totalizatordb.userAccounts (AccountID, UserID) VALUES (4, 4);
INSERT INTO totalizatordb.userAccounts (AccountID, UserID) VALUES (5, 5);

INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 1, 10, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (2, 1, 20, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 1, 30, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 2, 40, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 3, 50, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (2, 3, 60, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 3, 70, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 4, 80, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (4, 4, 90, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (5, 5, 100, 0);