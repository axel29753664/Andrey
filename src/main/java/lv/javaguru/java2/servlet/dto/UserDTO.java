package lv.javaguru.java2.servlet.dto;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {

    @Size(max = 50, message = "character allowed < 50")
    private String firstName;
    @Size(max = 50, message = "character allowed < 50")
    private String lastName;
    @NotEmpty
    @Size(min = 3, max = 20 , message = "Login must between 3 to 20 symbols")
    private String login;
    @NotEmpty
    @Size(min = 4, max = 16, message = "Password must between 4 to 14 symbols")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String login, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;

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


}
