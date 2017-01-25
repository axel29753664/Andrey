package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDTO;

import java.util.List;

public interface BetListService {

    List<BetDTO> prepareBetList(User user);

}
