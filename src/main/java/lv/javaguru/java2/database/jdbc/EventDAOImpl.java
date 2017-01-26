package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.database.GenericHibernateDAOImpl;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EventDAOImpl extends GenericHibernateDAOImpl<Event> implements EventDAO {

    private final String TABLE_NAME = "events";



    @Override
    @Transactional
    public Event getByEventName(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
        criteria.add(Restrictions.eq("eventName", name));
        Object result = criteria.uniqueResult();
        Event event = null;
        if (result != null) {
            event = (Event) result;
        }
        return event;

    }

    @Override
    @Transactional
    public List<Event> getEventsWhereWinnerStatusIsNull() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
        criteria.add(Restrictions.like("winnerStatus", BetConditionState.NOT_SET));
        return criteria.list();
    }

}