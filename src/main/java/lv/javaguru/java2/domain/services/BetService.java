package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Set;

public interface BetService {

    void saveToDB(Bet bet);

    Bet getById(Long id);

    List<Bet> getBetsByUserId(Long userId);

    List<Bet> getEventBets(Long eventId);

    Bet getEventUncoveredBet(Long id);

    List<Bet> getAllBets();

    void updateBet(Bet bet);

    void deleteBetById(Long id);

    void deleteByEventId(Long id);

    Set<Bet> getEventWinnersBets(Long eventId, BetConditionState state);

    Bet getOppositeBet (Bet bet);

    void changeBetsUncoveredSumAndEventBetSide (Bet bet, Bet oppositeBet, Double coefficient);

    void changeEventBetSide(Bet bet);

}
