package lv.javaguru.java2.domain.services.factories;

import org.springframework.validation.Errors;

public interface CreationEntityFactory <DTO, Entity> {

    Entity create(DTO dto, Errors errors);

}