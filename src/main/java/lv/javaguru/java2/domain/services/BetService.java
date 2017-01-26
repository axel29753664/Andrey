package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Set;

public interface BetService {

    void saveToDB(Bet bet);

    List<Bet> getBetsByUserId(Long userId);

    List<Bet> getEventBets(Long eventId);

    Bet getEventUncoveredBet(Long id);

    List<Bet> getAllBets();

    void deleteBetById(Long id);

    void deleteByEventId(Long id);

    Set<Bet> getEventWinnersBets(Long eventId, BetConditionState state);

    void createBet(BetDTO betDTO, BindingResult errors);

}
