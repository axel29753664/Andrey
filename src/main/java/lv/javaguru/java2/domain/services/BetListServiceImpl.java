package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterEventDTO;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BetListServiceImpl implements BetListService {

    @Autowired
    @Qualifier("ConverterBetDtoList")
    private ConverterDtoList converterBetDtoList;

    @Autowired
    @Qualifier("ConverterUserDtoList")
    private ConverterDtoList converterUserDtoList;

    @Autowired
    private ConverterEventDTO converterEventDTO;

    @Autowired
    private BetService betService;

    @Autowired
    private EventServices eventService;

    @Autowired
    private UserService userService;


    @Override
    public List<BetDTO> prepareBetList(Long userId) {
        List<Bet> bets = betService.getBetsByUserId(userId);
        List<BetDTO> betsDTO = converterBetDtoList.convertListToResponse(bets);
        return betsDTO;
    }

    @Override
    public List<UserDTO> prepareUserList() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDTO = converterUserDtoList.convertListToResponse(users);
        return usersDTO;
    }

    public List<EventDTO> prepareEventList(List<BetDTO> betsDTO) {
        List<EventDTO> eventsDTO = new ArrayList();
        for (BetDTO betDTO : betsDTO) {
            Event event = eventService.getEventById(betDTO.getEventId());
            EventDTO eventDTO = converterEventDTO.convertToResponse(event);
            eventsDTO.add(eventDTO);
        }
        return eventsDTO;
    }

    @Override
    public List<BetDTO> deletingProcess(Long betId){
        Long userId = betService.getById(betId).getUserId();
        betService.deleteBetById(betId);
        List<Bet> bets = betService.getBetsByUserId(userId);
        List<BetDTO> betsDto = converterBetDtoList.convertListToResponse(bets);
        return betsDto;
    }

}