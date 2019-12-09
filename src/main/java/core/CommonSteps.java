package core;

import aspects.LogSelenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CommonSteps {
//    @LogSelenide
    @Step("click on element: '{locator.description}'")
    public static void clickOnElement(Locator locator) {
        $(locator.getBy()).click();
    }

    @Step("check text of element '{locator.description}'")
    public static void elementShouldHasText(Locator locator, String text) {
        $(locator.getBy()).shouldHave(text(text));
    }

    @Step("check element '{locator.description}' displayed")
    public static void elementShouldBeDisplayed(Locator locator) {
        $(locator.getBy()).shouldBe(visible);
    }

    @Step("collection of elements '{locator.description}' should has size more then")
    public static void elementsCollectionShouldHasSizeMoreThen(Locator locator, int size) {
        $$(locator.getBy()).shouldHave(sizeGreaterThan(size));
    }

    @Step("element '{locator.description}' of collection should has attribute with value")
    public static void elementOfCollectionShouldHasAttributeWithValue(Locator locator, int index, String attribute, String value) {
        $$(locator.getBy()).get(index).shouldHave(attribute(attribute, value));
    }

    @Step("fill field and press enter '{locator.description}' displayed")
    public static void fillFieldAndPressEnter(Locator locator, String text) {
        $(locator.getBy()).setValue(text).pressEnter();
    }

    @Step("fill field '{locator.description}' displayed")
    public static void fillField(Locator locator, String text) {
        $(locator.getBy()).setValue(text);
    }

    @Step("select radio button element '{locator.description}' by value '{value}'")
    public static void selectRadioButtonByValue(Locator locator, String value) {
        $(locator.getBy()).selectRadio(value);
    }

    @Step("context click on element '{locator.description}' by value '{value}'")
    public static void contextClick(Locator locator) {
        $(locator.getBy()).contextClick();
    }

    @Step("get attribute '{attribute}' of element '{locator.description}'")
    public static String getAttributeValue(Locator locator, String attribute) {
        return $(locator.getBy()).attr(attribute);
    }

    @Step("check element attribute value for element '{locator.description}'")
    public static void elementAttributeValueShouldBeEqual(Locator locator, String attribute, String value) {
        $(locator.getBy()).shouldHave(attribute(attribute, value));
    }

    @Step("check that element '{locator.description}' has attribute")
    public static void elementShouldHasAttribute(Locator locator, String attribute, String value) {
        $(locator.getBy()).shouldHave(attribute(attribute, value));
    }
}