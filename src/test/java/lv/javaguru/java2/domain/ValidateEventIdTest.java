/*package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.EventDAOImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ValidateEventIdTest {

    @InjectMocks
    private ValidateEventId validateEventId;

    @Mock
    private EventDAOImpl eventDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnUser(){
        long eventId = 123;
        Event event = new Event();
        when(eventDao.getById(eventId)).thenReturn(event);
        validateEventId.check(eventId);
        verify(eventDao, times(1)).getById(eventId);
    }

    @Test (expected = ValidationIllegalStateException.class)
    public void shouldThrowExceptionDueUserNotExist() {
        long eventId = 123;
        Event event = null;
        when(eventDao.getById(eventId)).thenReturn(event);
        validateEventId.check(eventId);
        verify(eventDao, times(1)).getById(eventId);
    }

    @Test (expected = ValidationIllegalStateException.class)
    public void shouldThrowExceptionDueIncorrectUserId_Nr1() {
        long eventId = 0;
        validateEventId.check(eventId);
        fail();
    }

    @Test (expected = ValidationIllegalStateException.class)
    public void shouldThrowExceptionDueIncorrectUserId_Nr2() {
        long eventId = -10;
        validateEventId.check(eventId);
        fail();
    }

}*/