package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Bet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BetDAOImpl extends DAOImpl implements BetDAO {
    private final String TABLE_NAME = "bets";
    private final String BET_ID = "BetID";
    private final String USER_ID = "UserID";
    private final String EVENT_ID = "EventID";
    private final String BET_SUM = "Bet_Sum";
    private final String WINNING_CONDITION = "Winning_Condition";

    public void create(Bet bet) throws DBException {
        if (bet == null) {
            return;
        }
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into BETS values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS); // template SQL кот хотим выполнить первый автоинкремент, два других данные
            preparedStatement.setLong(1, bet.getUserId()); // заполняем поля
            preparedStatement.setLong(2, bet.getEventId());
            preparedStatement.setBigDecimal(3, bet.getBetSum());
            preparedStatement.setBoolean(4, bet.getWinningCondition());
            preparedStatement.executeUpdate(); // отсылка подготовленного запроса
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){ // поучаем обратно ID
                bet.setBetId(rs.getLong(1)); // заносим ID в поле класса Ставка
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute BetDAOImpl.create()");
            e.printStackTrace();
            throw new DBException("Exception while execute BetDAOImpl.create()", e);
        } finally {
            closeConnection(connection);
        }
    }

    public void deleteById(Long betId) throws DBException {
        String deleteQuery = "delete from " +  TABLE_NAME + " where " + BET_ID + " = " + betId;
        deleteByCondition(deleteQuery);
    }

    public Bet getById(Long betId) throws DBException {
        String searchQuery = "select * from " +  TABLE_NAME + " where " + BET_ID + " = " + betId;
        List<Bet> bets = getByCondition(searchQuery);
        Bet bet = getOneUniqueBet(bets);
        return bet;
    }

    public List<Bet> getByUserId(Long userId) throws DBException {
        String searchQuery = "select * from " +  TABLE_NAME + " where " + USER_ID + " = " + userId;
        List<Bet> bets = getByCondition(searchQuery);
        return bets;
    }

    public List<Bet> getByEventId(Long eventId) throws DBException {
        String searchQuery = "select * from " +  TABLE_NAME + " where " + EVENT_ID + " = " + eventId;
        List<Bet> bets = getByCondition(searchQuery);
        return bets;
    }

    public List<Bet> getByEventIdAndWinningCondition(Long eventId, Boolean winningCondition) throws DBException {
        String searchQuery = "select * from " +  TABLE_NAME + " where " + EVENT_ID + " = " + eventId + " AND " + WINNING_CONDITION + " = " + winningCondition;
        List<Bet> bets = getByCondition(searchQuery);
        return bets;
    }

    private List<Bet> getByCondition(String searchCondition) {
        List<Bet> bets = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(searchCondition);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bet bet = getDataFromSearchResult(resultSet);
                bets.add(bet);
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute BetDAOImpl.getByCondition()");
            e.printStackTrace();
            throw new DBException("Exception while execute BetDAOImpl.getByCondition()", e);
        } finally {
            closeConnection(connection);
        }
        return bets;
    }

    private void deleteByCondition(String deleteCondition) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCondition);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute BetDAOImpl.deleteByCondition()");
            e.printStackTrace();
            throw new DBException("Exception while execute BetDAOImpl.deleteByCondition()", e);
        } finally {
            closeConnection(connection);
        }
    }

    private Bet getDataFromSearchResult(ResultSet resultSet) throws SQLException {
        Bet bet = new Bet();
        bet.setBetId(resultSet.getLong("BetID"));
        bet.setUserId(resultSet.getLong("UserID"));
        bet.setEventId(resultSet.getLong("EventID"));
        bet.setBetSum(resultSet.getBigDecimal("Bet_Sum"));
        bet.setWinningCondition(resultSet.getBoolean("Winning_Condition"));
        return bet;
    }

    private Bet getOneUniqueBet(List<Bet> bets) {
        Bet bet = null;
        if (bets.size() > 0) {
            bet = bets.get(0);
        }
        return bet;
    }

}