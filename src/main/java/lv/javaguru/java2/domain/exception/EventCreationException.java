package lv.javaguru.java2.domain.exception;


import org.springframework.validation.BindingResult;

import java.util.List;

public class EventCreationException extends RuntimeException {
    public EventCreationException(String message) {
        super(message);
    }

}
