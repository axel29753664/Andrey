package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.AccountDAO;
import lv.javaguru.java2.database.DBException;

import lv.javaguru.java2.domain.moneyOperations.Account;
import lv.javaguru.java2.domain.moneyOperations.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Artjom on 09.11.2016.
 */
public class AccountDAOImpl extends DAOImpl implements AccountDAO {


    @Override
    public Account getAccountByID(long id) {

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from ACCOUNTS where AccountID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            if (resultSet.next()) {
                account = new Account();
                account.setAccountId(resultSet.getLong("AccountID"));
                account.setAccountBalance(resultSet.getLong("AccountBalance"));

            }
            return account;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateAccountBalance(Account account, long amount) {


    }

    @Override
    public void create(Account account) {
        if (account == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into ACCOUNTS values (default, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, account.getAccountBalance());


            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                account.setAccountId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Transaction> getReport() {
        return null;
    }

    @Override
    public void makeMoneyTransfer(Account sourceAccount, Account destinationAccount, long transferredAmount) {

        if (sourceAccount == null || destinationAccount == null) {
            return;
        }

        Connection connection = null;

        try {

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into TRANSACTIONS values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setLong(2, -(transferredAmount));
            preparedStatement.setLong(3, sourceAccount.getAccountId());
            preparedStatement.executeUpdate();

            preparedStatement =
                    connection.prepareStatement("update ACCOUNTS set AccountBalance = ? where AccountID = ?");
            preparedStatement.setLong(1, (sourceAccount.getAccountBalance() - transferredAmount));
            preparedStatement.setLong(2, sourceAccount.getAccountId());
            preparedStatement.executeUpdate();

            preparedStatement =
                    connection.prepareStatement("insert into TRANSACTIONS values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setLong(2, transferredAmount);
            preparedStatement.setLong(3, destinationAccount.getAccountId());
            preparedStatement.executeUpdate();

            preparedStatement =
                    connection.prepareStatement("update ACCOUNTS set AccountBalance = ? where AccountID = ?");
            preparedStatement.setLong(1, (destinationAccount.getAccountBalance() + transferredAmount));
            preparedStatement.setLong(2, destinationAccount.getAccountId());
            preparedStatement.executeUpdate();

        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
