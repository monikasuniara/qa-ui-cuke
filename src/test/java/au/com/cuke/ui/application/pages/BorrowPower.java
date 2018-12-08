package au.com.cuke.ui.application.pages;

import au.com.cuke.ui.core.Utils.Helpers;
import au.com.cuke.ui.core.ui.AppPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * The page object class for Borrowing Power page
 * It encapsulate all its web elements and their behaviors.
 *
 */

public class BorrowPower extends AppPage {

    public static enum InputWebElements {
        PROPERTYBUYINGFOR,
        SINGLE,
        JOINT,
        DEPENDENTS,
        HOME,
        INVESTMENT,
        INCOME,
        OTHERINCOME,
        SECONDAPPLICANTINCOME,
        SECONDAPPLICANTOTHERINCOME,
        LIVINGEXPENSES,
        CURRENTHOMELOAN,
        OTHERLOANPAYMENTS,
        OTHERCOMMITMENTS,
        TOTALLOANPAYMENTS,
        CREDITCARDLIMIT;
    }

    @CacheLookup
    @FindBy(className = "btn--borrow__calculate")
    private WebElement borrownBtn;

    @CacheLookup
    @FindBy(id = "application_type_single")
    private WebElement typeSingle;

    @CacheLookup
    @FindBy(id = "application_type_joint")
    private WebElement typeJoint;

    @CacheLookup
    @FindBy(css = "select[title = 'Number of dependants']")
    private WebElement noOfDependents;

    @CacheLookup
    @FindBy(id = "borrow_type_home")
    private WebElement typeHome;

    @CacheLookup
    @FindBy(id = "borrow_type_investment")
    private WebElement typeInvestment;


    @CacheLookup
    @FindBy(xpath = "//input[@aria-labelledby='q2q1']")
    private WebElement income;

    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q2q2']")
    private WebElement otherIncome;

    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q2q3']")
    private WebElement secondApplicantIncome;

    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q2q4']")
    private WebElement secondApplicantOtherIncome;

    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q3q1']")
    private WebElement livingExpenses;

    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q3q2']")
    private WebElement currentHomeLoan;

    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q3q3']")
    private WebElement loanRepayment;


    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q3q4']")
    private WebElement otherCommitments;

    @CacheLookup
    @FindBy(css = "input[aria-labelledby = 'q3q5']")
    private WebElement totalCreditCardLimits;

    By errorMessage = By.className("borrow__error__text");
    By startOver = By.cssSelector("div.text--white > div.box--right > button");


    private WebDriver commonDriver;

    public BorrowPower(WebDriver commonDriver) {
        super(commonDriver);
        this.commonDriver = commonDriver;
    }

    public void load(String pageUrl) {
        super.load(pageUrl);
        verifyLoaded();
    }

    public void verifyLoaded() {
        getDriverWait().until(visibilityOf(borrownBtn));
        Assertions.assertThat(borrownBtn.isDisplayed())
                .withFailMessage("could not load how much borrow page")
                .isTrue();
    }

