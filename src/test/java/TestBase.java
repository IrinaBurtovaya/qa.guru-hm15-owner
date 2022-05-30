import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestBase {

    private WebDriver driver = new WebDriverProvider().get();
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    //static String selenoid = System.getProperty("selenoid", "selenoid.autotests.cloud/wd/hub");

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browser = config.getBrowser().name;
        Configuration.baseUrl = config.getBaseUrl();
        // Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + selenoid;
    }

    @BeforeEach
    void openPage() {
        step("Открываем страницу для тестирования", () -> {
            open(config.getBaseUrl());
        });
    }

    @AfterEach
    void closePage() {
        closeWebDriver();
    }
}

