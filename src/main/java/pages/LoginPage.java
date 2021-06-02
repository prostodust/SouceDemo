package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@data-test='login-button']")
    WebElement loginButton;

    @FindBy(id = "login_button_container")
    WebElement errorMessage;

    @FindBy(xpath = "//*[@class='bot_column']")
    WebElement botLogo;

    /**
     * Open page
     *
     * @param url the url
     */
    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Login page
     *
     * @param username the username
     * @param password the password
     */
    public ProductsPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    /**
     * Getting an error message
     *
     * @return error text
     */
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param timeout the timeout
     */
    public LoginPage waitForElementBotLogoLocated(int timeout) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(botLogo));
        return this;
    }

}
