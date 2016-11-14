package lv.javaguru.java2;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.jdbc.BetDAOImpl;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetCreator;
import lv.javaguru.java2.domain.BetCreatorImpl;
import lv.javaguru.java2.domain.BetWinningChoiceState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lv.javaguru.java2.domain.BetWinningChoiceState.AGAINST;
import static lv.javaguru.java2.domain.BetWinningChoiceState.FOR;
import static lv.javaguru.java2.domain.BetWinningChoiceState.NOT_APPLIED;

public class Main_Temp {
    public static void main (String[] args) {
        //createBet();
        //getByID();
        //deleteBet();
        //getByUserId();
        //getByEventId();
        //getByEventIdAndWinningChoice();
        //betCreatorTest();

        long a = 1;
        Long b = null;
        b = b.valueOf(a);
        System.out.println(b);

    }

    public static void createBet() {
        Scanner sc = new Scanner(System.in);
        BetDAO betDao = new BetDAOImpl();
        int mainEnd = 1;
        List<Bet> betList = new ArrayList();
        do {
            System.out.println("Enter userID");
            Long userId = sc.nextLong();
            System.out.println("Enter eventID");
            Long eventId = sc.nextLong();
            System.out.println("Enter BetSum");
            BigDecimal betSum = sc.nextBigDecimal();
            System.out.println("Enter WinningChoice");
            Boolean winningChoice;
            int winingChoiceInt = sc.nextInt();
            if (winingChoiceInt == 1) {
                winningChoice = true;
            } else {
                winningChoice = false;
            }
            Bet bet = new Bet(userId, eventId, betSum, winningChoice);
            betDao.create(bet);
            betList.add(bet);
            System.out.println("Continue? (0 - no, 1 - yes");
            mainEnd = sc.nextInt();
        } while (mainEnd != 0);
        for (Bet bet: betList) {
            System.out.println(bet);
        }
    }

    public static void getByID() {
        Scanner sc = new Scanner(System.in);
        BetDAO betDao = new BetDAOImpl();
        int mainEnd = 1;
        do {
            System.out.println("Enter betID to view");
            Long betId = sc.nextLong();
            Bet bet = betDao.getById(betId);
            System.out.println(bet);

            System.out.println("Continue? (0 - no, 1 - yes");
            mainEnd = sc.nextInt();

        } while (mainEnd != 0);
    }

    public static void deleteBet() {
        Scanner sc = new Scanner(System.in);
        BetDAO betDao = new BetDAOImpl();
        int mainEnd = 1;
        do {
            System.out.println("Enter betID to delete");
            long betId = sc.nextLong();
            betDao.deleteById(betId);
            System.out.println("Continue? (0 - no, 1 - yes");
            mainEnd = sc.nextInt();
        } while (mainEnd != 0);
    }

    public static void getByUserId() {
        Scanner sc = new Scanner(System.in);
        BetDAO betDao = new BetDAOImpl();
        int mainEnd = 1;
        do {
            System.out.println("Enter userID to view all bets");
            Long userId = sc.nextLong();
            List<Bet> betList = betDao.getByUserId(userId);
            for (Bet bet: betList) {
                System.out.println(bet);
            }
            System.out.println("Continue? (0 - no, 1 - yes");
            mainEnd = sc.nextInt();
        } while (mainEnd != 0);
    }

    public static void getByEventId() {
        Scanner sc = new Scanner(System.in);
        BetDAO betDao = new BetDAOImpl();
        int mainEnd = 1;
        do {
            System.out.println("Enter eventID to view all bets");
            Long eventId = sc.nextLong();
            List<Bet> betList = betDao.getByEventId(eventId);
            for (Bet bet: betList) {
                System.out.println(bet);
            }
            System.out.println("Continue? (0 - no, 1 - yes");
            mainEnd = sc.nextInt();
        } while (mainEnd != 0);
    }

    public static void getByEventIdAndWinningChoice() {
        Scanner sc = new Scanner(System.in);
        BetDAO betDao = new BetDAOImpl();
        int mainEnd = 1;
        do {
            System.out.println("Enter eventID");
            Long eventId = sc.nextLong();
            System.out.println("Enter Winning Choice (1 - true, 0 - false");
            int winingChoiceInt = sc.nextInt();
            Boolean winningChoice;
            if (winingChoiceInt == 1) {
                winningChoice = true;
            } else {
                winningChoice = false;
            }
            List<Bet> betList = betDao.getByEventIdAndWinningChoice(eventId, winningChoice);
            for (Bet bet: betList) {
                System.out.println(bet);
            }
            System.out.println("Continue? (0 - no, 1 - yes)");
            mainEnd = sc.nextInt();
        } while (mainEnd != 0);

    }

    public static void betCreatorTest() {
        Scanner sc = new Scanner(System.in);
        int mainEnd = 1;
        do {
            System.out.println("Enter userID");
            Long userId = sc.nextLong();
            System.out.println("Enter eventID");
            Long eventId = sc.nextLong();
            System.out.println("Enter BetSum");
            BigDecimal betSum = sc.nextBigDecimal();
            System.out.println("Enter WinningChoice");
            BetWinningChoiceState winningChoice;
            int winingChoiceInt = sc.nextInt();
            if (winingChoiceInt == 2) {
                winningChoice = AGAINST;
            } else {
                if (winingChoiceInt == 1) {
                    winningChoice = FOR;
                } else {
                    winningChoice = NOT_APPLIED;
                }
            }

            BetCreatorImpl betCreator = new BetCreatorImpl();
            betCreator.createBet(userId, eventId, betSum, winningChoice);

            System.out.println("Continue? (0 - no, 1 - yes)");
            mainEnd = sc.nextInt();

        } while (mainEnd != 0);



    }

}
