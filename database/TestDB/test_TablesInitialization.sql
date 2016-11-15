INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (1, 1, 10, 1);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (2, 1, 20, 1);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (3, 1, 30, 0);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (1, 2, 40, 0);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (1, 3, 50, 1);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (2, 3, 60, 0);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (3, 3, 70, 1);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (3, 4, 80, 0);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (4, 4, 90, 1);
INSERT INTO java2_test.bets (UserID, EventID, Bet_Sum, Winning_Choice) VALUES (5, 5, 100, 0);

INSERT INTO java2_test.users (FirstName) VALUES ('Denis');
INSERT INTO java2_test.users (FirstName) VALUES ('Andrey');
INSERT INTO java2_test.users (FirstName) VALUES ('Anna');
INSERT INTO java2_test.users (FirstName) VALUES ('Alexander');
INSERT INTO java2_test.users (FirstName) VALUES ('Olga');

INSERT INTO java2_test.accounts (AccountBalance) VALUES (10);
INSERT INTO java2_test.accounts (AccountBalance) VALUES (50);
INSERT INTO java2_test.accounts (AccountBalance) VALUES (100);
INSERT INTO java2_test.accounts (AccountBalance) VALUES (200);
INSERT INTO java2_test.accounts (AccountBalance) VALUES (0);

INSERT INTO java2_test.userAccounts (AccountID, UserID) VALUES (1, 1);
INSERT INTO java2_test.userAccounts (AccountID, UserID) VALUES (2, 2);
INSERT INTO java2_test.userAccounts (AccountID, UserID) VALUES (3, 3);
INSERT INTO java2_test.userAccounts (AccountID, UserID) VALUES (4, 4);
INSERT INTO java2_test.userAccounts (AccountID, UserID) VALUES (5, 5);

INSERT INTO java2_test.eventGroups (EventGroupName) VALUES ('Arsenal - MU');
INSERT INTO java2_test.eventGroups (EventGroupName) VALUES ('Milan - Roma');
INSERT INTO java2_test.eventGroups (EventGroupName) VALUES ('Real Madrid - Barcelona');

INSERT INTO java2_test.events (EventName) VALUES ('Arsenal - MU: 3 - 1');
INSERT INTO java2_test.events (EventName) VALUES ('Arsenal - MU: 2 - 3');
INSERT INTO java2_test.events (EventName) VALUES ('Arsenal - MU: 4 - 4');
INSERT INTO java2_test.events (EventName) VALUES ('Milan - Roma: 0 - 1');
INSERT INTO java2_test.events (EventName) VALUES ('Milan - Roma: 1 - 2');
INSERT INTO java2_test.events (EventName) VALUES ('Real Madrid - Barcelona: 2 - 2');

