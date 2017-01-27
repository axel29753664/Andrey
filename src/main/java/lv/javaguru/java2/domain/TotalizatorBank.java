package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Bank")
public class TotalizatorBank {

    public final static double PERCENTS = 0.9;
    @Id
    @Column(name = "Balance", nullable = false)
    private BigDecimal balance;


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

