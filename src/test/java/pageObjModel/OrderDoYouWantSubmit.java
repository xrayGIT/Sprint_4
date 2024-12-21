package pageObjModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderDoYouWantSubmit {
    private final WebDriver driver;
    OrderDoYouWantSubmit(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private static final By YES_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderSubmitedPopup clickYesButton(){
        driver.findElement(YES_BUTTON).click();
        return new OrderSubmitedPopup(driver);
    }
}
