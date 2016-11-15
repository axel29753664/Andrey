package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import org.junit.After;
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
    //private User user;

    /*@Before
    public void initialization() {
        ValidateUserId validateUserId = new ValidateUserId();
        userDao = mock(UserDAOImpl.class);
        user = mock(User.class);
    }

    @After
    public void clean() {
        validateUserId = null;
        userDao = null;
        user = null;
    }
*/

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldReturnUser(){
        User user = new User();
        long userId = 123;
        when(userDao.getById(userId)).thenReturn(user);
        validateUserId.check(userId);
        verify(userDao, times(1)).getById(userId);
        //doThrow(new ValidationIllegalStateException("Account doesn't exist.")).when(validateUserId).check(userId);
    }

    @Test (expected = ValidationIllegalStateException.class)
    public void shouldThrowExceptionDueIncorrectUserId() throws ValidationIllegalStateException {
        User user = new User();
        long userId = 0;
        when(userDao.getById(userId)).thenReturn(user);
        validateUserId.check(userId);
        fail();
    }












}