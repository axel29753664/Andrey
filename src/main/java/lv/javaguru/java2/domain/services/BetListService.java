package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;

import java.util.List;

public interface BetListService {

    List<BetDTO> prepareBetList(Long userId);

    List<UserDTO> prepareUserList();

    List<EventDTO> prepareEventList(List<BetDTO> betsDTO);

    List<BetDTO> deletingProcess(Long betId);

}
