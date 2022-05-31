import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestBase {

    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserVersion = config.browserVersion();

        /*if (!config.getRemoteWebDriver().equals("")) {
            Configuration.remote = config.getRemoteWebDriver();
        }*/
    }


    @BeforeEach
    void openPage() {
        step("Открываем страницу для тестирования", () -> {
            open(config.baseUrl());
        });
    }

    @AfterEach
    void closePage() {
        Selenide.closeWebDriver();
    }
}


