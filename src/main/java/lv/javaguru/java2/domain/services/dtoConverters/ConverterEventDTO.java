package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterEventDTO implements ConverterDTO<Event, EventDTO> {
    @Override
    public Event convertFromRequest(EventDTO eventDTO) {
        Long eventId = eventDTO.getEventId();
        String eventName = eventDTO.getEventName();
        String eventDescription = eventDTO.getEventDescription();
        String winDescription = eventDTO.getWinDescription();
        BetConditionState betSide = eventDTO.getBetSide();
        BetConditionState winnerStatus = eventDTO.getWinnerStatus();
        double coefficient = eventDTO.getCoefficient();
        BigDecimal totalBank = eventDTO.getTotalBank();

        return new Event(eventId, eventName, eventDescription, winDescription, betSide, winnerStatus, coefficient, totalBank);
    }

    @Override
    public EventDTO convertToResponse(Event event) {
        Long eventId = event.getEventId();
        String eventName = event.getEventName();
        String eventDescription = event.getEventDescription();
        String winDescription = event.getWinDescription();
        BetConditionState betSide = event.getBetSide();
        BetConditionState winnerStatus = event.getWinnerStatus();
        double coefficient = event.getCoefficient();
        BigDecimal totalBank = event.getTotalBank();

        return new EventDTO(eventId, eventName, eventDescription, winDescription, betSide, winnerStatus, coefficient, totalBank);
    }
}
