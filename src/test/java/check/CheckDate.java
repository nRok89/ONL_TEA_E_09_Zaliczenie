package check;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.UserDataPages;

public class CheckDate extends UserDataPages {


    public CheckDate(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='address-footer']/a[1]")
    private WebElement updateLink;


    @Override
    public String getAlias() {
        return aliasInput.getAttribute("value");
    }

    public String getAddress() {
        return address1Input.getAttribute("value");
    }

    public String getPostCode() {
        return postcodeInput.getAttribute("value");
    }

    public String getCity() {
        return cityInput.getAttribute("value");
    }

    public String getPhone() {
        return phoneInput.getAttribute("value");
    }


    public String getCountry(){
        return countryChoose.getText();

    }
    public void startCheck(){
        updateLink.click();
    }


    public void endCheck(){
        driver.navigate().back();
    }

}
