package lv.javaguru.java2.domain.services.factories;


import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.ConverterDto;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.domain.validators.UserValidator;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class UserFactoryImpl implements UserFactory {

    @Autowired
    private ConverterDto<User, UserDTO> converterDto;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator validator;

    @Override
    public void create(UserDTO userDTO, Errors validResult) {
        validator.validate(userDTO, validResult);
        if (!validResult.hasErrors()) {
            User user = converterDto.convertFromRequest(userDTO);
            try {
                userService.saveToDB(user);
            } catch (JDBCException e) {
                validResult.rejectValue("firstName", "message.saveToDBError", "Error save to DB [" + e.getMessage() + "]");
            }
        }
    }

}
