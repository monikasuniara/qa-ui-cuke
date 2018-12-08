package au.com.cuke.ui.core.config;

import org.assertj.core.api.Assertions;

/**
 * This class handles the system properties passed in environment variables
 */
public class Config {

    private static final String ENV_BASE_URL = "cuke_BASE_URL";
    private static final String BROWSER = "cuke_browser";
    private static final String DEFAULT_BROWSER = "chrome";

    public static String baseUrl() {
        String baseUrl = System.getProperty(ENV_BASE_URL);
        verifyExists(baseUrl, ENV_BASE_URL);
        return baseUrl;
    }

    private static void verifyExists(String var, String envVarName) {
        Assertions.assertThat(var).withFailMessage(envVarName + " env var is not provided").isNotNull();
    }

    public static String desiredBrowser() {
        return System.getProperty(BROWSER, DEFAULT_BROWSER);
    }



}
