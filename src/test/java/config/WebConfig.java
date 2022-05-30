package config;

import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;

public interface WebConfig extends Config {

@Key("browser")
@DefaultValue("chrome")
Browser getBrowser();

@Key("baseUrl")
@DefaultValue("https://qa.guru/")
String getBaseUrl();

}
