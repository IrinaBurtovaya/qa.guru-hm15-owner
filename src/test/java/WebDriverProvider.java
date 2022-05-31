import config.WebConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebConfig config; /*= ConfigFactory.create(WebConfig.class, System.getProperties());*/

    public WebDriverProvider() {

        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }



    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {

        if (Objects.isNull(config.selenoidUrl())) {
            if (config.getBrowser().equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else if (config.getBrowser().equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        } else {
            if (config.getBrowser().equals("chrome")) {
                return new RemoteWebDriver(config.selenoidUrl(), new ChromeOptions());
            } else if (config.getBrowser().equals("firefox")) {
                return new RemoteWebDriver(config.selenoidUrl(), new FirefoxOptions());
            }
        }
        throw new NullPointerException("No such browser");
    }
}