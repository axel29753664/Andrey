package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Bet;

import java.util.List;

public interface BetDAO extends GenericDAO<Bet>{

    void deleteById(Long betId);

    List<Bet> getByUserId(Long userId);

    List<Bet> getByEventId(Long eventId);

    List<Bet> getByEventIdAndWinningCondition (Long eventId, Boolean winningCondition);

}
