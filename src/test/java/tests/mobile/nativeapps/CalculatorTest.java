package tests.mobile.nativeapps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.CommonSteps.*;
import static core.CommonSteps.elementShouldHasText;
import static locators.CalculatorLocators.*;

public class CalculatorTest extends BaseNativeAppTest {

    @Test
    @DisplayName("Check sum function of calculator")
    public void sumTest() {
        clickOnElement(DIGIT_2);
        clickOnElement(SUM);
        clickOnElement(DIGIT_4);
        elementShouldHasText(OPERATIONS_FOR_CALCULATIONS_FIELD, "6");
        clickOnElement(EQUAL);
        elementShouldHasText(RESULT_OF_CALCULATION_FIELD, "6");
    }
}
