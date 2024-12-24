package pageobjmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderAboutScooterRent {
    private final WebDriver driver;
    OrderAboutScooterRent(WebDriver driver){
        this.driver = driver;

    }

    // Когда привезти заказ
    private static final By WHEN_TO_DELIVER_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and contains(@placeholder, 'Когда привезти')]");
    // Дата сегодня в календаре
    private static final By TODAY_DATE_IN_CALENDAR = By.xpath(".//div[contains(@class,'react-datepicker__day--today')]");
    // Срок аренды
    private static final By RENT_DURATION_INPUT = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Кнопка Заказать
    private static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderAboutScooterRent selectDeliverDayToday(){
        driver.findElement(WHEN_TO_DELIVER_INPUT).click();
        driver.findElement(TODAY_DATE_IN_CALENDAR).click();
        return this;
    }

    public OrderAboutScooterRent setRentDuration(String duration){
        driver.findElement(RENT_DURATION_INPUT).click();
        String durationXPATH = ".//div[@class='Dropdown-option' and text()='" + duration + "']";
        driver.findElement(By.xpath(durationXPATH)).click();
        return this;
    }

    // так как в форме чек бокс, а не селектор, то название метода не совсем в подходит, так как можно и unselect сделать кликом
    // но по опыту это выглядит как баг и там должен быть селектор вместо чекбоксов, поэтому оставил это название
    // также понимаю что можно было сделать через поиск цвета по id - это с одной стороны надежнее. Но с другой стороны при любом изменении названия цвета в форме, мы просто копируем этот текст и подставляем в кейс
    // если команда разработки хорошо взаимодействует с QA и стандартные элементы типа списка чекбоксов реализованны однообразно на всех страницах это позволило бы сделать дополнительную библиотеку стандартных элементов и все их искать по тексту. Это упрощает написание новых кейсов.
    // повторюсь, вышеописаное актуально только если продукт стабильный, имеет хорошую культуру документирования и стандартизации. Иначе можно и на id сделать
    public OrderAboutScooterRent selectScooterColor(String colorToSelect){
        String colorToSelectXPATH = ".//label[@class='Checkbox_Label__3wxSf' and contains(text(), '" + colorToSelect + "')]/input";
        driver.findElement(By.xpath(colorToSelectXPATH)).click();
        return this;
    }

    public OrderDoYouWantSubmit clickNextButton(){
        driver.findElement(ORDER_BUTTON).click();
        return new OrderDoYouWantSubmit(driver);
    }
}
