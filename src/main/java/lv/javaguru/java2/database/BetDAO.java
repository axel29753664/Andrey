package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Bet;

import java.util.List;

public interface BetDAO {

    void create(Bet bet);

    void deleteById(long betId);

    Bet getById(long betId);

    List<Bet> getByUserId(long userId);

    List<Bet> getByEventId(long eventId);

    List<Bet> getByEventIdAndWinningChoice (long eventId, boolean winningChoice);

}
