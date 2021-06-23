package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

@Log4j2
public class CheckoutPage extends HeaderPage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@data-test='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@data-test='postalCode']")
    WebElement zipCodeInput;

    @FindBy(xpath = "//*[@data-test='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//*[@class='summary_subtotal_label']")
    WebElement itemTotalAmount;

    @FindBy(xpath = "//*[@class='summary_tax_label']")
    WebElement taxAmount;

    @FindBy(xpath = "//*[@class='summary_total_label']")
    WebElement totalAmount;

    @FindBy(xpath = "//*[@id='finish']")
    WebElement finishButton;

    @FindBy(xpath = "//*[@class='header_secondary_container']/span")
    WebElement completeText;

    /**
     * Open page
     *
     * @param url the url
     */
    @Step("Opening checkout page")
    public CheckoutPage openPage(String url) {
        log.info("Opening the checkout page at " + url);
        driver.get(url);
        return this;
    }

    /**
     * Filling in customer data
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param zipcode   the zipcode
     */
    @Step("Fill in {firstname}, {lastname} and {zipcode} in checkout page")
    public CheckoutPage fillingCustomerData(String firstname, String lastname, String zipcode) {
        log.info("Fill in <" + firstname + ">, <" + lastname + "> and <" + zipcode + "> in checkout page");
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        zipCodeInput.sendKeys(zipcode);
        continueButton.click();
        return this;
    }

    /**
     * Get the text Item total amount
     *
     * @return item total
     */
    public String getTotalItemsText() {
        log.info("Get the text <Item total amount>");
        String textItemTotalAmount = itemTotalAmount.getText();
        log.info("Return text: " + textItemTotalAmount);
        return textItemTotalAmount;
    }

    /**
     * Get the text Tax amount
     *
     * @return tax
     */
    public String getTaxText() {
        log.info("Get the text <Tax amount>");
        String textTaxAmount = taxAmount.getText();
        log.info("Return text: " + textTaxAmount);
        return textTaxAmount;
    }

    /**
     * Get the text Total amount
     *
     * @return total
     */
    public String getTotalText() {
        log.info("Get the text <Total amount>");
        String textTotalAmount = totalAmount.getText();
        log.info("Return text: " + textTotalAmount);
        return textTotalAmount;
    }

    /**
     * Pressing the button finish
     */
    public CheckoutPage clickFinishButton() {
        log.info("Pressing the button <Finish>");
        finishButton.click();
        return this;
    }

    /**
     * Get checkout complete text
     *
     * @return complete text
     */
    public String getCheckoutCompleteText() {
        log.debug("Get checkout complete text");
        return completeText.getText();
    }

    /**
     * Waiting for the page to open
     */
    public CheckoutPage waitForPageOpened() {
        log.debug("Waiting for the page to open");
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement foo = fluent.until(driver -> completeText);
        return this;
    }
}