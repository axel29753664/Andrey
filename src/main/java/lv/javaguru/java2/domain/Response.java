package lv.javaguru.java2.domain;

import lv.javaguru.java2.domain.validators.betValidation.BetValidationError;

import java.util.List;

public class Response {

    private Bet bet;
    private String dbError;
    private List<BetValidationError> errors;

    public Response() {
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public Bet getBet() {
        return bet;
    }

    public void setDbError(String dbError) {
        this.dbError = dbError;
    }

    public String getDbError() {
        return dbError;
    }

    public void setErrorsList(List<BetValidationError> errors) {
        this.errors = errors;
    }

    public List<BetValidationError> getErrorsList() {
        return errors;
    }

}
