package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class FinancialPage {
    @FindBy(className = "nowrap")
    private List<WebElement> transactionsList;

    private WebDriverWait wait;
    private SoftAssert softAssert;
    private int countNumberOfCompleteTransactions;

    public FinancialPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.softAssert = new SoftAssert();
    }

    public void countNumberOfCompleteTransactions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(transactionsList));
        for (WebElement transaction : transactionsList) {
            if (transaction.getAttribute("innerText").contains("Complete")) {
                countNumberOfCompleteTransactions++;
            }
        }

        // Assert that the number of complete transactions is 2
        softAssert.assertTrue(countNumberOfCompleteTransactions == 2,
                "The number of complete transactions is incorrect");
        softAssert.assertAll();
    }
}
