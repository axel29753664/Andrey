package lv.javaguru.java2.domain.services.parsers;

import lv.javaguru.java2.domain.BetConditionState;

public class ParserStringToBetConditionState {

    private final static String conditionWin = "WIN";
    private final static String conditionLose = "LOSE";


    public static BetConditionState parse(String string){

        BetConditionState returnObj = BetConditionState.NOT_SET;
        if ((string != null) && (!string.equals(""))) {
            returnObj = compareBetCondition(string, returnObj);
        }
        return returnObj;

    }


    private static BetConditionState compareBetCondition (String string, BetConditionState returnObj) {
        if (string.equals(conditionWin)) {
            returnObj = BetConditionState.WIN;
        }
        if (string.equals(conditionLose)) {
            returnObj = BetConditionState.LOSE;
        }
        return returnObj;
    }


}
