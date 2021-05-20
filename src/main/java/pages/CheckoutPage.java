package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public CheckoutPage openPage(String url) {
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
    public CheckoutPage fillingCustomerData(String firstname, String lastname, String zipcode) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        zipCodeInput.sendKeys(zipcode);
        continueButton.click();
        return this;
    }

    /**
     * Get the text Item total amount
     * @return item total
     */
    public String getTheTextItemTotal() {
        return itemTotalAmount.getText();
    }

    /**
     * Get the text Tax amount
     * @return tax
     */
    public String getTheTextTax() {
        return taxAmount.getText();
    }

    /**
     * Get the text Total amount
     * @return total
     */
    public String getTheTextTotal() {
        return totalAmount.getText();
    }

    /**
     * Pressing the button finish
     */
    public CheckoutPage clickFinishButton() {
        finishButton.click();
        return this;
    }

    /**
     * Get checkout complete text
     * @return complete text
     */
    public String getCheckoutCompleteText() {
        return completeText.getText();
    }
}