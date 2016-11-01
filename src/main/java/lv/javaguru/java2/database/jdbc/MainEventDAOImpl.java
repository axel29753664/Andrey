package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MainEventDAO;
import lv.javaguru.java2.domain.MainEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 11/1/2016.
 */
public class MainEventDAOImpl extends  DAOImpl implements MainEventDAO{

    public void create (MainEvent mainEvent) throws DBException {
        if (mainEvent == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into MAINEVENTS values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, mainEvent.getMainEventInfo());
            preparedStatement.setLong(2, mainEvent.getMainEventAddTime());
            preparedStatement.setLong(3, mainEvent.getMainEventStartTime());
            preparedStatement.setLong(4, mainEvent.getMainEventEndTime());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                mainEvent.setMainEventId(resultSet.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute MainEventDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public MainEvent getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from MAINEVENTS where MainEventID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            MainEvent mainEvent = null;
            if (resultSet.next()) {
                mainEvent = new MainEvent();
                mainEvent.setMainEventId(resultSet.getLong("MainEventID"));
                mainEvent.setMainEventInfo(resultSet.getString("MainEventInfo"));
                mainEvent.setMainEventAddTime(resultSet.getLong("MainEventAddTime"));
                mainEvent.setMainEventStartTime(resultSet.getLong("MainEventStartTime"));
                mainEvent.setMainEventEndTime(resultSet.getLong("MainEventEndTime"));
            }
            return mainEvent;
        } catch (Throwable e) {
            System.out.println("Exception while execute MainEventDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<MainEvent> getAll() throws DBException {
        List<MainEvent> mainEvents = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from MAINEVENTS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MainEvent mainEvent = new MainEvent();
                mainEvent.setMainEventId(resultSet.getLong("MainEventID"));
                mainEvent.setMainEventInfo(resultSet.getString("MainEventInfo"));
                mainEvent.setMainEventAddTime(resultSet.getLong("MainEventAddTime"));
                mainEvent.setMainEventStartTime(resultSet.getLong("MainEventStartTime"));
                mainEvent.setMainEventEndTime(resultSet.getLong("MainEventEndTime"));
                mainEvents.add(mainEvent);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list MainEventDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return mainEvents;
    }


    public void update(MainEvent mainEvent) {
        if (mainEvent == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update MAINEVENTS set MainEventInfo = ?," +
                            "set MainEventAddTime = ?," +
                            "set MainEventStartTime = ?," +
                            "set MainEventEndTime = ?");
            preparedStatement.setString(1, mainEvent.getMainEventInfo());
            preparedStatement.setLong(2, mainEvent.getMainEventAddTime());
            preparedStatement.setLong(3, mainEvent.getMainEventStartTime());
            preparedStatement.setLong(4, mainEvent.getMainEventEndTime());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute MainEventDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
