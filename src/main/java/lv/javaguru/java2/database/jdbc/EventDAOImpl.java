package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.database.GenericHibernateDAOImpl;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.WinnerStatus;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventDAOImpl extends GenericHibernateDAOImpl<Event> implements EventDAO {

    private final String TABLE_NAME = "events";
    private final String EVENT_ID = "EventID";


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
        criteria.add(Restrictions.like("winnerStatus", WinnerStatus.NOT_SET));
        return criteria.list();
    }

//    public Event getById(Long eventId) throws DBException {
//        String searchQuery = "select * from " +  TABLE_NAME + " where " + EVENT_ID + " = " + eventId;
//        List<Event> events = getByCondition(searchQuery);
//        Event event = getOneUniqueEvent(events);
//        return event;
//    }
//
//    private List<Event> getByCondition(String searchCondition) {
//        List<Event> events = new ArrayList();
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(searchCondition);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Event event = getDataFromSearchResult(resultSet);
//                events.add(event);
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while execute EventDAOImpl.getByCondition()");
//            e.printStackTrace();
//            throw new DBException(e);
//        } finally {
//            closeConnection(connection);
//        }
//        return events;
//    }
//
//    private Event getDataFromSearchResult(ResultSet resultSet) throws SQLException {
//        Event event = new Event();
//        event.setEventId(resultSet.getLong("EventID"));
//        event.setEventName(resultSet.getString("EventName"));
//        return event;
//    }
//
//    private Event getOneUniqueEvent(List<Event> events) {
//        Event event = null;
//        if (events.size() > 0) {
//            event = events.get(0);
//        }
//        return event;
//    }

}
