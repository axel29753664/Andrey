package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.domain.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetDAO betDAO;

    @Override
    public void writeInDatabase(Bet bet){
        betDAO.create(bet);
    }

    @Override
    public List<Bet> getBetsByUserId(Long userId) {
        return betDAO.getByUserId(userId);
    }

    @Override
    public List<Bet> getAllBets() {
        return betDAO.getAll();
    }

    @Override
    public void deleteBetById(Long betId) {
        betDAO.delete(betId);
    }

}
