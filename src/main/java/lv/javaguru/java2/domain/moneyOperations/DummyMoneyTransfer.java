package lv.javaguru.java2.domain.moneyOperations;

import java.util.Random;

/**
 * Created by Artjom on 06.11.2016.
 */
public class DummyMoneyTransfer implements ExternalMoneyTransfer {

    @Override
    public void withdrawMoneyFromAccount(Account account, long amount) {



    }

    @Override
    public void addMoneyToAccount(Account account) {

        Random randGen = new Random();
        long transferredSum = (long)randGen.nextInt(10000);
        account.setAccountBalance(transferredSum);


    }
}
