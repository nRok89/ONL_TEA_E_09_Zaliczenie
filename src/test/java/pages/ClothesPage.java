package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {
    private static WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "category-3")
    private WebElement clothesBotton;
    @FindBy(xpath = "//article[2]")
    private WebElement sweaterChoice;
    @FindBy(xpath = "//article[2]/div/div/h2/a")
    private WebElement sweaterName;


    public void clothesSelection() {
        clothesBotton.click();
        sweaterChoice.click();

    }

//    public String getSweaterName() {
//        return sweaterName.getText();
//
//    }

}
