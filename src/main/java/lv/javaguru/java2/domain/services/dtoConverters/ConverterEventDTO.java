package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.EventStatusState;
import lv.javaguru.java2.domain.WinnerStatus;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.stereotype.Service;

@Service
public class ConverterEventDTO implements ConverterDto<Event, EventDTO> {
    @Override
    public Event convertFromRequest(EventDTO eventDTO) {
        Long eventId = eventDTO.getEventId();
        String eventName = eventDTO.getEventName();
        String eventDescription = eventDTO.getEventDescription();
        String winningCondition = eventDTO.getWinningCondition();
        String loseCondition = eventDTO.getLoseCondition();
        String drawCondition = eventDTO.getDrawCondition();
        EventStatusState eventStatus = eventDTO.getEventStatus();
        WinnerStatus winnerStatus = eventDTO.getWinnerStatus();
        Event event = new Event(eventName, eventDescription, winningCondition, loseCondition, drawCondition);
        event.setEventId(eventId);
        event.setWinnerStatus(winnerStatus);
        event.setEventStatus(eventStatus);
        return event;
    }

    @Override
    public EventDTO convertToResponse(Event event) {
        Long eventId = event.getEventId();
        String eventName = event.getEventName();
        String eventDescription = event.getEventDescription();
        String winningCondition = event.getWinningCondition();
        String loseCondition = event.getLoseCondition();
        String drawCondition = event.getDrawCondition();
        EventStatusState eventStatus = event.getEventStatus();
        WinnerStatus winnerStatus = event.getWinnerStatus();
        EventDTO eventDTO = new EventDTO(eventName, eventDescription, winningCondition, loseCondition, drawCondition);
        event.setEventId(eventId);
        event.setEventStatus(eventStatus);
        event.setWinnerStatus(winnerStatus);
        return eventDTO;
    }
}
