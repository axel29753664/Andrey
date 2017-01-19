package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDto;

import java.util.List;

public interface BetListService {

    List<BetDto> prepareBetList(User user);

}
