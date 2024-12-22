package pageObjModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderSubmitedPopup {
    private final WebDriver driver;
    OrderSubmitedPopup(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    private static final By MAIN_POPUP_TEXT = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public void checkTextInSubmitedPopup() {
        try {
            Thread.sleep(2000); // так как не нашел способа дожидаться когда в тексте заказа появятся цифры, сделал через обычный sleep.
                                        // 2 секунды не должны быть критичными в рамках всего кейса
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String fullSubmittedPopupText = driver.findElement(MAIN_POPUP_TEXT).getText();
        String[] textByRows = fullSubmittedPopupText.split("\\r?\\n");
        boolean isOrderNumberPresented = fullSubmittedPopupText.matches("(.|\n|\r)*[0-9]+(.|\n|\r)*");
        Assert.assertEquals("Текст подтверждения заказа верный", "Заказ оформлен", textByRows[0]);
        Assert.assertTrue("Номер заказа назначен", isOrderNumberPresented);
    }
}
