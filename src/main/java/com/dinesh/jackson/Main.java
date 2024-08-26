package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Long.class, new CustomBigDecimalToIntSerializer());

        objectMapper.registerModule(simpleModule);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    public static void main(String[] args) throws Exception {
        ObjectWriter objectWriter = objectMapper.writer();
        User user = new User();
        user.setHeight(null);
        user.setDateOfBirth(LocalDateTime.of(2000, 7, 25, 9, 30));
        String result = objectWriter.writeValueAsString(user);
        objectMapper.reader().readValues("");
        System.out.println("result = " + result);
    }
}
