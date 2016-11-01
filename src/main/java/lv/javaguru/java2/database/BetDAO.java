package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Bet;

import java.util.List;

public interface BetDAO {

    void create(Bet bet);

    void delete(Long betId);

    Bet getById(Long betId);

    List<Bet> getByUserId(Long userId);

    List<Bet> getByEventId(Long eventId);

    List<Bet> getByEventIdAndWinningChoice (Long eventId, Boolean winningChoice);

}