    /**
     * Method gets list page element names defined using Enum
     * If testdata contains the web element then it handled as per their type
     * otherwise they are simply skipped
     * This method gives provision to handle any number of web elements existing in this page
     * without rewriting code for each one.
     *
     * @param testData
     */
    public void enterValues(Map<InputWebElements, Object> testData) {
        try {
            if (testData.containsKey(InputWebElements.SINGLE)) {
                typeSingle.click();
            }

            if (testData.containsKey(InputWebElements.JOINT)) {
                typeJoint.click();
            }

            if (testData.containsKey(InputWebElements.INVESTMENT)) {
                typeInvestment.click();
            }

            if (testData.containsKey(InputWebElements.INCOME)) {
                income.sendKeys(testData.get(InputWebElements.INCOME).toString());
            }

            if (testData.containsKey(InputWebElements.LIVINGEXPENSES)) {
                livingExpenses.sendKeys(testData.get(InputWebElements.LIVINGEXPENSES).toString());
            }

            if (testData.containsKey(InputWebElements.OTHERINCOME)) {
                otherIncome.sendKeys(testData.get(InputWebElements.OTHERINCOME).toString());
            }

            if (testData.containsKey(InputWebElements.SECONDAPPLICANTINCOME)) {
                secondApplicantIncome.sendKeys(testData.get(InputWebElements.SECONDAPPLICANTINCOME).toString());
            }

            if (testData.containsKey(InputWebElements.SECONDAPPLICANTOTHERINCOME)) {
                secondApplicantOtherIncome.sendKeys(testData.get(InputWebElements.INCOME).toString());
            }

            if (testData.containsKey(InputWebElements.SECONDAPPLICANTOTHERINCOME)) {
                secondApplicantOtherIncome.sendKeys(testData.get(InputWebElements.SECONDAPPLICANTOTHERINCOME).toString());
            }

            if (testData.containsKey(InputWebElements.CURRENTHOMELOAN)) {
                currentHomeLoan.sendKeys(testData.get(InputWebElements.CURRENTHOMELOAN).toString());
            }

            if (testData.containsKey(InputWebElements.OTHERLOANPAYMENTS)) {
                loanRepayment.sendKeys(testData.get(InputWebElements.OTHERLOANPAYMENTS).toString());
            }

            if (testData.containsKey(InputWebElements.OTHERCOMMITMENTS)) {
                otherCommitments.sendKeys(testData.get(InputWebElements.OTHERCOMMITMENTS).toString());
            }

            if (testData.containsKey(InputWebElements.CREDITCARDLIMIT)) {
                totalCreditCardLimits.sendKeys(testData.get(InputWebElements.CREDITCARDLIMIT).toString());
            }

            if (testData.containsKey(InputWebElements.DEPENDENTS)) {
                String depStr = (String) Helpers.nonNullGet(testData, InputWebElements.DEPENDENTS);
                int dep = Integer.valueOf(depStr);
                Assertions.assertThat(dep)
                        .isGreaterThanOrEqualTo(0)
                        .isLessThan(5);

                Select select = new Select(noOfDependents);
                select.selectByIndex(dep);

            }


        } catch (Exception e) {
            System.out.println("An unknown error: " + e.getMessage());
        }

    }

    /**
     * Start Over button is appears after ajax call, until that time this is kept hidden in form
     * Hence method waits until it becomes clickable and then click button
     * If wait times out then assertion fails and aborts the execution
     *
     */
    public void clearForm() {
        try {
            WebElement startOverBtn = getDriverWait().until(ExpectedConditions.elementToBeClickable(startOver));
            startOverBtn.click();

        } catch (NoSuchElementException e) {
            Assertions.assertThat( e.getMessage())
            .withFailMessage("Wait timed out. Could not find start over button, page not refreshed")
            .isBlank();
        }

    }

    /**
     * The method validates the form is reset correctly to default values.
     * If exits if default radio buttons are not selected
     * Otherwise it gets text from all input type elements
     * and get value of dropdown box
     * if at the the no text is appended to input variable
     * that means the form is reset correctly and method returns true
     *
     * Get the text in all input elements
     *
     * @return
     */
    public boolean verifyReset() {
        String input = "";

        //return if radio button options are not correct selections
        if (!typeSingle.isSelected() || !typeHome.isSelected())
        {
            return false;
        }

        input += income.getText();
        input += livingExpenses.getText();
        input += otherIncome.getText();
        input += secondApplicantIncome.getText();
        input += secondApplicantOtherIncome.getText();
        input += secondApplicantOtherIncome.getText();
        input += currentHomeLoan.getText();
        input += loanRepayment.getText();
        input += otherCommitments.getText();
        input += totalCreditCardLimits.getText();

        Select select = new Select(noOfDependents);
        WebElement selected = select.getFirstSelectedOption();
        input += selected.getText().equals("0") ? "" : selected.getText();

        return input.isEmpty();

    }

    public void calculate() {
        borrownBtn.click();
    }

    /**
     * The error message is loaded using ajax call
     * Hence method wait until element appears on screen and then read and return the error message
     * If wait times out then assertion fails and aborts the execution
     * @return
     */
    public String getErrorMessage() {
        String message = "";
        try {
            WebElement errorDiv = getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            message = errorDiv.getText();
        } catch (NotFoundException e) {
            Assertions.assertThat( e.getMessage())
                    .withFailMessage("Wait timed out. Unable to find error message div")
                    .isBlank();
        } finally {
            return message;
        }
    }


}
