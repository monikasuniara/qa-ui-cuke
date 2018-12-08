package au.com.cuke.ui.core.ui;

import au.com.cuke.ui.core.config.Config;
import org.openqa.selenium.WebDriver;

/**
 * This class initializes the browser instance based on
 * option opted at time of execution. Useful for cross browser testing
 */
class BrowserFactory {

    public static WebDriver getBrowser() throws Throwable {
        String desiredBrowserName = Config.desiredBrowser();
        WebDriver desiredBrowser = null;

        switch(desiredBrowserName) {
            case "chrome":
                desiredBrowser = ChromeBrowser.buildChromeBrowser();
                break;
            case "firefox":
                desiredBrowser = FirefoxBrowser.buildFirefoxBrowser();
                break;
            default:
                //work out what to do when a browser isn't needed
                break;
        }
        return desiredBrowser;
    }
}
