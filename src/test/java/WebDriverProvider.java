import com.codeborne.selenide.Browsers;
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

    private static WebDriver driver = new WebDriverProvider().get();

  private WebConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.baseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.isNull(config.getRemoteUrl())) {
            if (config.browser().equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else if (config.browser().equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        } else {
            if (config.browser().equals("chrome")) {
                return new RemoteWebDriver(config.getRemoteUrl(), new ChromeOptions());
            } else if (config.browser().equals("firefox")) {
                return new RemoteWebDriver(config.getRemoteUrl(), new FirefoxOptions());
            }
        }
        throw new NullPointerException("No such browser");
    }
}