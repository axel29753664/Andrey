INSERT INTO totalizatordb.users (FirstName) VALUES ('Denis');
INSERT INTO totalizatordb.users (FirstName) VALUES ('Andrey');
INSERT INTO totalizatordb.users (FirstName) VALUES ('Anna');
INSERT INTO totalizatordb.users (FirstName) VALUES ('Alexander');
INSERT INTO totalizatordb.users (FirstName) VALUES ('Olga');

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

INSERT INTO totalizatordb.eventGroups (EventGroupName) VALUES ('Arsenal - MU');
INSERT INTO totalizatordb.eventGroups (EventGroupName) VALUES ('Milan - Roma');
INSERT INTO totalizatordb.eventGroups (EventGroupName) VALUES ('Real Madrid - Barcelona');

INSERT INTO totalizatordb.events (EventName) VALUES ('Arsenal - MU: 3 - 1');
INSERT INTO totalizatordb.events (EventName) VALUES ('Arsenal - MU: 2 - 3');
INSERT INTO totalizatordb.events (EventName) VALUES ('Arsenal - MU: 4 - 4');
INSERT INTO totalizatordb.events (EventName) VALUES ('Milan - Roma: 0 - 1');
INSERT INTO totalizatordb.events (EventName) VALUES ('Milan - Roma: 1 - 2');
INSERT INTO totalizatordb.events (EventName) VALUES ('Real Madrid - Barcelona: 2 - 2');

INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (1, 1, 10, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (2, 1, 20, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (3, 1, 30, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (1, 2, 40, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (1, 3, 50, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (2, 3, 60, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (3, 3, 70, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (3, 4, 80, 0);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (4, 4, 90, 1);
INSERT INTO totalizatordb.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (5, 5, 100, 0);