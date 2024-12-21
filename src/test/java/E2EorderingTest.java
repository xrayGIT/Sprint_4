import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjModel.MainPage;
import pageObjModel.OrderAboutScooterRent;
import pageObjModel.OrderScooterForPage;

import static pageObjModel.MainPage.BOTTOM_BUTTON;
import static pageObjModel.MainPage.TOP_BUTTON;

@RunWith(Parameterized.class)
public class E2EorderingTest {
    WebDriver driver;
    public E2EorderingTest(String orderButtonPlace){
        this.orderButtonPlace = orderButtonPlace;
    }
    private final String orderButtonPlace;


    @Parameterized.Parameters
    public static Object[][] getParams() {
        //
        return new Object[][] {
                {TOP_BUTTON},
                {BOTTOM_BUTTON}
        };
    }

    @Before
    public void prerequisites(){
        driver = new ChromeDriver();
    }
    @Test
    public void testSubmitOrderE2E(){
        MainPage mainPage = new MainPage(driver);
        OrderScooterForPage orderPopup = mainPage.openMainPage()
                .agreeWithCookie()
                .clickOrderButton(orderButtonPlace);
        OrderAboutScooterRent orderPopUpAboutScooter = orderPopup.fillName("Иван")
                .fillSurname("Иванов")
                .fillAddress("г.Москва, улица Большая Полянка, 26с2")
                .fillMetroStation("Полянка")
                .fillPhone("+79992223311")
                .clickNextButton();
        orderPopUpAboutScooter.selectDeliverDayToday()
                .setRentDuration("сутки")
                .selectScooterColor("чёрный жемчуг")
                .clickNextButton()
                .clickYesButton();
    }

    @After
    public void after(){
        driver.quit();
    }




}
