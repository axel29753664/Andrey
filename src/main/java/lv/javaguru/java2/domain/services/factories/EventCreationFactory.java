package lv.javaguru.java2.domain.services.factories;


import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDto;
import lv.javaguru.java2.domain.validators.EventValidator;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class EventCreationFactory implements CreationFactory<EventDTO> {
    @Autowired
    private EventServices eventServices;
    @Autowired
    private ConverterDto<Event, EventDTO> converterDto;
    @Autowired
    private EventValidator validator;

    @Override
    public void create(EventDTO eventDTO, Errors validResult) {
        validator.validate(eventDTO, validResult);
        if (!validResult.hasErrors()) {
            Event event = converterDto.convertFromRequest(eventDTO);
            try {
                eventServices.saveToDB(event);
            } catch (JDBCException e) {
                validResult.rejectValue("eventName", "message.saveToDBError", "Error save to DB [" + e.getCause().getMessage() + "]");
            }
        }
    }
}

