package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ValidateUserIdTest {
    private ValidateUserId validateUserId;
    private UserDAOImpl userDao;
    private User user;

    @Before
    public void initialization() {
        validateUserId = new ValidateUserId();
        userDao = mock(UserDAOImpl.class);
        user = mock(User.class);
    }

    @After
    public void clean() {
        validateUserId = null;
        userDao = null;
        user = null;
    }

    /*@Test
    public void shouldReturnUser(){
        long userId = 123;
        when(userDao.getById(userId)).thenReturn(user);
        validateUserId.check(userId);
        verify(userDao, times(1)).getById(userId);
    }*/













}