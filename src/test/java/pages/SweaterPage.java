package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SweaterPage {
    protected static WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='group_1']")
    private WebElement sizeButton;
    @FindBy(xpath = "//*[@id='group_1']/option[1]")
    private WebElement sizeS_select;
    @FindBy(xpath = "//*[@id='group_1']/option[2]")
    private WebElement sizeM_select;
    @FindBy(xpath = "//*[@id='group_1']/option[3]")
    private WebElement sizeL_select;
    @FindBy(xpath = "//*[@id='group_1']/option[4]")
    private WebElement sizeXL_select;

    @FindBy(xpath = "//*[@id='quantity_wanted']")
    private WebElement quantityInput;
    @FindBy(css = "button.btn-primary")
    private WebElement addToCartButton;
    @FindBy(css = "a.btn")
    private WebElement checkOutButton;
    @FindBy(css = ".regular-price")
    public WebElement regularPrice;
    @FindBy(css = ".current-price > span:nth-child(1)")
    public WebElement price;



    public boolean sizeCorrect(String size) {

        if (size.equalsIgnoreCase("S") == true || size.equalsIgnoreCase("M") == true
                || size.equalsIgnoreCase("L") == true || size.equalsIgnoreCase("XL") == true) {

            return true;
        } else {
            System.out.println("Nie ma takiego rozmiaru");
            return false;
        }
    }

    public boolean numberCorrect(int numbers) {

        if (numbers > 0) {
            return true;
        } else {
            System.out.println("niepoprawna liczba");
            return false;
        }
    }


    public void order(String size, int quantity) {
        sizeButton.click();

        if (size.equalsIgnoreCase("S")) {
            sizeS_select.click();
        }
        if (size.equalsIgnoreCase("M")) {
            sizeM_select.click();
        }
        if (size.equalsIgnoreCase("L")) {
            sizeL_select.click();
        }
        if (size.equalsIgnoreCase("Xl")) {
            sizeXL_select.click();
        }
        quantityInput.click();
        quantityInput.clear();
        String numbers = String.valueOf(quantity);
        quantityInput.sendKeys(numbers);
        addToCartButton.click();
        WebElement waitForCheckOutButton = new WebDriverWait(driver, 1)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn")));
        checkOutButton.click();


    }
}