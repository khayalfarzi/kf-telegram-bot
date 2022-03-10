package az.company.kftelegrambot.service;

import az.company.kftelegrambot.service.func.ExecutableFunc;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommandService {

    private static final Map<String, ExecutableFunc> map = new HashMap<>();

    public void addFunc(String key, ExecutableFunc func) {
        map.put(key, func);
    }

    public Object execute(String key, String... params) {
        if (map.containsKey(key)) {
            return map.get(key).execute(params);
        }
        return null;
    }
}