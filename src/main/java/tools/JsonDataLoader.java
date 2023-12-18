package tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import transactions.Account;

import java.util.List;

public class JsonDataLoader implements JsonProcessor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonDataLoader() {
        objectMapper.findAndRegisterModules();
    }

    @Override
    public String toJson(List<Account> accounts) {
        try {
            return objectMapper.writeValueAsString(accounts);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> fromJson(String json) {
        try {
            return objectMapper.readValue(json, List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
