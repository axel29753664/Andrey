package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.GenericHibernateDAOImpl;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.exception.BetDBException;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Component
public class BetDAOImpl extends GenericHibernateDAOImpl<Bet> implements BetDAO {

    private final String TABLE_NAME = "bets";

    @Override
    @Transactional
    public List<Bet> getByUserId(Long userId) throws JDBCException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bet.class);
        criteria.add(Restrictions.eq("userId", userId));
        return criteria.list();
    }

    @Override
    @Transactional
    public List<Bet> getByEventId(Long eventId) throws JDBCException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bet.class);
        criteria.add(Restrictions.like("eventId", eventId));
        return criteria.list();
    }

    @Override
    @Transactional
    public List<Bet> getByEventIdAndBetCondition(Long eventId, BetConditionState betCondition) throws JDBCException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bet.class);
        criteria.add(Restrictions.like("eventId", eventId));
        criteria.add(Restrictions.like("betCondition", betCondition));
        return criteria.list();
    }


    @Override
    @Transactional
    public void delete(Long id) throws JDBCException {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("delete from " + TABLE_NAME + " where BetID = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteByUserId(Long userID) throws JDBCException {
        String deleteQuery = "delete from " + TABLE_NAME + " where UserID= :userID";
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(deleteQuery);
        query.setLong("userID", userID);
        query.executeUpdate();
    }

    @Override
    public Bet getUncoveredEventBetByEventId(Long id) throws BetDBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bet.class);
        criteria.add(Restrictions.like("eventId", id));
        criteria.add(Restrictions.gt("uncoveredSum", new BigDecimal(0)));
        if (criteria.list().size() > 1) {
            throw new BetDBException("More than one bet is uncovered");
        }
        Bet bet = null;
        if (criteria.list().size() > 0) {
            bet = (Bet) criteria.list().get(0);
        }
        return bet;

    }

    @Override
    @Transactional
    public void deleteByEventId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("delete from " + TABLE_NAME + " where EventID = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

}