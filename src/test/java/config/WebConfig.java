package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${env}.properties")
public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://qa.guru/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("selenoidUrl")
    String getSelenoidUrl();
}
