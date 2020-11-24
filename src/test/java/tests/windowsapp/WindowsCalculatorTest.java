package tests.windowsapp;

import com.codeborne.selenide.WebDriverRunner;
import core.AndroidDriverProvider;
import io.appium.java_client.windows.WindowsDriver;
import locators.CalculatorLocators;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static core.CommonSteps.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static locators.GoogleSearchLocators.*;

public class WindowsCalculatorTest {

    @BeforeEach
    public void init() {
        WebDriverRunner.setWebDriver(AndroidDriverProvider.getWindowsCalculator());
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    @DisplayName("Check google search")
    public void checkSumFunction() {
        clickOnElement(CalculatorLocators.DIGIT_1W);
        clickOnElement(CalculatorLocators.DIGIT_PLUSW);
        clickOnElement(CalculatorLocators.DIGIT_2W);
        clickOnElement(CalculatorLocators.DIGIT_EQUALW);
        elementShouldHasText(CalculatorLocators.DIGIT_RESULTW, "3");
    }
}
