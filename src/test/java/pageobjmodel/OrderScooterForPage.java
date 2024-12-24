package pageobjmodel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderScooterForPage {
    private final WebDriver driver;
    OrderScooterForPage(WebDriver driver){
        this.driver = driver;
    }
    // Имя
    private static final By NAME_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and contains(@placeholder, 'Имя')]");
    // Фамилия
    private static final By SURNAME_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and contains(@placeholder, 'Фамилия')]");
    // Адрес
    private static final By ADDRESS_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and contains(@placeholder, 'Адрес')]");
    // Станция метро поле
    private static final By METRO_STATION_INPUT = By.xpath(".//input[@class='select-search__input']");
    // Телефон
    private static final By PHONE_NUMBER_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and contains(@placeholder, 'Телефон')]");
    // Кнопка далее
    private static final By NEXT_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Сообщение о некорректных данных в полях
    private static final By ANY_FIELD_VALUE_ERRORS_PRESENTED = By.xpath(".//input[contains(@class,'Input_Error')]");

    public OrderScooterForPage fillName(String name){
        driver.findElement(NAME_INPUT).sendKeys(name);
        return this;
    }

    public OrderScooterForPage fillSurname(String surname){
        driver.findElement(SURNAME_INPUT).sendKeys(surname);
        return this;
    }

    public OrderScooterForPage fillAddress(String address){
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
        return this;
    }

    public OrderScooterForPage fillMetroStation(String metroStationName){
        driver.findElement(METRO_STATION_INPUT).click();
        // не стал выводить xpath конкретных станций метро в поля POM, иначе получилось бы множество полей вместо одной локальной переменной
        String metroStationXpath = ".//div[text()='" + metroStationName + "']/parent::*/parent::*";
        driver.findElement(By.xpath(metroStationXpath)).click();
        return this;
    }

    public OrderScooterForPage fillPhone(String phone){
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(phone);
        return this;
    }

    public OrderAboutScooterRent clickNextButton(){
        boolean isErrorPresentedOnThePage = driver.findElements(ANY_FIELD_VALUE_ERRORS_PRESENTED).isEmpty();
        Assert.assertTrue("В форме заказа нет ошибок во введеных данных перед нажатием 'Далее'", isErrorPresentedOnThePage);
        driver.findElement(NEXT_BUTTON).click();
        return new OrderAboutScooterRent(driver);
    }
}
