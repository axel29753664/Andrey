package lv.javaguru.java2.domain.moneyOperations;

/**
 * Created by Artjom on 06.11.2016.
 */
public interface ExternalMoneyTransfer {

    void withdrawMoneyFromAccount(Account account, long amount);

    void addMoneyToAccount(Account account);

}
