package au.com.cuke.ui.core.ui;

import au.com.cuke.ui.core.Utils.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxBrowser extends FirefoxDriver {

    public static WebDriver buildFirefoxBrowser() {
            return getLocalDriver();
    }

    private FirefoxBrowser() {
        super();
    }

    private static WebDriver getLocalDriver() {
        System.setProperty("webdriver.gecko.driver", Helpers.getFirefoxDriverPath());
        FirefoxBrowser browser = new FirefoxBrowser();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }
}
