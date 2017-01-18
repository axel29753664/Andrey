package lv.javaguru.java2.domain.services.factories;


import lv.javaguru.java2.servlet.dto.UserDTO;

public interface UserFactory {

    boolean create(UserDTO userDTO);

    void getErrors();

}
