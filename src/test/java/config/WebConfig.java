package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:config/${env}.properties")
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("baseUrl")
    @DefaultValue("https://qa.guru/")
    String getBaseUrl();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    URL getRemoteUrl();

    @Key("remoteWebDriver")
    String getRemoteWebDriver();

}
