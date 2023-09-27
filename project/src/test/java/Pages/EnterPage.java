package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class EnterPage {
    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "log-in")
    private WebElement signInBtn;

    @FindBy(className = "element-header")
    private WebElement elementHeader;

    private WebDriverWait wait;
    private SoftAssert softAssert;

    public EnterPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.softAssert = new SoftAssert();
    }

    public void enterToApp(String userName, String password) {
        wait.until(ExpectedConditions.visibilityOf(userNameInput)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();

        String elementText = wait.until(ExpectedConditions.visibilityOf(elementHeader)).getAttribute("innerHTML");

        // Assert that the Financial Page is shown
        softAssert.assertTrue(elementText.contains("Financial Overview"),
                "Failed to enter the Financial Page");
        softAssert.assertAll();
    }
}
