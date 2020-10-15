package commerce.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import kong.unirest.ObjectMapper;

public class JsonMapper implements ObjectMapper {

    private static final com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

    static {
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public <T> T readValue(String value, Class<T> valueType) {
        try {
            return mapper.readValue(value, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Json mapping error: " + e.getMessage());
        }
    }

    @Override
    public String writeValue(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Json mapping error: " + e.getMessage());
        }
    }
}
