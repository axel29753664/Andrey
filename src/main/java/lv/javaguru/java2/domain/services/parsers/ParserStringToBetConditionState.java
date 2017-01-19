package lv.javaguru.java2.domain.services.parsers;

import lv.javaguru.java2.domain.BetConditionState;
import org.springframework.stereotype.Component;

//@Component("StringToBetConditionStateParser")
public class ParserStringToBetConditionState {

    private final static String conditionWin = "WIN";
    private final static String conditionLose = "LOSE";
    private final static String conditionDraw = "DRAW";


    public static BetConditionState parse(String string){

        BetConditionState returnObj = BetConditionState.NOT_APPLIED;
        if ((string != null) && (!string.equals(""))) {
            returnObj = compareBetCondition(string, returnObj);
        }
        return returnObj;

    }


    private static BetConditionState compareBetCondition (String string, BetConditionState betConditionState) {
        if (string.equals(conditionWin)) {
            betConditionState = BetConditionState.WIN;
        }
        if (string.equals(conditionLose)) {
            betConditionState = BetConditionState.LOSE;
        }
        if (string.equals(conditionDraw)) {
            betConditionState = BetConditionState.DRAW;
        }
        return betConditionState;
    }


}
