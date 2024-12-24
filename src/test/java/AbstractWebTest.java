import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractWebTest {
    WebDriver driver;
    @Before
    public void prerequisites(){
        driver = new ChromeDriver();
    }
    @After
    public void after(){
        driver.quit();
    }
}
