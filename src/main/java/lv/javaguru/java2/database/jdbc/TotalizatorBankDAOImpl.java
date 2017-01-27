package lv.javaguru.java2.database.jdbc;


import lv.javaguru.java2.database.TotalizatorBankDAO;
import lv.javaguru.java2.database.GenericHibernateDAOImpl;
import lv.javaguru.java2.domain.TotalizatorBank;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class TotalizatorBankDAOImpl extends GenericHibernateDAOImpl<TotalizatorBank> implements TotalizatorBankDAO {
    @Override
    @Transactional
    public void updateBalance(BigDecimal balance) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("UPDATE Bank SET Balance = '" + balance + "'");
        query.executeUpdate();
    }
}
