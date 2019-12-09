package tests.webapp;

import com.codeborne.selenide.WebDriverRunner;
import core.AndroidDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;
import static core.CommonSteps.*;
import static locators.GoogleSearchLocators.*;

public class ChromeTest {
    @BeforeEach
    public void init() throws MalformedURLException {
        WebDriverRunner.setWebDriver(AndroidDriverProvider.getChrome());
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    @DisplayName("Check google search")
    public void checkGoogleSearch() {
        open("https://google.com");
        elementShouldBeDisplayed(SEARCH_FIELD);
        fillFieldAndPressEnter(SEARCH_FIELD, "selenide");
        elementShouldBeDisplayed(SEARCH_RESULT_LIST);
        elementsCollectionShouldHasSizeMoreThen(SEARCH_RESULT_ELEMENTS_LINK, 3);
        elementOfCollectionShouldHasAttributeWithValue(SEARCH_RESULT_ELEMENTS_LINK, 0, "href", "https://selenide.org/");
        System.out.println("completed");
    }
}
