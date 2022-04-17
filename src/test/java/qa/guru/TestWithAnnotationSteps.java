package qa.guru;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class TestWithAnnotationSteps {

    private static final String REPOSITORY = "AGordey/Homework-7-Allure";
    private static final int ISSUESNUMBER = 1;

    @Test
    public void testGithubIssueFailed() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsForTestWithAnnotationSteps steps = new WebStepsForTestWithAnnotationSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUESNUMBER);
    }
}







