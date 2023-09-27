package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.EnterPage;
import Pages.FinancialPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    private EnterPage enterPage;
    private FinancialPage financialPage;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize Pages
        enterPage = new EnterPage(driver);
        financialPage = new FinancialPage(driver);
    }

    @Test
    public void testPages() {
        driver.get("https://demo.applitools.com/");
        enterPage.enterToApp("testuser", "password123");
        financialPage.countNumberOfCompleteTransactions();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
