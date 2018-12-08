package au.com.cuke.ui.core.Utils;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The helper class provides common utility methods required application
 *
 */
public class Helpers {

    public static List getResourcesPath() {
        List<String> strings = new LinkedList<>();
        strings.add("src");
        strings.add("test");
        strings.add("resources");
        strings.add("drivers");

        return strings;
    }

    public static String getChromeDriverPath() {
        List<String> strings = getResourcesPath();
        strings.add(SystemUtils.IS_OS_WINDOWS ? "chromedriver.exe" : "chromedrivermac");

        return String.join(File.separator, strings);

    }

    public static String getFirefoxDriverPath() {
        List<String> strings = getResourcesPath();
        strings.add(SystemUtils.IS_OS_WINDOWS ? "geckodriver.exe" : "geckodrivermac");

        return String.join(File.separator, strings);

    }


    public static Object nonNullGet(Map map, Object key) {
        assertThat(map.get(key))
                .withFailMessage("Map key='%s' does not exist in: %s", key, map.keySet())
                .isNotNull();
        return map.get(key);
    }


}
