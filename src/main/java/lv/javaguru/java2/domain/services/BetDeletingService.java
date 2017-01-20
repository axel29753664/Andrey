package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDTO;

import java.util.List;

public interface BetDeletingService {

    List<BetDto> deletingProcess(BetDto betDto, UserDTO userForBetDeleting);

}
