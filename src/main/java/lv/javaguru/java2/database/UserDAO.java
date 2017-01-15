package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;
import org.hibernate.JDBCException;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {

    User getByLogin(String login) throws JDBCException;

    void deleteByLogin(String login) throws JDBCException;

    void deleteAll() throws JDBCException;

}
