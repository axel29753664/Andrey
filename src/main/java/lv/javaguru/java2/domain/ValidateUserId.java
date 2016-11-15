package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.UserDAOImpl;

public class ValidateUserId {
    UserDAOImpl userDao;

    public ValidateUserId() {
        userDao = new UserDAOImpl();
    }

    public void check(long userId) {
        if (userId <= 0) {
            throw new ValidationIllegalStateException("You must be login.");
        }
        User userExistence = userDao.getById(userId);
        if (userExistence == null) {
            throw new ValidationIllegalStateException("Account doesn't exist.");
        }
    }

}