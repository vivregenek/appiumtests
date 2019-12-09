package tests.nativeapps;

import com.codeborne.selenide.WebDriverRunner;
import core.AndroidDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

public class BaseNativeAppTest {

    @BeforeEach
    public void init() throws MalformedURLException {
        WebDriverRunner.setWebDriver(AndroidDriverProvider.getAndroidNativeAppDriver());
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
