package myStoreTest;

import check.CheckPrice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ShoppingTest {
    private static WebDriver driver;
    String email = "wodowanie.jan123@wp.pl" ;
    String password = "Haslo1234*" ;
    // dostępne rozmiary S, M, L, XL.
    String sweaterSize = "M";
    int numbersOfsweaters = 5;
    //domyslenie folder ""target"
    String screenAddress = "";


    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl");

    }

    @Test
    public void sweaterBuy() throws IOException {
        LoginPage logIn = new LoginPage(driver);
        logIn.myStoreLogin(email, password);

        ClothesPage clothes = new ClothesPage(driver);
        clothes.clothesSelection();

        CheckPrice price = new CheckPrice(driver);
        Assert.assertTrue(price.percent20() == price.priceDiffrence());
        Assert.assertEquals(price.calculatedPrice(), price.discountPrice());

        SweaterPage sweater = new SweaterPage(driver);
        Assert.assertTrue(sweater.sizeCorrect(sweaterSize));
        Assert.assertTrue(sweater.numberCorrect(numbersOfsweaters));
        sweater.order(sweaterSize, numbersOfsweaters);

        CheckOrderPage order = new CheckOrderPage(driver);
        order.endTheOder();
        order.getOrderReference();
        order.getTotalPrice();
        order.screen(screenAddress);

        OrderHistoryPage historyOrder = new OrderHistoryPage(driver);
        historyOrder.orderHistory();

        Assert.assertEquals(historyOrder.getOrderHistorylast(), order.orderReference());
        Assert.assertEquals(historyOrder.getPriceHistryLast(), order.totalPrice());
        Assert.assertEquals("Awaiting check payment", historyOrder.getAwaitingCheckInf());
    }


    @After
    public void tearDown() {
         driver.quit();
    }


}