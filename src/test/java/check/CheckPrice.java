package check;

import org.openqa.selenium.WebDriver;
import pages.SweaterPage;

public class CheckPrice extends SweaterPage {
    protected static WebDriver driver;

    public CheckPrice(WebDriver driver) {
        super(driver);
    }

    public String discountPrice() {
        String tempPrice = price.getText();
        String price = tempPrice.substring(1);
        return price;
    }

    public String fullPrice() {
        String tempPrice = regularPrice.getText();
        String price = tempPrice.substring(1);
        return price;
    }

    public double stringToDouble(String string) {
        double price = Double.valueOf(string);
        return price;
    }

    public double percent20() {
        double percent = 0.2 * stringToDouble(fullPrice());
        return percent;
    }

    public double priceDiffrence() {
        double difference = stringToDouble(fullPrice()) - stringToDouble(discountPrice());
        return difference;
    }


    public String calculatedPrice() {
        double discount = stringToDouble(fullPrice()) * 0.8;
        String calculated = String.valueOf(discount);
        return calculated;
    }


}
