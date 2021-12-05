package myStoreTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ClothesPage;
import pages.LoginPage;
import pages.SweaterPage;

import java.util.concurrent.TimeUnit;

public class ShoppingTest {
    private static WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl");

    }

    @Test
    public void sweaterBuy () {
        LoginPage logIn = new LoginPage(driver);
        logIn.myStoreLogin("wodowanie.jan123@wp.pl", "Haslo1234*");

        ClothesPage clothes = new ClothesPage(driver);
        clothes.clothesSelection();

        SweaterPage sweater = new SweaterPage(driver);
        sweater.order("5");


    }


    @After
    public void tearDown() {
      //   driver.quit();
    }



}