package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;

import java.util.List;

public interface BetService {

    public List<Bet> getBetsByUserId(Long userId);

    public List<Bet> getAllBets();

}
