package au.com.cuke.ui.stepDefinition;

import au.com.cuke.ui.application.pages.BorrowPower;
import com.google.common.base.Enums;
import com.google.common.base.Optional;
import cucumber.api.DataTable;
import cucumber.api.java8.En;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class borrowingPowerStepdefs implements En {
    private Map<String, Object> testData = new HashMap<>();
    private Map<BorrowPower.InputWebElements, Object> filteredTestData = new HashMap<>();
    private BorrowPower calcPage;

    public borrowingPowerStepdefs(BorrowPower borrowPower) {
        calcPage = borrowPower;

        Given("^Customer is on \"([^\"]*)\"$", (String pageUrl) -> {
            calcPage.load(pageUrl);
        });
        When("^Customer works out how much he could borrow based on details$", (DataTable table) -> {
            testData = table.asMap(String.class, Object.class);
            testData.forEach((k, v) -> {
                String key = k.replaceAll("_", "").toUpperCase();
                Optional<BorrowPower.InputWebElements> element = Enums.getIfPresent(BorrowPower.InputWebElements.class, key);
                assertThat(element.isPresent())
                        .withFailMessage(k + " does not exist in Borrow Calculation page, " +
                                "please check elements and pass correct options")
                        .isTrue();
                filteredTestData.put(element.get(), v);

            });

            calcPage.enterValues(filteredTestData);
            calcPage.calculate();

        });

        But("^Chooses to start over again$", () -> {
            calcPage.clearForm();
        });

        Then("^All the fields in form are reset$", () -> {
            assertThat(calcPage.verifyReset())
                    .withFailMessage("All the fields were expected to reset, but fields are not reset correctly")
                    .isTrue();
        });

        Then("^Customer gets error message \"([^\"]*)\"$", (String expected) -> {
            String actual = calcPage.getErrorMessage();
            assertThat(actual)
                    .withFailMessage(String.format("Expected %s, but got %s", expected, actual))
                    .isEqualToIgnoringCase(expected);
        });

    }
}
