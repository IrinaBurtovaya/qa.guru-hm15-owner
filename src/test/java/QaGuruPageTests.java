import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class QaGuruPageTests extends TestBase {
    QaGuruPage qaGuruPage = new QaGuruPage();

    @Tag("mainPageTest")
    @Test
    @DisplayName("Тест на открытие главной страницы сайта qa.guru")
    void mainPageHasBeenOpened() {
        step("Проверяем открытие страницы", () -> {
            qaGuruPage.schoolDescription.shouldHave(Condition.text("Школа инженеров по автоматизации тестирования"));
        });
    }

    @Test
    @DisplayName("Тест на открытие программы обучения")
    void scheduleHasBeenOpened() {
        step("Открываем программу обучения", () -> {
            qaGuruPage.openSchedule.click();
        });
        step("Открывается модальное окно", () -> {
            switchTo().window(0);
        });
        step("Проверяем название программы", () -> {
            qaGuruPage.scheduleName.shouldHave(Condition.text("Программа"));
        });
        step("Закрываем программу обучения", () -> {
            qaGuruPage.closeSchedule.click();
        });
    }

    @Test
    @DisplayName("Тест на проверку перехода в ВК")
    void vkTest() {
        step("Кликаем по иконке социальной сети ВК", () -> {
            qaGuruPage.vkIcon.scrollIntoView(true).click();
        });
        step("Переходим на страницу в ВК", () -> {
            switchTo().window(1);
        });
        step("Проверяем, что находимся на нужной странице в ВК", () -> {
            webdriver().shouldHave(url("https://vk.com/qa.guru"));
        });
        step("Возвращаемся на исходную страницу", () -> {
            switchTo().window(0);
        });
    }

    @Test
    @DisplayName("Тест на авторизацию с невалидными кредами")
    void authWithWrongCredentials() {
        step("Открываем страницу авторизации", () -> {
            qaGuruPage.loginButton.click();
        });
        step("Заполняем форму", () -> {
            qaGuruPage.emailField.setValue("test");
            qaGuruPage.passwordField.setValue("test");
        });
        step("Осуществляем вход в систему", () -> {
            qaGuruPage.doLogin.click();
        });
        step("Проверяем, что авторизация прошла неуспешно", () -> {
            qaGuruPage.errorMsg.shouldHave(Condition.text("Неверный формат e-mail"));
            switchTo().window(0);
        });
    }
}
