package lv.javaguru.java2.domain.services.parsers;

import org.springframework.stereotype.Component;

@Component("StringToLongParser")
public class ParsingFromStringToLongServiceImpl implements ParsingFromStringService {

    @Override
    public Long parse(String obj){
        Long returnObj = null;
        if ((obj != null) && (!obj.equals(""))) {
            returnObj = Long.parseLong(obj);
            }
        return returnObj;
    }

}
