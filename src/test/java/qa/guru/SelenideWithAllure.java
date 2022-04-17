package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideWithAllure {


    @Test
    public void testGithubIssue () {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("AGordey/Homework-7-Allure");
        $(".header-search-input").submit();

        $(linkText("AGordey/Homework-7-Allure")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).click();
    }

}







