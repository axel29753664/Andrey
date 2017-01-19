package lv.javaguru.java2.domain.services.parsers;

import org.springframework.stereotype.Component;

//@Component("StringToLongParser")
public class ParserStringToLong {

    public static Long parse(String string){
        Long aLong = null;
        if ((string != null) && (!string.equals(""))) {
            aLong = Long.parseLong(string);
            }
        return aLong;
    }

}
