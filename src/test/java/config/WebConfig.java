package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:config/${env}.properties")
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("baseUrl")
    @DefaultValue("https://qa.guru/")
    String baseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("remoteUrl")
    URL getRemoteUrl();

    @Key("remoteWebDriver")
    String getRemoteWebDriver();

}
