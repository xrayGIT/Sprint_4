import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjmodel.MainPage;
import pageobjmodel.OrderAboutScooterRent;
import pageobjmodel.OrderScooterForPage;

import static pageobjmodel.MainPage.BOTTOM_BUTTON;
import static pageobjmodel.MainPage.TOP_BUTTON;

@RunWith(Parameterized.class)
public class E2eOrderingTest extends AbstractWebTest {
    public E2eOrderingTest(String orderButtonPlace, String address, String metroStation, String rentDuration, String scooterColor){
        this.orderButtonPlace = orderButtonPlace;
        this.address = address;
        this.metroStation = metroStation;
        this.rentDuration = rentDuration;
        this.scooterColor = scooterColor;
    }
    private final String orderButtonPlace;
    private final String address;
    private final String metroStation;
    private final String rentDuration;
    private final String scooterColor;

    @Parameterized.Parameters
    public static Object[][] getParams() {
        //
        return new Object[][] {
                {TOP_BUTTON, "г.Москва, улица Большая Полянка, 26с2", "Полянка", "сутки", "чёрный жемчуг"},
                {BOTTOM_BUTTON, "г.Москва, Русаковская улица, 28с1Б", "Сокольники", "трое суток", "серая безысходность"}
        };
    }

    @Test
    public void testSubmitOrderE2E(){
        MainPage mainPage = new MainPage(driver);
        OrderScooterForPage orderPopup = mainPage.openMainPage()
                .agreeWithCookie()
                .clickOrderButton(orderButtonPlace);
        // выделяю новые переменные для новых окон чтобы проще было читать, будет понятно что здесь тест работает уже с новым popup
        // но можно сделать и сплошным flow api
        OrderAboutScooterRent orderPopUpAboutScooter = orderPopup.fillName("Иван")
                .fillSurname("Иванов")
                .fillAddress(address)
                .fillMetroStation(metroStation)
                .fillPhone("+79998887777")
                .clickNextButton();
        orderPopUpAboutScooter.selectDeliverDayToday()
                .setRentDuration(rentDuration)
                .selectScooterColor(scooterColor)
                .clickNextButton()
                .clickYesButton()
                .checkTextInSubmitedPopup();
    }

}
