package lv.javaguru.java2.domain.validators;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EventValidator implements Validator {
    @Autowired
    private EventServices eventServices;

    @Override
    public boolean supports(Class<?> aClass) {
        return EventDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EventDTO eventDTO = (EventDTO) o;
        Event event =eventServices.getByEventName(eventDTO.getEventName());
        if (event!=null){
            errors.rejectValue("eventName", "message.eventExist", "Event with that name already exist.");
        }

    }
}
