package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.TotalizatorBankDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TotalizatorBankServices {
    @Autowired
    private TotalizatorBankDAO totalizatorBankDAO;

    public void updateBalance(BigDecimal balance){
        totalizatorBankDAO.updateBalance(balance);
    }
}
