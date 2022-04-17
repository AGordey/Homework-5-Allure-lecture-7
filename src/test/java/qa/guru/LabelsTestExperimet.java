package qa.guru;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;

public class LabelsTestExperimet {

    @Test
    @Owner("AGordey")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("ISSUES для репозитория")
    @Story("Просмотр ISSUES в репозитории")
    @DisplayName("Учебное тестирование")
    @Link(value = "Ссылка на тестируемый ресурс", url = "https://github.com")
    public void testAnnotated() {
    }
}
