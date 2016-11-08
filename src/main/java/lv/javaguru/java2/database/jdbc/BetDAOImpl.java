package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Bet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BetDAOImpl extends DAOImpl implements BetDAO {

    public void create(Bet bet) throws DBException {
        if (bet == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into BETS values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS); // template SQL кот хотим выполнить первый автоинкремент, два других данные
            preparedStatement.setLong(1, bet.getUserId()); // заполняем поля
            preparedStatement.setLong(2, bet.getEventId());
            preparedStatement.setBigDecimal(3, bet.getBetSum());
            preparedStatement.setBoolean(4, bet.getWiningChoice());
            preparedStatement.executeUpdate(); // отсылка подготовленного запроса
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){ // поучаем обратно ID
                bet.setBetId(rs.getLong(1)); // заносим ID в поле класса Ставка
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute BetDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection); // close everything
        }

    }

    public void delete(Long betId) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from BETS where UserID = ?");
            preparedStatement.setLong(1, betId);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute BetDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Bet getById(Long betId) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from BETS where BetID = ?");
            preparedStatement.setLong(1, betId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Bet bet = null;
            if (resultSet.next()) {
                bet = new Bet();
                bet.setBetId(resultSet.getLong("BetID"));
                bet.setUserId(resultSet.getLong("UserID"));
                bet.setEventId(resultSet.getLong("EventID"));
                bet.setBetSum(resultSet.getBigDecimal("Bet_Sum"));
                bet.setWinningChoice(resultSet.getBoolean("Winning_Choice"));
            }
            return bet;
        } catch (Throwable e) {
            System.out.println("Exception while execute BetDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Bet> getByUserId(Long userId) throws DBException {
        List<Bet> bets = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from BETS where UserID = ?");
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bet bet = new Bet();
                bet.setBetId(resultSet.getLong("BetID"));
                bet.setUserId(resultSet.getLong("UserID"));
                bet.setEventId(resultSet.getLong("EventID"));
                bet.setBetSum(resultSet.getBigDecimal("Bet_Sum"));
                bet.setWinningChoice(resultSet.getBoolean("Winning_Choice"));
                bets.add(bet);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list BetDAOImpl.getByUserId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return bets;
    }

    public List<Bet> getByEventId(Long eventId) throws DBException {
        List<Bet> bets = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from BETS where EventID = ?");
            preparedStatement.setLong(1, eventId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bet bet = new Bet();
                bet.setBetId(resultSet.getLong("BetID"));
                bet.setUserId(resultSet.getLong("UserID"));
                bet.setEventId(resultSet.getLong("EventID"));
                bet.setBetSum(resultSet.getBigDecimal("Bet_Sum"));
                bet.setWinningChoice(resultSet.getBoolean("Winning_Choice"));
                bets.add(bet);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list BetDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return bets;
    }

    public List<Bet> getByEventIdAndWinningChoice(Long eventId, Boolean winningChoice) throws DBException {
        List<Bet> bets = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from BETS where EventID = ? AND Winning_Choise = ?");
            preparedStatement.setLong(1, eventId);
            preparedStatement.setBoolean(2, winningChoice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bet bet = new Bet();
                bet.setBetId(resultSet.getLong("BetID"));
                bet.setUserId(resultSet.getLong("UserID"));
                bet.setEventId(resultSet.getLong("EventID"));
                bet.setBetSum(resultSet.getBigDecimal("Bet_Sum"));
                bet.setWinningChoice(resultSet.getBoolean("Winning_Choice"));
                bets.add(bet);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list BetDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return bets;
    }

}
