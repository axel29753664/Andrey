package lv.javaguru.java2.domain.services.dtoConverters;

public interface ConverterDTO<ENTITY, DTO> {

    ENTITY convertFromRequest(DTO dto);

    DTO convertToResponse (ENTITY entity);

}