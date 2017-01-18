package lv.javaguru.java2.domain.services.factories;


import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.ConverterDto;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFactoryImpl implements UserFactory {

    @Autowired
    private ConverterDto<User,UserDTO> converterDto;

    @Override
    public boolean create(UserDTO userDTO) {
        User user = converterDto.convertFromRequest(userDTO);



        return false;
    }

    @Override
    public void getErrors() {

    }
}
