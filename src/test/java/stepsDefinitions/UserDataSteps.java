package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import check.CheckDate;
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
    public void addressData(String alias, String address, String city, String code, String phone, String country) {
        UserDataPages dataAddress = new UserDataPages(driver);
        dataAddress.address(alias, address, city, code, phone, country);

    }

    @And("^wyświetlenie i potwierdzenie zapisania danych (.*) \"(.*)\" (.*) (.*) (.*) \"(.*)\"$")
    public void resultsCheck(String alias, String address, String city, String code, String phone, String country) {
        UserDataPages result = new UserDataPages(driver);
        Assert.assertEquals("Address successfully added!", result.getAlertSuccess());
        // sprawdza czy dana wyświetlone zgadzaja sie z tym z parametrów
        Assert.assertEquals(result.getAlias(), alias);
        assertTrue(result.getAddress().matches("(.*)" + address + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)" + code + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)" + city + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)" + phone + "(.*)"));
        assertTrue(result.getAddress().matches("(.*)"+ country +"(.*)"));
        // sprawdza czy dane sa na odpowiednich miejscach w formularzu
        CheckDate check = new CheckDate(driver);
        check.startCheck();
        Assert.assertEquals(alias,check.getAlias());
        Assert.assertEquals(address,check.getAddress());
        Assert.assertEquals(city,check.getCity());
        Assert.assertEquals(code, check.getPostCode());
        Assert.assertEquals(phone, check.getPhone());
        Assert.assertEquals(country, check.getCountry());
        check.endCheck();

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
