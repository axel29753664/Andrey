package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.GenericHibernateDAOImpl;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;

import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class UserDAOImpl extends GenericHibernateDAOImpl<User> implements UserDAO {
    private final String TABLE_NAME = "users";

    @Override
    @Transactional
    public List<User> getAll() throws JDBCException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.addOrder(Order.asc("userId"));

        return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
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

}