package ch.unifr.shopcli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JsonProductFormatter implements ProductFormatter {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String format(List<Product> products) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize products to JSON", e);
        }
    }
}
