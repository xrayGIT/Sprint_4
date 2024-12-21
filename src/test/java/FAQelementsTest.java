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
        //проверяем текст ответа на вопрос по индексу. Не стал делать поиск по тексту вопроса,
        //так как текст вопроса все равно может меняться и не факт что это будет проще с точки зрения дальнейшей поддержки.]
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
