package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;

import java.util.List;

public interface BetDAO extends GenericDAO<Bet> {
    List<Bet> getUserBetsByEventStatus(Long userId, BetConditionState state);

    List getByUserId(Long userId);

    List<Bet> getByEventId(Long eventId);

    List<Bet> getByEventIdAndBetCondition(Long eventId, BetConditionState betCondition);

    void deleteByUserId(Long betId);

    void deleteByEventId(Long id);

    Bet getUncoveredEventBetByEventId(Long id);

    Bet getUncoveredBetByEventIdAndUncoveredSumAndState(Long id, BetConditionState betCondition);

}
