package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    private static WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "account")
    private WebElement accountButton;
    @FindBy(id = "history-link")
    private WebElement historyButton;

    @FindBy(xpath = "//tbody/tr[1]/th")
    private WebElement orderHistryLast;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement priceHistryLast;

    @FindBy(xpath = "//tbody/tr[1]/td[4]/span")
    private WebElement awaitingCheckInf;


    public String getAwaitingCheckInf() {
        String oneLineStatus = awaitingCheckInf.getText().replace("\n", "");
        return oneLineStatus;

    }


    public void orderHistory() {
        accountButton.click();
        historyButton.click();

    }

    public String getOrderHistorylast() {
        return orderHistryLast.getText();
    }

    public String getPriceHistryLast() {
        return priceHistryLast.getText();


    }
}