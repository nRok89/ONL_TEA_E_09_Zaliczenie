package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CheckOrderPage {

    private static WebDriver driver;
    // ArrayList<String> orderList = new ArrayList<>();
    String[] orderTab = new String[2];


    public CheckOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a.btn")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#delivery_option_1")
    private WebElement shippingMethodInput;
    @FindBy(css = "#payment-option-1")
    private WebElement paymentInput;

    @FindBy(css = "button.continue:nth-child(1)")
    private WebElement countinueAddressButton;
    @FindBy(css = "button.continue:nth-child(2)")
    private WebElement countinueShippingButton;
    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement agreeCheckbox;
    @FindBy(css = "div.ps-shown-by-js >button")
    private WebElement orderAndGoToPayButton;
    @FindBy(css = "#order-details > ul:nth-child(2) > li:nth-child(1)")
    private WebElement orderReference;
    @FindBy(xpath = "//*[text()=\"Total\"]/../../td[2]")
    private WebElement totalPrice;


    public void endTheOder() {
        proceedToCheckoutButton.click();
        countinueAddressButton.click();
        if (shippingMethodInput.isSelected() == false) {
            shippingMethodInput.click();
        }
        countinueShippingButton.click();
        if (paymentInput.isSelected() == false) {
            paymentInput.click();
        }

        if (agreeCheckbox.isSelected() == false) {
            agreeCheckbox.click();
        }
        orderAndGoToPayButton.click();

    }

    public String getOrderReference() {
        String tempOrderRef = orderReference.getText();
        String orderRef = tempOrderRef.substring(17);
        orderTab[0] = orderRef;
        return orderTab[0];
    }

    public String getTotalPrice() {
     String price = totalPrice.getText();
        orderTab[1] = price;
        return orderTab[1];

    }

    public String orderReference() {
        String order = orderTab[0] ;
        return order;
    }

    public String totalPrice() {
        String price = orderTab[1];
        return price;
    }

        public void screen (String fileAdress) throws IOException {
            String orderIndex = getOrderReference();
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "jpg", new File(fileAdress + "Order reference-" + orderIndex + ".jpg"));
        }


    }
