package commerce.util.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import commerce.model.list.ListResponse;
import commerce.model.list.pagination.Pagination;

import java.io.IOException;
import java.util.List;

public class CustomListDeserializer extends JsonDeserializer<ListResponse<?>> implements ContextualDeserializer {

    private JavaType valueType;

    private static final ObjectMapper mapper = new ObjectMapper();

    public CustomListDeserializer() {

    }

    public CustomListDeserializer(JavaType valueType) {
        this.valueType = valueType;
    }

    @Override
    public ListResponse<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TypeFactory typeFactory = ctxt.getTypeFactory();
        CollectionType listType = typeFactory.constructCollectionType(List.class, valueType);
        JsonNode node = p.getCodec().readTree(p);
        JsonParser parser = node.findValue("data").traverse(p.getCodec());
        List<?> listt = parser.getCodec().readValue(parser, listType);
        parser = node.findValue("pagination").traverse(p.getCodec());
        Pagination pagination = parser.getCodec().readValue(parser, Pagination.class);
        return new ListResponse<>(listt, pagination);
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JavaType valueType = ctxt.getContextualType();
        valueType = valueType.containedType(0);
        return new CustomListDeserializer(valueType);
    }
}
