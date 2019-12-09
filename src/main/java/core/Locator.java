package core;

import org.openqa.selenium.By;

public interface Locator {
    public By getBy();
    public String getDescription();
}
