package au.com.cuke.ui.core.ui;

import au.com.cuke.ui.core.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * The parent class for all Page Object classes.
 * This class takes care of set up of web driver, wait and initialize page
 *
 */
public class AppPage {
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;
    public WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;

    public AppPage(WebDriver commonDriver) {
        driver = commonDriver;
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        baseUrl = Config.baseUrl();
        PageFactory.initElements(driver, this);
    }

    public void load(String pageUrl) {
        driver.get(baseUrl + pageUrl);
    }

    public WebDriverWait getDriverWait() {
        getDriverWait(DEFAULT_TIMEOUT_SECONDS);
        return wait;
    }

    public WebDriverWait getDriverWait(int timeout) {
        if (wait == null) {
            wait = new WebDriverWait(driver, timeout);
        }
        return wait;
    }
}
