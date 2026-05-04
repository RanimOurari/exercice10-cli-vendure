package ch.unifr.shopcli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void urlFromOptionHasPriorityOverEnv() {
        Config config = Config.fromArgsAndEnv("http://option-url", "http://env-url");
        assertEquals("http://option-url", config.getUrl());
    }

    @Test
    void urlFromEnvUsedWhenOptionMissing() {
        Config config = Config.fromArgsAndEnv(null, "http://env-url");
        assertEquals("http://env-url", config.getUrl());
    }

    @Test
    void defaultUrlWhenNothingProvided() {
        Config config = Config.fromArgsAndEnv(null, null);
        assertEquals("http://localhost:3000/shop-api", config.getUrl());
    }
}
