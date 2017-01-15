package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;

import java.util.List;

public interface BetDAO extends GenericDAO<Bet>{

    void deleteByUserId(Long betId);

    List getByUserId(Long userId);

    List<Bet> getByEventId(Long eventId);

    List<Bet> getByEventIdAndBetCondition (Long eventId, BetConditionState betCondition);

}
