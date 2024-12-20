import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjModel.MainPage;

@RunWith(Parameterized .class)
public class FAQelementsTest {
    WebDriver driver;
    private final Integer index;
    private final String expectedAnswer;

    public FAQelementsTest(Integer index, String expectedAnswer){
        this.index = index;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."}
        };
    }

    @Before
    public void prerequisites(){
        driver = new ChromeDriver();
    }

    @Test
    public void testFAQAnswerHaveRightText(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .agreeWithCookie()
                .clickAndCheckFAQAnswerWithIndex(index, expectedAnswer);
    }

    @After
    public void after(){
        driver.quit();
    }
}
