package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverProvider {
    public static WebDriver getAndroidNativeAppDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.VERSION, "4.4.2");
        capabilities.setCapability("automationName", System.getProperty("automationName"));
        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("deviceName", System.getProperty("deviceName"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, System.getProperty("appPackage")); // This is package name of app
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, System.getProperty("appActivity")); // This is Launcher activity of app
        try {
            return new AndroidDriver(new URL(System.getProperty("hub")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getChrome() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.VERSION, "4.4.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("deviceName", "Android Emulator");
        try {
            return new AndroidDriver(new URL(System.getProperty("hub")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
