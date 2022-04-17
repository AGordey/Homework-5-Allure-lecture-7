package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class TestWithAnnotationSteps {

    private static final String REPOSITORY = "AGordey/Homework-7-Allure";
    private static final int ISSUESNUMBER = 1;

    @Test
    public void testGithubIssueFailed() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Переход на Github", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория с ISSUE " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("AGordey/Homework-7-Allure");
            $(".header-search-input").submit();
        });
        step("Преходим из выдачи поиска искомому репозиторию: " + REPOSITORY, () -> {
            $(linkText("AGordey/Homework-7-Allure")).click();
        });
        step("Переходим во вкладку ISSUES", () -> {
            $(partialLinkText("Issues")).click(); // добавил цифру 100 для ошибки теста
        });
        step("Поиск ISSUES с номером #" + ISSUESNUMBER, () -> {
            $(withText("#" + ISSUESNUMBER)).should(Condition.visible);
        });
    }
}







