package pageObjModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class OrderDoYouWantSubmit {
    private final WebDriver driver;
    OrderDoYouWantSubmit(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private static final By YES_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public OrderSubmitedPopup clickYesButton(){
        WebElement element = driver.findElement(YES_BUTTON);
        //((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        element.click();
        return new OrderSubmitedPopup(driver);
    }
}
