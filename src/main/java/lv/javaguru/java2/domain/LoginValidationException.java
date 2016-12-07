package lv.javaguru.java2.domain;

/**
 * Created by Axel_ on 05.12.2016.
 */
public class LoginValidationException extends RuntimeException {
    public LoginValidationException(String message) {
        super(message);
    }
}
