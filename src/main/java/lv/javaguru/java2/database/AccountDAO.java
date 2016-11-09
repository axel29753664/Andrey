package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.moneyOperations.Account;
import lv.javaguru.java2.domain.moneyOperations.Transaction;

import java.util.List;

/**
 * Created by Artjom on 07.11.2016.
 */
public interface AccountDAO {

    public Account getAccountByID (long id);

    public void updateAccountBalance (Account account, long amount);

    public void create(Account account);

    public void makeMoneyTransfer (Account sourceAccount, Account destinationAccount, long transferredAmount);

    public List<Transaction> getReport();




}
