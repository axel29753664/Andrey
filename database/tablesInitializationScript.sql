INSERT INTO users (FirstName, LastName, Login, Password) VALUES ('axel', 'foley', 'axel', 'axel');
INSERT INTO users (FirstName, LastName, Login, Password) VALUES ('Vasja', 'Pupkin', 'Vasja', 'Pupkin');
INSERT INTO users (FirstName, LastName, Login, Password) VALUES ('Anna', 'Vanna', 'Anna', 'Vanna');
INSERT INTO users (FirstName, LastName, Login, Password) VALUES ('login', 'password', 'login', 'password');


INSERT INTO main_events (MainEventName, MainEventAddTime, MainEventStartTime, MainEventEndTime, MainEventInfo)
            VALUES ('Arsenal - MU', 10, 20, 30, 'Text about Arsenal - MU');
INSERT INTO main_events (MainEventName, MainEventAddTime, MainEventStartTime, MainEventEndTime, MainEventInfo)
            VALUES ('Milan - Roma', 20, 30, 40, 'Text about Milan - Roma');
INSERT INTO main_events (MainEventName, MainEventAddTime, MainEventStartTime, MainEventEndTime, MainEventInfo)
            VALUES ('Real Madrid - Barcelona', 20, 30, 40, 'Text about Real Madrid - Barcelona');


INSERT INTO events (EventName) VALUES ('Arsenal - MU: 3 - 1');
INSERT INTO events (EventName) VALUES ('Arsenal - MU: 2 - 3');
INSERT INTO events (EventName) VALUES ('Arsenal - MU: 4 - 4');
INSERT INTO events (EventName) VALUES ('Milan - Roma: 0 - 1');
INSERT INTO events (EventName) VALUES ('Milan - Roma: 1 - 2');
INSERT INTO events (EventName) VALUES ('Real Madrid - Barcelona: 2 - 2');


INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 1, 10, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (2, 1, 20, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 1, 30, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 2, 40, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (1, 3, 50, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (2, 3, 60, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 4, 70, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (3, 4, 80, 0);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (4, 5, 90, 1);
INSERT INTO bets (UserID, EventID, Bet_Sum, Winning_Condition) VALUES (4, 6, 100, 0);


INSERT INTO accounts (AccountBalance) VALUES (10);
INSERT INTO accounts (AccountBalance) VALUES (50);
INSERT INTO accounts (AccountBalance) VALUES (100);
INSERT INTO accounts (AccountBalance) VALUES (0);


INSERT INTO userAccounts (AccountID, UserID) VALUES (1, 1);
INSERT INTO userAccounts (AccountID, UserID) VALUES (2, 2);
INSERT INTO userAccounts (AccountID, UserID) VALUES (3, 3);
INSERT INTO userAccounts (AccountID, UserID) VALUES (4, 4);

