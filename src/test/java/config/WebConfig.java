package config;

import org.aeonbits.owner.Config;

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("firefox")
    String getBrowser();

    @Key("baseUrl")
    @DefaultValue("https://qa.guru/")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
}
