package locators;

import core.Locator;
import io.appium.java_client.MobileBy;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public enum CalculatorLocators implements Locator {
    DIGIT_2(By.id("digit_2"), "digit 2 button"),
    DIGIT_1W(By.name("One"), "digit 2 button"),
    DIGIT_2W(By.name("Two"), "digit 2 button"),
    DIGIT_PLUSW(By.name("Plus"), "digit 2 button"),
    DIGIT_EQUALW(By.name("Equals"), "digit 2 button"),
    DIGIT_RESULTW(MobileBy.AccessibilityId("CalculatorResults"), "digit 2 button"),
    DIGIT_4(By.id("digit_4"), "digit 4 button"),
    SUM(By.id("op_add"), "sum button"),
    OPERATIONS_FOR_CALCULATIONS_FIELD(By.id("result"), "operations filed"),
    EQUAL( By.id("eq"), "equal button"),
    RESULT_OF_CALCULATION_FIELD(By.id("formula"), "result of operation field");

    private By by;
    private String description;

    CalculatorLocators(By by, String description) {
        this.by = by;
        this.description = description;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}
