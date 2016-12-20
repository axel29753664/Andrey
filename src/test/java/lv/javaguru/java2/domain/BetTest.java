/*package lv.javaguru.java2.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BetTest {
    private Bet bet;

    @Before
    public void initialization() {
        bet = new Bet();
    }

    @After
    public void clean() {
        bet = null;
    }

    @Test
    public void testSetCorrectBetId() {
        long betId = 1;
        bet.setBetId(betId);
        assertEquals(bet.getBetId(), betId);
    }

    @Test
    public void testSetCorrectUserId() {
        long userId = 10;
        bet.setUserId(userId);
        assertEquals(bet.getUserId(), userId);
    }

    @Test
    public void testSetCorrectEventId() {
        long eventId = 20;
        bet.setEventId(eventId);
        assertEquals(bet.getEventId(), eventId);
    }

    @Test
    public void testSetCorrectBetSum() {
        BigDecimal betSum = null;
        long number = 100;
        betSum = betSum.valueOf(number);
        bet.setBetSum(betSum);
        assertEquals(bet.getBetSum(), betSum);
    }

    @Test
    public void testSetTrueWinningChoice() {
        boolean winningChoice = true;
        bet.setWinningChoice(winningChoice);
        assertEquals(bet.getWinningChoice(), winningChoice);
    }

    @Test
    public void testSetFalseWinningChoice() {
        boolean winningChoice = false;
        bet.setWinningChoice(winningChoice);
        assertEquals(bet.getWinningChoice(), winningChoice);
    }

}
*/