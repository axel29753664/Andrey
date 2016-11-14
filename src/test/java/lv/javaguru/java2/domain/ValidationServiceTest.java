package lv.javaguru.java2.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationServiceTest {
    private ValidationService validationService;

    @Before
    public void initialization() {
        validationService = new ValidationService();
    }

    @After
    public void clear() {
        validationService = null;
    }

    @Test
    public void checkUserId() throws Exception {

    }

    @Test
    public void checkEventId() throws Exception {

    }

    @Test
    public void checkBetSum() throws Exception {

    }

    @Test
    public void checkWinningChoiceState() throws Exception {

    }

}