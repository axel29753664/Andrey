package lv.javaguru.java2.domain.services.parsers;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ParserStringIdsFromRequestToLong {
    public static List<Long> getIdList(HttpServletRequest request, int listSize) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            String result = request.getParameter(String.valueOf(i));  // get Event id by parameter name
            if (result != null) {
                Long id = Long.parseLong(result);
                list.add(id);
            }
        }
        return list;
    }
}
