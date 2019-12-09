package locators;

import core.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public enum GoogleSearchLocators implements Locator {
    SEARCH_FIELD(By.cssSelector("[name=q][type=search]"), "search field"),
    SEARCH_RESULT_LIST(By.cssSelector("div#rso"), "list with search results"),
    SEARCH_RESULT_ELEMENTS_LINK(By.cssSelector("[oncontextmenu='google.ctpacw.cm(this)']"), "link of search result element");

    private By by;
    private String description;

    GoogleSearchLocators(By by, String description) {
        this.by = by;
        this.description = description;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}
