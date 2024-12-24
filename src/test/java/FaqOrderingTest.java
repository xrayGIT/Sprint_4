import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjmodel.MainPage;

@RunWith(Parameterized .class)
public class FaqOrderingTest extends AbstractWebTest {
    private final Integer index;
    private final String expectedAnswer;

    public FaqOrderingTest(Integer index, String expectedAnswer){
        this.index = index;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        //проверяем текст ответа на вопрос по индексу. Не стал делать поиск по тексту вопроса,
        //так как текст вопроса все равно может меняться и не факт что это будет проще с точки зрения дальнейшей поддержки.]
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void testFAQAnswerHaveRightText(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .agreeWithCookie()
                .clickAndCheckFAQAnswerWithIndex(index, expectedAnswer);
    }
}
