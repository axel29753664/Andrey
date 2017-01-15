package lv.javaguru.java2.domain.services.parsers;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("StringToBigDecimalParser")
public class ParsingFromStringToBigDecimalServiceImpl implements ParsingFromStringService {

    @Override
    public BigDecimal parse(String obj){
        BigDecimal returnObj = null;
        if ((obj != null) && (!obj.equals(""))) {
            returnObj = BigDecimal.valueOf(Float.parseFloat(obj));
            returnObj = returnObj.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return returnObj;
    }

}
