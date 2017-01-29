package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.validation.Errors;

public interface ApplyBetService {

    void apply (BetDTO betDTO, Errors validResult);

}