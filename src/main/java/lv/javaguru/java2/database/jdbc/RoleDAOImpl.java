package lv.javaguru.java2.database.jdbc;


import lv.javaguru.java2.database.GenericHibernateDAOImpl;
import lv.javaguru.java2.database.RoleDAO;
import lv.javaguru.java2.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDAOImpl extends GenericHibernateDAOImpl<Role> implements RoleDAO {
}
