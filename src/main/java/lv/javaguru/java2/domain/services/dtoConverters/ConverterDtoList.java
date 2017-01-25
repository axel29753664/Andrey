package lv.javaguru.java2.domain.services.dtoConverters;

import java.util.List;

public interface ConverterDtoList<ENTITY, DTO> {

    List<DTO> convertListToResponse (List<ENTITY> objects);

}