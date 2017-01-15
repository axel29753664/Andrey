package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;

import java.util.List;

public interface BetService {

    List<Bet> getBetsByUserId(Long userId);

    List<Bet> getAllBets();

    void deleteBetById(Long id);

}
