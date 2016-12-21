package lv.javaguru.java2.domain.exception;


public class LoginServiceException extends RuntimeException {
    public LoginServiceException(String message) {
        super(message);
    }
}
