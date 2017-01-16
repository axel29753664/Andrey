package lv.javaguru.java2.domain;

import lv.javaguru.java2.domain.validators.betValidation.BetValidationError;
import lv.javaguru.java2.servlet.dto.BetDto;

import java.util.List;

public class Response {

    private BetDto betDto;
    private String dbError;
    private List<BetValidationError> errors;

    public Response() {
    }

    public void setBetDto(BetDto betDto) {
        this.betDto = betDto;
    }

    public BetDto getBetDto() {
        return betDto;
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
