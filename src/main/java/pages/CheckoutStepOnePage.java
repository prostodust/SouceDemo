package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends HeaderPage {

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public static final By FIRSTNAME_INPUT = By.xpath("//*[@data-test='firstName']");
    public static final By LASTNAME_INPUT = By.xpath("//*[@data-test='lastName']");
    public static final By ZIPCODE_INPUT = By.xpath("//*[@id='postalCode']");
    public static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");

    public void openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void fillingInCustomerData(String firstname, String lastname, String zipcode) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipcode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

}