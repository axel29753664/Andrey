package lv.javaguru.java2.servlet.mvc.controllers.controllerServices;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ButtonProcessMenu {
    private Map<String, Process> processMap = new HashMap<String, Process>() {
        {
            put("delete", new DeleteButtonProcess());
            put("update", new UpdateButtonProcess());
        }
    };

    public Process getButtonProcess(String buttonName) {
        return processMap.get(buttonName);
    }
}
