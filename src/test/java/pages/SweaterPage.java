package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SweaterPage {
    private static WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='group_1']")
    private WebElement sizeBotton;
    @FindBy(xpath = "//*[@id='group_1']/option[2]")
    private WebElement sizeSelect;
    @FindBy(xpath = "//*[@id='quantity_wanted']")
    private WebElement quantityInput;
    @FindBy(css = "button.btn-primary")
    private WebElement addToCartButton;
    @FindBy(css = "a.btn")
    private WebElement checkOutButton;


    public void order(String quantinty) {
        sizeBotton.click();
        sizeSelect.click();
        quantityInput.click();
        quantityInput.clear();
        quantityInput.sendKeys(quantinty);
        addToCartButton.click();
        WebElement waitForButton = new WebDriverWait(driver, 1)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn")));
        checkOutButton.click();

    }
}