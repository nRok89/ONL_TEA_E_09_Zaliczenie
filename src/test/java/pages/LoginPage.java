package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".user-info > a:nth-child(1)")
    private WebElement singInButton;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private WebElement submitButton;



    public void myStoreLogin(String email, String password) {
        singInButton.click();
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}


