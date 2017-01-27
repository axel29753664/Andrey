package lv.javaguru.java2.database;


import lv.javaguru.java2.domain.TotalizatorBank;

import java.math.BigDecimal;

public interface TotalizatorBankDAO extends GenericDAO<TotalizatorBank> {
    void updateBalance(BigDecimal balance);
}
