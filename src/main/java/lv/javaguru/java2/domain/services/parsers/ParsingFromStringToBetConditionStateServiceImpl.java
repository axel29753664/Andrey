package lv.javaguru.java2.domain.services.parsers;

import lv.javaguru.java2.domain.BetConditionState;
import org.springframework.stereotype.Component;

@Component("StringToBetConditionStateParser")
public class ParsingFromStringToBetConditionStateServiceImpl implements ParsingFromStringService {

    private final static String conditionWin = "WIN";
    private final static String conditionLose = "LOSE";
    private final static String conditionDraw = "DRAW";

    @Override
    public BetConditionState parse(String obj){

        BetConditionState returnObj = BetConditionState.NOT_APPLIED;
        if ((obj != null) && (!obj.equals(""))) {
            returnObj = compareBetCondition(obj, returnObj);
        }
        return returnObj;

    }


    private BetConditionState compareBetCondition (String obj, BetConditionState returnObj) {
        if (obj.equals(conditionWin)) {
            returnObj = BetConditionState.WIN;
        }
        if (obj.equals(conditionLose)) {
            returnObj = BetConditionState.LOSE;
        }
        if (obj.equals(conditionDraw)) {
            returnObj = BetConditionState.DRAW;
        }
        return returnObj;
    }


}
