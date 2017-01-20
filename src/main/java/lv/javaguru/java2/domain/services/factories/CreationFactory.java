package lv.javaguru.java2.domain.services.factories;


import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.validation.Errors;

public interface CreationFactory<DTO> {

    void create(DTO dto, Errors errors);

}
