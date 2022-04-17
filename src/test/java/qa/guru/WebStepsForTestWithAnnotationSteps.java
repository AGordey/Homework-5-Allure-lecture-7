package qa.guru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebStepsForTestWithAnnotationSteps {

    @Step("Переход на Github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Поиск репозитория {repo} с ISSUE ")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step("Преходим из выдачи поиска искомому репозиторию: {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Переходим во вкладку ISSUES")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Поиск ISSUES с номером # {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

}

