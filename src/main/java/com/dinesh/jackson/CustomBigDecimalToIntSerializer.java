package jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public class CustomBigDecimalToIntSerializer extends JsonDeserializer<Long> {

    public CustomBigDecimalToIntSerializer() {
        super();
        System.out.println("true = " + true);
    }

    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println("true = " + true);
//        ctxt.getParser().currentName();
        return 1000L;
    }
}
