package lv.javaguru.java2.servlet.dto;

import lv.javaguru.java2.domain.Role;
import lv.javaguru.java2.domain.RolesSet;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private Long userId;
    @Size(max = 50, message = "character allowed < 50")
    private String firstName;
    @Size(max = 50, message = "character allowed < 50")
    private String lastName;
    @NotEmpty
    @Size(min = 3, max = 20, message = "Login must between 3 to 20 symbols")
    private String login;
    @NotEmpty
    @Size(min = 4, max = 16, message = "Password must between 4 to 14 symbols")
    private String password;
    private Set<Role> roles;
    @Min(value = 0, message = "Balance must be >0")
    private BigDecimal balance;

    public UserDTO() {
        this.balance = new BigDecimal(0);
        this.roles = createDefaultUserRoles();
    }

    public UserDTO(Long userId) {
        this();
        this.userId = userId;
    }

    public UserDTO(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public UserDTO(Long userId, String firstName, String lastName, String login, String password, Set<Role> roles, BigDecimal balance) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.balance = balance;
    }

    private Set<Role> createDefaultUserRoles() {
        Set<Role> roleSet = new HashSet<>();                                            //set default access ROLE_USER
        roleSet.add(RolesSet.USER);
        return roleSet;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", balance=" + balance +
                '}';
    }
}