package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:resources/config/secret.properties",
        "classpath:config/api.properties"})
public interface ApiConfig extends Config {

    @Key("baseURI")
    @DefaultValue("http://demowebshop.tricentis.com")
        // сначала берутся данные из пропертей и если в пропертях пусто,
        // то берутся данные из default. Т.о. исключаются падения тестов из-за отсутствия данных.
    String getBaseURI();

    @Key("token")
    @DefaultValue("123")
    String getToken();
}
