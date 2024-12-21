package pageObjModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public static final int TIME_OUT_IN_SECONDS = 3;
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;
    // Верхняя кнопка заказать ".//button[@class='Button_Button__ra12g']"
    private static final By TOP_ORDER_BUTTON = By.className("Button_Button__ra12g");
    // Нижняя кнопка заказать ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"
    private static final By BOTTOM_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Элементы FAQ аккардиона ".//div[@class='accordion__item']" зачем если нет цели искать элемент по вопросу??
    // Вопрос в элементе аккардиона ".//div[@class='accordion__button']"
    private static final By QUESTION_ELEMENTS = By.className("accordion__button");
    // Ответ в элементе аккардиона ".//div[@class='accordion__panel']/p"
    private static final By OPENED_ANSWER = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]/p");
    // Кнопка согласия на куки id="rcc-confirm-button"
    private static final By AGREE_WITH_COOKIE_BUTTON = By.id("rcc-confirm-button");

    public static final String TOP_BUTTON = "top_button";
    public static final String BOTTOM_BUTTON = "bottom_button";

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage openMainPage(){
        driver.get(PAGE_URL);
        return this;
    }

    public MainPage agreeWithCookie(){
        WebElement element = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(AGREE_WITH_COOKIE_BUTTON));
        element.click();
        return this;
    }

    public OrderScooterForPage clickOrderButton(String orderButtonPlace){
        By button;
        if(orderButtonPlace.equals(TOP_BUTTON)){
            button = TOP_ORDER_BUTTON;
        } else if(orderButtonPlace.equals(BOTTOM_BUTTON)){
            button = BOTTOM_ORDER_BUTTON;
        }
        WebElement element = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(TOP_ORDER_BUTTON));
        element.click();
        return new OrderScooterForPage(driver);
    }

    public void clickBottomOrderButton(){
        driver.findElement(BOTTOM_ORDER_BUTTON);
    }

    public void clickAndCheckFAQAnswerWithIndex(Integer index, String expectedAnswer){
        driver.findElements(QUESTION_ELEMENTS).get(index).click();
        String answer = driver.findElement(OPENED_ANSWER).getText();
        Assert.assertEquals("Ответ на вопрос №" + index + " ожидаемый", expectedAnswer, answer);
    }

}
