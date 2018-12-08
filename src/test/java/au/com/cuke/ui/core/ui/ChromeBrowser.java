package au.com.cuke.ui.core.ui;

import au.com.cuke.ui.core.Utils.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

class ChromeBrowser extends ChromeDriver {
    public static WebDriver buildChromeBrowser() throws Throwable {

        return getLocalDriver();

    }

    private ChromeBrowser(ChromeOptions capabilities) {
        super(capabilities);
    }

    private static WebDriver getLocalDriver() {
        System.setProperty("webdriver.chrome.driver", Helpers.getChromeDriverPath());
        ChromeBrowser browser = new ChromeBrowser(getExtraOptions());
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.navigate().refresh();
        System.out.println("Refresh successfully");
        return browser;
    }

    private static ChromeOptions getExtraOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--kiosk");
        return options;
    }

}
