package lv.javaguru.java2.domain.services.factories;

import org.springframework.validation.Errors;

public interface CreationFactory<DTO> {

    void create(DTO dto, Errors errors);

}