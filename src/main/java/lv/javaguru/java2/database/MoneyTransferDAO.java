package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.moneyOperations.Account;

/**
 * Created by Artjom on 07.11.2016.
 */
public interface MoneyTransferDAO {

    public Account getAccountByID (long id);

    public void updateAccountBalance (Account account, long amount);



}
