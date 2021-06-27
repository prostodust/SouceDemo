package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
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
    @Step("Opening login page")
    public LoginPage openPage(String url) {
        log.info("Opening the login page at " + url);
        driver.get(url);
        return this;
    }

    /**
     * Login page
     *
     * @param username the username
     * @param password the password
     */
    @Step("Fill in {username} and {password} in login page")
    public ProductsPage login(String username, String password) {
        log.info("Fill in username <" + username + "> in login page");
        usernameInput.sendKeys(username);
        log.info("Fill in password <" + password + "> in login page");
        passwordInput.sendKeys(password);
        log.info("Pressing the button <Login>");
        loginButton.click();
        log.info("Went to the products page");
        return new ProductsPage(driver);
    }

    /**
     * Getting an error message
     *
     * @return error text
     */
    public String getErrorMessageText() {
        log.info("Getting an error message");
        return errorMessage.getText();
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param timeout the timeout
     */
    public LoginPage waitForElementBotLogoLocated(int timeout) {
        log.debug("Waiting for an element to load in login page during a <" + timeout + "> second");
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(botLogo));
        return this;
    }
}
