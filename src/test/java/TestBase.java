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

    static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();

        if (webConfig.getSelenoidUrl() != null) {
            Configuration.remote = webConfig.getSelenoidUrl();
        }
    }

    @BeforeEach
    void openPage() {
        step("Открываем страницу для тестирования", () -> {
            open(webConfig.getBaseUrl());
        });
    }

    @AfterEach
    void closePage() {
        Selenide.closeWebDriver();
    }
}


