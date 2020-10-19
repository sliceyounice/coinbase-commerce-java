package commerce.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import kong.unirest.GenericType;
import kong.unirest.ObjectMapper;

public class JsonMapper implements ObjectMapper {

    private static final com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

    private static final com.fasterxml.jackson.databind.ObjectMapper unwrappingMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    static {
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        unwrappingMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        unwrappingMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        unwrappingMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public <T> T readValue(String value, Class<T> valueType) {
        try {
            JsonRootName annotation = valueType.getAnnotation(JsonRootName.class);
            if (annotation != null) {
               return unwrappingMapper.readValue(value, valueType);
            }
            else {
                return mapper.readValue(value, valueType);
            }

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

    @Override
    public <T> T readValue(String value, GenericType<T> genericType) {
        try {
            JavaType type = mapper.constructType(genericType.getType());
            return mapper.readValue(value,  type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Json mapping error: " + e.getMessage());
        }
    }
}
