package lv.javaguru.java2.domain.services.parsers;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component("StringToBigDecimalParser")
public class ParserStringToBigDecimal {

    public static BigDecimal parse(String string){
        BigDecimal decimal = null;
        if ((string != null) && (!string.equals(""))) {
            decimal = BigDecimal.valueOf(Float.parseFloat(string));
            decimal = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return decimal;
    }

}
