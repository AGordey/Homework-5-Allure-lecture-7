package qa.guru;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class ClearSelenideWithAllureHowListener {


    @Test
    public void testGithubIssueRight () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("AGordey/Homework-7-Allure");
        $(".header-search-input").submit();

        $(linkText("AGordey/Homework-7-Allure")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).click();
    }
    @Test
    public void testGithubIssueFailed () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("AGordey/Homework-7-Allure");
        $(".header-search-input").submit();

        $(linkText("AGordey/Homework-7-Allure")).click();
        $(partialLinkText("Issues100")).click(); // добавил цифру 100 для ошибки теста
        $(withText("#1")).click();
    }
}







