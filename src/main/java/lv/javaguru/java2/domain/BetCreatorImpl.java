package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.UserDAOImpl;

import java.math.BigDecimal;

public class BetCreatorImpl implements BetCreator {

    public BetCreatorImpl() {
    }

    public void createBet(Long userId,
                          Long eventId,
                          BigDecimal betSum,
                          Boolean winningChoice) {

        checkUserId(userId);




    }

    private void checkUserId (Long userId) {
        if (userId <= 0) {
            throw new UserIllegalStateException("You must be login");
        }
        UserDAOImpl UserDAO = new UserDAOImpl();
        User user = UserDAO.getByLogin(userId);



    }








}
