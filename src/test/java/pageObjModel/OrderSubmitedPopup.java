package pageObjModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderSubmitedPopup {
    private final WebDriver driver;
    OrderSubmitedPopup(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public static final By MAIN_POPUP_TEXT = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

}
