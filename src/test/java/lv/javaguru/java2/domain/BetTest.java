package lv.javaguru.java2.domain;

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
    public void clear() {
        bet = null;
    }

    @Test
    public void testSetCorrectBetId() {
        Long betId = null;
        long number = 1;
        betId = betId.valueOf(number);
        bet.setBetId(betId);
        assertEquals(bet.getBetId(), betId);
    }

    @Test
    public void testSetCorrectUserId() {
        Long userId = null;
        long number = 10;
        userId = userId.valueOf(number);
        bet.setUserId(userId);
        assertEquals(bet.getUserId(), userId);
    }

    @Test
    public void testSetCorrectEventId() {
        Long eventId = null;
        long number = 20;
        eventId = eventId.valueOf(number);
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
        Boolean winningChoice = true;
        bet.setWinningChoice(winningChoice);
        assertEquals(bet.getWinningChoice(), winningChoice);
    }

    @Test
    public void testSetFalseWinningChoice() {
        Boolean winningChoice = false;
        bet.setWinningChoice(winningChoice);
        assertEquals(bet.getWinningChoice(), winningChoice);
    }

}
