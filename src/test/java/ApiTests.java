import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

@Tag("api")
public class ApiTests {

    @Test
    @DisplayName("Тест на использование данных из пропертей")
    void checkApiSystemPropertiesTest() {
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        Assertions.assertEquals("http://demowebshop.tricentis.com", config.getBaseURI());
        Assertions.assertEquals("123", config.getToken());
    }

    @Test
    @DisplayName("Тест на использование данных из файла")
    void checkApiFileTest() {
        Paths.get("resources/config/secret.properties");

        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        Assertions.assertEquals("http://demowebshop.tricentis.com", config.getBaseURI());
        Assertions.assertEquals("123", config.getToken());
    }
}


