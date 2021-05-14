package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends HeaderPage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static final By FIRSTNAME_INPUT = By.xpath("//*[@data-test='firstName']");
    public static final By LASTNAME_INPUT = By.xpath("//*[@data-test='lastName']");
    public static final By ZIPCODE_INPUT = By.xpath("//*[@data-test='postalCode']");
    public static final By CONTINUE_BUTTON = By.xpath("//*[@data-test='continue']");

    public static final By ITEM_TOTAL_AMOUNT = By.xpath("//*[@class='summary_subtotal_label']");
    public static final By TAX_AMOUNT = By.xpath("//*[@class='summary_tax_label']");
    public static final By TOTAL_AMOUNT = By.xpath("//*[@class='summary_total_label']");
    public static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");

    public static final By COMPLETE_TEXT = By.xpath("//*[@class='header_secondary_container']/span");

    /**
     * Open page
     *
     * @param url the url
     */
    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * Filling in customer data
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param zipcode   the zipcode
     */
    public void fillingCustomerData(String firstname, String lastname, String zipcode) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipcode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

}