package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetDAO betDAO;

    @Override
    public void saveToDB(Bet bet){
        betDAO.create(bet);
    }

    @Override
    public List<Bet> getBetsByUserId(Long userId) {
        return betDAO.getByUserId(userId);
    }

    @Override
    public List<Bet> getEventBets(Long eventId) {
        return betDAO.getByEventId(eventId);
    }

    @Override
    public Bet getEventUncoveredBet(Long id) {
        return betDAO.getUncoveredEventBetByEventId(id);
    }

    @Override
    public List<Bet> getAllBets() {
        return betDAO.getAll();
    }

    @Override
    public void deleteBetById(Long betId) {
        betDAO.delete(betId);
    }

    @Override
    public void deleteByEventId(Long id) {
        betDAO.deleteByEventId(id);
    }

    @Override
    public Set<Bet> getEventWinnersBets(Long eventId, BetConditionState state) {
        List<Bet> betList = betDAO.getByEventIdAndBetCondition(eventId, state);
        Set<Bet> betSet = new HashSet<>();
        betSet.addAll(betList);
        return betSet;
    }

}
