package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.UserDataPages;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class UserDataSteps {
    private WebDriver driver;

    @Given("przegladarka otwarta na stronie mystore-testlab.coderslab.pl")
    public void openCodersLab() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("^zalogowanie uzytkownika na portalu na podajac email (.*) i haslo (.*)$")
    public void singIn(String email, String password) {
        LoginPage logIn = new LoginPage(driver);
        logIn.myStoreLogin(email, password);
    }

    @Then("^przejscie do zakładki Address i wypisanie danych (.*) \"(.*)\" (.*) (.*) (.*) \"(.*)\"$")
    public void addressData(String alias, String address, String code, String city, String phone, String country) {
        UserDataPages dataAddress = new UserDataPages(driver);
        dataAddress.address(alias, address, code, city, phone, country);


    }

    @And("^wyświetlenie i potwierdzenie zapisania danych (.*) \"(.*)\" (.*) (.*) (.*) \"(.*)\"$")
    public void resultsCheck(String alias, String address, String code, String city, String phone, String country) {
        UserDataPages result = new UserDataPages(driver);
        Assert.assertEquals("Address successfully added!", result.getAlertSuccess());
        Assert.assertEquals(result.getAlias(), alias);
        assertTrue(result.getAddress().matches("(.*)" + address + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)" + code + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)" + city + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)" + phone + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)"+ country +"(.*)"));

    }

    @When("usuniecie danych z konta uzytkownika")
    public void removeAddress() {
        UserDataPages remove = new UserDataPages(driver);
        remove.deleteAddress();
        Assert.assertEquals("Address successfully deleted!", remove.getAlertSuccess());
    }

    @Then("sprawdzenie czy dane zostaly usuniete danych")
    public void whatKey() {
        UserDataPages key = new UserDataPages(driver);

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=my-account");
      System.out.println(key.getNameBottomAddFirst());
        assertTrue(key.getNameBottomAddFirst().matches("ADD FIRST ADDRESS"));

    }

}
