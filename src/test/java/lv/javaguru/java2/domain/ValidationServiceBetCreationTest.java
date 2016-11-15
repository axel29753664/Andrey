package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.EventDAOImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningChoiceState.FOR;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceBetCreationTest {

    @InjectMocks
    private ValidationServiceBetCreation validationServiceBetCreation;

    //@Mock
    //private ValidateUserId validateUserId;
    //private ValidateEventId validateEventId;

    //@Before
    //public void init() {
    //    MockitoAnnotations.initMocks(this);
    //}

    /*
    @Test
    public void shouldReturnUser(){
        long userId = 123;
        long eventId = 50;
        BigDecimal betSum = new BigDecimal(10);
        BetWinningChoiceState winningChoice = FOR;

        ValidateUserId validateUserId = mock(ValidateUserId.class);
        ValidateEventId validateEventId = mock(ValidateEventId.class);

        validationServiceBetCreation.check(userId, eventId, betSum, winningChoice);
        verify(validateUserId, times(1)).check(userId);
    }
    */

}