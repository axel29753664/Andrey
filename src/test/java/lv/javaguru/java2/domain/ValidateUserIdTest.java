/*package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.UserDAOImpl;
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
public class ValidateUserIdTest {

    @InjectMocks
    private ValidateUserId validateUserId;

    @Mock
    private UserDAOImpl userDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnUser(){
        long userId = 123;
        User user = new User();
        when(userDao.getById(userId)).thenReturn(user);
        validateUserId.check(userId);
        verify(userDao, times(1)).getById(userId);
    }

    @Test (expected = ValidationIllegalStateException.class)
    public void shouldThrowExceptionDueUserNotExist() {
        long userId = 123;
        User user = null;
        when(userDao.getById(userId)).thenReturn(user);
        validateUserId.check(userId);
        fail();
    }

    @Test (expected = ValidationIllegalStateException.class)
    public void shouldThrowExceptionDueIncorrectUserId_Nr1() {
        long userId = 0;
        validateUserId.check(userId);
        fail();
    }

    @Test (expected = ValidationIllegalStateException.class)
    public void shouldThrowExceptionDueIncorrectUserId_Nr2() {
        long userId = -10;
        validateUserId.check(userId);
        fail();
    }

}*/