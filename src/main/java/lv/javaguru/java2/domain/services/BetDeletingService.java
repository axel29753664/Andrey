package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDto;

import java.util.List;

public interface BetDeletingService {

    List<BetDto> deletingProcess(BetDto betDto, UserDto userForBetDeleting);

}
