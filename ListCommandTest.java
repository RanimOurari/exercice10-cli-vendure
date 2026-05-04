package ch.unifr.shopcli;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListCommandTest {

    @Test
    void listCommandReturnsProductsInTableFormat() {
        ProductRepository repo = new StaticProductRepository();
        ProductService service = new ProductService(repo);
        ProductFormatter formatter = new TableProductFormatter();
        ListCommand cmd = new ListCommand(service, formatter);

        int exitCode = cmd.call();
        assertEquals(0, exitCode);

        String output = cmd.getLastOutput();
        assertTrue(output.contains("Name"));
        assertTrue(output.contains("Price"));
        assertTrue(output.contains("Coffee"));
    }

    @Test
    void listCommandReturnsProductsInJsonFormat() {
        ProductRepository repo = new StaticProductRepository();
        ProductService service = new ProductService(repo);
        ProductFormatter formatter = new JsonProductFormatter();
        ListCommand cmd = new ListCommand(service, formatter);

        int exitCode = cmd.call();
        assertEquals(0, exitCode);

        String output = cmd.getLastOutput();
        assertTrue(output.trim().startsWith("["));
        assertTrue(output.contains("\"name\""));
    }
}
