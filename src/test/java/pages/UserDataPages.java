package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserDataPages {
    protected static WebDriver driver;


    public UserDataPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "address-link")
    public WebElement addressButton;
    @FindBy(name = "alias")
    public WebElement aliasInput;
    @FindBy(name = "address1")
    public WebElement address1Input;
    @FindBy(name = "postcode")
    public WebElement postcodeInput;
    @FindBy(name = "city")
    public WebElement cityInput;
    @FindBy(name = "phone")
    public WebElement phoneInput;
    @FindBy(name = "id_country")
    private WebElement countrySelect;
    @FindBy(xpath = "//*[@name='id_country']/option[2]")
    public WebElement countryChoose;

    @FindBy(css = "button.btn")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@role='alert']/ul/li")
    private WebElement alertSuccess;

    @FindBy(xpath = ("//*[@class='address-body']/address"))
    private WebElement addressResult;
    @FindBy(xpath = "//*[@class='address-body']/h4")
    private WebElement aliasResult;


    @FindBy(xpath = ("//*[@class='address-footer']/a[2]"))
    private WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"address-link\"]/span")
    private WebElement addAddressButtonSpan;


    public void address(String alias, String address, String city, String code, String phone, String country) {
        addressButton.click();
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        address1Input.click();
        address1Input.clear();
        address1Input.sendKeys(address);
        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(code);
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
        countrySelect.click();
        countryChoose.sendKeys(country);
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        saveButton.click();
    }

    public String getAddress() {

        return addressResult.getText();
    }

    public String getAlertSuccess() {
        return alertSuccess.getText();
    }

    public String getAlias() {
        return aliasResult.getText();
    }

    public void deleteAddress() {
        deleteButton.click();

    }

    public String getNameBottomAddFirst() {
        return addAddressButtonSpan.getText();

    }
}