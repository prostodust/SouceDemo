package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import utils.TestListener;

import java.time.Duration;

@Log4j2
@Listeners(TestListener.class)
abstract class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ProductSteps productSteps;
    CartSteps cartSteps;

    /**
     * Actions performed before each test
     */
    @BeforeMethod
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        initPages();
        String variable = "driver";
        log.info("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    /**
     * Actions performed after each test
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    /**
     * Initializing pages
     */
    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
    }
}
