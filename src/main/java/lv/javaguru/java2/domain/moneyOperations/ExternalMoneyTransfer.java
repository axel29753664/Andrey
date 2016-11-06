package lv.javaguru.java2.domain.moneyOperations;

import java.util.List;

/**
 * Created by Artjom on 06.11.2016.
 */
public interface ExternalMoneyTransfer {

    void withdrawMoneyFromAccount(UserAccount account, long amount);

    void addMoneyToAccount(UserAccount account);

}
