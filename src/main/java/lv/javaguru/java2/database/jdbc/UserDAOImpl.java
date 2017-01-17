package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.GenericHibernateDAOImpl;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.h2.engine.Session;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class UserDAOImpl extends GenericHibernateDAOImpl<User> implements UserDAO {
    private final String TABLE_NAME = "users";

    @Override
    @Transactional
    public List<User> getAll() throws JDBCException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        Set<User> userSet = new HashSet<>();
        userSet.addAll(criteria.list());                                                    //ПЕРЕДЕЛАТЬ
        List<User> userList = new ArrayList<>();
        userList.addAll(userSet);

        return userList;
    }

    @Override
    @Transactional
    public User getByLogin(String login) throws JDBCException {
        User user = null;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("login", login));
        if (criteria.list().size() > 0) {
            user = (User) criteria.list().get(0);
        }
        return user;
    }


    @Override
    @Transactional
    public void deleteByLogin(String login) throws JDBCException {
        String hql = "DELETE FROM " + TABLE_NAME + " WHERE Login= :login";
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql);
        query.setString("login", login);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAll() throws JDBCException {
        String hql = "DELETE FROM " + TABLE_NAME;
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql);
        query.executeUpdate();
    }


    //       public void create(User user) throws DBException {
//       if (user == null) {
//            return;
//        }
//
//        Connection connection = null;
//
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("INSERT INTO " + DBName + " VALUES (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());
//            preparedStatement.setString(3, user.getLogin());
//            preparedStatement.setString(4, user.getPassword());
//            preparedStatement.executeUpdate();
//            ResultSet rs = preparedStatement.getGeneratedKeys();
//            if (rs.next()) {
//                user.setUserId(rs.getLong(1));
//            }
//        } catch (Throwable e) {
//            System.out.println("exception while execute UserDAOImpl.create()");
//            e.printStackTrace();
//            throw new DBException(e);
//        } finally {
//            closeConnection(connection);
//        }
//
//    }
//
//    private List<User> getByCondition(String condition) {
//        Connection connection = null;
//        String query = "select * from " + DBName + condition;
//
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<User> users = new ArrayList<>();
//            while (resultSet.next()) {
//                User user = parseResultSet(resultSet);
//                users.add(user);
//            }
//            return users;
//        } catch (Throwable e) {
//            System.out.println("exception while execute " + query);
//            e.printStackTrace();
//            throw new DBException(e);
//        } finally {
//            closeConnection(connection);
//        }
//    }
//
//    private User getUserIfExist(String condition) {
//        List<User> users = getByCondition(condition);
//        if (users.size() > 0) {
//            return users.get(0);
//        }
//        return null;
//    }
//
//    public User getByLogin(String login) {
//        String condition = " where " + Login + " = '" + login + "'";
//        return getUserIfExist(condition);
//    }
//
//    public User getById(Long id) throws DBException {
//        String condition = " where " + UserID + " = " + id;
//        return getUserIfExist(condition);
//    }
//
//    public List<User> getAll() throws DBException {
//        return getByCondition("");
//    }
//
//    public void deleteById(Long id) throws DBException {
//        deleteByCondition(" WHERE " + UserID + " = " + id);
//    }
//
//    public void deleteByLogin(String login) throws DBException {
//        deleteByCondition(" WHERE " + Login + " = '" + login + "'");
//    }
//
//    public void deleteAll() throws DBException {
//        deleteByCondition("");
//    }
//
//    private void deleteByCondition(String condition) {
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("DELETE FROM " + DBName + condition);
//            preparedStatement.executeUpdate();
//        } catch (Throwable e) {
//            System.out.println("exception while execute DELETE FROM " + DBName + condition);
//            e.printStackTrace();
//            throw new DBException(e);
//        } finally {
//            closeConnection(connection);
//        }
//    }
//
//    public void update(User user) throws DBException {
//        if (user == null) {
//            return;
//        }
//
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("UPDATE " + DBName + " SET "
//                            + FirstName + " = ?,"
//                            + LastName + " = ?,"
//                            + Login + " = ?, "
//                            + Password + " = ? "
//                            + "WHERE " + UserID + " = ?");
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());
//            preparedStatement.setString(3, user.getLogin());
//            preparedStatement.setString(4, user.getPassword());
//            preparedStatement.setLong(5, user.getUserId());
//            preparedStatement.executeUpdate();
//        } catch (Throwable e) {
//            System.out.println("exception while execute UserDAOImpl.update()");
//            e.printStackTrace();
//            throw new DBException(e);
//        } finally {
//            closeConnection(connection);
//        }
//    }
//
}
